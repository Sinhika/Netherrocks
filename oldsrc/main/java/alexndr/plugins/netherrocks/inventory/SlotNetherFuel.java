package alexndr.plugins.netherrocks.inventory;

import alexndr.plugins.netherrocks.tiles.NetherFurnaceTileEntity;
import net.minecraft.inventory.SlotFurnaceFuel;
import net.minecraft.item.ItemStack;

/**
 * @author AleXndrTheGr8st
 */
public class SlotNetherFuel extends SlotFurnaceFuel
{
	NetherFurnaceTileEntity nfte;
	
    public SlotNetherFuel(NetherFurnaceTileEntity inventoryIn, int slotIndex, int xPosition, int yPosition) 
    {
		super(inventoryIn, slotIndex, xPosition, yPosition);
		this.nfte = inventoryIn;
	}

    /**
     * Check if the stack is allowed to be placed in this slot, used for armor slots as well as furnace fuel.
     */
	@Override
    public boolean isItemValid(ItemStack stack)
    {
        return nfte.isItemFuel(stack) || isBucket(stack);
    }

} // end slot
