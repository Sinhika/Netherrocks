package mod.alexndr.netherrocks;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import mod.alexndr.netherrocks.config.NetherrocksConfig;
import mod.alexndr.netherrocks.content.NetherrocksArmorMaterial;
import mod.alexndr.netherrocks.generation.OreGeneration;
import mod.alexndr.simplecorelib.loot.ChestLootHandler;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.DamageSource;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.event.LootTableLoadEvent;
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

    @SubscribeEvent(receiveCanceled = true, priority= EventPriority.HIGHEST)
    public static void onLivingAttackEvent(LivingAttackEvent event)
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
                LOGGER.debug("Canceled fall damage because of illumenite");
            } // end-if full set of Illumenite and fall damage
            else if (event.getSource().isFireDamage()
                     && ModUtil.isPlayerWearingFullSet(player,
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
        if (!OreGeneration.checkAndInitBiome(evt)) return;
        
        if (evt.getCategory() == Biome.Category.NETHER) 
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
            String prefix = "minecraft:chests/";
            String name = event.getName().toString();

            if (name.startsWith(prefix)) 
            {
                String file = name.substring(name.indexOf(prefix) + prefix.length());
                
                // village chests are a bit more complicated now, but use the old
                // village_blacksmith chest loot table anyway.
                if (file.startsWith("village/village_")) 
                {
                    String village = "village/";
                    file = file.substring(file.indexOf(village) + village.length());
                }
                else if (file.startsWith("stronghold_")) 
                {
                    file = "stronghold";
                }
                switch (file) {
                case "simple_dungeon":
                case "woodland_mansion":
                case "shipwreck_supply":
                case "shipwreck_map":
                case "shipwreck_treasure":
                case "buried_treasure":
                case "pillager_outpost":
                case "underwater_ruin_small":
                case "underwater_ruin_big":
                    LOGGER.debug("Attempting to inject loot pool for " + file);
                    event.getTable().addPool(ChestLootHandler.getInjectPool(Netherrocks.MODID, "simple_dungeon"));
                    break;
                case "nether_bridge":
                    LOGGER.debug("Attempting to inject loot pool for " + file);
                    event.getTable().addPool(ChestLootHandler.getInjectPool(Netherrocks.MODID, "nether"));
                    break;
                case "village_weaponsmith":
                case "village_toolsmith":
                case "village_armorer":
                case "village_mason":
                case "desert_pyramid":
                case "abandoned_mineshaft":
                case "jungle_temple":
                case "stronghold":
                case "igloo_chest":
                    LOGGER.debug("Attempting to inject loot pool for " + file);
                    event.getTable().addPool(ChestLootHandler.getInjectPool(Netherrocks.MODID, file));
                    break;
                default:
                    // cases deliberately ignored:
                    // dispensers, because you don't shoot ingots/ores/tools at people.
                    // other villagers
                    // the_end, because no end ores or metals.
                    break;
                } // end-switch
            } // end-if chest loot
            
        } // end-if config allows
    } // end LootLoad()
    
} // end-class
