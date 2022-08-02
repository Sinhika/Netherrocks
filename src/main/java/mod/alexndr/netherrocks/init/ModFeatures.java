package mod.alexndr.netherrocks.init;

import mod.alexndr.netherrocks.Netherrocks;
import mod.alexndr.netherrocks.generation.IllumeniteBlobFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public final class ModFeatures
{
//    /** Feature<?> registry */
    public static final DeferredRegister<Feature<?>> FEATURES = 
    		DeferredRegister.create(ForgeRegistries.Keys.FEATURES, Netherrocks.MODID);

    /** illumenite blob feature */
    public static final RegistryObject<Feature<NoneFeatureConfiguration>> ILLUMENITE_BLOB = 
            FEATURES.register("illumenite_blob", () -> new IllumeniteBlobFeature(NoneFeatureConfiguration.CODEC));

} // end class
