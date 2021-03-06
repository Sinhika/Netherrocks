package mod.alexndr.netherrocks.content;

import java.util.Objects;

import mod.alexndr.netherrocks.api.content.AbstractNetherFurnaceContainer;
import mod.alexndr.netherrocks.init.ModBlocks;
import mod.alexndr.netherrocks.init.ModContainers;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.ContainerType;
import net.minecraft.network.PacketBuffer;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.fml.network.IContainerFactory;

public class NetherSmokerContainer extends AbstractNetherFurnaceContainer<NetherSmokerBlock>
{
    /**
    * Logical-client-side constructor, called from {@link ContainerType#create(IContainerFactory)}
    * Calls the logical-server-side constructor with the TileEntity at the pos in the PacketBuffer
    */
   public NetherSmokerContainer(final int windowId, final PlayerInventory playerInventory, final PacketBuffer data) 
   {
       this(windowId, playerInventory, getTileEntity(playerInventory, data));
   }

    public NetherSmokerContainer(int id, PlayerInventory playerInventory, 
                                 NetherSmokerTileEntity tileEntity)
    {
        super(ModContainers.NETHER_SMOKER.get(), id, playerInventory, tileEntity, ModBlocks.nether_smoker);
    }

    private static NetherSmokerTileEntity getTileEntity(final PlayerInventory playerInventory, final PacketBuffer data) 
    {
        Objects.requireNonNull(playerInventory, "playerInventory cannot be null!");
        Objects.requireNonNull(data, "data cannot be null!");
        final TileEntity tileAtPos = playerInventory.player.level.getBlockEntity(data.readBlockPos());
        if (tileAtPos instanceof NetherSmokerTileEntity)
            return (NetherSmokerTileEntity) tileAtPos;
        throw new IllegalStateException("Tile entity is not correct! " + tileAtPos);
    }
    
} // end class
