package alexndr.plugins.Netherrocks;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.Achievement;
import net.minecraft.stats.AchievementList;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.common.registry.GameRegistry;
import alexndr.api.content.blocks.SimpleBlock;
import alexndr.api.content.items.SimpleArmor;
import alexndr.api.content.items.SimpleAxe;
import alexndr.api.content.items.SimpleHoe;
import alexndr.api.content.items.SimpleItem;
import alexndr.api.content.items.SimplePickaxe;
import alexndr.api.content.items.SimpleShovel;
import alexndr.api.content.items.SimpleSword;
import alexndr.api.helpers.game.StatTriggersHelper;
import alexndr.api.helpers.game.TabHelper;
import alexndr.api.logger.LogHelper;
import alexndr.api.registry.ContentCategories;
import alexndr.plugins.Netherrocks.blocks.NetherFurnaceBlock;
import alexndr.plugins.Netherrocks.items.FyritePickaxe;
import alexndr.plugins.Netherrocks.items.FyriteSword;
import alexndr.plugins.Netherrocks.items.IllumeniteSword;
import alexndr.plugins.Netherrocks.tiles.NetherFurnaceTileEntity;

/**
 * @author AleXndrTheGr8st
 */
public class Content 
{
	public static void preInitialize() 
	{
		setToolAndArmorStats();
		
		try {
			doItems();
			doBlocks();
			doTools();
			doArmor();
			doAchievements();
			
			//Registers
			GameRegistry.registerTileEntity(NetherFurnaceTileEntity.class, "nether_furnace");
			
			LogHelper.verbose("Netherrocks",
					"Content pre-init completed successfully");
		} 
		catch (Exception e) {
			LogHelper.severe("Netherrocks",
					"Content pre-init failed. This is a serious problem!");
			e.printStackTrace();
		}
	} // end preInitialize()
	
	
	public static void doItems() 
	{
		fyrite_ingot = new SimpleItem(Netherrocks.plugin, ContentCategories.Item.INGOT).setConfigEntry(Settings.fyriteIngot).setUnlocalizedName("fyrite_ingot");
		malachite_ingot = new SimpleItem(Netherrocks.plugin, ContentCategories.Item.INGOT).setConfigEntry(Settings.malachiteIngot).setUnlocalizedName("malachite_ingot");
		ashstone_gem = new SimpleItem(Netherrocks.plugin, ContentCategories.Item.INGOT).setConfigEntry(Settings.ashstoneGem).setUnlocalizedName("ashstone_gem");
		illumenite_ingot = new SimpleItem(Netherrocks.plugin, ContentCategories.Item.INGOT).setConfigEntry(Settings.illumeniteIngot).setUnlocalizedName("illumenite_ingot");
		dragonstone_gem = new SimpleItem(Netherrocks.plugin, ContentCategories.Item.INGOT).setConfigEntry(Settings.dragonstoneGem).setUnlocalizedName("dragonstone_gem");
		argonite_ingot = new SimpleItem(Netherrocks.plugin, ContentCategories.Item.INGOT).setConfigEntry(Settings.argoniteIngot).setUnlocalizedName("argonite_ingot");
	} // end doItems()
	
