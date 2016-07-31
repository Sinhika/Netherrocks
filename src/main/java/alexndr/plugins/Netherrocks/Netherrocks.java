package alexndr.plugins.Netherrocks;

import alexndr.api.logger.LogHelper;
import alexndr.api.registry.Plugin;
import alexndr.plugins.Netherrocks.helpers.NetherFurnaceGuiHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.IGuiHandler;
import net.minecraftforge.fml.common.network.NetworkRegistry;

/**
 * @author AleXndrTheGr8st
 */
@Mod(modid = ModInfo.ID, name = ModInfo.NAME, version = ModInfo.VERSION, 
	acceptedMinecraftVersions=ModInfo.ACCEPTED_VERSIONS,
	 dependencies = ModInfo.DEPENDENCIES, updateJSON=ModInfo.VERSIONURL)
public class Netherrocks 
{
	@Mod.Instance
	public static Netherrocks INSTANCE;

	@SidedProxy(clientSide = "alexndr.plugins.Netherrocks.ProxyClient", 
				serverSide = "alexndr.plugins.Netherrocks.ProxyCommon")
	public static ProxyCommon proxy;

	public static Plugin plugin = new Plugin(ModInfo.ID, ModInfo.NAME);
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event) 
	{
		LogHelper.info("Netherrocks", "Loading...");
		proxy.PreInit(event);
	}
	
	@EventHandler
	public void init(FMLInitializationEvent event) 
	{
		NetworkRegistry.INSTANCE.registerGuiHandler(this, (IGuiHandler) new NetherFurnaceGuiHandler());
		proxy.Init(event);
	} 
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent event) 
	{
		proxy.PostInit(event);
		LogHelper.info("Netherrocks", "Loading Complete!");
	}

} // end class
