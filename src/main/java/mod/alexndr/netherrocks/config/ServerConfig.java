package mod.alexndr.netherrocks.config;

import mod.alexndr.netherrocks.Netherrocks;
import net.minecraftforge.common.ForgeConfigSpec;

/**
 * For configuration settings that change the behaviour of code on the LOGICAL SERVER.
 * This can be moved to an inner class of ExampleModConfig, but is separate because of personal preference and to keep the code organised
 *
 * @author Cadiboo
 * @author Sinhika
 */
final class ServerConfig
{

	final ForgeConfigSpec.BooleanValue serverEnableArgoniteOre;
    final ForgeConfigSpec.IntValue serverArgoniteVeinSize;
    final ForgeConfigSpec.IntValue serverArgoniteVeinCount;
    final ForgeConfigSpec.IntValue serverArgoniteBottomHeight;
    final ForgeConfigSpec.IntValue serverArgoniteMaxHeight;
	
	final ForgeConfigSpec.BooleanValue serverEnableAshstoneOre;
    final ForgeConfigSpec.IntValue serverAshstoneVeinSize;
    final ForgeConfigSpec.IntValue serverAshstoneVeinCount;
    final ForgeConfigSpec.IntValue serverAshstoneBottomHeight;
    final ForgeConfigSpec.IntValue serverAshstoneMaxHeight;

    final ForgeConfigSpec.BooleanValue serverEnableDragonstoneOre;
    final ForgeConfigSpec.IntValue serverDragonstoneVeinSize;
    final ForgeConfigSpec.IntValue serverDragonstoneVeinCount;
    final ForgeConfigSpec.IntValue serverDragonstoneBottomHeight;
    final ForgeConfigSpec.IntValue serverDragonstoneMaxHeight;

    final ForgeConfigSpec.BooleanValue serverEnableFyriteOre;
    final ForgeConfigSpec.IntValue serverFyriteVeinSize;
    final ForgeConfigSpec.IntValue serverFyriteVeinCount;
    final ForgeConfigSpec.IntValue serverFyriteBottomHeight;
    final ForgeConfigSpec.IntValue serverFyriteMaxHeight;

    final ForgeConfigSpec.BooleanValue serverEnableIllumeniteOre;
    final ForgeConfigSpec.IntValue serverIllumeniteVeinSize;
    final ForgeConfigSpec.IntValue serverIllumeniteVeinCount;
    final ForgeConfigSpec.IntValue serverIllumeniteBottomHeight;
    final ForgeConfigSpec.IntValue serverIllumeniteMaxHeight;

    final ForgeConfigSpec.BooleanValue serverEnableMalachiteOre;
    final ForgeConfigSpec.IntValue serverMalachiteVeinSize;
    final ForgeConfigSpec.IntValue serverMalachiteVeinCount;
    final ForgeConfigSpec.IntValue serverMalachiteBottomHeight;
    final ForgeConfigSpec.IntValue serverMalachiteMaxHeight;

    final ForgeConfigSpec.BooleanValue serverAddModLootToChests;
    final ForgeConfigSpec.BooleanValue serverEnableAesthetics;

