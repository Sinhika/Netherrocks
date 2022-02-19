package mod.alexndr.netherrocks.content;

import mod.alexndr.netherrocks.init.ModContainers;
import mod.alexndr.simplecorelib.content.VeryAbstractFurnaceMenu;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.crafting.RecipeType;

public class NetherBlastFurnaceContainer extends VeryAbstractFurnaceMenu
{
    public NetherBlastFurnaceContainer(final int windowId, final Inventory playerInventory, final BlockPos pos, Player playerEntity)
    {
        super(ModContainers.NETHER_BLAST_FURNACE.get(), windowId, pos, playerInventory, playerEntity, RecipeType.BLASTING); 
    }

} // end class
