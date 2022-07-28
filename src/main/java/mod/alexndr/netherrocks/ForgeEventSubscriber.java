package mod.alexndr.netherrocks;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import mod.alexndr.netherrocks.config.NetherrocksConfig;
import mod.alexndr.netherrocks.content.FyritePressurePlateBlock;
import mod.alexndr.netherrocks.content.NetherrocksArmorMaterial;
import mod.alexndr.netherrocks.generation.OreGeneration;
import mod.alexndr.netherrocks.helpers.NetherrocksInjectionLookup;
import mod.alexndr.simplecorelib.api.helpers.ArmorUtils;
import mod.alexndr.simplecorelib.api.helpers.LootUtils;
import net.minecraft.core.BlockPos;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraftforge.event.LootTableLoadEvent;
import net.minecraftforge.event.VanillaGameEvent;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.event.world.BiomeLoadingEvent;
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

            // fall damage and are they wearing full illumenite armor?
            if ((event.getSource() == DamageSource.FALL) &&
                    ArmorUtils.isPlayerWearingFullSet(player,
                                               NetherrocksArmorMaterial.ILLUMENITE))
            {
                // pro-forma cancelable check.
                if (event.isCancelable()) event.setCanceled(true);
                LOGGER.debug("Canceled fall damage because of illumenite");
            } // end-if full set of Illumenite and fall damage
            else if (event.getSource().isFire()
                     && ArmorUtils.isPlayerWearingFullSet(player,
                                                      NetherrocksArmorMaterial.FYRITE))
            {
                // pro-forma cancelable check.
                if (event.isCancelable()) event.setCanceled(true);
                LOGGER.debug("Canceled fire damage because of fyrite");
            } // end-else-if full set of Fyrite and fire damage
        } // end-if player
    } // end onLivingHurtEvent

    /**
     * Biome loading triggers ore generation.
     */
    @SubscribeEvent(priority=EventPriority.HIGH)
    public static void onBiomeLoading(BiomeLoadingEvent evt)
    {
        if (evt.getCategory() == Biome.BiomeCategory.NETHER) 
        {
            OreGeneration.generateNetherOres(evt);
        }
    } // end onBiomeLoading()
    
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
        // is the responsible block a FyritePressurePlateBlock?
        Level level = event.getLevel();
        BlockPos pos = event.getEventPosition();
        if (! (level.getBlockState(pos).getBlock() instanceof FyritePressurePlateBlock))
        {
            return;
        }
        // we only care about BLOCK_PRESSED events.
        if (event.getVanillaEvent() == GameEvent.BLOCK_PRESS)
        {
            Entity entity = event.getCause();
            if (entity == null) { return; }
//            if (entity instanceof ItemEntity) 
//            {
//                ItemStack stack = ((ItemEntity) entity).getItem();
//                if (stack.getBurnTime(RecipeType.SMELTING) > 0) 
//                {
//                    entity.setSecondsOnFire(10);
//                }
//            } // end-else if ItemEntity
//            else 
            if (!entity.fireImmune())
            {
                entity.setSecondsOnFire(10);
            }
        } // end-if BLOCK_PRESS  
    } // end onVanillaGameEvent

} // end-class
