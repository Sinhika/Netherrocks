package mod.alexndr.netherrocks.datagen;

import java.util.List;

import mod.alexndr.netherrocks.Netherrocks;
import mod.alexndr.netherrocks.init.ModBlocks;
import mod.alexndr.simplecorelib.datagen.MiningBlockTags;
import mod.alexndr.simplecorelib.helpers.TagUtils;
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
//        registerOreTags();
        registerStorageBlockTags();
        registerMiningTags();
        registerBeaconTags();
        registerDoorsSlabsAndStairs();
    }

    private void registerDoorsSlabsAndStairs()
    {
    	this.tag(TagUtils.modBlockTag("minecraft", "doors"))
    		.add(ModBlocks.argonite_door.get())
    		.add(ModBlocks.ashstone_door.get())
    		.add(ModBlocks.dragonstone_door.get())
    		.add(ModBlocks.fyrite_door.get())
    		.add(ModBlocks.illumenite_door.get())
    		.add(ModBlocks.malachite_door.get());
    	this.tag(TagUtils.modBlockTag("minecraft","stairs"))
			.add(ModBlocks.argonite_brick_stairs.get())
			.add(ModBlocks.ashstone_brick_stairs.get())
			.add(ModBlocks.dragonstone_brick_stairs.get())
			.add(ModBlocks.fyrite_brick_stairs.get())
			.add(ModBlocks.illumenite_brick_stairs.get())
			.add(ModBlocks.malachite_brick_stairs.get());
    	this.tag(TagUtils.modBlockTag("minecraft","slabs"))
			.add(ModBlocks.argonite_brick_slab.get())
			.add(ModBlocks.ashstone_brick_slab.get())
			.add(ModBlocks.dragonstone_brick_slab.get())
			.add(ModBlocks.fyrite_brick_slab.get())
			.add(ModBlocks.illumenite_brick_slab.get())
			.add(ModBlocks.malachite_brick_slab.get());
    }
    
    private void registerStorageBlockTags()
    {
        this.tag(TagUtils.forgeBlockTag("storage_blocks"))
        	.addTag(TagUtils.forgeBlockTag("storage_blocks/malachite"))
        	.addTag(TagUtils.forgeBlockTag("storage_blocks/fyrite"))
        	.addTag(TagUtils.forgeBlockTag("storage_blocks/argonite"))
        	.addTag(TagUtils.forgeBlockTag("storage_blocks/ashstone"))
        	.addTag(TagUtils.forgeBlockTag("storage_blocks/dragonstone"))
        	.addTag(TagUtils.forgeBlockTag("storage_blocks/illumenite"))
        	.addTag(TagUtils.forgeBlockTag("storage_blocks/raw_malachite"))
        	.addTag(TagUtils.forgeBlockTag("storage_blocks/raw_fyrite"))
        	.addTag(TagUtils.forgeBlockTag("storage_blocks/raw_argonite"))
        	.addTag(TagUtils.forgeBlockTag("storage_blocks/raw_illumenite"));
        
        this.tag(TagUtils.forgeBlockTag("storage_blocks/raw_argonite"))
    		.add(ModBlocks.raw_argonite_block.get());
        this.tag(TagUtils.forgeBlockTag("storage_blocks/raw_fyrite"))
    		.add(ModBlocks.raw_fyrite_block.get());
        this.tag(TagUtils.forgeBlockTag("storage_blocks/raw_malachite"))
    		.add(ModBlocks.raw_malachite_block.get());
        this.tag(TagUtils.forgeBlockTag("storage_blocks/raw_illumenite"))
    		.add(ModBlocks.raw_illumenite_block.get());

        this.tag(TagUtils.forgeBlockTag("storage_blocks/argonite"))
    		.add(ModBlocks.argonite_block.get());
        this.tag(TagUtils.forgeBlockTag("storage_blocks/fyrite"))
    		.add(ModBlocks.fyrite_block.get());
        this.tag(TagUtils.forgeBlockTag("storage_blocks/malachite"))
    		.add(ModBlocks.malachite_block.get());
        this.tag(TagUtils.forgeBlockTag("storage_blocks/illumenite"))
    		.add(ModBlocks.illumenite_block.get());
        this.tag(TagUtils.forgeBlockTag("storage_blocks/ashstone"))
    		.add(ModBlocks.ashstone_block.get());
        this.tag(TagUtils.forgeBlockTag("storage_blocks/dragonstone"))
    		.add(ModBlocks.dragonstone_block.get());

    } // end registerStorageBlockTags()
    
    protected void registerMiningTags()
    {
        // do nothing; super() generates all the vanilla blocktags, and we don't want that.
    	registerMineableTags( List.of(ModBlocks.argonite_block.get(), ModBlocks.argonite_ore.get(), 
    			ModBlocks.argonite_bars.get(), ModBlocks.argonite_brick_slab.get(), ModBlocks.argonite_brick_stairs.get(),
    			ModBlocks.argonite_bricks.get(), ModBlocks.argonite_door.get(),
    			ModBlocks.ashstone_block.get(), ModBlocks.ashstone_ore.get(), 
    			ModBlocks.ashstone_bars.get(), ModBlocks.ashstone_brick_slab.get(), ModBlocks.ashstone_brick_stairs.get(),
    			ModBlocks.ashstone_bricks.get(), ModBlocks.ashstone_door.get(),
    			ModBlocks.dragonstone_ore.get(), ModBlocks.dragonstone_block.get(), 
    			ModBlocks.dragonstone_bars.get(), ModBlocks.dragonstone_brick_slab.get(), ModBlocks.dragonstone_brick_stairs.get(),
    			ModBlocks.dragonstone_bricks.get(), ModBlocks.dragonstone_door.get(),
    			ModBlocks.fyrite_block.get(), ModBlocks.fyrite_ore.get(),
    			ModBlocks.fyrite_bars.get(), ModBlocks.fyrite_brick_slab.get(), ModBlocks.fyrite_brick_stairs.get(),
    			ModBlocks.fyrite_bricks.get(), ModBlocks.fyrite_door.get(),
    			ModBlocks.illumenite_block.get(), ModBlocks.illumenite_ore.get(), 
    			ModBlocks.illumenite_bars.get(), ModBlocks.illumenite_brick_slab.get(), ModBlocks.illumenite_brick_stairs.get(),
    			ModBlocks.illumenite_bricks.get(), ModBlocks.illumenite_door.get(),
    			ModBlocks.malachite_block.get(), ModBlocks.malachite_ore.get(),
    			ModBlocks.malachite_bars.get(), ModBlocks.malachite_brick_slab.get(), ModBlocks.malachite_brick_stairs.get(),
    			ModBlocks.malachite_bricks.get(), ModBlocks.malachite_door.get(),
    			ModBlocks.raw_argonite_block.get(), ModBlocks.raw_fyrite_block.get(), ModBlocks.raw_illumenite_block.get(),
    			ModBlocks.raw_malachite_block.get(),
    			ModBlocks.nether_blast_furnace.get(), ModBlocks.nether_furnace.get(), ModBlocks.nether_smoker.get()),
    		List.of(),   // 1 
    		List.of(ModBlocks.fyrite_block.get(), ModBlocks.fyrite_ore.get(), ModBlocks.fyrite_bars.get(), 
    				ModBlocks.fyrite_brick_slab.get(), ModBlocks.fyrite_brick_stairs.get(),
        			ModBlocks.fyrite_bricks.get(), ModBlocks.fyrite_door.get(),
    				ModBlocks.illumenite_block.get(), ModBlocks.illumenite_ore.get(), ModBlocks.illumenite_bars.get(), 
    				ModBlocks.illumenite_brick_slab.get(), ModBlocks.illumenite_brick_stairs.get(),
        			ModBlocks.illumenite_bricks.get(), ModBlocks.illumenite_door.get(),
    				ModBlocks.malachite_block.get(), ModBlocks.malachite_ore.get(), ModBlocks.malachite_bars.get(), 
    				ModBlocks.malachite_brick_slab.get(), ModBlocks.malachite_brick_stairs.get(),
        			ModBlocks.malachite_bricks.get(), ModBlocks.malachite_door.get(),
    				ModBlocks.raw_fyrite_block.get(), ModBlocks.raw_illumenite_block.get(), 
    				ModBlocks.raw_malachite_block.get()),   // 2
    		List.of(ModBlocks.argonite_block.get(), ModBlocks.argonite_ore.get(), ModBlocks.argonite_bars.get(), 
    				ModBlocks.argonite_brick_slab.get(), ModBlocks.argonite_brick_stairs.get(),
        			ModBlocks.argonite_bricks.get(), ModBlocks.argonite_door.get(), 
    				ModBlocks.ashstone_block.get(), ModBlocks.ashstone_ore.get(), ModBlocks.ashstone_bars.get(), 
    				ModBlocks.ashstone_brick_slab.get(), ModBlocks.ashstone_brick_stairs.get(),
        			ModBlocks.ashstone_bricks.get(), ModBlocks.ashstone_door.get(),
    				ModBlocks.dragonstone_block.get(), ModBlocks.dragonstone_ore.get(), ModBlocks.dragonstone_bars.get(), 
    				ModBlocks.dragonstone_brick_slab.get(), ModBlocks.dragonstone_brick_stairs.get(),
        			ModBlocks.dragonstone_bricks.get(), ModBlocks.dragonstone_door.get(),
    				ModBlocks.raw_argonite_block.get()),   // 3
    		List.of());  // 4
    }
    
    private void registerBeaconTags()
    {
    	this.tag(TagUtils.modBlockTag("minecraft", "beacon_base_blocks"))
    		.add(ModBlocks.argonite_block.get())
    		.add(ModBlocks.fyrite_block.get())
    		.add(ModBlocks.illumenite_block.get())
    		.add(ModBlocks.malachite_block.get());
    }
    
} // end class
