package mod.alexndr.netherrocks;

import mod.alexndr.netherrocks.client.ClientModEventSubscriber;
import mod.alexndr.netherrocks.config.NetherrocksConfig;
import mod.alexndr.netherrocks.init.*;
import net.neoforged.bus.api.EventPriority;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.neoforge.client.event.RegisterMenuScreensEvent;
import net.neoforged.neoforge.common.NeoForge;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(Netherrocks.MODID)
public class Netherrocks
{
	// modid 
	public static final String MODID = "netherrocks";
	
    // public static final ResourceLocation SIMPLE_TEXTURE_ATLAS = new ResourceLocation(MODID, "textures/atlas/gui.png");

    // Directly reference a log4j logger.
    public static final Logger LOGGER = LogManager.getLogger();

    public Netherrocks(IEventBus modEventBus, ModContainer modContainer)
    {
    	LOGGER.debug("Hello from Netherrocks!");

        // Register DeferredRegisters
        ModArmorMaterials.ARMOR_MATERIALS.register(modEventBus);
        ModBlocks.BLOCKS.register(modEventBus);
        ModItems.ITEMS.register(modEventBus);
        CreativeTabs.CREATIVE_MODE_TABS.register(modEventBus);
        ModContainers.CONTAINER_TYPES.register(modEventBus);
        ModTiles.TILE_ENTITY_TYPES.register(modEventBus);
        ModSerializers.GLM.register(modEventBus);
        ModFeatures.FEATURES.register(modEventBus);
        // TODO register ModCodecs

        // register event listeners.
        modEventBus.addListener(ModEventSubscriber::onRegisterItems);
        NeoForge.EVENT_BUS.addListener(EventPriority.HIGHEST,true, ForgeEventSubscriber::onLivingAttackEvent);
        NeoForge.EVENT_BUS.addListener(ForgeEventSubscriber::onVanillaGameEvent);
        modEventBus.addListener(NetherrocksConfig::onLoad);
        // TODO

        // register client event listeners
        modEventBus.addListener(RegisterMenuScreensEvent.class, ClientModEventSubscriber::registerScreens);
        // TODO

        // Register Configs
        modContainer.registerConfig(ModConfig.Type.STARTUP, NetherrocksConfig.SPEC);

    } // end Netherrocks()

} // end class Netherrocks
