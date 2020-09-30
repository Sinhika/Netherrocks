package mod.alexndr.netherrocks.generation;

import mod.alexndr.netherrocks.config.NetherrocksConfig;
import mod.alexndr.netherrocks.init.ModBlocks;
import mod.alexndr.simplecorelib.world.OreGenUtils;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage.Decoration;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.FeatureSpreadConfig;
import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraftforge.event.world.BiomeLoadingEvent;

/**
 * Ore generation master-class for Netherrocks.
 */
public class OreGeneration
{
    protected static ConfiguredFeature<?, ?> ORE_ARGONITE;
    protected static ConfiguredFeature<?, ?> ORE_ASHSTONE;
    protected static ConfiguredFeature<?, ?> ORE_DRAGONSTONE;
    protected static ConfiguredFeature<?, ?> ORE_FYRITE;
    protected static ConfiguredFeature<?, ?> ORE_ILLUMENITE;
    protected static ConfiguredFeature<?, ?> ORE_ILLUMENITE_EXTRA;
    protected static ConfiguredFeature<?, ?> ORE_MALACHITE;

    public static final Feature<NoFeatureConfig> ILLUMENITE_FEATURE = new IllumeniteBlobFeature(
            NoFeatureConfig.field_236558_a_);

    /** 
     * generate nether ores.
     */
    public static void generateNetherOres(BiomeLoadingEvent evt)
    {
        evt.getGeneration().withFeature(Decoration.UNDERGROUND_DECORATION, OreGeneration.ORE_ARGONITE);
        evt.getGeneration().withFeature(Decoration.UNDERGROUND_DECORATION, OreGeneration.ORE_ASHSTONE);
        evt.getGeneration().withFeature(Decoration.UNDERGROUND_DECORATION, OreGeneration.ORE_DRAGONSTONE);
        evt.getGeneration().withFeature(Decoration.UNDERGROUND_DECORATION, OreGeneration.ORE_FYRITE);
        evt.getGeneration().withFeature(Decoration.UNDERGROUND_DECORATION, OreGeneration.ORE_MALACHITE);
        evt.getGeneration().withFeature(Decoration.UNDERGROUND_DECORATION, OreGeneration.ORE_ILLUMENITE);
        evt.getGeneration().withFeature(Decoration.UNDERGROUND_DECORATION, OreGeneration.ORE_ILLUMENITE_EXTRA);
    } // end generateNetherOres()
    
   /**
     * initialize nether Features.
     * 
     * @param evt
     */
    protected static void initNetherFeatures()
    {
        if (NetherrocksConfig.enableArgoniteOre && ORE_ARGONITE == null) 
        {
            ORE_ARGONITE = OreGenUtils.buildNetherOreFeature(ModBlocks.argonite_ore.get().getDefaultState(),
                                                             NetherrocksConfig.argonite_cfg);
        }
        if (NetherrocksConfig.enableAshstoneOre && ORE_ASHSTONE == null) 
        {
            ORE_ASHSTONE = OreGenUtils.buildNetherOreFeature(ModBlocks.ashstone_ore.get().getDefaultState(),
                    NetherrocksConfig.ashstone_cfg);
        }
        if (NetherrocksConfig.enableDragonstoneOre && ORE_DRAGONSTONE == null) 
        {
            ORE_DRAGONSTONE = OreGenUtils.buildNetherOreFeature(ModBlocks.dragonstone_ore.get().getDefaultState(),
                    NetherrocksConfig.dragonstone_cfg);
        }
        if (NetherrocksConfig.enableFyriteOre && ORE_FYRITE == null) 
        {
            ORE_FYRITE = OreGenUtils.buildNetherOreFeature(ModBlocks.fyrite_ore.get().getDefaultState(),
                    NetherrocksConfig.fyrite_cfg);
        }
        // Illumenite ore is a special snowflake that generates in glowstone blobs, so it has
        // to mimic glowstone generation. A side-effect is that more glowstone generates as well.
        if (NetherrocksConfig.enableIllumeniteOre && ORE_ILLUMENITE == null) 
        {
            ORE_ILLUMENITE = ILLUMENITE_FEATURE.withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG)
                    .withPlacement(Placement.field_242907_l.configure(NetherrocksConfig.illumenite_cfg.getCfg())
                    .func_242728_a()
                    .func_242731_b(NetherrocksConfig.illumenite_cfg.getVein_count()));
            ORE_ILLUMENITE_EXTRA = ILLUMENITE_FEATURE.withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG)
                    .withPlacement(Placement.field_242912_w.configure(new FeatureSpreadConfig(10)));
        }
        if (NetherrocksConfig.enableMalachiteOre && ORE_MALACHITE == null) 
        {
            ORE_MALACHITE = OreGenUtils.buildNetherOreFeature(ModBlocks.malachite_ore.get().getDefaultState(),
                    NetherrocksConfig.malachite_cfg);
        }
    } // end-initNetherFeatures()

    /**
     * Do we care about this biome? Yes, if overworld or nether, no if THEEND. Also
     * init relevant Features, if they are null.
     */
    public static boolean checkAndInitBiome(BiomeLoadingEvent evt)
    {
        if (evt.getCategory() == Biome.Category.NETHER)
        {
            initNetherFeatures();
            return true;
        }
        return false;
    } // end checkBiome


} // end class OreGeneration