	public static void doBlocks() 
	{
		fyrite_ore = new SimpleBlock(Netherrocks.plugin, Material.ROCK,
				ContentCategories.Block.ORE).setConfigEntry(Settings.fyriteOre)
				.setStepSound(SoundType.STONE).setUnlocalizedName("fyrite_ore");
		malachite_ore = new SimpleBlock(Netherrocks.plugin, Material.ROCK,
										ContentCategories.Block.ORE)
				.setConfigEntry(Settings.malachiteOre)
				.setStepSound(SoundType.STONE)
				.setUnlocalizedName("malachite_ore");
		ashstone_ore = new SimpleBlock(Netherrocks.plugin, Material.ROCK,
				ContentCategories.Block.ORE)
				.setConfigEntry(Settings.ashstoneOre)
				.setStepSound(SoundType.STONE)
				.setUnlocalizedName("ashstone_ore");
		illumenite_ore = new SimpleBlock(Netherrocks.plugin, Material.GLASS,
				ContentCategories.Block.ORE)
				.setConfigEntry(Settings.illumeniteOre)
				.setStepSound(SoundType.GLASS)
				.setUnlocalizedName("illumenite_ore");
		dragonstone_ore = new SimpleBlock(Netherrocks.plugin, Material.ROCK,
				ContentCategories.Block.ORE)
				.setConfigEntry(Settings.dragonstoneOre)
				.setStepSound(SoundType.STONE)
				.setUnlocalizedName("dragonstone_ore");
		argonite_ore = new SimpleBlock(Netherrocks.plugin, Material.ROCK,
				ContentCategories.Block.ORE)
				.setConfigEntry(Settings.argoniteOre)
				.setStepSound(SoundType.STONE)
				.setUnlocalizedName("argonite_ore");
		
		fyrite_block = new SimpleBlock(Netherrocks.plugin, Material.IRON,
				ContentCategories.Block.GENERAL)
				.setConfigEntry(Settings.fyriteBlock)
				.setStepSound(SoundType.METAL)
				.setUnlocalizedName("fyrite_block");
		malachite_block = new SimpleBlock(Netherrocks.plugin,
				Material.IRON,
				ContentCategories.Block.GENERAL)
				.setConfigEntry(Settings.malachiteBlock)
				.setStepSound(SoundType.METAL)
				.setUnlocalizedName("malachite_block");
		ashstone_block = new SimpleBlock(Netherrocks.plugin,
				Material.ROCK,
				ContentCategories.Block.GENERAL)
				.setConfigEntry(Settings.ashstoneBlock)
				.setStepSound(SoundType.STONE)
				.setUnlocalizedName("ashstone_block");
		illumenite_block = new SimpleBlock(Netherrocks.plugin,
				Material.GLASS,
				ContentCategories.Block.GENERAL)
				.setConfigEntry(Settings.illumeniteBlock)
				.setStepSound(SoundType.GLASS)
				.setUnlocalizedName("illumenite_block");
		dragonstone_block = new SimpleBlock(Netherrocks.plugin,
				Material.ROCK,
				ContentCategories.Block.GENERAL)
				.setConfigEntry(Settings.dragonstoneBlock)
				.setStepSound(SoundType.STONE)
				.setUnlocalizedName("dragonstone_block");
		argonite_block = new SimpleBlock(Netherrocks.plugin,
				Material.IRON,
				ContentCategories.Block.GENERAL)
				.setConfigEntry(Settings.argoniteBlock)
				.setStepSound(SoundType.METAL)
				.setUnlocalizedName("argonite_block");
		
		nether_furnace = new NetherFurnaceBlock(false)
				.setConfigEntry(Settings.netherFurnace)
				.setUnlocalizedName("nether_furnace");
		nether_furnace_lit = new NetherFurnaceBlock(true)
				.setConfigEntry(Settings.netherFurnace)
				.setUnlocalizedName("nether_furnace_lit");
	} // end doBlocks()
	
