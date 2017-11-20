package alexndr.plugins.Netherrocks;

import alexndr.api.config.ConfigHelper;
import alexndr.api.config.types.ConfigArmor;
import alexndr.api.config.types.ConfigBlock;
import alexndr.api.config.types.ConfigItem;
import alexndr.api.config.types.ConfigOre;
import alexndr.api.config.types.ConfigTool;
import alexndr.api.logger.LogHelper;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

/**
 * @author AleXndrTheGr8st
 */
public class Settings 
{
	private static Configuration settings = new Configuration();
	
	public static void createOrLoadSettings(FMLPreInitializationEvent event) 
	{
		settings = ConfigHelper.GetConfig(event, "AleXndr", ModInfo.ID + ".cfg");
		LogHelper.verbose(ModInfo.ID, "loading settings...");
		
		try {
			settings.load();
			ConfigHelper.createHelpEntry(settings, ModInfo.URL);
			configureBlocks();
			configureOres();
			configureItems();
			configureTools();
			configureArmor();
			configureMachines();
		}
		catch(Exception e) {
			LogHelper.severe("Netherrocks", "Failed to load settings");
			e.printStackTrace();
		}
		finally {
			settings.save();
			LogHelper.verbose("Netherrocks", "Settings loaded successfully");
		}
	} // end createOrLoadSettings()
	
	public static void configureMachines()
	{
		netherFurnace = new ConfigBlock("Nether Furnace", ConfigHelper.CATEGORY_MACHINE)
				.setHardness(3.5F).setResistance(12.0F).setLightValue(1.0F)
				.setHarvestTool("pickaxe");
		netherFurnace.GetConfig(settings);
		netherFurnaceSpeed = settings.getInt("SmeltingTime", netherFurnace.getSubCategory(), 
				100, 1, 32767, "item smelt time (ticks)");
		netherrackBurnTime = settings.getInt("NetherrackBurnTime", netherFurnace.getSubCategory(),
				200, 1, 32767, "netherrack fuel burn time (secs)");
		fyriteBurnTime = settings.getInt("FyriteBurnTime", netherFurnace.getSubCategory(), 
				8000, 1, 32767, "fyrite item fuel burn time (secs)");
		blazeRodBurnTime = settings.getInt("BlazeRodBurnTime", netherFurnace.getSubCategory(), 
				2400, 1, 32767, "blaze rod fuel burn time (secs)");
	} // end configureMachines()
	
	public static void configureArmor() 
	{
		//Armor
		fyriteArmor = new ConfigArmor("Fyrite Armor").setDurability(5)
						.setEnchantability(7).setHelmReduction(3)
						.setChestReduction(5).setLegsReduction(4)
						.setBootsReduction(3);
		fyriteArmor.GetConfig(settings);
		fyriteEffect = settings.getBoolean("FireProof", fyriteArmor.getSubCategory(), true,
				"set bonus: fireproof");

		malachiteArmor = new ConfigArmor("Malachite Armor")
						.setDurability(16).setEnchantability(39).setHelmReduction(2)
						.setChestReduction(4).setLegsReduction(4).setBootsReduction(2);
		malachiteArmor.GetConfig(settings);
		malachiteEffect = settings.getBoolean("JumpBoost", malachiteArmor.getSubCategory(), 
				true, "set bonus: jump boost");
		malachiteJumpBoost = settings.getInt("BoostFactor", malachiteArmor.getSubCategory(), 1,
				0, 9, "jump boost level");
						
		illumeniteArmor = new ConfigArmor("Illumenite Armor").setDurability(12).setEnchantability(15)
				.setHelmReduction(4).setChestReduction(5).setLegsReduction(5).setBootsReduction(3);
		illumeniteArmor.GetConfig(settings);
		illumeniteEffect = settings.getBoolean("NoFallDamage", illumeniteArmor.getSubCategory(), 
				true, "set bonus: take no fall damage");
		
		dragonstoneArmor = new ConfigArmor("Dragonstone Armor")
						.setDurability(48).setEnchantability(27)
						.setHelmReduction(3).setChestReduction(9)
						.setLegsReduction(7).setBootsReduction(3);
		dragonstoneArmor.GetConfig(settings);
	} // end configureArmor()

