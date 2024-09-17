package mod.alexndr.netherrocks.content;

import com.mojang.serialization.MapCodec;
import mod.alexndr.netherrocks.api.content.AbstractNetherBlastFurnaceBlock;
import mod.alexndr.netherrocks.init.ModTiles;
import net.minecraft.core.BlockPos;
import net.minecraft.stats.Stats;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.AbstractFurnaceBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

public class NetherBlastFurnaceBlock extends AbstractNetherBlastFurnaceBlock
{
    //private static final String DISPLAY_NAME = "block.netherrocks.nether_blast_furnace";
    public static final MapCodec<NetherBlastFurnaceBlock> CODEC = simpleCodec(NetherBlastFurnaceBlock::new);

    public NetherBlastFurnaceBlock(Properties builder)
    {
        super(builder);
    }

    @Override protected MapCodec<? extends AbstractFurnaceBlock> codec()
    {
        return CODEC;
    }

    /**
     * Called to open this furnace's container.
     *
     * @param level
     * @param pos
     * @param player
     * @see #use
     */
    @Override
    protected void openContainer(Level level, BlockPos pos, Player player)
    {
        BlockEntity blockentity = level.getBlockEntity(pos);
        if (blockentity instanceof NetherBlastFurnaceTileEntity) {
            player.openMenu((MenuProvider)blockentity);
            player.awardStat(Stats.INTERACT_WITH_FURNACE);
        }
    }

    @Override
 	public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level, BlockState bstate, BlockEntityType<T> entityType) 
 	{
 		return createFurnaceTicker(level, entityType, ModTiles.NETHER_BLAST_FURNACE.get());
 	}

 	@Override
 	public BlockEntity newBlockEntity(BlockPos bpos, BlockState bstate) {
 		return new NetherBlastFurnaceTileEntity(bpos, bstate);
 	}




} // end class
