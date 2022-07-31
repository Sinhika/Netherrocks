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

    final ForgeConfigSpec.BooleanValue serverAddModLootToChests;
    final ForgeConfigSpec.BooleanValue serverEnableAesthetics;
    final ForgeConfigSpec.BooleanValue serverEnableAshstoneGhastOre;
    
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
	    
	} // end ctor

} // end class ServerConfig
