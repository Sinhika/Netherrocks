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
//
//    /** ConfiguredFeature<?, ?> registry */
//    public static final DeferredRegister<ConfiguredFeature<?, ?>> CONFIGURED_FEATURES =
//            DeferredRegister.create(Registry.CONFIGURED_FEATURE_REGISTRY, Netherrocks.MODID);
//    
//    public static RegistryObject<ConfiguredFeature<OreConfiguration, ?>> ORE_GHAST = 
//            CONFIGURED_FEATURES.register("ore_ghast", 
//                    ()->OreGenUtils.createConfiguredOreFeature(
//                            OreGenUtils.BuildNetherOreTargetList(ModBlocks.ghast_ore.get(), false), 
//                            NetherrocksConfig.ashstone_cfg));
//                          
//    /** PlacedFeature registry */
//    public static final DeferredRegister<PlacedFeature> PLACED_FEATURES =
//            DeferredRegister.create(Registry.PLACED_FEATURE_REGISTRY, Netherrocks.MODID);
//    
//    public static RegistryObject<PlacedFeature> GHAST_ORE_VEIN = 
//            PLACED_FEATURES.register("ghast_ore_vein", 
//                    ()->OreGenUtils.createPlacedOreFeature(ORE_GHAST.getHolder().get(), NetherrocksConfig.ashstone_cfg));
//    
            
} // end class
