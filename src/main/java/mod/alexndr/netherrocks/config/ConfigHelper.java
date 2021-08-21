package mod.alexndr.netherrocks.config;

import mod.alexndr.simplecorelib.config.ModOreConfig;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.configurations.RangeDecoratorConfiguration;
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
        NetherrocksConfig.argonite_cfg = new ModOreConfig(ModOreConfig.FULL_RANGE, 
        		ConfigHolder.SERVER.serverArgoniteVeinSize.get(), ConfigHolder.SERVER.serverArgoniteVeinCount.get(),
        		VerticalAnchor.absolute(ConfigHolder.SERVER.serverArgoniteBottomHeight.get()),
        		VerticalAnchor.absolute(ConfigHolder.SERVER.serverArgoniteMaxHeight.get()));
                
        
		NetherrocksConfig.enableAshstoneOre = ConfigHolder.SERVER.serverEnableAshstoneOre.get();
        NetherrocksConfig.ashstone_cfg = new ModOreConfig(ModOreConfig.FULL_RANGE, 
        		ConfigHolder.SERVER.serverAshstoneVeinSize.get(), ConfigHolder.SERVER.serverAshstoneVeinCount.get(),
        		VerticalAnchor.absolute(ConfigHolder.SERVER.serverAshstoneBottomHeight.get()),
        		VerticalAnchor.absolute(ConfigHolder.SERVER.serverAshstoneMaxHeight.get()));

		NetherrocksConfig.enableDragonstoneOre = ConfigHolder.SERVER.serverEnableDragonstoneOre.get();
        NetherrocksConfig.dragonstone_cfg = new ModOreConfig(ModOreConfig.FULL_RANGE,
        		ConfigHolder.SERVER.serverDragonstoneVeinSize.get(), ConfigHolder.SERVER.serverDragonstoneVeinCount.get(),
           		VerticalAnchor.absolute(ConfigHolder.SERVER.serverDragonstoneBottomHeight.get()),
        		VerticalAnchor.absolute(ConfigHolder.SERVER.serverDragonstoneMaxHeight.get()));
        
		NetherrocksConfig.enableFyriteOre = ConfigHolder.SERVER.serverEnableFyriteOre.get();
        NetherrocksConfig.fyrite_cfg = new ModOreConfig(ModOreConfig.FULL_RANGE, 
                ConfigHolder.SERVER.serverFyriteVeinSize.get(), ConfigHolder.SERVER.serverFyriteVeinCount.get(),
           		VerticalAnchor.absolute(ConfigHolder.SERVER.serverFyriteBottomHeight.get()),
        		VerticalAnchor.absolute(ConfigHolder.SERVER.serverFyriteMaxHeight.get()));
                
        NetherrocksConfig.enableIllumeniteOre = ConfigHolder.SERVER.serverEnableIllumeniteOre.get();
        NetherrocksConfig.illumenite_cfg = new ModOreConfig(ModOreConfig.FULL_RANGE, 
                ConfigHolder.SERVER.serverIllumeniteVeinSize.get(), ConfigHolder.SERVER.serverIllumeniteVeinCount.get(),
           		VerticalAnchor.absolute(ConfigHolder.SERVER.serverIllumeniteBottomHeight.get()),
        		VerticalAnchor.absolute(ConfigHolder.SERVER.serverIllumeniteMaxHeight.get()));

        NetherrocksConfig.enableMalachiteOre = ConfigHolder.SERVER.serverEnableMalachiteOre.get();
        NetherrocksConfig.malachite_cfg = new ModOreConfig(ModOreConfig.FULL_RANGE, 
                ConfigHolder.SERVER.serverMalachiteVeinSize.get(),ConfigHolder.SERVER.serverMalachiteVeinCount.get(),
           		VerticalAnchor.absolute(ConfigHolder.SERVER.serverMalachiteBottomHeight.get()),
        		VerticalAnchor.absolute(ConfigHolder.SERVER.serverMalachiteMaxHeight.get()));
	} // end bakeServer()

	@SuppressWarnings("unused")
	private static void setValueAndSave(final ModConfig modConfig, final String path, final Object newValue)
	{
		modConfig.getConfigData().set(path, newValue);
		modConfig.save();
	} // end setValueAndSave()

} // end class ConfigHelper
