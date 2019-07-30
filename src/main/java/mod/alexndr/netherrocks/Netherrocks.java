package mod.alexndr.netherrocks;

import mod.alexndr.netherrocks.config.ConfigHolder;
import mod.alexndr.netherrocks.generation.OreGeneration;
import mod.alexndr.netherrocks.init.ClientProxy;
import mod.alexndr.netherrocks.init.IProxy;
import mod.alexndr.netherrocks.init.ServerProxy;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(Netherrocks.MODID)
public class Netherrocks
{
	// modid 
	public static final String MODID = "netherrocks";

    public static IProxy
        proxy = DistExecutor.runForDist(() -> () -> new ClientProxy(), () -> () -> new ServerProxy());

    // Directly reference a log4j logger.
    private static final Logger LOGGER = LogManager.getLogger();

    public Netherrocks()
    {
    	LOGGER.info("Hello from Simple Ores:Netherrocks!");
        final ModLoadingContext modLoadingContext = ModLoadingContext.get();

        // Register Configs
        modLoadingContext.registerConfig(ModConfig.Type.SERVER, ConfigHolder.SERVER_SPEC);
    } // end Netherrocks()

} // end class Netherrocks
