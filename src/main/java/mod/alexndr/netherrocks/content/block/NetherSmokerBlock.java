package mod.alexndr.netherrocks.content.block;

import com.mojang.serialization.MapCodec;
import mod.alexndr.netherrocks.api.content.AbstractNetherSmokerBlock;
import mod.alexndr.netherrocks.content.block_entity.NetherSmokerTileEntity;
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

public class NetherSmokerBlock extends AbstractNetherSmokerBlock
{
    //private static final String DISPLAY_NAME = "block.netherrocks.nether_smoker";
    public static final MapCodec<NetherSmokerBlock> CODEC = simpleCodec(NetherSmokerBlock::new);

    public NetherSmokerBlock(Properties builder)
    {
        super(builder);
    }

    @Override protected MapCodec<? extends AbstractFurnaceBlock> codec()
    {
        return CODEC;
    }

	@Override
	public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level, BlockState bstate, BlockEntityType<T> entityType) 
	{
		return createCustomFurnaceTicker(level, entityType, ModTiles.NETHER_SMOKER.get());
	}


	@Override
	public BlockEntity newBlockEntity(BlockPos bpos, BlockState bstate) {
		return new NetherSmokerTileEntity(bpos, bstate);
	}


    @Override
    protected void openContainer(Level level, BlockPos bpos, Player player) 
    {
        BlockEntity be = level.getBlockEntity(bpos);
        if (be instanceof NetherSmokerTileEntity) 
        {
            player.openMenu((MenuProvider) be);
            player.awardStat(Stats.INTERACT_WITH_FURNACE);
        } // end-if
    } // end openContainer

} // end-class
