package mod.alexndr.netherrocks.content.block_entity;

import mod.alexndr.netherrocks.api.content.AbstractNetherFurnaceTileEntity;
import mod.alexndr.netherrocks.content.container.NetherFurnaceContainer;
import mod.alexndr.netherrocks.init.ModTiles;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.block.state.BlockState;

public class NetherFurnaceTileEntity extends AbstractNetherFurnaceTileEntity
{
    private static final String DISPLAY_NAME = "block.netherrocks.nether_furnace";

    public NetherFurnaceTileEntity(BlockPos blockpos, BlockState blockstate)
    {
        super(ModTiles.NETHER_FURNACE.get(),blockpos, blockstate, RecipeType.SMELTING);
    }

    @Override protected Component getDefaultName()
    {
        return Component.translatable(DISPLAY_NAME);
    }

    @Override protected AbstractContainerMenu createMenu(int containerId, Inventory inventory)
    {
        return new NetherFurnaceContainer(containerId, inventory, this, this.dataAccess);
    }
}  // end class NetherFurnaceTileEntity
