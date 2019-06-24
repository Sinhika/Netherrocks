package alexndr.plugins.netherrocks.gui;

import alexndr.api.content.gui.SimpleFurnaceGui;
import alexndr.plugins.netherrocks.inventory.NetherFurnaceContainer;
import alexndr.plugins.netherrocks.tiles.NetherFurnaceTileEntity;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;

/**
 * @author AleXndrTheGr8st
 */
public class NetherFurnaceGui extends SimpleFurnaceGui 
{
    protected static final ResourceLocation netherFurnaceGuiTextures 
    	= new ResourceLocation(alexndr.plugins.netherrocks.ModInfo.ID,
    						   "textures/gui/container/nether_furnace_gui.png");
    
 	public NetherFurnaceGui(InventoryPlayer player, NetherFurnaceTileEntity iinv) 
	{
		super(new NetherFurnaceContainer(player, iinv), netherFurnaceGuiTextures, player, iinv);
	}
	
	public static ResourceLocation getGuiTexture() {
		return netherFurnaceGuiTextures;
	}
 	
} // end class
