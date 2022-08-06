package mod.alexndr.netherrocks.datagen;

import java.util.Map;

import com.google.common.collect.Maps;

import mod.alexndr.netherrocks.Netherrocks;
import mod.alexndr.netherrocks.helpers.NetherrocksLootModifiers;
import mod.alexndr.netherrocks.helpers.NonLootModifiers;
import mod.alexndr.netherrocks.init.ModBlocks;
import mod.alexndr.netherrocks.init.ModItems;
import mod.alexndr.netherrocks.init.ModTags;
import net.minecraft.advancements.critereon.FluidPredicate;
import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.advancements.critereon.LocationPredicate;
import net.minecraft.core.BlockPos;
import net.minecraft.data.DataGenerator;
import net.minecraft.tags.FluidTags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.storage.loot.predicates.AlternativeLootItemCondition;
import net.minecraft.world.level.storage.loot.predicates.LocationCheck;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.predicates.MatchTool;
import net.minecraftforge.common.data.GlobalLootModifierProvider;

public class LootModifierProvider extends GlobalLootModifierProvider
{
    private static Map<Item, Integer> burnTimes = loadBurnTimes();

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
        
        add("nether_fuel_times", new NonLootModifiers.NetherFuelSerializer(new LootItemCondition[] {}, burnTimes));
        
    } // end start()

    private static Map<Item, Integer> loadBurnTimes()
    {
        final int netherrackBurnTime = 200;
        final int fyriteBurnTime = 8000;
        final int blazeRodBurnTime = 2400;
        
        Map<Item, Integer> map = Maps.newLinkedHashMap();
        addItemBurnTime(map, Blocks.NETHERRACK, netherrackBurnTime);
        addItemBurnTime(map, ModBlocks.fyrite_block.get(), fyriteBurnTime * 10);
        addItemBurnTime(map, ModBlocks.raw_fyrite_block.get(), fyriteBurnTime * 10);
        addItemBurnTime(map, ModBlocks.fyrite_bricks.get(), fyriteBurnTime * 10);
        addItemBurnTime(map, ModBlocks.fyrite_brick_stairs.get(), fyriteBurnTime * 10);
        addItemBurnTime(map, ModBlocks.fyrite_brick_slab.get(), fyriteBurnTime * 5);
        addItemBurnTime(map, ModBlocks.fyrite_door.get(), fyriteBurnTime * 5);
        addItemBurnTime(map, ModItems.fyrite_ingot.get(), fyriteBurnTime);
        addItemBurnTime(map, ModItems.raw_fyrite.get(), fyriteBurnTime);
        addItemBurnTime(map, ModItems.fyrite_nugget.get(), fyriteBurnTime/9);
        addItemBurnTime(map, ModItems.fyrite_dust.get(), fyriteBurnTime/2);
        addItemBurnTime(map, Items.BLAZE_ROD, blazeRodBurnTime);
        addItemBurnTime(map, Items.BLAZE_POWDER, blazeRodBurnTime/3);
        return map;
    } // end getBurnTimes()

    private static void addItemBurnTime(Map<Item, Integer> map,
                                   ItemLike itemProvider, int burnTimeIn)
    {
        map.put(itemProvider.asItem(), burnTimeIn);
    }

} // end class