	public static void configureTools() 
	{
		//Tools
		fyriteTools = new ConfigTool("Fyrite Tools").setUses(150)
						.setHarvestLevel(3).setHarvestSpeed(8.0F)
						.setDamageVsEntity(4.0F).setEnchantability(7);
		fyriteTools.GetConfig(settings);
		
		malachiteTools = new ConfigTool("Malachite Tools").setUses(700)
						.setHarvestLevel(3).setHarvestSpeed(9.0F)
						.setDamageVsEntity(3.0F).setEnchantability(39);
		malachiteTools.GetConfig(settings);
		
		ashstoneTools = new ConfigTool("Ashstone Tools").setUses(900)
						.setHarvestLevel(3).setHarvestSpeed(16.0F)
						.setDamageVsEntity(2.0F).setEnchantability(7);
		ashstoneTools.GetConfig(settings);
		
        illumeniteTools = new ConfigTool("Illumenite Tools").setUses(700)
                        .setHarvestLevel(3).setHarvestSpeed(8.0F).setDamageVsEntity(4.0F)
                        .setEnchantability(7);
        illumeniteTools.GetConfig(settings);
        illumeniteNVTime =  settings.getInt("NightVisionTime", illumeniteTools.getSubCategory(), 
        		3600, 0, 9999, "night vision duration (user)(seconds)");
        illumeniteBlindnessTime =  settings.getInt("BlindnessTime", illumeniteTools.getSubCategory(),
        		60, 0, 999, "blindness duration (target)(seconds)");
        illumeniteSlowTime = settings.getInt("SlowTime", illumeniteTools.getSubCategory(),
        		200, 0, 999, "slowness duration (target)(seconds)");
        illumeniteSlowLevel = settings.getInt("SlowLevel", illumeniteTools.getSubCategory(),
        		3, 0, 9, "slowness level (target)");
        
        dragonstoneTools = new ConfigTool("Dragonstone Tools")
                        .setUses(4000).setHarvestLevel(4).setHarvestSpeed(10.0F)
                        .setDamageVsEntity(8.0F).setEnchantability(27);
        dragonstoneTools.GetConfig(settings);
        
        argoniteTools = new ConfigTool("Argonite Tools").setUses(1300)
                        .setHarvestLevel(3).setHarvestSpeed(8.0F).setDamageVsEntity(3.0F)
                        .setEnchantability(18);
        argoniteTools.GetConfig(settings);
		
	} // end configureTools()

	public static void configureItems() 
	{
		//Items
		fyriteIngot = new ConfigItem("Fyrite Ingot", ConfigHelper.CATEGORY_ITEM)
						.setSmeltingXP(0.8F);
		fyriteIngot.GetConfig(settings);
		
		malachiteIngot = new ConfigItem("Malachite Ingot", ConfigHelper.CATEGORY_ITEM)
				.setSmeltingXP(0.5F);
		malachiteIngot.GetConfig(settings);
		
		ashstoneGem = new ConfigItem("Ashstone Gem", ConfigHelper.CATEGORY_ITEM)
						.setSmeltingXP(0.8F);
		ashstoneGem.GetConfig(settings);
        illumeniteIngot = new ConfigItem("Illumenite Ingot", ConfigHelper.CATEGORY_ITEM)
                        .setSmeltingXP(0.8F);
        illumeniteIngot.GetConfig(settings);
		dragonstoneGem = new ConfigItem("Dragonstone Gem", ConfigHelper.CATEGORY_ITEM)
						.setSmeltingXP(1.0F);
		dragonstoneGem.GetConfig(settings);
		argoniteIngot = new ConfigItem("Argonite Ingot", ConfigHelper.CATEGORY_ITEM)
						.setSmeltingXP(0.7F);
		argoniteIngot.GetConfig(settings);
	} // end configuredItems()

	public static void configureOres() 
	{
		// Ores
        fyriteOre = new ConfigOre("Fyrite Ore").setHardness(3.0F)
                        .setResistance(10.0F).setLightValue(0.0F).setHarvestLevel(2)
                        .setHarvestTool("pickaxe").setSpawnRate(10).setVeinSize(6)
                        .setMinHeight(1).setMaxHeight(127);
        fyriteOre.GetConfig(settings);
        
        malachiteOre = new ConfigOre("Malachite Ore").setHardness(3.0F)
                        .setResistance(10.0F).setLightValue(0.0F).setHarvestLevel(2)
                        .setHarvestTool("pickaxe").setSpawnRate(10).setVeinSize(7)
                        .setMinHeight(1).setMaxHeight(127);
        malachiteOre.GetConfig(settings);
        
        ashstoneOre = new ConfigOre("Ashstone Ore").setHardness(3.0F)
                        .setResistance(10.0F).setLightValue(0.0F).setHarvestLevel(2)
                        .setHarvestTool("pickaxe").setSpawnRate(10).setVeinSize(5)
                        .setMinHeight(1).setMaxHeight(127);
        ashstoneOre.GetConfig(settings);
        
        illumeniteOre = new ConfigOre("Illumenite Ore").setHardness(3.0F)
                        .setResistance(10.0F).setLightValue(1.0F).setHarvestLevel(2)
                        .setHarvestTool("pickaxe").setSpawnRate(350).setVeinSize(15)
                        .setMinHeight(1).setMaxHeight(127);
        illumeniteOre.GetConfig(settings);
        dragonstoneOre = new ConfigOre("Dragonstone Ore")
                        .setHardness(3.0F).setResistance(10.0F).setLightValue(0.0F)
                        .setHarvestLevel(2).setHarvestTool("pickaxe").setSpawnRate(6)
                        .setVeinSize(6).setMinHeight(1).setMaxHeight(127);
        dragonstoneOre.GetConfig(settings);
        argoniteOre = new ConfigOre("Argonite Ore").setHardness(3.0F)
                        .setResistance(10.0F).setLightValue(0.0F).setHarvestLevel(2)
                        .setHarvestTool("pickaxe").setSpawnRate(10).setVeinSize(6)
                        .setMinHeight(1).setMaxHeight(127);
        argoniteOre.GetConfig(settings);
	} // end configureOres()

