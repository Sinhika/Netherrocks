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

public class NetherSmokerContainer extends AbstractNetherFurnaceContainer<NetherSmokerBlock>
{
    /**
    * Logical-client-side constructor, called from {@link ContainerType#create(IContainerFactory)}
    * Calls the logical-server-side constructor with the TileEntity at the pos in the PacketBuffer
    */
   public NetherSmokerContainer(final int windowId, final Inventory playerInventory, final FriendlyByteBuf data) 
   {
       this(windowId, playerInventory, getTileEntity(playerInventory, data));
   }

    public NetherSmokerContainer(int id, Inventory playerInventory, 
                                 NetherSmokerTileEntity tileEntity)
    {
        super(ModContainers.NETHER_SMOKER.get(), id, playerInventory, tileEntity, ModBlocks.nether_smoker);
    }

    private static NetherSmokerTileEntity getTileEntity(final Inventory playerInventory, final FriendlyByteBuf data) 
    {
        Objects.requireNonNull(playerInventory, "playerInventory cannot be null!");
        Objects.requireNonNull(data, "data cannot be null!");
        final BlockEntity tileAtPos = playerInventory.player.level.getBlockEntity(data.readBlockPos());
        if (tileAtPos instanceof NetherSmokerTileEntity)
            return (NetherSmokerTileEntity) tileAtPos;
        throw new IllegalStateException("Tile entity is not correct! " + tileAtPos);
    }
    
} // end class
