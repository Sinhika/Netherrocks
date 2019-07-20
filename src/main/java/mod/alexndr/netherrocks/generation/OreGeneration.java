package mod.alexndr.netherrocks.generation;

import mod.alexndr.netherrocks.Netherrocks;
import mod.alexndr.netherrocks.config.NetherrocksConfig;
import mod.alexndr.netherrocks.init.ModBlocks;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biomes;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.placement.*;
import net.minecraftforge.registries.ForgeRegistries;

/**
 * Ore generation master-class for SimpleOres.
 */
public class OreGeneration
{
    // Vein/Chunk Count, MinHeight, MaxHeightBase, MaxHeight
    private static final CountRangeConfig argonite_cfg = new CountRangeConfig(10, 0, 0, 128);
    private static final int argonite_veinsize = 6;
    private static final CountRangeConfig ashstone_cfg = new CountRangeConfig(10, 0, 0, 128);
    private static final int ashstone_veinsize = 5;
    private static final CountRangeConfig dragonstone_cfg = new CountRangeConfig(7, 0, 0, 128);
    private static final int dragonstone_veinsize = 5;
    private static final CountRangeConfig fyrite_cfg = new CountRangeConfig(10, 0, 0, 128);
    private static final int fyrite_veinsize = 6;
    private static final CountRangeConfig malachite_cfg = new CountRangeConfig(10, 0, 0, 128);
    private static final int malachite_veinsize = 7;

    private static final CountRangeConfig illumenite_cfg = new CountRangeConfig(5, 0, 0, 128);
    private static final int illumenite_veinsize = 15;
    private static final Feature<NoFeatureConfig> ILLUMENITE_FEATURE = new IllumeniteBlobFeature(NoFeatureConfig::deserialize);

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
                                                             new OreFeatureConfig(
                                                                 OreFeatureConfig.FillerBlockType.NETHERRACK,
                                                                 ModBlocks.argonite_ore
                                                                     .getDefaultState(),
                                                                 argonite_veinsize),
                                                             Placement.COUNT_RANGE,
                                                             argonite_cfg));
            }
            if (NetherrocksConfig.enableAshstoneOre)
            {
                biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES,
                                Biome.createDecoratedFeature(Feature.ORE,
                                                             new OreFeatureConfig(
                                                                 OreFeatureConfig.FillerBlockType.NETHERRACK,
                                                                 ModBlocks.ashstone_ore
                                                                     .getDefaultState(),
                                                                 ashstone_veinsize),
                                                             Placement.COUNT_RANGE,
                                                             ashstone_cfg));

            }
            if (NetherrocksConfig.enableDragonstoneOre)
            {
                biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES,
                                Biome.createDecoratedFeature(Feature.ORE,
                                                             new OreFeatureConfig(
                                                                 OreFeatureConfig.FillerBlockType.NETHERRACK,
                                                                 ModBlocks.dragonstone_ore
                                                                     .getDefaultState(),
                                                                 dragonstone_veinsize),
                                                             Placement.COUNT_RANGE,
                                                             dragonstone_cfg));

            }
            if (NetherrocksConfig.enableFyriteOre)
            {
                biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES,
                                Biome.createDecoratedFeature(Feature.ORE,
                                                             new OreFeatureConfig(
                                                                 OreFeatureConfig.FillerBlockType.NETHERRACK,
                                                                 ModBlocks.fyrite_ore
                                                                     .getDefaultState(),
                                                                 fyrite_veinsize),
                                                             Placement.COUNT_RANGE,
                                                             fyrite_cfg));

            }
            if (NetherrocksConfig.enableMalachiteOre)
            {
                biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES,
                                Biome.createDecoratedFeature(Feature.ORE,
                                                             new OreFeatureConfig(
                                                                 OreFeatureConfig.FillerBlockType.NETHERRACK,
                                                                 ModBlocks.malachite_ore
                                                                     .getDefaultState(),
                                                                 malachite_veinsize),
                                                             Placement.COUNT_RANGE,
                                                             malachite_cfg));

            }
            if (NetherrocksConfig.enableIllumeniteOre)
            {
                ILLUMENITE_FEATURE
                    .setRegistryName(Netherrocks.MODID, "illumenite_ore");
                biome.addFeature(
                    GenerationStage.Decoration.UNDERGROUND_DECORATION,
                    Biome.createDecoratedFeature(ILLUMENITE_FEATURE,
                                                 IFeatureConfig.NO_FEATURE_CONFIG,
                                                 Placement.LIGHT_GEM_CHANCE,
                                                 new FrequencyConfig(
                                                     illumenite_veinsize)));
                biome.addFeature(
                    GenerationStage.Decoration.UNDERGROUND_DECORATION,
                    Biome.createDecoratedFeature(ILLUMENITE_FEATURE,
                                                 IFeatureConfig.NO_FEATURE_CONFIG,
                                                 Placement.COUNT_RANGE,
                                                 illumenite_cfg));
            }
        } // end-for biome in Category.NETHER
    } // end setupNetherOreGen()

}  // end class OreGeneration
