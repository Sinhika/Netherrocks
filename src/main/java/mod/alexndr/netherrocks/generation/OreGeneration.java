package mod.alexndr.netherrocks.generation;

import mod.alexndr.netherrocks.config.NetherrocksConfig;
import mod.alexndr.netherrocks.init.ModBlocks;
import net.minecraft.block.Blocks;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biomes;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.feature.ReplaceBlockConfig;
import net.minecraft.world.gen.placement.CountRangeConfig;
import net.minecraft.world.gen.placement.Placement;

/**
 * Ore generation master-class for SimpleOres.
 */
public class OreGeneration
{
    // Vein/Chunk Count, MinHeight, MaxHeightBase, MaxHeight
    // TODO
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

    private static final CountRangeConfig illumenite_cfg = new CountRangeConfig(350, 1, 0, 128);
    private static final int illumenite_veinsize = 15;
    /**
     * called in setup to generate Nether ores.
     */
    public static void setupNetherOreGen()
    {
        if (NetherrocksConfig.enableArgoniteOre)
        {
            Biomes.NETHER.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES,
                    Biome.createDecoratedFeature(Feature.ORE,
                            new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NETHERRACK,
                                                 ModBlocks.argonite_ore.getDefaultState(), argonite_veinsize),
                                     Placement.COUNT_RANGE, argonite_cfg));
        }
        if (NetherrocksConfig.enableAshstoneOre)
        {
            Biomes.NETHER.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES,
                 Biome.createDecoratedFeature(Feature.ORE,
                        new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NETHERRACK,
                                             ModBlocks.ashstone_ore.getDefaultState(), ashstone_veinsize),
                                             Placement.COUNT_RANGE, ashstone_cfg));

        }
        if (NetherrocksConfig.enableDragonstoneOre)
        {
            Biomes.NETHER.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES,
                Biome.createDecoratedFeature(Feature.ORE,
                        new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NETHERRACK,
                                             ModBlocks.dragonstone_ore.getDefaultState(), dragonstone_veinsize),
                                             Placement.COUNT_RANGE, dragonstone_cfg));

        }
        if (NetherrocksConfig.enableFyriteOre)
        {
            Biomes.NETHER.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES,
                Biome.createDecoratedFeature(Feature.ORE,
                        new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NETHERRACK,
                                             ModBlocks.fyrite_ore.getDefaultState(), fyrite_veinsize),
                                             Placement.COUNT_RANGE, fyrite_cfg));

        }
        if (NetherrocksConfig.enableMalachiteOre)
        {
            Biomes.NETHER.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES,
                Biome.createDecoratedFeature(Feature.ORE,
                        new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NETHERRACK,
                                             ModBlocks.malachite_ore.getDefaultState(), malachite_veinsize),
                                             Placement.COUNT_RANGE, malachite_cfg));

        }
        if (NetherrocksConfig.enableIllumeniteOre)
        {
            // TODO - this will need tweaking if it works at all.
            // TODO - does not work at all.
            Biomes.NETHER.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES,
                Biome.createDecoratedFeature(Feature.EMERALD_ORE,
                        new ReplaceBlockConfig(Blocks.GLOWSTONE.getDefaultState(), ModBlocks.illumenite_ore.getDefaultState()),
                                             Placement.COUNT_RANGE, illumenite_cfg));
        }
    } // end setupNetherOreGen()

}  // end class OreGeneration
