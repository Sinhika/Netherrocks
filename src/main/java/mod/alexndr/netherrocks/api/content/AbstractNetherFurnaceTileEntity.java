package mod.alexndr.netherrocks.api.content;

import mod.alexndr.netherrocks.datagen.NetherFurnaceFuelHandler;
import mod.alexndr.netherrocks.init.ModDataMaps;
import mod.alexndr.simplecorelib.api.content.SomewhatAbstractFurnaceBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.registries.datamaps.builtin.FurnaceFuel;

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
        return NetherFurnaceFuelHandler.getFuel().containsKey(stack.getItem())  || stack.is(Items.BUCKET);
    }

    /**
     * For nether furnaces, replaces ForgeHooks.getBurnTime.
     * @param stack - fuel itemstack
     * @param recipeType - ignored
     * @return burn time in ticks.
     */
    @Override
    protected int getBurnTime(ItemStack stack, @Nullable RecipeType<?> recipeType)
    {
        if (stack.isEmpty())
        {
            return 0;
        }
        else {
            FurnaceFuel furnaceFuel = BuiltInRegistries.ITEM.createIntrusiveHolder(stack.getItem()).getData(
                    ModDataMaps.NETHER_FURNACE_FUELS);
            return furnaceFuel == null ? 0 : furnaceFuel.burnTime();
        }
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

} // end class
