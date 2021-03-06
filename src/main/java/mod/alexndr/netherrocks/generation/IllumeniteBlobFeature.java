package mod.alexndr.netherrocks.generation;

import java.util.Random;

import com.mojang.serialization.Codec;

import mod.alexndr.netherrocks.init.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.ISeedReader;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.NoFeatureConfig;

public class IllumeniteBlobFeature  extends Feature<NoFeatureConfig>
{
    public IllumeniteBlobFeature(Codec<NoFeatureConfig> p_i231956_1_)
    {
        super(p_i231956_1_);
    }

    /**
     * How to construct the feature...
     * Was place() in 1.15.2.
     * @param worldIn
     * @param generator
     * @param rand
     * @param pos
     * @param config
     * @return
     */
    @Override
    public boolean place(ISeedReader worldIn,
            ChunkGenerator generator, Random rand, BlockPos pos, NoFeatureConfig config)
    {
        if (!worldIn.isEmptyBlock(pos)) {
            return false;
        }
        BlockState upblock = worldIn.getBlockState(pos.above());
        if (!upblock.is(Blocks.NETHERRACK) && !upblock.is(Blocks.GLOWSTONE)
            && !upblock.is(Blocks.BASALT) && !upblock.is(Blocks.BLACKSTONE))
        {
            return false;
        }
        else {
            Block thisblock = (rand.nextInt(100) < 50) ? ModBlocks.illumenite_ore.get() : Blocks.GLOWSTONE;
            worldIn.setBlock(pos, thisblock.defaultBlockState(), 2);

            for(int i = 0; i < 1500; ++i)
            {
                BlockPos blockpos = pos.offset(rand.nextInt(8) - rand.nextInt(8), -rand.nextInt(12), rand.nextInt(8) - rand.nextInt(8));
                BlockState bstate = worldIn.getBlockState(blockpos);
                if (bstate.getBlock().isAir(bstate, worldIn, blockpos))
                {
                    int j = 0;

                    for(Direction direction : Direction.values())
                    {
                        Block thatblock = worldIn.getBlockState(blockpos.relative(direction)).getBlock();
                        if (thatblock == Blocks.GLOWSTONE || thatblock == ModBlocks.illumenite_ore.get())
                        {
                            ++j;
                        }
                        if (j > 1) {
                            break;
                        }
                    } // end-for

                    if (j == 1) {
                        Block nextblock = (rand.nextInt(100) < 50) ? ModBlocks.illumenite_ore.get() : Blocks.GLOWSTONE;
                        worldIn.setBlock(blockpos, nextblock.defaultBlockState(), 2);
                    }
                } // end-if
            }

            return true;
        } // end else
    } // end place()
}  // end class IllumeniteBlobFeature
