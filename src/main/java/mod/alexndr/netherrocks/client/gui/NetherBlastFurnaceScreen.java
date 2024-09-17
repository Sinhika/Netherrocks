package mod.alexndr.netherrocks.client.gui;

import mod.alexndr.netherrocks.Netherrocks;
import mod.alexndr.netherrocks.content.NetherBlastFurnaceContainer;
import mod.alexndr.simplecorelib.api.client.gui.SomewhatAbstractFurnaceScreen;
import net.minecraft.client.gui.screens.recipebook.BlastingRecipeBookComponent;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;

public class NetherBlastFurnaceScreen extends SomewhatAbstractFurnaceScreen<NetherBlastFurnaceContainer>
{
    private final static int name_color =  0x0ffffff;
    private static final ResourceLocation NETHER_FURNACE_GUI_TEXTURES =
        new ResourceLocation(Netherrocks.MODID, "textures/gui/container/nether_furnace_gui.png");
    private static final ResourceLocation LIT_PROGRESS_SPRITE = new ResourceLocation("container/blast_furnace/lit_progress");
    private static final ResourceLocation BURN_PROGRESS_SPRITE = new ResourceLocation("container/blast_furnace/burn_progress");

    public NetherBlastFurnaceScreen(final NetherBlastFurnaceContainer container, final Inventory inv, final Component text)
    {
        super(container, new BlastingRecipeBookComponent(), inv, text, NETHER_FURNACE_GUI_TEXTURES, LIT_PROGRESS_SPRITE,
                BURN_PROGRESS_SPRITE );
    }
    
}  // end class NetherFurnaceScreen
