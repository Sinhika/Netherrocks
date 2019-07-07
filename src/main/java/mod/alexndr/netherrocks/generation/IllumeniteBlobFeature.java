package mod.alexndr.netherrocks.generation;

import com.mojang.datafixers.Dynamic;
import mod.alexndr.netherrocks.init.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.GenerationSettings;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.NoFeatureConfig;

import java.util.Random;
import java.util.function.Function;

public class IllumeniteBlobFeature  extends Feature<NoFeatureConfig>
{
    public IllumeniteBlobFeature(Function<Dynamic<?>, ? extends NoFeatureConfig> p_i49878_1_)
    {
        super(p_i49878_1_);
    }

    @Override
    public boolean place(IWorld worldIn, ChunkGenerator<? extends GenerationSettings> generator,
                         Random rand, BlockPos pos, NoFeatureConfig config)
    {
        Block upblock = worldIn.getBlockState(pos.up()).getBlock();
        if (!worldIn.isAirBlock(pos)) {
            return false;
        }
        else if ((upblock != Blocks.NETHERRACK) && (upblock != Blocks.GLOWSTONE))
        {
            return false;
        }
        else {
            Block thisblock = (rand.nextInt(100) < 50) ? ModBlocks.illumenite_ore : Blocks.GLOWSTONE;
            worldIn.setBlockState(pos, thisblock.getDefaultState(), 2);

            for(int i = 0; i < 1500; ++i)
            {
                BlockPos blockpos = pos.add(rand.nextInt(8) - rand.nextInt(8), -rand.nextInt(12), rand.nextInt(8) - rand.nextInt(8));
                if (worldIn.getBlockState(blockpos).isAir(worldIn, blockpos))
                {
                    int j = 0;

                    for(Direction direction : Direction.values())
                    {
                        Block thatblock = worldIn.getBlockState(blockpos.offset(direction)).getBlock();
                        if (thatblock == Blocks.GLOWSTONE || thatblock == ModBlocks.illumenite_ore)
                        {
                            ++j;
                        }
                        if (j > 1) {
                            break;
                        }
                    } // end-for

                    if (j == 1) {
                        Block nextblock = (rand.nextInt(100) < 50) ? ModBlocks.illumenite_ore : Blocks.GLOWSTONE;
                        worldIn.setBlockState(blockpos, nextblock.getDefaultState(), 2);
                    }
                } // end-if
            }

            return true;
        } // end else
    } // end place()
}  // end class IllumeniteBlobFeature