	public static void configureBlocks() 
	{
		fyriteBlock = new ConfigBlock("Fyrite Block", ConfigHelper.CATEGORY_BLOCK).setHardness(7.0F)
						.setResistance(12.0F).setLightValue(0.0F)
						.setHarvestLevel(0).setHarvestTool("pickaxe")
						.setBeaconBase(true);
		fyriteBlock.GetConfig(settings);
		malachiteBlock = new ConfigBlock("Malachite Block", ConfigHelper.CATEGORY_BLOCK)
						.setHardness(7.0F).setResistance(12.0F)
						.setLightValue(0.0F).setHarvestLevel(0)
						.setHarvestTool("pickaxe")
						.setBeaconBase(true);
		malachiteBlock.GetConfig(settings);
		ashstoneBlock = new ConfigBlock("Ashstone Block", ConfigHelper.CATEGORY_BLOCK)
						.setHardness(7.0F).setResistance(12.0F)
						.setLightValue(0.0F).setHarvestLevel(0)
						.setHarvestTool("pickaxe")
						.setBeaconBase(true);
		ashstoneBlock.GetConfig(settings);
		illumeniteBlock = new ConfigBlock("Illumenite Block", ConfigHelper.CATEGORY_BLOCK)
						.setHardness(7.0F).setResistance(10.0F)
						.setLightValue(1.0F).setHarvestLevel(0)
						.setHarvestTool("pickaxe")
						.setBeaconBase(true);
		illumeniteBlock.GetConfig(settings);
		dragonstoneBlock = new ConfigBlock("Dragonstone Block", ConfigHelper.CATEGORY_BLOCK)
						.setHardness(10.0F).setResistance(45.0F)
						.setLightValue(0.0F).setHarvestLevel(0)
						.setHarvestTool("pickaxe")
						.setBeaconBase(true);
		dragonstoneBlock.GetConfig(settings);
		argoniteBlock = new ConfigBlock("Argonite Block", ConfigHelper.CATEGORY_BLOCK)
						.setHardness(7.0F).setResistance(12.0F)
						.setLightValue(0.0F).setHarvestLevel(0)
						.setHarvestTool("pickaxe")
						.setBeaconBase(true);
		argoniteBlock.GetConfig(settings);
	} // end configureBlocks()

	public static ConfigOre fyriteOre, malachiteOre, ashstoneOre, illumeniteOre, dragonstoneOre, argoniteOre;
	public static ConfigBlock fyriteBlock, malachiteBlock, ashstoneBlock, illumeniteBlock, dragonstoneBlock, argoniteBlock,
								netherFurnace;
	public static ConfigItem fyriteIngot, malachiteIngot, ashstoneGem, illumeniteIngot, dragonstoneGem, argoniteIngot, 
								argoniteBucket;
	
	public static ConfigTool fyriteTools, malachiteTools, ashstoneTools, illumeniteTools, dragonstoneTools, argoniteTools;
	
	public static ConfigArmor fyriteArmor, malachiteArmor, illumeniteArmor, dragonstoneArmor;
	public static int illumeniteNVTime, illumeniteBlindnessTime, illumeniteSlowTime, malachiteJumpBoost,
			illumeniteSlowLevel, netherFurnaceSpeed, netherrackBurnTime, fyriteBurnTime, blazeRodBurnTime;
	public static boolean malachiteEffect, fyriteEffect, illumeniteEffect;
	
//	public static ConfigValue armorEffects, toolEffects, coloredGUIs, 
								 
} // end class Settings
