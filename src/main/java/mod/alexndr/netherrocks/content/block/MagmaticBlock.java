package mod.alexndr.netherrocks.content.block;

import com.mojang.serialization.MapCodec;
import net.minecraft.world.level.block.MagmaBlock;
import org.jetbrains.annotations.NotNull;

/**
 * Needs to have the properties of both MagmaBlock and DropExperienceBlock
 */
public class MagmaticBlock extends MagmaBlock
{

    public static final MapCodec<MagmaBlock> MAGMATIC_CODEC = simpleCodec(MagmaticBlock::new);

    @Override
    public @NotNull MapCodec<MagmaBlock> codec() {
        return MAGMATIC_CODEC;
    }

    public MagmaticBlock(Properties properties)
    {
        super(properties);
    }


} // end class
