package mod.alexndr.netherrocks.api.content;

import javax.annotation.Nonnull;

import mod.alexndr.netherrocks.api.helpers.FunctionalIntReferenceHolder;
import mod.alexndr.netherrocks.api.helpers.FurnaceResultSlotItemHandler;
import net.minecraft.client.network.play.ClientPlayNetHandler;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.ContainerType;
import net.minecraft.inventory.container.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketBuffer;
import net.minecraft.network.play.server.SWindowPropertyPacket;
import net.minecraft.util.IWorldPosCallable;
import net.minecraft.util.IntReferenceHolder;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.items.SlotItemHandler;

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
public abstract class AbstractNetherFurnaceContainer<T extends AbstractNetherFurnaceBlock> extends Container
{
    protected RegistryObject<T> my_block; 
    public AbstractNetherFurnaceTileEntity tileEntity;
    protected IWorldPosCallable canInteractWithCallable;
    
    /**
     * Constructor called logical-server-side from {@link MythrilFurnaceTileEntity#createMenu}
     * and logical-client-side from {@link #ModFurnaceContainer(int, PlayerInventory, PacketBuffer)}
     */
    public AbstractNetherFurnaceContainer(ContainerType<?> type, int id, final PlayerInventory playerInventory, 
                                       final AbstractNetherFurnaceTileEntity tileEntity, 
                                       final RegistryObject<T> block)
    {
        super(type, id);
        this.tileEntity = tileEntity;
        this.canInteractWithCallable = IWorldPosCallable.of(tileEntity.getWorld(), tileEntity.getPos());
        this.my_block = block;
        
        // Add tracking for data (Syncs to client/updates value when it changes)
        this.trackInt(new FunctionalIntReferenceHolder(() -> tileEntity.smeltTimeLeft, v -> tileEntity.smeltTimeLeft = (short) v));
        this.trackInt(new FunctionalIntReferenceHolder(() -> tileEntity.maxSmeltTime, v -> tileEntity.maxSmeltTime = (short) v));
        this.trackInt(new FunctionalIntReferenceHolder(() -> tileEntity.fuelBurnTimeLeft, v -> tileEntity.fuelBurnTimeLeft = (short) v));
        this.trackInt(new FunctionalIntReferenceHolder(() -> tileEntity.maxFuelBurnTime, v -> tileEntity.maxFuelBurnTime = (short) v));

        // Tile inventory slot(s)
        this.addSlot(new SlotItemHandler(tileEntity.inventory, AbstractNetherFurnaceTileEntity.FUEL_SLOT, 56, 53));
        this.addSlot(new SlotItemHandler(tileEntity.inventory, AbstractNetherFurnaceTileEntity.INPUT_SLOT, 56, 17));
        this.addSlot(new FurnaceResultSlotItemHandler(playerInventory.player, tileEntity, tileEntity.inventory,
                                                      AbstractNetherFurnaceTileEntity.OUTPUT_SLOT, 116, 35));

        final int playerInventoryStartX = 8;
        final int playerInventoryStartY = 84;
        final int slotSizePlus2 = 18; // slots are 16x16, plus 2 (for spacing/borders) is 18x18

        // Player Top Inventory slots
        for (int row = 0; row < 3; ++row) {
            for (int column = 0; column < 9; ++column) {
                this.addSlot(new Slot(playerInventory, 9 + (row * 9) + column, playerInventoryStartX + (column * slotSizePlus2), playerInventoryStartY + (row * slotSizePlus2)));
            }
        }

        final int playerHotbarY = playerInventoryStartY + slotSizePlus2 * 3 + 4;
        // Player Hotbar slots
        for (int column = 0; column < 9; ++column) {
            this.addSlot(new Slot(playerInventory, column, playerInventoryStartX + (column * slotSizePlus2), playerHotbarY));
        }
    } // end server-side ctor

    /**
     * Generic & dynamic version of {@link Container#transferStackInSlot(PlayerEntity, int)}.
     * Handle when the stack in slot {@code index} is shift-clicked.
     * Normally this moves the stack between the player inventory and the other inventory(s).
     *
     * @param player the player passed in
     * @param index  the index passed in
     * @return the {@link ItemStack}
     */
    @Nonnull
    @Override
    public ItemStack transferStackInSlot(final PlayerEntity player, final int index)
    {
    	ItemStack returnStack = ItemStack.EMPTY;
    	final Slot slot = this.inventorySlots.get(index);
    	if (slot != null && slot.getHasStack()) {
    		final ItemStack slotStack = slot.getStack();
    		returnStack = slotStack.copy();
    
    		final int containerSlots = this.inventorySlots.size() - player.inventory.mainInventory.size();
    		if (index < containerSlots) {
    			if (!mergeItemStack(slotStack, containerSlots, this.inventorySlots.size(), true)) {
    				return ItemStack.EMPTY;
    			}
    		} else if (!mergeItemStack(slotStack, 0, containerSlots, false)) {
    			return ItemStack.EMPTY;
    		}
    		if (slotStack.getCount() == 0) {
    			slot.putStack(ItemStack.EMPTY);
    		} else {
    			slot.onSlotChanged();
    		}
    		if (slotStack.getCount() == returnStack.getCount()) {
    			return ItemStack.EMPTY;
    		}
    		slot.onTake(player, slotStack);
    	}
    	return returnStack;
    }

    @Override
    public boolean canInteractWith(@Nonnull final PlayerEntity player)
    {
    	return isWithinUsableDistance(canInteractWithCallable, player, my_block.get());
    }

}