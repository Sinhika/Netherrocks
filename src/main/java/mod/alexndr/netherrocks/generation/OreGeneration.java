package mod.alexndr.netherrocks.generation;

import java.util.List;

import mod.alexndr.netherrocks.config.NetherrocksConfig;
import mod.alexndr.netherrocks.init.ModBlocks;
import mod.alexndr.simplecorelib.world.OreGenUtils;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.GenerationStep.Decoration;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockMatchTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraftforge.event.world.BiomeLoadingEvent;

/**
 * Ore generation master-class for Netherrocks.
 */
public class OreGeneration
{
	public static final RuleTest MAGMAROCK_TEST = new BlockMatchTest(Blocks.MAGMA_BLOCK);
	public static final RuleTest GLOWSTONE_TEST = new BlockMatchTest(Blocks.GLOWSTONE);
	public static final RuleTest BLACKSTONE_TEST = new BlockMatchTest(Blocks.BLACKSTONE);

	public static final List<OreConfiguration.TargetBlockState> ORE_ARGONITE_TARGET_LIST =
			OreGenUtils.BuildNetherOreTargetList(ModBlocks.argonite_ore.get(), true);
	public static final List<OreConfiguration.TargetBlockState> ORE_ASHSTONE_TARGET_LIST = 
			OreGenUtils.BuildNetherOreTargetList(ModBlocks.ashstone_ore.get(), false);
	
	public static final List<OreConfiguration.TargetBlockState> ORE_DRAGONSTONE_TARGET_LIST = 
			OreGenUtils.BuildNetherOreTargetList(ModBlocks.dragonstone_ore.get(), false);
	
	public static final List<OreConfiguration.TargetBlockState> ORE_FYRITE_TARGET_LIST = 
			OreGenUtils.BuildNetherOreTargetList(ModBlocks.fyrite_ore.get(), true);
	public static final List<OreConfiguration.TargetBlockState> ORE_FYRITE_TARGET_LIST2 = List.of(
			OreConfiguration.target(MAGMAROCK_TEST, ModBlocks.fyrite_ore.get().defaultBlockState()));

	public static final List<OreConfiguration.TargetBlockState> ORE_MALACHITE_TARGET_LIST = 
			OreGenUtils.BuildNetherOreTargetList(ModBlocks.malachite_ore.get(), true);
	
	// TODO - Illumenite
	public static final List<OreConfiguration.TargetBlockState> ORE_ILLUMENITE_TARGET =
			List.of(OreConfiguration.target(GLOWSTONE_TEST, ModBlocks.illumenite_ore.get().defaultBlockState()));
	
    public static ConfiguredFeature<OreConfiguration, ?> ORE_ARGONITE;
    public static ConfiguredFeature<OreConfiguration, ?> ORE_ASHSTONE;
    public static ConfiguredFeature<OreConfiguration, ?> ORE_DRAGONSTONE;
    public static ConfiguredFeature<OreConfiguration, ?> ORE_FYRITE;
    public static ConfiguredFeature<OreConfiguration, ?> ORE_FYRITE_ROCK;
    public static ConfiguredFeature<OreConfiguration, ?> ORE_ILLUMENITE;
    public static ConfiguredFeature<OreConfiguration, ?> ORE_ILLUMENITE_EXTRA;
    public static ConfiguredFeature<OreConfiguration, ?> ORE_MALACHITE;

    public static PlacedFeature ARGONITE_VEIN;
    public static PlacedFeature ASHSTONE_VEIN;
    public static PlacedFeature DRAGONSTONE_VEIN;
    public static PlacedFeature FYRITE_VEIN;
    public static PlacedFeature FYRITE_IN_MAGMA;
    public static PlacedFeature ILLUMENITE_CLUSTER;
    public static PlacedFeature MALACHITE_VEIN;
    
