package mod.alexndr.netherrocks.generation;

import net.minecraft.world.gen.placement.NoPlacementConfig;
import net.minecraft.world.gen.placement.SimplePlacement;

import com.mojang.datafixers.Dynamic;
import java.util.Random;
import java.util.function.Function;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import net.minecraft.util.math.BlockPos;

public class Height4to128  extends SimplePlacement<NoPlacementConfig>
{
    public Height4to128(Function<Dynamic<?>, ? extends NoPlacementConfig> p_i51362_1_)
    {
        super(p_i51362_1_);
    }

    @Override
    protected Stream<BlockPos> func_212852_a_(Random random, NoPlacementConfig noPlacementConfig, BlockPos blockPos)
    {
        int lvt_4_1_ = 3 + random.nextInt(6);
        return IntStream.range(0, lvt_4_1_).mapToObj((foobar) -> {
            int lvt_3_1_ = random.nextInt(16);
            int bar = random.nextInt(124) + 4;
            int lvt_5_1_ = random.nextInt(16);
            return blockPos.add(lvt_3_1_, bar, lvt_5_1_);
        });
    }
}  // end class Height4to128
