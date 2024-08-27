package mod.alexndr.netherrocks.client;

import mod.alexndr.netherrocks.Netherrocks;
import mod.alexndr.netherrocks.client.gui.NetherBlastFurnaceScreen;
import mod.alexndr.netherrocks.client.gui.NetherFurnaceScreen;
import mod.alexndr.netherrocks.client.gui.NetherSmokerScreen;
import mod.alexndr.netherrocks.init.ModContainers;
import mod.alexndr.simplecorelib.client.gui.TestFurnaceScreen;
import mod.alexndr.simplecorelib.init.ModMenuTypes;
import net.neoforged.neoforge.client.event.RegisterMenuScreensEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Subscribe to events from the MOD EventBus that should be handled on the PHYSICAL CLIENT side in this class
 *
 * @author Sinhika
 */
// @EventBusSubscriber(modid = Netherrocks.MODID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientModEventSubscriber
{
    private static final Logger LOGGER = LogManager.getLogger(Netherrocks.MODID + " Client Mod Event Subscriber");
    
    public static void registerScreens(RegisterMenuScreensEvent event)
    {
        // uncomment to register client gui of test_furnace.
        event.register(ModMenuTypes.test_furnace.get(), TestFurnaceScreen::new);
        event.register(ModContainers.NETHER_FURNACE.get(), NetherFurnaceScreen::new);
        event.register(ModContainers.NETHER_BLAST_FURNACE.get(), NetherBlastFurnaceScreen::new);
        event.register(ModContainers.NETHER_SMOKER.get(), NetherSmokerScreen::new);
        LOGGER.debug("Registered ContainerType Screens");
    }

} // end class