	public static void doTools() 
	{
		fyrite_sword = new FyriteSword().setConfigEntry(Settings.fyriteTools)
				.setCreativeTab(TabHelper.combatTab()).setUnlocalizedName("fyrite_sword");
		fyrite_pickaxe = new FyritePickaxe().setConfigEntry(Settings.fyriteTools)
				.setCreativeTab(TabHelper.toolsTab())
				.setUnlocalizedName("fyrite_pickaxe");
				
		malachite_pickaxe = new SimplePickaxe(Netherrocks.plugin, Content.toolMalachite)
			.setConfigEntry(Settings.malachiteTools)
			.setCreativeTab(TabHelper.toolsTab()).setUnlocalizedName("malachite_pickaxe");
		malachite_axe = new SimpleAxe(Netherrocks.plugin, Content.toolMalachite).setConfigEntry(Settings.malachiteTools).setCreativeTab(TabHelper.toolsTab()).setUnlocalizedName("malachite_axe");
		malachite_shovel = new SimpleShovel(Netherrocks.plugin, Content.toolMalachite).setConfigEntry(Settings.malachiteTools).setCreativeTab(TabHelper.toolsTab()).setUnlocalizedName("malachite_shovel");
		malachite_hoe = new SimpleHoe(Netherrocks.plugin, Content.toolMalachite).setConfigEntry(Settings.malachiteTools).setCreativeTab(TabHelper.toolsTab()).setUnlocalizedName("malachite_hoe");
		malachite_sword = new SimpleSword(Netherrocks.plugin, Content.toolMalachite)
			.setConfigEntry(Settings.malachiteTools)
			.setCreativeTab(TabHelper.combatTab())
			.setUnlocalizedName("malachite_sword");
		
		illumenite_sword = new IllumeniteSword().setConfigEntry(Settings.fyriteTools)
				.setCreativeTab(TabHelper.combatTab())
				.setUnlocalizedName("illumenite_sword");
		
		ashstone_pickaxe = new SimplePickaxe(Netherrocks.plugin, Content.toolAshstone).setConfigEntry(Settings.ashstoneTools).setCreativeTab(TabHelper.toolsTab()).setUnlocalizedName("ashstone_pickaxe");
		ashstone_axe = new SimpleAxe(Netherrocks.plugin, Content.toolAshstone).setConfigEntry(Settings.ashstoneTools).setCreativeTab(TabHelper.toolsTab()).setUnlocalizedName("ashstone_axe");
		ashstone_shovel = new SimpleShovel(Netherrocks.plugin, Content.toolAshstone).setConfigEntry(Settings.ashstoneTools).setCreativeTab(TabHelper.toolsTab()).setUnlocalizedName("ashstone_shovel");
		ashstone_hoe = new SimpleHoe(Netherrocks.plugin, Content.toolAshstone).setConfigEntry(Settings.ashstoneTools).setCreativeTab(TabHelper.toolsTab()).setUnlocalizedName("ashstone_hoe");
		ashstone_sword = new SimpleSword(Netherrocks.plugin, Content.toolAshstone).setConfigEntry(Settings.ashstoneTools).setCreativeTab(TabHelper.combatTab()).setUnlocalizedName("ashstone_sword");
		
		dragonstone_pickaxe = new SimplePickaxe(Netherrocks.plugin, Content.toolDragonstone).setConfigEntry(Settings.dragonstoneTools).setCreativeTab(TabHelper.toolsTab()).setUnlocalizedName("dragonstone_pickaxe");
		dragonstone_axe = new SimpleAxe(Netherrocks.plugin, Content.toolDragonstone).setConfigEntry(Settings.dragonstoneTools).setCreativeTab(TabHelper.toolsTab()).setUnlocalizedName("dragonstone_axe");
		dragonstone_shovel = new SimpleShovel(Netherrocks.plugin, Content.toolDragonstone).setConfigEntry(Settings.dragonstoneTools).setCreativeTab(TabHelper.toolsTab()).setUnlocalizedName("dragonstone_shovel");
		dragonstone_hoe = new SimpleHoe(Netherrocks.plugin, Content.toolDragonstone).setConfigEntry(Settings.dragonstoneTools).setCreativeTab(TabHelper.toolsTab()).setUnlocalizedName("dragonstone_hoe");
		dragonstone_sword = new SimpleSword(Netherrocks.plugin, Content.toolDragonstone).setConfigEntry(Settings.dragonstoneTools).setCreativeTab(TabHelper.combatTab()).setUnlocalizedName("dragonstone_sword");
		
		argonite_pickaxe = new SimplePickaxe(Netherrocks.plugin, Content.toolArgonite).setConfigEntry(Settings.argoniteTools).setCreativeTab(TabHelper.toolsTab()).setUnlocalizedName("argonite_pickaxe");
		argonite_axe = new SimpleAxe(Netherrocks.plugin, Content.toolArgonite).setConfigEntry(Settings.argoniteTools).setCreativeTab(TabHelper.toolsTab()).setUnlocalizedName("argonite_axe");
		argonite_shovel = new SimpleShovel(Netherrocks.plugin, Content.toolArgonite).setConfigEntry(Settings.argoniteTools).setCreativeTab(TabHelper.toolsTab()).setUnlocalizedName("argonite_shovel");
		argonite_hoe = new SimpleHoe(Netherrocks.plugin, Content.toolArgonite).setConfigEntry(Settings.argoniteTools).setCreativeTab(TabHelper.toolsTab()).setUnlocalizedName("argonite_hoe");
		argonite_sword = new SimpleSword(Netherrocks.plugin, Content.toolArgonite).setConfigEntry(Settings.argoniteTools).setCreativeTab(TabHelper.combatTab()).setUnlocalizedName("argonite_sword");
	} // end doTools()
	
