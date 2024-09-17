package mod.alexndr.netherrocks.content;

import mod.alexndr.netherrocks.api.content.AbstractNetherFurnaceTileEntity;
import mod.alexndr.netherrocks.init.ModTiles;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.block.state.BlockState;

public class NetherBlastFurnaceTileEntity extends AbstractNetherFurnaceTileEntity
{
    private static final String DISPLAY_NAME = "block.netherrocks.nether_blast_furnace";

    public NetherBlastFurnaceTileEntity(BlockPos blockpos, BlockState blockstate)
    {
        super(ModTiles.NETHER_BLAST_FURNACE.get(), blockpos, blockstate, RecipeType.BLASTING);
    }

    @Override protected Component getDefaultName()
    {
        return Component.translatable(DISPLAY_NAME);
    }

    @Override protected AbstractContainerMenu createMenu(int containerId, Inventory inventory)
    {
        return new NetherBlastFurnaceContainer(containerId, inventory, this, this.dataAccess);
    }


    @Override
    protected int getBurnDuration(ItemStack fuelstack)
    {
        return super.getBurnDuration(fuelstack)/2;
    }

} // end class
