package alexndr.plugins.Netherrocks.inventory;

import javax.annotation.Nullable;

import alexndr.plugins.Netherrocks.tiles.NetherFurnaceTileEntity;
import net.minecraft.init.Items;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

/**
 * @author AleXndrTheGr8st
 */
public class SlotNetherFuel extends Slot
{
	public SlotNetherFuel(IInventory iinv, int index, int x, int y) {
		super(iinv, index, x, y);
	}

    @Override
	public boolean isItemValid(@Nullable ItemStack stack)
    {
        return NetherFurnaceTileEntity.isItemFuel(stack) || isBucket(stack);
    }

    @Override
    public int getItemStackLimit(ItemStack stack)
    {
        return isBucket(stack) ? 1 : super.getItemStackLimit(stack);
    }

    // TODO rewrite to use UniversalBucket and SimpleBucket
    public static boolean isBucket(ItemStack stack)
    {
        return stack != null && stack.getItem() != null && stack.getItem() == Items.BUCKET;
    }
} // end slot