	ServerConfig(final ForgeConfigSpec.Builder builder)
	{
	    builder.push("General");
	    serverAddModLootToChests = builder.comment("Add Netherrocks items to chest loot?")
                .translation(Netherrocks.MODID + ".config.serverAddModLootToChests")
                .define("AddModLootToChests", true);
        serverEnableAesthetics = builder.comment("Enable Netherrocks aesthetic blocks?")
                .translation(Netherrocks.MODID + "config.EnableAesthetics")
                .define("EnableAestheticsBlocks", true);
	    builder.pop();
	    
		builder.push("OreGeneration");
		serverEnableArgoniteOre = builder
				.comment("Enable argonite ore generation?")
				.translation(Netherrocks.MODID + ".config.serverEnableArgoniteOre")
				.define("EnableArgoniteOre", true);
		serverEnableAshstoneOre = builder
				.comment("Enable ashstone ore generation?")
				.translation(Netherrocks.MODID + ".config.serverEnableAshstoneOre")
				.define("EnableAshstoneOre", true);
		serverEnableDragonstoneOre = builder
				.comment("Enable dragonstone ore generation?")
				.translation(Netherrocks.MODID + ".config.serverEnableDragonstoneOre")
				.define("EnableDragonstoneOre", true);
		serverEnableFyriteOre = builder
				.comment("Enable fyrite ore generation?")
				.translation(Netherrocks.MODID + ".config.serverEnableFyriteOre")
				.define("EnableFyriteOre", true);
		serverEnableIllumeniteOre = builder
				.comment("Enable illumenite ore generation?")
				.translation(Netherrocks.MODID + ".config.serverEnableIllumeniteOre")
				.define("EnableIllumeniteOre", true);
		serverEnableMalachiteOre = builder
				.comment("Enable malachite ore generation?")
				.translation(Netherrocks.MODID + ".config.serverEnableMalachiteOre")
				.define("EnableMalachiteOre", true);
		
        builder.push("Argonite");
        serverArgoniteVeinSize = builder
                .comment("Argonite ore vein size")
                .translation(Netherrocks.MODID + ".config.serverArgoniteVeinSize")
                .defineInRange("ArgoniteVeinSize", 6, 1, Integer.MAX_VALUE);
        serverArgoniteVeinCount = builder
                .comment("Argonite ore vein count per chunk")
                .translation(Netherrocks.MODID + ".config.serverArgoniteVeinCount")
                .defineInRange("ArgoniteVeinCount", 10, 1, Integer.MAX_VALUE);
        serverArgoniteBottomHeight = builder
                .comment("Argonite ore minimum height (currently ignored)")
                .translation(Netherrocks.MODID + ".config.serverArgoniteBottomHeight")
                .defineInRange("ArgoniteBottomHeight", 1, 1, 128);
        serverArgoniteMaxHeight = builder
                .comment("Argonite ore maximum height (currently ignored)")
                .translation(Netherrocks.MODID + ".config.serverArgoniteMaxHeight")
                .defineInRange("ArgoniteMaxHeight", 128, 1, 128);
        builder.pop();
               
        builder.push("Ashstone");
        serverAshstoneVeinSize = builder
                .comment("Ashstone ore vein size")
                .translation(Netherrocks.MODID + ".config.serverAshstoneVeinSize")
                .defineInRange("AshstoneVeinSize", 5, 1, Integer.MAX_VALUE);
        serverAshstoneVeinCount = builder
                .comment("Ashstone ore vein count per chunk")
                .translation(Netherrocks.MODID + ".config.serverAshstoneVeinCount")
                .defineInRange("AshstoneVeinCount", 10, 1, Integer.MAX_VALUE);
        serverAshstoneBottomHeight = builder
                .comment("Ashstone ore minimum height (currently ignored)")
                .translation(Netherrocks.MODID + ".config.serverAshstoneBottomHeight")
                .defineInRange("AshstoneBottomHeight", 1, 1, 127);
        serverAshstoneMaxHeight = builder
                .comment("Ashstone ore maximum height (currently ignored)")
                .translation(Netherrocks.MODID + ".config.serverAshstoneMaxHeight")
                .defineInRange("AshstoneMaxHeight", 128, 1, 128);
        builder.pop();
        
        builder.push("Dragonstone");
        serverDragonstoneVeinSize = builder
                .comment("Dragonstone ore vein size")
                .translation(Netherrocks.MODID + ".config.serverDragonstoneVeinSize")
                .defineInRange("DragonstoneVeinSize", 5, 1, Integer.MAX_VALUE);
        serverDragonstoneVeinCount = builder
                .comment("Dragonstone ore vein count per chunk")
                .translation(Netherrocks.MODID + ".config.serverDragonstoneVeinCount")
                .defineInRange("DragonstoneVeinCount", 7, 1, Integer.MAX_VALUE);
        serverDragonstoneBottomHeight = builder
                .comment("Dragonstone ore minimum height (currently ignored)")
                .translation(Netherrocks.MODID + ".config.serverDragonstoneBottomHeight")
                .defineInRange("DragonstoneBottomHeight", 1, 1, 127);
        serverDragonstoneMaxHeight = builder
                .comment("Dragonstone ore maximum height (currently ignored)")
                .translation(Netherrocks.MODID + ".config.serverDragonstoneMaxHeight")
                .defineInRange("DragonstoneMaxHeight", 128, 1, 128);
        builder.pop();
        
        builder.push("Fyrite");
        serverFyriteVeinSize = builder
                .comment("Fyrite ore vein size")
                .translation(Netherrocks.MODID + ".config.serverFyriteVeinSize")
                .defineInRange("FyriteVeinSize", 6, 1, Integer.MAX_VALUE);
        serverFyriteVeinCount = builder
                .comment("Fyrite ore vein count per chunk")
                .translation(Netherrocks.MODID + ".config.serverFyriteVeinCount")
                .defineInRange("FyriteVeinCount", 10, 1, Integer.MAX_VALUE);
        serverFyriteBottomHeight = builder
                .comment("Fyrite ore minimum height (currently ignored)")
                .translation(Netherrocks.MODID + ".config.serverFyriteBottomHeight")
                .defineInRange("FyriteBottomHeight", 1, 1, 127);
        serverFyriteMaxHeight = builder
                .comment("Fyrite ore maximum height (currently ignored)")
                .translation(Netherrocks.MODID + ".config.serverFyriteMaxHeight")
                .defineInRange("FyriteMaxHeight", 128, 1, 128);
        builder.pop();
        
        builder.push("Illumenite");
        serverIllumeniteVeinSize = builder
                .comment("Illumenite ore vein size")
                .translation(Netherrocks.MODID + ".config.serverIllumeniteVeinSize")
                .defineInRange("IllumeniteVeinSize", 15, 1, Integer.MAX_VALUE);
        serverIllumeniteVeinCount = builder
                .comment("Illumenite ore vein count per chunk")
                .translation(Netherrocks.MODID + ".config.serverIllumeniteVeinCount")
                .defineInRange("IllumeniteVeinCount", 5, 1, Integer.MAX_VALUE);
        serverIllumeniteBottomHeight = builder
                .comment("Illumenite ore minimum height (currently ignored)")
                .translation(Netherrocks.MODID + ".config.serverIllumeniteBottomHeight")
                .defineInRange("IllumeniteBottomHeight", 1, 1, 127);
        serverIllumeniteMaxHeight = builder
                .comment("Illumenite ore maximum height (currently ignored)")
                .translation(Netherrocks.MODID + ".config.serverIllumeniteMaxHeight")
                .defineInRange("IllumeniteMaxHeight", 128, 1, 128);
        builder.pop();
        
        builder.push("Malachite");
        serverMalachiteVeinSize = builder
                .comment("Malachite ore vein size")
                .translation(Netherrocks.MODID + ".config.serverMalachiteVeinSize")
                .defineInRange("MalachiteVeinSize", 7, 1, Integer.MAX_VALUE);
        serverMalachiteVeinCount = builder
                .comment("Malachite ore vein count per chunk")
                .translation(Netherrocks.MODID + ".config.serverMalachiteVeinCount")
                .defineInRange("MalachiteVeinCount", 10, 1, Integer.MAX_VALUE);
        serverMalachiteBottomHeight = builder
                .comment("Malachite ore minimum height (currently ignored)")
                .translation(Netherrocks.MODID + ".config.serverMalachiteBottomHeight")
                .defineInRange("MalachiteBottomHeight", 1, 1, 127);
        serverMalachiteMaxHeight = builder
                .comment("Malachite ore maximum height (currently ignored)")
                .translation(Netherrocks.MODID + ".config.serverMalachiteMaxHeight")
                .defineInRange("MalachiteMaxHeight", 128, 1, 128);
        builder.pop();
        
		builder.pop();
	} // end ctor

} // end class ServerConfig
