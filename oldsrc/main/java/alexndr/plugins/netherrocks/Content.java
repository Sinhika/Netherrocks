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
		if (Settings.fyriteOre.isEnabled() && Settings.fyriteIngot.isEnabled()) 
		{
			GameRegistry.addSmelting(ModBlocks.fyrite_ore, new ItemStack(
				ModItems.fyrite_ingot, 1, 0), 0.8F);
		}
		if (Settings.malachiteOre.isEnabled() && Settings.malachiteIngot.isEnabled())
		{
			GameRegistry.addSmelting(ModBlocks.malachite_ore, new ItemStack(
				ModItems.malachite_ingot, 1, 0), 0.5F);
		}
		GameRegistry.addSmelting(ModBlocks.ashstone_ore, new ItemStack(
				ModItems.ashstone_gem, 1, 0), 0.8F);
		GameRegistry.addSmelting(ModBlocks.illumenite_ore, new ItemStack(
				ModItems.illumenite_ingot, 1, 0), 0.8F);
		GameRegistry.addSmelting(ModBlocks.argonite_ore, new ItemStack(
				ModItems.argonite_ingot, 1, 0), 0.7F);
		GameRegistry.addSmelting(ModBlocks.dragonstone_ore, new ItemStack(
				ModItems.dragonstone_gem, 1, 0), 1.0F);
	} // end addSmeltingRecipes()
	
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
	
} // end class
