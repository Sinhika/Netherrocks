package mod.alexndr.netherrocks.content;

import mod.alexndr.netherrocks.init.ModTiles;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.item.crafting.AbstractCookingRecipe;
import net.minecraft.item.crafting.IRecipeType;
import net.minecraft.tileentity.AbstractFurnaceTileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;

public class NetherFurnaceTileEntity extends AbstractFurnaceTileEntity
{
    public NetherFurnaceTileEntity()
    {
        super(ModTiles.NETHER_FURNACE, IRecipeType.SMELTING);
    }

    @Override
    protected ITextComponent getDefaultName()
    {
        return new TranslationTextComponent("container.nether_furnace");
    }

    @Override
    protected Container createMenu(int id, PlayerInventory player)
    {
        return null;
    }
}  // end class NetherFurnaceTileEntity
