package mod.alexndr.netherrocks;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import mod.alexndr.netherrocks.config.ConfigHolder;
import mod.alexndr.netherrocks.init.ModBlocks;
import mod.alexndr.netherrocks.init.ModContainers;
import mod.alexndr.netherrocks.init.ModItems;
import mod.alexndr.netherrocks.init.ModTiles;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(Netherrocks.MODID)
public class Netherrocks
{
	// modid 
	public static final String MODID = "netherrocks";

    // Directly reference a log4j logger.
    private static final Logger LOGGER = LogManager.getLogger();

    public Netherrocks()
    {
    	LOGGER.debug("Hello from Simple Ores:Netherrocks!");
    	
        final ModLoadingContext modLoadingContext = ModLoadingContext.get();
        final IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        
        ModBlocks.BLOCKS.register(modEventBus);
        ModItems.ITEMS.register(modEventBus);
        ModContainers.CONTAINER_TYPES.register(modEventBus);
        ModTiles.TILE_ENTITY_TYPES.register(modEventBus);

        // Register Configs
        modLoadingContext.registerConfig(ModConfig.Type.SERVER, ConfigHolder.SERVER_SPEC);
    } // end Netherrocks()

} // end class Netherrocks
