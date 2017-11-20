package alexndr.plugins.Netherrocks;

import alexndr.api.content.blocks.SimpleBlock;
import alexndr.api.core.SimpleCoreAPI;
import alexndr.api.helpers.game.TabHelper;
import alexndr.api.registry.ContentCategories;
import alexndr.plugins.Netherrocks.blocks.NetherFurnaceBlock;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.registries.IForgeRegistry;

public class ModBlocks 
{
	// ORES
	public static SimpleBlock fyrite_ore = 
			new SimpleBlock("fyrite_ore", Netherrocks.plugin, Material.ROCK, 
							ContentCategories.Block.ORE);
	public static SimpleBlock malachite_ore = 
			new SimpleBlock("malachite_ore", Netherrocks.plugin, Material.ROCK, 
					ContentCategories.Block.ORE);
	public static SimpleBlock ashstone_ore;
	public static SimpleBlock illumenite_ore;
	public static SimpleBlock dragonstone_ore;
	public static SimpleBlock argonite_ore;
	
	// STORAGE BLOCKS
	public static SimpleBlock fyrite_block;
	public static SimpleBlock malachite_block;
	public static SimpleBlock ashstone_block;
	public static SimpleBlock illumenite_block;
	public static SimpleBlock dragonstone_block;
	public static SimpleBlock argonite_block;
	
	// MACHINES
	public static NetherFurnaceBlock nether_furnace_lit;
	public static NetherFurnaceBlock nether_furnace;

	public static void configureBlocks() 
	{
		fyrite_ore.setConfigEntry(Settings.fyriteOre).setStepSound(SoundType.STONE)
				.setCreativeTab(TabHelper.blocksTab(SimpleCoreAPI.plugin));
		malachite_ore.setConfigEntry(Settings.malachiteOre).setStepSound(SoundType.STONE)
				.setCreativeTab(TabHelper.blocksTab(SimpleCoreAPI.plugin));
		ashstone_ore = new SimpleBlock(Netherrocks.plugin, Material.ROCK, ContentCategories.Block.ORE)
				.setConfigEntry(Settings.ashstoneOre).setStepSound(SoundType.STONE).setUnlocalizedName("ashstone_ore")
				.setDropItem(true).setItemToDrop(ashstone_gem).setQuantityToDrop(1)
				.setCreativeTab(TabHelper.blocksTab(SimpleCoreAPI.plugin));
		illumenite_ore = new SimpleBlock(Netherrocks.plugin, Material.GLASS, ContentCategories.Block.ORE)
				.setConfigEntry(Settings.illumeniteOre).setStepSound(SoundType.GLASS)
				.setUnlocalizedName("illumenite_ore").setCreativeTab(TabHelper.blocksTab(SimpleCoreAPI.plugin));
		dragonstone_ore = new SimpleBlock(Netherrocks.plugin, Material.ROCK, ContentCategories.Block.ORE)
				.setConfigEntry(Settings.dragonstoneOre).setStepSound(SoundType.STONE).setDropItem(true)
				.setItemToDrop(dragonstone_gem).setQuantityToDrop(1).setUnlocalizedName("dragonstone_ore")
				.setCreativeTab(TabHelper.blocksTab(SimpleCoreAPI.plugin));
		argonite_ore = new SimpleBlock(Netherrocks.plugin, Material.ROCK, ContentCategories.Block.ORE)
				.setConfigEntry(Settings.argoniteOre).setStepSound(SoundType.STONE).setUnlocalizedName("argonite_ore")
				.setCreativeTab(TabHelper.blocksTab(SimpleCoreAPI.plugin));
		//		
//		fyrite_block = new SimpleBlock(Netherrocks.plugin, Material.IRON,
//				ContentCategories.Block.GENERAL)
//				.setConfigEntry(Settings.fyriteBlock)
//				.setStepSound(SoundType.METAL)
//				.setUnlocalizedName("fyrite_block").setCreativeTab(TabHelper.decorationsTab(SimpleCoreAPI.plugin));
//		malachite_block = new SimpleBlock(Netherrocks.plugin,
//				Material.IRON,
//				ContentCategories.Block.GENERAL)
//				.setConfigEntry(Settings.malachiteBlock)
//				.setStepSound(SoundType.METAL)
//				.setUnlocalizedName("malachite_block").setCreativeTab(TabHelper.decorationsTab(SimpleCoreAPI.plugin));
//		ashstone_block = new SimpleBlock(Netherrocks.plugin,
//				Material.ROCK,
//				ContentCategories.Block.GENERAL)
//				.setConfigEntry(Settings.ashstoneBlock)
//				.setStepSound(SoundType.STONE)
//				.setUnlocalizedName("ashstone_block").setCreativeTab(TabHelper.decorationsTab(SimpleCoreAPI.plugin));
//		illumenite_block = new SimpleBlock(Netherrocks.plugin,
//				Material.GLASS,
//				ContentCategories.Block.GENERAL)
//				.setConfigEntry(Settings.illumeniteBlock)
//				.setStepSound(SoundType.GLASS)
//				.setUnlocalizedName("illumenite_block").setCreativeTab(TabHelper.decorationsTab(SimpleCoreAPI.plugin));
//		dragonstone_block = new SimpleBlock(Netherrocks.plugin,
//				Material.ROCK,
//				ContentCategories.Block.GENERAL)
//				.setConfigEntry(Settings.dragonstoneBlock)
//				.setStepSound(SoundType.STONE)
//				.setUnlocalizedName("dragonstone_block").setCreativeTab(TabHelper.decorationsTab(SimpleCoreAPI.plugin));
//		argonite_block = new SimpleBlock(Netherrocks.plugin,
//				Material.IRON,
//				ContentCategories.Block.GENERAL)
//				.setConfigEntry(Settings.argoniteBlock)
//				.setStepSound(SoundType.METAL)
//				.setUnlocalizedName("argonite_block").setCreativeTab(TabHelper.decorationsTab(SimpleCoreAPI.plugin));
//		
//		nether_furnace = new NetherFurnaceBlock(false)
//				.setConfigEntry(Settings.netherFurnace)
//				.setUnlocalizedName("nether_furnace").setCreativeTab(TabHelper.redstoneTab(SimpleCoreAPI.plugin));
//		nether_furnace_lit = new NetherFurnaceBlock(true)
//				.setConfigEntry(Settings.netherFurnace)
//				.setUnlocalizedName("nether_furnace_lit");
	} // end configureBlocks()

