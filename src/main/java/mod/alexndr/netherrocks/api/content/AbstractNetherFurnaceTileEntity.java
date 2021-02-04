package mod.alexndr.netherrocks.api.content;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.Random;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import mod.alexndr.netherrocks.content.NetherFurnaceTileEntity;
import mod.alexndr.netherrocks.init.ModBlocks;
import mod.alexndr.netherrocks.init.ModItems;
import mod.alexndr.netherrocks.init.ModTags;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.item.ExperienceOrbEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.AbstractCookingRecipe;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.IRecipeType;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.tags.ITag;
import net.minecraft.tileentity.AbstractFurnaceTileEntity;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.Direction;
import net.minecraft.util.IItemProvider;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.text.ITextComponent;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.fml.network.NetworkHooks;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandlerModifiable;
import net.minecraftforge.items.ItemStackHandler;
import net.minecraftforge.items.wrapper.RangedWrapper;

public abstract class AbstractNetherFurnaceTileEntity extends TileEntity  implements ITickableTileEntity, INamedContainerProvider
{

    public static final int FUEL_SLOT = 0;
    public static final int INPUT_SLOT = 1;
    public static final int OUTPUT_SLOT = 2;
    
    private static final String INVENTORY_TAG = "inventory";
    private static final String SMELT_TIME_LEFT_TAG = "smeltTimeLeft";
    private static final String MAX_SMELT_TIME_TAG = "maxSmeltTime";
    private static final String FUEL_BURN_TIME_LEFT_TAG = "fuelBurnTimeLeft";
    private static final String MAX_FUEL_BURN_TIME_TAG = "maxFuelBurnTime";
    
    protected final IRecipeType<? extends AbstractCookingRecipe> recipeType;
    private final Map<ResourceLocation, Integer> recipe2xp_map = Maps.newHashMap();

    // implement recipe-caching like all the cool kids.
    protected AbstractCookingRecipe cachedRecipe;
    protected ItemStack failedMatch = ItemStack.EMPTY;
    
    protected double fuelMultiplier = 1.0;
    protected int YieldChance = 0;
    protected int YieldAmount = 0;
    protected Random generator = new Random();

    public short smeltTimeLeft = -1;
    public short maxSmeltTime = -1;
    public short fuelBurnTimeLeft = -1;
    public short maxFuelBurnTime = -1;
    private boolean lastBurning = false;
    
    public final ItemStackHandler inventory = new ItemStackHandler(3) 
    {
    		@Override
    		public boolean isItemValid(final int slot, @Nonnull final ItemStack stack) 
    		{
    			switch (slot) {
    				case FUEL_SLOT:
    					return AbstractNetherFurnaceTileEntity.isFuel(stack);
    				case INPUT_SLOT:
    					return isInput(stack);
    				case OUTPUT_SLOT:
    					return isOutput(stack);
    				default:
    					return false;
    			}
    		} // end ItemStackHander(3).isItemValid()
    
    		@Override
    		protected void onContentsChanged(final int slot) {
    			super.onContentsChanged(slot);
    			// Mark the tile entity as having changed whenever its inventory changes.
    			// "markDirty" tells vanilla that the chunk containing the tile entity has
    			// changed and means the game will save the chunk to disk later.
    			AbstractNetherFurnaceTileEntity.this.markDirty();
    		} // end ()
    }; // end ItemStackHandler(3)
    
    private final LazyOptional<ItemStackHandler> inventoryCapabilityExternal = LazyOptional.of(() -> this.inventory);
    private final LazyOptional<IItemHandlerModifiable> inventoryCapabilityExternalUp = LazyOptional.of(() -> new RangedWrapper(this.inventory, INPUT_SLOT, INPUT_SLOT + 1));
    private final LazyOptional<IItemHandlerModifiable> inventoryCapabilityExternalDown = LazyOptional.of(() -> new RangedWrapper(this.inventory, OUTPUT_SLOT, OUTPUT_SLOT + 1));
    private final LazyOptional<IItemHandlerModifiable> inventoryCapabilityExternalSides = LazyOptional.of(() -> new RangedWrapper(this.inventory, FUEL_SLOT, INPUT_SLOT + 1));

