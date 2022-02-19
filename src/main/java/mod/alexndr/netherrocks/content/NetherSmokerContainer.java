package mod.alexndr.netherrocks.content;

import mod.alexndr.netherrocks.init.ModContainers;
import mod.alexndr.simplecorelib.content.VeryAbstractFurnaceMenu;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.crafting.RecipeType;

public class NetherSmokerContainer extends VeryAbstractFurnaceMenu
{
     public NetherSmokerContainer(final int windowId, final Inventory playerInventory, final BlockPos pos, Player playerEntity)
    {
        super(ModContainers.NETHER_SMOKER.get(), windowId, pos, playerInventory, playerEntity, RecipeType.SMOKING);
        		
    }

 } // end class
