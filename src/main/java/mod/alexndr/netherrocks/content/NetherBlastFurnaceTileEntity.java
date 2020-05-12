package mod.alexndr.netherrocks.content;

import mod.alexndr.netherrocks.api.content.AbstractNetherFurnaceTileEntity;
import mod.alexndr.netherrocks.init.ModBlocks;
import mod.alexndr.netherrocks.init.ModTiles;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.item.crafting.IRecipeType;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;

public class NetherBlastFurnaceTileEntity extends AbstractNetherFurnaceTileEntity
{

    public NetherBlastFurnaceTileEntity()
    {
        super(ModTiles.NETHER_BLAST_FURNACE.get(), IRecipeType.BLASTING);
        fuelMultiplier = fuelMultiplier / 2.0; // because blast furnace
    }

    @Override
    public ITextComponent getDisplayName()
    {
        return new TranslationTextComponent(ModBlocks.nether_blast_furnace.get().getTranslationKey());
    }

    @Override
    public Container createMenu(int windowId, PlayerInventory inventory, PlayerEntity player)
    {
        return new NetherBlastFurnaceContainer(windowId, inventory, this);
    }

} // end class
