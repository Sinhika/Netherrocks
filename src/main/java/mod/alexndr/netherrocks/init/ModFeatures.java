package mod.alexndr.netherrocks.init;

import mod.alexndr.netherrocks.Netherrocks;
import mod.alexndr.netherrocks.config.NetherrocksConfig;
import mod.alexndr.netherrocks.generation.IllumeniteBlobFeature;
import mod.alexndr.simplecorelib.world.OreGenUtils;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public final class ModFeatures
{
    /** Feature<?> registry */
    public static final DeferredRegister<Feature<?>> FEATURES = 
    		DeferredRegister.create(ForgeRegistries.Keys.FEATURES, Netherrocks.MODID);

    /** illumenite blob feature */
    public static final RegistryObject<Feature<NoneFeatureConfiguration>> ILLUMENITE_FEATURE = 
            FEATURES.register("illumenite_blob", () -> new IllumeniteBlobFeature(NoneFeatureConfiguration.CODEC));

    /** ConfiguredFeature<?, ?> registry */
    public static final DeferredRegister<ConfiguredFeature<?, ?>> CONFIGURED_FEATURES =
            DeferredRegister.create(Registry.CONFIGURED_FEATURE_REGISTRY, Netherrocks.MODID);
    
    public static RegistryObject<ConfiguredFeature<OreConfiguration, ?>> ORE_ARGONITE = 
            CONFIGURED_FEATURES.register("ore_argonite", 
                    ()-> new ConfiguredFeature<>(Feature.ORE, 
                            OreGenUtils.ConfigureOreFeature(
                                    OreGenUtils.BuildNetherOreTargetList(ModBlocks.argonite_ore.get(), true), 
                                    NetherrocksConfig.argonite_cfg.getVein_size(), 0.0F)));
    
    public static RegistryObject<ConfiguredFeature<OreConfiguration, ?>> ORE_ASHSTONE;
    public static RegistryObject<ConfiguredFeature<OreConfiguration, ?>> ORE_DRAGONSTONE;
    public static RegistryObject<ConfiguredFeature<OreConfiguration, ?>> ORE_FYRITE;
    public static RegistryObject<ConfiguredFeature<OreConfiguration, ?>> ORE_FYRITE_ROCK;
    public static RegistryObject<ConfiguredFeature<NoneFeatureConfiguration, ?>>  ORE_ILLUMENITE;
    public static RegistryObject<ConfiguredFeature<OreConfiguration, ?>> ORE_MALACHITE;


    /** PlacedFeature registry */
    
} // end class
