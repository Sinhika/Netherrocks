package mod.alexndr.netherrocks.api.content;

import mod.alexndr.netherrocks.init.ModDataMaps;
import mod.alexndr.simplecorelib.api.content.block_entity.SomewhatAbstractFurnaceBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.registries.datamaps.builtin.FurnaceFuel;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;

public abstract class AbstractNetherFurnaceTileEntity extends SomewhatAbstractFurnaceBlockEntity
{

    public AbstractNetherFurnaceTileEntity(BlockEntityType<?> tileEntityTypeIn, BlockPos blockpos, BlockState blockstate,
    		RecipeType<? extends AbstractCookingRecipe> recipeTypeIn)
    {
        super(tileEntityTypeIn, blockpos, blockstate, recipeTypeIn);
    }

    @Override
    public boolean isCustomFuel(ItemStack stack)
    {
        return AbstractNetherFurnaceTileEntity.isStaticCustomFuel(stack);
    }

    public static boolean isStaticCustomFuel(ItemStack stack)
    {
        return (stack.getItemHolder().getData(ModDataMaps.NETHER_FURNACE_FUELS) != null);
    }

    /**
     * For nether furnaces, replaces ForgeHooks.getBurnTime.
     * @param stack - fuel itemstack
     * @param recipeType - ignored
     * @return burn time in ticks.
     */
    public static int getStaticBurnTime(ItemStack stack, @Nullable RecipeType<?> recipeType)
    {
        if (stack.isEmpty())
        {
            return 0;
        }
        else {
            FurnaceFuel furnaceFuel = stack.getItemHolder().getData(
                    ModDataMaps.NETHER_FURNACE_FUELS);
            return furnaceFuel == null ? 0 : furnaceFuel.burnTime();
        }

    }


    /**
     * For nether furnaces, replaces ForgeHooks.getBurnTime.
     * @param stack - fuel itemstack
     * @param recipeType - ignored
     * @return burn time in ticks.
     */
    @Override
    public int getBurnTime(ItemStack stack, @Nullable RecipeType<?> recipeType)
    {
        int bt = getStaticBurnTime(stack, recipeType);
        //Netherrocks.LOGGER.debug("{} burnTime is {}", stack.getDescriptionId(), bt);
        return bt;
    } // end getBurnTime()
    
    /**
     * Nether furnaces cook things twice as fast as normal.
     */
    @Override
    protected int getSmeltTime(Level level, SomewhatAbstractFurnaceBlockEntity blockEntity)
    {
        int baseCookTime = super.getSmeltTime(this.getLevel(), this);
        return (baseCookTime/2);
    }

    @Override
    public boolean canPlaceItemThroughFace(int index, ItemStack stack, @org.jetbrains.annotations.Nullable Direction direction)
    {
        return this.canPlaceItem(index, stack);
    }

    /**
     * Returns {@code true} if automation is allowed to insert the given stack (ignoring stack size) into the given slot. For guis use Slot.isItemValid
     */
    @Override
    public boolean canPlaceItem(int index, @NotNull ItemStack stack)
    {
        if (index == 2) {
            return false;
        } else if (index != 1) {
            return true;
        } else {
            ItemStack itemstack = (ItemStack)this.items.get(1);
            return isCustomFuel(stack) || stack.is(Items.BUCKET) && !itemstack.is(Items.BUCKET);
        }
    }
} // end class
