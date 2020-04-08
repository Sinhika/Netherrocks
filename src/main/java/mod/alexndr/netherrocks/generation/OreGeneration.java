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
import net.minecraft.world.gen.placement.CountRangeConfig;
import net.minecraft.world.gen.placement.FrequencyConfig;
import net.minecraft.world.gen.placement.Placement;
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
                                 Feature.ORE.withConfiguration(new OreFeatureConfig(
                                                                 OreFeatureConfig.FillerBlockType.NETHERRACK,
                                                                 ModBlocks.argonite_ore.get().getDefaultState(),
                                                                 argonite_veinsize))
                                 .withPlacement(Placement.COUNT_RANGE.configure(argonite_cfg)));
            }
            if (NetherrocksConfig.enableAshstoneOre)
            {
                biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES,
                                 Feature.ORE.withConfiguration(
                                		 new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NETHERRACK,
                                                              ModBlocks.ashstone_ore.get().getDefaultState(),
                                                              ashstone_veinsize))
                                 .withPlacement(Placement.COUNT_RANGE.configure(ashstone_cfg)));

            }
            if (NetherrocksConfig.enableDragonstoneOre)
            {
                biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES,
                                 Feature.ORE.withConfiguration(new OreFeatureConfig(
                                                                 OreFeatureConfig.FillerBlockType.NETHERRACK,
                                                                 ModBlocks.dragonstone_ore.get().getDefaultState(),
                                                                 dragonstone_veinsize))
                                 .withPlacement(Placement.COUNT_RANGE.configure(dragonstone_cfg)));

            }
            if (NetherrocksConfig.enableFyriteOre)
            {
                biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES,
                                Feature.ORE.withConfiguration(new OreFeatureConfig(
                                                                 OreFeatureConfig.FillerBlockType.NETHERRACK,
                                                                 ModBlocks.fyrite_ore.get().getDefaultState(),
                                                                 fyrite_veinsize))
                                .withPlacement(Placement.COUNT_RANGE.configure(fyrite_cfg)));

            }
            if (NetherrocksConfig.enableMalachiteOre)
            {
                biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES,
                                 Feature.ORE.withConfiguration(new OreFeatureConfig(
                                                        OreFeatureConfig.FillerBlockType.NETHERRACK,
                                                        ModBlocks.malachite_ore.get().getDefaultState(),
                                                                 malachite_veinsize))
                                 .withPlacement(Placement.COUNT_RANGE.configure(malachite_cfg)));

            }
            if (NetherrocksConfig.enableIllumeniteOre)
            {
                ILLUMENITE_FEATURE
                    .setRegistryName(Netherrocks.MODID, "illumenite_ore");
                biome.addFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION,
                				 ILLUMENITE_FEATURE.withConfiguration(
                						 IFeatureConfig.NO_FEATURE_CONFIG).withPlacement(
                								 Placement.LIGHT_GEM_CHANCE.configure(
                										 new FrequencyConfig(illumenite_veinsize))));
                biome.addFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION,
                				 ILLUMENITE_FEATURE.withConfiguration(
                						 IFeatureConfig.NO_FEATURE_CONFIG).withPlacement(
                                                 	Placement.COUNT_RANGE.configure(illumenite_cfg)));
            }
        } // end-for biome in Category.NETHER
    } // end setupNetherOreGen()

}  // end class OreGeneration
