package mod.alexndr.netherrocks;

import com.google.common.base.Preconditions;
import mod.alexndr.netherrocks.config.ConfigHelper;
import mod.alexndr.netherrocks.config.ConfigHolder;
import mod.alexndr.netherrocks.content.*;
import mod.alexndr.netherrocks.generation.OreGeneration;
import mod.alexndr.netherrocks.init.ModBlocks;
import mod.alexndr.netherrocks.init.ModTabGroups;
import mod.alexndr.netherrocks.init.ModTiles;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.OreBlock;
import net.minecraft.block.material.Material;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.inventory.container.ContainerType;
import net.minecraft.inventory.container.FurnaceContainer;
import net.minecraft.item.*;
import net.minecraft.tileentity.FurnaceTileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.IForgeRegistryEntry;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.awt.event.ContainerEvent;

@Mod.EventBusSubscriber(modid = Netherrocks.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public final class ModEventSubscriber 
{
	private static final Logger LOGGER = LogManager.getLogger(Netherrocks.MODID + " Mod Event Subscriber");

	@SubscribeEvent
	public static void onCommonSetup(final FMLCommonSetupEvent event)
	{
		OreGeneration.setupNetherOreGen();
		LOGGER.debug("Common setup done");
	} // end onCommonSetup


	@SubscribeEvent
	public static void onRegisterContainers(final RegistryEvent.Register<ContainerType<?>> event)
	{
		// register containers.
		// TODO
		//event.getRegistry().register();
	} // end ()


	@SubscribeEvent
	public static void onRegisterTileEntities(final RegistryEvent.Register<TileEntityType<?>> event)
	{
		ModTiles.NETHER_FURNACE =
			TileEntityType.Builder.create(NetherFurnaceTileEntity::new,
										  ModBlocks.nether_furnace).build(null);
		// tile entities.
        event.getRegistry().register(
        	setup(ModTiles.NETHER_FURNACE, "nether_furnace_tile_entity")
		);
	} // end ()


	/**
	 * This method will be called by Forge when it is time for the mod to register its Blocks.
	 * This method will always be called before the Item registry method.
	 */
	@SubscribeEvent
	public static void onRegisterBlocks(final RegistryEvent.Register<Block> event)
	{
		// Register all your blocks inside this registerAll call
        event.getRegistry().registerAll(
				setup(new OreBlock(Block.Properties.create(Material.ROCK)
                       .hardnessAndResistance( 3.0F, 30.0F)
                       .harvestTool(ToolType.PICKAXE).harvestLevel(2)),
					  "fyrite_ore"),
				setup(new OreBlock(Block.Properties.create(Material.ROCK)
                        .hardnessAndResistance( 3.0F, 30.0F)
                        .harvestTool(ToolType.PICKAXE).harvestLevel(2)),
					  "malachite_ore"),
				setup(new OreBlock(Block.Properties.create(Material.ROCK)
                        .hardnessAndResistance( 5.0F, 30.0F)
                        .harvestTool(ToolType.PICKAXE).harvestLevel(3)),
					  "ashstone_ore"),
                setup(new OreBlock(Block.Properties.create(Material.ROCK)
                        .hardnessAndResistance( 5.0F, 30.0F)
                        .harvestTool(ToolType.PICKAXE).harvestLevel(3)),
					  "argonite_ore"),
				setup(new OreBlock(Block.Properties.create(Material.ROCK)
                        .hardnessAndResistance( 5.0F, 30.0F)
                        .harvestTool(ToolType.PICKAXE).harvestLevel(3)),
					  "dragonstone_ore"),
				setup(new OreBlock(Block.Properties.create(Material.ROCK)
						.hardnessAndResistance( 1.0F, 30.0F)
						.harvestTool(ToolType.PICKAXE).harvestLevel(2)
						.lightValue(15)),
					  "illumenite_ore"),
				setup(new Block(Block.Properties.create(Material.ROCK)
						.hardnessAndResistance(10.0F, 72.0F)
						.harvestTool(ToolType.PICKAXE).harvestLevel(1)),
					  "dragonstone_block"),
				setup(new Block(Block.Properties.create(Material.ROCK)
						.hardnessAndResistance(7.0F, 72.0F)
						.harvestTool(ToolType.PICKAXE).harvestLevel(1)),
					  "ashstone_block"),
				setup(new Block(Block.Properties.create(Material.ROCK)
						.hardnessAndResistance(7.0F, 72.0F)
						.harvestTool(ToolType.PICKAXE).harvestLevel(1)),
					  "fyrite_block"),
				setup(new Block(Block.Properties.create(Material.ROCK)
						.hardnessAndResistance(7.0F, 72.0F)
						.harvestTool(ToolType.PICKAXE).harvestLevel(1)),
					  "malachite_block"),
				setup(new Block(Block.Properties.create(Material.ROCK)
						.hardnessAndResistance(7.0F, 72.0F)
						.harvestTool(ToolType.PICKAXE).harvestLevel(1)
						.lightValue(15)),
					  "illumenite_block"),
				setup(new Block(Block.Properties.create(Material.ROCK)
						.hardnessAndResistance(7.0F, 72.0F)
						.harvestTool(ToolType.PICKAXE).harvestLevel(1)),
					  "argonite_block"),
				setup(new NetherFurnaceBlock(Block.Properties.create(Material.ROCK)
						.hardnessAndResistance(3.5F, 12.0F)
						 .lightValue(0).harvestTool(ToolType.PICKAXE)),
					  "nether_furnace")
        );
		LOGGER.debug("Registered Blocks");
	}

	/**
	 * This method will be called by Forge when it is time for the mod to register its Items.
	 * This method will always be called after the Block registry method.
	 */
	@SubscribeEvent
	public static void onRegisterItems(final RegistryEvent.Register<Item> event)
	{
		final IForgeRegistry<Item> registry = event.getRegistry();

		// ingots, nuggets, gems, parts
		registry.registerAll(
				setup(new Item(new Item.Properties().group(ModTabGroups.MOD_ITEM_GROUP)), "argonite_ingot"),
				setup(new Item(new Item.Properties().group(ModTabGroups.MOD_ITEM_GROUP)), "fyrite_ingot"),
				setup(new Item(new Item.Properties().group(ModTabGroups.MOD_ITEM_GROUP)), "illumenite_ingot"),
				setup(new Item(new Item.Properties().group(ModTabGroups.MOD_ITEM_GROUP)), "malachite_ingot"),
				setup(new Item(new Item.Properties().group(ModTabGroups.MOD_ITEM_GROUP)), "ashstone_gem"),
				setup(new Item(new Item.Properties().group(ModTabGroups.MOD_ITEM_GROUP)), "dragonstone_gem"),
				setup(new Item(new Item.Properties().group(ModTabGroups.MOD_ITEM_GROUP)), "argonite_nugget"),
				setup(new Item(new Item.Properties().group(ModTabGroups.MOD_ITEM_GROUP)), "fyrite_nugget"),
				setup(new Item(new Item.Properties().group(ModTabGroups.MOD_ITEM_GROUP)), "illumenite_nugget"),
				setup(new Item(new Item.Properties().group(ModTabGroups.MOD_ITEM_GROUP)), "malachite_nugget")
		);

		// armors
		registry.registerAll(
				// dragonstone
				setup(new ArmorItem(NetherrocksArmorMaterial.DRAGONSTONE, EquipmentSlotType.HEAD,
									new Item.Properties().group(ModTabGroups.MOD_ITEM_GROUP)), "dragonstone_helmet"),
				setup(new ArmorItem(NetherrocksArmorMaterial.DRAGONSTONE, EquipmentSlotType.CHEST,
									new Item.Properties().group(ModTabGroups.MOD_ITEM_GROUP)), "dragonstone_chestplate"),
				setup(new ArmorItem(NetherrocksArmorMaterial.DRAGONSTONE, EquipmentSlotType.LEGS,
									new Item.Properties().group(ModTabGroups.MOD_ITEM_GROUP)), "dragonstone_leggings"),
				setup(new ArmorItem(NetherrocksArmorMaterial.DRAGONSTONE, EquipmentSlotType.FEET,
									new Item.Properties().group(ModTabGroups.MOD_ITEM_GROUP)), "dragonstone_boots"),

				// fyrite
				setup(new FyriteArmorItem(NetherrocksArmorMaterial.FYRITE, EquipmentSlotType.HEAD,
										  new Item.Properties().group(ModTabGroups.MOD_ITEM_GROUP)), "fyrite_helmet"),
				setup(new FyriteArmorItem(NetherrocksArmorMaterial.FYRITE, EquipmentSlotType.CHEST,
									new Item.Properties().group(ModTabGroups.MOD_ITEM_GROUP)), "fyrite_chestplate"),
				setup(new FyriteArmorItem(NetherrocksArmorMaterial.FYRITE, EquipmentSlotType.LEGS,
									new Item.Properties().group(ModTabGroups.MOD_ITEM_GROUP)), "fyrite_leggings"),
				setup(new FyriteArmorItem(NetherrocksArmorMaterial.FYRITE, EquipmentSlotType.FEET,
									new Item.Properties().group(ModTabGroups.MOD_ITEM_GROUP)), "fyrite_boots"),

				// illumenite
				setup(new IllumeniteArmorItem(NetherrocksArmorMaterial.ILLUMENITE, EquipmentSlotType.HEAD,
									new Item.Properties().group(ModTabGroups.MOD_ITEM_GROUP)), "illumenite_helmet"),
				setup(new IllumeniteArmorItem(NetherrocksArmorMaterial.ILLUMENITE, EquipmentSlotType.CHEST,
									new Item.Properties().group(ModTabGroups.MOD_ITEM_GROUP)), "illumenite_chestplate"),
				setup(new IllumeniteArmorItem(NetherrocksArmorMaterial.ILLUMENITE, EquipmentSlotType.LEGS,
											  new Item.Properties().group(ModTabGroups.MOD_ITEM_GROUP)), "illumenite_leggings"),
				setup(new IllumeniteArmorItem(NetherrocksArmorMaterial.ILLUMENITE, EquipmentSlotType.FEET,
									new Item.Properties().group(ModTabGroups.MOD_ITEM_GROUP)), "illumenite_boots"),

				// malachite
				setup(new MalachiteArmorItem(NetherrocksArmorMaterial.MALACHITE, EquipmentSlotType.HEAD,
											 new Item.Properties().group(ModTabGroups.MOD_ITEM_GROUP)), "malachite_helmet"),
				setup(new MalachiteArmorItem(NetherrocksArmorMaterial.MALACHITE, EquipmentSlotType.CHEST,
									new Item.Properties().group(ModTabGroups.MOD_ITEM_GROUP)), "malachite_chestplate"),
				setup(new MalachiteArmorItem(NetherrocksArmorMaterial.MALACHITE, EquipmentSlotType.LEGS,
									new Item.Properties().group(ModTabGroups.MOD_ITEM_GROUP)), "malachite_leggings"),
				setup(new MalachiteArmorItem(NetherrocksArmorMaterial.MALACHITE, EquipmentSlotType.FEET,
									new Item.Properties().group(ModTabGroups.MOD_ITEM_GROUP)), "malachite_boots")
		);

		// tools
		registry.registerAll(
				// axes
				// TODO will need to change classes when tools effects implemented.
				setup(new AxeItem(NetherrocksItemTier.ARGONITE, 7.0F, -3.1F,
									new Item.Properties().group(ModTabGroups.MOD_ITEM_GROUP)), "argonite_axe"),
				setup(new AxeItem(NetherrocksItemTier.FYRITE, 7.0F, -3.1F,
									new Item.Properties().group(ModTabGroups.MOD_ITEM_GROUP)), "fyrite_axe"),
				setup(new AxeItem(NetherrocksItemTier.MALACHITE, 7.0F, -3.1F,
									new Item.Properties().group(ModTabGroups.MOD_ITEM_GROUP)), "malachite_axe"),
				setup(new AxeItem(NetherrocksItemTier.ASHSTONE, 7.0F, -3.1F,
									new Item.Properties().group(ModTabGroups.MOD_ITEM_GROUP)), "ashstone_axe"),
				setup(new AxeItem(NetherrocksItemTier.DRAGONSTONE, 7.0F, -3.1F,
									new Item.Properties().group(ModTabGroups.MOD_ITEM_GROUP)), "dragonstone_axe"),

				// hoes
				setup(new HoeItem(NetherrocksItemTier.ARGONITE,-2.0F,
						new Item.Properties().group(ModTabGroups.MOD_ITEM_GROUP)), "argonite_hoe"),
				setup(new HoeItem(NetherrocksItemTier.MALACHITE, -2.0F,
									new Item.Properties().group(ModTabGroups.MOD_ITEM_GROUP)), "malachite_hoe"),
				setup(new HoeItem(NetherrocksItemTier.ASHSTONE, -2.0F,
									new Item.Properties().group(ModTabGroups.MOD_ITEM_GROUP)), "ashstone_hoe"),
				setup(new HoeItem(NetherrocksItemTier.DRAGONSTONE, -2.0F,
									new Item.Properties().group(ModTabGroups.MOD_ITEM_GROUP)), "dragonstone_hoe"),

                // pickaxes
				// TODO will need to change classes when tools effects implemented.
				setup(new PickaxeItem(NetherrocksItemTier.ARGONITE, 1, -2.8F,
										new Item.Properties().group(ModTabGroups.MOD_ITEM_GROUP)), "argonite_pickaxe"),
				setup(new PickaxeItem(NetherrocksItemTier.FYRITE, 1, -2.8F,
									new Item.Properties().group(ModTabGroups.MOD_ITEM_GROUP)), "fyrite_pickaxe"),
				setup(new PickaxeItem(NetherrocksItemTier.MALACHITE, 1, -2.8F,
									new Item.Properties().group(ModTabGroups.MOD_ITEM_GROUP)), "malachite_pickaxe"),
				setup(new PickaxeItem(NetherrocksItemTier.ASHSTONE, 1, -2.8F,
									new Item.Properties().group(ModTabGroups.MOD_ITEM_GROUP)), "ashstone_pickaxe"),
				setup(new PickaxeItem(NetherrocksItemTier.DRAGONSTONE, 1, -2.8F,
									new Item.Properties().group(ModTabGroups.MOD_ITEM_GROUP)), "dragonstone_pickaxe"),

				// shovels
				// TODO will need to change classes when tools effects implemented.
				setup(new ShovelItem(NetherrocksItemTier.ARGONITE, 1.5F, -3.0F,
									 new Item.Properties().group(ModTabGroups.MOD_ITEM_GROUP)), "argonite_shovel"),
				setup(new ShovelItem(NetherrocksItemTier.FYRITE, 1.5F, -3.0F,
									new Item.Properties().group(ModTabGroups.MOD_ITEM_GROUP)), "fyrite_shovel"),
				setup(new ShovelItem(NetherrocksItemTier.MALACHITE, 1.5F, -3.0F,
									new Item.Properties().group(ModTabGroups.MOD_ITEM_GROUP)), "malachite_shovel"),
				setup(new ShovelItem(NetherrocksItemTier.ASHSTONE, 1.5F, -3.0F,
									new Item.Properties().group(ModTabGroups.MOD_ITEM_GROUP)), "ashstone_shovel"),
				setup(new ShovelItem(NetherrocksItemTier.DRAGONSTONE, 1.5F, -3.0F,
									new Item.Properties().group(ModTabGroups.MOD_ITEM_GROUP)), "dragonstone_shovel"),

				// swords
				// TODO will need to change classes when tools effects implemented.
				setup(new SwordItem(NetherrocksItemTier.ARGONITE, 3, -2.4F,
									new Item.Properties().group(ModTabGroups.MOD_ITEM_GROUP)), "argonite_sword"),
				setup(new SwordItem(NetherrocksItemTier.FYRITE, 3, -2.4F,
										new Item.Properties().group(ModTabGroups.MOD_ITEM_GROUP)), "fyrite_sword"),
				setup(new SwordItem(NetherrocksItemTier.MALACHITE, 3, -2.4F,
										new Item.Properties().group(ModTabGroups.MOD_ITEM_GROUP)), "malachite_sword"),
				setup(new SwordItem(NetherrocksItemTier.ASHSTONE, 3, -2.4F,
										new Item.Properties().group(ModTabGroups.MOD_ITEM_GROUP)), "ashstone_sword"),
				setup(new SwordItem(NetherrocksItemTier.DRAGONSTONE, 3, -2.4F,
										new Item.Properties().group(ModTabGroups.MOD_ITEM_GROUP)), "dragonstone_sword"),
				setup(new SwordItem(NetherrocksItemTier.ILLUMENITE, 3, -2.4F,
									new Item.Properties().group(ModTabGroups.MOD_ITEM_GROUP)), "illumenite_sword")
		);

		// We need to go over the entire registry so that we include any potential Registry Overrides
		for (final Block block : ForgeRegistries.BLOCKS.getValues()) {

			final ResourceLocation blockRegistryName = block.getRegistryName();
			Preconditions.checkNotNull(blockRegistryName, "Registry Name of Block \"" + block + "\" is null! This is not allowed!");

			// Check that the blocks is from our mod, if not, continue to the next block
			if (!blockRegistryName.getNamespace().equals(Netherrocks.MODID)) {
				continue;
			}
			// Make the properties, and make it so that the item will be on our ItemGroup (CreativeTab)
			final Item.Properties properties = new Item.Properties().group(ModTabGroups.MOD_ITEM_GROUP);

			// Create the new BlockItem with the block and it's properties
			final BlockItem blockItem = new BlockItem(block, properties);
			// Setup the new BlockItem with the block's registry name and register it
			registry.register(setup(blockItem, blockRegistryName));
		}
		LOGGER.debug("Registered Items");
	}  // end onRegisterItems()

	@SubscribeEvent
	public static void onModConfigEvent(final ModConfig.ModConfigEvent event)
	{
		final ModConfig config = event.getConfig();

		// Rebake the configs when they change
		if (config.getSpec() == ConfigHolder.SERVER_SPEC) {
			ConfigHelper.bakeServer(config);
		}
	} // onModConfigEvent


    public static <T extends IForgeRegistryEntry<T>> T setup(final T entry,
													   final String name)
	{
		return setup(entry, new ResourceLocation(Netherrocks.MODID, name));
	}

	public static <T extends IForgeRegistryEntry<T>> T setup(final T entry,
													   final ResourceLocation registryName)
	{
		entry.setRegistryName(registryName);
		return entry;
	}

} // end class ModEventSubscriber
