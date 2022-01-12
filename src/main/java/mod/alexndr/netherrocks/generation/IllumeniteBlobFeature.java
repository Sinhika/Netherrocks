package mod.alexndr.netherrocks.generation;

import java.util.Random;

import com.mojang.serialization.Codec;

import mod.alexndr.netherrocks.init.ModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;

public class IllumeniteBlobFeature  extends Feature<NoneFeatureConfiguration>
{
    public IllumeniteBlobFeature(Codec<NoneFeatureConfiguration> codec)
    {
        super(codec);
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
    public boolean place(FeaturePlaceContext<NoneFeatureConfiguration> context)
    {
    	WorldGenLevel worldIn = context.level();
    	BlockPos pos = context.origin();
    	Random rand = context.random();
    	
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
                if (bstate.isAir())
                {
                    int j = 0;

                    for(Direction direction : Direction.values())
                    {
                        BlockState thatblock = worldIn.getBlockState(blockpos.relative(direction));
                        if (thatblock.is(Blocks.GLOWSTONE) || thatblock.is(ModBlocks.illumenite_ore.get()))
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
