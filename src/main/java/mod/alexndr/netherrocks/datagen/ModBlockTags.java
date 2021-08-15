package mod.alexndr.netherrocks.datagen;

import mod.alexndr.netherrocks.Netherrocks;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ModBlockTags extends BlockTagsProvider
{

    public ModBlockTags(DataGenerator generatorIn, ExistingFileHelper existingFileHelper)
    {
        super(generatorIn, Netherrocks.MODID, existingFileHelper);
    }

    @Override
    protected void addTags()
    {
        // do nothing; super() generates all the vanilla blocktags, and we don't want that.
    }

    
} // end class
