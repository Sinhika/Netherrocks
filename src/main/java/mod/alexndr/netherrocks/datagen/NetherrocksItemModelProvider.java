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
        this.withExistingParent("argonite_shears", "handheld")
            .texture("layer0", new ResourceLocation(Netherrocks.MODID, "item/argonite_shears"));
        this.withExistingParent("ashstone_shears", "handheld") 
            .texture("layer0", new ResourceLocation(Netherrocks.MODID, "item/ashstone_shears"));
        this.withExistingParent("dragonstone_shears", "handheld") 
            .texture("layer0",  new ResourceLocation(Netherrocks.MODID, "item/dragonstone_shears"));
        this.withExistingParent("fyrite_shears", "handheld")
            .texture("layer0", new ResourceLocation(Netherrocks.MODID, "item/fyrite_shears"));
        this.withExistingParent("malachite_shears", "handheld") 
            .texture("layer0", new ResourceLocation(Netherrocks.MODID, "item/malachite_shears"));
    }

} // end class
