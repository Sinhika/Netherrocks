package mod.alexndr.netherrocks.content;

import mod.alexndr.netherrocks.init.ModContainers;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.container.AbstractFurnaceContainer;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipeType;
import net.minecraft.util.IIntArray;

public class NetherFurnaceContainer extends AbstractFurnaceContainer
{
    public NetherFurnaceContainer( int id, PlayerInventory playerInv)
    {
        super(ModContainers.NETHER_FURNACE, IRecipeType.SMELTING, id, playerInv);
    }

    public NetherFurnaceContainer( int id, PlayerInventory playerInv, IInventory iinv, IIntArray fields)
    {
        super(ModContainers.NETHER_FURNACE, IRecipeType.SMELTING, id, playerInv, iinv, fields);
    }

    @Override
    protected boolean isFuel(ItemStack fuelStack)
    {
        return NetherFurnaceTileEntity.isFuel(fuelStack);
    }
}  // end class NetherFurnaceContainer
