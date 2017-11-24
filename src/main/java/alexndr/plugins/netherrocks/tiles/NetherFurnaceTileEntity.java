package alexndr.plugins.netherrocks.tiles;

import java.util.ArrayList;
import java.util.List;

import alexndr.api.content.tiles.TileEntitySimpleFurnace;
import alexndr.api.logger.LogHelper;
import alexndr.plugins.netherrocks.ModBlocks;
import alexndr.plugins.netherrocks.ModItems;
import alexndr.plugins.netherrocks.blocks.NetherFurnaceBlock;
import alexndr.plugins.netherrocks.inventory.NetherFurnaceContainer;
import alexndr.plugins.netherrocks.inventory.SlotNetherFuel;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.inventory.Container;
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
	protected final static List<ItemStack> fuelstacks = new ArrayList<ItemStack>();
	public final static String tilename = "container.netherrocks_nether_furnace";
	public final static String guiID = "netherrocks:nether_furnace_gui";
	
    public NetherFurnaceTileEntity() 
    {
		super(tilename, 600, guiID, 3);
		LogHelper.verbose("netherrocks", "finished TileEntitySimpleFurnace ctor for " + tilename);
	}

    public static boolean isItemFuel(ItemStack fuel)
    {
         return NetherFurnaceTileEntity.getItemBurnTime(fuel) > 0;
    }

    
    public static int getItemBurnTime(ItemStack burnItem) 
    {
    	if (burnItem.isEmpty())
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
                 else if (block == ModBlocks.fyrite_block) {
                	 return NetherFurnaceBlock.fyriteBurnTime * 10;
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
            
            if (item == ModItems.fyrite_ingot) return NetherFurnaceBlock.fyriteBurnTime;
            if (item == Items.BLAZE_ROD) return NetherFurnaceBlock.blazeRodBurnTime;
            if (item == Items.BLAZE_POWDER) return NetherFurnaceBlock.blazeRodBurnTime / 3;
            
            // if not one of the special items, doesn't burn at all
            return 0;
        } // end-else ! null

	} // end getItemBurnTime()

    /**
     * 
     * @return a list of valid fuel items
     */
   public static List<ItemStack> getFuels()
   {
	   if (fuelstacks.isEmpty()) 
	   {
		   fuelstacks.add(new ItemStack(Blocks.NETHERRACK));
		   fuelstacks.add(new ItemStack(ModItems.fyrite_ingot));
		   fuelstacks.add(new ItemStack(Items.BLAZE_ROD));
		   fuelstacks.add(new ItemStack(Items.BLAZE_POWDER));
		   fuelstacks.add(new ItemStack(ModBlocks.fyrite_block));
		   fuelstacks.add(new ItemStack(ModItems.fyrite_axe));
		   fuelstacks.add(new ItemStack(ModItems.fyrite_pickaxe));
		   fuelstacks.add(new ItemStack(ModItems.fyrite_shovel));
		   fuelstacks.add(new ItemStack(ModItems.fyrite_sword));
	   }
	   return fuelstacks;
   } // end getFuels()
   
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


	@Override
	public Container createContainer(InventoryPlayer playerInventory, EntityPlayer playerIn) {
        return new NetherFurnaceContainer(playerInventory, this);
	}

	@Override
	public void update() 
	{
        boolean flag = this.isBurning();
        boolean flag1 = false;
        int burnTime = 0;
        
        if (this.isBurning())
        {
            --this.furnaceBurnTime;
        }

        if (!this.getWorld().isRemote)
        {
            ItemStack itemstack = (ItemStack)this.getStackInSlot(NDX_FUEL_SLOT);
            if (!itemstack.isEmpty()) {
                burnTime = NetherFurnaceTileEntity.getItemBurnTime(itemstack);
            }
            flag1 = default_cooking_update(flag1, itemstack, burnTime);
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
