package alexndr.plugins.netherrocks.inventory;

import alexndr.api.content.tiles.TileEntityBaseFurnace;
import alexndr.plugins.netherrocks.tiles.NetherFurnaceTileEntity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraftforge.items.ItemStackHandler;

/**
 * Layout based on ContainerFurnace; inventory is mostly capability-based.
 * @author AleXndrTheGr8st
 */
public class NetherFurnaceContainer extends Container 
{
	protected NetherFurnaceTileEntity tileFurnace;
//	private int lastCookTime = 0;
//	private int lastBurnTime = 0;
//	private int lastItemBurnTime = 0;
//	private int lastTotalCookTime = 0;
    
    public NetherFurnaceContainer(InventoryPlayer player, NetherFurnaceTileEntity tileentity) 
    {
		this.tileFurnace = tileentity;
		AddOwnSlots();
		AddPlayerSlots(player);
    }
    
	private void AddPlayerSlots(InventoryPlayer player) 
	{
		// main player inventory slots
		for (int i = 0; i < 3; ++i) {
			for (int j = 0; j < 9; ++j) 
				this.addSlotToContainer(new Slot(player, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
		}
		// player hotbar slots
		for (int i = 0; i < 9; ++i) 
			this.addSlotToContainer(new Slot(player, i, 8 + i * 18, 142));
	} // end AddPlayerSlots()

	private void AddOwnSlots() 
	{
		ItemStackHandler itemhandler = tileFurnace.getSlotHandler();
		this.addSlotToContainer(
				new SlotNetherInput(itemhandler, TileEntityBaseFurnace.NDX_INPUT_SLOT, 56, 17, 
									tileFurnace));
		this.addSlotToContainer(
				new SlotNetherFuel(itemhandler, TileEntityBaseFurnace.NDX_FUEL_SLOT, 56, 53, 
								   tileFurnace));
		this.addSlotToContainer(
				new SlotNetherOutput(itemhandler, TileEntityBaseFurnace.NDX_OUTPUT_SLOT, 116, 35,
									tileFurnace) );
	} // end AddOwnSlots()


	@Override
	public boolean canInteractWith(EntityPlayer playerIn) 
	{
        return this.tileFurnace.canInteractWith(playerIn);
	}
	
	@Override
	public ItemStack transferStackInSlot(EntityPlayer playerIn, int index) 
	{
		int inventoryStart = TileEntityBaseFurnace.NDX_OUTPUT_SLOT + 1; // skip own slots
		int inventoryEnd = inventoryStart + 26;
		int hotbarStart = inventoryEnd + 1;
		int hotbarEnd = hotbarStart + 8;
		
		//int containerSlots = inventorySlots.size() - playerIn.inventory.mainInventory.size();
		ItemStack currentStack = ItemStack.EMPTY;
		
		Slot slot = this.inventorySlots.get(index);

		if (slot != null && slot.getHasStack()) 
		{
			ItemStack newStack = slot.getStack();
			currentStack = newStack.copy();
			
			// if furnace output slot...
			if (index == TileEntityBaseFurnace.NDX_OUTPUT_SLOT)
			{
				if (!this.mergeItemStack(newStack, inventoryStart, inventorySlots.size(), true)) 
				{
					return ItemStack.EMPTY;
				}
				slot.onSlotChange(newStack, currentStack);
			}
			// else if inventory or hotbar slot...
			else if (index >= inventoryStart)			
			{
				// is this something we can smelt?
				if (FurnaceRecipes.instance().getSmeltingResult(newStack).isEmpty()) 
				{
					// if so, try moving to input slot.
					if (!this.mergeItemStack(newStack, TileEntityBaseFurnace.NDX_INPUT_SLOT, 
											 TileEntityBaseFurnace.NDX_INPUT_SLOT+1, false))
					{
						return ItemStack.EMPTY;
					}
				} // end-if smeltable
				// else if main inventory slot...
				else if (index <= inventoryEnd)
				{
					// can we move it to a hotbar slot?
					if (!this.mergeItemStack(newStack, hotbarStart, hotbarEnd+1, false)) {
						return ItemStack.EMPTY;
					} // end-if 
				} // end else-if index <= inventoryEnd 
				// else if hotbar slot...
				else if(index >= inventoryEnd+1 && index < hotbarEnd+1)
				{
					// can we move it to a main inventory slot?
					if (!this.mergeItemStack(newStack, inventoryStart, inventoryEnd+1, false)) {
						return ItemStack.EMPTY;
					}
				} // end else-if inventoryEnd < index <= hotbarEnd
			} // end else-if index >= inventoryStart
			// else not inventory or hotbar or output slot
			else {
				if( !this.mergeItemStack(newStack, inventoryStart, hotbarEnd+1, false)) {
					return ItemStack.EMPTY;
				}
			} // end-else
			
			if (newStack.isEmpty())
				slot.putStack(ItemStack.EMPTY);
			else
				slot.onSlotChanged();

			if (newStack.getCount() == currentStack.getCount())
				return ItemStack.EMPTY;

			slot.onTake(playerIn, newStack);
		}

		return currentStack;
	} // end transferStackInSlot()
	
//	@Override
//  public void addListener(IContainerListener listener)
//  {
//      super.addListener(listener);
//      listener.sendAllWindowProperties(this, this.tileFurnace);
//  }
  
//  @Override
//	public void detectAndSendChanges() 
//  {
//		super.detectAndSendChanges();
//
//		for (int i = 0; i < this.listeners.size(); ++i) {
//			IContainerListener icrafting = (IContainerListener) this.listeners.get(i);
//
//			if (this.lastCookTime != this.tileFurnace.getField(2))
//				icrafting.sendWindowProperty(this, 2, this.tileFurnace.getField(2));
//
//			if (this.lastBurnTime != this.tileFurnace.getField(0))
//				icrafting.sendWindowProperty(this, 0, this.tileFurnace.getField(0));
//
//			if (this.lastItemBurnTime != this.tileFurnace.getField(1))
//				icrafting.sendWindowProperty(this, 1, this.tileFurnace.getField(1));
//
//			if (this.lastTotalCookTime != this.tileFurnace.getField(3))
//				icrafting.sendWindowProperty(this, 3, this.tileFurnace.getField(3));
//		}
//
//		this.lastCookTime = this.tileFurnace.getField(2);
//		this.lastBurnTime = this.tileFurnace.getField(0);
//		this.lastItemBurnTime = this.tileFurnace.getField(1);
//		this.lastTotalCookTime = this.tileFurnace.getField(3);
//  }
  
//  @Override
//	@SideOnly(Side.CLIENT)
//  public void updateProgressBar(int id, int data) {
//      this.tileFurnace.setField(id, data);
//  }

} // end class()
