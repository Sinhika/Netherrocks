package mod.alexndr.netherrocks.datagen;

import java.util.List;

import mod.alexndr.netherrocks.Netherrocks;
import mod.alexndr.netherrocks.init.ModBlocks;
import mod.alexndr.simplecorelib.datagen.MiningBlockTags;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ModBlockTags extends MiningBlockTags
{

    public ModBlockTags(DataGenerator generatorIn, ExistingFileHelper existingFileHelper)
    {
        super(generatorIn, Netherrocks.MODID, existingFileHelper);
    }

    @Override
    protected void addTags()
    {
        // do nothing; super() generates all the vanilla blocktags, and we don't want that.
    	registerMineableTags( List.of(ModBlocks.argonite_block.get(), ModBlocks.argonite_ore.get(), 
    			ModBlocks.ashstone_block.get(), ModBlocks.ashstone_ore.get(), ModBlocks.dragonstone_block.get(),
    			ModBlocks.dragonstone_ore.get(), ModBlocks.fyrite_block.get(), ModBlocks.illumenite_block.get(),
    			ModBlocks.illumenite_ore.get(), ModBlocks.malachite_block.get(), ModBlocks.malachite_ore.get(),
    			ModBlocks.nether_blast_furnace.get(), ModBlocks.nether_furnace.get(), ModBlocks.nether_smoker.get()),
    		List.of(),   // 1 
    		List.of(ModBlocks.fyrite_block.get(), ModBlocks.fyrite_ore.get(), ModBlocks.illumenite_block.get(),
    				ModBlocks.illumenite_ore.get(), ModBlocks.malachite_block.get(), ModBlocks.malachite_ore.get()),   // 2
    		List.of(ModBlocks.argonite_block.get(), ModBlocks.argonite_ore.get(), ModBlocks.ashstone_block.get(),
    				ModBlocks.ashstone_ore.get(), ModBlocks.dragonstone_block.get(), ModBlocks.dragonstone_ore.get()),   // 3
    		List.of());  // 4
    }

    
} // end class