    public AbstractNetherFurnaceTileEntity(TileEntityType<?> tileEntityTypeIn, IRecipeType<? extends AbstractCookingRecipe> recipeTypeIn)
    {
        super(tileEntityTypeIn);
        this.recipeType = recipeTypeIn;
    }

    /**
     * @return If the stack is not empty and has a smelting recipe associated with it
     */
    private boolean isInput(final ItemStack stack)
    {
    	if (stack.isEmpty())
    		return false;
    	return getRecipe(stack).isPresent();
    }

    /**
     * @return If the stack's item is equal to the result of smelting our input
     */
    private boolean isOutput(final ItemStack stack)
    {
    	final Optional<ItemStack> result = getResult(inventory.getStackInSlot(INPUT_SLOT));
    	return result.isPresent() && ItemStack.areItemsEqual(result.get(), stack);
    }

    /**
     * @return The smelting recipe for the input stack
     */
    private Optional<AbstractCookingRecipe> getRecipe(final ItemStack input)
    {
        if (input.isEmpty() || input == failedMatch) {
            return Optional.empty();
        }
    	// Due to vanilla's code we need to pass an IInventory into RecipeManager#getRecipe so we make one here.
    	return getRecipe(new Inventory(input));
    }

    /**
     * @return The smelting recipe for the inventory; implements recipe caching.
     */
    @SuppressWarnings("unchecked")
    private Optional<AbstractCookingRecipe> getRecipe(final IInventory inventory)
    {
        if (cachedRecipe != null && cachedRecipe.matches(inventory, world))
        {
            return Optional.of(cachedRecipe);
        }
        else
        {
            AbstractCookingRecipe rec 
                = world.getRecipeManager().getRecipe((IRecipeType<AbstractCookingRecipe>) recipeType, inventory, world).orElse(null);
            if (rec == null) {
                failedMatch = inventory.getStackInSlot(0); // i.e., input.
            }
            else {
                failedMatch = ItemStack.EMPTY;
            }
            cachedRecipe = rec;
            return Optional.ofNullable(rec);
        } // end else
    } // end getRecipe()

    
    protected Optional<ItemStack> getResult(final ItemStack input)
    {
        // Due to vanilla's code we need to pass an IInventory into RecipeManager#getRecipe and
        // AbstractCookingRecipe#getCraftingResult() so we make one here.
        final Inventory dummyInventory = new Inventory(input);
        Optional<ItemStack> maybe_result = 
                getRecipe(dummyInventory).map(recipe -> recipe.getCraftingResult(dummyInventory));
        
        // enhanced yield processing.
        if (YieldChance <= 0 || YieldAmount <= 0)
        {
            return maybe_result;
        }
        ItemStack result =  maybe_result.orElse(ItemStack.EMPTY);
        int r = generator.nextInt(100);
        if(r <= YieldChance && ! result.isEmpty()) 
        {
            int k = YieldAmount;
            if ((k + result.getCount()) < result.getMaxStackSize())
            result.grow(k);
        }
        return Optional.of(result);
    }

    public static boolean isFuel(ItemStack stack)
    {
        return getValidFuels().contains(stack.getItem());
    }

    protected static final int netherrackBurnTime = 200;
    protected static final int fyriteBurnTime = 8000;
    protected static final int blazeRodBurnTime = 2400;
    protected static final List<Item> validFuels = new ArrayList<Item>();
    protected static Map<Item, Integer> burnTimes = new Hashtable<Item, Integer>();

    /**
     * Get the list of valid fuels, or create it if it is empty.
     * @return a list of valid fuel items
     */
    public static List<Item> getValidFuels()
    {
        if (validFuels.isEmpty())
        {
            validFuels.add(Blocks.NETHERRACK.asItem());
            validFuels.add(ModBlocks.fyrite_block.get().asItem());
            validFuels.add(ModItems.fyrite_ingot.get());
            validFuels.add(ModItems.fyrite_nugget.get());
            validFuels.add(Items.BLAZE_ROD);
            validFuels.add(Items.BLAZE_POWDER);
            for (Item item : ModTags.getnetherFurnaceFuels().getAllElements())
            {
                validFuels.add(item);
            }
        }
        return validFuels;
    } // end getValidFuels()

