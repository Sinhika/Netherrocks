package mod.alexndr.netherrocks.generation;

import mod.alexndr.netherrocks.config.NetherrocksConfig;
import mod.alexndr.netherrocks.init.ModFeatures;
import net.minecraft.world.level.levelgen.GenerationStep.Decoration;
import net.minecraftforge.event.world.BiomeLoadingEvent;

/**
 * Ore generation master-class for Netherrocks.
 */
public class OreGeneration
{
    /** 
     * generate nether ores.
     */
    public static void generateNetherOres(BiomeLoadingEvent evt)
    {
        if (NetherrocksConfig.enableArgoniteOre)
            evt.getGeneration().addFeature(Decoration.UNDERGROUND_DECORATION, ModFeatures.ARGONITE_VEIN.getHolder().get());
        if (NetherrocksConfig.enableAshstoneOre) 
        {
            if (NetherrocksConfig.enableAshstoneGhastOre) {
                evt.getGeneration().addFeature(Decoration.UNDERGROUND_DECORATION, ModFeatures.GHAST_ORE_VEIN.getHolder().get());
            }
            else {
                evt.getGeneration().addFeature(Decoration.UNDERGROUND_DECORATION, ModFeatures.ASHSTONE_VEIN.getHolder().get());
            }
        }
        if (NetherrocksConfig.enableDragonstoneOre)
            evt.getGeneration().addFeature(Decoration.UNDERGROUND_DECORATION, ModFeatures.DRAGONSTONE_VEIN.getHolder().get());
        if (NetherrocksConfig.enableFyriteOre) {
            evt.getGeneration().addFeature(Decoration.UNDERGROUND_DECORATION, ModFeatures.FYRITE_VEIN.getHolder().get());
            evt.getGeneration().addFeature(Decoration.UNDERGROUND_DECORATION, ModFeatures.FYRITE_IN_MAGMA.getHolder().get());
        }
        if (NetherrocksConfig.enableMalachiteOre)
            evt.getGeneration().addFeature(Decoration.UNDERGROUND_DECORATION, ModFeatures.MALACHITE_VEIN.getHolder().get());
        
        if (NetherrocksConfig.enableIllumeniteOre)
        {
            evt.getGeneration().addFeature(Decoration.UNDERGROUND_DECORATION, ModFeatures.ILLUMENITE_CLUSTER.getHolder().get());
            evt.getGeneration().addFeature(Decoration.UNDERGROUND_DECORATION, ModFeatures.ILLUMENITE_CLUSTER_EXTRA.getHolder().get());
        }
    } // end generateNetherOres()
    
} // end class OreGeneration
