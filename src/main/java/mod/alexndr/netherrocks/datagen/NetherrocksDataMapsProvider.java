package mod.alexndr.netherrocks.datagen;

import mod.alexndr.netherrocks.init.ModDataMaps;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.DataMapProvider;
import net.neoforged.neoforge.registries.datamaps.builtin.FurnaceFuel;

import java.util.concurrent.CompletableFuture;

public class NetherrocksDataMapsProvider extends DataMapProvider
{

    /**
     * Create a new provider.
     *
     * @param packOutput     the output location
     * @param lookupProvider a {@linkplain CompletableFuture} supplying the registries
     */
    protected NetherrocksDataMapsProvider(PackOutput packOutput,
                                          CompletableFuture<HolderLookup.Provider> lookupProvider)
    {
        super(packOutput, lookupProvider);
    }

    /**
     * Generate data map entries.
     */
    @Override protected void gather()
    {
        final var fuels = builder(ModDataMaps.NETHER_FURNACE_FUELS);
        NetherFurnaceFuelHandler fuel_handler = new NetherFurnaceFuelHandler();
        fuel_handler.buildFuels((value, time) ->
                value.ifLeft(item -> fuels.add(item.builtInRegistryHolder(), new FurnaceFuel(time), false))
                .ifRight(tag -> fuels.add(tag, new FurnaceFuel(time), false)));

    }
} // end class