    public static Map<Item, Integer> getBurnTimes()
    {
        Map<Item, Integer> map = Maps.newLinkedHashMap();
        addItemBurnTime(map, Blocks.NETHERRACK, netherrackBurnTime);
        addItemBurnTime(map, ModBlocks.fyrite_block.get(), fyriteBurnTime * 10);
        addItemBurnTime(map, ModItems.fyrite_ingot.get(), fyriteBurnTime);
        addItemBurnTime(map, ModItems.fyrite_nugget.get(), fyriteBurnTime/9);
        addItemBurnTime(map, ModItems.fyrite_dust.get(), fyriteBurnTime/2);
        addItemBurnTime(map, Items.BLAZE_ROD, blazeRodBurnTime);
        addItemBurnTime(map, Items.BLAZE_POWDER, blazeRodBurnTime/3);
        addItemTagBurnTime(map, ModTags.getnetherFurnaceFuels(), fyriteBurnTime / 3);
        return map;
    } // end getBurnTimes()

    protected static void addItemBurnTime(Map<Item, Integer> map,
                                   IItemProvider itemProvider, int burnTimeIn)
    {
        map.put(itemProvider.asItem(), burnTimeIn);
    }

    protected static void addItemTagBurnTime(Map<Item, Integer> map, ITag<Item> iTag, int burnTimeIn)
    {
        for(Item item : iTag.getAllElements()) {
            map.put(item, burnTimeIn);
        }
    } // end ()


    /**
     * Called every tick to update our tile entity
     */
    @Override
    public void tick()
    {
        // Fuel burning code
        boolean hasFuel = false;
        if (isBurning()) {
            hasFuel = true;
            --fuelBurnTimeLeft;
        }
        
    	if (world == null || world.isRemote)
    		return;
    
    	// Smelting code
    	final ItemStack input = inventory.getStackInSlot(INPUT_SLOT).copy();
    	final ItemStack result = getResult(input).orElse(ItemStack.EMPTY);
    
        if (!result.isEmpty() && isInput(input))
        {
            final boolean canInsertResultIntoOutput 
                = inventory.insertItem(OUTPUT_SLOT, result, true).isEmpty();
            if (canInsertResultIntoOutput)
            {
                if (!hasFuel) { 
                    if (burnFuel()) hasFuel = true; 
                 }
                if (hasFuel)
                {
                    if (smeltTimeLeft == -1)
                    { // Item has not been smelted before
                        smeltTimeLeft = maxSmeltTime = getSmeltTime(input);
                    }
                    else
                    { // Item was already being smelted
                        --smeltTimeLeft;
                        if (smeltTimeLeft == 0)
                        {
                            inventory.insertItem(OUTPUT_SLOT, result, false);
                            
                            this.setRecipeUsed(getRecipe(input).get()); // move to BEFORE we shrink stack!
                            
                            if (input.hasContainerItem()) {
                                inventory.setStackInSlot(INPUT_SLOT, input.getContainerItem());
                            }
                            else
                            {
                                input.shrink(1);
                                inventory.setStackInSlot(INPUT_SLOT, input); // Update the data
                            }
                            
                            smeltTimeLeft = -1; // Set to -1 so we smelt the next stack on the next tick
                        } // end-if
                    } // end-else
                }
                else // No fuel -> add to smelt time left to simulate cooling
                {
                    if (smeltTimeLeft < maxSmeltTime) ++smeltTimeLeft;
                }
            }
        } // end-if
    	else // We have an invalid input stack (somehow)
    	{
    		smeltTimeLeft = maxSmeltTime = -1;
    	}
    	
    	// Syncing code
    	// If the burning state has changed.
    	if (lastBurning != hasFuel) { // We use hasFuel because the current fuel may be all burnt out but we have more that will be used next tick
    
    		// "markDirty" tells vanilla that the chunk containing the tile entity has
    		// changed and means the game will save the chunk to disk later.
    		this.markDirty();
    
    		final BlockState newState = this.getBlockState()
    				.with(AbstractNetherFurnaceBlock.BURNING, hasFuel);
    
    		// Flag 2: Send the change to clients
    		world.setBlockState(pos, newState, 2);
    
    		// Update the last synced burning state to the current burning state
    		lastBurning = hasFuel;
    	} // end-if
    } // end tick()

