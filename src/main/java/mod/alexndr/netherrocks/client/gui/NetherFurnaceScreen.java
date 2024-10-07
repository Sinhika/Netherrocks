package mod.alexndr.netherrocks.client.gui;

import mod.alexndr.netherrocks.Netherrocks;
import mod.alexndr.netherrocks.content.container.NetherFurnaceContainer;
import mod.alexndr.simplecorelib.api.client.gui.SomewhatAbstractFurnaceScreen;
import net.minecraft.client.gui.screens.recipebook.SmeltingRecipeBookComponent;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;

public class NetherFurnaceScreen extends SomewhatAbstractFurnaceScreen<NetherFurnaceContainer>
{
//	private final static int name_color =  0x0ffffff;
  //private final static int name_color =  0x404040;
    private static final ResourceLocation NETHER_FURNACE_GUI_TEXTURES =
        new ResourceLocation(Netherrocks.MODID, "textures/gui/container/nether_furnace_gui.png");

    public NetherFurnaceScreen(NetherFurnaceContainer container, Inventory inv, Component text)
    {
        super(container, new SmeltingRecipeBookComponent(), inv, text, NETHER_FURNACE_GUI_TEXTURES);
    }
    
}  // end class NetherFurnaceScreen
