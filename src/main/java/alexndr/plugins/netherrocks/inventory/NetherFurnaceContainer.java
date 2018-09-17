package alexndr.plugins.netherrocks.inventory;

import alexndr.api.content.inventory.SimpleFurnaceContainer;
import alexndr.api.content.tiles.TileEntitySimpleFurnace;
import alexndr.plugins.netherrocks.tiles.NetherFurnaceTileEntity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Slot;
import net.minecraft.inventory.SlotFurnaceOutput;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;

/**
 * Layout based on ContainerFurnace; inventory is mostly capability-based.
 * @author AleXndrTheGr8st
 */
public class NetherFurnaceContainer extends SimpleFurnaceContainer 
{
    
    public NetherFurnaceContainer(InventoryPlayer player, NetherFurnaceTileEntity tileentity) 
    {
    	super(player, tileentity);
		AddOwnSlots(player);
		AddPlayerSlots(player);
    }
    
    @Override
    protected void AddOwnSlots(InventoryPlayer player) 
	{
		this.addSlotToContainer(new Slot(tileFurnace, TileEntitySimpleFurnace.NDX_INPUT_SLOT, 56, 17));
		this.addSlotToContainer(new SlotNetherFuel((NetherFurnaceTileEntity) tileFurnace, 
								TileEntitySimpleFurnace.NDX_FUEL_SLOT, 56, 53));
		this.addSlotToContainer(
				new SlotFurnaceOutput(player.player, tileFurnace, TileEntitySimpleFurnace.NDX_OUTPUT_SLOT, 116, 35));
	} // end AddOwnSlots()


	@Override
	public ItemStack transferStackInSlot(EntityPlayer playerIn, int index) 
	{
        ItemStack itemstack = ItemStack.EMPTY;
        Slot slot = this.inventorySlots.get(index);

        if (slot != null && slot.getHasStack())
        {
            ItemStack itemstack1 = slot.getStack();
            itemstack = itemstack1.copy();

            // output slot?
            if (index == TileEntitySimpleFurnace.NDX_OUTPUT_SLOT)
            {
                if (!this.mergeItemStack(itemstack1, 3, 39, true))
                {
                    return ItemStack.EMPTY;
                }

                slot.onSlotChange(itemstack1, itemstack);
            }
            // player inv/hotbar slot?
            else if (index != TileEntitySimpleFurnace.NDX_FUEL_SLOT 
            		&& index != TileEntitySimpleFurnace.NDX_OUTPUT_SLOT)
            {
                if (!FurnaceRecipes.instance().getSmeltingResult(itemstack1).isEmpty())
                {
                    if (!this.mergeItemStack(itemstack1, 0, 1, false))
                    {
                        return ItemStack.EMPTY;
                    }
                }
                else if (((NetherFurnaceTileEntity) tileFurnace).isItemFuel(itemstack1))
                {
                    if (!this.mergeItemStack(itemstack1, 1, 2, false))
                    {
                        return ItemStack.EMPTY;
                    }
                }
                else if (index >= 3 && index < 30)
                {
                    if (!this.mergeItemStack(itemstack1, 30, 39, false))
                    {
                        return ItemStack.EMPTY;
                    }
                }
                else if (index >= 30 && index < 39 && !this.mergeItemStack(itemstack1, 3, 30, false))
                {
                    return ItemStack.EMPTY;
                }
            }
            else if (!this.mergeItemStack(itemstack1, 3, 39, false))
            {
                return ItemStack.EMPTY;
            }

            if (itemstack1.isEmpty())
            {
                slot.putStack(ItemStack.EMPTY);
            }
            else
            {
                slot.onSlotChanged();
            }

            if (itemstack1.getCount() == itemstack.getCount())
            {
                return ItemStack.EMPTY;
            }

            slot.onTake(playerIn, itemstack1);
        }

        return itemstack;
 	} // end transferStackInSlot()
	

} // end class()
