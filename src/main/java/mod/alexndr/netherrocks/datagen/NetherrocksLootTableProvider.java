package mod.alexndr.netherrocks.datagen;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Supplier;

import com.mojang.datafixers.util.Pair;

import mod.alexndr.netherrocks.init.ModBlocks;
import mod.alexndr.netherrocks.init.ModItems;
import mod.alexndr.simplecorelib.api.datagen.BlockLootTableProvider;
import net.minecraft.advancements.critereon.FluidPredicate;
import net.minecraft.advancements.critereon.LocationPredicate;
import net.minecraft.core.BlockPos;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.FluidTags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.LootTable.Builder;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.entries.LootPoolEntryContainer;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSet;
import net.minecraft.world.level.storage.loot.predicates.LocationCheck;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;

public class NetherrocksLootTableProvider extends BlockLootTableProvider
{

    public NetherrocksLootTableProvider(DataGenerator dataGeneratorIn)
    {
        super(dataGeneratorIn);
        // TODO Auto-generated constructor stub
    }

    @Override
    protected List<Pair<Supplier<Consumer<BiConsumer<ResourceLocation, Builder>>>, LootContextParamSet>> getTables()
    {
        tables.clear();
        standardDropTable(ModBlocks.argonite_block.get());
        standardDropTable(ModBlocks.raw_argonite_block.get());
        standardDropTable(ModBlocks.argonite_bricks.get());
        standardDropTable(ModBlocks.argonite_brick_stairs.get());
        slabDropTable(ModBlocks.argonite_brick_slab.get());
        standardDropTable(ModBlocks.argonite_bars.get());
        doorDropTable(ModBlocks.argonite_door.get());
        specialDropTable(ModBlocks.argonite_ore.get(), ModItems.raw_argonite.get());

        standardDropTable(ModBlocks.ashstone_block.get());
        standardDropTable(ModBlocks.ashstone_bricks.get());
        standardDropTable(ModBlocks.ashstone_brick_stairs.get());
        slabDropTable(ModBlocks.ashstone_brick_slab.get());
        standardDropTable(ModBlocks.ashstone_bars.get());
        doorDropTable(ModBlocks.ashstone_door.get());
        specialDropTable(ModBlocks.ashstone_ore.get(), ModItems.ashstone_gem.get());
        ghastOreDropTable();

        standardDropTable(ModBlocks.dragonstone_block.get());
        standardDropTable(ModBlocks.dragonstone_bricks.get());
        standardDropTable(ModBlocks.dragonstone_brick_stairs.get());
        slabDropTable(ModBlocks.dragonstone_brick_slab.get());
        standardDropTable(ModBlocks.dragonstone_bars.get());
        doorDropTable(ModBlocks.dragonstone_door.get());
        specialDropTable(ModBlocks.dragonstone_ore.get(), ModItems.dragonstone_gem.get());

        standardDropTable(ModBlocks.fyrite_block.get());
        standardDropTable(ModBlocks.raw_fyrite_block.get());
        standardDropTable(ModBlocks.fyrite_bricks.get());
        standardDropTable(ModBlocks.fyrite_brick_stairs.get());
        slabDropTable(ModBlocks.fyrite_brick_slab.get());
        standardDropTable(ModBlocks.fyrite_bars.get());
        doorDropTable(ModBlocks.fyrite_door.get());
        specialDropTable(ModBlocks.fyrite_ore.get(), ModItems.raw_fyrite.get());

        standardDropTable(ModBlocks.illumenite_block.get());
        standardDropTable(ModBlocks.raw_illumenite_block.get());
        standardDropTable(ModBlocks.illumenite_bricks.get());
        standardDropTable(ModBlocks.illumenite_brick_stairs.get());
        slabDropTable(ModBlocks.illumenite_brick_slab.get());
        standardDropTable(ModBlocks.illumenite_bars.get());
        doorDropTable(ModBlocks.illumenite_door.get());
        specialDropTable(ModBlocks.illumenite_ore.get(), ModItems.raw_illumenite.get());

        standardDropTable(ModBlocks.malachite_block.get());
        standardDropTable(ModBlocks.raw_malachite_block.get());
        standardDropTable(ModBlocks.malachite_bricks.get());
        standardDropTable(ModBlocks.malachite_brick_stairs.get());
        slabDropTable(ModBlocks.malachite_brick_slab.get());
        standardDropTable(ModBlocks.malachite_bars.get());
        doorDropTable(ModBlocks.malachite_door.get());
        specialDropTable(ModBlocks.malachite_ore.get(), ModItems.raw_malachite.get());

        copyNameDropTable(ModBlocks.nether_blast_furnace.get(), ModBlocks.nether_blast_furnace.get().asItem());
        copyNameDropTable(ModBlocks.nether_furnace.get(), ModBlocks.nether_furnace.get().asItem());
        copyNameDropTable(ModBlocks.nether_smoker.get(), ModBlocks.nether_smoker.get().asItem());

        // pressure plates
        standardDropTable(ModBlocks.argonite_pressure_plate.get());
        standardDropTable(ModBlocks.ashstone_pressure_plate.get());
        standardDropTable(ModBlocks.dragonstone_pressure_plate.get());
        standardDropTable(ModBlocks.fyrite_pressure_plate.get());
        standardDropTable(ModBlocks.illumenite_pressure_plate.get());
        standardDropTable(ModBlocks.malachite_pressure_plate.get());

        return tables;
    } // end getTables()

    protected void ghastOreDropTable()
    {
        blockTable(ModBlocks.ghast_ore.get(), createGhastOreDrops());
    }

    protected static LootItemCondition.Builder create_location_check(BlockPos pos) 
    {
        return LocationCheck.checkLocation(
                LocationPredicate.Builder.location()
                        .setFluid(FluidPredicate.Builder.fluid().of(FluidTags.LAVA).build()),
                pos);
    }
    
    /**
     * Ghast ore drops ghast tears if near lava, otherwise as ashstone.
     * 
     * @return
     */
    protected static LootTable.Builder createGhastOreDrops()
    {
        Item niceItem = Items.GHAST_TEAR;
        Item normalItem = ModItems.ashstone_gem.get();

        LootPoolEntryContainer.Builder<?> builder = LootItem.lootTableItem(niceItem)
                .apply(SetItemCountFunction.setCount(ConstantValue.exactly(1.0F)))
                .when(create_location_check(new BlockPos(1, 0, 0)))
                .otherwise(LootItem.lootTableItem(niceItem).apply(SetItemCountFunction.setCount(ConstantValue.exactly(1.0F)))
                        .when(create_location_check(new BlockPos(-1, 0, 0))))
                .otherwise(LootItem.lootTableItem(niceItem).apply(SetItemCountFunction.setCount(ConstantValue.exactly(1.0F)))
                        .when(create_location_check(new BlockPos(0, 0, 1))))
                .otherwise(LootItem.lootTableItem(niceItem).apply(SetItemCountFunction.setCount(ConstantValue.exactly(1.0F)))
                        .when(create_location_check(new BlockPos(0, 0, -1))))
                .otherwise(LootItem.lootTableItem(normalItem).apply(SetItemCountFunction.setCount(ConstantValue.exactly(1.0F))));
               

         return LootTable.lootTable().withPool(LootPool.lootPool().add(builder));
    } // end createGhastOreDrops()

} // end class
