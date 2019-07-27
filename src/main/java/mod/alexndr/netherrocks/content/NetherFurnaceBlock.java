package mod.alexndr.netherrocks.content;

import net.minecraft.block.FurnaceBlock;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockReader;

public class NetherFurnaceBlock extends FurnaceBlock
{
    public NetherFurnaceBlock(Properties builder)
    {
        super(builder);
    }

    @Override
    public TileEntity createNewTileEntity(IBlockReader worldIn)
    {
        return new NetherFurnaceTileEntity();
    }
}  // end class NetherFurnaceBlock