	/**
	 * Register blocks with Forge.
	 * 
	 * @param registry Forge block registry interface.
	 */
	public static void register(IForgeRegistry<Block> registry) 
	{
		if (Settings.fyriteOre.isEnabled()) registry.register(fyrite_ore);
		if (Settings.malachiteOre.isEnabled()) registry.register(malachite_ore);
		if (Settings.argoniteOre.isEnabled()) registry.register(argonite_block);
		if (Settings.ashstoneOre.isEnabled()) registry.register(ashstone_ore);
		if (Settings.dragonstoneOre.isEnabled()) registry.register(dragonstone_ore);
		if (Settings.illumeniteOre.isEnabled()) registry.register(illumenite_ore);
		if (Settings.argoniteBlock.isEnabled()) registry.register(argonite_block);
		if (Settings.ashstoneBlock.isEnabled()) registry.register(ashstone_block);
		if (Settings.dragonstoneBlock.isEnabled()) registry.register(dragonstone_block);
		if (Settings.fyriteBlock.isEnabled()) registry.register(fyrite_block);
		if (Settings.illumeniteBlock.isEnabled()) registry.register(illumenite_block);
		if (Settings.malachiteBlock.isEnabled()) registry.register(malachite_block);
		if (Settings.netherFurnace.isEnabled()) {
			registry.register(nether_furnace);
			registry.register(nether_furnace_lit);
		}
	} // end register()
	
	/**
	 * register ItemBlocks with Forge.
	 * 
	 * @param registry Forge item registry interface.
	 */
	public static void registerItemBlocks(IForgeRegistry<Item> registry) 
	{
		if (Settings.fyriteOre.isEnabled()) registry.register(fyrite_ore.createItemBlock());
		if (Settings.malachiteOre.isEnabled()) registry.register(malachite_ore.createItemBlock());
		if (Settings.argoniteOre.isEnabled()) registry.register(argonite_block.createItemBlock());
		if (Settings.ashstoneOre.isEnabled()) registry.register(ashstone_ore.createItemBlock());
		if (Settings.dragonstoneOre.isEnabled()) registry.register(dragonstone_ore.createItemBlock());
		if (Settings.illumeniteOre.isEnabled()) registry.register(illumenite_ore.createItemBlock());
		if (Settings.argoniteBlock.isEnabled()) registry.register(argonite_block.createItemBlock());
		if (Settings.ashstoneBlock.isEnabled()) registry.register(ashstone_block.createItemBlock());
		if (Settings.dragonstoneBlock.isEnabled()) registry.register(dragonstone_block.createItemBlock());
		if (Settings.fyriteBlock.isEnabled()) registry.register(fyrite_block.createItemBlock());
		if (Settings.illumeniteBlock.isEnabled()) registry.register(illumenite_block.createItemBlock());
		if (Settings.malachiteBlock.isEnabled()) registry.register(malachite_block.createItemBlock());
		if (Settings.netherFurnace.isEnabled()) {
			registry.register(nether_furnace.createItemBlock());
		}
	} // end registerItemBlocks()