	public static void doArmor() 
	{
		fyrite_helmet = new SimpleArmor(Netherrocks.plugin, Content.armorFyrite, 
				EntityEquipmentSlot.HEAD).setConfigEntry(Settings.fyriteArmor).setType("fyrite")
				.addToolTip("netherrocks.fyriteArmor.info", TextFormatting.GREEN)
				.setCreativeTab(TabHelper.combatTab()).setUnlocalizedName("fyrite_helmet");
		fyrite_chestplate = new SimpleArmor(Netherrocks.plugin, Content.armorFyrite, 
				EntityEquipmentSlot.CHEST).setConfigEntry(Settings.fyriteArmor).setType("fyrite")
				.addToolTip("netherrocks.fyriteArmor.info", TextFormatting.GREEN)
				.setCreativeTab(TabHelper.combatTab()).setUnlocalizedName("fyrite_chestplate");
		fyrite_leggings = new SimpleArmor(Netherrocks.plugin, Content.armorFyrite, 
				EntityEquipmentSlot.LEGS).setConfigEntry(Settings.fyriteArmor).setType("fyrite")
				.addToolTip("netherrocks.fyriteArmor.info", TextFormatting.GREEN)
				.setCreativeTab(TabHelper.combatTab()).setUnlocalizedName("fyrite_leggings");
		fyrite_boots = new SimpleArmor(Netherrocks.plugin, Content.armorFyrite, 
				EntityEquipmentSlot.FEET).setConfigEntry(Settings.fyriteArmor).setType("fyrite")
				.addToolTip("netherrocks.fyriteArmor.info", TextFormatting.GREEN)
				.setCreativeTab(TabHelper.combatTab()).setUnlocalizedName("fyrite_boots");
		
		malachite_helmet = new SimpleArmor(Netherrocks.plugin, Content.armorMalachite, 
				EntityEquipmentSlot.HEAD).setConfigEntry(Settings.malachiteArmor).setType("malachite")
				.addToolTip("netherrocks.malachiteArmor.info", TextFormatting.GREEN)
				.setCreativeTab(TabHelper.combatTab()).setUnlocalizedName("malachite_helmet");
		malachite_chestplate = new SimpleArmor(Netherrocks.plugin, Content.armorMalachite, 
				EntityEquipmentSlot.CHEST).setConfigEntry(Settings.malachiteArmor).setType("malachite")
				.addToolTip("netherrocks.malachiteArmor.info", TextFormatting.GREEN)
				.setCreativeTab(TabHelper.combatTab()).setUnlocalizedName("malachite_chestplate");
		malachite_leggings = new SimpleArmor(Netherrocks.plugin, Content.armorMalachite, 
				EntityEquipmentSlot.LEGS).setConfigEntry(Settings.malachiteArmor).setType("malachite")
				.addToolTip("netherrocks.malachiteArmor.info", TextFormatting.GREEN)
				.setCreativeTab(TabHelper.combatTab()).setUnlocalizedName("malachite_leggings");
		malachite_boots = new SimpleArmor(Netherrocks.plugin, Content.armorMalachite, 
				EntityEquipmentSlot.FEET).setConfigEntry(Settings.malachiteArmor).setType("malachite")
				.addToolTip("netherrocks.malachiteArmor.info", TextFormatting.GREEN)
				.setCreativeTab(TabHelper.combatTab()).setUnlocalizedName("malachite_boots");
		
		illumenite_helmet = new SimpleArmor(Netherrocks.plugin, Content.armorIllumenite, 
				EntityEquipmentSlot.HEAD).setConfigEntry(Settings.illumeniteArmor).setType("illumenite")
				.addToolTip("netherrocks.illumeniteArmor.info", TextFormatting.GREEN)
				.setCreativeTab(TabHelper.combatTab()).setUnlocalizedName("illumenite_helmet");
		illumenite_chestplate = new SimpleArmor(Netherrocks.plugin, Content.armorIllumenite, 
				EntityEquipmentSlot.CHEST).setConfigEntry(Settings.illumeniteArmor).setType("illumenite")
				.addToolTip("netherrocks.illumeniteArmor.info", TextFormatting.GREEN)
				.setCreativeTab(TabHelper.combatTab()).setUnlocalizedName("illumenite_chestplate");
		illumenite_leggings = new SimpleArmor(Netherrocks.plugin, Content.armorIllumenite, 
				EntityEquipmentSlot.LEGS).setConfigEntry(Settings.illumeniteArmor).setType("illumenite")
				.addToolTip("netherrocks.illumeniteArmor.info", TextFormatting.GREEN)
				.setCreativeTab(TabHelper.combatTab()).setUnlocalizedName("illumenite_leggings");
		illumenite_boots = new SimpleArmor(Netherrocks.plugin, Content.armorIllumenite, 
				EntityEquipmentSlot.FEET).setConfigEntry(Settings.illumeniteArmor).setType("illumenite")
				.addToolTip("netherrocks.illumeniteArmor.info", TextFormatting.GREEN)
				.setCreativeTab(TabHelper.combatTab()).setUnlocalizedName("illumenite_boots");
		
		dragonstone_helmet = new SimpleArmor(Netherrocks.plugin, Content.armorDragonstone, EntityEquipmentSlot.HEAD).setConfigEntry(Settings.dragonstoneArmor).setType("dragonstone")
				.addToolTip("netherrocks.dragonstoneArmor.info", TextFormatting.GREEN).setCreativeTab(TabHelper.combatTab()).setUnlocalizedName("dragonstone_helmet");
		dragonstone_chestplate = new SimpleArmor(Netherrocks.plugin, Content.armorDragonstone, EntityEquipmentSlot.CHEST).setConfigEntry(Settings.dragonstoneArmor).setType("dragonstone")
				.addToolTip("netherrocks.dragonstoneArmor.info", TextFormatting.GREEN).setCreativeTab(TabHelper.combatTab()).setUnlocalizedName("dragonstone_chestplate");
		dragonstone_leggings = new SimpleArmor(Netherrocks.plugin, Content.armorDragonstone, EntityEquipmentSlot.LEGS).setConfigEntry(Settings.dragonstoneArmor).setType("dragonstone")
				.addToolTip("netherrocks.dragonstoneArmor.info", TextFormatting.GREEN).setCreativeTab(TabHelper.combatTab()).setUnlocalizedName("dragonstone_leggings");
		dragonstone_boots = new SimpleArmor(Netherrocks.plugin, Content.armorDragonstone, EntityEquipmentSlot.FEET).setConfigEntry(Settings.dragonstoneArmor).setType("dragonstone")
				.addToolTip("netherrocks.dragonstoneArmor.info", TextFormatting.GREEN).setCreativeTab(TabHelper.combatTab()).setUnlocalizedName("dragonstone_boots");
	} // end doArmor()
	
