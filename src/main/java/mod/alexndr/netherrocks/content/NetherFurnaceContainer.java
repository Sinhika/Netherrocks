package mod.alexndr.netherrocks.content;

import java.util.Objects;

import mod.alexndr.netherrocks.api.content.AbstractNetherFurnaceContainer;
import mod.alexndr.netherrocks.init.ModBlocks;
import mod.alexndr.netherrocks.init.ModContainers;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.inventory.container.ContainerType;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraftforge.fml.network.IContainerFactory;


public class NetherFurnaceContainer extends AbstractNetherFurnaceContainer<NetherFurnaceBlock>
{
     /**
     * Logical-client-side constructor, called from {@link ContainerType#create(IContainerFactory)}
     * Calls the logical-server-side constructor with the TileEntity at the pos in the PacketBuffer
     */
    public NetherFurnaceContainer(final int windowId, final Inventory playerInventory, final FriendlyByteBuf data) 
    {
        this(windowId, playerInventory, getTileEntity(playerInventory, data));
    }

    /**
     * Constructor called logical-server-side from {@link NetherFurnaceTileEntity#createMenu}
     * and logical-client-side from {@link #NetherFurnaceContainer(int, PlayerInventory, PacketBuffer)}
     */
    public NetherFurnaceContainer(final int windowId, final Inventory playerInventory, final NetherFurnaceTileEntity tileEntity) 
    {
        super(ModContainers.NETHER_FURNACE.get(), windowId, playerInventory, tileEntity, ModBlocks.nether_furnace);

     } // end server-side ctor

    private static NetherFurnaceTileEntity getTileEntity(final Inventory playerInventory, final FriendlyByteBuf data) {
        Objects.requireNonNull(playerInventory, "playerInventory cannot be null!");
        Objects.requireNonNull(data, "data cannot be null!");
        final BlockEntity tileAtPos = playerInventory.player.level.getBlockEntity(data.readBlockPos());
        if (tileAtPos instanceof NetherFurnaceTileEntity)
            return (NetherFurnaceTileEntity) tileAtPos;
        throw new IllegalStateException("Tile entity is not correct! " + tileAtPos);
    }

}  // end class NetherFurnaceContainer
