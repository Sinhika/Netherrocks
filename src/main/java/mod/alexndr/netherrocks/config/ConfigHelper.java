package mod.alexndr.netherrocks.config;

import net.minecraft.world.gen.placement.CountRangeConfig;
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
		NetherrocksConfig.enableArgoniteOre = ConfigHolder.SERVER.serverEnableArgoniteOre.get();
        NetherrocksConfig.argonite_veinsize = ConfigHolder.SERVER.serverArgoniteVeinSize.get();
        NetherrocksConfig.argonite_cfg = new CountRangeConfig(  
                ConfigHolder.SERVER.serverArgoniteVeinCount.get(),
                ConfigHolder.SERVER.serverArgoniteBottomHeight.get(), 
                0, ConfigHolder.SERVER.serverArgoniteMaxHeight.get() 
        );
        
		NetherrocksConfig.enableAshstoneOre = ConfigHolder.SERVER.serverEnableAshstoneOre.get();
        NetherrocksConfig.ashstone_veinsize = ConfigHolder.SERVER.serverAshstoneVeinSize.get();
        NetherrocksConfig.ashstone_cfg = new CountRangeConfig(  
                ConfigHolder.SERVER.serverAshstoneVeinCount.get(),
                ConfigHolder.SERVER.serverAshstoneBottomHeight.get(), 
                0, ConfigHolder.SERVER.serverAshstoneMaxHeight.get() 
        );
        
		NetherrocksConfig.enableDragonstoneOre = ConfigHolder.SERVER.serverEnableDragonstoneOre.get();
        NetherrocksConfig.dragonstone_veinsize = ConfigHolder.SERVER.serverDragonstoneVeinSize.get();
        NetherrocksConfig.dragonstone_cfg = new CountRangeConfig(  
                ConfigHolder.SERVER.serverDragonstoneVeinCount.get(),
                ConfigHolder.SERVER.serverDragonstoneBottomHeight.get(), 
                0, ConfigHolder.SERVER.serverDragonstoneMaxHeight.get() 
        );
        
		NetherrocksConfig.enableFyriteOre = ConfigHolder.SERVER.serverEnableFyriteOre.get();
        NetherrocksConfig.fyrite_veinsize = ConfigHolder.SERVER.serverFyriteVeinSize.get();
        NetherrocksConfig.fyrite_cfg = new CountRangeConfig(  
                ConfigHolder.SERVER.serverFyriteVeinCount.get(),
                ConfigHolder.SERVER.serverFyriteBottomHeight.get(), 
                0, ConfigHolder.SERVER.serverFyriteMaxHeight.get() 
        );

        NetherrocksConfig.enableIllumeniteOre = ConfigHolder.SERVER.serverEnableIllumeniteOre.get();
        NetherrocksConfig.illumenite_veinsize = ConfigHolder.SERVER.serverIllumeniteVeinSize.get();
        NetherrocksConfig.illumenite_cfg = new CountRangeConfig(  
                ConfigHolder.SERVER.serverIllumeniteVeinCount.get(),
                ConfigHolder.SERVER.serverIllumeniteBottomHeight.get(), 
                0, ConfigHolder.SERVER.serverIllumeniteMaxHeight.get() 
        );

        NetherrocksConfig.enableMalachiteOre = ConfigHolder.SERVER.serverEnableMalachiteOre.get();
        NetherrocksConfig.malachite_veinsize = ConfigHolder.SERVER.serverMalachiteVeinSize.get();
        NetherrocksConfig.malachite_cfg = new CountRangeConfig(  
                ConfigHolder.SERVER.serverMalachiteVeinCount.get(),
                ConfigHolder.SERVER.serverMalachiteBottomHeight.get(), 
                0, ConfigHolder.SERVER.serverMalachiteMaxHeight.get() 
        );
	} // end bakeServer()

	@SuppressWarnings("unused")
	private static void setValueAndSave(final ModConfig modConfig, final String path, final Object newValue)
	{
		modConfig.getConfigData().set(path, newValue);
		modConfig.save();
	} // end setValueAndSave()

} // end class ConfigHelper