	public static void doAchievements() 
	{
		fyriteOreAch = new Achievement("achievement.fyriteOreAch", "fyriteOreAch", -6, 7, fyrite_ore, AchievementList.PORTAL).registerStat();
		malachiteOreAch = new Achievement("achievement.malachiteOreAch", "malachiteOreAch", -6, 5, malachite_ore, fyriteOreAch).registerStat();
		ashstoneOreAch = new Achievement("achievement.ashstoneOreAch", "ashstoneOreAch", -6, 3, ashstone_ore, malachiteOreAch).registerStat();
		illumeniteOreAch = new Achievement("achievement.illumeniteOreAch", "illumeniteOreAch", -6, 1, illumenite_ore, ashstoneOreAch).registerStat();
		argoniteOreAch = new Achievement("achievement.argoniteOreAch", "argoniteOreAch", -6, -1, argonite_ore, illumeniteOreAch).registerStat();
		dragonstoneOreAch = new Achievement("achievement.dragonstoneOreAch", "dragonstoneOreAch", -6, -3, dragonstone_ore, argoniteOreAch).setSpecial().registerStat();
		
		fyriteSetAch = new Achievement("achievement.fyriteSetAch", "fyriteSetAch", -8, 7, fyrite_chestplate, fyriteOreAch).setSpecial().registerStat();
		malachiteSetAch = new Achievement("achievement.malachiteSetAch", "malachiteSetAch", -8, 5, malachite_chestplate, malachiteOreAch).setSpecial().registerStat();
		ashstoneAxeAch = new Achievement("achievement.ashstoneAxeAch", "ashstoneAxeAch", -8, 3, ashstone_axe, ashstoneOreAch).registerStat();
		illumeniteSetAch = new Achievement("achievement.illumeniteSetAch", "illumeniteSetAch", -8, 1, illumenite_chestplate, illumeniteOreAch).setSpecial().registerStat();
		argoniteSwordAch = new Achievement("achievement.argoniteSwordAch", "argoniteSwordAch", -8, -1, argonite_sword, argoniteOreAch).registerStat();
		dragonstonePickaxeAch = new Achievement("achievement.dragonstonePickaxeAch", "dragonstonePickaxeAch", -8, -3, dragonstone_pickaxe, dragonstoneOreAch).registerStat();
		
		//netherFurnaceAch = new Achievement("achievement.netherFurnaceAch", "netherFurnaceAch", 1, 7, nether_furnace_lit, AchievementList.portal).registerStat();
	} // end doAchievements()

