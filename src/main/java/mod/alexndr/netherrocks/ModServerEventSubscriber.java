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

    @SubscribeEvent(receiveCanceled = true)
    public static void onLivingHurtEvent(LivingHurtEvent event)
    {
        // first, is it a player?
        if (event.getEntityLiving() instanceof PlayerEntity)
        {
            PlayerEntity player = (PlayerEntity) event.getEntityLiving();
            LOGGER.info("caught LivingHurtEvent");

            // fall damage and are they wearing full illumenite armor?
            if ((event.getSource() == DamageSource.FALL) &&
                ModUtil.isPlayerWearingFullSet(player,
                                               NetherrocksArmorMaterial.ILLUMENITE))
            {
                // pro-forma cancelable check.
                if (event.isCancelable()) event.setCanceled(true);
                LOGGER.info("Canceled fall damage from illumenite");
            } // end-if full set of Illumenite
        } // end-if player
    } // end onLivingHurtEvent

} // end-class
