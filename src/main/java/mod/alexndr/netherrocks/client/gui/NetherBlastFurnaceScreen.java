package mod.alexndr.netherrocks.client.gui;

import mod.alexndr.netherrocks.Netherrocks;
import mod.alexndr.netherrocks.content.NetherBlastFurnaceContainer;
import mod.alexndr.simplecorelib.client.gui.VeryAbstractFurnaceScreen;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;

public class NetherBlastFurnaceScreen extends VeryAbstractFurnaceScreen<NetherBlastFurnaceContainer>
{
    private final static int name_color =  0x404040;
    private static final ResourceLocation NETHER_FURNACE_GUI_TEXTURES =
        new ResourceLocation(Netherrocks.MODID, "textures/gui/container/nether_furnace_gui.png");

    public NetherBlastFurnaceScreen(final NetherBlastFurnaceContainer container, final PlayerInventory inv, final ITextComponent text)
    {
        super(container, inv, NETHER_FURNACE_GUI_TEXTURES,  text, name_color);
    }
    
}  // end class NetherFurnaceScreen
