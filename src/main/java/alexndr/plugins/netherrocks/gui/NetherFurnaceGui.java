package alexndr.plugins.netherrocks.gui;

import alexndr.plugins.netherrocks.inventory.NetherFurnaceContainer;
import alexndr.plugins.netherrocks.tiles.NetherFurnaceTileEntity;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;

/**
 * @author AleXndrTheGr8st
 */
public class NetherFurnaceGui extends GuiContainer 
{
    protected static final ResourceLocation furnaceGuiTextures 
    	= new ResourceLocation(alexndr.plugins.netherrocks.ModInfo.ID,
    						   "textures/gui/container/nether_furnace_gui.png");
    
    protected final InventoryPlayer playerInv;
    private NetherFurnaceTileEntity tileFurnace;

	public NetherFurnaceGui(InventoryPlayer player, NetherFurnaceTileEntity iinv) 
	{
		super(new NetherFurnaceContainer(player, iinv));
        this.playerInv = player;
        this.tileFurnace = iinv;
	}
	
	public static ResourceLocation getGuiTexture() {
		return furnaceGuiTextures;
	}
	
    @Override
	protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY) 
    {
        String s = this.tileFurnace.getDisplayName().getUnformattedText();
        this.fontRenderer.drawString(s, this.xSize / 2 - this.fontRenderer.getStringWidth(s) / 2, 6, 4210752);
        this.fontRenderer.drawString(this.playerInv.getDisplayName().getUnformattedText(), 8, this.ySize - 96 + 2, 4210752);
    }

	@Override
	protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) 
	{
		GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
		this.mc.getTextureManager().bindTexture(furnaceGuiTextures);
		int k = (this.width - this.xSize) / 2;
		int l = (this.height - this.ySize) / 2;
		this.drawTexturedModalRect(k, l, 0, 0, this.xSize, this.ySize);
		int i1;

		if (tileFurnace.isBurning()) 
		{
			i1 = tileFurnace.getScaledBurnTime(13);
			this.drawTexturedModalRect(k + 56, l + 36 + 12 - i1, 176, 12 - i1, 14, i1 + 1);
		}

		i1 = tileFurnace.getScaledCookProgress(24);
		this.drawTexturedModalRect(k + 79, l + 34, 176, 14, i1 + 1, 16);
	} // end ()
	
} // end class
