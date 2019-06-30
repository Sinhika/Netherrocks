package mod.alexndr.netherrocks.config;

import net.minecraftforge.fml.config.ModConfig;

/**
 * This bakes the config values to normal fields
 *
 * @author Cadiboo
 * It can be merged into the main ExampleModConfig class, but is separate because of personal preference and to keep the code organised
 */
public final class ConfigHelper
{

	// We store a reference to the ModConfigs here to be able to change the values in them from our code
	// (For example from a config GUI)
	private static ModConfig serverConfig;

//	public static void bakeClient(final ModConfig config) { }

	public static void bakeServer(final ModConfig config)
	{
		serverConfig = config;

		NetherrocksConfig.enableArgoniteOre = ConfigHolder.SERVER.serverEnableArgoniteOre.get();
		NetherrocksConfig.enableAshstoneOre = ConfigHolder.SERVER.serverEnableArgoniteOre.get();
		NetherrocksConfig.enableDragonstoneOre = ConfigHolder.SERVER.serverEnableArgoniteOre.get();
		NetherrocksConfig.enableFyriteOre = ConfigHolder.SERVER.serverEnableArgoniteOre.get();
		NetherrocksConfig.enableIllumeniteOre = ConfigHolder.SERVER.serverEnableArgoniteOre.get();
		NetherrocksConfig.enableMalachiteOre = ConfigHolder.SERVER.serverEnableArgoniteOre.get();
	} // end bakeServer()

	private static void setValueAndSave(final ModConfig modConfig, final String path, final Object newValue)
	{
		modConfig.getConfigData().set(path, newValue);
		modConfig.save();
	} // end setValueAndSave()

} // end class ConfigHelper
