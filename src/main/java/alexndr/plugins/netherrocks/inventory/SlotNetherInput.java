package alexndr.plugins.netherrocks.inventory;

import alexndr.plugins.netherrocks.tiles.NetherFurnaceTileEntity;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.SlotItemHandler;

public class SlotNetherInput extends SlotItemHandler 
{
	private NetherFurnaceTileEntity nfte;

	public SlotNetherInput(IItemHandler itemHandler, int index, int xPosition, int yPosition, 
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
	
} // end class
