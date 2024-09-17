package mod.alexndr.netherrocks.datagen;

import mod.alexndr.netherrocks.Netherrocks;
import mod.alexndr.netherrocks.init.ModBlocks;
import mod.alexndr.netherrocks.init.ModTags;
import mod.alexndr.simplecorelib.api.datagen.MiningBlockTags;
import mod.alexndr.simplecorelib.api.helpers.TagUtils;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModBlockTags extends MiningBlockTags
{

    public ModBlockTags(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider,
						ExistingFileHelper existingFileHelper)
    {
        super(output, lookupProvider, Netherrocks.MODID, existingFileHelper);
    }

    @Override
    protected void addTags(Provider pProvider)
    {
        super.addTags(pProvider);
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
        this.tag(TagUtils.cBlockTag( "ores"))
                .addTag(TagUtils.cBlockTag( "ores/argonite"))
                .addTag(TagUtils.cBlockTag( "ores/ashstone"))
                .addTag(TagUtils.cBlockTag( "ores/dragonstone"))
                .addTag(TagUtils.cBlockTag( "ores/fyrite"))
                .addTag(TagUtils.cBlockTag( "ores/illumenite"))
                .addTag(TagUtils.cBlockTag( "ores/malachite"));

        this.tag(TagUtils.cBlockTag( "ores/argonite"))
                .add(ModBlocks.argonite_ore.get());
        this.tag(TagUtils.cBlockTag( "ores/ashstone"))
        	.add(ModBlocks.ashstone_ore.get());
        this.tag(TagUtils.cBlockTag( "ores/dragonstone"))
        	.add(ModBlocks.dragonstone_ore.get());
        this.tag(TagUtils.cBlockTag( "ores/fyrite"))
        	.add(ModBlocks.fyrite_ore.get());
        this.tag(TagUtils.cBlockTag( "ores/illumenite"))
        	.add(ModBlocks.illumenite_ore.get());
        this.tag(TagUtils.cBlockTag( "ores/malachite"))
        	.add(ModBlocks.malachite_ore.get());

        // register forge ore_rates tags.
        this.registerOreRateTags( List.of(), // sparse 
        		List.of(ModBlocks.argonite_ore.get(), ModBlocks.ashstone_ore.get(), // singular
        				ModBlocks.dragonstone_ore.get(), ModBlocks.fyrite_ore.get(),
        				ModBlocks.illumenite_ore.get(), ModBlocks.malachite_ore.get()),
        		List.of()); // dense
        
        // register forge:ores_in_ground tags
        this.registerOresInGroundTags( List.of(), // stone ores
        		List.of(), // deepslate ores
        		List.of(ModBlocks.argonite_ore.get(), ModBlocks.ashstone_ore.get(), // netherrack ores
        				ModBlocks.dragonstone_ore.get(), ModBlocks.fyrite_ore.get(),
        				ModBlocks.illumenite_ore.get(), ModBlocks.malachite_ore.get()));
 
    
    }  // end registerOreTags
    
    
    private void registerDoorsSlabsAndStairs()
    {
    	this.tag(BlockTags.DOORS)
    		.add(ModBlocks.argonite_door.get())
    		.add(ModBlocks.ashstone_door.get())
    		.add(ModBlocks.dragonstone_door.get())
    		.add(ModBlocks.fyrite_door.get())
    		.add(ModBlocks.illumenite_door.get())
    		.add(ModBlocks.malachite_door.get());
    	this.tag(BlockTags.STAIRS)
			.add(ModBlocks.argonite_brick_stairs.get())
			.add(ModBlocks.ashstone_brick_stairs.get())
			.add(ModBlocks.dragonstone_brick_stairs.get())
			.add(ModBlocks.fyrite_brick_stairs.get())
			.add(ModBlocks.illumenite_brick_stairs.get())
			.add(ModBlocks.malachite_brick_stairs.get());
    	this.tag(BlockTags.SLABS)
			.add(ModBlocks.argonite_brick_slab.get())
			.add(ModBlocks.ashstone_brick_slab.get())
			.add(ModBlocks.dragonstone_brick_slab.get())
			.add(ModBlocks.fyrite_brick_slab.get())
			.add(ModBlocks.illumenite_brick_slab.get())
			.add(ModBlocks.malachite_brick_slab.get());
    }
    
    private void registerStorageBlockTags()
    {
        this.tag(Tags.Blocks.STORAGE_BLOCKS)
        	.addTag(TagUtils.cBlockTag("storage_blocks/malachite"))
        	.addTag(TagUtils.cBlockTag("storage_blocks/fyrite"))
        	.addTag(TagUtils.cBlockTag("storage_blocks/argonite"))
        	.addTag(TagUtils.cBlockTag("storage_blocks/ashstone"))
        	.addTag(TagUtils.cBlockTag("storage_blocks/dragonstone"))
        	.addTag(TagUtils.cBlockTag("storage_blocks/illumenite"))
        	.addTag(TagUtils.cBlockTag("storage_blocks/raw_malachite"))
        	.addTag(TagUtils.cBlockTag("storage_blocks/raw_fyrite"))
        	.addTag(TagUtils.cBlockTag("storage_blocks/raw_argonite"))
        	.addTag(TagUtils.cBlockTag("storage_blocks/raw_illumenite"));
        
        this.tag(TagUtils.cBlockTag("storage_blocks/raw_argonite"))
    		.add(ModBlocks.raw_argonite_block.get());
        this.tag(TagUtils.cBlockTag("storage_blocks/raw_fyrite"))
    		.add(ModBlocks.raw_fyrite_block.get());
        this.tag(TagUtils.cBlockTag("storage_blocks/raw_malachite"))
    		.add(ModBlocks.raw_malachite_block.get());
        this.tag(TagUtils.cBlockTag("storage_blocks/raw_illumenite"))
    		.add(ModBlocks.raw_illumenite_block.get());

        this.tag(TagUtils.cBlockTag("storage_blocks/argonite"))
    		.add(ModBlocks.argonite_block.get());
        this.tag(TagUtils.cBlockTag("storage_blocks/fyrite"))
    		.add(ModBlocks.fyrite_block.get());
        this.tag(TagUtils.cBlockTag("storage_blocks/malachite"))
    		.add(ModBlocks.malachite_block.get());
        this.tag(TagUtils.cBlockTag("storage_blocks/illumenite"))
    		.add(ModBlocks.illumenite_block.get());
        this.tag(TagUtils.cBlockTag("storage_blocks/ashstone"))
    		.add(ModBlocks.ashstone_block.get());
        this.tag(TagUtils.cBlockTag("storage_blocks/dragonstone"))
    		.add(ModBlocks.dragonstone_block.get());

    } // end registerStorageBlockTags()
    
    @Override
    protected void registerMiningTags()
    {
     // all the registered blocks are mineable.
        List<Block> mineables = (List<Block>) ModBlocks.BLOCKS.getEntries().stream().map((h) -> h.get()).toList();
        
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
    				ModBlocks.ashstone_block.get(), ModBlocks.ashstone_ore.get(), 
    				ModBlocks.ashstone_bars.get(), 
    				ModBlocks.ashstone_brick_slab.get(), ModBlocks.ashstone_brick_stairs.get(),
        			ModBlocks.ashstone_bricks.get(), ModBlocks.ashstone_door.get(),
    				ModBlocks.dragonstone_block.get(), ModBlocks.dragonstone_ore.get(), ModBlocks.dragonstone_bars.get(), 
    				ModBlocks.dragonstone_brick_slab.get(), ModBlocks.dragonstone_brick_stairs.get(),
        			ModBlocks.dragonstone_bricks.get(), ModBlocks.dragonstone_door.get(),
    				ModBlocks.raw_argonite_block.get()),   // 3
    		List.of());  // 4

		this.tag(ModTags.Blocks.NEEDS_DRAGONSTONE_TOOL);
		this.tag(Tags.Blocks.NEEDS_NETHERITE_TOOL);

		this.tag(ModTags.Blocks.INCORRECT_FOR_DRAGONSTONE_TOOL);

		this.tag(BlockTags.INCORRECT_FOR_NETHERITE_TOOL)
				.addTag(ModTags.Blocks.NEEDS_DRAGONSTONE_TOOL);

		this.tag(BlockTags.INCORRECT_FOR_DIAMOND_TOOL)
				.addTag(Tags.Blocks.NEEDS_NETHERITE_TOOL)
				.addTag(ModTags.Blocks.NEEDS_DRAGONSTONE_TOOL);


    } // end registerMiningTags()
    
    private void registerBeaconTags()
    {
    	this.tag(BlockTags.BEACON_BASE_BLOCKS)
    		.add(ModBlocks.argonite_block.get())
    		.add(ModBlocks.fyrite_block.get())
    		.add(ModBlocks.illumenite_block.get())
    		.add(ModBlocks.malachite_block.get());
    }
    
    private void registerMiscTags()
    {
        this.tag(BlockTags.PRESSURE_PLATES)
            .add(ModBlocks.argonite_pressure_plate.get())
            .add(ModBlocks.ashstone_pressure_plate.get())
            .add(ModBlocks.dragonstone_pressure_plate.get())
            .add(ModBlocks.illumenite_pressure_plate.get())
            .add(ModBlocks.malachite_pressure_plate.get())
            .add(ModBlocks.fyrite_pressure_plate.get());
        
    }
} // end class
