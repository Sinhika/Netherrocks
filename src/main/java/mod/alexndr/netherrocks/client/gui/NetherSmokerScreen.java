package mod.alexndr.netherrocks.client.gui;

import mod.alexndr.netherrocks.Netherrocks;
import mod.alexndr.netherrocks.content.NetherSmokerContainer;
import mod.alexndr.simplecorelib.client.gui.VeryAbstractFurnaceScreen;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;

public class NetherSmokerScreen extends VeryAbstractFurnaceScreen<NetherSmokerContainer>
{
    private final static int name_color =  0x404040;
    private static final ResourceLocation NETHER_FURNACE_GUI_TEXTURES =
        new ResourceLocation(Netherrocks.MODID, "textures/gui/container/nether_furnace_gui.png");

    public NetherSmokerScreen(NetherSmokerContainer screenContainer, Inventory inv, Component titleIn)
    {
        super(screenContainer, inv, NETHER_FURNACE_GUI_TEXTURES, titleIn, name_color);
    }

} // end class
