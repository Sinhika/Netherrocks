package mod.alexndr.netherrocks.content;

import mod.alexndr.netherrocks.api.content.AbstractNetherFurnaceTileEntity;
import mod.alexndr.netherrocks.init.ModBlocks;
import mod.alexndr.netherrocks.init.ModTiles;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipeType;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;

public class NetherSmokerTileEntity extends AbstractNetherFurnaceTileEntity
{

    public NetherSmokerTileEntity()
    {
        super(ModTiles.NETHER_SMOKER.get(), IRecipeType.SMOKING);
    }

    
    @Override
    protected int getBurnDuration(ItemStack fuelstack)
    {
        return super.getBurnDuration(fuelstack)/2;
    }


    @Override
    public ITextComponent getDisplayName()
    {
        return new TranslationTextComponent(ModBlocks.nether_smoker.get().getDescriptionId());
    }

    @Override
    public Container createMenu(int windowId, PlayerInventory inventory, PlayerEntity player)
    {
        return new NetherSmokerContainer(windowId, inventory, this);
    }

} // end class
