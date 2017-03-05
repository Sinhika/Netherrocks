package alexndr.plugins.Netherrocks.tiles;

import alexndr.api.content.tiles.TileEntitySimpleFurnace;
import alexndr.plugins.Netherrocks.Content;
import alexndr.plugins.Netherrocks.blocks.NetherFurnaceBlock;
import alexndr.plugins.Netherrocks.inventory.SlotNetherFuel;
import mcjty.lib.tools.ItemStackTools;
import mcjty.lib.tools.MathTools;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemHoe;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.item.ItemTool;

/**
 * @author AleXndrTheGr8st
 */
public class NetherFurnaceTileEntity extends TileEntitySimpleFurnace
{
    public NetherFurnaceTileEntity() 
    {
		super("container.nether_furnace", 600, "netherrocks:nether_furnace_gui", 3);
	}

    public static boolean isItemFuel(ItemStack fuel)
    {
         return NetherFurnaceTileEntity.getItemBurnTime(fuel) > 0;
    }

    
   public static int getItemBurnTime(ItemStack burnItem) 
    {
        if (burnItem == null)
        {
            return 0;
        }
        else
        {
            Item item = burnItem.getItem();

            if (item instanceof ItemBlock && Block.getBlockFromItem(item) != Blocks.AIR)
            {
                Block block = Block.getBlockFromItem(item);
                 if (block == Blocks.NETHERRACK) {
                	return NetherFurnaceBlock.netherrackBurnTime;
                }
            }

            // allow fyrite tools to be burned, too.
            if (item instanceof ItemTool 
            		&& ((ItemTool)item).getToolMaterialName().equals("FYRITE")) {
            	return NetherFurnaceBlock.fyriteBurnTime * 2/3;
            }
            if (item instanceof ItemSword 
            		&& ((ItemSword)item).getToolMaterialName().equals("FYRITE")) {
            	return NetherFurnaceBlock.fyriteBurnTime * 2/3;
            }
            if (item instanceof ItemHoe 
            		&& ((ItemHoe)item).getMaterialName().equals("FYRITE")) {
            	return NetherFurnaceBlock.fyriteBurnTime * 2/3;
            }
            
            if (item == Content.fyrite_ingot) return NetherFurnaceBlock.fyriteBurnTime;
            if (item == Items.BLAZE_ROD) return NetherFurnaceBlock.blazeRodBurnTime;
            if (item == Items.BLAZE_POWDER) return NetherFurnaceBlock.blazeRodBurnTime / 3;
            
            // if not one of the special items, doesn't burn at all
            return 0;
        } // end-else ! null

	} // end getItemBurnTime()

   @Override
   public boolean isItemValidForSlot(int index, ItemStack stack)
   {
       if (index == NDX_OUTPUT_SLOT)
       {
           return false;
       }
       else if (index != NDX_FUEL_SLOT)
       {
           return true;
       }
       else
       {
           ItemStack itemstack = this.getStackInSlot(NDX_FUEL_SLOT);
           return NetherFurnaceTileEntity.isItemFuel(stack) || SlotNetherFuel.isBucket(stack) 
                           && (itemstack == null || itemstack.getItem() != Items.BUCKET);
       }
   }


//	@Override
//	public Container createContainer(InventoryPlayer playerInventory, EntityPlayer playerIn) {
//        return new NetherFurnaceContainer(playerInventory, this);
//	}

	@Override
	public void update() 
	{
        boolean flag = this.isBurning();
        boolean flag1 = false;

        if (this.isBurning())
        {
            --this.furnaceBurnTime;
        }

        if (!this.getWorld().isRemote)
        {
            ItemStack itemstack = (ItemStack)this.getStackInSlot(NDX_FUEL_SLOT);
            
            if (this.isBurning() || ItemStackTools.isValid(itemstack) 
                &&  ItemStackTools.isValid(this.getStackInSlot(NDX_INPUT_SLOT)))
            {
                if (!this.isBurning() && this.canSmelt())
                {
                    this.furnaceBurnTime = NetherFurnaceTileEntity.getItemBurnTime(itemstack);
                    this.currentItemBurnTime = this.furnaceBurnTime;

                    if (this.isBurning())
                    {
                        flag1 = true;
                        
                        if (ItemStackTools.isValid(itemstack))
                        {
                            Item item = itemstack.getItem();
                            ItemStackTools.incStackSize(itemstack, -1);
                            if (ItemStackTools.isEmpty(itemstack)) {
                                ItemStack item1 = item.getContainerItem(itemstack);
                                this.furnaceItemStacks.set(NDX_FUEL_SLOT, item1);
                            }
                        }
                    } // end-if isBurning
                } // end-if !isBurning && canSmelt

                if (this.isBurning() && this.canSmelt())
                {
                    ++this.cookTime;

                    if (this.cookTime == this.totalCookTime)
                    {
                        this.cookTime = 0;
                        this.totalCookTime = this.getCookTime(
                                        this.getStackInSlot(NDX_INPUT_SLOT));
                        this.smeltItem();
                        flag1 = true;
                    }
                }
                else
                {
                    this.cookTime = 0;
                }
            } // end-if isBurning or isValid(fuel)
            else if (!this.isBurning() && this.cookTime > 0)
            {
                this.cookTime = MathTools.clamp(this.cookTime - 2, 0, this.totalCookTime);
            }

            if (flag != this.isBurning())
            {
                flag1 = true;
                NetherFurnaceBlock.setState(this.isBurning(), this.getWorld(), this.pos);
            } // end-if
        } // end-if ! isRemote

        if (flag1)
        {
            this.markDirty();
        }
	} // end update()
} // end class
