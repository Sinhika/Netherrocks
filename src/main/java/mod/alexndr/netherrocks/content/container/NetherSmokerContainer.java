package mod.alexndr.netherrocks.content.container;

import mod.alexndr.netherrocks.api.content.AbstractNetherFurnaceTileEntity;
import mod.alexndr.netherrocks.init.ModContainers;
import net.minecraft.world.Container;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.AbstractFurnaceMenu;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.inventory.RecipeBookType;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeType;

public class NetherSmokerContainer extends AbstractFurnaceMenu
{
    public NetherSmokerContainer(int pContainerId, Inventory pPlayerInventory)
    {
        super(ModContainers.NETHER_SMOKER.get(), RecipeType.SMOKING, RecipeBookType.SMOKER, pContainerId,
                pPlayerInventory);
    }

    public NetherSmokerContainer(int pContainerId, Inventory pPlayerInventory, Container pFurnaceContainer,
                                  ContainerData pFurnaceData)
    {
        super(ModContainers.NETHER_SMOKER.get(), RecipeType.SMOKING, RecipeBookType.SMOKER, pContainerId,
                pPlayerInventory,
                pFurnaceContainer, pFurnaceData);
    }

    @Override
    protected boolean isFuel(ItemStack stack) {
        return AbstractNetherFurnaceTileEntity.isStaticCustomFuel(stack);
    }

} // end class
