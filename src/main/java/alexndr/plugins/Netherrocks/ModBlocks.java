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
							ContentCategories.Block.ORE).setStepSound(SoundType.STONE);
	public static SimpleBlock malachite_ore = 
			new SimpleBlock("malachite_ore", Netherrocks.plugin, Material.ROCK, 
					ContentCategories.Block.ORE).setStepSound(SoundType.STONE);
	public static SimpleBlock ashstone_ore = 
			new SimpleBlock("ashstone_ore", Netherrocks.plugin, Material.ROCK, 
					ContentCategories.Block.ORE).setStepSound(SoundType.STONE);
	public static SimpleBlock illumenite_ore = 
			new SimpleBlock("illumenite_ore", Netherrocks.plugin, Material.GLASS, 
					ContentCategories.Block.ORE).setStepSound(SoundType.GLASS);
	public static SimpleBlock dragonstone_ore = 
			new SimpleBlock("dragonstone_ore", Netherrocks.plugin, Material.ROCK, 
					ContentCategories.Block.ORE).setStepSound(SoundType.STONE);
	public static SimpleBlock argonite_ore = 
			new SimpleBlock("argonite_ore", Netherrocks.plugin, Material.ROCK, 
					ContentCategories.Block.ORE).setStepSound(SoundType.STONE);
	
	// STORAGE BLOCKS
	public static SimpleBlock argonite_block = new SimpleBlock("argonite_block", Netherrocks.plugin, Material.IRON,
			ContentCategories.Block.GENERAL).setStepSound(SoundType.METAL);
	public static SimpleBlock fyrite_block = new SimpleBlock("fyrite_block", Netherrocks.plugin, Material.IRON,
			ContentCategories.Block.GENERAL).setStepSound(SoundType.METAL);
	public static SimpleBlock malachite_block = new SimpleBlock("malachite_block", Netherrocks.plugin, Material.IRON,
			ContentCategories.Block.GENERAL).setStepSound(SoundType.METAL);
	public static SimpleBlock ashstone_block = new SimpleBlock("ashstone_block", Netherrocks.plugin, Material.ROCK,
			ContentCategories.Block.GENERAL).setStepSound(SoundType.STONE);
	public static SimpleBlock illumenite_block = new SimpleBlock("illumenite_block", Netherrocks.plugin, Material.GLASS,
			ContentCategories.Block.GENERAL).setStepSound(SoundType.GLASS);
	public static SimpleBlock dragonstone_block = new SimpleBlock("dragonstone_block", Netherrocks.plugin,
			Material.ROCK, ContentCategories.Block.GENERAL).setStepSound(SoundType.STONE);
	
	// MACHINES
	public static NetherFurnaceBlock nether_furnace
			= new NetherFurnaceBlock("nether_furnace", false);
	public static NetherFurnaceBlock nether_furnace_lit  
			= new NetherFurnaceBlock("nether_furnace_lit", true);

	public static void configureBlocks() 
	{
		if (Settings.fyriteOre.isEnabled()) {
			fyrite_ore.setConfigEntry(Settings.fyriteOre)
					.setCreativeTab(TabHelper.blocksTab(SimpleCoreAPI.plugin));
		}
		if (Settings.malachiteOre.isEnabled()) {
			malachite_ore.setConfigEntry(Settings.malachiteOre)
					.setCreativeTab(TabHelper.blocksTab(SimpleCoreAPI.plugin));
		}
		if (Settings.ashstoneOre.isEnabled()) {
			ashstone_ore.setConfigEntry(Settings.ashstoneOre).setDropItem(true)
					.setItemToDrop(ModItems.ashstone_gem).setQuantityToDrop(1)
					.setCreativeTab(TabHelper.blocksTab(SimpleCoreAPI.plugin));
		}
		if (Settings.illumeniteOre.isEnabled()) {
			illumenite_ore.setConfigEntry(Settings.illumeniteOre)
					.setCreativeTab(TabHelper.blocksTab(SimpleCoreAPI.plugin));
		}
		if (Settings.dragonstoneOre.isEnabled()) {
			dragonstone_ore.setConfigEntry(Settings.dragonstoneOre).setDropItem(true)
					.setItemToDrop(ModItems.dragonstone_gem).setQuantityToDrop(1)
					.setCreativeTab(TabHelper.blocksTab(SimpleCoreAPI.plugin));
		}
		if (Settings.argoniteOre.isEnabled()) {
			argonite_ore.setConfigEntry(Settings.argoniteOre)
					.setCreativeTab(TabHelper.blocksTab(SimpleCoreAPI.plugin));
		}
		if (Settings.argoniteBlock.isEnabled()) {
			argonite_block.setConfigEntry(Settings.argoniteBlock)
					.setCreativeTab(TabHelper.decorationsTab(SimpleCoreAPI.plugin));
		}
		if (Settings.fyriteBlock.isEnabled()) {
			fyrite_block.setConfigEntry(Settings.fyriteBlock)
					.setCreativeTab(TabHelper.decorationsTab(SimpleCoreAPI.plugin));
		}
		if (Settings.malachiteBlock.isEnabled()) {
			malachite_block.setConfigEntry(Settings.malachiteBlock)
					.setCreativeTab(TabHelper.decorationsTab(SimpleCoreAPI.plugin));
		}
		if (Settings.ashstoneBlock.isEnabled()) { 
			ashstone_block.setConfigEntry(Settings.ashstoneBlock)
					.setCreativeTab(TabHelper.decorationsTab(SimpleCoreAPI.plugin));
		}
		if (Settings.illumeniteBlock.isEnabled()) {
			illumenite_block.setConfigEntry(Settings.illumeniteBlock)
					.setCreativeTab(TabHelper.decorationsTab(SimpleCoreAPI.plugin));
		}
		if (Settings.dragonstoneBlock.isEnabled()) {
			dragonstone_block.setConfigEntry(Settings.dragonstoneBlock)
					.setCreativeTab(TabHelper.decorationsTab(SimpleCoreAPI.plugin));
		}
		if (Settings.netherFurnace.isEnabled()) {
			nether_furnace.setConfigEntry(Settings.netherFurnace)
					.setCreativeTab(TabHelper.redstoneTab(SimpleCoreAPI.plugin));
			nether_furnace_lit.setConfigEntry(Settings.netherFurnace);
		}
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
