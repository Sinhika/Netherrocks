package mod.alexndr.netherrocks.generation;

import java.util.List;

import mod.alexndr.netherrocks.config.NetherrocksConfig;
import mod.alexndr.netherrocks.init.ModBlocks;
import mod.alexndr.netherrocks.init.ModFeatures;
import mod.alexndr.simplecorelib.world.OreGenUtils;
import net.minecraft.core.Holder;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.util.valueproviders.BiasedToBottomInt;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.GenerationStep.Decoration;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.placement.BiomeFilter;
import net.minecraft.world.level.levelgen.placement.CountPlacement;
import net.minecraft.world.level.levelgen.placement.InSquarePlacement;
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
	
//    public static Holder<ConfiguredFeature<OreConfiguration, ?>> ORE_ARGONITE;
//    public static Holder<ConfiguredFeature<OreConfiguration, ?>> ORE_ASHSTONE;
//    public static Holder<ConfiguredFeature<OreConfiguration, ?>> ORE_DRAGONSTONE;
//    public static Holder<ConfiguredFeature<OreConfiguration, ?>> ORE_FYRITE;
//    public static Holder<ConfiguredFeature<OreConfiguration, ?>> ORE_FYRITE_ROCK;
//    public static Holder<ConfiguredFeature<NoneFeatureConfiguration, ?>>  ORE_ILLUMENITE;
//    public static Holder<ConfiguredFeature<OreConfiguration, ?>> ORE_MALACHITE;
//
    public static Holder<PlacedFeature> ARGONITE_VEIN;
    public static Holder<PlacedFeature> ASHSTONE_VEIN;
    public static Holder<PlacedFeature> DRAGONSTONE_VEIN;
    public static Holder<PlacedFeature> FYRITE_VEIN;
    public static Holder<PlacedFeature> FYRITE_IN_MAGMA;
    public static Holder<PlacedFeature> ILLUMENITE_CLUSTER;
    public static Holder<PlacedFeature> ILLUMENITE_CLUSTER_EXTRA;
    public static Holder<PlacedFeature> MALACHITE_VEIN;
    
    /**
     * initialize nether Features.
     * 
     * @param evt
     */
	public static void initNetherFeatures()
    {
        if (NetherrocksConfig.enableArgoniteOre) 
        {
//            ORE_ARGONITE = FeatureUtils.register("ore_argonite", Feature.ORE, 
//                    OreGenUtils.ConfigureOreFeature(OreGenUtils.BuildNetherOreTargetList(ModBlocks.argonite_ore.get(), true), 
//            		NetherrocksConfig.argonite_cfg.getVein_size(), 0.0F));
            
            ARGONITE_VEIN = PlacementUtils.register("argonite_vein", ORE_ARGONITE, 
            							OreGenUtils.ConfigurePlacementModifiers(NetherrocksConfig.argonite_cfg));												
        }
        if (NetherrocksConfig.enableAshstoneOre) 
        {
        	ORE_ASHSTONE = FeatureUtils.register("ore_ashstone", Feature.ORE,
        	        OreGenUtils.ConfigureOreFeature(ORE_ASHSTONE_TARGET_LIST, 
            		NetherrocksConfig.ashstone_cfg.getVein_size(), 0.0F));
        	ASHSTONE_VEIN = PlacementUtils.register("argonite_vein", ORE_ASHSTONE, 
            							OreGenUtils.ConfigurePlacementModifiers(NetherrocksConfig.ashstone_cfg));												
        }
        if (NetherrocksConfig.enableDragonstoneOre) 
        {
        	ORE_DRAGONSTONE = FeatureUtils.register("ore_dragonstone", Feature.ORE, 
        	        OreGenUtils.ConfigureOreFeature(ORE_DRAGONSTONE_TARGET_LIST, 
            		NetherrocksConfig.dragonstone_cfg.getVein_size(), 0.0F));
        	DRAGONSTONE_VEIN = PlacementUtils.register("dragonstone_vein", ORE_DRAGONSTONE, 
            							OreGenUtils.ConfigurePlacementModifiers(NetherrocksConfig.dragonstone_cfg));												
        }
        if (NetherrocksConfig.enableFyriteOre) 
        {
            ORE_FYRITE = FeatureUtils.register("ore_fyrite", Feature.ORE, 
                    OreGenUtils.ConfigureOreFeature(ORE_FYRITE_TARGET_LIST, 
            		NetherrocksConfig.fyrite_cfg.getVein_size(), 0.0F));
            FYRITE_VEIN = PlacementUtils.register("fyrite_vein", ORE_FYRITE, 
            							OreGenUtils.ConfigurePlacementModifiers(NetherrocksConfig.fyrite_cfg));		
            ORE_FYRITE_ROCK = FeatureUtils.register("ore_fyrite_rock", Feature.ORE, 
                    OreGenUtils.ConfigureOreFeature(ORE_FYRITE_TARGET_LIST2,
            		NetherrocksConfig.fyrite_cfg.getVein_size(), 0.0F));
            FYRITE_IN_MAGMA  = PlacementUtils.register("fyrite_in_magma", ORE_FYRITE_ROCK, 
					OreGenUtils.ConfigurePlacementModifiers(NetherrocksConfig.fyrite_cfg));	
        }
        // Illumenite ore is a special snowflake that generates in glowstone blobs, so it has
        // to mimic glowstone generation. A side-effect is that more glowstone generates as well.
        // If code does not work after porting, check changes to ORE_GLOWSTONE in vanilla.
        if (NetherrocksConfig.enableIllumeniteOre) 
        {
        	ORE_ILLUMENITE = FeatureUtils.register("ore_illumenite", ModFeatures.ILLUMENITE_FEATURE.get());
        	ILLUMENITE_CLUSTER =  PlacementUtils.register("illumenite_cluster", 
        			ORE_ILLUMENITE, CountPlacement.of(NetherrocksConfig.illumenite_cfg.getVein_size()), 
        					InSquarePlacement.spread(), PlacementUtils.FULL_RANGE, BiomeFilter.biome());		
        	ILLUMENITE_CLUSTER_EXTRA =  PlacementUtils.register("illumenite_cluster_extra", 
        			ORE_ILLUMENITE, CountPlacement.of(BiasedToBottomInt.of(0,NetherrocksConfig.illumenite_cfg.getVein_count())),
        					InSquarePlacement.spread(), PlacementUtils.RANGE_4_4, BiomeFilter.biome());
        }
        if (NetherrocksConfig.enableMalachiteOre) 
        {
        	ORE_MALACHITE = FeatureUtils.register("ore_malachite", Feature.ORE, 
        	        OreGenUtils.ConfigureOreFeature(ORE_MALACHITE_TARGET_LIST, 
            		NetherrocksConfig.malachite_cfg.getVein_size(), 0.0F));
        	MALACHITE_VEIN = PlacementUtils.register("malachite_vein", ORE_MALACHITE, 
					OreGenUtils.ConfigurePlacementModifiers(NetherrocksConfig.malachite_cfg));	
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
            evt.getGeneration().addFeature(Decoration.UNDERGROUND_DECORATION, OreGeneration.ILLUMENITE_CLUSTER_EXTRA);
        }
    } // end generateNetherOres()
    
} // end class OreGeneration
