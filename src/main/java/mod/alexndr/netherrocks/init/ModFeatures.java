package mod.alexndr.netherrocks.init;

import mod.alexndr.netherrocks.Netherrocks;
import mod.alexndr.netherrocks.generation.IllumeniteBlobFeature;
import mod.alexndr.netherrocks.generation.MagmaticBlobFeature;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.OreFeature;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public final class ModFeatures
{
//    /** Feature<?> registry */
    public static final DeferredRegister<Feature<?>> FEATURES = 
    		DeferredRegister.create(BuiltInRegistries.FEATURE, Netherrocks.MODID);

    /** illumenite blob feature */
    public static final Supplier<Feature<NoneFeatureConfiguration>> ILLUMENITE_BLOB =
            FEATURES.register("illumenite_blob",
                              () -> new IllumeniteBlobFeature(NoneFeatureConfiguration.CODEC));

    /** magmatic fyrite blob feature */
    public static final Supplier<OreFeature> MAGMATIC_BLOB =
            FEATURES.register("magmatic_blob", () -> new MagmaticBlobFeature(OreConfiguration.CODEC));

} // end class
