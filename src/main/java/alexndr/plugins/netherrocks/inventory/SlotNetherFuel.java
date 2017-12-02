package alexndr.plugins.netherrocks.inventory;

import javax.annotation.Nullable;

import alexndr.plugins.netherrocks.tiles.NetherFurnaceTileEntity;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.SlotItemHandler;

/**
 * @author AleXndrTheGr8st
 */
public class SlotNetherFuel extends SlotItemHandler
{
	private NetherFurnaceTileEntity nfte;
	
	public SlotNetherFuel(IItemHandler iinv, int index, int x, int y, NetherFurnaceTileEntity nfte) 
	{
		super(iinv, index, x, y);
		this.nfte = nfte;
	}

    @Override
	public boolean isItemValid(@Nullable ItemStack stack)
    {
        boolean okay = NetherFurnaceTileEntity.isItemFuel(stack) || isBucket(stack);
        return okay && super.isItemValid(stack);
    }

    @Override
    public int getItemStackLimit(ItemStack stack)
    {
        return isBucket(stack) ? 1 : super.getItemStackLimit(stack);
    }

    // TODO rewrite to use UniversalBucket and SimpleBucket
    public static boolean isBucket(ItemStack stack)
    {
        return stack != null && stack.getItem() != null 
        		&& stack.getItem() == Items.BUCKET;
    }

	@Override
	public void onSlotChange(ItemStack p_75220_1_, ItemStack p_75220_2_) 
	{
		nfte.markDirty();
	}

} // end slot
