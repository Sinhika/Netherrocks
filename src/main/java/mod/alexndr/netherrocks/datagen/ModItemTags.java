package mod.alexndr.netherrocks.datagen;

import mod.alexndr.netherrocks.Netherrocks;
import mod.alexndr.netherrocks.init.ModBlocks;
import mod.alexndr.netherrocks.init.ModItems;
import mod.alexndr.simplecorelib.helpers.TagUtils;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ModItemTags extends ItemTagsProvider
{

    public ModItemTags(DataGenerator dataGenerator, ExistingFileHelper existingFileHelper)
    {
        super(dataGenerator, new ModBlockTags(dataGenerator, existingFileHelper), 
                              Netherrocks.MODID, existingFileHelper);
    }
    
    @Override
    protected void addTags()
    {
        registerDustTags();
        registerOreChunkTags();
        registerToolTags();
        registerDoorsSlabsAndStairs();
    }

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
