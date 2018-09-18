package alexndr.plugins.netherrocks.tiles;

import java.util.ArrayList;
import java.util.List;

import alexndr.api.content.tiles.TileEntitySimpleFurnace;
import alexndr.api.logger.LogHelper;
import alexndr.plugins.netherrocks.ModBlocks;
import alexndr.plugins.netherrocks.ModItems;
import alexndr.plugins.netherrocks.blocks.NetherFurnaceBlock;
import alexndr.plugins.netherrocks.inventory.NetherFurnaceContainer;
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
import net.minecraft.nbt.NBTTagCompound;

/**
 * @author AleXndrTheGr8st
 */
public class NetherFurnaceTileEntity extends TileEntitySimpleFurnace
{
	protected final static List<ItemStack> fuelstacks = new ArrayList<ItemStack>();
	public final static String tilename = "container.nether_furnace";
	public final static String guiID = "netherrocks:nether_furnace_gui";
	public final static int TILETYPE = 253;
	
    public NetherFurnaceTileEntity() 
    {
		super(NetherFurnaceTileEntity.tilename, 600, NetherFurnaceTileEntity.guiID, 3);
		LogHelper.verbose("netherrocks", "finished NetherFurnaceTileEntity ctor for " 
					+ this.getDisplayName().getUnformattedText());
	}

    public boolean isItemFuel(ItemStack fuel)
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
                 if (Block.isEqualTo(block,Blocks.NETHERRACK)) {
                	return NetherFurnaceBlock.netherrackBurnTime;
                }
                 else if (Block.isEqualTo(block, ModBlocks.fyrite_block)) {
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
	public Container createContainer(InventoryPlayer playerInventory, EntityPlayer playerIn) 
	{
        return new NetherFurnaceContainer(playerInventory, this);
	}


	/* (non-Javadoc)
	 * @see alexndr.api.content.tiles.TileEntitySimpleFurnace#readFromNBT(net.minecraft.nbt.NBTTagCompound)
	 */
	@Override
	public void readFromNBT(NBTTagCompound compound) 
	{
		super.readFromNBT(compound);
        this.currentItemBurnTime = NetherFurnaceTileEntity.getItemBurnTime((ItemStack)this.getStackInSlot(NDX_FUEL_SLOT));
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
            ItemStack readonly_fuelstack = (ItemStack)this.getStackInSlot(NDX_FUEL_SLOT);
            if (!readonly_fuelstack.isEmpty()) {
                burnTime = NetherFurnaceTileEntity.getItemBurnTime(readonly_fuelstack);
            }
            flag1 = default_cooking_update(flag1, readonly_fuelstack, burnTime);
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
//        if (this.world != null)
//        {
//        	IBlockState blockstate = this.getWorld().getBlockState(this.pos);
//        	this.getWorld().notifyBlockUpdate(this.pos, blockstate, blockstate, 2);
//        }

	} // end update()

} // end class
