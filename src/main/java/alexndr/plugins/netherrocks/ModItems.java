package alexndr.plugins.netherrocks;

import alexndr.api.content.items.SimpleArmor;
import alexndr.api.content.items.SimpleAxe;
import alexndr.api.content.items.SimpleHoe;
import alexndr.api.content.items.SimpleItem;
import alexndr.api.content.items.SimplePickaxe;
import alexndr.api.content.items.SimpleShovel;
import alexndr.api.content.items.SimpleSword;
import alexndr.api.core.SimpleCoreAPI;
import alexndr.api.helpers.game.TabHelper;
import alexndr.plugins.netherrocks.items.FyriteArmor;
import alexndr.plugins.netherrocks.items.FyriteAxe;
import alexndr.plugins.netherrocks.items.FyritePickaxe;
import alexndr.plugins.netherrocks.items.FyriteShovel;
import alexndr.plugins.netherrocks.items.FyriteSword;
import alexndr.plugins.netherrocks.items.IllumeniteArmor;
import alexndr.plugins.netherrocks.items.IllumeniteSword;
import alexndr.plugins.netherrocks.items.MalachiteArmor;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.registries.IForgeRegistry;

public class ModItems 
{
	// INGOTS, ETC
	public static SimpleItem fyrite_ingot = new SimpleItem("fyrite_ingot", Netherrocks.plugin);
	public static SimpleItem malachite_ingot = 
			new SimpleItem("malachite_ingot", Netherrocks.plugin);
	public static SimpleItem ashstone_gem = new SimpleItem("ashstone_gem", Netherrocks.plugin);
	public static SimpleItem illumenite_ingot = 
			new SimpleItem("illumenite_ingot", Netherrocks.plugin);
	public static SimpleItem dragonstone_gem = new SimpleItem("dragonstone_gem", Netherrocks.plugin);
	public static SimpleItem argonite_ingot = new SimpleItem("argonite_ingot", Netherrocks.plugin);

	// ARMOR
	// fyrite
	public static FyriteArmor fyrite_helmet = 
			new FyriteArmor("fyrite_helmet", EntityEquipmentSlot.HEAD, Settings.fyriteEffect);
	public static FyriteArmor fyrite_chestplate = 
			new FyriteArmor("fyrite_chestplate", EntityEquipmentSlot.CHEST, Settings.fyriteEffect);
	public static FyriteArmor fyrite_leggings = 
			new FyriteArmor("fyrite_leggings", EntityEquipmentSlot.LEGS,Settings.fyriteEffect);
	public static FyriteArmor fyrite_boots = 
			new FyriteArmor("fyrite_boots", EntityEquipmentSlot.FEET, Settings.fyriteEffect);

	// malachite armor
	public static MalachiteArmor malachite_helmet = 
			new MalachiteArmor("malachite_helmet", EntityEquipmentSlot.HEAD, 
								Settings.malachiteEffect, Settings.malachiteJumpBoost);
	public static MalachiteArmor malachite_chestplate = 
			new MalachiteArmor("malachite_chestplate", EntityEquipmentSlot.CHEST, 
								Settings.malachiteEffect, Settings.malachiteJumpBoost);
	public static MalachiteArmor malachite_leggings = 
			new MalachiteArmor("malachite_leggings", EntityEquipmentSlot.LEGS, 
								Settings.malachiteEffect, Settings.malachiteJumpBoost);
	public static MalachiteArmor malachite_boots = 
			new MalachiteArmor("malachite_boots", EntityEquipmentSlot.FEET, 
							Settings.malachiteEffect, Settings.malachiteJumpBoost);
	
