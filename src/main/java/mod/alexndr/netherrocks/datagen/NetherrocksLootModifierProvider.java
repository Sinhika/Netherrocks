package mod.alexndr.netherrocks.datagen;

import mod.alexndr.netherrocks.Netherrocks;
import mod.alexndr.netherrocks.helpers.NetherrocksLootModifiers;
import mod.alexndr.netherrocks.init.ModBlocks;
import mod.alexndr.netherrocks.init.ModTags;
import mod.alexndr.simplecorelib.api.datagen.SimpleLootModifierProvider;
import net.minecraft.advancements.critereon.BlockPredicate;
import net.minecraft.advancements.critereon.FluidPredicate;
import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.advancements.critereon.LocationPredicate;
import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.HolderSet;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.FluidTags;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.storage.loot.BuiltInLootTables;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.predicates.*;

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

        // TODO: are FluidTags not loaded when LootModifierProvider.start() runs?
        //HolderSet<Fluid> LavaSet = BuiltInRegistries.FLUID.getTag(FluidTags.LAVA).orElseThrow();

        add("auto_smelt_tool", new NetherrocksLootModifiers.AutoSmeltLootModifier(
                new LootItemCondition[] {
                        MatchTool.toolMatches(ItemPredicate.Builder.item().of(ModTags.Items.AUTO_SMELT_TOOLS)).build()
                }));

        add("ghast_ore_loot", new NetherrocksLootModifiers.GhastOreLootModifier(
                new LootItemCondition[] {
                        LootItemBlockStatePropertyCondition.hasBlockStateProperties(ModBlocks.ashstone_ore.get()).build(),
                        AnyOfCondition.anyOf(
                                        LocationCheck.checkLocation(
                                                LocationPredicate.Builder.location().setBlock(
                                                        BlockPredicate.Builder.block().of(Blocks.LAVA)),
                                                new BlockPos(1,0,0))                                )
                                .or(
                                        LocationCheck.checkLocation(
                                                LocationPredicate.Builder.location().setBlock(
                                                        BlockPredicate.Builder.block().of(Blocks.LAVA)),
                                                new BlockPos(-1,0,0))
                                )
                                .or(
                                        LocationCheck.checkLocation(
                                                LocationPredicate.Builder.location().setBlock(
                                                        BlockPredicate.Builder.block().of(Blocks.LAVA)),
                                                new BlockPos(0,0,1))
                                )
                                .or(
                                        LocationCheck.checkLocation(
                                                LocationPredicate.Builder.location().setBlock(
                                                        BlockPredicate.Builder.block().of(Blocks.LAVA)),
                                                new BlockPos(0,0,-1))
                                )
                                .or(
                                        LocationCheck.checkLocation(
                                                LocationPredicate.Builder.location().setBlock(
                                                        BlockPredicate.Builder.block().of(Blocks.LAVA)),
                                                new BlockPos(0,1,0))
                                )
                                .or(
                                        LocationCheck.checkLocation(
                                                LocationPredicate.Builder.location().setBlock(
                                                        BlockPredicate.Builder.block().of(Blocks.LAVA)),
                                                new BlockPos(0,-1,0))
                                )
                                .build()
                }));

    }
} // end class
