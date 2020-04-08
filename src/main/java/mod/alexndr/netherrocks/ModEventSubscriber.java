package mod.alexndr.netherrocks;

import static mod.alexndr.netherrocks.Netherrocks.proxy;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import mod.alexndr.netherrocks.config.ConfigHelper;
import mod.alexndr.netherrocks.config.ConfigHolder;
import mod.alexndr.netherrocks.content.NetherFurnaceContainer;
import mod.alexndr.netherrocks.content.NetherFurnaceTileEntity;
import mod.alexndr.netherrocks.generation.OreGeneration;
import mod.alexndr.netherrocks.init.ModBlocks;
import mod.alexndr.netherrocks.init.ModContainers;
import mod.alexndr.netherrocks.init.ModTabGroups;
import mod.alexndr.netherrocks.init.ModTiles;
import net.minecraft.inventory.container.ContainerType;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.extensions.IForgeContainerType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.IForgeRegistryEntry;

@Mod.EventBusSubscriber(modid = Netherrocks.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public final class ModEventSubscriber 
{
	private static final Logger LOGGER = LogManager.getLogger(Netherrocks.MODID + " Mod Event Subscriber");

	@SubscribeEvent
	public static void onCommonSetup(final FMLCommonSetupEvent event)
	{
		proxy.init();
		OreGeneration.setupNetherOreGen();
		LOGGER.debug("Common setup done");
	} // end onCommonSetup


	@SubscribeEvent
	public static void onRegisterContainers(final RegistryEvent.Register<ContainerType<?>> event)
	{
		// register containers.
		ModContainers.NETHER_FURNACE =
			IForgeContainerType.create((windowId, inv, data) -> {
				return new NetherFurnaceContainer(windowId, inv);
			});
		event.getRegistry().register(
			setup(ModContainers.NETHER_FURNACE, "nether_furnace"));
	} // end ()


	@SubscribeEvent
	public static void onRegisterTileEntities(final RegistryEvent.Register<TileEntityType<?>> event)
	{
		ModTiles.NETHER_FURNACE =
			TileEntityType.Builder.create(NetherFurnaceTileEntity::new,
										  ModBlocks.nether_furnace.get()).build(null);
		// tile entities.
        event.getRegistry().register(
        	setup(ModTiles.NETHER_FURNACE, "nether_furnace_tile_entity")
		);
	} // end ()


	/**
	 * This method will be called by Forge when it is time for the mod to register its Items.
	 * This method will always be called after the Block registry method.
	 */
	@SubscribeEvent
	public static void onRegisterItems(final RegistryEvent.Register<Item> event)
	{
		final IForgeRegistry<Item> registry = event.getRegistry();
        // Automatically register BlockItems for all our Blocks
        ModBlocks.BLOCKS.getEntries().stream()
                .map(RegistryObject::get)
                // You can do extra filtering here if you don't want some blocks to have an BlockItem automatically registered for them
                // .filter(block -> needsItemBlock(block))
                // Register the BlockItem for the block
                .forEach(block -> {
                    // Make the properties, and make it so that the item will be on our ItemGroup (CreativeTab)
                    final Item.Properties properties = new Item.Properties().group(ModTabGroups.MOD_ITEM_GROUP);
                    // Create the new BlockItem with the block and it's properties
                    final BlockItem blockItem = new BlockItem(block, properties);
                    // Set the new BlockItem's registry name to the block's registry name
                    blockItem.setRegistryName(block.getRegistryName());
                    // Register the BlockItem
                    registry.register(blockItem);
                });
        LOGGER.debug("Registered BlockItems");
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
