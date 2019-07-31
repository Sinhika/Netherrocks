package mod.alexndr.netherrocks.content;

import net.minecraft.block.FurnaceBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.stats.Stats;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;

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

    @Override
    protected void interactWith(World worldIn, BlockPos posIn, PlayerEntity playerIn)
    {
        TileEntity tile = worldIn.getTileEntity(posIn);
        if (tile instanceof NetherFurnaceTileEntity) {
            playerIn.openContainer((INamedContainerProvider)tile);
            playerIn.addStat(Stats.INTERACT_WITH_FURNACE);
        }
    }
}  // end class NetherFurnaceBlock
