package mod.alexndr.netherrocks.datagen;

import mod.alexndr.netherrocks.Netherrocks;
import mod.alexndr.netherrocks.helpers.NetherrocksLootModifiers;
import mod.alexndr.simplecorelib.api.datagen.SimpleLootModifierProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.storage.loot.BuiltInLootTables;
import net.minecraft.world.level.storage.loot.LootTable;

import java.util.concurrent.CompletableFuture;

public class NetherrocksLootModifierProvider extends SimpleLootModifierProvider
{
    public NetherrocksLootModifierProvider(PackOutput output,
                                           CompletableFuture<HolderLookup.Provider> registries)
    {
        super(output, registries, Netherrocks.MODID);
    }

    @Override protected void add(ResourceKey<LootTable> targetLootTable, ResourceKey<LootTable> customLootTable)
    {
        this.add(targetLootTable.location().getPath(),
                new NetherrocksLootModifiers.NetherrocksChestLootModifier(
                        getCondition(targetLootTable.location()), customLootTable));
    }

    /**
     * Call {@link #add} here, which will pass in the necessary information to write the jsons.
     */
    @Override protected void start()
    {
        AddNetherAliases(NetherrocksLootInjectorProvider.BASTION);
        AddStrongholdAliases(NetherrocksLootInjectorProvider.STRONGHOLD);
        this.add(BuiltInLootTables.DESERT_PYRAMID, NetherrocksLootInjectorProvider.DESERT_PYRAMID);
        this.add(BuiltInLootTables.JUNGLE_TEMPLE, NetherrocksLootInjectorProvider.JUNGLE_TEMPLE);
        this.add(BuiltInLootTables.RUINED_PORTAL, NetherrocksLootInjectorProvider.RUINED_PORTAL);
    }
} // end class
