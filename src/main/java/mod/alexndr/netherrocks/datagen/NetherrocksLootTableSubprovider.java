package mod.alexndr.netherrocks.datagen;

import mod.alexndr.netherrocks.init.ModBlocks;
import mod.alexndr.netherrocks.init.ModItems;
import mod.alexndr.simplecorelib.api.datagen.SimpleBlockLootSubProvider;

public class NetherrocksLootTableSubprovider extends SimpleBlockLootSubProvider
{

     @Override
    protected void generate() 
    {
        dropSelf(ModBlocks.argonite_block.get());
        dropSelf(ModBlocks.raw_argonite_block.get());
        dropSelf(ModBlocks.argonite_bricks.get());
        dropSelf(ModBlocks.argonite_brick_stairs.get());
        dropSlab(ModBlocks.argonite_brick_slab.get());
        dropSelf(ModBlocks.argonite_bars.get());
        doorDropTable(ModBlocks.argonite_door.get());
        dropMultiItemsWithFortune(ModBlocks.argonite_ore.get(), ModItems.raw_argonite.get(), 1, 1);

        dropSelf(ModBlocks.ashstone_block.get());
        dropSelf(ModBlocks.ashstone_bricks.get());
        dropSelf(ModBlocks.ashstone_brick_stairs.get());
        dropSlab(ModBlocks.ashstone_brick_slab.get());
        dropSelf(ModBlocks.ashstone_bars.get());
        doorDropTable(ModBlocks.ashstone_door.get());
        dropMultiItemsWithFortune(ModBlocks.ashstone_ore.get(), ModItems.ashstone_gem.get(), 1, 1);

        dropSelf(ModBlocks.dragonstone_block.get());
        dropSelf(ModBlocks.dragonstone_bricks.get());
        dropSelf(ModBlocks.dragonstone_brick_stairs.get());
        dropSlab(ModBlocks.dragonstone_brick_slab.get());
        dropSelf(ModBlocks.dragonstone_bars.get());
        doorDropTable(ModBlocks.dragonstone_door.get());
        dropMultiItemsWithFortune(ModBlocks.dragonstone_ore.get(), ModItems.dragonstone_gem.get(), 1,1);

        dropSelf(ModBlocks.fyrite_block.get());
        dropSelf(ModBlocks.raw_fyrite_block.get());
        dropSelf(ModBlocks.fyrite_bricks.get());
        dropSelf(ModBlocks.fyrite_brick_stairs.get());
        dropSlab(ModBlocks.fyrite_brick_slab.get());
        dropSelf(ModBlocks.fyrite_bars.get());
        doorDropTable(ModBlocks.fyrite_door.get());
        dropMultiItemsWithFortune(ModBlocks.fyrite_ore.get(), ModItems.raw_fyrite.get(), 1,1);

        dropSelf(ModBlocks.illumenite_block.get());
        dropSelf(ModBlocks.raw_illumenite_block.get());
        dropSelf(ModBlocks.illumenite_bricks.get());
        dropSelf(ModBlocks.illumenite_brick_stairs.get());
        dropSlab(ModBlocks.illumenite_brick_slab.get());
        dropSelf(ModBlocks.illumenite_bars.get());
        doorDropTable(ModBlocks.illumenite_door.get());
        dropMultiItemsWithFortune(ModBlocks.illumenite_ore.get(), ModItems.raw_illumenite.get(), 1,1 );

        dropSelf(ModBlocks.malachite_block.get());
        dropSelf(ModBlocks.raw_malachite_block.get());
        dropSelf(ModBlocks.malachite_bricks.get());
        dropSelf(ModBlocks.malachite_brick_stairs.get());
        dropSlab(ModBlocks.malachite_brick_slab.get());
        dropSelf(ModBlocks.malachite_bars.get());
        doorDropTable(ModBlocks.malachite_door.get());
        dropMultiItemsWithFortune(ModBlocks.malachite_ore.get(), ModItems.raw_malachite.get(), 1,1);

        dropNameableBlockEntity(ModBlocks.nether_blast_furnace.get());
        dropNameableBlockEntity(ModBlocks.nether_furnace.get());
        dropNameableBlockEntity(ModBlocks.nether_smoker.get());

        // pressure plates
        dropSelf(ModBlocks.argonite_pressure_plate.get());
        dropSelf(ModBlocks.ashstone_pressure_plate.get());
        dropSelf(ModBlocks.dragonstone_pressure_plate.get());
        dropSelf(ModBlocks.fyrite_pressure_plate.get());
        dropSelf(ModBlocks.illumenite_pressure_plate.get());
        dropSelf(ModBlocks.malachite_pressure_plate.get());

    } // end getTables()

 
} // end class
