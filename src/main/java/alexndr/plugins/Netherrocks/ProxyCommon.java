package alexndr.plugins.Netherrocks;

import java.util.List;

import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import alexndr.api.core.SimpleCoreAPI;
import alexndr.api.helpers.game.OreGenerator;
import alexndr.api.helpers.game.TabHelper;
import alexndr.api.logger.LogHelper;
import alexndr.api.registry.ContentRegistry;
import alexndr.plugins.Netherrocks.helpers.FyriteHandler;
import alexndr.plugins.Netherrocks.helpers.IllumeniteHandler;

import com.google.common.collect.Lists;


public class ProxyCommon 
{

	public void PreInit(FMLPreInitializationEvent event)
	{	
		//Configuration
		ContentRegistry.registerPlugin(Netherrocks.plugin);
		Settings.createOrLoadSettings(event);
		
		// in the event this is standalone..
		if (! TabHelper.wereTabsInitialized()) {
			SimpleCoreAPI.tabPreInit();
		}
		Netherrocks.tabPreInit();
		
		//Content
		Content.preInitialize();
		Recipes.preInitialize();
	} // end PreInit

	public void Init(FMLInitializationEvent event)
	{
		//Content
		Recipes.initialize();
		setTabIcons();
		Content.setRepairMaterials();
		Content.setAchievementTriggers();
		
		setOreGenSettings();
		
		MinecraftForge.EVENT_BUS.register(FyriteHandler.INSTANCE);
		MinecraftForge.EVENT_BUS.register(IllumeniteHandler.INSTANCE);
	} // end Init()

	public void PostInit(FMLPostInitializationEvent event)
	{
	} // end PostInit()

	private static void setTabIcons() 
	{
		LogHelper.verbose("Netherrocks", "Setting tab icons");
		List<Item> list = Lists.newArrayList(Item.getItemFromBlock(Content.fyrite_ore), 
						Item.getItemFromBlock(Content.dragonstone_block), 
						Content.malachite_ingot, Content.ashstone_pickaxe, Content.argonite_sword);
		SimpleCoreAPI.setTabIcons(list);
		Netherrocks.simpleMachines.setIcon(Item.getItemFromBlock(Content.nether_furnace));
	}
	
	private static void setOreGenSettings() 
	{
		LogHelper.verbose("Netherrocks", "Setting ore gen paramaters");
		OreGenerator.registerOreForGen(-1, Content.fyrite_ore, Blocks.NETHERRACK, 
				Settings.fyriteOre.getSpawnRate(), Settings.fyriteOre.getVeinSize(), 
				Settings.fyriteOre.getMinHeight(), Settings.fyriteOre.getMaxHeight());
		OreGenerator.registerOreForGen(-1, Content.malachite_ore, Blocks.NETHERRACK, 
				Settings.malachiteOre.getSpawnRate(), Settings.malachiteOre.getVeinSize(), 
				Settings.malachiteOre.getMinHeight(), Settings.malachiteOre.getMaxHeight());
		OreGenerator.registerOreForGen(-1, Content.ashstone_ore, Blocks.NETHERRACK, 
				Settings.ashstoneOre.getSpawnRate(), Settings.ashstoneOre.getVeinSize(), 
				Settings.ashstoneOre.getMinHeight(), Settings.ashstoneOre.getMaxHeight());
		OreGenerator.registerOreForGen(-1, Content.illumenite_ore, Blocks.GLOWSTONE, 
				Settings.illumeniteOre.getSpawnRate(), Settings.illumeniteOre.getVeinSize(), 
				Settings.illumeniteOre.getMinHeight(), Settings.illumeniteOre.getMaxHeight());
		OreGenerator.registerOreForGen(-1, Content.dragonstone_ore, Blocks.NETHERRACK, 
				Settings.dragonstoneOre.getSpawnRate(), Settings.dragonstoneOre.getVeinSize(), 
				Settings.dragonstoneOre.getMinHeight(), Settings.dragonstoneOre.getMaxHeight());
		OreGenerator.registerOreForGen(-1, Content.argonite_ore, Blocks.NETHERRACK, 
				Settings.argoniteOre.getSpawnRate(), Settings.argoniteOre.getVeinSize(), 
				Settings.argoniteOre.getMinHeight(), Settings.argoniteOre.getMaxHeight());
	} // end setOreGenSettings()

} // end class
