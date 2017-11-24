package alexndr.plugins.netherrocks.blocks;

import alexndr.api.content.blocks.SimpleFurnace;
import alexndr.api.registry.ContentCategories;
import alexndr.api.registry.Plugin;
import alexndr.plugins.netherrocks.Netherrocks;
import alexndr.plugins.netherrocks.Settings;
import alexndr.plugins.netherrocks.helpers.NetherFurnaceGuiHandler;
import alexndr.plugins.netherrocks.tiles.NetherFurnaceTileEntity;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.stats.StatList;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

/**
 * @author AleXndrTheGr8st
 */
public class NetherFurnaceBlock extends SimpleFurnace
{

	public static int netherrackBurnTime = 200;
	public static int fyriteBurnTime = 8000;
	public static int blazeRodBurnTime = 2400;

	public NetherFurnaceBlock(String furnace_name, Plugin plugin, boolean isActive) 
	{
		super(furnace_name, plugin, Material.ROCK, ContentCategories.Block.MACHINE, isActive);
		setRegistryName(plugin.getModId(), furnace_name);
	}
	
	@Override
	public NetherFurnaceBlock setStepSound(SoundType sound) {
		return (NetherFurnaceBlock) super.setStepSound(sound);
	}

	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta) 
	{
		NetherFurnaceTileEntity te = new NetherFurnaceTileEntity();
		return (TileEntity) te;
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
	
} // end class

