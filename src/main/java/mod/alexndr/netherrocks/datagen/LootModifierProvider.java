package mod.alexndr.netherrocks.datagen;

import mod.alexndr.netherrocks.Netherrocks;
import mod.alexndr.netherrocks.helpers.NetherrocksLootModifiers;
import mod.alexndr.netherrocks.init.ModBlocks;
import mod.alexndr.netherrocks.init.ModTags;
import net.minecraft.advancements.critereon.FluidPredicate;
import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.advancements.critereon.LocationPredicate;
import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.HolderSet;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.FluidTags;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.storage.loot.predicates.*;
import net.neoforged.neoforge.common.data.GlobalLootModifierProvider;

import java.util.concurrent.CompletableFuture;

public class LootModifierProvider extends GlobalLootModifierProvider
{

    public LootModifierProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries)
    {
        super(output, registries, Netherrocks.MODID);
    }

    @Override
    protected void start()
    {
        HolderSet<Fluid> LavaSet = BuiltInRegistries.FLUID.getTag(FluidTags.LAVA).orElseThrow();

        add("auto_smelt_tool", new NetherrocksLootModifiers.AutoSmeltLootModifier( 
                new LootItemCondition[] {
                        MatchTool.toolMatches(ItemPredicate.Builder.item().of(ModTags.Items.AUTO_SMELT_TOOLS)).build()
                }));
        
        add("ghast_ore_loot", new NetherrocksLootModifiers.GhastOreLootModifier(
                new LootItemCondition[] {
                        LootItemBlockStatePropertyCondition.hasBlockStateProperties(ModBlocks.ashstone_ore.get()).build(),
                        AnyOfCondition.anyOf(
                            LocationCheck.checkLocation(
                                    LocationPredicate.Builder.location().setFluid(
                                            FluidPredicate.Builder.fluid().of(LavaSet)),
                                    new BlockPos(1,0,0))
                        )
                        .or(
                            LocationCheck.checkLocation(
                                LocationPredicate.Builder.location().setFluid(
                                        FluidPredicate.Builder.fluid().of(LavaSet)),
                                new BlockPos(-1,0,0))
                        )
                        .or(
                            LocationCheck.checkLocation(
                                LocationPredicate.Builder.location().setFluid(FluidPredicate.Builder.fluid().of(LavaSet)),
                                new BlockPos(0,0,1))
                        )
                        .or(
                            LocationCheck.checkLocation(
                                LocationPredicate.Builder.location().setFluid(FluidPredicate.Builder.fluid().of(LavaSet)),
                                new BlockPos(0,0,-1))
                        )
                        .or(
                            LocationCheck.checkLocation(
                                LocationPredicate.Builder.location().setFluid(FluidPredicate.Builder.fluid().of(LavaSet)),
                                new BlockPos(0,1,0))
                        )
                        .or(
                            LocationCheck.checkLocation(
                                LocationPredicate.Builder.location().setFluid(FluidPredicate.Builder.fluid().of(LavaSet)),
                                new BlockPos(0,-1,0))
                        )
                        .build()
                }));
    } // end start()

} // end class
