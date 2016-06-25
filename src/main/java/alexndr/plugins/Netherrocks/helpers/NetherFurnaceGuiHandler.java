package alexndr.plugins.Netherrocks.helpers;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;
import alexndr.plugins.Netherrocks.gui.NetherFurnaceGui;
import alexndr.plugins.Netherrocks.inventory.NetherFurnaceContainer;
import alexndr.plugins.Netherrocks.tiles.NetherFurnaceTileEntity;

public class NetherFurnaceGuiHandler implements IGuiHandler 
{

	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world,
			int x, int y, int z) 
	{
		TileEntity machine = world.getTileEntity(new BlockPos(x, y, z));
		
        if(machine == null)
        	return null;
            
        if(machine instanceof NetherFurnaceTileEntity)
        	return new NetherFurnaceContainer(player.inventory, (NetherFurnaceTileEntity)machine);
        
        return null;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world,
			int x, int y, int z) 
	{
		TileEntity machine = world.getTileEntity(new BlockPos(x, y, z));
		
        if(machine == null)
        	return null;
            
        if(machine instanceof NetherFurnaceTileEntity)
        	return new NetherFurnaceGui(player.inventory, (NetherFurnaceTileEntity)machine);
        
        return null;
	}

} // end class
