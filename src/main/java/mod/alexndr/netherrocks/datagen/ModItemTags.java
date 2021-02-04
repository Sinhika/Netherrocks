package mod.alexndr.netherrocks.datagen;

import mod.alexndr.netherrocks.Netherrocks;
import mod.alexndr.netherrocks.init.ModItems;
import mod.alexndr.simplecorelib.helpers.TagUtils;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.ItemTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ModItemTags extends ItemTagsProvider
{

    public ModItemTags(DataGenerator dataGenerator, ExistingFileHelper existingFileHelper)
    {
        super(dataGenerator, new ModBlockTags(dataGenerator, existingFileHelper), 
                              Netherrocks.MODID, existingFileHelper);
    }
    
    @Override
    protected void registerTags()
    {
        registerDustTags();
        registerOreChunkTags();
    }

    private void registerDustTags()
    {
        this.getOrCreateBuilder(TagUtils.forgeTag("dusts"))
            .addTag(TagUtils.forgeTag("dusts/argonite"))
            .addTag(TagUtils.forgeTag("dusts/fyrite"))
            .addTag(TagUtils.forgeTag("dusts/illumenite"))
            .addTag(TagUtils.forgeTag("dusts/malachite"));
        
        this.getOrCreateBuilder(TagUtils.forgeTag("dusts/argonite"))
            .add(ModItems.argonite_dust.get());
        this.getOrCreateBuilder(TagUtils.forgeTag("dusts/fyrite"))
            .add(ModItems.fyrite_dust.get());
        this.getOrCreateBuilder(TagUtils.forgeTag("dusts/illumenite"))
            .add(ModItems.illumenite_dust.get());
        this.getOrCreateBuilder(TagUtils.forgeTag("dusts/malachite"))
            .add(ModItems.malachite_dust.get());
            
    } // end registerDustTags()
    
    private void registerOreChunkTags()
    {
        this.getOrCreateBuilder(TagUtils.modTag("silents_mechanisms", "chunks"))
            .addTag(TagUtils.modTag("silents_mechanisms", "chunks/argonite"))
            .addTag(TagUtils.modTag("silents_mechanisms", "chunks/fyrite"))
            .addTag(TagUtils.modTag("silents_mechanisms", "chunks/illumenite"))
            .addTag(TagUtils.modTag("silents_mechanisms", "chunks/malachite"));
        
        this.getOrCreateBuilder(TagUtils.modTag("silents_mechanisms", "chunks/argonite"))
            .add(ModItems.crushed_argonite_ore.get());
        this.getOrCreateBuilder(TagUtils.modTag("silents_mechanisms", "chunks/fyrite"))
            .add(ModItems.crushed_fyrite_ore.get());
        this.getOrCreateBuilder(TagUtils.modTag("silents_mechanisms", "chunks/illumenite"))
            .add(ModItems.crushed_illumenite_ore.get());
        this.getOrCreateBuilder(TagUtils.modTag("silents_mechanisms", "chunks/malachite"))
            .add(ModItems.crushed_malachite_ore.get());
        
    } // end registerOreChunkTags()
    
} // end class
