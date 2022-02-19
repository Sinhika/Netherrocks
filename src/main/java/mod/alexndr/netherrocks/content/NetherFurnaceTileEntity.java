package mod.alexndr.netherrocks.content;

import mod.alexndr.netherrocks.api.content.AbstractNetherFurnaceTileEntity;
import mod.alexndr.netherrocks.init.ModTiles;
import net.minecraft.core.BlockPos;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.block.state.BlockState;

public class NetherFurnaceTileEntity extends AbstractNetherFurnaceTileEntity
{
    public NetherFurnaceTileEntity(BlockPos blockpos, BlockState blockstate)
    {
        super(ModTiles.NETHER_FURNACE.get(),blockpos, blockstate, RecipeType.SMELTING);
    }

}  // end class NetherFurnaceTileEntity
