package alexndr.plugins.Netherrocks.blocks;

import java.util.Random;

import javax.annotation.Nullable;

import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.StatList;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import alexndr.api.content.blocks.SimpleFurnace;
import alexndr.api.registry.ContentCategories;
import alexndr.plugins.Netherrocks.Content;
import alexndr.plugins.Netherrocks.Netherrocks;
import alexndr.plugins.Netherrocks.helpers.NetherFurnaceGuiHandler;
import alexndr.plugins.Netherrocks.tiles.NetherFurnaceTileEntity;

/**
 * @author AleXndrTheGr8st
 */
public class NetherFurnaceBlock extends SimpleFurnace
{

	public static int netherrackBurnTime = 200, fyriteBurnTime = 8000, blazeRodBurnTime = 2400;

	public NetherFurnaceBlock(boolean isActive) 
	{
		super(Netherrocks.plugin, Material.ROCK, ContentCategories.Block.MACHINE, isActive);
	}
	
	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta) {
		return new NetherFurnaceTileEntity();
	}

	public static SimpleFurnace getUnlit_furnace() {
		return (SimpleFurnace) Content.nether_furnace;
	}

	public static SimpleFurnace getLit_furnace() {
		return (SimpleFurnace) Content.nether_furnace_lit;
	}

	
	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune) {
		return Item.getItemFromBlock(Content.nether_furnace);
	}
	
    /* cut & pasted from BlockFurnace */
	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos,
			IBlockState state, EntityPlayer playerIn, EnumHand hand,
			@Nullable ItemStack heldItem, EnumFacing side, float hitX,
			float hitY, float hitZ) 
	{
        if (worldIn.isRemote) {
            return true;
        }
        else
        {
            TileEntity tileentity = worldIn.getTileEntity(pos);

            if (tileentity instanceof NetherFurnaceTileEntity)
            {
            	playerIn.openGui(Netherrocks.INSTANCE, NetherFurnaceGuiHandler.NETHER_FURNACE_TILE_ID, 
            		  			worldIn, pos.getX(), pos.getY(), pos.getZ());
                playerIn.addStat(StatList.FURNACE_INTERACTION);
            }
            return true;
        }
	} // end onBlockActivated
	
    public static void setState(boolean active, World worldIn, BlockPos pos)
    {
        IBlockState iblockstate = worldIn.getBlockState(pos);
        TileEntity tileentity = worldIn.getTileEntity(pos);
    	
        keepInventory = true;

        if (active)
        {
            worldIn.setBlockState(pos, getLit_furnace().getDefaultState().withProperty(FACING, iblockstate.getValue(FACING)), 3);
            worldIn.setBlockState(pos, getLit_furnace().getDefaultState().withProperty(FACING, iblockstate.getValue(FACING)), 3);
        }
        else
        {
            worldIn.setBlockState(pos, getUnlit_furnace().getDefaultState().withProperty(FACING, iblockstate.getValue(FACING)), 3);
            worldIn.setBlockState(pos, getUnlit_furnace().getDefaultState().withProperty(FACING, iblockstate.getValue(FACING)), 3);
        }

        keepInventory = false;

        if (tileentity != null)
        {
            tileentity.validate();
            worldIn.setTileEntity(pos, tileentity);
        }
    } // end setState()
	

	@Override
	public IBlockState onBlockPlaced(World worldIn, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer) {
		return this.getDefaultState().withProperty(FACING, placer.getHorizontalFacing().getOpposite());
	}
	
	@Override
	public void onBlockPlacedBy(World worldIn, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack) {
		worldIn.setBlockState(pos, state.withProperty(FACING, placer.getHorizontalFacing().getOpposite()), 2);
		if(stack.hasDisplayName()) {
			TileEntity tileentity = worldIn.getTileEntity(pos);
			if(tileentity instanceof NetherFurnaceTileEntity)
				((NetherFurnaceTileEntity)tileentity).setCustomInventoryName(stack.getDisplayName());
		}
	}
	
	@Override
	public void setAdditionalProperties() 
	{
		super.setAdditionalProperties();
		if(entry.getValueByName("NetherrackBurnTime") != null 
				&& entry.getValueByName("NetherrackBurnTime").isActive())
		{
			NetherFurnaceBlock.netherrackBurnTime = Integer.parseInt(
					entry.getValueByName("NetherrackBurnTime").getCurrentValue());
		}
		if(entry.getValueByName("FyriteBurnTime") != null 
				&& entry.getValueByName("FyriteBurnTime").isActive())
		{
			NetherFurnaceBlock.fyriteBurnTime = Integer.parseInt(entry.getValueByName("FyriteBurnTime").getCurrentValue());
		}
		if(entry.getValueByName("BlazeRodBurnTime") != null 
				&& entry.getValueByName("BlazeRodBurnTime").isActive())
		{
			NetherFurnaceBlock.blazeRodBurnTime = Integer.parseInt(entry.getValueByName("BlazeRodBurnTime").getCurrentValue());
		}
	} // end setAdditionalProperties()

	@Override
	@SideOnly(Side.CLIENT)
	public ItemStack getItem(World arg0, BlockPos arg1, IBlockState arg2) {
		return new ItemStack(Item.getItemFromBlock(Content.nether_furnace));
	}
	
} // end class

