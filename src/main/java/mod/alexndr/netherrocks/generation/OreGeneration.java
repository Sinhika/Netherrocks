package mod.alexndr.netherrocks.generation;

import mod.alexndr.netherrocks.Netherrocks;
import mod.alexndr.netherrocks.config.NetherrocksConfig;
import mod.alexndr.netherrocks.init.ModBlocks;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.placement.FrequencyConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraftforge.registries.ForgeRegistries;

/**
 * Ore generation master-class for SimpleOres.
 */
public class OreGeneration
{
    private static final Feature<NoFeatureConfig> ILLUMENITE_FEATURE = 
            new IllumeniteBlobFeature(NoFeatureConfig::deserialize);

    /**
     * called in setup to generate Nether ores.
     */
    public static void setupNetherOreGen()
    {
        for (Biome biome: ForgeRegistries.BIOMES.getValues())
        {
            // Nether Ore generation.
            if (biome.getCategory() != Biome.Category.NETHER) continue;

            if (NetherrocksConfig.enableArgoniteOre)
            {
				biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, 
						Biome.createDecoratedFeature(Feature.ORE,
						new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NETHERRACK,
								ModBlocks.argonite_ore.get().getDefaultState(), 
								NetherrocksConfig.argonite_veinsize),
						Placement.COUNT_RANGE, NetherrocksConfig.argonite_cfg));
            }
            if (NetherrocksConfig.enableAshstoneOre)
            {
				biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, 
						Biome.createDecoratedFeature(Feature.ORE,
						new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NETHERRACK,
								ModBlocks.ashstone_ore.get().getDefaultState(), 
								NetherrocksConfig.ashstone_veinsize),
						Placement.COUNT_RANGE, NetherrocksConfig.ashstone_cfg));

            }
            if (NetherrocksConfig.enableDragonstoneOre)
            {
				biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, 
						Biome.createDecoratedFeature(Feature.ORE,
						new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NETHERRACK,
								ModBlocks.dragonstone_ore.get().getDefaultState(), 
								NetherrocksConfig.dragonstone_veinsize),
						Placement.COUNT_RANGE, NetherrocksConfig.dragonstone_cfg));
            }
            if (NetherrocksConfig.enableFyriteOre)
            {
				biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, 
						Biome.createDecoratedFeature(Feature.ORE,
						new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NETHERRACK,
								ModBlocks.fyrite_ore.get().getDefaultState(), 
								NetherrocksConfig.fyrite_veinsize),
						Placement.COUNT_RANGE, NetherrocksConfig.fyrite_cfg));
            }
            if (NetherrocksConfig.enableMalachiteOre)
            {
				biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, 
						Biome.createDecoratedFeature(Feature.ORE,
						new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NETHERRACK,
								ModBlocks.malachite_ore.get().getDefaultState(), 
								NetherrocksConfig.malachite_veinsize),
						Placement.COUNT_RANGE, NetherrocksConfig.malachite_cfg));
            }
            if (NetherrocksConfig.enableIllumeniteOre)
            {
                ILLUMENITE_FEATURE.setRegistryName(Netherrocks.MODID, "illumenite_ore");
                Biome.createDecoratedFeature(ILLUMENITE_FEATURE, IFeatureConfig.NO_FEATURE_CONFIG,
                        Placement.LIGHT_GEM_CHANCE,
                        new FrequencyConfig(NetherrocksConfig.illumenite_veinsize));
				biome.addFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION,
						Biome.createDecoratedFeature(ILLUMENITE_FEATURE, IFeatureConfig.NO_FEATURE_CONFIG,
								Placement.COUNT_RANGE, NetherrocksConfig.illumenite_cfg));
            }
        } // end-for biome in Category.NETHER
    } // end setupNetherOreGen()

}  // end class OreGeneration
