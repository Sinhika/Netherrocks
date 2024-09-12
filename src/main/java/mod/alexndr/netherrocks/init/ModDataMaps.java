package mod.alexndr.netherrocks.init;

import mod.alexndr.netherrocks.Netherrocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.entity.AbstractFurnaceBlockEntity;
import net.neoforged.neoforge.registries.datamaps.DataMapType;
import net.neoforged.neoforge.registries.datamaps.builtin.FurnaceFuel;

public class ModDataMaps
{
    /**
     * The {@linkplain Item} data map that replaces {@link AbstractFurnaceBlockEntity#getFuel()}.
     * <p>
     * The location of this data map is {@code <modid>/data_maps/item/nether_furnace_fuels.json}, and the values are objects with 1 field:
     * <ul>
     * <li>{@code burn_time}, a positive integer - how long the item will burn, in ticks</li>
     * </ul>
     *
     * The use of a integer as the value is also possible, though discouraged in case more options are added in the future.
     * This datamap is based on NeoForgeDataMaps.FURNACE_FUELS.
     *
     */
    public static final DataMapType<Item, FurnaceFuel> NETHER_FURNACE_FUELS = DataMapType.builder(
            id("nether_furnace_fuels"), Registries.ITEM, FurnaceFuel.CODEC).synced(FurnaceFuel.BURN_TIME_CODEC, false).build();

    private static ResourceLocation id(final String name) {
        return new ResourceLocation(Netherrocks.MODID, name);
    }
} // end class
