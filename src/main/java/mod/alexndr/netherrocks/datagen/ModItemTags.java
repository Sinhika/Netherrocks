package mod.alexndr.netherrocks.datagen;

import java.util.List;

import mod.alexndr.netherrocks.Netherrocks;
import mod.alexndr.netherrocks.init.ModBlocks;
import mod.alexndr.netherrocks.init.ModItems;
import mod.alexndr.simplecorelib.datagen.MiningItemTags;
import mod.alexndr.simplecorelib.helpers.TagUtils;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ModItemTags extends MiningItemTags
{

    public ModItemTags(DataGenerator dataGenerator, ExistingFileHelper existingFileHelper)
    {
        super(dataGenerator, new ModBlockTags(dataGenerator, existingFileHelper), 
                              Netherrocks.MODID, existingFileHelper);
    }
    
    @Override
    protected void addTags()
    {
    	super.addTags();
    	registerNuggetTags();
    	registerIngotTags();
    	registerRawMetalTags();
    	registerGemTags();
        registerDustTags();
        registerOreChunkTags();
        registerToolTags();
        registerDoorsSlabsAndStairs();
    	registerBlockItemTags();
    }

    
    protected void registerOreTags()
    {
    	// register "forge:ores" tags
        this.tag(TagUtils.forgeTag( "ores"))
                .addTag(TagUtils.forgeTag( "ores/argonite"))
                .addTag(TagUtils.forgeTag( "ores/ashstone"))
                .addTag(TagUtils.forgeTag( "ores/dragonstone"))
                .addTag(TagUtils.forgeTag( "ores/fyrite"))
                .addTag(TagUtils.forgeTag( "ores/illumenite"))
                .addTag(TagUtils.forgeTag( "ores/malachite"));

        this.tag(TagUtils.forgeTag( "ores/argonite"))
                .add(ModBlocks.argonite_ore.get().asItem());
        this.tag(TagUtils.forgeTag( "ores/ashstone"))
        	.add(ModBlocks.ashstone_ore.get().asItem());
        this.tag(TagUtils.forgeTag( "ores/dragonstone"))
        	.add(ModBlocks.dragonstone_ore.get().asItem());
        this.tag(TagUtils.forgeTag( "ores/fyrite"))
        	.add(ModBlocks.fyrite_ore.get().asItem());
        this.tag(TagUtils.forgeTag( "ores/illumenite"))
        	.add(ModBlocks.illumenite_ore.get().asItem());
        this.tag(TagUtils.forgeTag( "ores/malachite"))
        	.add(ModBlocks.malachite_ore.get().asItem());

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
    	this.tag(TagUtils.modTag("minecraft", "doors"))
    		.add(ModBlocks.argonite_door.get().asItem())
    		.add(ModBlocks.ashstone_door.get().asItem())
    		.add(ModBlocks.dragonstone_door.get().asItem())
    		.add(ModBlocks.fyrite_door.get().asItem())
    		.add(ModBlocks.illumenite_door.get().asItem())
    		.add(ModBlocks.malachite_door.get().asItem());
    	this.tag(TagUtils.modTag("minecraft","stairs"))
			.add(ModBlocks.argonite_brick_stairs.get().asItem())
			.add(ModBlocks.ashstone_brick_stairs.get().asItem())
			.add(ModBlocks.dragonstone_brick_stairs.get().asItem())
			.add(ModBlocks.fyrite_brick_stairs.get().asItem())
			.add(ModBlocks.illumenite_brick_stairs.get().asItem())
			.add(ModBlocks.malachite_brick_stairs.get().asItem());
    	this.tag(TagUtils.modTag("minecraft","slabs"))
			.add(ModBlocks.argonite_brick_slab.get().asItem())
			.add(ModBlocks.ashstone_brick_slab.get().asItem())
			.add(ModBlocks.dragonstone_brick_slab.get().asItem())
			.add(ModBlocks.fyrite_brick_slab.get().asItem())
			.add(ModBlocks.illumenite_brick_slab.get().asItem())
			.add(ModBlocks.malachite_brick_slab.get().asItem());
    }

    private void registerBlockItemTags()
    {
        this.tag(TagUtils.forgeTag("storage_blocks"))
	        .addTag(TagUtils.forgeTag("storage_blocks/malachite"))
	        .addTag(TagUtils.forgeTag("storage_blocks/fyrite"))
	        .addTag(TagUtils.forgeTag("storage_blocks/argonite"))
	        .addTag(TagUtils.forgeTag("storage_blocks/ashstone"))
	        .addTag(TagUtils.forgeTag("storage_blocks/dragonstone"))
	        .addTag(TagUtils.forgeTag("storage_blocks/illumenite"))
	        .addTag(TagUtils.forgeTag("storage_blocks/raw_malachite"))
	        .addTag(TagUtils.forgeTag("storage_blocks/raw_fyrite"))
	        .addTag(TagUtils.forgeTag("storage_blocks/raw_illumenite"))
	        .addTag(TagUtils.forgeTag("storage_blocks/raw_argonite"));
    
        
        this.tag(TagUtils.forgeTag("storage_blocks/raw_argonite"))
    		.add(ModBlocks.raw_argonite_block.get().asItem());
        this.tag(TagUtils.forgeTag("storage_blocks/raw_fyrite"))
    		.add(ModBlocks.raw_fyrite_block.get().asItem());
        this.tag(TagUtils.forgeTag("storage_blocks/raw_malachite"))
    		.add(ModBlocks.raw_malachite_block.get().asItem());
        this.tag(TagUtils.forgeTag("storage_blocks/raw_illumenite"))
    		.add(ModBlocks.raw_illumenite_block.get().asItem());

        this.tag(TagUtils.forgeTag("storage_blocks/argonite"))
    		.add(ModBlocks.argonite_block.get().asItem());
        this.tag(TagUtils.forgeTag("storage_blocks/fyrite"))
    		.add(ModBlocks.fyrite_block.get().asItem());
        this.tag(TagUtils.forgeTag("storage_blocks/malachite"))
    		.add(ModBlocks.malachite_block.get().asItem());
        this.tag(TagUtils.forgeTag("storage_blocks/illumenite"))
    		.add(ModBlocks.illumenite_block.get().asItem());
        this.tag(TagUtils.forgeTag("storage_blocks/ashstone"))
    		.add(ModBlocks.ashstone_block.get().asItem());
        this.tag(TagUtils.forgeTag("storage_blocks/dragonstone"))
    		.add(ModBlocks.dragonstone_block.get().asItem());

    } // end registerBlockItemTags()
   
    private void registerNuggetTags()
    {
        this.tag(TagUtils.forgeTag("nuggets"))
	    	.addTag(TagUtils.forgeTag("nuggets/argonite"))
			.addTag(TagUtils.forgeTag("nuggets/fyrite"))
	    	.addTag(TagUtils.forgeTag("nuggets/malachite"))
	    	.addTag(TagUtils.forgeTag("nuggets/illumenite"));

        this.tag(TagUtils.forgeTag("nuggets/argonite"))
    		.add(ModItems.argonite_nugget.get());
        this.tag(TagUtils.forgeTag("nuggets/fyrite"))
        	.add(ModItems.fyrite_nugget.get());
        this.tag(TagUtils.forgeTag("nuggets/malachite"))
    		.add(ModItems.malachite_nugget.get());
        this.tag(TagUtils.forgeTag("nuggets/illumenite"))
    		.add(ModItems.illumenite_nugget.get());
    } // end registerNuggetTags()

    
    private void registerRawMetalTags()
    {
        this.tag(TagUtils.forgeTag("raw_metals"))
	    	.addTag(TagUtils.forgeTag("raw_metals/argonite"))
			.addTag(TagUtils.forgeTag("raw_metals/fyrite"))
	    	.addTag(TagUtils.forgeTag("raw_metals/malachite"))
	    	.addTag(TagUtils.forgeTag("raw_metals/illumenite"));
        
        this.tag(TagUtils.forgeTag("raw_metals/argonite"))
    		.add(ModItems.raw_argonite.get());
        this.tag(TagUtils.forgeTag("raw_metals/fyrite"))
        	.add(ModItems.raw_fyrite.get());
        this.tag(TagUtils.forgeTag("raw_metals/malachite"))
    		.add(ModItems.raw_malachite.get());
        this.tag(TagUtils.forgeTag("raw_metals/illumenite"))
    		.add(ModItems.raw_illumenite.get());
    } // end registerRawMetalTags()

    
    private void registerGemTags()
    {
        this.tag(TagUtils.forgeTag("gems"))
        	.addTag(TagUtils.forgeTag("gems/ashstone"));
        this.tag(TagUtils.forgeTag("gems/ashstone"))
        	.add(ModItems.ashstone_gem.get());
        this.tag(TagUtils.forgeTag("gems"))
    		.addTag(TagUtils.forgeTag("gems/dragonstone"));
        this.tag(TagUtils.forgeTag("gems/dragonstone"))
    		.add(ModItems.dragonstone_gem.get());
    }

    private void registerIngotTags()
    {
        this.tag(TagUtils.forgeTag("ingots"))
    		.addTag(TagUtils.forgeTag("ingots/argonite"))
        	.addTag(TagUtils.forgeTag("ingots/fyrite"))
        	.addTag(TagUtils.forgeTag("ingots/illumenite"))
        	.addTag(TagUtils.forgeTag("ingots/malachite"));
        
        this.tag(TagUtils.forgeTag("ingots/argonite"))
        	.add(ModItems.argonite_ingot.get());
        this.tag(TagUtils.forgeTag("ingots/fyrite"))
    		.add(ModItems.fyrite_ingot.get());
        this.tag(TagUtils.forgeTag("ingots/malachite"))
    		.add(ModItems.malachite_ingot.get());
        this.tag(TagUtils.forgeTag("ingots/illumenite"))
    		.add(ModItems.illumenite_ingot.get());
    } // end registerIngotTags()

    
    private void registerToolTags()
    {
    	this.tag(TagUtils.modTag(Netherrocks.MODID, "auto_smelt_tools"))
    		.add(ModItems.fyrite_axe.get())
    		.add(ModItems.fyrite_pickaxe.get())
    		.add(ModItems.fyrite_shovel.get());
    }
    
    private void registerDustTags()
    {
        this.tag(TagUtils.forgeTag("dusts"))
            .addTag(TagUtils.forgeTag("dusts/argonite"))
            .addTag(TagUtils.forgeTag("dusts/fyrite"))
            .addTag(TagUtils.forgeTag("dusts/illumenite"))
            .addTag(TagUtils.forgeTag("dusts/malachite"));
        
        this.tag(TagUtils.forgeTag("dusts/argonite"))
            .add(ModItems.argonite_dust.get());
        this.tag(TagUtils.forgeTag("dusts/fyrite"))
            .add(ModItems.fyrite_dust.get());
        this.tag(TagUtils.forgeTag("dusts/illumenite"))
            .add(ModItems.illumenite_dust.get());
        this.tag(TagUtils.forgeTag("dusts/malachite"))
            .add(ModItems.malachite_dust.get());
            
    } // end registerDustTags()
    
    private void registerOreChunkTags()
    {
        this.tag(TagUtils.modTag("silents_mechanisms", "chunks"))
            .addTag(TagUtils.modTag("silents_mechanisms", "chunks/argonite"))
            .addTag(TagUtils.modTag("silents_mechanisms", "chunks/fyrite"))
            .addTag(TagUtils.modTag("silents_mechanisms", "chunks/illumenite"))
            .addTag(TagUtils.modTag("silents_mechanisms", "chunks/malachite"));
        
        this.tag(TagUtils.modTag("silents_mechanisms", "chunks/argonite"))
            .add(ModItems.crushed_argonite_ore.get());
        this.tag(TagUtils.modTag("silents_mechanisms", "chunks/fyrite"))
            .add(ModItems.crushed_fyrite_ore.get());
        this.tag(TagUtils.modTag("silents_mechanisms", "chunks/illumenite"))
            .add(ModItems.crushed_illumenite_ore.get());
        this.tag(TagUtils.modTag("silents_mechanisms", "chunks/malachite"))
            .add(ModItems.crushed_malachite_ore.get());
        
    } // end registerOreChunkTags()
    
} // end class