    /**
     * Mimics the code in {@link AbstractFurnaceTileEntity#func_214005_h()}
     *
     * @return The custom smelt time or 200 if there is no recipe for the input
     */
    protected short getSmeltTime(final ItemStack input)
    {
    	return getRecipe(input)
    			.map(AbstractCookingRecipe::getCookTime)
    			.orElse(200)
    			.shortValue();
    }

    public void setRecipeUsed(@Nullable IRecipe<?> recipe)
    {
        if (recipe != null)
        {
            this.recipe2xp_map.compute(recipe.getId(), (p_214004_0_, p_214004_1_) -> {
                return 1 + (p_214004_1_ == null ? 0 : p_214004_1_);
            });
        }
    } // end setRecipeUsed()
    
    /**
     * @return If the fuel was burnt
     */
    protected boolean burnFuel() 
    {
        final ItemStack fuelStack = inventory.getStackInSlot(FUEL_SLOT).copy();
        if (!fuelStack.isEmpty()) 
        {
            if (NetherFurnaceTileEntity.burnTimes.isEmpty()) {
                NetherFurnaceTileEntity.burnTimes = NetherFurnaceTileEntity.getBurnTimes();
            }
            final int burnTime = 
                    (int) Math.ceil(NetherFurnaceTileEntity.burnTimes.get(fuelStack.getItem()) * fuelMultiplier);
            if (burnTime > 0) {
                fuelBurnTimeLeft = maxFuelBurnTime = ((short) burnTime);
                if (fuelStack.hasContainerItem())
                    inventory.setStackInSlot(FUEL_SLOT, fuelStack.getContainerItem());
                else {
                    fuelStack.shrink(1);
                    inventory.setStackInSlot(FUEL_SLOT, fuelStack); // Update the data
                }
                return true;
            }
        } // end-if
        fuelBurnTimeLeft = maxFuelBurnTime = -1;
        return false;
    } // end burnFuel()
    

    public boolean isBurning()
    {
    	return this.fuelBurnTimeLeft > 0;
    }

    /**
     * Retrieves the Optional handler for the capability requested on the specific side.
     *
     * @param cap  The capability to check
     * @param side The Direction to check from. CAN BE NULL! Null is defined to represent 'internal' or 'self'
     * @return The requested an optional holding the requested capability.
     */
    @Nonnull
    @Override
    public <T> LazyOptional<T> getCapability(@Nonnull final Capability<T> cap, @Nullable final Direction side)
    {
    	if (cap == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY) {
    		if (side == null)
    			return inventoryCapabilityExternal.cast();
    		switch (side) {
    			case DOWN:
    				return inventoryCapabilityExternalDown.cast();
    			case UP:
    				return inventoryCapabilityExternalUp.cast();
    			case NORTH:
    			case SOUTH:
    			case WEST:
    			case EAST:
    				return inventoryCapabilityExternalSides.cast();
    		}
    	}
    	return super.getCapability(cap, side);
    }

    /**
     * Read saved data from disk into the tile.
     */
    @Override
    public void read(BlockState stateIn, final CompoundNBT compound)
    {
    	super.read(stateIn, compound);
    	this.inventory.deserializeNBT(compound.getCompound(INVENTORY_TAG));
    	this.smeltTimeLeft = compound.getShort(SMELT_TIME_LEFT_TAG);
    	this.maxSmeltTime = compound.getShort(MAX_SMELT_TIME_TAG);
    	this.fuelBurnTimeLeft = compound.getShort(FUEL_BURN_TIME_LEFT_TAG);
    	this.maxFuelBurnTime = compound.getShort(MAX_FUEL_BURN_TIME_TAG);
    	
        // We set this in read() instead of the constructor so that TileEntities
        // constructed from NBT (saved tile entities) have this set to the proper value
        if (this.hasWorld() && !this.world.isRemote) {
            lastBurning = this.isBurning();
        }
        
    	// get recipe2xp map
        int ii = compound.getShort("RecipesUsedSize");
        for(int jj = 0; jj < ii; ++jj) {
           ResourceLocation resourcelocation 
               = new ResourceLocation(compound.getString("RecipeLocation" + jj));
           int kk = compound.getInt("RecipeAmount" + jj);
           this.recipe2xp_map.put(resourcelocation, kk);
        }
        // blockstate?
        if (this.hasWorld()) {
            this.world.setBlockState(getPos(), this.getBlockState()
                    .with(AbstractNetherFurnaceBlock.BURNING, Boolean.valueOf(this.isBurning())));
        }
        
    } // end read()

