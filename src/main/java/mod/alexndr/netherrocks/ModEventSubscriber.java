package mod.alexndr.netherrocks;

import com.google.common.base.Preconditions;
import mod.alexndr.netherrocks.config.ConfigHelper;
import mod.alexndr.netherrocks.config.ConfigHolder;
import mod.alexndr.netherrocks.content.NetherrocksArmorMaterial;
import mod.alexndr.netherrocks.content.NetherrocksItemTier;
import mod.alexndr.netherrocks.content.SimpleAxe;
import mod.alexndr.netherrocks.content.SimplePickaxe;
import mod.alexndr.netherrocks.init.ModTabGroups;
import net.minecraft.block.Block;
import net.minecraft.block.OreBlock;
import net.minecraft.block.material.Material;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.*;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.IForgeRegistryEntry;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus.MOD;

@EventBusSubscriber(modid = Netherrocks.MODID, bus = MOD)
public final class ModEventSubscriber 
{
	private static final Logger LOGGER = LogManager.getLogger(Netherrocks.MODID + " Mod Event Subscriber");

	/**
	 * This method will be called by Forge when it is time for the mod to register its Blocks.
	 * This method will always be called before the Item registry method.
	 */
	@SubscribeEvent
	public static void onRegisterBlocks(final RegistryEvent.Register<Block> event)
	{
		// Register all your blocks inside this registerAll call
		// TODO
        event.getRegistry().registerAll(
                setup(new OreBlock(Block.Properties.create(Material.ROCK).hardnessAndResistance( 1.7F, 3.0F)), "argonite_ore"),
				setup(new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(20.0F, 100.0F)), "argonite_block")
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
		// TODO
		registry.registerAll(
				setup(new Item(new Item.Properties().group(ModTabGroups.MOD_ITEM_GROUP)), "argonite_ingot")
		);

		// armors
		// TODO
		registry.registerAll(
				// dragonstone
				setup(new ArmorItem(NetherrocksArmorMaterial.DRAGONSTONE, EquipmentSlotType.HEAD,
									new Item.Properties().group(ModTabGroups.MOD_ITEM_GROUP)), "dragonstone_helmet")

				// fyrite
				// TODO
				// illumenite
				// TODO
				// mallachite
				// TODO
		);

		// tools
		// TODO
		registry.registerAll(
				// axes
				setup(new SimpleAxe(NetherrocksItemTier.ARGONITE, 7.0F, -3.1F,
									new Item.Properties().group(ModTabGroups.MOD_ITEM_GROUP)), "argonite_axe"),

				// hoes
				setup(new HoeItem(NetherrocksItemTier.ARGONITE,-2.0F,
						new Item.Properties().group(ModTabGroups.MOD_ITEM_GROUP)), "argonite_hoe"),

                // pickaxes
				setup(new SimplePickaxe(NetherrocksItemTier.ARGONITE, 1, -2.8F,
										new Item.Properties().group(ModTabGroups.MOD_ITEM_GROUP)), "argonite_pickaxe"),

				// shovels
				setup(new ShovelItem(NetherrocksItemTier.ARGONITE, 1.5F, -3.0F,
									 new Item.Properties().group(ModTabGroups.MOD_ITEM_GROUP)), "argonite_shovel"),

				// swords
				setup(new SwordItem(NetherrocksItemTier.ARGONITE, 3, -2.4F,
									new Item.Properties().group(ModTabGroups.MOD_ITEM_GROUP)), "argonite_sword")
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
