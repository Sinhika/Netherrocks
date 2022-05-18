package mod.alexndr.netherrocks.datagen;

import java.util.List;

import mod.alexndr.netherrocks.Netherrocks;
import mod.alexndr.netherrocks.init.ModBlocks;
import mod.alexndr.simplecorelib.api.datagen.MiningBlockTags;
import mod.alexndr.simplecorelib.api.helpers.TagUtils;
import net.minecraft.data.DataGenerator;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockTags extends MiningBlockTags
{

    public ModBlockTags(DataGenerator generatorIn, ExistingFileHelper existingFileHelper)
    {
        super(generatorIn, Netherrocks.MODID, existingFileHelper);
    }

    @Override
    protected void addTags()
    {
        super.addTags();
        registerStorageBlockTags();
        registerMiningTags();
        registerBeaconTags();
        registerDoorsSlabsAndStairs();
        registerMiscTags();
    }

    
    @Override
    protected void registerOreTags()
    {
    	// register "forge:ores" tags
        this.tag(TagUtils.forgeBlockTag( "ores"))
                .addTag(TagUtils.forgeBlockTag( "ores/argonite"))
                .addTag(TagUtils.forgeBlockTag( "ores/ashstone"))
                .addTag(TagUtils.forgeBlockTag( "ores/dragonstone"))
                .addTag(TagUtils.forgeBlockTag( "ores/fyrite"))
                .addTag(TagUtils.forgeBlockTag( "ores/illumenite"))
                .addTag(TagUtils.forgeBlockTag( "ores/malachite"));

        this.tag(TagUtils.forgeBlockTag( "ores/argonite"))
                .add(ModBlocks.argonite_ore.get());
        this.tag(TagUtils.forgeBlockTag( "ores/ashstone"))
        	.add(ModBlocks.ashstone_ore.get());
        this.tag(TagUtils.forgeBlockTag( "ores/dragonstone"))
        	.add(ModBlocks.dragonstone_ore.get());
        this.tag(TagUtils.forgeBlockTag( "ores/fyrite"))
        	.add(ModBlocks.fyrite_ore.get());
        this.tag(TagUtils.forgeBlockTag( "ores/illumenite"))
        	.add(ModBlocks.illumenite_ore.get());
        this.tag(TagUtils.forgeBlockTag( "ores/malachite"))
        	.add(ModBlocks.malachite_ore.get());

        // register forge ore_rates tags.
        this.registerOreRateTags( List.of(), // sparse 
        		List.of(ModBlocks.argonite_ore.get(), ModBlocks.ashstone_ore.get(),
        				ModBlocks.dragonstone_ore.get(), ModBlocks.fyrite_ore.get(),
        				ModBlocks.illumenite_ore.get(), ModBlocks.malachite_ore.get()), // singular 
        		List.of()); // dense
        
        // register forge:ores_in_ground tags
        this.registerOresInGroundTags( List.of(), // stone ores
        		List.of(), // deepslate ores
        		List.of(ModBlocks.argonite_ore.get(), ModBlocks.ashstone_ore.get(),
        				ModBlocks.dragonstone_ore.get(), ModBlocks.fyrite_ore.get(),
        				ModBlocks.illumenite_ore.get(), ModBlocks.malachite_ore.get()));  // netherrack ores
    
    }  // end registerOreTags
    
    
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
    
    @Override
    protected void registerMiningTags()
    {
     // all the registered blocks are mineable.
        List<Block> mineables = ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get).toList();
        
        // do nothing; super() generates all the vanilla blocktags, and we don't want that.
    	registerMineableTags( mineables,
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
    
    private void registerMiscTags()
    {
        this.tag(TagUtils.modBlockTag("minecraft", "pressure_plates"))
            .add(ModBlocks.argonite_pressure_plate.get())
            .add(ModBlocks.ashstone_pressure_plate.get())
            .add(ModBlocks.dragonstone_pressure_plate.get())
            .add(ModBlocks.illumenite_pressure_plate.get())
            .add(ModBlocks.malachite_pressure_plate.get())
            .add(ModBlocks.fyrite_pressure_plate.get());
        
    }
} // end class