	public static void setToolAndArmorStats() 
	{
		LogHelper.verbose("Netherrocks", "Setting Tool and Armor stats");
		//Tools
		toolFyrite = EnumHelper.addToolMaterial("FYRITE", Settings.fyriteTools.getHarvestLevel(), Settings.fyriteTools.getUses(), Settings.fyriteTools.getHarvestSpeed(), Settings.fyriteTools.getDamageVsEntity(), Settings.fyriteTools.getEnchantability());
		toolMalachite = EnumHelper.addToolMaterial("MALACHITE", Settings.malachiteTools.getHarvestLevel(), Settings.malachiteTools.getUses(), Settings.malachiteTools.getHarvestSpeed(), Settings.malachiteTools.getDamageVsEntity(), Settings.malachiteTools.getEnchantability());
		toolAshstone = EnumHelper.addToolMaterial("ASHSTONE", Settings.ashstoneTools.getHarvestLevel(), Settings.ashstoneTools.getUses(), Settings.ashstoneTools.getHarvestSpeed(), Settings.ashstoneTools.getDamageVsEntity(), Settings.ashstoneTools.getEnchantability());
		toolIllumenite = EnumHelper.addToolMaterial("ILLUMENITE", Settings.illumeniteTools.getHarvestLevel(), Settings.illumeniteTools.getUses(), Settings.illumeniteTools.getHarvestSpeed(), Settings.illumeniteTools.getDamageVsEntity(), Settings.illumeniteTools.getEnchantability());
		toolDragonstone = EnumHelper.addToolMaterial("DRAGONSTONE", Settings.dragonstoneTools.getHarvestLevel(), Settings.dragonstoneTools.getUses(), Settings.dragonstoneTools.getHarvestSpeed(), Settings.dragonstoneTools.getDamageVsEntity(), Settings.dragonstoneTools.getEnchantability());
		toolArgonite = EnumHelper.addToolMaterial("ARGONITE", Settings.argoniteTools.getHarvestLevel(), Settings.argoniteTools.getUses(), Settings.argoniteTools.getHarvestSpeed(), Settings.argoniteTools.getDamageVsEntity(), Settings.argoniteTools.getEnchantability());
		
		//Armor
		ResourceLocation soundName = new ResourceLocation("item.armor.equip_generic");
		SoundEvent armorNoise = SoundEvent.REGISTRY.getObject(soundName);
		
		armorFyrite = EnumHelper.addArmorMaterial("FYRITE", "fyrite", 
				Settings.fyriteArmor.getDurability(), 
				new int[] {Settings.fyriteArmor.getHelmReduction(),  
						   Settings.fyriteArmor.getChestReduction(), 
						   Settings.fyriteArmor.getLegsReduction(), 
						   Settings.fyriteArmor.getBootsReduction()}, 
				Settings.fyriteArmor.getEnchantability(), armorNoise, 0.0F);
		armorMalachite = EnumHelper.addArmorMaterial("MALACHITE", "malachite", 
				Settings.malachiteArmor.getDurability(), 
				new int[] {Settings.malachiteArmor.getHelmReduction(),  
						   Settings.malachiteArmor.getChestReduction(), 
						   Settings.malachiteArmor.getLegsReduction(), 
						   Settings.malachiteArmor.getBootsReduction()}, 
				Settings.malachiteArmor.getEnchantability(), armorNoise, 0.0F);
		armorIllumenite = EnumHelper.addArmorMaterial("ILLUMENITE", "illumenite", 
				Settings.illumeniteArmor.getDurability(), 
				new int[] {Settings.illumeniteArmor.getHelmReduction(),  
						   Settings.illumeniteArmor.getChestReduction(), 
						   Settings.illumeniteArmor.getLegsReduction(), 
						   Settings.illumeniteArmor.getBootsReduction()}, 
				Settings.illumeniteArmor.getEnchantability(), armorNoise, 0.0F);
		armorDragonstone = EnumHelper.addArmorMaterial("DRAGONSTONE", "dragonstone", 
				Settings.dragonstoneArmor.getDurability(), 
				new int[] {	Settings.dragonstoneArmor.getHelmReduction(),  
							Settings.dragonstoneArmor.getChestReduction(), 
							Settings.dragonstoneArmor.getLegsReduction(), 
							Settings.dragonstoneArmor.getBootsReduction()}, 
				Settings.dragonstoneArmor.getEnchantability(), armorNoise, 2.0F);
	} // end setToolAndArmorStats()
	
