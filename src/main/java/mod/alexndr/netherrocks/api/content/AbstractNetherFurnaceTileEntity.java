package mod.alexndr.netherrocks.api.content;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import javax.annotation.Nullable;

import com.google.common.collect.Maps;

import mod.alexndr.netherrocks.init.ModBlocks;
import mod.alexndr.netherrocks.init.ModItems;
import mod.alexndr.netherrocks.init.ModTags;
import mod.alexndr.simplecorelib.content.VeryAbstractFurnaceTileEntity;
import net.minecraft.block.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.AbstractCookingRecipe;
import net.minecraft.item.crafting.IRecipeType;
import net.minecraft.tags.ITag;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.IItemProvider;

public abstract class AbstractNetherFurnaceTileEntity extends VeryAbstractFurnaceTileEntity
{
    
    public AbstractNetherFurnaceTileEntity(TileEntityType<?> tileEntityTypeIn,
            IRecipeType<? extends AbstractCookingRecipe> recipeTypeIn)
    {
        super(tileEntityTypeIn, recipeTypeIn);
    }

    @Override
    public boolean isFuel(ItemStack stack)
    {
        return getValidFuels().contains(stack.getItem());
    }

    protected static final int netherrackBurnTime = 200;
    protected static final int fyriteBurnTime = 8000;
    protected static final int blazeRodBurnTime = 2400;
    protected static final List<Item> validFuels = new ArrayList<Item>();
    protected static Map<Item, Integer> burnTimes = new Hashtable<Item, Integer>();

    /**
     * Get the list of valid fuels, or create it if it is empty.
     * @return a list of valid fuel items
     */
    public static List<Item> getValidFuels()
    {
        if (validFuels.isEmpty())
        {
            validFuels.add(Blocks.NETHERRACK.asItem());
            validFuels.add(ModBlocks.fyrite_block.get().asItem());
            validFuels.add(ModItems.fyrite_ingot.get());
            validFuels.add(ModItems.fyrite_nugget.get());
            validFuels.add(ModItems.fyrite_dust.get());
            validFuels.add(Items.BLAZE_ROD);
            validFuels.add(Items.BLAZE_POWDER);
            for (Item item : ModTags.getnetherFurnaceFuels().getValues())
            {
                validFuels.add(item);
            }
        }
        return validFuels;
    } // end getValidFuels()

    public static Map<Item, Integer> loadBurnTimes()
    {
        Map<Item, Integer> map = Maps.newLinkedHashMap();
        addItemBurnTime(map, Blocks.NETHERRACK, netherrackBurnTime);
        addItemBurnTime(map, ModBlocks.fyrite_block.get(), fyriteBurnTime * 10);
        addItemBurnTime(map, ModItems.fyrite_ingot.get(), fyriteBurnTime);
        addItemBurnTime(map, ModItems.fyrite_nugget.get(), fyriteBurnTime/9);
        addItemBurnTime(map, ModItems.fyrite_dust.get(), fyriteBurnTime/2);
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

    protected static void addItemTagBurnTime(Map<Item, Integer> map, ITag<Item> iTag, int burnTimeIn)
    {
        for(Item item : iTag.getValues()) {
            map.put(item, burnTimeIn);
        }
    } // end ()

    /**
     * For nether furnaces, replaces ForgeHooks.getBurnTime.
     * @param stack - fuel itemstack
     * @param recipeType - ignored
     * @return burn time in ticks.
     */
    protected static int getBurnTime(ItemStack stack, @Nullable IRecipeType<?> recipeType)
    {
        if (AbstractNetherFurnaceTileEntity.burnTimes.isEmpty()) {
            AbstractNetherFurnaceTileEntity.burnTimes = AbstractNetherFurnaceTileEntity.loadBurnTimes();
        }
        if (stack.isEmpty())
        {
            return 0;
        }
        else {
            Item item = stack.getItem();
            int ret = AbstractNetherFurnaceTileEntity.burnTimes.getOrDefault(item, 0);
            return ret;
        }
    } // end getBurnTime()
    
    /**
     * Nether furnaces cook things twice as fast as normal.
     */
    @Override
    protected short getSmeltTime(ItemStack input)
    {
        return (short) (super.getSmeltTime(input)/2);
    }

    @Override
    protected int getBurnDuration(ItemStack fuelstack)
    {
        // getBurnTime() already handles empty stack case.
         int returnval = AbstractNetherFurnaceTileEntity.getBurnTime(fuelstack, recipeType);
         // LOGGER.debug("[" + getDisplayName().getString() + "]AbstractNetherFurnaceTileEntity.getBurnDuration: returns " + returnval + " for " + fuelstack.toString());
         return returnval;
    } // end getBurnDuration

} // end class
