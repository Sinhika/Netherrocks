package alexndr.plugins.Netherrocks.tiles;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemHoe;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.item.ItemTool;
import net.minecraft.util.math.MathHelper;
import alexndr.api.content.tiles.TileEntitySimpleFurnace;
import alexndr.plugins.Netherrocks.Content;
import alexndr.plugins.Netherrocks.blocks.NetherFurnaceBlock;

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
         return getItemBurnTime(fuel) > 0;
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

        if (!this.worldObj.isRemote)
        {
            if (this.isBurning() 
            	|| this.furnaceItemStacks[1] != null && this.furnaceItemStacks[0] != null)
            {
                if (!this.isBurning() && this.canSmelt())
                {
                    this.currentItemBurnTime = this.furnaceBurnTime = getItemBurnTime(this.furnaceItemStacks[1]);

                    if (this.isBurning())
                    {
                        flag1 = true;

                        if (this.furnaceItemStacks[1] != null)
                        {
                            --this.furnaceItemStacks[1].stackSize;

                            if (this.furnaceItemStacks[1].stackSize == 0)
                            {
                                this.furnaceItemStacks[1] = furnaceItemStacks[1].getItem().getContainerItem(furnaceItemStacks[1]);
                            }
                        }
                    }
                }

                if (this.isBurning() && this.canSmelt())
                {
                    ++this.cookTime;

                    if (this.cookTime == this.totalCookTime)
                    {
                        this.cookTime = 0;
                        this.totalCookTime = this.getCookTime(this.furnaceItemStacks[0]);
                        this.smeltItem();
                        flag1 = true;
                    }
                }
                else
                {
                    this.cookTime = 0;
                }
            }
            else if (!this.isBurning() && this.cookTime > 0)
            {
                this.cookTime = MathHelper.clamp_int(this.cookTime - 2, 0, this.totalCookTime);
            }

            if (flag != this.isBurning())
            {
                flag1 = true;
                NetherFurnaceBlock.setState(this.isBurning(), this.worldObj, this.pos);
            } // end-if
        } // end-if

        if (flag1)
        {
            this.markDirty();
        }
	} // end update()
} // end class
