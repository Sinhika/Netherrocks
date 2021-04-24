package mod.alexndr.netherrocks.datagen;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Supplier;

import com.mojang.datafixers.util.Pair;

import mod.alexndr.netherrocks.Netherrocks;
import mod.alexndr.netherrocks.init.ModItems;
import mod.alexndr.simplecorelib.datagen.LootTableInjectorProvider;
import net.minecraft.data.DataGenerator;
import net.minecraft.loot.ItemLootEntry;
import net.minecraft.loot.LootParameterSet;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTable.Builder;
import net.minecraft.loot.RandomValueRange;
import net.minecraft.loot.functions.SetCount;
import net.minecraft.util.ResourceLocation;

public class NetherrocksLootInjectorProvider extends LootTableInjectorProvider
{

    public NetherrocksLootInjectorProvider(DataGenerator dataGeneratorIn)
    {
        super(dataGeneratorIn);
    }

    @Override
    protected List<Pair<Supplier<Consumer<BiConsumer<ResourceLocation, Builder>>>, LootParameterSet>> getTables()
    {
        tables.clear();
        // desert pyramid
        LootPool.Builder foo = createChestPool(1, 1, 0.25F)
                .add(ItemLootEntry.lootTableItem(ModItems.fyrite_ingot.get()).setWeight(10)
                    .apply(SetCount.setCount(RandomValueRange.between(1, 2))))
                .add(ItemLootEntry.lootTableItem(ModItems.illumenite_ingot.get()).setWeight(5)
                        .apply(SetCount.setCount(RandomValueRange.between(1, 2))))
                .add(ItemLootEntry.lootTableItem(ModItems.dragonstone_gem.get()).setWeight(1)
                        .apply(SetCount.setCount(RandomValueRange.between(1, 1))));
        addInjectionTable(Netherrocks.MODID, "desert_pyramid", foo);

        // ruined_portal
        foo = createChestPool(1, 1, 0.50F)
                .add(ItemLootEntry.lootTableItem(ModItems.malachite_ingot.get()).setWeight(10)
                        .apply(SetCount.setCount(RandomValueRange.between(2, 4))))
                .add(ItemLootEntry.lootTableItem(ModItems.argonite_ingot.get()).setWeight(8)
                        .apply(SetCount.setCount(RandomValueRange.between(1, 3))))
                .add(ItemLootEntry.lootTableItem(ModItems.fyrite_ingot.get()).setWeight(10)
                        .apply(SetCount.setCount(RandomValueRange.between(1, 2))))
                .add(ItemLootEntry.lootTableItem(ModItems.illumenite_ingot.get()).setWeight(5)
                            .apply(SetCount.setCount(RandomValueRange.between(1, 2))))
                .add(ItemLootEntry.lootTableItem(ModItems.ashstone_gem.get()).setWeight(1)
                        .apply(SetCount.setCount(RandomValueRange.between(1, 2))))
                .add(ItemLootEntry.lootTableItem(ModItems.dragonstone_gem.get()).setWeight(1)
                            .apply(SetCount.setCount(RandomValueRange.between(1, 1))));
        addInjectionTable(Netherrocks.MODID, "ruined_portal", foo);
        
        // bastion
        foo = createChestPool(1, 2, 0.75F)
                .add(ItemLootEntry.lootTableItem(ModItems.malachite_helmet.get()).setWeight(3))
                .add(ItemLootEntry.lootTableItem(ModItems.malachite_chestplate.get()).setWeight(3))
                .add(ItemLootEntry.lootTableItem(ModItems.malachite_leggings.get()).setWeight(3))
                .add(ItemLootEntry.lootTableItem(ModItems.malachite_boots.get()).setWeight(3))
                .add(ItemLootEntry.lootTableItem(ModItems.malachite_sword.get()).setWeight(3))
                .add(ItemLootEntry.lootTableItem(ModItems.malachite_axe.get()).setWeight(3))
                .add(ItemLootEntry.lootTableItem(ModItems.malachite_pickaxe.get()).setWeight(3))
                .add(ItemLootEntry.lootTableItem(ModItems.malachite_shovel.get()).setWeight(3))
                .add(ItemLootEntry.lootTableItem(ModItems.argonite_sword.get()).setWeight(2))
                .add(ItemLootEntry.lootTableItem(ModItems.argonite_axe.get()).setWeight(2))
                .add(ItemLootEntry.lootTableItem(ModItems.argonite_pickaxe.get()).setWeight(2))
                .add(ItemLootEntry.lootTableItem(ModItems.argonite_shovel.get()).setWeight(2))
                .add(ItemLootEntry.lootTableItem(ModItems.ashstone_sword.get()).setWeight(1))
                .add(ItemLootEntry.lootTableItem(ModItems.ashstone_axe.get()).setWeight(1))
                .add(ItemLootEntry.lootTableItem(ModItems.ashstone_pickaxe.get()).setWeight(1))
                .add(ItemLootEntry.lootTableItem(ModItems.ashstone_shovel.get()).setWeight(1))
                .add(ItemLootEntry.lootTableItem(ModItems.fyrite_helmet.get()).setWeight(2))
                .add(ItemLootEntry.lootTableItem(ModItems.fyrite_chestplate.get()).setWeight(2))
                .add(ItemLootEntry.lootTableItem(ModItems.fyrite_leggings.get()).setWeight(2))
                .add(ItemLootEntry.lootTableItem(ModItems.fyrite_boots.get()).setWeight(2))
                .add(ItemLootEntry.lootTableItem(ModItems.fyrite_sword.get()).setWeight(2))
                .add(ItemLootEntry.lootTableItem(ModItems.fyrite_pickaxe.get()).setWeight(2))
                .add(ItemLootEntry.lootTableItem(ModItems.fyrite_shovel.get()).setWeight(2))
                .add(ItemLootEntry.lootTableItem(ModItems.illumenite_helmet.get()).setWeight(2))
                .add(ItemLootEntry.lootTableItem(ModItems.illumenite_chestplate.get()).setWeight(2))
                .add(ItemLootEntry.lootTableItem(ModItems.illumenite_leggings.get()).setWeight(2))
                .add(ItemLootEntry.lootTableItem(ModItems.illumenite_boots.get()).setWeight(2))
                .add(ItemLootEntry.lootTableItem(ModItems.illumenite_sword.get()).setWeight(2))
                .add(ItemLootEntry.lootTableItem(ModItems.dragonstone_helmet.get()).setWeight(1))
                .add(ItemLootEntry.lootTableItem(ModItems.dragonstone_chestplate.get()).setWeight(1))
                .add(ItemLootEntry.lootTableItem(ModItems.dragonstone_leggings.get()).setWeight(1))
                .add(ItemLootEntry.lootTableItem(ModItems.dragonstone_boots.get()).setWeight(1))
                .add(ItemLootEntry.lootTableItem(ModItems.dragonstone_sword.get()).setWeight(1))
                .add(ItemLootEntry.lootTableItem(ModItems.dragonstone_axe.get()).setWeight(1))
                .add(ItemLootEntry.lootTableItem(ModItems.dragonstone_pickaxe.get()).setWeight(1))
                .add(ItemLootEntry.lootTableItem(ModItems.dragonstone_shovel.get()).setWeight(1))
                .add(ItemLootEntry.lootTableItem(ModItems.malachite_ingot.get()).setWeight(2)
                        .apply(SetCount.setCount(RandomValueRange.between(2, 4))))
                .add(ItemLootEntry.lootTableItem(ModItems.argonite_ingot.get()).setWeight(2)
                        .apply(SetCount.setCount(RandomValueRange.between(1, 3))))
                .add(ItemLootEntry.lootTableItem(ModItems.fyrite_ingot.get()).setWeight(2)
                        .apply(SetCount.setCount(RandomValueRange.between(1, 2))))
                .add(ItemLootEntry.lootTableItem(ModItems.illumenite_ingot.get()).setWeight(1)
                            .apply(SetCount.setCount(RandomValueRange.between(1, 2))))
                .add(ItemLootEntry.lootTableItem(ModItems.ashstone_gem.get()).setWeight(1)
                        .apply(SetCount.setCount(RandomValueRange.between(1, 2))))
                .add(ItemLootEntry.lootTableItem(ModItems.dragonstone_gem.get()).setWeight(1)
                            .apply(SetCount.setCount(RandomValueRange.between(1, 1))));
        addInjectionTable(Netherrocks.MODID, "bastion", foo);

        // jungle_temple
        foo = createChestPool(1, 1, 0.25F)
                .add(ItemLootEntry.lootTableItem(ModItems.malachite_ingot.get()).setWeight(10)
                    .apply(SetCount.setCount(RandomValueRange.between(2, 4))))
                .add(ItemLootEntry.lootTableItem(ModItems.ashstone_gem.get()).setWeight(1)
                        .apply(SetCount.setCount(RandomValueRange.between(1, 2))));
        addInjectionTable(Netherrocks.MODID, "jungle_temple", foo);

        // stronghold
        foo = createChestPool(1, 1, 0.25F)
                .add(ItemLootEntry.lootTableItem(ModItems.malachite_helmet.get()).setWeight(1))
                .add(ItemLootEntry.lootTableItem(ModItems.malachite_chestplate.get()).setWeight(1))
                .add(ItemLootEntry.lootTableItem(ModItems.malachite_leggings.get()).setWeight(1))
                .add(ItemLootEntry.lootTableItem(ModItems.malachite_boots.get()).setWeight(1))
                .add(ItemLootEntry.lootTableItem(ModItems.malachite_sword.get()).setWeight(1))
                .add(ItemLootEntry.lootTableItem(ModItems.malachite_axe.get()).setWeight(1))
                .add(ItemLootEntry.lootTableItem(ModItems.malachite_pickaxe.get()).setWeight(1))
                .add(ItemLootEntry.lootTableItem(ModItems.malachite_ingot.get()).setWeight(10)
                        .apply(SetCount.setCount(RandomValueRange.between(2, 4))))
                .add(ItemLootEntry.lootTableItem(ModItems.argonite_ingot.get()).setWeight(3)
                        .apply(SetCount.setCount(RandomValueRange.between(1, 3))))
                .add(ItemLootEntry.lootTableItem(ModItems.fyrite_ingot.get()).setWeight(5)
                        .apply(SetCount.setCount(RandomValueRange.between(1, 2))))
                .add(ItemLootEntry.lootTableItem(ModItems.illumenite_ingot.get()).setWeight(1)
                            .apply(SetCount.setCount(RandomValueRange.between(1, 2))));
        addInjectionTable(Netherrocks.MODID, "stronghold", foo);
               
        return tables;
    } // end getTables()

} // end class
