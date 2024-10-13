package mod.alexndr.netherrocks.datagen;

import mod.alexndr.netherrocks.Netherrocks;
import mod.alexndr.netherrocks.init.ModBlocks;
import mod.alexndr.netherrocks.init.ModItems;
import mod.alexndr.simplecorelib.api.datagen.MiningItemTags;
import mod.alexndr.simplecorelib.api.helpers.TagUtils;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModItemTags extends MiningItemTags
{

    public ModItemTags(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider,
    		CompletableFuture<TagLookup<Block>> blockTagProvider, ExistingFileHelper existingFileHelper)
    {
        super(output, lookupProvider, blockTagProvider, Netherrocks.MODID, existingFileHelper);
    }
    
    @Override
    protected void addTags(HolderLookup.Provider lookupProvider)
    {
    	super.addTags(lookupProvider);
    	registerNuggetTags();
    	registerIngotTags();
    	registerRawMetalTags();
    	registerGemTags();
        registerDustTags();
        //registerOreChunkTags();
        registerTools();
        registerArmorTags(ModItems.ITEMS);
        registerDoorsSlabsAndStairs();
    	registerBlockItemTags();
    }

    
    @Override
    protected void registerOreTags()
    {
    	// register "forge:ores" tags
        this.tag(Tags.Items.ORES)
                .addTag(TagUtils.cTag( "ores/argonite"))
                .addTag(TagUtils.cTag( "ores/ashstone"))
                .addTag(TagUtils.cTag( "ores/dragonstone"))
                .addTag(TagUtils.cTag( "ores/fyrite"))
                .addTag(TagUtils.cTag( "ores/illumenite"))
                .addTag(TagUtils.cTag( "ores/malachite"));

        this.tag(TagUtils.cTag( "ores/argonite"))
                .add(ModBlocks.argonite_ore.get().asItem());
        this.tag(TagUtils.cTag( "ores/ashstone"))
        	.add(ModBlocks.ashstone_ore.get().asItem());
        this.tag(TagUtils.cTag( "ores/dragonstone"))
        	.add(ModBlocks.dragonstone_ore.get().asItem());
        this.tag(TagUtils.cTag( "ores/fyrite"))
        	.add(ModBlocks.fyrite_ore.get().asItem())
				.add(ModBlocks.magmatic_fyrite_ore.get().asItem());
        this.tag(TagUtils.cTag( "ores/illumenite"))
        	.add(ModBlocks.illumenite_ore.get().asItem());
        this.tag(TagUtils.cTag( "ores/malachite"))
        	.add(ModBlocks.malachite_ore.get().asItem());

        // register forge ore_rates tags.
        this.registerOreRateTags( List.of(), // sparse 
        		List.of(ModBlocks.argonite_ore.get(), ModBlocks.ashstone_ore.get(),
        				ModBlocks.dragonstone_ore.get(), ModBlocks.fyrite_ore.get(),
						ModBlocks.magmatic_fyrite_ore.get(),
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
    	this.tag(ItemTags.DOORS)
    		.add(ModBlocks.argonite_door.get().asItem())
    		.add(ModBlocks.ashstone_door.get().asItem())
    		.add(ModBlocks.dragonstone_door.get().asItem())
    		.add(ModBlocks.fyrite_door.get().asItem())
    		.add(ModBlocks.illumenite_door.get().asItem())
    		.add(ModBlocks.malachite_door.get().asItem());
    	this.tag(ItemTags.STAIRS)
			.add(ModBlocks.argonite_brick_stairs.get().asItem())
			.add(ModBlocks.ashstone_brick_stairs.get().asItem())
			.add(ModBlocks.dragonstone_brick_stairs.get().asItem())
			.add(ModBlocks.fyrite_brick_stairs.get().asItem())
			.add(ModBlocks.illumenite_brick_stairs.get().asItem())
			.add(ModBlocks.malachite_brick_stairs.get().asItem());
    	this.tag(ItemTags.SLABS)
			.add(ModBlocks.argonite_brick_slab.get().asItem())
			.add(ModBlocks.ashstone_brick_slab.get().asItem())
			.add(ModBlocks.dragonstone_brick_slab.get().asItem())
			.add(ModBlocks.fyrite_brick_slab.get().asItem())
			.add(ModBlocks.illumenite_brick_slab.get().asItem())
			.add(ModBlocks.malachite_brick_slab.get().asItem());
    } // end registerDoorsSlabsAndStairs

    private void registerBlockItemTags()
    {
        this.tag(Tags.Items.STORAGE_BLOCKS)
	        .addTag(TagUtils.cTag("storage_blocks/malachite"))
	        .addTag(TagUtils.cTag("storage_blocks/fyrite"))
	        .addTag(TagUtils.cTag("storage_blocks/argonite"))
	        .addTag(TagUtils.cTag("storage_blocks/ashstone"))
	        .addTag(TagUtils.cTag("storage_blocks/dragonstone"))
	        .addTag(TagUtils.cTag("storage_blocks/illumenite"))
	        .addTag(TagUtils.cTag("storage_blocks/raw_malachite"))
	        .addTag(TagUtils.cTag("storage_blocks/raw_fyrite"))
	        .addTag(TagUtils.cTag("storage_blocks/raw_illumenite"))
	        .addTag(TagUtils.cTag("storage_blocks/raw_argonite"));
    
        
        this.tag(TagUtils.cTag("storage_blocks/raw_argonite"))
    		.add(ModBlocks.raw_argonite_block.get().asItem());
        this.tag(TagUtils.cTag("storage_blocks/raw_fyrite"))
    		.add(ModBlocks.raw_fyrite_block.get().asItem());
        this.tag(TagUtils.cTag("storage_blocks/raw_malachite"))
    		.add(ModBlocks.raw_malachite_block.get().asItem());
        this.tag(TagUtils.cTag("storage_blocks/raw_illumenite"))
    		.add(ModBlocks.raw_illumenite_block.get().asItem());

        this.tag(TagUtils.cTag("storage_blocks/argonite"))
    		.add(ModBlocks.argonite_block.get().asItem());
        this.tag(TagUtils.cTag("storage_blocks/fyrite"))
    		.add(ModBlocks.fyrite_block.get().asItem());
        this.tag(TagUtils.cTag("storage_blocks/malachite"))
    		.add(ModBlocks.malachite_block.get().asItem());
        this.tag(TagUtils.cTag("storage_blocks/illumenite"))
    		.add(ModBlocks.illumenite_block.get().asItem());
        this.tag(TagUtils.cTag("storage_blocks/ashstone"))
    		.add(ModBlocks.ashstone_block.get().asItem());
        this.tag(TagUtils.cTag("storage_blocks/dragonstone"))
    		.add(ModBlocks.dragonstone_block.get().asItem());

    } // end registerBlockItemTags()
   
    private void registerNuggetTags()
    {
        this.tag(Tags.Items.NUGGETS)
	    	.addTag(TagUtils.cTag("nuggets/argonite"))
			.addTag(TagUtils.cTag("nuggets/fyrite"))
	    	.addTag(TagUtils.cTag("nuggets/malachite"))
	    	.addTag(TagUtils.cTag("nuggets/illumenite"));

        this.tag(TagUtils.cTag("nuggets/argonite"))
    		.add(ModItems.argonite_nugget.get());
        this.tag(TagUtils.cTag("nuggets/fyrite"))
        	.add(ModItems.fyrite_nugget.get());
        this.tag(TagUtils.cTag("nuggets/malachite"))
    		.add(ModItems.malachite_nugget.get());
        this.tag(TagUtils.cTag("nuggets/illumenite"))
    		.add(ModItems.illumenite_nugget.get());
    } // end registerNuggetTags()

    
    private void registerRawMetalTags()
    {
        this.tag(Tags.Items.RAW_MATERIALS)
	    	.addTag(TagUtils.cTag("raw_materials/argonite"))
			.addTag(TagUtils.cTag("raw_materials/fyrite"))
	    	.addTag(TagUtils.cTag("raw_materials/malachite"))
	    	.addTag(TagUtils.cTag("raw_materials/illumenite"));
        
        this.tag(TagUtils.cTag("raw_materials/argonite"))
    		.add(ModItems.raw_argonite.get());
        this.tag(TagUtils.cTag("raw_materials/fyrite"))
        	.add(ModItems.raw_fyrite.get());
        this.tag(TagUtils.cTag("raw_materials/malachite"))
    		.add(ModItems.raw_malachite.get());
        this.tag(TagUtils.cTag("raw_materials/illumenite"))
    		.add(ModItems.raw_illumenite.get());
    } // end registerRawMetalTags()

    
    private void registerGemTags()
    {
        this.tag(Tags.Items.GEMS)
        	.addTag(TagUtils.cTag("gems/ashstone"));
        this.tag(TagUtils.cTag("gems/ashstone"))
        	.add(ModItems.ashstone_gem.get());
        this.tag(TagUtils.cTag("gems"))
    		.addTag(TagUtils.cTag("gems/dragonstone"));
        this.tag(TagUtils.cTag("gems/dragonstone"))
    		.add(ModItems.dragonstone_gem.get());
    }

    private void registerIngotTags()
    {
        this.tag(Tags.Items.INGOTS)
    		.addTag(TagUtils.cTag("ingots/argonite"))
        	.addTag(TagUtils.cTag("ingots/fyrite"))
        	.addTag(TagUtils.cTag("ingots/illumenite"))
        	.addTag(TagUtils.cTag("ingots/malachite"));
        
        this.tag(TagUtils.cTag("ingots/argonite"))
        	.add(ModItems.argonite_ingot.get());
        this.tag(TagUtils.cTag("ingots/fyrite"))
    		.add(ModItems.fyrite_ingot.get());
        this.tag(TagUtils.cTag("ingots/malachite"))
    		.add(ModItems.malachite_ingot.get());
        this.tag(TagUtils.cTag("ingots/illumenite"))
    		.add(ModItems.illumenite_ingot.get());
    } // end registerIngotTags()

    
    private void registerTools()
    {
    	this.tag(TagUtils.modTag(Netherrocks.MODID, "auto_smelt_tools"))
    		.add(ModItems.fyrite_axe.get())
    		.add(ModItems.fyrite_pickaxe.get())
    		.add(ModItems.fyrite_shovel.get())
    		.add(ModItems.fyrite_shears.get());
    	
    	registerToolTags(ModItems.ITEMS);
    	
    } // end registerToolTags
    
    private void registerDustTags()
    {
        this.tag(Tags.Items.DUSTS)
            .addTag(TagUtils.cTag("dusts/argonite"))
            .addTag(TagUtils.cTag("dusts/fyrite"))
            .addTag(TagUtils.cTag("dusts/illumenite"))
            .addTag(TagUtils.cTag("dusts/malachite"));
        
        this.tag(TagUtils.cTag("dusts/argonite"))
            .add(ModItems.argonite_dust.get());
        this.tag(TagUtils.cTag("dusts/fyrite"))
            .add(ModItems.fyrite_dust.get());
        this.tag(TagUtils.cTag("dusts/illumenite"))
            .add(ModItems.illumenite_dust.get());
        this.tag(TagUtils.cTag("dusts/malachite"))
            .add(ModItems.malachite_dust.get());
            
    } // end registerDustTags()
    
//    private void registerOreChunkTags()
//    {
//        this.tag(TagUtils.modTag("silents_mechanisms", "chunks"))
//            .addTag(TagUtils.modTag("silents_mechanisms", "chunks/argonite"))
//            .addTag(TagUtils.modTag("silents_mechanisms", "chunks/fyrite"))
//            .addTag(TagUtils.modTag("silents_mechanisms", "chunks/illumenite"))
//            .addTag(TagUtils.modTag("silents_mechanisms", "chunks/malachite"));
//
//        this.tag(TagUtils.modTag("silents_mechanisms", "chunks/argonite"))
//            .add(ModItems.crushed_argonite_ore.get());
//        this.tag(TagUtils.modTag("silents_mechanisms", "chunks/fyrite"))
//            .add(ModItems.crushed_fyrite_ore.get());
//        this.tag(TagUtils.modTag("silents_mechanisms", "chunks/illumenite"))
//            .add(ModItems.crushed_illumenite_ore.get());
//        this.tag(TagUtils.modTag("silents_mechanisms", "chunks/malachite"))
//            .add(ModItems.crushed_malachite_ore.get());
//
//    } // end registerOreChunkTags()
    
} // end class
