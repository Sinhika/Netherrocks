package alexndr.plugins.Netherrocks;

import java.io.File;

import alexndr.api.config.Configuration;
import alexndr.api.config.types.ConfigArmor;
import alexndr.api.config.types.ConfigBlock;
import alexndr.api.config.types.ConfigItem;
import alexndr.api.config.types.ConfigTool;
import alexndr.api.config.types.ConfigValue;
import alexndr.api.logger.LogHelper;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

/**
 * @author AleXndrTheGr8st
 */
public class Settings {
	private static Configuration settings = new Configuration();
	
	public static void createOrLoadSettings(FMLPreInitializationEvent event) 
	{
		settings.setModName("Netherrocks");
		File configDir = new File(event.getModConfigurationDirectory(), "AleXndr");
		File settingsFile = new File(configDir, "Netherrocks_Settings.xml" );
		settings.setFile(settingsFile);
		
		LogHelper.verbose("Netherrocks", "Loading Settings...");
		try {
			settings.load();
			settings.createHelpEntry(ModInfo.URL);

			//Blocks
			fyriteOre = settings.get(
					new ConfigBlock("Fyrite Ore", "Ores").setHardness(3.0F)
							.setResistance(10.0F).setLightValue(0.0F)
							.setHarvestLevel(2).setHarvestTool("pickaxe")
							.setSpawnRate(10).setVeinSize(6).setMinHeight(1)
							.setMaxHeight(127)
							.setCreativeTab("SimpleBlocks")).asConfigBlock();
			malachiteOre = settings.get(
					new ConfigBlock("Malachite Ore", "Ores").setHardness(3.0F)
							.setResistance(10.0F).setLightValue(0.0F)
							.setHarvestLevel(2).setHarvestTool("pickaxe")
							.setSpawnRate(10).setVeinSize(7).setMinHeight(1)
							.setMaxHeight(127)
							.setCreativeTab("SimpleBlocks")).asConfigBlock();
			ashstoneOre = settings.get(
					new ConfigBlock("Ashstone Ore", "Ores").setHardness(3.0F)
							.setResistance(10.0F).setLightValue(0.0F)
							.setHarvestLevel(2).setHarvestTool("pickaxe")
							.setSpawnRate(10).setVeinSize(5).setMinHeight(1)
							.setMaxHeight(127)
							.setCreativeTab("SimpleBlocks")).asConfigBlock();
			illumeniteOre = settings.get(
					new ConfigBlock("Illumenite Ore", "Ores").setHardness(3.0F)
							.setResistance(10.0F).setLightValue(1.0F)
							.setHarvestLevel(2).setHarvestTool("pickaxe")
							.setSpawnRate(350).setVeinSize(15).setMinHeight(1)
							.setMaxHeight(127)
							.setCreativeTab("SimpleBlocks")).asConfigBlock();
			dragonstoneOre = settings.get(
					new ConfigBlock("Dragonstone Ore", "Ores")
							.setHardness(3.0F).setResistance(10.0F)
							.setLightValue(0.0F).setHarvestLevel(2)
							.setHarvestTool("pickaxe").setSpawnRate(6)
							.setVeinSize(6).setMinHeight(1).setMaxHeight(127)
							.setCreativeTab("SimpleBlocks")).asConfigBlock();
			argoniteOre = settings.get(
					new ConfigBlock("Argonite Ore", "Ores").setHardness(3.0F)
							.setResistance(10.0F).setLightValue(0.0F)
							.setHarvestLevel(2).setHarvestTool("pickaxe")
							.setSpawnRate(10).setVeinSize(6).setMinHeight(1)
							.setMaxHeight(127)
							.setCreativeTab("SimpleBlocks")).asConfigBlock();
			
			fyriteBlock = settings.get(
					new ConfigBlock("Fyrite Block", "Blocks").setHardness(7.0F)
							.setResistance(10.0F).setLightValue(0.0F)
							.setHarvestLevel(0).setHarvestTool("pickaxe")
							.setCreativeTab("SimpleDecorations")
							.setBeaconBase(true)).asConfigBlock();
			malachiteBlock = settings.get(
					new ConfigBlock("Malachite Block", "Blocks")
							.setHardness(7.0F).setResistance(10.0F)
							.setLightValue(0.0F).setHarvestLevel(0)
							.setHarvestTool("pickaxe")
							.setCreativeTab("SimpleDecorations")
							.setBeaconBase(true)).asConfigBlock();
			ashstoneBlock = settings.get(
					new ConfigBlock("Ashstone Block", "Blocks")
							.setHardness(7.0F).setResistance(10.0F)
							.setLightValue(0.0F).setHarvestLevel(0)
							.setHarvestTool("pickaxe")
							.setCreativeTab("SimpleDecorations")
							.setBeaconBase(true)).asConfigBlock();
			illumeniteBlock = settings.get(
					new ConfigBlock("Illumenite Block", "Blocks")
							.setHardness(7.0F).setResistance(10.0F)
							.setLightValue(1.0F).setHarvestLevel(0)
							.setHarvestTool("pickaxe")
							.setCreativeTab("SimpleDecorations")
							.setBeaconBase(true)).asConfigBlock();
			dragonstoneBlock = settings.get(
					new ConfigBlock("Dragonstone Block", "Blocks")
							.setHardness(7.0F).setResistance(10.0F)
							.setLightValue(0.0F).setHarvestLevel(0)
							.setHarvestTool("pickaxe")
							.setCreativeTab("SimpleDecorations")
							.setBeaconBase(true)).asConfigBlock();
			argoniteBlock = settings.get(
					new ConfigBlock("Argonite Block", "Blocks")
							.setHardness(7.0F).setResistance(10.0F)
							.setLightValue(0.0F).setHarvestLevel(0)
							.setHarvestTool("pickaxe")
							.setCreativeTab("SimpleDecorations")
							.setBeaconBase(true)).asConfigBlock();
			
			netherFurnace = settings.get(new ConfigBlock("Nether Furnace", "Blocks")
					.setHardness(3.5F).setResistance(12.0F).setLightValue(1.0F)
					.setHarvestLevel(0).setHarvestTool("pickaxe")
					.setCreativeTab("SimpleMachines")
					.createNewValue("SmeltingTime", "@I", "100", "100")
					.createNewValue("NetherrackBurnTime", "@I", "200", "200")
					.createNewValue("FyriteBurnTime", "@I", "8000", "8000")
					.createNewValue("BlazeRodBurnTime", "@I", "2400", "2400"))
					.asConfigBlock();
				
			//Items
			fyriteIngot = settings.get(
					new ConfigItem("Fyrite Ingot", "Items").setStackSize(64)
							.setCreativeTab("SimpleMaterials")
							.setSmeltingXP(0.8F)).asConfigItem();
			malachiteIngot = settings.get(
					new ConfigItem("Malachite Ingot", "Items").setStackSize(64)
							.setCreativeTab("SimpleMaterials")
							.setSmeltingXP(0.5F)).asConfigItem();
			ashstoneGem = settings.get(
					new ConfigItem("Ashstone Gem", "Items").setStackSize(64)
							.setCreativeTab("SimpleMaterials")
							.setSmeltingXP(0.8F)).asConfigItem();
			illumeniteIngot = settings.get(
					new ConfigItem("Illumenite Ingot", "Items")
							.setStackSize(64).setCreativeTab("SimpleMaterials")
							.setSmeltingXP(0.8F)).asConfigItem();
			dragonstoneGem = settings.get(
					new ConfigItem("Dragonstone Gem", "Items").setStackSize(64)
							.setCreativeTab("SimpleMaterials")
							.setSmeltingXP(1.0F)).asConfigItem();
			argoniteIngot = settings.get(
					new ConfigItem("Argonite Ingot", "Items").setStackSize(64)
							.setCreativeTab("SimpleMaterials")
							.setSmeltingXP(0.7F)).asConfigItem();
			illumeniteRod = settings.get(
					new ConfigItem("Illumenite Rod", "Items").setStackSize(64)
							.setCreativeTab("SimpleMaterials")).asConfigItem();
			
			//Tools
			fyriteTools = settings.get(
					new ConfigTool("Fyrite Tools", "Tools").setUses(150)
							.setHarvestLevel(3).setHarvestSpeed(8.0F)
							.setDamageVsEntity(4.0F).setEnchantability(7))
					.asConfigTool();
			malachiteTools = settings.get(
					new ConfigTool("Malachite Tools", "Tools").setUses(700)
							.setHarvestLevel(3).setHarvestSpeed(9.0F)
							.setDamageVsEntity(3.0F).setEnchantability(39))
					.asConfigTool();
			ashstoneTools = settings.get(
					new ConfigTool("Ashstone Tools", "Tools").setUses(900)
							.setHarvestLevel(3).setHarvestSpeed(16.0F)
							.setDamageVsEntity(2.0F).setEnchantability(7))
					.asConfigTool();
			illumeniteTools = settings.get(new ConfigTool("Illumenite Tools", "Tools").setUses(700).setHarvestLevel(3).setHarvestSpeed(8.0F).setDamageVsEntity(4.0F).setEnchantability(7)
					.createNewValue("NightVisionTime", "@I", "3600", "3600").createNewValue("BlindnessTime", "@I", "60", "60")
					.createNewValue("SlowTime", "@I", "200", "200").createNewValue("SlowLevel", "@I", "3", "3")).asConfigTool();
					illumeniteNVTime = illumeniteTools.getValueByName("NightVisionTime");
					illumeniteBlindnessTime = illumeniteTools.getValueByName("BlindnessTime");
					illumeniteSlowTime = illumeniteTools.getValueByName("SlowTime");
					illumeniteSlowLevel = illumeniteTools.getValueByName("SlowLevel");
			dragonstoneTools = settings.get(new ConfigTool("Dragonstone Tools", "Tools").setUses(4000).setHarvestLevel(4).setHarvestSpeed(10.0F).setDamageVsEntity(8.0F).setEnchantability(27)).asConfigTool();
			argoniteTools = settings.get(new ConfigTool("Argonite Tools", "Tools").setUses(1300).setHarvestLevel(3).setHarvestSpeed(8.0F).setDamageVsEntity(3.0F).setEnchantability(18)).asConfigTool();
			
			//Armor
			fyriteArmor = settings.get(
					new ConfigArmor("Fyrite Armor", "Armors").setDurability(5)
							.setEnchantability(7).setHelmReduction(3)
							.setChestReduction(5).setLegsReduction(4)
							.setBootsReduction(3)
							.createNewValue("FireProof", "@B", "true", "true"))
					.asConfigArmor();
			fyriteEffect = fyriteArmor.getValueByName("FireProof");
			malachiteArmor = settings
					.get(new ConfigArmor("Malachite Armor", "Armors")
							.setDurability(16)
							.setEnchantability(39)
							.setHelmReduction(2)
							.setChestReduction(4)
							.setLegsReduction(4)
							.setBootsReduction(2)
							.createNewValue("JumpBoost", "@B", "true", "true")
							.createNewValue("BoostFactor", "@I", "1", "1"))
					.asConfigArmor();
			malachiteEffect = malachiteArmor.getValueByName("JumpBoost");
			malachiteJumpBoost = malachiteArmor.getValueByName("BoostFactor");
			illumeniteArmor = settings.get(
					new ConfigArmor("Illumenite Armor", "Armors")
							.setDurability(12)
							.setEnchantability(15)
							.setHelmReduction(4)
							.setChestReduction(5)
							.setLegsReduction(5)
							.setBootsReduction(3)
							.createNewValue("NoFallDamage", "@B", "true",
									"true")).asConfigArmor();
			illumeniteEffect = illumeniteArmor.getValueByName("NoFallDamage");
			dragonstoneArmor = settings.get(
					new ConfigArmor("Dragonstone Armor", "Armors")
							.setDurability(48).setEnchantability(27)
							.setHelmReduction(3).setChestReduction(9)
							.setLegsReduction(7).setBootsReduction(3))
					.asConfigArmor();
			
		}
		catch(Exception e) {
			LogHelper.severe("Netherrocks", "Failed to load settings");
			e.printStackTrace();
		}
		finally {
			settings.save();
			LogHelper.verbose("Netherrocks", "Settings loaded successfully");
		}
	}
	
	public static ConfigBlock fyriteOre, malachiteOre, ashstoneOre, illumeniteOre, dragonstoneOre, argoniteOre,
								fyriteBlock, malachiteBlock, ashstoneBlock, illumeniteBlock, dragonstoneBlock, argoniteBlock,
								netherFurnace;
	public static ConfigItem fyriteIngot, malachiteIngot, ashstoneGem, illumeniteIngot, dragonstoneGem, argoniteIngot, 
								illumeniteRod, argoniteBucket;
	
	public static ConfigTool fyriteTools, malachiteTools, ashstoneTools, illumeniteTools, dragonstoneTools, argoniteTools;
	
	public static ConfigArmor fyriteArmor, malachiteArmor, illumeniteArmor, dragonstoneArmor;
	
	public static ConfigValue updateChecker, armorEffects, toolEffects, coloredGUIs, 
								netherFurnaceSpeed, netherrackBurnTime, fyriteBurnTime, blazeRodBurnTime, 
								illumeniteNVTime, illumeniteBlindnessTime, illumeniteSlowTime, illumeniteSlowLevel, 
								malachiteEffect, malachiteJumpBoost, fyriteEffect, illumeniteEffect;
}
