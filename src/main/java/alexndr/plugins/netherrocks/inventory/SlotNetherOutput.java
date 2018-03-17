package alexndr.plugins.netherrocks.inventory;

import javax.annotation.Nonnull;

import alexndr.plugins.netherrocks.tiles.NetherFurnaceTileEntity;
import net.minecraft.item.ItemStack;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.SlotItemHandler;

public class SlotNetherOutput extends SlotItemHandler 
{
	private NetherFurnaceTileEntity nfte;

	public SlotNetherOutput(IItemHandler itemHandler, int index, int xPosition, int yPosition,
						    NetherFurnaceTileEntity nfte) 
	{
		super(itemHandler, index, xPosition, yPosition);
		this.nfte = nfte;
	}
	
	@Override
	public void onSlotChanged() 
	{ 
		nfte.markDirty();
	}

	 @Override
	    public boolean isItemValid(@Nonnull ItemStack stack) {
	        return false;
	}
} // end class
