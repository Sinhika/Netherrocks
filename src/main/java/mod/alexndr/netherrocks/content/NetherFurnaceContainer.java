package mod.alexndr.netherrocks.content;

import mod.alexndr.netherrocks.init.ModContainers;
import mod.alexndr.simplecorelib.content.VeryAbstractFurnaceMenu;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.crafting.RecipeType;


public class NetherFurnaceContainer extends VeryAbstractFurnaceMenu
{
    /**
     * Constructor called logical-server-side from {@link NetherFurnaceTileEntity#createMenu}
     * and logical-client-side from {@link #NetherFurnaceContainer(int, PlayerInventory, PacketBuffer)}
     */
    public NetherFurnaceContainer(final int windowId, final Inventory playerInventory, final BlockPos pos, Player playerEntity) 
    {
        super(ModContainers.NETHER_FURNACE.get(),windowId, pos,  playerInventory, playerEntity, RecipeType.SMELTING);
     } // end server-side ctor


}  // end class NetherFurnaceContainer
