package mod.alexndr.netherrocks.helpers;

import com.google.common.collect.Maps;
import com.mojang.datafixers.util.Either;
import mod.alexndr.netherrocks.config.NetherrocksConfig;
import mod.alexndr.netherrocks.init.ModBlocks;
import mod.alexndr.netherrocks.init.ModItems;
import net.minecraft.SharedConstants;
import net.minecraft.Util;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Blocks;

import javax.annotation.Nullable;
import java.util.Map;
import java.util.function.ObjIntConsumer;

public class NetherFurnaceFuelHandler
{
    protected static int netherrackBurnTime = 0;
    protected static int fyriteBurnTime = 0;
    protected static int blazeRodBurnTime = 0;
    protected static int baseToolBurnTime = 0;
    
//    protected static Map<Item, Integer> validFuels = Maps.newLinkedHashMap();

    @Nullable private static volatile Map<Item, Integer> fuelCache;

    public static void invalidateCache() {
        fuelCache = null;
    }

    public static Map<Item, Integer> getFuel()
    {
        Map<Item, Integer> map = fuelCache;
        if (map != null) {
            return map;
        }
        else {
            Map<Item, Integer> map1 = Maps.newLinkedHashMap();
            buildFuels((e, time) -> e.ifRight(tag -> add(map1, tag, time)).ifLeft(item -> add(map1, item, time)));
            fuelCache = map1;
            return map1;
        }
    }

    private static void add(ObjIntConsumer<Either<Item, TagKey<Item>>> consumer,
                            ItemLike item, int time)
    {
        consumer.accept(com.mojang.datafixers.util.Either.left(item.asItem()), time);
    }

    private static void add(ObjIntConsumer<Either<Item, TagKey<Item>>> consumer,
                            TagKey<Item> tag, int time)
    {
        consumer.accept(com.mojang.datafixers.util.Either.right(tag), time);
    }

    private static boolean isNeverAFurnaceFuel(Item pItem) {
        return pItem.builtInRegistryHolder().is(ItemTags.NON_FLAMMABLE_WOOD);
    }

    private static void add(Map<Item, Integer> pMap, TagKey<Item> pItemTag, int pBurnTime) {
        for (Holder<Item> holder : BuiltInRegistries.ITEM.getTagOrEmpty(pItemTag)) {
            if (!isNeverAFurnaceFuel(holder.value())) {
                pMap.put(holder.value(), pBurnTime);
            }
        }
    }

    private static void add(Map<Item, Integer> pMap, ItemLike pItem, int pBurnTime) {
        Item item = pItem.asItem();
        if (isNeverAFurnaceFuel(item)) {
            if (SharedConstants.IS_RUNNING_IN_IDE) {
                throw (IllegalStateException) Util.pauseInIde(
                        new IllegalStateException(
                                "A developer tried to explicitly make fire resistant item " + item.getName(null).getString() + " a furnace fuel. That will not work!"
                        )
                );
            }
        } else {
            pMap.put(item, pBurnTime);
        }
    }

    public static void buildFuels(ObjIntConsumer<Either<Item, TagKey<Item>>> map1)
    {
        netherrackBurnTime = NetherrocksConfig.serverNetherrackBurnTime.get();
        fyriteBurnTime = NetherrocksConfig.serverFyriteBurnTime.get();
        blazeRodBurnTime = NetherrocksConfig.serverBlazeRodBurnTime.get();
        baseToolBurnTime = NetherrocksConfig.serverBaseToolBurnTime.get();
        
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
