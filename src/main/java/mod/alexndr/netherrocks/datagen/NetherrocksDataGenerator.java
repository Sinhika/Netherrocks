package mod.alexndr.netherrocks.datagen;

import static net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus.MOD;

import mod.alexndr.netherrocks.Netherrocks;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

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
        gen.addProvider(event.includeServer(), new Recipes(gen));
        gen.addProvider(event.includeServer(),new SilentsRecipes(gen));
        gen.addProvider(event.includeServer(),new ModBlockTags(gen, event.getExistingFileHelper()));
        gen.addProvider(event.includeServer(),new ModItemTags(gen, event.getExistingFileHelper()));
        gen.addProvider(event.includeServer(),new NetherrocksLootTableProvider(gen));
        gen.addProvider(event.includeServer(),new NetherrocksLootInjectorProvider(gen));
        gen.addProvider(event.includeServer(), new LootModifierProvider(gen));
        
        gen.addProvider(event.includeClient(),new NetherrocksBlockStateProvider(gen, event.getExistingFileHelper()));
        gen.addProvider(event.includeClient(),new NetherrocksItemModelProvider(gen, event.getExistingFileHelper()));
     } // end gatherData()

} // end class
