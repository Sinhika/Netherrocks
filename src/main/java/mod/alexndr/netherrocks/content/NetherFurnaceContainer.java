package mod.alexndr.netherrocks.content;

import mod.alexndr.netherrocks.init.ModContainers;
import mod.alexndr.simplecorelib.content.VeryAbstractFurnaceMenu;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraftforge.fmllegacy.network.IContainerFactory;


public class NetherFurnaceContainer extends VeryAbstractFurnaceMenu
{
     /**
     * Logical-client-side constructor, called from {@link ContainerType#create(IContainerFactory)}
     * Calls the logical-server-side constructor with the TileEntity at the pos in the PacketBuffer
     */
    public NetherFurnaceContainer(final int windowId, final Inventory playerInventory, final FriendlyByteBuf data) 
    {
    	super(ModContainers.NETHER_FURNACE.get(), RecipeType.SMELTING, windowId, playerInventory);
    }

    /**
     * Constructor called logical-server-side from {@link NetherFurnaceTileEntity#createMenu}
     * and logical-client-side from {@link #NetherFurnaceContainer(int, PlayerInventory, PacketBuffer)}
     */
    public NetherFurnaceContainer(final int windowId, final Inventory playerInventory, final NetherFurnaceTileEntity tileEntity) 
    {
        super(ModContainers.NETHER_FURNACE.get(), RecipeType.SMELTING, windowId, playerInventory, tileEntity.inventory,
        		tileEntity.dataAccess, tileEntity);

     } // end server-side ctor


}  // end class NetherFurnaceContainer