	/**
	 * register models of ItemBlocks with Forge.
	 */
	public static void registerModels() 
	{
		if (Settings.fyriteOre.isEnabled()) 
			fyrite_ore.registerItemModel(Item.getItemFromBlock(fyrite_ore));
		if (Settings.malachiteOre.isEnabled())
			malachite_ore.registerItemModel(Item.getItemFromBlock(malachite_ore));
		if (Settings.argoniteOre.isEnabled())
			argonite_ore.registerItemModel(Item.getItemFromBlock(argonite_ore));
		if (Settings.ashstoneOre.isEnabled()) 
			ashstone_ore.registerItemModel(Item.getItemFromBlock(ashstone_ore));
		if (Settings.dragonstoneOre.isEnabled())
			dragonstone_ore.registerItemModel(Item.getItemFromBlock(dragonstone_ore));
		if (Settings.illumeniteOre.isEnabled()) 
			illumenite_ore.registerItemModel(Item.getItemFromBlock(illumenite_ore));
		
		if (Settings.argoniteBlock.isEnabled()) 
			argonite_block.registerItemModel(Item.getItemFromBlock(argonite_block));
		if (Settings.ashstoneBlock.isEnabled()) 
			ashstone_block.registerItemModel(Item.getItemFromBlock(ashstone_block));
		if (Settings.dragonstoneBlock.isEnabled()) 
			dragonstone_block.registerItemModel(Item.getItemFromBlock(dragonstone_block));
		if (Settings.fyriteBlock.isEnabled()) 
			fyrite_block.registerItemModel(Item.getItemFromBlock(fyrite_block));
		if (Settings.illumeniteBlock.isEnabled())
			illumenite_block.registerItemModel(Item.getItemFromBlock(illumenite_block));
		if (Settings.malachiteBlock.isEnabled())
			malachite_block.registerItemModel(Item.getItemFromBlock(malachite_block));

		if (Settings.netherFurnace.isEnabled()) {
			nether_furnace.registerItemModel(Item.getItemFromBlock(nether_furnace));
		}
	} // end registerModels()
	
	/**
	 * ore dictionary registrations for blocks.
	 */
	public static void registerOreDictionary()
	{
		if (Settings.fyriteOre.isEnabled()) {
			OreDictionary.registerOre("oreFyrite", new ItemStack(ModBlocks.fyrite_ore));
		}
		if (Settings.malachiteOre.isEnabled()) {
			OreDictionary.registerOre("oreMalachite", new ItemStack(ModBlocks.malachite_ore));
		}
		if (Settings.ashstoneOre.isEnabled()) {
			OreDictionary.registerOre("oreAshstone", new ItemStack(ModBlocks.ashstone_ore));
		}
		if (Settings.illumeniteOre.isEnabled()) {
			OreDictionary.registerOre("oreIllumenite", new ItemStack(ModBlocks.illumenite_ore));
		}
		if (Settings.dragonstoneOre.isEnabled()) {
			OreDictionary.registerOre("oreDragonstone", new ItemStack(ModBlocks.dragonstone_ore));
		}
		if (Settings.argoniteOre.isEnabled()) {
			OreDictionary.registerOre("oreArgonite", new ItemStack(ModBlocks.argonite_ore));
		}
		if (Settings.fyriteBlock.isEnabled())
			OreDictionary.registerOre("blockFyrite", new ItemStack(ModBlocks.fyrite_block));
		if (Settings.malachiteBlock.isEnabled())
			OreDictionary.registerOre("blockMalachite", new ItemStack(ModBlocks.malachite_block));
		if (Settings.ashstoneBlock.isEnabled())
			OreDictionary.registerOre("blockAshstone", new ItemStack(ModBlocks.ashstone_block));
		if (Settings.illumeniteBlock.isEnabled())
			OreDictionary.registerOre("blockIllumenite", new ItemStack(ModBlocks.illumenite_block));
		if (Settings.dragonstoneBlock.isEnabled()) 
			OreDictionary.registerOre("blockDragonstone", new ItemStack(ModBlocks.dragonstone_block));
		if (Settings.argoniteBlock.isEnabled())
			OreDictionary.registerOre("blockArgonite", new ItemStack(ModBlocks.argonite_block));
	} // end registerOreDictionary()
	
} // end class
