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
	final ForgeConfigSpec.BooleanValue serverEnableAshstoneOre;
	final ForgeConfigSpec.BooleanValue serverEnableDragonstoneOre;
	final ForgeConfigSpec.BooleanValue serverEnableFyriteOre;
	final ForgeConfigSpec.BooleanValue serverEnableIllumeniteOre;
	final ForgeConfigSpec.BooleanValue serverEnableMalachiteOre;
	// TODO

	ServerConfig(final ForgeConfigSpec.Builder builder)
	{
		builder.push("general");
		serverEnableArgoniteOre = builder
				.comment("Enable argonite ore generation?")
				.translation(Netherrocks.MODID + ".config.serverEnableArgoniteOre")
				.define("serverEnableArgoniteOre", true);
		serverEnableAshstoneOre = builder
				.comment("Enable ashstone ore generation?")
				.translation(Netherrocks.MODID + ".config.serverEnableAshstoneOre")
				.define("serverEnableAshstoneOre", true);
		serverEnableDragonstoneOre = builder
				.comment("Enable dragonstone ore generation?")
				.translation(Netherrocks.MODID + ".config.serverEnableDragonstoneOre")
				.define("serverEnableDragonstoneOre", true);
		serverEnableFyriteOre = builder
				.comment("Enable fyrite ore generation?")
				.translation(Netherrocks.MODID + ".config.serverEnableFyriteOre")
				.define("serverEnableFyriteOre", true);
		serverEnableIllumeniteOre = builder
				.comment("Enable illumenite ore generation?")
				.translation(Netherrocks.MODID + ".config.serverEnableIllumeniteOre")
				.define("serverEnableIllumeniteOre", true);
		serverEnableMalachiteOre = builder
				.comment("Enable malachite ore generation?")
				.translation(Netherrocks.MODID + ".config.serverEnableMalachiteOre")
				.define("serverEnableMalachiteOre", true);
		builder.pop();
	} // end ctor

} // end class ServerConfig
