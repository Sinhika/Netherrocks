package mod.alexndr.netherrocks.gui;

import mod.alexndr.netherrocks.Netherrocks;
import mod.alexndr.netherrocks.content.NetherFurnaceContainer;
import net.minecraft.client.gui.screen.inventory.AbstractFurnaceScreen;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class NetherFurnaceScreen extends AbstractFurnaceScreen<NetherFurnaceContainer>
{
    private static final ResourceLocation NETHER_FURNACE_GUI_TEXTURES =
        new ResourceLocation(Netherrocks.MODID, "textures/gui/container/nether_furnace_gui.png");

    public NetherFurnaceScreen(NetherFurnaceContainer container, PlayerInventory inv,
                               ITextComponent text)
    {
        super(container, new NetherFurnaceRecipeGui(), inv, text, NETHER_FURNACE_GUI_TEXTURES);
    }

}  // end class NetherFurnaceScreen