	public static void setRepairMaterials() 
	{
		LogHelper.verbose("Netherrocks", "Setting Tool and Armor repair materials");
		//Tools
		toolFyrite.setRepairItem(new ItemStack(Content.fyrite_ingot));
		toolMalachite.setRepairItem(new ItemStack(Content.malachite_ingot));
		toolAshstone.setRepairItem(new ItemStack(Content.ashstone_gem));
		toolIllumenite.setRepairItem(new ItemStack(Content.illumenite_ingot));
		toolDragonstone.setRepairItem(new ItemStack(Content.dragonstone_gem));
		toolArgonite.setRepairItem(new ItemStack(Content.argonite_ingot));
		
		//Armor
		armorFyrite.customCraftingMaterial = Content.fyrite_ingot;
		armorMalachite.customCraftingMaterial = Content.malachite_ingot;
		armorIllumenite.customCraftingMaterial = Content.illumenite_ingot;
		armorDragonstone.customCraftingMaterial = Content.dragonstone_gem;
	} // end setRepairMaterials()
	
	public static void setAchievementTriggers() 
	{
		LogHelper.verbose("Netherrocks", "Setting achievement triggers");
		//Pickup Triggers
		StatTriggersHelper.addPickupTrigger(Item.getItemFromBlock(Content.fyrite_ore), Content.fyriteOreAch);
		StatTriggersHelper.addPickupTrigger(Item.getItemFromBlock(Content.malachite_ore), Content.malachiteOreAch);
		StatTriggersHelper.addPickupTrigger(Content.ashstone_gem, Content.ashstoneOreAch);
		StatTriggersHelper.addPickupTrigger(Item.getItemFromBlock(Content.illumenite_ore), Content.illumeniteOreAch);
		StatTriggersHelper.addPickupTrigger(Content.dragonstone_gem, Content.dragonstoneOreAch);
		StatTriggersHelper.addPickupTrigger(Item.getItemFromBlock(Content.argonite_ore), Content.argoniteOreAch);
		
		//Crafting Triggers
		StatTriggersHelper.addCraftingTrigger(Content.ashstone_axe, Content.ashstoneAxeAch);
		StatTriggersHelper.addCraftingTrigger(Content.argonite_sword, Content.argoniteSwordAch);
		StatTriggersHelper.addCraftingTrigger(Content.dragonstone_pickaxe, Content.dragonstonePickaxeAch);
		//StatTriggersHelper.addCraftingTrigger(Content.nether_furnace, Content.netherFurnaceAch);
		
		//Smelting Triggers
		StatTriggersHelper.addSmeltingTrigger(Content.ashstone_gem, Content.ashstoneOreAch);
		StatTriggersHelper.addSmeltingTrigger(Content.dragonstone_gem, Content.dragonstoneOreAch);
	} // end setAchievementTriggers()
	

