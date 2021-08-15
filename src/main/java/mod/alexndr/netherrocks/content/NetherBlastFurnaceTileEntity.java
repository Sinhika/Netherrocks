package mod.alexndr.netherrocks.content;

import mod.alexndr.netherrocks.api.content.AbstractNetherFurnaceTileEntity;
import mod.alexndr.netherrocks.init.ModBlocks;
import mod.alexndr.netherrocks.init.ModTiles;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;

public class NetherBlastFurnaceTileEntity extends AbstractNetherFurnaceTileEntity
{

    public NetherBlastFurnaceTileEntity()
    {
        super(ModTiles.NETHER_BLAST_FURNACE.get(), RecipeType.BLASTING);
    }

    @Override
    protected int getBurnDuration(ItemStack fuelstack)
    {
        return super.getBurnDuration(fuelstack)/2;
    }

    @Override
    public Component getDisplayName()
    {
        return new TranslatableComponent(ModBlocks.nether_blast_furnace.get().getDescriptionId());
    }

    @Override
    public AbstractContainerMenu createMenu(int windowId, Inventory inventory, Player player)
    {
        return new NetherBlastFurnaceContainer(windowId, inventory, this);
    }

} // end class
