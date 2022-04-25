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

//	public static void bakeClient(final ModConfig config) { }

	public static void bakeServer(final ModConfig config)
	{
	    NetherrocksConfig.addModLootToChests = ConfigHolder.SERVER.serverAddModLootToChests.get();

	    NetherrocksConfig.enableArgoniteOre = ConfigHolder.SERVER.serverEnableArgoniteOre.get();
		NetherrocksConfig.enableAshstoneOre = ConfigHolder.SERVER.serverEnableAshstoneOre.get();
		NetherrocksConfig.enableDragonstoneOre = ConfigHolder.SERVER.serverEnableDragonstoneOre.get();
		NetherrocksConfig.enableFyriteOre = ConfigHolder.SERVER.serverEnableFyriteOre.get();
        NetherrocksConfig.enableIllumeniteOre = ConfigHolder.SERVER.serverEnableIllumeniteOre.get();
        NetherrocksConfig.enableMalachiteOre = ConfigHolder.SERVER.serverEnableMalachiteOre.get();

        NetherrocksConfig.INSTANCE.putFlag("aesthetics_enabled", ConfigHolder.SERVER.serverEnableAesthetics.get());
	} // end bakeServer()

	@SuppressWarnings("unused")
	private static void setValueAndSave(final ModConfig modConfig, final String path, final Object newValue)
	{
		modConfig.getConfigData().set(path, newValue);
		modConfig.save();
	} // end setValueAndSave()

} // end class ConfigHelper
