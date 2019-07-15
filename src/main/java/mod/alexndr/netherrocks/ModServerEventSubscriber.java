package mod.alexndr.netherrocks;

import mod.alexndr.netherrocks.content.NetherrocksArmorMaterial;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.DamageSource;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Subscribe to events from the FORGE EventBus that should be handled on both PHYSICAL sides in this class
 *
 */
@EventBusSubscriber(modid = Netherrocks.MODID, bus = EventBusSubscriber.Bus.MOD
    , value= Dist.DEDICATED_SERVER )
public final class ModServerEventSubscriber
{
    private static final Logger LOGGER =
        LogManager.getLogger(Netherrocks.MODID + " Mod Event Subscriber (Server)");

} // end-class
