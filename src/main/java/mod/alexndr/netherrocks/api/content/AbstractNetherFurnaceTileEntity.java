package mod.alexndr.netherrocks.api.content;

import mod.alexndr.netherrocks.helpers.NetherFurnaceFuelHandler;
import net.minecraft.core.BlockPos;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.block.entity.AbstractFurnaceBlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

import javax.annotation.Nullable;

public abstract class AbstractNetherFurnaceTileEntity extends AbstractFurnaceBlockEntity
{
    
    public AbstractNetherFurnaceTileEntity(BlockEntityType<?> tileEntityTypeIn, BlockPos blockpos, BlockState blockstate,
    		RecipeType<? extends AbstractCookingRecipe> recipeTypeIn)
    {
        super(tileEntityTypeIn, blockpos, blockstate, recipeTypeIn);
    }

    public static boolean isFuel(ItemStack stack)
    {
        return NetherFurnaceFuelHandler.getFuel().containsKey(stack.getItem())  || stack.is(Items.BUCKET);
    }

    /**
     * For nether furnaces, replaces ForgeHooks.getBurnTime.
     * @param stack - fuel itemstack
     * @param recipeType - ignored
     * @return burn time in ticks.
     */
    public static int getBurnTime(ItemStack stack, @Nullable RecipeType<?> recipeType)
    {
        if (stack.isEmpty())
        {
            return 0;
        }
        else {
            Item item = stack.getItem();
            return NetherFurnaceFuelHandler.getFuel().getOrDefault(item, 0);
        }
    } // end getBurnTime()
    
    /**
     * Nether furnaces cook things twice as fast as normal.
     */
    @Override
    protected short getSmeltTime(ItemStack input)
    {
        return (short) (super.getTotalCookTime(input)/2);
    }

    @Override
    protected int getBurnDuration(ItemStack fuelstack)
    {
        // getBurnTime() already handles empty stack case.
        // LOGGER.debug("[" + getDisplayName().getString() + "]AbstractNetherFurnaceTileEntity.getBurnDuration: returns " + returnval + " for " + fuelstack.toString());
         return AbstractNetherFurnaceTileEntity.getBurnTime(fuelstack, recipeType);
    } // end getBurnDuration

} // end class
