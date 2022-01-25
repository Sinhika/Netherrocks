package mod.alexndr.netherrocks.content;

import mod.alexndr.netherrocks.init.ModContainers;
import mod.alexndr.simplecorelib.content.VeryAbstractFurnaceMenu;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraftforge.network.IContainerFactory;

public class NetherSmokerContainer extends VeryAbstractFurnaceMenu
{
    /**
    * Logical-client-side constructor, called from {@link ContainerType#create(IContainerFactory)}
    * Calls the logical-server-side constructor with the TileEntity at the pos in the PacketBuffer
    */
   public NetherSmokerContainer(final int windowId, final Inventory playerInventory, final FriendlyByteBuf data) 
   {
	   super(ModContainers.NETHER_SMOKER.get(), RecipeType.SMOKING, windowId, playerInventory);
   }

    public NetherSmokerContainer(int id, Inventory playerInventory, NetherSmokerTileEntity tileEntity)
    {
        super(ModContainers.NETHER_SMOKER.get(), RecipeType.SMOKING, id, playerInventory, 
        		tileEntity.inventory, tileEntity.dataAccess, tileEntity);
    }

 } // end class
