package mod.alexndr.netherrocks.content;

import mod.alexndr.netherrocks.api.content.AbstractNetherBlastFurnaceBlock;
import mod.alexndr.netherrocks.init.ModTiles;
import net.minecraft.core.BlockPos;
import net.minecraft.stats.Stats;
import net.minecraft.world.Containers;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.items.ItemStackHandler;

public class NetherBlastFurnaceBlock extends AbstractNetherBlastFurnaceBlock
{

    public NetherBlastFurnaceBlock(Properties builder)
    {
        super(builder);
    }

     @SuppressWarnings("deprecation")
    @Override
    public void onRemove(BlockState oldState, Level worldIn, BlockPos pos, BlockState newState, boolean isMoving)
    {
        if (oldState.getBlock() != newState.getBlock())
        {
            BlockEntity tileEntity = worldIn.getBlockEntity(pos);
            if (tileEntity instanceof NetherBlastFurnaceTileEntity)
            {
                final ItemStackHandler inventory = ((NetherBlastFurnaceTileEntity) tileEntity).inventory;
                for (int slot = 0; slot < inventory.getSlots(); ++slot)
                    Containers.dropItemStack(worldIn, pos.getX(), pos.getY(), pos.getZ(),
                            inventory.getStackInSlot(slot));
            }
        }
        // call this or tile entities don't get cleaned up!
        super.onRemove(oldState, worldIn, pos, newState, isMoving);
    } // end onRemove

 	@Override
 	public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level, BlockState bstate, BlockEntityType<T> entityType) 
 	{
 		return createFurnaceTicker(level, entityType, ModTiles.NETHER_BLAST_FURNACE.get());
 	}


 	@Override
 	public BlockEntity newBlockEntity(BlockPos bpos, BlockState bstate) {
 		return new NetherBlastFurnaceTileEntity(bpos, bstate);
 	}


 	@Override
 	protected void openContainer(Level level, BlockPos bpos, Player player) 
 	{
 		BlockEntity blockentity = level.getBlockEntity(bpos);
 		if (blockentity instanceof NetherBlastFurnaceTileEntity)
 		{
 			player.openMenu((MenuProvider) blockentity);
 			player.awardStat(Stats.INTERACT_WITH_FURNACE);
 		}
 	}

} // end class
