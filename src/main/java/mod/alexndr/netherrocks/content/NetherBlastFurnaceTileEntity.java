package mod.alexndr.netherrocks.content;

import mod.alexndr.netherrocks.api.content.AbstractNetherFurnaceTileEntity;
import mod.alexndr.netherrocks.init.ModTiles;
import net.minecraft.core.BlockPos;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.block.state.BlockState;

public class NetherBlastFurnaceTileEntity extends AbstractNetherFurnaceTileEntity
{

    public NetherBlastFurnaceTileEntity(BlockPos blockpos, BlockState blockstate)
    {
        super(ModTiles.NETHER_BLAST_FURNACE.get(), blockpos, blockstate, RecipeType.BLASTING);
    }

    @Override
    protected int getBurnDuration(ItemStack fuelstack)
    {
        return super.getBurnDuration(fuelstack)/2;
    }

} // end class
