package mod.alexndr.netherrocks.init;

import java.util.List;

import mod.alexndr.netherrocks.Netherrocks;
import mod.alexndr.netherrocks.config.NetherrocksConfig;
import mod.alexndr.netherrocks.generation.IllumeniteBlobFeature;
import mod.alexndr.simplecorelib.api.helpers.OreGenUtils;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.util.valueproviders.BiasedToBottomInt;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.placement.BiomeFilter;
import net.minecraft.world.level.levelgen.placement.CountPlacement;
import net.minecraft.world.level.levelgen.placement.InSquarePlacement;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockMatchTest;
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
                    ()->OreGenUtils.createConfiguredOreFeature(
                            OreGenUtils.BuildNetherOreTargetList(ModBlocks.argonite_ore.get(), true), 
                            NetherrocksConfig.argonite_cfg));
    
    public static RegistryObject<ConfiguredFeature<OreConfiguration, ?>> ORE_ASHSTONE = 
            CONFIGURED_FEATURES.register("ore_ashstone", 
                    ()->OreGenUtils.createConfiguredOreFeature(
                            OreGenUtils.BuildNetherOreTargetList(ModBlocks.ashstone_ore.get(), false), 
                            NetherrocksConfig.ashstone_cfg));
                            
    public static RegistryObject<ConfiguredFeature<OreConfiguration, ?>> ORE_DRAGONSTONE = 
            CONFIGURED_FEATURES.register("ore_dragonstone", 
                    ()->OreGenUtils.createConfiguredOreFeature(
                            OreGenUtils.BuildNetherOreTargetList(ModBlocks.dragonstone_ore.get(), false), 
                            NetherrocksConfig.dragonstone_cfg));
    
    public static RegistryObject<ConfiguredFeature<OreConfiguration, ?>> ORE_FYRITE = 
            CONFIGURED_FEATURES.register("ore_fyrite", 
                    ()->OreGenUtils.createConfiguredOreFeature(
                            OreGenUtils.BuildNetherOreTargetList(ModBlocks.fyrite_ore.get(), true), 
                            NetherrocksConfig.fyrite_cfg));
    
    public static RegistryObject<ConfiguredFeature<OreConfiguration, ?>> ORE_FYRITE_ROCK = 
            CONFIGURED_FEATURES.register("ore_fyrite", 
                    ()->OreGenUtils.createConfiguredOreFeature(
                            List.of(OreConfiguration.target(new BlockMatchTest(Blocks.MAGMA_BLOCK), 
                                                            ModBlocks.fyrite_ore.get().defaultBlockState())), 
                            NetherrocksConfig.fyrite_cfg));
    
    public static RegistryObject<ConfiguredFeature<OreConfiguration, ?>> ORE_MALACHITE = 
            CONFIGURED_FEATURES.register("ore_malachite", 
                    ()->OreGenUtils.createConfiguredOreFeature(
                            OreGenUtils.BuildNetherOreTargetList(ModBlocks.malachite_ore.get(), true), 
                            NetherrocksConfig.malachite_cfg));
    
    public static RegistryObject<ConfiguredFeature<NoneFeatureConfiguration, ?>>  ORE_ILLUMENITE =
            CONFIGURED_FEATURES.register("ore_illumenite", 
                    ()->new ConfiguredFeature<>(ILLUMENITE_FEATURE.get(), FeatureConfiguration.NONE));


    /** PlacedFeature registry */
    public static final DeferredRegister<PlacedFeature> PLACED_FEATURES =
            DeferredRegister.create(Registry.PLACED_FEATURE_REGISTRY, Netherrocks.MODID);
    
    public static RegistryObject<PlacedFeature> ARGONITE_VEIN = 
            PLACED_FEATURES.register("argonite_vein", 
                    ()->OreGenUtils.createPlacedOreFeature(ORE_ARGONITE.getHolder().get(),NetherrocksConfig.argonite_cfg));

    public static RegistryObject<PlacedFeature> ASHSTONE_VEIN = 
            PLACED_FEATURES.register("ashstone_vein", 
                    ()->OreGenUtils.createPlacedOreFeature(ORE_ASHSTONE.getHolder().get(),NetherrocksConfig.ashstone_cfg));
    
    public static RegistryObject<PlacedFeature> DRAGONSTONE_VEIN = 
            PLACED_FEATURES.register("dragonstone_vein", 
                    ()->OreGenUtils.createPlacedOreFeature(ORE_DRAGONSTONE.getHolder().get(),NetherrocksConfig.dragonstone_cfg));
    
    public static RegistryObject<PlacedFeature> FYRITE_VEIN = 
            PLACED_FEATURES.register("fyrite_vein", 
                    ()->OreGenUtils.createPlacedOreFeature(ORE_FYRITE.getHolder().get(),NetherrocksConfig.fyrite_cfg));
    
    public static RegistryObject<PlacedFeature> FYRITE_IN_MAGMA= 
            PLACED_FEATURES.register("fyrite_vein", 
                    ()->OreGenUtils.createPlacedOreFeature(ORE_FYRITE_ROCK.getHolder().get(),NetherrocksConfig.fyrite_cfg));

    public static RegistryObject<PlacedFeature> MALACHITE_VEIN = 
            PLACED_FEATURES.register("malachite_vein", 
                    ()->OreGenUtils.createPlacedOreFeature(ORE_MALACHITE.getHolder().get(),NetherrocksConfig.malachite_cfg));
    
    public static RegistryObject<PlacedFeature> ILLUMENITE_CLUSTER = 
            PLACED_FEATURES.register("illumenite_cluster",
                    ()->new PlacedFeature(Holder.hackyErase(ORE_ILLUMENITE.getHolder().get()), 
                            List.of(CountPlacement.of(NetherrocksConfig.illumenite_cfg.get().getVein_size()), 
                            InSquarePlacement.spread(), PlacementUtils.FULL_RANGE, BiomeFilter.biome())));
            
    public static RegistryObject<PlacedFeature> ILLUMENITE_CLUSTER_EXTRA =
            PLACED_FEATURES.register("illumenite_cluster_extra",
                    ()->new PlacedFeature(Holder.hackyErase(ORE_ILLUMENITE.getHolder().get()),
                            List.of(CountPlacement.of(BiasedToBottomInt.of(0,NetherrocksConfig.illumenite_cfg.get().getVein_count())),
                            InSquarePlacement.spread(), PlacementUtils.RANGE_4_4, BiomeFilter.biome())));
    
} // end class
