package alexndr.plugins.netherrocks.blocks;

import alexndr.api.content.blocks.SimpleFurnace;
import alexndr.api.registry.ContentCategories;
import alexndr.api.registry.Plugin;
import alexndr.plugins.netherrocks.Netherrocks;
import alexndr.plugins.netherrocks.Settings;
import alexndr.plugins.netherrocks.helpers.NetherFurnaceGuiHandler;
import alexndr.plugins.netherrocks.tiles.NetherFurnaceTileEntity;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

/**
 * @author AleXndrTheGr8st
 */
public class NetherFurnaceBlock extends SimpleFurnace<NetherFurnaceTileEntity>
{
	// repeat for custom furnace classes
	private static Block unlit_furnace;
	private static Block lit_furnace;

	public static int netherrackBurnTime = 200;
	public static int fyriteBurnTime = 8000;
	public static int blazeRodBurnTime = 2400;

	public NetherFurnaceBlock(String furnace_name, Plugin plugin, boolean isActive) 
	{
		super(furnace_name, plugin, Material.ROCK, ContentCategories.Block.MACHINE, isActive);
	}
	
	@Override
	public NetherFurnaceBlock setStepSound(SoundType sound) {
		return (NetherFurnaceBlock) super.setStepSound(sound);
	}

    /* cut & pasted from BlockFurnace & modified */
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
                // playerIn.addStat(StatList.FURNACE_INTERACTION);
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
            worldIn.setBlockState(pos, NetherFurnaceBlock.lit_furnace.getDefaultState().withProperty(FACING, iblockstate.getValue(FACING)), 3);
            worldIn.setBlockState(pos, NetherFurnaceBlock.lit_furnace.getDefaultState().withProperty(FACING, iblockstate.getValue(FACING)), 3);
        }
        else
        {
            worldIn.setBlockState(pos, NetherFurnaceBlock.unlit_furnace.getDefaultState().withProperty(FACING, iblockstate.getValue(FACING)), 3);
            worldIn.setBlockState(pos, NetherFurnaceBlock.unlit_furnace.getDefaultState().withProperty(FACING, iblockstate.getValue(FACING)), 3);
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
	public Class<NetherFurnaceTileEntity> getTileEntityClass() 
	{
		return NetherFurnaceTileEntity.class;
	}

	@Override
	public NetherFurnaceTileEntity createTileEntity(World world, IBlockState state) 
	{
		return new NetherFurnaceTileEntity();
	}

	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta) 
	{
		return new NetherFurnaceTileEntity();
	}
	
	public static Block getUnlit_furnace() {
		return NetherFurnaceBlock.unlit_furnace;
	}

	public static void setUnlit_furnace(Block unlit_furnace) {
		NetherFurnaceBlock.unlit_furnace = unlit_furnace;
	}

	public static Block getLit_furnace() {
		return NetherFurnaceBlock.lit_furnace;
	}

	public static void setLit_furnace(Block lit_furnace) {
		NetherFurnaceBlock.lit_furnace = lit_furnace;
	}

	
} // end class

