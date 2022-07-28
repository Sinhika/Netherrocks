package mod.alexndr.netherrocks.datagen;

import static net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus.MOD;

import mod.alexndr.netherrocks.Netherrocks;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.data.event.GatherDataEvent;

/**
 * bundles up the GatherDataEvent handler and all the necessary data providers for
 * data generation.
 * @author Sinhika
 */
@EventBusSubscriber(modid = Netherrocks.MODID, bus = MOD)
public class NetherrocksDataGenerator
{
    /**
     * GatherDataEvent handler.
     * @param event the GatherDataEvent.
     */
    @SubscribeEvent
    public static void gatherData(GatherDataEvent event)
    {
        DataGenerator gen = event.getGenerator();
        if (event.includeServer())
        {
            gen.addProvider(new Recipes(gen));
            gen.addProvider(new SilentsRecipes(gen));
            gen.addProvider(new ModBlockTags(gen, event.getExistingFileHelper()));
            gen.addProvider(new ModItemTags(gen, event.getExistingFileHelper()));
            gen.addProvider(new NetherrocksLootTableProvider(gen));
            gen.addProvider(new NetherrocksLootInjectorProvider(gen));
            gen.addProvider(new NetherrocksBlockStateProvider(gen, event.getExistingFileHelper()));
            gen.addProvider(new NetherrocksItemModelProvider(gen, event.getExistingFileHelper()));
        }
     } // end gatherData()

} // end class
