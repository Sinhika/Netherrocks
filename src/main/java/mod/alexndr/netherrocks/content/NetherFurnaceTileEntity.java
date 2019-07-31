package mod.alexndr.netherrocks.content;

import com.google.common.collect.Maps;
import mod.alexndr.netherrocks.init.ModBlocks;
import mod.alexndr.netherrocks.init.ModItems;
import mod.alexndr.netherrocks.init.ModTags;
import mod.alexndr.netherrocks.init.ModTiles;
import net.minecraft.block.Blocks;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.IRecipeType;
import net.minecraft.tags.Tag;
import net.minecraft.tileentity.AbstractFurnaceTileEntity;
import net.minecraft.util.IItemProvider;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class NetherFurnaceTileEntity extends AbstractFurnaceTileEntity
{
    protected static final int netherrackBurnTime = 200;
    protected static final int fyriteBurnTime = 8000;
    protected static final int blazeRodBurnTime = 2400;
    protected static final List<Item> validFuels = new ArrayList<Item>();

    public NetherFurnaceTileEntity()
    {
        super(ModTiles.NETHER_FURNACE, IRecipeType.SMELTING);
    }

    @Override
    protected ITextComponent getDefaultName()
    {
        return new TranslationTextComponent("container.nether_furnace");
    }

    @Override
    public boolean isItemValidForSlot(int index, ItemStack stack)
    {
        if (index == 2) {
            return false;
        }
        else if (index != 1) {
            return true;
        }
        else {
            return NetherFurnaceTileEntity.isFuel(stack);
        }
    } // end ()

    public static boolean isFuel(ItemStack stack)
    {
        return getValidFuels().contains(stack.getItem());
    }


    @Override
    protected int getBurnTime(ItemStack fuelStack)
    {
        if (fuelStack.isEmpty()) { return 0; }
        Item fuelItem = fuelStack.getItem();

        if (getValidFuels().contains(fuelItem))
        {
            return NetherFurnaceTileEntity.getBurnTimes().getOrDefault(fuelItem, 0);
        }
        else {
            return 0;
        }
    } // end getBurnTime()

    /**
     * Get the list of valid fuels, or create it if it is empty.
     * @return a list of valid fuel items
     */
    public static List<Item> getValidFuels()
    {
        if (validFuels.isEmpty())
        {
            validFuels.add(Blocks.NETHERRACK.asItem());
            validFuels.add(ModBlocks.fyrite_block.asItem());
            validFuels.add(ModItems.fyrite_ingot);
            validFuels.add(ModItems.fyrite_nugget);
            validFuels.add(Items.BLAZE_ROD);
            validFuels.add(Items.BLAZE_POWDER);
            for (Item item : ModTags.getnetherFurnaceFuels().getAllElements())
            {
                validFuels.add(item);
            }
//            validFuels.add(ModItems.fyrite_axe);
//            validFuels.add(ModItems.fyrite_pickaxe);
//            validFuels.add(ModItems.fyrite_shovel);
//            validFuels.add(ModItems.fyrite_sword);
        }
        return validFuels;
    } // end getValidFuels()

    public static Map<Item, Integer> getBurnTimes()
    {
        Map<Item, Integer> map = Maps.newLinkedHashMap();
        addItemBurnTime(map, Blocks.NETHERRACK, netherrackBurnTime);
        addItemBurnTime(map, ModBlocks.fyrite_block, fyriteBurnTime * 10);
        addItemBurnTime(map, ModItems.fyrite_ingot, fyriteBurnTime);
        addItemBurnTime(map, ModItems.fyrite_nugget, fyriteBurnTime/9);
        addItemBurnTime(map, Items.BLAZE_ROD, blazeRodBurnTime);
        addItemBurnTime(map, Items.BLAZE_POWDER, blazeRodBurnTime/3);
        addItemTagBurnTime(map, ModTags.getnetherFurnaceFuels(), fyriteBurnTime / 3);
        return map;
    } // end getBurnTimes()

    protected static void addItemBurnTime(Map<Item, Integer> map,
                                   IItemProvider itemProvider, int burnTimeIn)
    {
        map.put(itemProvider.asItem(), burnTimeIn);
    }

    protected static void addItemTagBurnTime(Map<Item, Integer> map, Tag<Item> itemTag, int burnTimeIn)
    {
        for(Item item : itemTag.getAllElements()) {
            map.put(item, burnTimeIn);
        }
    } // end ()

    @Nullable
    @Override
    protected Container createMenu(int id, PlayerInventory player)
    {
        return new NetherFurnaceContainer(id, player);
    }
}  // end class NetherFurnaceTileEntity
