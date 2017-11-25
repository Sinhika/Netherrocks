package alexndr.plugins.netherrocks;

import java.util.List;

import com.google.common.collect.Lists;

import alexndr.api.core.SimpleCoreAPI;
import alexndr.api.helpers.game.OreGenerator;
import alexndr.api.helpers.game.TabHelper;
import alexndr.api.logger.LogHelper;
import alexndr.api.registry.ContentRegistry;
import alexndr.api.registry.Plugin;
import alexndr.plugins.netherrocks.helpers.FyriteHandler;
import alexndr.plugins.netherrocks.helpers.IllumeniteHandler;
import alexndr.plugins.netherrocks.tiles.NetherFurnaceTileEntity;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;


@Mod.EventBusSubscriber
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
		
		Content.preInitialize();
	} // end PreInit

	public void Init(FMLInitializationEvent event)
	{
		setTabIcons();
		Content.setRepairMaterials();
		
		setOreGenSettings();
		Content.addSmeltingRecipes();
		
		MinecraftForge.EVENT_BUS.register(FyriteHandler.INSTANCE);
		MinecraftForge.EVENT_BUS.register(IllumeniteHandler.INSTANCE);
	} // end Init()

	public void PostInit(FMLPostInitializationEvent event)
	{
	} // end PostInit()

	private static void setTabIcons() 
	{
		LogHelper.verbose("Netherrocks", "Setting tab icons");
		List<Item> list = Lists.newArrayList(Item.getItemFromBlock(ModBlocks.fyrite_ore), 
						Item.getItemFromBlock(ModBlocks.dragonstone_block), 
						ModItems.malachite_ingot, ModItems.ashstone_pickaxe, 
						ModItems.argonite_sword, Item.getItemFromBlock(ModBlocks.nether_furnace));
		SimpleCoreAPI.setTabIcons(list);
	}
	
	private static void setOreGenSettings() 
	{
		LogHelper.verbose("Netherrocks", "Setting ore gen paramaters");
		if (Settings.fyriteOre.isEnableOreGen()) {
			OreGenerator.registerOreForGen(-1, ModBlocks.fyrite_ore, Blocks.NETHERRACK, 
					Settings.fyriteOre.getSpawnRate(), Settings.fyriteOre.getVeinSize(), 
					Settings.fyriteOre.getMinHeight(), Settings.fyriteOre.getMaxHeight());
		}
		if (Settings.malachiteOre.isEnableOreGen()) {
			OreGenerator.registerOreForGen(-1, ModBlocks.malachite_ore, Blocks.NETHERRACK, 
					Settings.malachiteOre.getSpawnRate(), Settings.malachiteOre.getVeinSize(), 
					Settings.malachiteOre.getMinHeight(), Settings.malachiteOre.getMaxHeight());
		}
		if (Settings.ashstoneOre.isEnableOreGen()) {
			OreGenerator.registerOreForGen(-1, ModBlocks.ashstone_ore, Blocks.NETHERRACK, 
					Settings.ashstoneOre.getSpawnRate(), Settings.ashstoneOre.getVeinSize(), 
					Settings.ashstoneOre.getMinHeight(), Settings.ashstoneOre.getMaxHeight());
		}
		if (Settings.illumeniteOre.isEnableOreGen()) {
			OreGenerator.registerOreForGen(-1, ModBlocks.illumenite_ore, Blocks.GLOWSTONE, 
					Settings.illumeniteOre.getSpawnRate(), Settings.illumeniteOre.getVeinSize(), 
					Settings.illumeniteOre.getMinHeight(), Settings.illumeniteOre.getMaxHeight());
		}
		if (Settings.dragonstoneOre.isEnableOreGen()) {
			OreGenerator.registerOreForGen(-1, ModBlocks.dragonstone_ore, Blocks.NETHERRACK, 
					Settings.dragonstoneOre.getSpawnRate(), Settings.dragonstoneOre.getVeinSize(), 
					Settings.dragonstoneOre.getMinHeight(), Settings.dragonstoneOre.getMaxHeight());
		}
		if (Settings.argoniteOre.isEnableOreGen()) {
			OreGenerator.registerOreForGen(-1, ModBlocks.argonite_ore, Blocks.NETHERRACK, 
					Settings.argoniteOre.getSpawnRate(), Settings.argoniteOre.getVeinSize(), 
					Settings.argoniteOre.getMinHeight(), Settings.argoniteOre.getMaxHeight());
		}
	} // end setOreGenSettings()

	@SuppressWarnings("unchecked")
	@SubscribeEvent
	public static void registerBlocks(RegistryEvent.Register<Block> event) 
			throws ClassNotFoundException 
	{
   	 //Registers
   	 if (Settings.netherFurnace.isEnabled()) 
   	 {
   		 Class<?> c = Class.forName("alexndr.plugins.netherrocks.tiles.NetherFurnaceTileEntity");
		 GameRegistry.registerTileEntity( (Class<? extends TileEntity>) c, 
				 						  NetherFurnaceTileEntity.tilename);
   	 }
     ModBlocks.register(event.getRegistry());
    	 
	} // end registerBlocks()

	@SubscribeEvent
	public static void registerItems(RegistryEvent.Register<Item> event) 
	{
    	ModItems.register(event.getRegistry());
    	ModBlocks.registerItemBlocks(event.getRegistry());
        ModItems.registerOreDictionary();
        ModBlocks.registerOreDictionary();
	}

	public void registerItemRenderer(Plugin plugin, Item item, int meta, String id) {
	}

} // end class
