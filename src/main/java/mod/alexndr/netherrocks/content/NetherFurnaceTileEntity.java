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

import java.util.Map;

public class NetherFurnaceTileEntity extends AbstractFurnaceTileEntity
{
    protected static final int netherrackBurnTime = 200;
    protected static final int fyriteBurnTime = 8000;
    protected static final int blazeRodBurnTime = 2400;

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
    protected int getBurnTime(ItemStack fuelStack)
    {
        if (fuelStack.isEmpty()) { return 0; }
        Item fuelItem = fuelStack.getItem();
        return NetherFurnaceTileEntity.getBurnTimes().getOrDefault(fuelItem, 0);
    }

    public static Map<Item, Integer> getBurnTimes()
    {
        Map<Item, Integer> map = Maps.newLinkedHashMap();
        addItemBurnTime(map, Blocks.NETHERRACK, netherrackBurnTime);
        addItemBurnTime(map, ModBlocks.fyrite_block, fyriteBurnTime * 10);
        addItemBurnTime(map, ModItems.fyrite_ingot, fyriteBurnTime);
        addItemBurnTime(map, ModItems.fyrite_nugget, fyriteBurnTime/9);
        addItemBurnTime(map, Items.BLAZE_ROD, blazeRodBurnTime);
        addItemBurnTime(map, Items.BLAZE_POWDER, blazeRodBurnTime/3);
        addItemTagBurnTime(map, ModTags.getFyriteTools(), fyriteBurnTime/3);
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

    @Override
    protected Container createMenu(int id, PlayerInventory player)
    {
        return null;
    }
}  // end class NetherFurnaceTileEntity
