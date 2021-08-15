package mod.alexndr.netherrocks.client;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import mod.alexndr.netherrocks.Netherrocks;
import mod.alexndr.netherrocks.client.gui.NetherBlastFurnaceScreen;
import mod.alexndr.netherrocks.client.gui.NetherFurnaceScreen;
import mod.alexndr.netherrocks.client.gui.NetherSmokerScreen;
import mod.alexndr.netherrocks.init.ModContainers;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

/**
 * Subscribe to events from the MOD EventBus that should be handled on the PHYSICAL CLIENT side in this class
 *
 * @author Sinhika
 */
@EventBusSubscriber(modid = Netherrocks.MODID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientModEventSubscriber
{
    private static final Logger LOGGER = LogManager.getLogger(Netherrocks.MODID + " Client Mod Event Subscriber");

    /**
     * We need to register our renderers on the client because rendering code does not exist on the server
     * and trying to use it on a dedicated server will crash the game.
     * <p>
     * This method will be called by Forge when it is time for the mod to do its client-side setup
     * This method will always be called after the Registry events.
     * This means that all Blocks, Items, TileEntityTypes, etc. will all have been registered already
     */
    @SubscribeEvent
    public static void onFMLClientSetupEvent(final FMLClientSetupEvent event) 
    {
        // Register ContainerType Screens
        // ScreenManager.registerFactory is not safe to call during parallel mod loading so we queue it to run later
        event.enqueueWork(() -> {
            MenuScreens.register(ModContainers.NETHER_FURNACE.get(), NetherFurnaceScreen::new);
            MenuScreens.register(ModContainers.NETHER_BLAST_FURNACE.get(), NetherBlastFurnaceScreen::new);
            MenuScreens.register(ModContainers.NETHER_SMOKER.get(), NetherSmokerScreen::new);
            LOGGER.debug("Registered ContainerType Screens");
        });

    } // end ()
} // end class
