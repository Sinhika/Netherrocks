package mod.alexndr.netherrocks;

import mod.alexndr.netherrocks.content.NetherrocksArmorMaterial;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.DamageSource;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Subscribe to events from the FORGE EventBus that should be handled on both PHYSICAL sides in this class
 *
 */
@EventBusSubscriber(modid = Netherrocks.MODID, bus = EventBusSubscriber.Bus.FORGE )
public final class ForgeEventSubscriber
{
    private static final Logger LOGGER = LogManager.getLogger(Netherrocks.MODID + " Forge Event Subscriber");

    @SubscribeEvent(receiveCanceled = true, priority= EventPriority.HIGHEST)
    public static void onLivingHurtEvent(LivingAttackEvent event)
    {
        // first, is it a player?
        if (event.getEntityLiving() instanceof PlayerEntity)
        {
            PlayerEntity player = (PlayerEntity) event.getEntityLiving();
            LOGGER.debug("caught LivingAttackEvent");

            // fall damage and are they wearing full illumenite armor?
            if ((event.getSource() == DamageSource.FALL) &&
                ModUtil.isPlayerWearingFullSet(player,
                                               NetherrocksArmorMaterial.ILLUMENITE))
            {
                // pro-forma cancelable check.
                if (event.isCancelable()) event.setCanceled(true);
                LOGGER.debug("Canceled fall damage from illumenite");
            } // end-if full set of Illumenite
        } // end-if player
    } // end onLivingHurtEvent

} // end-class
