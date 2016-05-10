package alexndr.plugins.Netherrocks;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityFurnace;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import alexndr.api.helpers.game.TabHelper;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

/**
 * @author AleXndrTheGr8st
 */
public class BlockNetherFurnace extends BlockContainer
{
    /**
     * Is the random generator used by furnace to drop the inventory contents in random directions.
     */
    private final Random furnaceRand = new Random();

    /** True if this is an active furnace, false if idle */
    private final boolean isActive;

    /**
     * This flag is used to prevent the furnace inventory to be dropped upon block removal, is used internally when the
     * furnace block changes from idle to active and vice-versa.
     */
    private static boolean keepFurnaceInventory;
    @SideOnly(Side.CLIENT)
    private IIcon furnaceIconTop;
    @SideOnly(Side.CLIENT)
    private IIcon furnaceIconFront;

    public BlockNetherFurnace(boolean par2)
    {
        super(Material.iron);
        this.isActive = par2;
        
        if(par2 == false)
		{
        	this.setCreativeTab(TabHelper.decorationsTab());
		}
    }

    /**
     * Returns the ID of the items to drop on destruction.
     */
    @Override
    public Item getItemDropped(int par1, Random par2Random, int par3)
    {
        return Item.getItemFromBlock(Content.nether_furnace);
    }

    /**
     * Called whenever the block is added into the world. Args: world, x, y, z
     */
    @Override
	public void onBlockAdded(World par1World, int par2, int par3, int par4)
    {
        super.onBlockAdded(par1World, par2, par3, par4);
        this.setDefaultDirection(par1World, par2, par3, par4);
    }

    /**
     * set a blocks direction
     */
    private void setDefaultDirection(World par1World, int par2, int par3, int par4)
    {
        if (!par1World.isRemote)
        {
            Block l = par1World.getBlock(par2, par3, par4 - 1);
            Block i1 = par1World.getBlock(par2, par3, par4 + 1);
            Block j1 = par1World.getBlock(par2 - 1, par3, par4);
            Block k1 = par1World.getBlock(par2 + 1, par3, par4);
            byte b0 = 3;

            if (l.func_149730_j() && !i1.func_149730_j())
            {
                b0 = 3;
            }

            if (i1.func_149730_j() && !l.func_149730_j())
            {
                b0 = 2;
            }

            if (j1.func_149730_j() && !k1.func_149730_j())
            {
                b0 = 5;
            }

            if (k1.func_149730_j() && !j1.func_149730_j())
            {
                b0 = 4;
            }

            par1World.setBlockMetadataWithNotify(par2, par3, par4, b0, 2);
        }
    }

    /**
     * From the specified side and block metadata retrieves the blocks texture. Args: side, metadata
     */
    @Override
	@SideOnly(Side.CLIENT)
    public IIcon getIcon(int par1, int par2)
    {
        if(par2 == 0 || par2 == 1)
        {
        	return par1 == 1 ? this.furnaceIconTop : (par1 == 0 ? this.furnaceIconTop : (par1 == 3 ? this.furnaceIconFront : this.blockIcon));        	        	
        }
        else
        {
        	return par1 == 1 ? this.furnaceIconTop : (par1 == 0 ? this.furnaceIconTop : (par1 != par2 ? this.blockIcon : this.furnaceIconFront));
        }  
    }

