package mod.alexndr.netherrocks.content;

import com.mojang.serialization.MapCodec;
import mod.alexndr.netherrocks.init.ModTiles;
import mod.alexndr.simplecorelib.api.content.SomewhatAbstractFurnaceBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.util.RandomSource;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.AbstractFurnaceBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;

public class NetherFurnaceBlock extends SomewhatAbstractFurnaceBlock
{
    //private static final String DISPLAY_NAME = "block.netherrocks.nether_furnace";
    public static final MapCodec<NetherFurnaceBlock> CODEC = simpleCodec(NetherFurnaceBlock::new);

   public NetherFurnaceBlock(final Properties builder)
    {
        super(builder);
    } // end ctor

    @Override protected MapCodec<? extends AbstractFurnaceBlock> codec() { return CODEC; }

	@Override
	public <T extends BlockEntity> BlockEntityTicker<T> getTicker(
            Level level, BlockState bstate, BlockEntityType<T> entityType)
	{
		return createFurnaceTicker(level, entityType, ModTiles.NETHER_FURNACE.get());
	}


	@Override
	public BlockEntity newBlockEntity(BlockPos bpos, BlockState bstate) {
		return new NetherFurnaceTileEntity(bpos, bstate);
	}

   @Override
    protected void openContainer(Level level, BlockPos bpos, Player player) 
    {
        BlockEntity be = level.getBlockEntity(bpos);
        if (be instanceof NetherFurnaceTileEntity) 
        {
            player.openMenu((MenuProvider) be);
            player.awardStat(Stats.INTERACT_WITH_FURNACE);
        } // end-if
    } // end openContainer

    /**
     * Called periodically clientside on blocks near the player to show effects (like furnace fire particles).
     *
     * @param stateIn
     * @param worldIn
     * @param pos
     * @param rand
     */
    @Override public void animateTick(BlockState stateIn, @NotNull Level worldIn, @NotNull BlockPos pos, @NotNull RandomSource rand)
    {
        if (stateIn.getValue(LIT)) {
            double d0 = (double) pos.getX() + 0.5D;
            double d1 = pos.getY();
            double d2 = (double) pos.getZ() + 0.5D;
            if (rand.nextDouble() < 0.1D) {
                worldIn.playLocalSound(d0, d1, d2, SoundEvents.FURNACE_FIRE_CRACKLE, SoundSource.BLOCKS, 1.0F, 1.0F,
                        false);
            }

            Direction direction = stateIn.getValue(FACING);
            Direction.Axis direction$axis = direction.getAxis();
            // double d3 = 0.52D;
            double d4 = rand.nextDouble() * 0.6D - 0.3D;
            double d5 = direction$axis == Direction.Axis.X ? (double) direction.getStepX() * 0.52D : d4;
            double d6 = rand.nextDouble() * 6.0D / 16.0D;
            double d7 = direction$axis == Direction.Axis.Z ? (double) direction.getStepZ() * 0.52D : d4;
            worldIn.addParticle(ParticleTypes.SMOKE, d0 + d5, d1 + d6, d2 + d7, 0.0D, 0.0D, 0.0D);
            worldIn.addParticle(ParticleTypes.FLAME, d0 + d5, d1 + d6, d2 + d7, 0.0D, 0.0D, 0.0D);
        }
    } // end animateTick

}  // end class NetherFurnaceBlock
