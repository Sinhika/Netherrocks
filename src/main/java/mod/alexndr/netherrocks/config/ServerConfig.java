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
public final class ServerConfig
{

    final ForgeConfigSpec.BooleanValue serverAddModLootToChests;
    final ForgeConfigSpec.BooleanValue serverEnableAesthetics;
    final ForgeConfigSpec.BooleanValue serverEnableAshstoneGhastOre;
    public final ForgeConfigSpec.IntValue serverNetherrackBurnTime;
    public final ForgeConfigSpec.IntValue serverFyriteBurnTime;
    public final ForgeConfigSpec.IntValue serverBlazeRodBurnTime;
    public final ForgeConfigSpec.IntValue serverBaseToolBurnTime;
    
	ServerConfig(final ForgeConfigSpec.Builder builder)
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
