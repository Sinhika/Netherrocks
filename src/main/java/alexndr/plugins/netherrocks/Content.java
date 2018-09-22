package alexndr.plugins.netherrocks;

import alexndr.api.helpers.game.ArmorMaterialHelper;
import alexndr.api.logger.LogHelper;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.common.registry.GameRegistry;

/**
 * @author AleXndrTheGr8st
 */
public class Content 
{
	//Tool Materials
	public static ToolMaterial toolFyrite, toolMalachite, toolAshstone, toolIllumenite, 
							   toolDragonstone, toolArgonite;
	
	//Armor Materials
	public static ArmorMaterial armorFyrite, armorMalachite, armorIllumenite, armorDragonstone;
	
	public static void preInitialize() 
	{
		setToolAndArmorStats();
		
		try {
			ModItems.configureSimpleItems(); // must be before doBlocks() as some items are dropped by blocks.
			ModBlocks.configureBlocks();
			ModItems.configureTools();
			ModItems.configureArmor();
//			doAchievements();
			
			LogHelper.verbose("Netherrocks",
					"Content pre-init completed successfully");
		} 
		catch (Exception e) {
			LogHelper.severe("Netherrocks",
					"Content pre-init failed. This is a serious problem!");
			e.printStackTrace();
		}
	} // end preInitialize()
	
	
	/**
	 * Add smelting recipes to GameRegistry.
	 */
	public static void addSmeltingRecipes() 
	{
		// Furnace Recipes
		GameRegistry.addSmelting(ModBlocks.fyrite_ore, new ItemStack(
				ModItems.fyrite_ingot, 1, 0), 0.8F);
		GameRegistry.addSmelting(ModBlocks.malachite_ore, new ItemStack(
				ModItems.malachite_ingot, 1, 0), 0.5F);
		GameRegistry.addSmelting(ModBlocks.ashstone_ore, new ItemStack(
				ModItems.ashstone_gem, 1, 0), 0.8F);
		GameRegistry.addSmelting(ModBlocks.illumenite_ore, new ItemStack(
				ModItems.illumenite_ingot, 1, 0), 0.8F);
		GameRegistry.addSmelting(ModBlocks.argonite_ore, new ItemStack(
				ModItems.argonite_ingot, 1, 0), 0.7F);
		GameRegistry.addSmelting(ModBlocks.dragonstone_ore, new ItemStack(
				ModItems.dragonstone_gem, 1, 0), 1.0F);
	} // end addSmeltingRecipes()
	
	
//	public static void doAchievements() 
//	{
//		dragonstoneOreAch = new Achievement("achievement.dragonstoneOreAch", "dragonstoneOreAch", -6, -3, dragonstone_ore, argoniteOreAch).setSpecial().registerStat();
//		
//		fyriteSetAch = new Achievement("achievement.fyriteSetAch", "fyriteSetAch", -8, 7, fyrite_chestplate, fyriteOreAch).setSpecial().registerStat();
//		malachiteSetAch = new Achievement("achievement.malachiteSetAch", "malachiteSetAch", -8, 5, malachite_chestplate, malachiteOreAch).setSpecial().registerStat();
//		ashstoneAxeAch = new Achievement("achievement.ashstoneAxeAch", "ashstoneAxeAch", -8, 3, ashstone_axe, ashstoneOreAch).registerStat();
//		illumeniteSetAch = new Achievement("achievement.illumeniteSetAch", "illumeniteSetAch", -8, 1, illumenite_chestplate, illumeniteOreAch).setSpecial().registerStat();
//		argoniteSwordAch = new Achievement("achievement.argoniteSwordAch", "argoniteSwordAch", -8, -1, argonite_sword, argoniteOreAch).registerStat();
//		dragonstonePickaxeAch = new Achievement("achievement.dragonstonePickaxeAch", "dragonstonePickaxeAch", -8, -3, dragonstone_pickaxe, dragonstoneOreAch).registerStat();
//		
//		//netherFurnaceAch = new Achievement("achievement.netherFurnaceAch", "netherFurnaceAch", 1, 7, nether_furnace_lit, AchievementList.portal).registerStat();
//	} // end doAchievements()

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
				new int[] {Settings.fyriteArmor.getBootsReduction(),  
						   Settings.fyriteArmor.getLegsReduction(), 
						   Settings.fyriteArmor.getChestReduction(), 
						   Settings.fyriteArmor.getHelmReduction()}, 
				Settings.fyriteArmor.getEnchantability(), armorNoise, 0.0F);
		armorMalachite = EnumHelper.addArmorMaterial("MALACHITE", "malachite", 
				Settings.malachiteArmor.getDurability(), 
				new int[] {Settings.malachiteArmor.getBootsReduction(),  
						   Settings.malachiteArmor.getLegsReduction(), 
						   Settings.malachiteArmor.getChestReduction(), 
						   Settings.malachiteArmor.getHelmReduction()}, 
				Settings.malachiteArmor.getEnchantability(), armorNoise, 0.0F);
		armorIllumenite = EnumHelper.addArmorMaterial("ILLUMENITE", "illumenite", 
				Settings.illumeniteArmor.getDurability(), 
				new int[] {Settings.illumeniteArmor.getBootsReduction(),  
						   Settings.illumeniteArmor.getLegsReduction(), 
						   Settings.illumeniteArmor.getChestReduction(), 
						   Settings.illumeniteArmor.getHelmReduction()}, 
				Settings.illumeniteArmor.getEnchantability(), armorNoise, 0.0F);
		armorDragonstone = EnumHelper.addArmorMaterial("DRAGONSTONE", "dragonstone", 
				Settings.dragonstoneArmor.getDurability(), 
				new int[] {	Settings.dragonstoneArmor.getBootsReduction(),  
							Settings.dragonstoneArmor.getLegsReduction(), 
							Settings.dragonstoneArmor.getChestReduction(), 
							Settings.dragonstoneArmor.getHelmReduction()}, 
				Settings.dragonstoneArmor.getEnchantability(), armorNoise, 2.0F);
	} // end setToolAndArmorStats()
	
	public static void setRepairMaterials() 
	{
		LogHelper.verbose("Netherrocks", "Setting Tool and Armor repair materials");
		//Tools
		toolFyrite.setRepairItem(new ItemStack(ModItems.fyrite_ingot));
		toolMalachite.setRepairItem(new ItemStack(ModItems.malachite_ingot));
		toolAshstone.setRepairItem(new ItemStack(ModItems.ashstone_gem));
		toolIllumenite.setRepairItem(new ItemStack(ModItems.illumenite_ingot));
		toolDragonstone.setRepairItem(new ItemStack(ModItems.dragonstone_gem));
		toolArgonite.setRepairItem(new ItemStack(ModItems.argonite_ingot));
		
		//Armor
		ArmorMaterialHelper.setRepairItem(armorFyrite, new ItemStack(ModItems.fyrite_ingot));
		ArmorMaterialHelper.setRepairItem(armorMalachite, new ItemStack(ModItems.malachite_ingot));
		ArmorMaterialHelper.setRepairItem(armorIllumenite, new ItemStack(ModItems.illumenite_ingot));
		ArmorMaterialHelper.setRepairItem(armorDragonstone, new ItemStack(ModItems.dragonstone_gem));
	} // end setRepairMaterials()
	
