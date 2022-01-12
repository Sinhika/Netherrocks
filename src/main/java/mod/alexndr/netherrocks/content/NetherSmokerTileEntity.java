package mod.alexndr.netherrocks.content;

import mod.alexndr.netherrocks.api.content.AbstractNetherFurnaceTileEntity;
import mod.alexndr.netherrocks.init.ModBlocks;
import mod.alexndr.netherrocks.init.ModTiles;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.block.state.BlockState;

public class NetherSmokerTileEntity extends AbstractNetherFurnaceTileEntity
{

    public NetherSmokerTileEntity(BlockPos blockpos, BlockState blockstate)
    {
        super(ModTiles.NETHER_SMOKER.get(), blockpos, blockstate, RecipeType.SMOKING);
    }

    
    @Override
    protected int getBurnDuration(ItemStack fuelstack)
    {
        return super.getBurnDuration(fuelstack)/2;
    }


    @Override
    public Component getDefaultName()
    {
        return new TranslatableComponent(ModBlocks.nether_smoker.get().getDescriptionId());
    }

    @Override
    public AbstractContainerMenu createMenu(int windowId, Inventory inventory)
    {
        return new NetherSmokerContainer(windowId, inventory, this);
    }

} // end class
