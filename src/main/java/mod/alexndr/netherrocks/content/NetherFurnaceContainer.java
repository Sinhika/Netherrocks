package mod.alexndr.netherrocks.content;

import mod.alexndr.netherrocks.init.ModContainers;
import net.minecraft.world.Container;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.AbstractFurnaceMenu;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.inventory.RecipeBookType;
import net.minecraft.world.item.crafting.RecipeType;


public class NetherFurnaceContainer extends AbstractFurnaceMenu
{

    public NetherFurnaceContainer(int pContainerId, Inventory pPlayerInventory)
    {
        super(ModContainers.NETHER_FURNACE.get(), RecipeType.SMELTING, RecipeBookType.FURNACE, pContainerId,
                pPlayerInventory);
    }

    public NetherFurnaceContainer(int pContainerId, Inventory pPlayerInventory, Container pFurnaceContainer,
                                  ContainerData pFurnaceData)
    {
        super(ModContainers.NETHER_FURNACE.get(), RecipeType.SMELTING, RecipeBookType.FURNACE, pContainerId,
                pPlayerInventory,
                pFurnaceContainer, pFurnaceData);
    }

}  // end class NetherFurnaceContainer
