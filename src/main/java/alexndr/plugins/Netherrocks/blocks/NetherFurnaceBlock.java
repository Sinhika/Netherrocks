package alexndr.plugins.Netherrocks.blocks;

import java.util.Random;

import alexndr.api.content.blocks.SimpleFurnace;
import alexndr.api.registry.ContentCategories;
import alexndr.plugins.Netherrocks.ModBlocks;
import alexndr.plugins.Netherrocks.Netherrocks;
import alexndr.plugins.Netherrocks.Settings;
import alexndr.plugins.Netherrocks.helpers.NetherFurnaceGuiHandler;
import alexndr.plugins.Netherrocks.tiles.NetherFurnaceTileEntity;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
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

/**
 * @author AleXndrTheGr8st
 */
public class NetherFurnaceBlock extends SimpleFurnace
{

	public static int netherrackBurnTime = 200, fyriteBurnTime = 8000, blazeRodBurnTime = 2400;

	public NetherFurnaceBlock(String name, boolean isActive) 
	{
		super(name, Netherrocks.plugin, Material.ROCK, ContentCategories.Block.MACHINE, isActive);
		this.setStepSound(SoundType.STONE);
	}
	
	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta) {
		return new NetherFurnaceTileEntity();
	}

	public static SimpleFurnace getUnlit_furnace() {
		return (SimpleFurnace) ModBlocks.nether_furnace;
	}

	public static SimpleFurnace getLit_furnace() {
		return (SimpleFurnace) ModBlocks.nether_furnace_lit;
	}

	
	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune) {
		return Item.getItemFromBlock(ModBlocks.nether_furnace);
	}
	
    /* cut & pasted from BlockFurnace & modified per CompatBlock */
	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, 
						IBlockState state, EntityPlayer playerIn, EnumHand hand, 
						EnumFacing facing, float hitX, float hitY, float hitZ) 
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
	public void setAdditionalProperties() 
	{
		super.setAdditionalProperties();
		NetherFurnaceBlock.netherrackBurnTime = Settings.netherrackBurnTime;
		NetherFurnaceBlock.fyriteBurnTime = Settings.fyriteBurnTime;
		NetherFurnaceBlock.blazeRodBurnTime = Settings.blazeRodBurnTime;
	} // end setAdditionalProperties()

	@Override
	@SideOnly(Side.CLIENT)
	public ItemStack getItem(World arg0, BlockPos arg1, IBlockState arg2) {
		return new ItemStack(Item.getItemFromBlock(ModBlocks.nether_furnace));
	}
	
} // end class