	// illumenite armor
	public static IllumeniteArmor illumenite_helmet = 
			new IllumeniteArmor("illumenite_helmet", EntityEquipmentSlot.HEAD,
								Settings.illumeniteEffect);
	public static IllumeniteArmor illumenite_chestplate = 
			new IllumeniteArmor("illumenite_chestplate", EntityEquipmentSlot.CHEST, 
								Settings.illumeniteEffect);
	public static IllumeniteArmor illumenite_leggings = 
			new IllumeniteArmor("illumenite_leggings", EntityEquipmentSlot.LEGS, 
								Settings.illumeniteEffect);
	public static IllumeniteArmor illumenite_boots = 
			new IllumeniteArmor("illumenite_boots", EntityEquipmentSlot.FEET,
								Settings.illumeniteEffect);
	// dragonstone armor
	public static SimpleArmor dragonstone_helmet = 
			new SimpleArmor("dragonstone_helmet", Netherrocks.plugin, Content.armorDragonstone, 
							 EntityEquipmentSlot.HEAD);
	public static SimpleArmor dragonstone_chestplate = 
			new SimpleArmor("dragonstone_chestplate", Netherrocks.plugin, Content.armorDragonstone,
					EntityEquipmentSlot.CHEST);
	public static SimpleArmor dragonstone_leggings = 
			new SimpleArmor("dragonstone_leggings", Netherrocks.plugin, Content.armorDragonstone, 
					EntityEquipmentSlot.LEGS);
	public static SimpleArmor dragonstone_boots = 
			new SimpleArmor("dragonstone_boots", Netherrocks.plugin, Content.armorDragonstone, 
					EntityEquipmentSlot.FEET);

	// TOOLS
	// fyrite tools
	public static FyritePickaxe fyrite_pickaxe = new FyritePickaxe("fyrite_pickaxe");
	public static FyriteAxe fyrite_axe = new FyriteAxe("fyrite_axe");
	public static FyriteShovel fyrite_shovel = new FyriteShovel("fyrite_shovel");
	public static FyriteSword fyrite_sword = new FyriteSword("fyrite_sword");
	
	// malachite tools
	public static SimplePickaxe malachite_pickaxe = 
			new SimplePickaxe("malachite_pickaxe", Netherrocks.plugin, Content.toolMalachite);
	public static SimpleAxe malachite_axe = 
			new SimpleAxe("malachite_axe", Netherrocks.plugin, Content.toolMalachite);
	public static SimpleShovel malachite_shovel = 
			new SimpleShovel("malachite_shovel", Netherrocks.plugin, Content.toolMalachite);
	public static SimpleSword malachite_sword = 
			new SimpleSword("malachite_sword", Netherrocks.plugin, Content.toolMalachite);
	public static SimpleHoe malachite_hoe = 
			new SimpleHoe("malachite_hoe", Netherrocks.plugin, Content.toolMalachite);
	
	// ashstone tools
	public static SimplePickaxe ashstone_pickaxe = 
			new SimplePickaxe("ashstone_pickaxe", Netherrocks.plugin, Content.toolAshstone);
	public static SimpleAxe ashstone_axe = 
			new SimpleAxe("ashstone_axe", Netherrocks.plugin, Content.toolAshstone);
	public static SimpleShovel ashstone_shovel = 
			new SimpleShovel("ashstone_shovel", Netherrocks.plugin, Content.toolAshstone);
	public static SimpleHoe ashstone_hoe = 
			new SimpleHoe("ashstone_hoe", Netherrocks.plugin, Content.toolAshstone);
	public static SimpleSword ashstone_sword = 
			new SimpleSword("ashstone_sword", Netherrocks.plugin, Content.toolAshstone);
	
	// dragonstone tools
	public static SimplePickaxe dragonstone_pickaxe = 
			new SimplePickaxe("dragonstone_pickaxe", Netherrocks.plugin, Content.toolDragonstone);
	public static SimpleAxe dragonstone_axe = 
			new SimpleAxe("dragonstone_axe", Netherrocks.plugin, Content.toolDragonstone);
	public static SimpleShovel dragonstone_shovel = 
			new SimpleShovel("dragonstone_shovel", Netherrocks.plugin, Content.toolDragonstone);
	public static SimpleHoe dragonstone_hoe = 
			new SimpleHoe("dragonstone_hoe", Netherrocks.plugin, Content.toolDragonstone);
	public static SimpleSword dragonstone_sword = 
			new SimpleSword("dragonstone_sword", Netherrocks.plugin, Content.toolDragonstone);
	
