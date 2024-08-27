package mod.alexndr.netherrocks.datagen;

import static net.neoforged.fml.common.Mod.EventBusSubscriber.Bus.MOD;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import mod.alexndr.netherrocks.Netherrocks;
import mod.alexndr.simplecorelib.api.datagen.SimpleLootTableProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod.EventBusSubscriber;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.data.event.GatherDataEvent;

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
        PackOutput packOutput = gen.getPackOutput();
        CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();		
        
        // server
        gen.addProvider(event.includeServer(), new Recipes(packOutput));

        ModBlockTags blockTags = new ModBlockTags(packOutput,lookupProvider, existingFileHelper);
        
        gen.addProvider(event.includeServer(), blockTags);
        gen.addProvider(event.includeServer(),
        		new ModItemTags(packOutput,lookupProvider, blockTags.contentsGetter(), existingFileHelper));
        
        gen.addProvider(event.includeServer(), 
            	new SimpleLootTableProvider(packOutput, List.of(
            			new LootTableProvider.SubProviderEntry(NetherrocksLootTableSubprovider::new, LootContextParamSets.BLOCK),
            			new LootTableProvider.SubProviderEntry(NetherrocksLootInjectorProvider::new, LootContextParamSets.CHEST)
            			)));
        
        gen.addProvider(event.includeServer(), new LootModifierProvider(packOutput));
        
        // client
        gen.addProvider(event.includeClient(),new NetherrocksBlockStateProvider(packOutput, existingFileHelper));
        gen.addProvider(event.includeClient(),new NetherrocksItemModelProvider(packOutput, existingFileHelper));
     } // end gatherData()

} // end class
