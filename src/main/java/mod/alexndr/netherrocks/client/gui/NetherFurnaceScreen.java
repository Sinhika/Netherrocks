package mod.alexndr.netherrocks.client.gui;

import mod.alexndr.netherrocks.Netherrocks;
import mod.alexndr.netherrocks.content.NetherFurnaceContainer;
import net.minecraft.client.gui.screens.inventory.AbstractFurnaceScreen;
import net.minecraft.client.gui.screens.recipebook.SmeltingRecipeBookComponent;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;

public class NetherFurnaceScreen extends AbstractFurnaceScreen<NetherFurnaceContainer>
{
	private final static int name_color =  0x0ffffff;
    private static final ResourceLocation LIT_PROGRESS_SPRITE = new ResourceLocation("container/furnace/lit_progress");
    private static final ResourceLocation BURN_PROGRESS_SPRITE = new ResourceLocation("container/furnace/burn_progress");

    //private final static int name_color =  0x404040;
    private static final ResourceLocation NETHER_FURNACE_GUI_TEXTURES =
        new ResourceLocation(Netherrocks.MODID, "textures/gui/container/nether_furnace_gui.png");

    public NetherFurnaceScreen(NetherFurnaceContainer container, Inventory inv, Component text)
    {
        super(container, new SmeltingRecipeBookComponent(), inv, text, NETHER_FURNACE_GUI_TEXTURES, LIT_PROGRESS_SPRITE,
                BURN_PROGRESS_SPRITE);
    }
    
}  // end class NetherFurnaceScreen
