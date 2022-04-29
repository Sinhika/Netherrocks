package mod.alexndr.netherrocks.datagen;

import mod.alexndr.netherrocks.Netherrocks;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class NetherrocksItemModelProvider extends ItemModelProvider
{

    public NetherrocksItemModelProvider(DataGenerator generator, ExistingFileHelper existingFileHelper)
    {
        super(generator, Netherrocks.MODID, existingFileHelper);
        // TODO Auto-generated constructor stub
    }

    @Override
    protected void registerModels()
    {
        ResourceLocation shears_parent = new ResourceLocation("shears");
        
        this.singleTexture("argonite_shears", shears_parent, 
                new ResourceLocation(Netherrocks.MODID, "item/argonite_shears"));
        this.singleTexture("ashstone_shears", shears_parent, 
                new ResourceLocation(Netherrocks.MODID, "item/ashstone_shears"));
        this.singleTexture("dragonstone_shears", shears_parent, 
                new ResourceLocation(Netherrocks.MODID, "item/dragonstone_shears"));
        this.singleTexture("fyrite_shears", shears_parent, 
                new ResourceLocation(Netherrocks.MODID, "item/fyrite_shears"));
        this.singleTexture("malachite_shears", shears_parent, 
                new ResourceLocation(Netherrocks.MODID, "item/malachite_shears"));
    }

} // end class
