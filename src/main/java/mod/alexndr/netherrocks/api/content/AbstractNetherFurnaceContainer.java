package mod.alexndr.netherrocks.api.content;

import mod.alexndr.simplecorelib.content.VeryAbstractFurnaceContainer;
import mod.alexndr.simplecorelib.content.VeryAbstractFurnaceTileEntity;
import net.minecraft.client.network.play.ClientPlayNetHandler;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.inventory.container.Container;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.network.play.server.SWindowPropertyPacket;
import net.minecraft.util.IntReferenceHolder;
import net.minecraftforge.fml.RegistryObject;

/**
 * Smelt time is synced with
 * Server: Each tick {@link #detectAndSendChanges()} is called ({@link ServerPlayerEntity#tick()})
 * Server: The (tracked) value of the tile's energy is updated ({@link #updateProgressBar(int, int)})
 * Server: If the value is different from the value last sent to the client ({@link IntReferenceHolder#isDirty()}),
 * it is synced to the client ({@link ServerPlayerEntity#sendWindowProperty(Container, int, int)})
 * Client: The sync packet is received ({@link ClientPlayNetHandler#handleWindowProperty(SWindowPropertyPacket)})
 * and the tracked value of is updated ({@link Container#updateProgressBar(int, int)})
 * Client: The tile's data is set to the new value
 *
 * @author Sinhika, notes by Cadiboo
 */
public abstract class AbstractNetherFurnaceContainer<T extends AbstractNetherFurnaceBlock> extends VeryAbstractFurnaceContainer<AbstractNetherFurnaceBlock>
{

    public AbstractNetherFurnaceContainer(MenuType<?> containerType, int id, Inventory playerInventory,
            VeryAbstractFurnaceTileEntity tileEntity, RegistryObject<AbstractNetherFurnaceBlock> arg4)
    {
        super(containerType, id, playerInventory, tileEntity, arg4);
    }
}