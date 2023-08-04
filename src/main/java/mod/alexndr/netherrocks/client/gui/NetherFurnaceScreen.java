package mod.alexndr.netherrocks.client.gui;

import mod.alexndr.netherrocks.Netherrocks;
import mod.alexndr.netherrocks.content.NetherFurnaceContainer;
import mod.alexndr.simplecorelib.api.client.gui.VeryAbstractFurnaceScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;

public class NetherFurnaceScreen extends VeryAbstractFurnaceScreen<NetherFurnaceContainer>
{
	private final static int name_color =  0x0ffffff;
    //private final static int name_color =  0x404040;
    private static final ResourceLocation NETHER_FURNACE_GUI_TEXTURES =
        new ResourceLocation(Netherrocks.MODID, "textures/gui/container/nether_furnace_gui.png");

    public NetherFurnaceScreen(final NetherFurnaceContainer container, final Inventory inv, final Component text)
    {
        super(container, inv, NETHER_FURNACE_GUI_TEXTURES,  text, name_color);
    }
    
}  // end class NetherFurnaceScreen