	//Tool Materials
	public static ToolMaterial toolFyrite, toolMalachite, toolAshstone, toolIllumenite, toolDragonstone, toolArgonite;
	
	//Armor Materials
	public static ArmorMaterial armorFyrite, armorMalachite, armorIllumenite, armorDragonstone;
	
	public static Block fyrite_ore, malachite_ore, ashstone_ore, illumenite_ore, dragonstone_ore, argonite_ore,
						fyrite_block, malachite_block, ashstone_block, illumenite_block, dragonstone_block, argonite_block, 
						nether_furnace_lit, nether_furnace;
	
	public static Item 	fyrite_ingot, malachite_ingot, ashstone_gem, illumenite_ingot, dragonstone_gem, argonite_ingot, 
						illumenite_rod;
	
	public static Item 	malachite_pickaxe, ashstone_pickaxe, dragonstone_pickaxe, argonite_pickaxe, fyrite_pickaxe, 
						malachite_axe, ashstone_axe, dragonstone_axe, argonite_axe, 
						malachite_shovel, ashstone_shovel, dragonstone_shovel, argonite_shovel, 
						malachite_sword, ashstone_sword, dragonstone_sword, argonite_sword, fyrite_sword, illumenite_sword, 
						malachite_hoe, ashstone_hoe, dragonstone_hoe, argonite_hoe;
	
	public static Item 	fyrite_helmet, malachite_helmet, illumenite_helmet, dragonstone_helmet, 
						fyrite_chestplate, malachite_chestplate, illumenite_chestplate, dragonstone_chestplate, 
						fyrite_leggings, malachite_leggings, illumenite_leggings, dragonstone_leggings, 
						fyrite_boots, malachite_boots, illumenite_boots, dragonstone_boots;
	
	public static Achievement 	fyriteOreAch, malachiteOreAch, ashstoneOreAch, illumeniteOreAch, dragonstoneOreAch, argoniteOreAch, netherFurnaceAch, 
								fyriteSetAch, malachiteSetAch, ashstoneAxeAch, illumeniteSetAch, dragonstonePickaxeAch, argoniteSwordAch;
} // end class
