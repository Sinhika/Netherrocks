package mod.alexndr.netherrocks.generation;

import mod.alexndr.netherrocks.Netherrocks;
import mod.alexndr.netherrocks.config.NetherrocksConfig;
import mod.alexndr.netherrocks.init.ModBlocks;
import mod.alexndr.simplecorelib.world.OreGenUtils;
import net.minecraft.world.gen.GenerationStage.Decoration;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.FeatureSpreadConfig;
import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

/**
 * Ore generation master-class for Netherrocks.
 */
public class OreGeneration
{
    public static ConfiguredFeature<?, ?> ORE_ARGONITE;
    public static ConfiguredFeature<?, ?> ORE_ASHSTONE;
    public static ConfiguredFeature<?, ?> ORE_DRAGONSTONE;
    public static ConfiguredFeature<?, ?> ORE_FYRITE;
    public static ConfiguredFeature<?, ?> ORE_ILLUMENITE;
    public static ConfiguredFeature<?, ?> ORE_ILLUMENITE_EXTRA;
    public static ConfiguredFeature<?, ?> ORE_MALACHITE;

    public static final DeferredRegister<Feature<?>> FEATURES = 
            DeferredRegister.create(ForgeRegistries.FEATURES, Netherrocks.MODID);

    public static final RegistryObject<Feature<NoFeatureConfig>> ILLUMENITE_FEATURE = 
            FEATURES.register("illumenite_blob", 
                              () -> new IllumeniteBlobFeature(NoFeatureConfig.field_236558_a_));

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
    public static void initNetherFeatures()
    {
        if (NetherrocksConfig.enableArgoniteOre) 
        {
            ORE_ARGONITE = OreGenUtils.buildNetherOreFeature(Feature.ORE, ModBlocks.argonite_ore.get().getDefaultState(),
                                                             NetherrocksConfig.argonite_cfg);
            OreGenUtils.registerFeature(Netherrocks.MODID, "argonite_vein", ORE_ARGONITE);
        }
        if (NetherrocksConfig.enableAshstoneOre) 
        {
            ORE_ASHSTONE = OreGenUtils.buildNetherOreFeature(Feature.ORE, ModBlocks.ashstone_ore.get().getDefaultState(),
                    NetherrocksConfig.ashstone_cfg);
            OreGenUtils.registerFeature(Netherrocks.MODID, "ashstone_vein", ORE_ASHSTONE);
        }
        if (NetherrocksConfig.enableDragonstoneOre) 
        {
            ORE_DRAGONSTONE = OreGenUtils.buildNetherOreFeature(Feature.ORE, ModBlocks.dragonstone_ore.get().getDefaultState(),
                    NetherrocksConfig.dragonstone_cfg);
            OreGenUtils.registerFeature(Netherrocks.MODID, "dragonstone_vein", ORE_DRAGONSTONE);
        }
        if (NetherrocksConfig.enableFyriteOre && ORE_FYRITE == null) 
        {
            ORE_FYRITE = OreGenUtils.buildNetherOreFeature(Feature.ORE, ModBlocks.fyrite_ore.get().getDefaultState(),
                    NetherrocksConfig.fyrite_cfg);
            OreGenUtils.registerFeature(Netherrocks.MODID, "fyrite_vein", ORE_FYRITE);
        }
        // Illumenite ore is a special snowflake that generates in glowstone blobs, so it has
        // to mimic glowstone generation. A side-effect is that more glowstone generates as well.
        if (NetherrocksConfig.enableIllumeniteOre && ORE_ILLUMENITE == null) 
        {
            ORE_ILLUMENITE = ILLUMENITE_FEATURE.get().withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG)
                    .range(NetherrocksConfig.illumenite_cfg.getCfg().maximum).square()
                    .func_242731_b(NetherrocksConfig.illumenite_cfg.getVein_count());
            ORE_ILLUMENITE_EXTRA = ILLUMENITE_FEATURE.get().withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG)
                    .withPlacement(Placement.GLOWSTONE.configure(new FeatureSpreadConfig(10)));
            OreGenUtils.registerFeature(Netherrocks.MODID, "illumenite_cluster", ORE_ILLUMENITE);
            OreGenUtils.registerFeature(Netherrocks.MODID, "illumenite_cluster_extra", ORE_ILLUMENITE_EXTRA);
            
        }
        if (NetherrocksConfig.enableMalachiteOre && ORE_MALACHITE == null) 
        {
            ORE_MALACHITE = OreGenUtils.buildNetherOreFeature(Feature.ORE, ModBlocks.malachite_ore.get().getDefaultState(),
                    NetherrocksConfig.malachite_cfg);
            OreGenUtils.registerFeature(Netherrocks.MODID, "malachite_vein", ORE_MALACHITE);
        }
    } // end-initNetherFeatures()

} // end class OreGeneration