    /**
     * Write data from the tile into a compound tag for saving to disk.
     */
    @Nonnull
    @Override
    public CompoundNBT write(final CompoundNBT compound)
    {
    	super.write(compound);
    	compound.put(INVENTORY_TAG, this.inventory.serializeNBT());
    	compound.putShort(SMELT_TIME_LEFT_TAG, this.smeltTimeLeft);
    	compound.putShort(MAX_SMELT_TIME_TAG, this.maxSmeltTime);
    	compound.putShort(FUEL_BURN_TIME_LEFT_TAG, this.fuelBurnTimeLeft);
    	compound.putShort(MAX_FUEL_BURN_TIME_TAG, this.maxFuelBurnTime);
    	
    	// write recipe2xp map
        compound.putShort("RecipesUsedSize", (short)this.recipe2xp_map.size());
        int ii = 0;
        for(Entry<ResourceLocation, Integer> entry : this.recipe2xp_map.entrySet()) 
        {
           compound.putString("RecipeLocation" + ii, entry.getKey().toString());
           compound.putInt("RecipeAmount" + ii, entry.getValue());
           ++ii;
        }
    	return compound;
    }

    /**
     * Get an NBT compound to sync to the client with SPacketChunkData, used for initial loading of the
     * chunk or when many blocks change at once.
     * This compound comes back to you client-side in {@link #handleUpdateTag}
     * The default implementation ({@link TileEntity#handleUpdateTag}) calls {@link #writeInternal)}
     * which doesn't save any of our extra data so we override it to call {@link #write} instead
     */
    @Nonnull
    public CompoundNBT getUpdateTag()
    {
    	return this.write(new CompoundNBT());
    }

    /**
     * Invalidates our tile entity
     */
    @Override
    public void remove()
    {
    	super.remove();
    	// We need to invalidate our capability references so that any cached references (by other mods) don't
    	// continue to reference our capabilities and try to use them and/or prevent them from being garbage collected
    	inventoryCapabilityExternal.invalidate();
    }

    @Nonnull
    @Override
    public abstract ITextComponent getDisplayName();

    /**
     * Called from {@link NetworkHooks#openGui}
     * (which is called from {@link ElectricFurnaceBlock#onBlockActivated} on the logical server)
     *
     * @return The logical-server-side Container for this TileEntity
     */
    @Nonnull
    @Override
    public abstract Container createMenu(final int windowId, final PlayerInventory inventory, final PlayerEntity player);

    public void grantExperience(PlayerEntity player)
    {
        List<IRecipe<?>> list = Lists.newArrayList();

        for (Entry<ResourceLocation, Integer> entry : this.recipe2xp_map.entrySet())
        {
            player.world.getRecipeManager().getRecipe(entry.getKey()).ifPresent((p_213993_3_) -> {
                list.add(p_213993_3_);
                spawnExpOrbs(player, entry.getValue(), ((AbstractCookingRecipe) p_213993_3_).getExperience());
            });
        }
        player.unlockRecipes(list);
        this.recipe2xp_map.clear();
    }
    
    private static void spawnExpOrbs(PlayerEntity player, int pCount, float experience)
    {
        if (experience == 0.0F) {
            pCount = 0;
        }
        else if (experience < 1.0F)
        {
            int i = MathHelper.floor((float) pCount * experience);
            if (i < MathHelper.ceil((float) pCount * experience)
                    && Math.random() < (double) ((float) pCount * experience - (float) i))
            {
                ++i;
            }
            pCount = i;
        }

        while (pCount > 0)
        {
            int j = ExperienceOrbEntity.getXPSplit(pCount);
            pCount -= j;
            player.world.addEntity(new ExperienceOrbEntity(player.world, player.getPosX(), player.getPosY() + 0.5D,
                    player.getPosZ() + 0.5D, j));
        }
    } // end spawnExpOrbs()

} // end class
