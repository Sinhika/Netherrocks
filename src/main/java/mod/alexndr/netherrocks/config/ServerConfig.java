package mod.alexndr.netherrocks.config;

import mod.alexndr.netherrocks.Netherrocks;
import net.neoforged.neoforge.common.NeoForgeConfigSpec;

/**
 * For configuration settings that change the behaviour of code on the LOGICAL SERVER.
 * This can be moved to an inner class of ExampleModConfig, but is separate because of personal preference and to keep the code organised
 *
 * @author Cadiboo
 * @author Sinhika
 */
public final class ServerConfig
{

    final NeoForgeConfigSpec.BooleanValue serverAddModLootToChests;
    final NeoForgeConfigSpec.BooleanValue serverEnableAesthetics;
    final NeoForgeConfigSpec.BooleanValue serverEnableAshstoneGhastOre;
    public final NeoForgeConfigSpec.IntValue serverNetherrackBurnTime;
    public final NeoForgeConfigSpec.IntValue serverFyriteBurnTime;
    public final NeoForgeConfigSpec.IntValue serverBlazeRodBurnTime;
    public final NeoForgeConfigSpec.IntValue serverBaseToolBurnTime;
    
	ServerConfig(final NeoForgeConfigSpec.Builder builder)
	{
	    builder.push("General");
	    serverAddModLootToChests = builder.comment("Add Netherrocks items to chest loot?")
                .translation(Netherrocks.MODID + ".config.serverAddModLootToChests")
                .define("AddModLootToChests", true);
        serverEnableAesthetics = builder.comment("Enable Netherrocks aesthetic blocks?")
                .translation(Netherrocks.MODID + "config.EnableAesthetics")
                .define("EnableAestheticsBlocks", true);
        serverEnableAshstoneGhastOre = builder.comment("Enable Ashstone to double as ghast tear ore?")
                .translation(Netherrocks.MODID + "config.EnableAshstoneGhastOre")
                .define("EnableAshstoneGhastOre", false);
	    builder.pop();
	    builder.push("Nether Furnace Fuels");
	    serverNetherrackBurnTime = builder.comment("Ticks to consume 1 block of netherrack")
	            .defineInRange("NetherrackBurnTime", 200, 1, 10000);
	    serverFyriteBurnTime = builder.comment("Ticks to consume 1 ingot of fyrite: base for several other burn times")
	            .defineInRange("FyriteBurnTime", 8000, 1, 32000);
	    serverBlazeRodBurnTime = builder.comment("Ticks to consume 1 blaze rod; base for certain other burn times")
	            .defineInRange("BlazeRodBurnTime", 2400, 1, 20000);
	    serverBaseToolBurnTime = builder.comment("Ticks to consume 1 fyrite tool")
	            .defineInRange("BaseToolBurntime", 3200, 1, 32000);
	    builder.pop();
	} // end ctor

} // end class ServerConfig
