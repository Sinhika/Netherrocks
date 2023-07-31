package mod.alexndr.netherrocks.content;

import mod.alexndr.netherrocks.init.ModBlockSetTypes;
import mod.alexndr.simplecorelib.api.content.MultifunctionPressurePlateBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;

public class FyritePressurePlateBlock extends MultifunctionPressurePlateBlock
{
	
    public FyritePressurePlateBlock()
    {
        super(15, MultifunctionPressurePlateBlock.Sensitivity.EVERYTHING_WEIGHTED, 10, 
              BlockBehaviour.Properties.of().mapColor(MapColor.FIRE).noCollission().strength(0.5F),
              ModBlockSetTypes.FYRITE);
    }

    // sets things on fire when triggered.
    // this is handled by a VanillaGameEvent subscriber--@see ForgeEventSubscriber class.
    
} // end class
