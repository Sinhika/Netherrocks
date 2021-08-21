package mod.alexndr.netherrocks.generation;

import com.google.common.collect.ImmutableList;

import mod.alexndr.netherrocks.Netherrocks;
import mod.alexndr.netherrocks.config.NetherrocksConfig;
import mod.alexndr.netherrocks.init.ModBlocks;
import mod.alexndr.simplecorelib.world.OreGenUtils;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.GenerationStep.Decoration;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.configurations.CountConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.placement.FeatureDecorator;
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
	
	public static final ImmutableList<OreConfiguration.TargetBlockState> ORE_FYRITE_TARGET_LIST = ImmutableList.of(
			OreConfiguration.target(MAGMAROCK_TEST, ModBlocks.fyrite_ore.get().defaultBlockState()));
			
    public static ConfiguredFeature<?, ?> ORE_ARGONITE;
    public static ConfiguredFeature<?, ?> ORE_ASHSTONE;
    public static ConfiguredFeature<?, ?> ORE_DRAGONSTONE;
    public static ConfiguredFeature<?, ?> ORE_FYRITE;
    public static ConfiguredFeature<?, ?> ORE_FYRITE_ROCK;
    public static ConfiguredFeature<?, ?> ORE_ILLUMENITE;
    public static ConfiguredFeature<?, ?> ORE_ILLUMENITE_EXTRA;
    public static ConfiguredFeature<?, ?> ORE_MALACHITE;

//    public static final DeferredRegister<Feature<?>> FEATURES = 
//            DeferredRegister.create(ForgeRegistries.FEATURES, Netherrocks.MODID);
//
//    public static final RegistryObject<Feature<NoneFeatureConfiguration>> ILLUMENITE_FEATURE = 
//            FEATURES.register("illumenite_blob", 
//                              () -> new IllumeniteBlobFeature(NoneFeatureConfiguration.CODEC));

    /**
     * initialize nether Features.
     * 
     * @param evt
     */
    public static void initNetherFeatures()
    {
        if (NetherrocksConfig.enableArgoniteOre) 
        {
            ORE_ARGONITE = OreGenUtils.buildNetherRockFeature(ModBlocks.argonite_ore.get().defaultBlockState(),
                                                             NetherrocksConfig.argonite_cfg);
            OreGenUtils.registerFeature(Netherrocks.MODID, "argonite_vein", ORE_ARGONITE);
        }
        if (NetherrocksConfig.enableAshstoneOre) 
        {
            ORE_ASHSTONE = OreGenUtils.buildNetherRockFeature(ModBlocks.ashstone_ore.get().defaultBlockState(),
                    NetherrocksConfig.ashstone_cfg);
            OreGenUtils.registerFeature(Netherrocks.MODID, "ashstone_vein", ORE_ASHSTONE);
        }
        if (NetherrocksConfig.enableDragonstoneOre) 
        {
            ORE_DRAGONSTONE = OreGenUtils.buildNetherRockFeature(ModBlocks.dragonstone_ore.get().defaultBlockState(),
                    NetherrocksConfig.dragonstone_cfg);
            OreGenUtils.registerFeature(Netherrocks.MODID, "dragonstone_vein", ORE_DRAGONSTONE);
        }
        if (NetherrocksConfig.enableFyriteOre) 
        {
            ORE_FYRITE = OreGenUtils.buildNetherOreFeature(ModBlocks.fyrite_ore.get().defaultBlockState(),
                    NetherrocksConfig.fyrite_cfg);
            ORE_FYRITE_ROCK = OreGenUtils.buildTargettedOreFeature(ORE_FYRITE_TARGET_LIST, NetherrocksConfig.fyrite_cfg);
            OreGenUtils.registerFeature(Netherrocks.MODID, "fyrite_vein", ORE_FYRITE);
            OreGenUtils.registerFeature(Netherrocks.MODID, "fyrite_in_magma", ORE_FYRITE_ROCK);
        }
        // Illumenite ore is a special snowflake that generates in glowstone blobs, so it has
        // to mimic glowstone generation. A side-effect is that more glowstone generates as well.
        if (NetherrocksConfig.enableIllumeniteOre) 
        {
            ORE_ILLUMENITE = ILLUMENITE_FEATURE.get().configured(FeatureConfiguration.NONE)
                    .range(NetherrocksConfig.illumenite_cfg.getCfg().maximum).squared()
                    .count(NetherrocksConfig.illumenite_cfg.getVein_count());
            ORE_ILLUMENITE_EXTRA = ILLUMENITE_FEATURE.get().configured(FeatureConfiguration.NONE)
                    .decorated(FeatureDecorator.GLOWSTONE.configured(new CountConfiguration(10)));
            OreGenUtils.registerFeature(Netherrocks.MODID, "illumenite_cluster", ORE_ILLUMENITE);
            OreGenUtils.registerFeature(Netherrocks.MODID, "illumenite_cluster_extra", ORE_ILLUMENITE_EXTRA);
            
        }
        if (NetherrocksConfig.enableMalachiteOre) 
        {
            ORE_MALACHITE = OreGenUtils.buildNetherRockFeature(ModBlocks.malachite_ore.get().defaultBlockState(),
                    NetherrocksConfig.malachite_cfg);
            OreGenUtils.registerFeature(Netherrocks.MODID, "malachite_vein", ORE_MALACHITE);
        }
    } // end-initNetherFeatures()


    /** 
     * generate nether ores.
     */
    public static void generateNetherOres(BiomeLoadingEvent evt)
    {
        if (NetherrocksConfig.enableArgoniteOre)
            evt.getGeneration().addFeature(Decoration.UNDERGROUND_DECORATION, OreGeneration.ORE_ARGONITE);
        if (NetherrocksConfig.enableAshstoneOre)
            evt.getGeneration().addFeature(Decoration.UNDERGROUND_DECORATION, OreGeneration.ORE_ASHSTONE);
        if (NetherrocksConfig.enableDragonstoneOre)
            evt.getGeneration().addFeature(Decoration.UNDERGROUND_DECORATION, OreGeneration.ORE_DRAGONSTONE);
        if (NetherrocksConfig.enableFyriteOre)
            evt.getGeneration().addFeature(Decoration.UNDERGROUND_DECORATION, OreGeneration.ORE_FYRITE);
        if (NetherrocksConfig.enableMalachiteOre)
            evt.getGeneration().addFeature(Decoration.UNDERGROUND_DECORATION, OreGeneration.ORE_MALACHITE);
        
        if (NetherrocksConfig.enableIllumeniteOre)
        {
            evt.getGeneration().addFeature(Decoration.UNDERGROUND_DECORATION, OreGeneration.ORE_ILLUMENITE);
            evt.getGeneration().addFeature(Decoration.UNDERGROUND_DECORATION, OreGeneration.ORE_ILLUMENITE_EXTRA);
        }
    } // end generateNetherOres()
    
} // end class OreGeneration