    /**
     * When this method is called, your block should register all the icons it needs with the given IconRegister. This
     * is the only chance you get to register icons.
     */
    @Override
	@SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister par1IconRegister)
    {
        this.blockIcon = par1IconRegister.registerIcon("netherrocks:" + "nether_furnace_side");
        this.furnaceIconFront = par1IconRegister.registerIcon(this.isActive ? "netherrocks:" + "nether_furnace_front_lit" : "netherrocks:" + "nether_furnace_front");
        this.furnaceIconTop = par1IconRegister.registerIcon("netherrocks:" + "nether_furnace_top");
    }

    /**
     * Called upon block activation (right click on the block.)
     */
    @Override
	public boolean onBlockActivated(World par1World, int par2, int par3, int par4, EntityPlayer par5EntityPlayer, int par6, float par7, float par8, float par9)
    {
        if (par1World.isRemote)
        {
            return true;
        }
        else
        {
            par5EntityPlayer.openGui(Netherrocks.INSTANCE, 0, par1World, par2, par3, par4);

            return true;
        }
    }

    /**
     * Update which block ID the furnace is using depending on whether or not it is burning
     */
    public static void updateFurnaceBlockState(boolean par0, World par1World, int par2, int par3, int par4)
    {
        int l = par1World.getBlockMetadata(par2, par3, par4);
        TileEntity tileentity = par1World.getTileEntity(par2, par3, par4);
        keepFurnaceInventory = true;

        if (par0)
        {
            par1World.setBlock(par2, par3, par4, Content.nether_furnace_lit);
        }
        else
        {
            par1World.setBlock(par2, par3, par4, Content.nether_furnace);
        }

        keepFurnaceInventory = false;
        par1World.setBlockMetadataWithNotify(par2, par3, par4, l, 2);

        if (tileentity != null)
        {
            tileentity.validate();
            par1World.setTileEntity(par2, par3, par4, tileentity);
        }
    }

    /**
     * A randomly called display update to be able to add particles or other items for display
     */
    @Override
	@SideOnly(Side.CLIENT)
    public void randomDisplayTick(World par1World, int par2, int par3, int par4, Random par5Random)
    {
        if (this.isActive)
        {
            int l = par1World.getBlockMetadata(par2, par3, par4);
            float f = par2 + 0.5F;
            float f1 = par3 + 0.0F + par5Random.nextFloat() * 6.0F / 16.0F;
            float f2 = par4 + 0.5F;
            float f3 = 0.52F;
            float f4 = par5Random.nextFloat() * 0.6F - 0.3F;

            if (l == 4)
            {
                par1World.spawnParticle("smoke", f - f3, f1, f2 + f4, 0.0D, 0.0D, 0.0D);
                par1World.spawnParticle("flame", f - f3, f1, f2 + f4, 0.0D, 0.0D, 0.0D);
            }
            else if (l == 5)
            {
                par1World.spawnParticle("smoke", f + f3, f1, f2 + f4, 0.0D, 0.0D, 0.0D);
                par1World.spawnParticle("flame", f + f3, f1, f2 + f4, 0.0D, 0.0D, 0.0D);
            }
            else if (l == 2)
            {
                par1World.spawnParticle("smoke", f + f4, f1, f2 - f3, 0.0D, 0.0D, 0.0D);
                par1World.spawnParticle("flame", f + f4, f1, f2 - f3, 0.0D, 0.0D, 0.0D);
            }
            else if (l == 3)
            {
                par1World.spawnParticle("smoke", f + f4, f1, f2 + f3, 0.0D, 0.0D, 0.0D);
                par1World.spawnParticle("flame", f + f4, f1, f2 + f3, 0.0D, 0.0D, 0.0D);
            }
        }
    }

    /**
     * Returns a new instance of a block's tile entity class. Called on placing the block.
     */
    @Override
	public TileEntity createNewTileEntity(World par1World, int var2)
    {
        return new TileEntityNetherFurnace();
    }

    /**
     * Called when the block is placed in the world.
     */
    @Override
	public void onBlockPlacedBy(World par1World, int par2, int par3, int par4, EntityLivingBase par5EntityLivingBase, ItemStack par6ItemStack)
    {
        int l = MathHelper.floor_double(par5EntityLivingBase.rotationYaw * 4.0F / 360.0F + 0.5D) & 3;

        if (l == 0)
        {
            par1World.setBlockMetadataWithNotify(par2, par3, par4, 2, 2);
        }

        if (l == 1)
        {
            par1World.setBlockMetadataWithNotify(par2, par3, par4, 5, 2);
        }

        if (l == 2)
        {
            par1World.setBlockMetadataWithNotify(par2, par3, par4, 3, 2);
        }

        if (l == 3)
        {
            par1World.setBlockMetadataWithNotify(par2, par3, par4, 4, 2);
        }

        if (par6ItemStack.hasDisplayName())
        {
            ((TileEntityFurnace)par1World.getTileEntity(par2, par3, par4)).func_145951_a(par6ItemStack.getDisplayName());
        }
    }

    /**
     * ejects contained items into the world, and notifies neighbours of an update, as appropriate
     */
    @Override
	public void breakBlock(World par1World, int par2, int par3, int par4, Block par5, int par6)
    {
        if (!keepFurnaceInventory)
        {
        	TileEntityNetherFurnace tileentityfurnace = (TileEntityNetherFurnace)par1World.getTileEntity(par2, par3, par4);

            if (tileentityfurnace != null)
            {
                for (int j1 = 0; j1 < tileentityfurnace.getSizeInventory(); ++j1)
                {
                    ItemStack itemstack = tileentityfurnace.getStackInSlot(j1);

                    if (itemstack != null)
                    {
                        float f = this.furnaceRand.nextFloat() * 0.8F + 0.1F;
                        float f1 = this.furnaceRand.nextFloat() * 0.8F + 0.1F;
                        float f2 = this.furnaceRand.nextFloat() * 0.8F + 0.1F;

                        while (itemstack.stackSize > 0)
                        {
                            int k1 = this.furnaceRand.nextInt(21) + 10;

                            if (k1 > itemstack.stackSize)
                            {
                                k1 = itemstack.stackSize;
                            }

                            itemstack.stackSize -= k1;
                            EntityItem entityitem = new EntityItem(par1World, par2 + f, par3 + f1, par4 + f2, new ItemStack(itemstack.getItem(), k1, itemstack.getItemDamage()));

                            if (itemstack.hasTagCompound())
                            {
                                entityitem.getEntityItem().setTagCompound((NBTTagCompound)itemstack.getTagCompound().copy());
                            }

                            float f3 = 0.05F;
                            entityitem.motionX = (float)this.furnaceRand.nextGaussian() * f3;
                            entityitem.motionY = (float)this.furnaceRand.nextGaussian() * f3 + 0.2F;
                            entityitem.motionZ = (float)this.furnaceRand.nextGaussian() * f3;
                            par1World.spawnEntityInWorld(entityitem);
                        }
                    }
                }

                par1World.func_147453_f(par2, par3, par4, par5);
            }
        }

        super.breakBlock(par1World, par2, par3, par4, par5, par6);
    }

    /**
     * If this returns true, then comparators facing away from this block will use the value from
     * getComparatorInputOverride instead of the actual redstone signal strength.
     */
    @Override
	public boolean hasComparatorInputOverride()
    {
        return true;
    }

    /**
     * If hasComparatorInputOverride returns true, the return value from this is used instead of the redstone signal
     * strength when this block inputs to a comparator.
     */
    @Override
	public int getComparatorInputOverride(World par1World, int par2, int par3, int par4, int par5)
    {
        return Container.calcRedstoneFromInventory((IInventory)par1World.getTileEntity(par2, par3, par4));
    }
}
