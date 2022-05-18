package mod.alexndr.netherrocks.content;

import mod.alexndr.simplecorelib.api.content.MultifunctionPressurePlateBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;

public class FyritePressurePlateBlock extends MultifunctionPressurePlateBlock
{

    public FyritePressurePlateBlock()
    {
        super(15, MultifunctionPressurePlateBlock.Sensitivity.EVERYTHING_WEIGHTED, 10, 
              Block.Properties.of(Material.METAL, MaterialColor.FIRE).noCollission().strength(0.5F).sound(SoundType.METAL));
    }

   @Override
    protected void playOnSound(LevelAccessor pLevel, BlockPos pPos)
    {
       super.playOnSound(pLevel, pPos);
       // add fire sounds
       pLevel.playSound((Player) null, pPos, SoundEvents.FLINTANDSTEEL_USE, SoundSource.BLOCKS, 0.3F,
               0.8F);
       pLevel.playSound((Player) null, pPos, SoundEvents.GENERIC_BURN, SoundSource.BLOCKS, 0.3F,
               0.8F);
    }

   @Override
   protected void playOffSound(LevelAccessor pLevel, BlockPos pPos)
   {
       super.playOffSound(pLevel, pPos);
       // add fire subsiding sounds.
       pLevel.playSound((Player) null, pPos, SoundEvents.FIRE_EXTINGUISH, SoundSource.BLOCKS, 0.3F,
               0.8F);
   }

    
    // TODO: sets things on fire when triggered.
    // this is handled by a VanillaGameEvent subscriber--@see ForgeEventSubscriber class.
    
} // end class
