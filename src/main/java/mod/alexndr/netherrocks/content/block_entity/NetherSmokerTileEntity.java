package mod.alexndr.netherrocks.content.block_entity;

import mod.alexndr.netherrocks.api.content.AbstractNetherFurnaceTileEntity;
import mod.alexndr.netherrocks.content.container.NetherSmokerContainer;
import mod.alexndr.netherrocks.init.ModTiles;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.block.state.BlockState;

public class NetherSmokerTileEntity extends AbstractNetherFurnaceTileEntity
{
    private static final String DISPLAY_NAME = "block.netherrocks.nether_smoker";

    public NetherSmokerTileEntity(BlockPos blockpos, BlockState blockstate)
    {
        super(ModTiles.NETHER_SMOKER.get(), blockpos, blockstate, RecipeType.SMOKING);
    }

    
    @Override
    protected int getBurnDuration(ItemStack fuelstack)
    {
        return super.getBurnDuration(fuelstack)/2;
    }

    @Override protected Component getDefaultName()
    {
        return Component.translatable(DISPLAY_NAME);
    }

    @Override protected AbstractContainerMenu createMenu(int containerId, Inventory inventory)
    {
        return new NetherSmokerContainer(containerId, inventory, this, this.dataAccess);
    }
} // end class
