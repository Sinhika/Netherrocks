package mod.alexndr.netherrocks.helpers;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.google.common.collect.Maps;

import mod.alexndr.netherrocks.config.ConfigHolder;
import mod.alexndr.netherrocks.init.ModBlocks;
import mod.alexndr.netherrocks.init.ModItems;
import mod.alexndr.netherrocks.init.ModTags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.neoforge.registries.tags.ITag;

public final class NetherFurnaceFuelHandler
{
    protected static int netherrackBurnTime = 0;
    protected static int fyriteBurnTime = 0;
    protected static int blazeRodBurnTime = 0;
    protected static int baseToolBurnTime = 0;
    
    protected static List<Item> validFuels = new ArrayList<Item>();
    protected static Map<Item, Integer> burnTimes = Maps.newLinkedHashMap();

    
    public static Map<Item, Integer> getBurnTimes()
    {
        if (burnTimes.isEmpty()) 
        {
            burnTimes = loadBurnTimes();
        }
        return burnTimes;
    }

    public static List<Item> getValidfuels()
    {
        if (validFuels.isEmpty()) {
            validFuels.addAll(getBurnTimes().keySet());
        }
        return validFuels;
    }

    public static Map<Item, Integer> loadBurnTimes()
    {
        Map<Item, Integer> map = Maps.newLinkedHashMap();
        netherrackBurnTime = ConfigHolder.SERVER.serverNetherrackBurnTime.get();
        fyriteBurnTime = ConfigHolder.SERVER.serverFyriteBurnTime.get();
        blazeRodBurnTime = ConfigHolder.SERVER.serverBlazeRodBurnTime.get();
        baseToolBurnTime = ConfigHolder.SERVER.serverBaseToolBurnTime.get();
        
        addItemBurnTime(map, Blocks.NETHERRACK, netherrackBurnTime);
        addItemBurnTime(map, ModItems.fyrite_ingot.get(), fyriteBurnTime);
        addItemBurnTime(map, ModBlocks.fyrite_block.get(), fyriteBurnTime * 10);
        addItemBurnTime(map, ModBlocks.fyrite_brick_slab.get(), fyriteBurnTime * 5);
        addItemBurnTime(map, ModBlocks.fyrite_door.get(), fyriteBurnTime * 2);      // 6 ingots / 3 doors = 2
        addItemBurnTime(map, ModItems.fyrite_nugget.get(), fyriteBurnTime/9);
        addItemBurnTime(map, ModBlocks.fyrite_bars.get(), fyriteBurnTime/2);    // 6 ingots / 12 bars = 0.5. dust same.
        addItemBurnTime(map, Items.BLAZE_ROD, blazeRodBurnTime);
        addItemBurnTime(map, Items.BLAZE_POWDER, blazeRodBurnTime/3);
        
        addItemTagBurnTime(map, ModTags.getnetherFurnaceFuels("as_tool"), baseToolBurnTime);
        addItemTagBurnTime(map, ModTags.getnetherFurnaceFuels("as_ingot"), fyriteBurnTime);
        addItemTagBurnTime(map, ModTags.getnetherFurnaceFuels("as_block"), fyriteBurnTime * 10);
        addItemTagBurnTime(map, ModTags.getnetherFurnaceFuels("as_slab"), fyriteBurnTime * 5);
        addItemTagBurnTime(map, ModTags.getnetherFurnaceFuels("as_door"), fyriteBurnTime * 2);
        addItemTagBurnTime(map, ModTags.getnetherFurnaceFuels("as_bars"), fyriteBurnTime/2);
        addItemTagBurnTime(map, ModTags.getnetherFurnaceFuels("as_blaze_rod"), blazeRodBurnTime);
        addItemTagBurnTime(map, ModTags.getnetherFurnaceFuels("as_blaze_powder"), blazeRodBurnTime/3);
     
        return map;
    } // end getBurnTimes()

    protected static void addItemBurnTime(Map<Item, Integer> map,
                                   ItemLike itemProvider, int burnTimeIn)
    {
        map.put(itemProvider.asItem(), burnTimeIn);
    }

    protected static void addItemTagBurnTime(Map<Item, Integer> map, ITag<Item> iTag, int burnTimeIn)
    {
        iTag.stream().forEach(item -> map.put(item, burnTimeIn));
        
    } // end ()


} // end class
