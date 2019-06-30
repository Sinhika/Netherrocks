package mod.alexndr.netherrocks.generation;

import mod.alexndr.netherrocks.config.NetherrocksConfig;
import mod.alexndr.netherrocks.init.ModBlocks;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biomes;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.placement.CountRangeConfig;
import net.minecraft.world.gen.placement.Placement;

/**
 * Ore generation master-class for SimpleOres.
 */
public class OreGeneration
{
    // Vein/Chunk Count, MinHeight, MaxHeightBase, MaxHeight
    // TODO
    private static final CountRangeConfig argonite_cfg = new CountRangeConfig(5, 10, 0, 128);
    private static final int argonite_veinsize = 7;

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
        // TODO
    } // end setupNetherOreGen()

}  // end class OreGeneration
