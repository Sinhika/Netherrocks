package mod.alexndr.netherrocks.datagen;

import mod.alexndr.netherrocks.Netherrocks;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

public class NetherrocksItemModelProvider extends ItemModelProvider
{

    public NetherrocksItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper)
    {
        super(output, Netherrocks.MODID, existingFileHelper);
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
        this.withExistingParent("dragonstone_upgrade_smithing_template", "generated")
            .texture("layer0", new ResourceLocation(Netherrocks.MODID, "item/dragonstone_upgrade_smithing_template"));
    }

} // end class
