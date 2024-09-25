package mod.alexndr.netherrocks.datagen;

import com.mojang.datafixers.util.Either;
import mod.alexndr.netherrocks.init.ModBlocks;
import mod.alexndr.netherrocks.init.ModItems;
import mod.alexndr.simplecorelib.api.datagen.SpecialFuelHandler;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Blocks;

import java.util.function.ObjIntConsumer;

public class NetherFurnaceFuelHandler extends SpecialFuelHandler
{
    protected static int netherrackBurnTime = 0;
    protected static int fyriteBurnTime = 0;
    protected static int blazeRodBurnTime = 0;
    protected static int baseToolBurnTime = 0;
    

    public void buildFuels(ObjIntConsumer<Either<Item, TagKey<Item>>> map1)
    {
        netherrackBurnTime = 200;
        fyriteBurnTime = 8000;
        blazeRodBurnTime = 2400;
        baseToolBurnTime = 3200;
        
        add(map1, Blocks.NETHERRACK, netherrackBurnTime);

        add(map1, ModItems.fyrite_ingot.get(), fyriteBurnTime);
        add(map1, ModItems.raw_fyrite.get(), fyriteBurnTime);
        add(map1, ModItems.fyrite_leggings.get(), fyriteBurnTime);
        add(map1, ModItems.fyrite_chestplate.get(), fyriteBurnTime);
        add(map1, ModItems.crushed_fyrite_ore.get(), fyriteBurnTime);

        add(map1, ModBlocks.fyrite_block.get(), fyriteBurnTime * 10);
        add(map1, ModBlocks.raw_fyrite_block.get(), fyriteBurnTime * 10);
        add(map1, ModBlocks.fyrite_bricks.get(), fyriteBurnTime * 10);
        add(map1, ModBlocks.fyrite_brick_stairs.get(), fyriteBurnTime * 10);

        add(map1, ModBlocks.fyrite_brick_slab.get(), fyriteBurnTime * 5);

        add(map1, ModBlocks.fyrite_door.get(), fyriteBurnTime * 2);      // 6 ingots / 3 doors = 2

        add(map1, ModItems.fyrite_nugget.get(), fyriteBurnTime/9);

        add(map1, ModBlocks.fyrite_bars.get(), fyriteBurnTime/2);    // 6 ingots / 12 bars = 0.5. dust same.
        add(map1, ModItems.fyrite_dust.get(), fyriteBurnTime/2);    // 6 ingots / 12 bars = 0.5. dust same.
        add(map1, ModItems.fyrite_helmet.get(), fyriteBurnTime/2);    // 6 ingots / 12 bars = 0.5. dust same.
        add(map1, ModItems.fyrite_boots.get(), fyriteBurnTime/2);    // 6 ingots / 12 bars = 0.5. dust same.

        add(map1, Items.BLAZE_ROD, blazeRodBurnTime);
        add(map1, Items.BLAZE_POWDER, blazeRodBurnTime/3);

        add(map1, ModItems.fyrite_axe.get(), baseToolBurnTime);
        add(map1, ModItems.fyrite_pickaxe.get(), baseToolBurnTime);
        add(map1, ModItems.fyrite_shears.get(), baseToolBurnTime);
        add(map1, ModItems.fyrite_shovel.get(), baseToolBurnTime);
        add(map1, ModItems.fyrite_sword.get(), baseToolBurnTime);
    } // end buildFuels()


} // end class
