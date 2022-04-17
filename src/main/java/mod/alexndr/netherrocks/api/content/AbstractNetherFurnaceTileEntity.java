package mod.alexndr.netherrocks.api.content;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import javax.annotation.Nullable;

import com.google.common.collect.Maps;

import mod.alexndr.netherrocks.init.ModBlocks;
import mod.alexndr.netherrocks.init.ModItems;
import mod.alexndr.netherrocks.init.ModTags;
import mod.alexndr.simplecorelib.content.VeryAbstractFurnaceTileEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.tags.Tag;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.registries.tags.ITag;

public abstract class AbstractNetherFurnaceTileEntity extends VeryAbstractFurnaceTileEntity
{
    
    public AbstractNetherFurnaceTileEntity(BlockEntityType<?> tileEntityTypeIn, BlockPos blockpos, BlockState blockstate,
    		RecipeType<? extends AbstractCookingRecipe> recipeTypeIn)
    {
        super(tileEntityTypeIn, blockpos, blockstate, recipeTypeIn);
    }

    @Override
    public boolean isFuel(ItemStack stack)
    {
        return getValidFuels().contains(stack.getItem()) || stack.is(Items.BUCKET);
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
            validFuels.add(ModBlocks.raw_fyrite_block.get().asItem());
            validFuels.add(ModItems.fyrite_ingot.get());
            validFuels.add(ModItems.raw_fyrite.get());
            validFuels.add(ModItems.fyrite_nugget.get());
            validFuels.add(ModItems.fyrite_dust.get());
            validFuels.add(ModBlocks.fyrite_bricks.get().asItem());
            validFuels.add(ModBlocks.fyrite_brick_stairs.get().asItem());
            validFuels.add(ModBlocks.fyrite_brick_slab.get().asItem());
            validFuels.add(ModBlocks.fyrite_door.get().asItem());
            validFuels.add(Items.BLAZE_ROD);
            validFuels.add(Items.BLAZE_POWDER);
            ModTags.getnetherFurnaceFuels().stream().forEach(item -> validFuels.add(item));
        }
        return validFuels;
    } // end getValidFuels()

    public static Map<Item, Integer> loadBurnTimes()
    {
        Map<Item, Integer> map = Maps.newLinkedHashMap();
        addItemBurnTime(map, Blocks.NETHERRACK, netherrackBurnTime);
        addItemBurnTime(map, ModBlocks.fyrite_block.get(), fyriteBurnTime * 10);
        addItemBurnTime(map, ModBlocks.raw_fyrite_block.get(), fyriteBurnTime * 10);
        addItemBurnTime(map, ModBlocks.fyrite_bricks.get(), fyriteBurnTime * 10);
        addItemBurnTime(map, ModBlocks.fyrite_brick_stairs.get(), fyriteBurnTime * 10);
        addItemBurnTime(map, ModBlocks.fyrite_brick_slab.get(), fyriteBurnTime * 5);
        addItemBurnTime(map, ModBlocks.fyrite_door.get(), fyriteBurnTime * 5);
        addItemBurnTime(map, ModItems.fyrite_ingot.get(), fyriteBurnTime);
        addItemBurnTime(map, ModItems.raw_fyrite.get(), fyriteBurnTime);
        addItemBurnTime(map, ModItems.fyrite_nugget.get(), fyriteBurnTime/9);
        addItemBurnTime(map, ModItems.fyrite_dust.get(), fyriteBurnTime/2);
        addItemBurnTime(map, Items.BLAZE_ROD, blazeRodBurnTime);
        addItemBurnTime(map, Items.BLAZE_POWDER, blazeRodBurnTime/3);
        addItemTagBurnTime(map, ModTags.getnetherFurnaceFuels(), fyriteBurnTime / 3);
        return map;
    } // end getBurnTimes()

    protected static void addItemBurnTime(Map<Item, Integer> map,
                                   ItemLike itemProvider, int burnTimeIn)
    {
        map.put(itemProvider.asItem(), burnTimeIn);
    }

    protected static void addItemTagBurnTime(Map<Item, Integer> map, ITag<Item> iTag, int burnTimeIn)
    {
        iTag.stream().forEach(item -> map.put(item, burnTimeIn));
        
    } // end ()

    /**
     * For nether furnaces, replaces ForgeHooks.getBurnTime.
     * @param stack - fuel itemstack
     * @param recipeType - ignored
     * @return burn time in ticks.
     */
    public static int getBurnTime(ItemStack stack, @Nullable RecipeType<?> recipeType)
    {
        if (AbstractNetherFurnaceTileEntity.burnTimes.isEmpty()) {
            AbstractNetherFurnaceTileEntity.burnTimes = AbstractNetherFurnaceTileEntity.loadBurnTimes();
        }
        if (stack.isEmpty())
        {
            return 0;
        }
        else {
            Item item = stack.getItem();
            int ret = AbstractNetherFurnaceTileEntity.burnTimes.getOrDefault(item, 0);
            return ret;
        }
    } // end getBurnTime()
    
    /**
     * Nether furnaces cook things twice as fast as normal.
     */
    @Override
    protected short getSmeltTime(ItemStack input)
    {
        return (short) (super.getSmeltTime(input)/2);
    }

    @Override
    protected int getBurnDuration(ItemStack fuelstack)
    {
        // getBurnTime() already handles empty stack case.
         int returnval = AbstractNetherFurnaceTileEntity.getBurnTime(fuelstack, recipeType);
         // LOGGER.debug("[" + getDisplayName().getString() + "]AbstractNetherFurnaceTileEntity.getBurnDuration: returns " + returnval + " for " + fuelstack.toString());
         return returnval;
    } // end getBurnDuration

} // end class
