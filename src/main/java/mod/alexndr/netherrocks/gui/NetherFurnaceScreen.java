package mod.alexndr.netherrocks.gui;

import com.mojang.blaze3d.platform.GlStateManager;

import mod.alexndr.netherrocks.Netherrocks;
import mod.alexndr.netherrocks.content.NetherFurnaceContainer;
import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.AbstractFurnaceContainer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class NetherFurnaceScreen extends ContainerScreen<NetherFurnaceContainer>
{
    private static final ResourceLocation NETHER_FURNACE_GUI_TEXTURES =
        new ResourceLocation(Netherrocks.MODID, "textures/gui/container/nether_furnace_gui.png");

    public NetherFurnaceScreen(NetherFurnaceContainer container, PlayerInventory inv, ITextComponent text)
    {
        super(container, inv, text);
    }

	@Override
	protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) 
	{
	      GlStateManager.color4f(1.0F, 1.0F, 1.0F, 1.0F);
	      this.minecraft.getTextureManager().bindTexture(NetherFurnaceScreen.NETHER_FURNACE_GUI_TEXTURES);
	      int i = this.guiLeft;
	      int j = this.guiTop;
	      this.blit(i, j, 0, 0, this.xSize, this.ySize);
	      if (((AbstractFurnaceContainer)this.container).func_217061_l()) {
	         int k = ((AbstractFurnaceContainer)this.container).getBurnLeftScaled();
	         this.blit(i + 56, j + 36 + 12 - k, 176, 12 - k, 14, k + 1);
	      }

	      int l = ((AbstractFurnaceContainer)this.container).getCookProgressionScaled();
	      this.blit(i + 79, j + 34, 176, 14, l + 1, 16);
	}

	@Override
	protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY) 
	{
		String s = this.title.getFormattedText();
		this.font.drawString(s, (float) (this.xSize / 2 - this.font.getStringWidth(s) / 2), 6.0F, 4210752);
		this.font.drawString(this.playerInventory.getDisplayName().getFormattedText(), 8.0F,
				(float) (this.ySize - 96 + 2), 4210752);
	}

    
}  // end class NetherFurnaceScreen
