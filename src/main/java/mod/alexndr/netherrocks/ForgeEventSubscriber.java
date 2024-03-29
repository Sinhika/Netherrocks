package mod.alexndr.netherrocks;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import mod.alexndr.netherrocks.config.NetherrocksConfig;
import mod.alexndr.netherrocks.content.FyritePressurePlateBlock;
import mod.alexndr.netherrocks.content.NetherrocksArmorMaterial;
import mod.alexndr.netherrocks.helpers.NetherrocksInjectionLookup;
import mod.alexndr.simplecorelib.api.helpers.ArmorUtils;
import mod.alexndr.simplecorelib.api.helpers.LootUtils;
import net.minecraft.core.BlockPos;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.event.LootTableLoadEvent;
import net.minecraftforge.event.VanillaGameEvent;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

/**
 * Subscribe to events from the FORGE EventBus that should be handled on both PHYSICAL sides in this class
 *
 */
@EventBusSubscriber(modid = Netherrocks.MODID, bus = EventBusSubscriber.Bus.FORGE )
public final class ForgeEventSubscriber
{
    private static final Logger LOGGER = LogManager.getLogger(Netherrocks.MODID + " Forge Event Subscriber");
    private static final NetherrocksInjectionLookup lootLookupMap = new NetherrocksInjectionLookup();

    @SubscribeEvent(receiveCanceled = true, priority= EventPriority.HIGHEST)
    public static void onLivingAttackEvent(LivingAttackEvent event)
    {
        // first, is it a player?
        if (event.getEntity() instanceof Player)
        {
            Player player = (Player) event.getEntity();
            LOGGER.debug("caught LivingAttackEvent");

            DamageSource source = event.getSource();
            
            // fall damage and are they wearing full illumenite armor?
            if ((source.is(DamageTypes.FALL))
            	   && ArmorUtils.isPlayerWearingFullSet(player, NetherrocksArmorMaterial.ILLUMENITE))
            {
                // pro-forma cancelable check.
                if (event.isCancelable()) event.setCanceled(true);
                LOGGER.debug("Canceled fall damage because of illumenite");
            } // end-if full set of Illumenite and fall damage
            else if ((source.is(DamageTypes.IN_FIRE) || source.is(DamageTypes.ON_FIRE) || source.is(DamageTypes.HOT_FLOOR)
            		 	|| source.is(DamageTypes.LAVA) || source.is(DamageTypes.FIREBALL) || source.is(DamageTypes.FIREWORKS))
                     && ArmorUtils.isPlayerWearingFullSet(player, NetherrocksArmorMaterial.FYRITE))
            {
                // pro-forma cancelable check.
                if (event.isCancelable()) event.setCanceled(true);
                LOGGER.debug("Canceled fire damage because of fyrite");
            } // end-else-if full set of Fyrite and fire damage
        } // end-if player
    } // end onLivingHurtEvent

    /**
     * add mod loot to loot tables. Code heavily based on Botania's LootHandler, which
     * neatly solves the problem when I couldn't figure it out.
     */
    @SubscribeEvent
    public static void LootLoad(final LootTableLoadEvent event)
    {
        if (NetherrocksConfig.addModLootToChests)
        {
            LootUtils.LootLoadHandler(Netherrocks.MODID,  event, lootLookupMap);
        } // end-if config allows
    } // end LootLoad()
    
    /**
     * intercept BLOCK_PRESSED, BLOCK_UNPRESSED game events for fyrite pressure plates and 
     * set things on fire / stop setting on fire.
     */
    @SubscribeEvent
    public static void onVanillaGameEvent(VanillaGameEvent event)
    {
        // we only care about BLOCK_PRESSED events.
        if (event.getVanillaEvent() == GameEvent.BLOCK_ACTIVATE)
        {
            // is the responsible block a FyritePressurePlateBlock?
        	Vec3 pos = event.getEventPosition();
        	BlockPos blockPos = BlockPos.containing(pos.x(), pos.y(), pos.z());
            BlockState bs = event.getLevel().getBlockState(blockPos);
            if (bs == null) { return; }
            
            if (! (bs.getBlock() instanceof FyritePressurePlateBlock))
            {
                return;
            }
            Entity entity = event.getCause();
            if (entity == null) { return; }
            if (!entity.fireImmune())
            {
                entity.setSecondsOnFire(10);
            }
        } // end-if BLOCK_PRESS  
    } // end onVanillaGameEvent

} // end-class