	// argonite tools
	public static SimplePickaxe argonite_pickaxe = 
			new SimplePickaxe("argonite_pickaxe", Netherrocks.plugin, Content.toolArgonite);
	public static SimpleAxe argonite_axe = 
			new SimpleAxe("argonite_axe", Netherrocks.plugin, Content.toolArgonite);
	public static SimpleShovel argonite_shovel = 
			new SimpleShovel("argonite_shovel", Netherrocks.plugin, Content.toolArgonite);
	public static SimpleHoe argonite_hoe = 
			new SimpleHoe("argonite_hoe", Netherrocks.plugin, Content.toolArgonite);
	public static SimpleSword argonite_sword = 
			new SimpleSword("argonite_sword", Netherrocks.plugin, Content.toolArgonite);
	
	// illumenite sword
	public static IllumeniteSword illumenite_sword = new IllumeniteSword("illumenite_sword");

	public static void configureTools() 
	{
		if (Settings.fyriteTools.isEnabled()) 
		{
			fyrite_sword.setConfigEntry(Settings.fyriteTools)
					.addToolTip("netherrocks.fyrite_sword.info")
					.setCreativeTab(TabHelper.combatTab(SimpleCoreAPI.plugin));
			fyrite_pickaxe.setConfigEntry(Settings.fyriteTools)
					.addToolTip("netherrocks.fyrite_pickaxe.info")
					.setCreativeTab(TabHelper.toolsTab(SimpleCoreAPI.plugin));
			fyrite_axe.setConfigEntry(Settings.fyriteTools)
					.addToolTip("netherrocks.fyrite_axe.info")
					.setCreativeTab(TabHelper.toolsTab(SimpleCoreAPI.plugin));
			fyrite_shovel.setConfigEntry(Settings.fyriteTools)
					.addToolTip("netherrocks.fyrite_shovel.info")
					.setCreativeTab(TabHelper.toolsTab(SimpleCoreAPI.plugin));
		}
		if (Settings.malachiteTools.isEnabled()) 
		{
			malachite_pickaxe.setConfigEntry(Settings.malachiteTools)
					.setCreativeTab(TabHelper.toolsTab(SimpleCoreAPI.plugin));
			malachite_axe.setConfigEntry(Settings.malachiteTools)
					.setCreativeTab(TabHelper.toolsTab(SimpleCoreAPI.plugin));
			malachite_shovel.setConfigEntry(Settings.malachiteTools)
					.setCreativeTab(TabHelper.toolsTab(SimpleCoreAPI.plugin));
			malachite_hoe.setConfigEntry(Settings.malachiteTools)
					.setCreativeTab(TabHelper.toolsTab(SimpleCoreAPI.plugin));
			malachite_sword.setConfigEntry(Settings.malachiteTools)
					.setCreativeTab(TabHelper.combatTab(SimpleCoreAPI.plugin));
		}
		if (Settings.illumeniteTools.isEnabled()) {
			illumenite_sword.setConfigEntry(Settings.fyriteTools)
					.addToolTip("netherrocks.illumenite_sword.info")
					.setCreativeTab(TabHelper.combatTab(SimpleCoreAPI.plugin));
		}
		if (Settings.ashstoneTools.isEnabled()) 
		{
			ashstone_pickaxe.setConfigEntry(Settings.ashstoneTools)
					.setCreativeTab(TabHelper.toolsTab(SimpleCoreAPI.plugin));
			ashstone_axe.setConfigEntry(Settings.ashstoneTools)
					.setCreativeTab(TabHelper.toolsTab(SimpleCoreAPI.plugin));
			ashstone_shovel.setConfigEntry(Settings.ashstoneTools)
					.setCreativeTab(TabHelper.toolsTab(SimpleCoreAPI.plugin));
			ashstone_hoe.setConfigEntry(Settings.ashstoneTools)
					.setCreativeTab(TabHelper.toolsTab(SimpleCoreAPI.plugin));
			ashstone_sword.setConfigEntry(Settings.ashstoneTools)
					.setCreativeTab(TabHelper.combatTab(SimpleCoreAPI.plugin));
		}
		if (Settings.dragonstoneTools.isEnabled()) 
		{
			dragonstone_pickaxe.setConfigEntry(Settings.dragonstoneTools)
					.setCreativeTab(TabHelper.toolsTab(SimpleCoreAPI.plugin));
			dragonstone_axe.setConfigEntry(Settings.dragonstoneTools)
					.setCreativeTab(TabHelper.toolsTab(SimpleCoreAPI.plugin));
			dragonstone_shovel.setConfigEntry(Settings.dragonstoneTools)
					.setCreativeTab(TabHelper.toolsTab(SimpleCoreAPI.plugin));
			dragonstone_hoe.setConfigEntry(Settings.dragonstoneTools)
					.setCreativeTab(TabHelper.toolsTab(SimpleCoreAPI.plugin));
			dragonstone_sword.setConfigEntry(Settings.dragonstoneTools)
					.setCreativeTab(TabHelper.combatTab(SimpleCoreAPI.plugin));
		}
		if (Settings.argoniteTools.isEnabled()) 
		{
			argonite_pickaxe.setConfigEntry(Settings.argoniteTools)
					.setCreativeTab(TabHelper.toolsTab(SimpleCoreAPI.plugin));
			argonite_axe.setConfigEntry(Settings.argoniteTools)
					.setCreativeTab(TabHelper.toolsTab(SimpleCoreAPI.plugin));
			argonite_shovel.setConfigEntry(Settings.argoniteTools)
					.setCreativeTab(TabHelper.toolsTab(SimpleCoreAPI.plugin));
			argonite_hoe.setConfigEntry(Settings.argoniteTools)
					.setCreativeTab(TabHelper.toolsTab(SimpleCoreAPI.plugin));
			argonite_sword.setConfigEntry(Settings.argoniteTools)
					.setCreativeTab(TabHelper.combatTab(SimpleCoreAPI.plugin));
		}
	} // end configureTools()
	

public static void configureArmor() 
{
	if (Settings.fyriteArmor.isEnabled()) 
	{
		fyrite_helmet.setConfigEntry(Settings.fyriteArmor).setType("fyrite")
			.addToolTip("netherrocks.fyriteArmor.info", TextFormatting.GREEN)
			.setCreativeTab(TabHelper.combatTab(SimpleCoreAPI.plugin));
		fyrite_chestplate.setConfigEntry(Settings.fyriteArmor).setType("fyrite")
			.addToolTip("netherrocks.fyriteArmor.info", TextFormatting.GREEN)
			.setCreativeTab(TabHelper.combatTab(SimpleCoreAPI.plugin));
		fyrite_leggings.setConfigEntry(Settings.fyriteArmor).setType("fyrite")
			.addToolTip("netherrocks.fyriteArmor.info", TextFormatting.GREEN)
			.setCreativeTab(TabHelper.combatTab(SimpleCoreAPI.plugin));
		fyrite_boots.setConfigEntry(Settings.fyriteArmor).setType("fyrite")
			.addToolTip("netherrocks.fyriteArmor.info", TextFormatting.GREEN)
			.setCreativeTab(TabHelper.combatTab(SimpleCoreAPI.plugin));
	}
	if (Settings.malachiteArmor.isEnabled()) 
	{
		malachite_helmet.setConfigEntry(Settings.malachiteArmor).setType("malachite")
				.addToolTip("netherrocks.malachiteArmor.info", TextFormatting.GREEN)
				.setCreativeTab(TabHelper.combatTab(SimpleCoreAPI.plugin));
		malachite_chestplate.setConfigEntry(Settings.malachiteArmor).setType("malachite")
				.addToolTip("netherrocks.malachiteArmor.info", TextFormatting.GREEN)
				.setCreativeTab(TabHelper.combatTab(SimpleCoreAPI.plugin));
		malachite_leggings.setConfigEntry(Settings.malachiteArmor).setType("malachite")
				.addToolTip("netherrocks.malachiteArmor.info", TextFormatting.GREEN)
				.setCreativeTab(TabHelper.combatTab(SimpleCoreAPI.plugin));
		malachite_boots.setConfigEntry(Settings.malachiteArmor).setType("malachite")
				.addToolTip("netherrocks.malachiteArmor.info", TextFormatting.GREEN)
				.setCreativeTab(TabHelper.combatTab(SimpleCoreAPI.plugin));
	}
	if (Settings.illumeniteArmor.isEnabled()) 
	{
		illumenite_helmet.setConfigEntry(Settings.illumeniteArmor).setType("illumenite")
				.addToolTip("netherrocks.illumeniteArmor.info", TextFormatting.GREEN)
				.setCreativeTab(TabHelper.combatTab(SimpleCoreAPI.plugin));
		illumenite_chestplate.setConfigEntry(Settings.illumeniteArmor).setType("illumenite")
				.addToolTip("netherrocks.illumeniteArmor.info", TextFormatting.GREEN)
				.setCreativeTab(TabHelper.combatTab(SimpleCoreAPI.plugin));
		illumenite_leggings.setConfigEntry(Settings.illumeniteArmor).setType("illumenite")
				.addToolTip("netherrocks.illumeniteArmor.info", TextFormatting.GREEN)
				.setCreativeTab(TabHelper.combatTab(SimpleCoreAPI.plugin));
		illumenite_boots.setConfigEntry(Settings.illumeniteArmor).setType("illumenite")
				.addToolTip("netherrocks.illumeniteArmor.info", TextFormatting.GREEN)
				.setCreativeTab(TabHelper.combatTab(SimpleCoreAPI.plugin));
	}
	if (Settings.dragonstoneArmor.isEnabled()) 
	{
		dragonstone_helmet.setConfigEntry(Settings.dragonstoneArmor).setType("dragonstone")
			.setCreativeTab(TabHelper.combatTab(SimpleCoreAPI.plugin));
		dragonstone_chestplate.setConfigEntry(Settings.dragonstoneArmor).setType("dragonstone")
			.setCreativeTab(TabHelper.combatTab(SimpleCoreAPI.plugin));
		dragonstone_leggings.setConfigEntry(Settings.dragonstoneArmor).setType("dragonstone")
			.setCreativeTab(TabHelper.combatTab(SimpleCoreAPI.plugin));
		dragonstone_boots.setConfigEntry(Settings.dragonstoneArmor).setType("dragonstone")
			.setCreativeTab(TabHelper.combatTab(SimpleCoreAPI.plugin));
	}
} // end configureArmor()

public static void configureSimpleItems() 
{
	if (Settings.fyriteIngot.isEnabled()) {
		fyrite_ingot.setConfigEntry(Settings.fyriteIngot)
			.setCreativeTab(TabHelper.materialsTab(SimpleCoreAPI.plugin));
	}
	if (Settings.malachiteIngot.isEnabled()) {
		malachite_ingot.setConfigEntry(Settings.malachiteIngot)
			.setCreativeTab(TabHelper.materialsTab(SimpleCoreAPI.plugin));
	}
	if (Settings.ashstoneGem.isEnabled()) {
		ashstone_gem.setConfigEntry(Settings.ashstoneGem)
			.setCreativeTab(TabHelper.materialsTab(SimpleCoreAPI.plugin));
	}
	if (Settings.illumeniteIngot.isEnabled()) {
		illumenite_ingot.setConfigEntry(Settings.illumeniteIngot)
			.setCreativeTab(TabHelper.materialsTab(SimpleCoreAPI.plugin));
	}
	if (Settings.dragonstoneGem.isEnabled()) {
		dragonstone_gem.setConfigEntry(Settings.dragonstoneGem)
			.setCreativeTab(TabHelper.materialsTab(SimpleCoreAPI.plugin));
	}
	if (Settings.argoniteIngot.isEnabled()) {
		argonite_ingot.setConfigEntry(Settings.argoniteIngot)
			.setCreativeTab(TabHelper.materialsTab(SimpleCoreAPI.plugin));
	}
} // end configureSimpleItems()

/**
 * register Items with Forge.
 * 
 * @param registry Forge item registry interface.
 */
public static void register(IForgeRegistry<Item> registry) 
{
	if (Settings.fyriteIngot.isEnabled()) registry.register(fyrite_ingot);
	if (Settings.malachiteIngot.isEnabled()) registry.register(malachite_ingot);
	if (Settings.ashstoneGem.isEnabled()) registry.register(ashstone_gem);
	if (Settings.dragonstoneGem.isEnabled()) registry.register(dragonstone_gem);
	if (Settings.argoniteIngot.isEnabled()) registry.register(argonite_ingot);
	if (Settings.illumeniteIngot.isEnabled()) registry.register(illumenite_ingot);
	
	if (Settings.fyriteArmor.isEnabled()) {
		registry.registerAll(fyrite_helmet, fyrite_chestplate, fyrite_leggings, fyrite_boots);
	}
	if (Settings.malachiteArmor.isEnabled()) {
		registry.registerAll(malachite_helmet, malachite_chestplate, malachite_leggings, 
							 malachite_boots);
	}
	if (Settings.dragonstoneArmor.isEnabled()) {
		registry.registerAll(dragonstone_helmet, dragonstone_chestplate, dragonstone_leggings, 
				 dragonstone_boots);
	}
	if (Settings.illumeniteArmor.isEnabled()) {
		registry.registerAll(illumenite_helmet, illumenite_chestplate, illumenite_leggings, 
				 illumenite_boots);
	}
	if (Settings.fyriteTools.isEnabled()) {
		registry.registerAll(fyrite_pickaxe, fyrite_axe, fyrite_shovel, fyrite_sword);
	}
	if (Settings.argoniteTools.isEnabled()) {
		registry.registerAll(argonite_pickaxe, argonite_axe, argonite_shovel, argonite_sword, 
				argonite_hoe);
	}
	if (Settings.ashstoneTools.isEnabled()) {
		registry.registerAll(ashstone_pickaxe, ashstone_axe, ashstone_shovel, ashstone_sword, 
				ashstone_hoe);
	}
	if (Settings.dragonstoneTools.isEnabled()) {
		registry.registerAll(dragonstone_pickaxe, dragonstone_axe, dragonstone_shovel, 
				dragonstone_sword, dragonstone_hoe);
	}
	if (Settings.illumeniteTools.isEnabled()) {
		registry.register( illumenite_sword);
	}
	if (Settings.malachiteTools.isEnabled()) {
		registry.registerAll(malachite_pickaxe, malachite_axe, malachite_shovel, 
				malachite_sword, malachite_hoe);
	}
} // end register()

/**
 * register Item models with Forge.
 */
public static void registerModels() 
{
	if (Settings.fyriteIngot.isEnabled()) fyrite_ingot.registerItemModel();
	if (Settings.malachiteIngot.isEnabled()) malachite_ingot.registerItemModel();
	if (Settings.ashstoneGem.isEnabled()) ashstone_gem.registerItemModel();
	if (Settings.dragonstoneGem.isEnabled()) dragonstone_gem.registerItemModel();
	if (Settings.argoniteIngot.isEnabled()) argonite_ingot.registerItemModel();
	if (Settings.illumeniteIngot.isEnabled()) illumenite_ingot.registerItemModel();
	
	if (Settings.fyriteArmor.isEnabled()) 
	{
		fyrite_helmet.registerItemModel();
		fyrite_chestplate.registerItemModel();
		fyrite_leggings.registerItemModel();
		fyrite_boots.registerItemModel();
	}
	if (Settings.malachiteArmor.isEnabled())
	{
		malachite_helmet.registerItemModel();
		malachite_chestplate.registerItemModel();
		malachite_leggings.registerItemModel();
		malachite_boots.registerItemModel();
	}
	if (Settings.dragonstoneArmor.isEnabled()) 
	{
		dragonstone_helmet.registerItemModel();
		dragonstone_chestplate.registerItemModel();
		dragonstone_leggings.registerItemModel();
		dragonstone_boots.registerItemModel();
	}
	if (Settings.illumeniteArmor.isEnabled()) 
	{
		illumenite_helmet.registerItemModel();
		illumenite_chestplate.registerItemModel();
		illumenite_leggings.registerItemModel();
		illumenite_boots.registerItemModel();
	}
	if (Settings.fyriteTools.isEnabled()) {
		fyrite_pickaxe.registerItemModel();
		fyrite_axe.registerItemModel();
		fyrite_sword.registerItemModel();
		fyrite_shovel.registerItemModel();
	}
	if (Settings.argoniteTools.isEnabled()) {
		argonite_pickaxe.registerItemModel();
		argonite_axe.registerItemModel();
		argonite_sword.registerItemModel();
		argonite_shovel.registerItemModel();
		argonite_hoe.registerItemModel();
	}
	if (Settings.ashstoneTools.isEnabled()) {
		ashstone_pickaxe.registerItemModel();
		ashstone_axe.registerItemModel();
		ashstone_sword.registerItemModel();
		ashstone_shovel.registerItemModel();
		ashstone_hoe.registerItemModel();
	}
	if (Settings.dragonstoneTools.isEnabled()) {
		dragonstone_pickaxe.registerItemModel();
		dragonstone_axe.registerItemModel();
		dragonstone_sword.registerItemModel();
		dragonstone_shovel.registerItemModel();
		dragonstone_hoe.registerItemModel();
	}
	if (Settings.illumeniteTools.isEnabled()) {
		illumenite_sword.registerItemModel();
	}
	if (Settings.malachiteTools.isEnabled()) 
	{
		malachite_pickaxe.registerItemModel();
		malachite_axe.registerItemModel();
		malachite_sword.registerItemModel();
		malachite_shovel.registerItemModel();
		malachite_hoe.registerItemModel();
	}
} // end registerModels()

/**
 * register ingots and suchlike with the ore dictionary.
 */
public static void registerOreDictionary()
{
	if (Settings.malachiteIngot.isEnabled())
		OreDictionary.registerOre("ingotMalachite", new ItemStack(ModItems.malachite_ingot));
	if (Settings.ashstoneGem.isEnabled())
		OreDictionary.registerOre("gemAshstone", new ItemStack(ModItems.ashstone_gem));
	OreDictionary.registerOre("ingotIllumenite", new ItemStack(ModItems.illumenite_ingot));
	if (Settings.dragonstoneGem.isEnabled())
		OreDictionary.registerOre("gemDragonstone", new ItemStack(ModItems.dragonstone_gem));
	if (Settings.argoniteIngot.isEnabled())
		OreDictionary.registerOre("ingotArgonite", new ItemStack(ModItems.argonite_ingot));
	if (Settings.fyriteIngot.isEnabled())
		OreDictionary.registerOre("ingotFyrite", new ItemStack(ModItems.fyrite_ingot));
} // end registerOreDictionary()

} // end class
