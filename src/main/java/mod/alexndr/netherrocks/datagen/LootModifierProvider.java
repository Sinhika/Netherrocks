package mod.alexndr.netherrocks.datagen;

import mod.alexndr.netherrocks.Netherrocks;
import mod.alexndr.netherrocks.helpers.NetherrocksLootModifiers;
import mod.alexndr.netherrocks.init.ModBlocks;
import mod.alexndr.netherrocks.init.ModTags;
import net.minecraft.advancements.critereon.FluidPredicate;
import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.advancements.critereon.LocationPredicate;
import net.minecraft.core.BlockPos;
import net.minecraft.data.DataGenerator;
import net.minecraft.tags.FluidTags;
import net.minecraft.world.level.storage.loot.predicates.AlternativeLootItemCondition;
import net.minecraft.world.level.storage.loot.predicates.LocationCheck;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.predicates.MatchTool;
import net.minecraftforge.common.data.GlobalLootModifierProvider;

public class LootModifierProvider extends GlobalLootModifierProvider
{

    public LootModifierProvider(DataGenerator gen)
    {
        super(gen, Netherrocks.MODID);
    }

    @Override
    protected void start()
    {
        add("auto_smelt_tool", new NetherrocksLootModifiers.AutoSmeltLootModifier( 
                new LootItemCondition[] {
                        MatchTool.toolMatches(ItemPredicate.Builder.item().of(ModTags.Items.AUTO_SMELT_TOOLS)).build()
                }));
        
        add("ghast_ore_loot", new NetherrocksLootModifiers.GhastOreLootModifier(
                new LootItemCondition[] {
                        LootItemBlockStatePropertyCondition.hasBlockStateProperties(ModBlocks.ashstone_ore.get()).build(),
                        AlternativeLootItemCondition.alternative(
                            LocationCheck.checkLocation(
                                    LocationPredicate.Builder.location().setFluid(FluidPredicate.Builder.fluid().of(FluidTags.LAVA).build()), 
                                    new BlockPos(1,0,0))
                        )
                        .or(
                            LocationCheck.checkLocation(
                                LocationPredicate.Builder.location().setFluid(FluidPredicate.Builder.fluid().of(FluidTags.LAVA).build()), 
                                new BlockPos(-1,0,0))
                        )
                        .or(
                            LocationCheck.checkLocation(
                                LocationPredicate.Builder.location().setFluid(FluidPredicate.Builder.fluid().of(FluidTags.LAVA).build()), 
                                new BlockPos(0,0,1))
                        )
                        .or(
                            LocationCheck.checkLocation(
                                LocationPredicate.Builder.location().setFluid(FluidPredicate.Builder.fluid().of(FluidTags.LAVA).build()), 
                                new BlockPos(0,0,-1))
                        )
                        .or(
                            LocationCheck.checkLocation(
                                LocationPredicate.Builder.location().setFluid(FluidPredicate.Builder.fluid().of(FluidTags.LAVA).build()), 
                                new BlockPos(0,1,0))
                        )
                        .or(
                            LocationCheck.checkLocation(
                                LocationPredicate.Builder.location().setFluid(FluidPredicate.Builder.fluid().of(FluidTags.LAVA).build()), 
                                new BlockPos(0,-1,0))
                        )
                        .build()
                }));
    } // end start()

} // end class