    /**
     * initialize nether Features.
     * 
     * @param evt
     */
	public static void initNetherFeatures()
    {
        if (NetherrocksConfig.enableArgoniteOre) 
        {
            ORE_ARGONITE = FeatureUtils.register("ore_argonite", OreGenUtils.ConfigureOreFeature(ORE_ARGONITE_TARGET_LIST, 
            		NetherrocksConfig.argonite_cfg.getVein_size(), 0.0F));
            ARGONITE_VEIN = PlacementUtils.register("argonite_vein", 
            							OreGenUtils.ConfigurePlacedFeature(NetherrocksConfig.argonite_cfg, ORE_ARGONITE));												
        }
        if (NetherrocksConfig.enableAshstoneOre) 
        {
//            ORE_ASHSTONE = OreGenUtils.buildNetherRockFeature(ModBlocks.ashstone_ore.get().defaultBlockState(),
//                    NetherrocksConfig.ashstone_cfg);
//            OreGenUtils.registerFeature(Netherrocks.MODID, "ashstone_vein", ORE_ASHSTONE);
        }
        if (NetherrocksConfig.enableDragonstoneOre) 
        {
//            ORE_DRAGONSTONE = OreGenUtils.buildTargettedOreFeature(ORE_DRAGONSTONE_TARGET_LIST, NetherrocksConfig.dragonstone_cfg);
//            OreGenUtils.registerFeature(Netherrocks.MODID, "dragonstone_vein", ORE_DRAGONSTONE);
        }
        if (NetherrocksConfig.enableFyriteOre) 
        {
//            ORE_FYRITE = OreGenUtils.buildNetherOreFeature(ModBlocks.fyrite_ore.get().defaultBlockState(),
//                    NetherrocksConfig.fyrite_cfg);
//            ORE_FYRITE_ROCK = OreGenUtils.buildTargettedOreFeature(ORE_FYRITE_TARGET_LIST, NetherrocksConfig.fyrite_cfg);
//            OreGenUtils.registerFeature(Netherrocks.MODID, "fyrite_vein", ORE_FYRITE);
//            OreGenUtils.registerFeature(Netherrocks.MODID, "fyrite_in_magma", ORE_FYRITE_ROCK);
        }
        // Illumenite ore is a special snowflake that generates in glowstone blobs, so it has
        // to mimic glowstone generation. A side-effect is that more glowstone generates as well.
        if (NetherrocksConfig.enableIllumeniteOre) 
        {
//            ORE_ILLUMENITE = ModFeatures.ILLUMENITE_FEATURE.get().configured(FeatureConfiguration.NONE)
//                   .range(Features.Decorators.FULL_RANGE).squared().count(NetherrocksConfig.illumenite_cfg.getVein_count());
//            
//            ORE_ILLUMENITE_EXTRA = ModFeatures.ILLUMENITE_FEATURE.get().configured(FeatureConfiguration.NONE)
//            		.range(Features.Decorators.RANGE_4_4).squared().count(BiasedToBottomInt.of(0, 9));
//            
//            OreGenUtils.registerFeature(Netherrocks.MODID, "illumenite_cluster", ORE_ILLUMENITE);
//            OreGenUtils.registerFeature(Netherrocks.MODID, "illumenite_cluster_extra", ORE_ILLUMENITE_EXTRA);
            
        }
        if (NetherrocksConfig.enableMalachiteOre) 
        {
//            ORE_MALACHITE = OreGenUtils.buildNetherRockFeature(ModBlocks.malachite_ore.get().defaultBlockState(),
//                    NetherrocksConfig.malachite_cfg);
//            OreGenUtils.registerFeature(Netherrocks.MODID, "malachite_vein", ORE_MALACHITE);
        }
    } // end-initNetherFeatures()


    /** 
     * generate nether ores.
     */
    public static void generateNetherOres(BiomeLoadingEvent evt)
    {
        if (NetherrocksConfig.enableArgoniteOre)
            evt.getGeneration().addFeature(Decoration.UNDERGROUND_DECORATION, OreGeneration.ARGONITE_VEIN);
        if (NetherrocksConfig.enableAshstoneOre)
            evt.getGeneration().addFeature(Decoration.UNDERGROUND_DECORATION, OreGeneration.ASHSTONE_VEIN);
        if (NetherrocksConfig.enableDragonstoneOre)
            evt.getGeneration().addFeature(Decoration.UNDERGROUND_DECORATION, OreGeneration.DRAGONSTONE_VEIN);
        if (NetherrocksConfig.enableFyriteOre) {
            evt.getGeneration().addFeature(Decoration.UNDERGROUND_DECORATION, OreGeneration.FYRITE_VEIN);
            evt.getGeneration().addFeature(Decoration.UNDERGROUND_DECORATION, OreGeneration.FYRITE_IN_MAGMA);
        }
        if (NetherrocksConfig.enableMalachiteOre)
            evt.getGeneration().addFeature(Decoration.UNDERGROUND_DECORATION, OreGeneration.MALACHITE_VEIN);
        
        if (NetherrocksConfig.enableIllumeniteOre)
        {
            evt.getGeneration().addFeature(Decoration.UNDERGROUND_DECORATION, OreGeneration.ILLUMENITE_CLUSTER);
//            evt.getGeneration().addFeature(Decoration.UNDERGROUND_DECORATION, OreGeneration.ORE_ILLUMENITE_EXTRA);
        }
    } // end generateNetherOres()
    
} // end class OreGeneration
