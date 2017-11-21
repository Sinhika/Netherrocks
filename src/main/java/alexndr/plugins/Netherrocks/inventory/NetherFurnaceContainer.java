package alexndr.plugins.Netherrocks.inventory;

import alexndr.plugins.Netherrocks.tiles.NetherFurnaceTileEntity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IContainerListener;
import net.minecraft.inventory.Slot;
import net.minecraft.inventory.SlotFurnaceOutput;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 * @author AleXndrTheGr8st
 */
public class NetherFurnaceContainer extends Container 
{
	protected NetherFurnaceTileEntity tileFurnace;
	private int lastCookTime = 0;
	private int lastBurnTime = 0;
	private int lastItemBurnTime = 0;
	private int lastTotalCookTime = 0;
    
    public NetherFurnaceContainer(InventoryPlayer player, NetherFurnaceTileEntity tileentity) 
    {
		this.tileFurnace = tileentity;
		this.addSlotToContainer(new Slot(tileentity, 0, 56, 17));
		this.addSlotToContainer(new SlotNetherFuel(tileentity, 1, 56, 53));
		this.addSlotToContainer(new SlotFurnaceOutput(player.player, tileentity, 2, 116, 35));

		for (int i = 0; i < 3; ++i) {
			for (int j = 0; j < 9; ++j) 
				this.addSlotToContainer(new Slot(player, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
		}

		for (int i = 0; i < 9; ++i) 
			this.addSlotToContainer(new Slot(player, i, 8 + i * 18, 142));
    }
    
	@Override
    public void addListener(IContainerListener listener)
    {
        super.addListener(listener);
        listener.sendAllWindowProperties(this, this.tileFurnace);
    }
    
    @Override
	public void detectAndSendChanges() 
    {
		super.detectAndSendChanges();

		for (int i = 0; i < this.listeners.size(); ++i) {
			IContainerListener icrafting = (IContainerListener) this.listeners.get(i);

			if (this.lastCookTime != this.tileFurnace.getField(2))
				icrafting.sendWindowProperty(this, 2, this.tileFurnace.getField(2));

			if (this.lastBurnTime != this.tileFurnace.getField(0))
				icrafting.sendWindowProperty(this, 0, this.tileFurnace.getField(0));

			if (this.lastItemBurnTime != this.tileFurnace.getField(1))
				icrafting.sendWindowProperty(this, 1, this.tileFurnace.getField(1));

			if (this.lastTotalCookTime != this.tileFurnace.getField(3))
				icrafting.sendWindowProperty(this, 3, this.tileFurnace.getField(3));
		}

		this.lastCookTime = this.tileFurnace.getField(2);
		this.lastBurnTime = this.tileFurnace.getField(0);
		this.lastItemBurnTime = this.tileFurnace.getField(1);
		this.lastTotalCookTime = this.tileFurnace.getField(3);
    }
    
    @Override
	@SideOnly(Side.CLIENT)
    public void updateProgressBar(int id, int data) {
        this.tileFurnace.setField(id, data);
    }

	@Override
	public boolean canInteractWith(EntityPlayer playerIn) {
        return this.tileFurnace.isUsableByPlayer(playerIn);
	}
	
	@Override
	public ItemStack transferStackInSlot(EntityPlayer playerIn, int index) 
	{
		ItemStack itemstack = ItemStack.EMPTY;
		Slot slot = this.inventorySlots.get(index);

		if (slot != null && slot.getHasStack()) {
			ItemStack itemstack1 = slot.getStack();
			itemstack = itemstack1.copy();

			if (index == 2) {
				if (!this.mergeItemStack(itemstack1, 3, 39, true))
					return ItemStack.EMPTY;
				slot.onSlotChange(itemstack1, itemstack);
			} 
			else if (index != 1 && index != 0) {
				if (NetherFurnaceTileEntity.isItemFuel(itemstack1)) {
					if (!this.mergeItemStack(itemstack1, 1, 2, false))
						return ItemStack.EMPTY;
				} 
				else if (FurnaceRecipes.instance().getSmeltingResult(itemstack1) != null) {
					if (!this.mergeItemStack(itemstack1, 0, 1, false))
						return ItemStack.EMPTY;
				} 
				else if (index >= 3 && index < 30) {
					if (!this.mergeItemStack(itemstack1, 30, 39, false))
						return ItemStack.EMPTY;
				} 
				else if (index >= 30 && index < 39 && !this.mergeItemStack(itemstack1, 3, 30, false))
					return ItemStack.EMPTY;
			} 
			else if (!this.mergeItemStack(itemstack1, 3, 39, false))
				return ItemStack.EMPTY;

			if (itemstack1.isEmpty())
				slot.putStack(ItemStack.EMPTY);
			else
				slot.onSlotChanged();

			if (itemstack1.getCount() == itemstack.getCount())
				return ItemStack.EMPTY;

			slot.onTake(playerIn, itemstack1);
		}

		return itemstack;
	}
} // end class()
