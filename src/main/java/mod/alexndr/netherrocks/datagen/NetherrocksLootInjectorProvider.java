package mod.alexndr.netherrocks.datagen;

import mod.alexndr.netherrocks.Netherrocks;
import mod.alexndr.netherrocks.init.ModItems;
import mod.alexndr.simplecorelib.api.datagen.SimpleLootInjectorSubProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import org.jetbrains.annotations.NotNull;

import java.util.function.BiConsumer;

public class NetherrocksLootInjectorProvider extends SimpleLootInjectorSubProvider
{
    public static final ResourceKey<LootTable> BASTION =
            getInjectionTableId(Netherrocks.MODID, "bastion");
    public static final ResourceKey<LootTable> DESERT_PYRAMID =
            getInjectionTableId(Netherrocks.MODID, "desert_pyramid");
    public static final ResourceKey<LootTable> JUNGLE_TEMPLE =
            getInjectionTableId(Netherrocks.MODID, "jungle_temple");
    public static final ResourceKey<LootTable> RUINED_PORTAL =
            getInjectionTableId(Netherrocks.MODID, "ruined_portal");
    public static final ResourceKey<LootTable> STRONGHOLD =
            getInjectionTableId(Netherrocks.MODID, "stronghold");

    @Override
    public void generate(@NotNull HolderLookup.Provider pRegistries,
                         BiConsumer<ResourceKey<LootTable>, LootTable.Builder> pGenerator)
    {
        // bastion
        pGenerator.accept(BASTION, LootTable.lootTable().withPool(
                createChestPool("bastion", 1, 2, 0.75F)
                        .add(LootItem.lootTableItem(ModItems.malachite_helmet.get()).setWeight(3))
                        .add(LootItem.lootTableItem(ModItems.malachite_chestplate.get()).setWeight(3))
                        .add(LootItem.lootTableItem(ModItems.malachite_leggings.get()).setWeight(3))
                        .add(LootItem.lootTableItem(ModItems.malachite_boots.get()).setWeight(3))
                        .add(LootItem.lootTableItem(ModItems.malachite_sword.get()).setWeight(3))
                        .add(LootItem.lootTableItem(ModItems.malachite_axe.get()).setWeight(3))
                        .add(LootItem.lootTableItem(ModItems.malachite_pickaxe.get()).setWeight(3))
                        .add(LootItem.lootTableItem(ModItems.malachite_shovel.get()).setWeight(3))
                        .add(LootItem.lootTableItem(ModItems.argonite_sword.get()).setWeight(2))
                        .add(LootItem.lootTableItem(ModItems.argonite_axe.get()).setWeight(2))
                        .add(LootItem.lootTableItem(ModItems.argonite_pickaxe.get()).setWeight(2))
                        .add(LootItem.lootTableItem(ModItems.argonite_shovel.get()).setWeight(2))
                        .add(LootItem.lootTableItem(ModItems.ashstone_sword.get()).setWeight(1))
                        .add(LootItem.lootTableItem(ModItems.ashstone_axe.get()).setWeight(1))
                        .add(LootItem.lootTableItem(ModItems.ashstone_pickaxe.get()).setWeight(1))
                        .add(LootItem.lootTableItem(ModItems.ashstone_shovel.get()).setWeight(1))
                        .add(LootItem.lootTableItem(ModItems.fyrite_helmet.get()).setWeight(2))
                        .add(LootItem.lootTableItem(ModItems.fyrite_chestplate.get()).setWeight(2))
                        .add(LootItem.lootTableItem(ModItems.fyrite_leggings.get()).setWeight(2))
                        .add(LootItem.lootTableItem(ModItems.fyrite_boots.get()).setWeight(2))
                        .add(LootItem.lootTableItem(ModItems.fyrite_sword.get()).setWeight(2))
                        .add(LootItem.lootTableItem(ModItems.fyrite_pickaxe.get()).setWeight(2))
                        .add(LootItem.lootTableItem(ModItems.fyrite_shovel.get()).setWeight(2))
                        .add(LootItem.lootTableItem(ModItems.illumenite_helmet.get()).setWeight(2))
                        .add(LootItem.lootTableItem(ModItems.illumenite_chestplate.get()).setWeight(2))
                        .add(LootItem.lootTableItem(ModItems.illumenite_leggings.get()).setWeight(2))
                        .add(LootItem.lootTableItem(ModItems.illumenite_boots.get()).setWeight(2))
                        .add(LootItem.lootTableItem(ModItems.illumenite_sword.get()).setWeight(2))
                        .add(LootItem.lootTableItem(ModItems.dragonstone_helmet.get()).setWeight(1))
                        .add(LootItem.lootTableItem(ModItems.dragonstone_chestplate.get()).setWeight(1))
                        .add(LootItem.lootTableItem(ModItems.dragonstone_leggings.get()).setWeight(1))
                        .add(LootItem.lootTableItem(ModItems.dragonstone_boots.get()).setWeight(1))
                        .add(LootItem.lootTableItem(ModItems.dragonstone_sword.get()).setWeight(1))
                        .add(LootItem.lootTableItem(ModItems.dragonstone_axe.get()).setWeight(1))
                        .add(LootItem.lootTableItem(ModItems.dragonstone_pickaxe.get()).setWeight(1))
                        .add(LootItem.lootTableItem(ModItems.dragonstone_shovel.get()).setWeight(1))
                        .add(LootItem.lootTableItem(ModItems.malachite_ingot.get()).setWeight(2)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(2, 4))))
                        .add(LootItem.lootTableItem(ModItems.argonite_ingot.get()).setWeight(2)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 3))))
                        .add(LootItem.lootTableItem(ModItems.fyrite_ingot.get()).setWeight(2)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 2))))
                        .add(LootItem.lootTableItem(ModItems.illumenite_ingot.get()).setWeight(1)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 2))))
                        .add(LootItem.lootTableItem(ModItems.ashstone_gem.get()).setWeight(1)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 2))))
                        .add(LootItem.lootTableItem(ModItems.dragonstone_gem.get()).setWeight(1)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 1))))));

        // desert pyramid
        pGenerator.accept(DESERT_PYRAMID, LootTable.lootTable().withPool(
                createChestPool("desert_pyramid", 1, 1, 0.25F)
                .add(LootItem.lootTableItem(ModItems.fyrite_ingot.get()).setWeight(10)
                    .apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 2))))
                .add(LootItem.lootTableItem(ModItems.illumenite_ingot.get()).setWeight(5)
                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 2))))
                .add(LootItem.lootTableItem(ModItems.dragonstone_gem.get()).setWeight(1)
                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 1))))));

        // jungle_temple
        pGenerator.accept(JUNGLE_TEMPLE, LootTable.lootTable().withPool(
                createChestPool("jungle_temple", 1, 1, 0.25F)
                        .add(LootItem.lootTableItem(ModItems.malachite_ingot.get()).setWeight(10)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(2, 4))))
                        .add(LootItem.lootTableItem(ModItems.ashstone_gem.get()).setWeight(1)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 2))))));

        // ruined_portal
        pGenerator.accept(RUINED_PORTAL, LootTable.lootTable().withPool(
                createChestPool("ruined_portal", 1, 1, 0.50F)
                .add(LootItem.lootTableItem(ModItems.malachite_ingot.get()).setWeight(10)
                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(2, 4))))
                .add(LootItem.lootTableItem(ModItems.argonite_ingot.get()).setWeight(8)
                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 3))))
                .add(LootItem.lootTableItem(ModItems.fyrite_ingot.get()).setWeight(10)
                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 2))))
                .add(LootItem.lootTableItem(ModItems.illumenite_ingot.get()).setWeight(5)
                            .apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 2))))
                .add(LootItem.lootTableItem(ModItems.ashstone_gem.get()).setWeight(1)
                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 2))))
                .add(LootItem.lootTableItem(ModItems.dragonstone_gem.get()).setWeight(1)
                            .apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 1))))));

        // stronghold
        pGenerator.accept(STRONGHOLD, LootTable.lootTable().withPool(
                createChestPool("stronghold", 1, 1, 0.25F)
                .add(LootItem.lootTableItem(ModItems.malachite_helmet.get()).setWeight(1))
                .add(LootItem.lootTableItem(ModItems.malachite_chestplate.get()).setWeight(1))
                .add(LootItem.lootTableItem(ModItems.malachite_leggings.get()).setWeight(1))
                .add(LootItem.lootTableItem(ModItems.malachite_boots.get()).setWeight(1))
                .add(LootItem.lootTableItem(ModItems.malachite_sword.get()).setWeight(1))
                .add(LootItem.lootTableItem(ModItems.malachite_axe.get()).setWeight(1))
                .add(LootItem.lootTableItem(ModItems.malachite_pickaxe.get()).setWeight(1))
                .add(LootItem.lootTableItem(ModItems.malachite_ingot.get()).setWeight(10)
                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(2, 4))))
                .add(LootItem.lootTableItem(ModItems.argonite_ingot.get()).setWeight(3)
                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 3))))
                .add(LootItem.lootTableItem(ModItems.fyrite_ingot.get()).setWeight(5)
                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 2))))
                .add(LootItem.lootTableItem(ModItems.illumenite_ingot.get()).setWeight(1)
                            .apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 2))))));

    } // end generate()

} // end class
