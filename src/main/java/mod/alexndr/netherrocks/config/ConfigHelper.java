package mod.alexndr.netherrocks.config;

import mod.alexndr.simplecorelib.config.ModOreConfig;
import net.minecraft.world.gen.placement.TopSolidRangeConfig;
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
        NetherrocksConfig.argonite_cfg = new ModOreConfig(
                new TopSolidRangeConfig(ConfigHolder.SERVER.serverArgoniteBottomHeight.get(),
                        0, ConfigHolder.SERVER.serverArgoniteMaxHeight.get()),
                ConfigHolder.SERVER.serverArgoniteVeinSize.get(),
                ConfigHolder.SERVER.serverArgoniteVeinCount.get()); 
        
		NetherrocksConfig.enableAshstoneOre = ConfigHolder.SERVER.serverEnableAshstoneOre.get();
        NetherrocksConfig.ashstone_cfg = new ModOreConfig(
                new TopSolidRangeConfig(ConfigHolder.SERVER.serverAshstoneBottomHeight.get(), 
                        0, ConfigHolder.SERVER.serverAshstoneMaxHeight.get()),
                ConfigHolder.SERVER.serverAshstoneVeinSize.get(), 
                ConfigHolder.SERVER.serverAshstoneVeinCount.get());
        
		NetherrocksConfig.enableDragonstoneOre = ConfigHolder.SERVER.serverEnableDragonstoneOre.get();
        NetherrocksConfig.dragonstone_cfg = new ModOreConfig(
                new TopSolidRangeConfig(ConfigHolder.SERVER.serverDragonstoneBottomHeight.get(), 
                        0, ConfigHolder.SERVER.serverDragonstoneMaxHeight.get()),
                ConfigHolder.SERVER.serverDragonstoneVeinSize.get(), 
                ConfigHolder.SERVER.serverDragonstoneVeinCount.get());
        
		NetherrocksConfig.enableFyriteOre = ConfigHolder.SERVER.serverEnableFyriteOre.get();
        NetherrocksConfig.fyrite_cfg = new ModOreConfig(
                new TopSolidRangeConfig(ConfigHolder.SERVER.serverFyriteBottomHeight.get(), 
                        0, ConfigHolder.SERVER.serverFyriteMaxHeight.get() ),
                ConfigHolder.SERVER.serverFyriteVeinSize.get(),
                ConfigHolder.SERVER.serverFyriteVeinCount.get());
                
        NetherrocksConfig.enableIllumeniteOre = ConfigHolder.SERVER.serverEnableIllumeniteOre.get();
        NetherrocksConfig.illumenite_cfg = new ModOreConfig(
                new TopSolidRangeConfig(ConfigHolder.SERVER.serverIllumeniteBottomHeight.get(), 
                        0, ConfigHolder.SERVER.serverIllumeniteMaxHeight.get()),
                ConfigHolder.SERVER.serverIllumeniteVeinSize.get(),
                ConfigHolder.SERVER.serverIllumeniteVeinCount.get());

        NetherrocksConfig.enableMalachiteOre = ConfigHolder.SERVER.serverEnableMalachiteOre.get();
        NetherrocksConfig.malachite_cfg = new ModOreConfig(
                new TopSolidRangeConfig(ConfigHolder.SERVER.serverMalachiteBottomHeight.get(), 
                        0, ConfigHolder.SERVER.serverMalachiteMaxHeight.get()),
                ConfigHolder.SERVER.serverMalachiteVeinSize.get(),
                ConfigHolder.SERVER.serverMalachiteVeinCount.get());
	} // end bakeServer()

	@SuppressWarnings("unused")
	private static void setValueAndSave(final ModConfig modConfig, final String path, final Object newValue)
	{
		modConfig.getConfigData().set(path, newValue);
		modConfig.save();
	} // end setValueAndSave()

} // end class ConfigHelper
