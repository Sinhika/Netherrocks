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
	// TODO

	ServerConfig(final ForgeConfigSpec.Builder builder)
	{
		builder.push("general");
		serverEnableArgoniteOre = builder
				.comment("Enable argonite ore generation?")
				.translation(Netherrocks.MODID + ".config.serverEnableArgoniteOre")
				.define("serverEnableArgoniteOre", true);
		// TODO
		builder.pop();
	} // end ctor

} // end class ServerConfig