//	public static void setAchievementTriggers() 
//	{
//		LogHelper.verbose("Netherrocks", "Setting achievement triggers");
//		//Pickup Triggers
//		StatTriggersHelper.addPickupTrigger(Item.getItemFromBlock(Content.fyrite_ore), Content.fyriteOreAch);
//		StatTriggersHelper.addPickupTrigger(Item.getItemFromBlock(Content.malachite_ore), Content.malachiteOreAch);
//		StatTriggersHelper.addPickupTrigger(Content.ashstone_gem, Content.ashstoneOreAch);
//		StatTriggersHelper.addPickupTrigger(Item.getItemFromBlock(Content.illumenite_ore), Content.illumeniteOreAch);
//		StatTriggersHelper.addPickupTrigger(Content.dragonstone_gem, Content.dragonstoneOreAch);
//		StatTriggersHelper.addPickupTrigger(Item.getItemFromBlock(Content.argonite_ore), Content.argoniteOreAch);
//		
//		//Crafting Triggers
//		StatTriggersHelper.addCraftingTrigger(Content.ashstone_axe, Content.ashstoneAxeAch);
//		StatTriggersHelper.addCraftingTrigger(Content.argonite_sword, Content.argoniteSwordAch);
//		StatTriggersHelper.addCraftingTrigger(Content.dragonstone_pickaxe, Content.dragonstonePickaxeAch);
//		//StatTriggersHelper.addCraftingTrigger(Content.nether_furnace, Content.netherFurnaceAch);
//		
//		//Smelting Triggers
//		StatTriggersHelper.addSmeltingTrigger(Content.ashstone_gem, Content.ashstoneOreAch);
//		StatTriggersHelper.addSmeltingTrigger(Content.dragonstone_gem, Content.dragonstoneOreAch);
//	} // end setAchievementTriggers()
	

//	public static Achievement 	fyriteOreAch, malachiteOreAch, ashstoneOreAch, illumeniteOreAch, dragonstoneOreAch, argoniteOreAch, netherFurnaceAch, 
//								fyriteSetAch, malachiteSetAch, ashstoneAxeAch, illumeniteSetAch, dragonstonePickaxeAch, argoniteSwordAch;
} // end class
