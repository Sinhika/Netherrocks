package mod.alexndr.netherrocks.content;

import javax.annotation.Nonnull;

import mod.alexndr.netherrocks.api.content.AbstractNetherFurnaceTileEntity;
import mod.alexndr.netherrocks.init.ModBlocks;
import mod.alexndr.netherrocks.init.ModTiles;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraftforge.fml.network.NetworkHooks;

public class NetherFurnaceTileEntity extends AbstractNetherFurnaceTileEntity
{
    public NetherFurnaceTileEntity()
    {
        super(ModTiles.NETHER_FURNACE.get(), RecipeType.SMELTING);
    }

    @Nonnull
    @Override
    public Component getDisplayName() {
        return new TranslatableComponent(ModBlocks.nether_furnace.get().getDescriptionId());
    }

    /**
     * Called from {@link NetworkHooks#openGui}
     * (which is called from {@link ElectricFurnaceBlock#onBlockActivated} on the logical server)
     *
     * @return The logical-server-side Container for this TileEntity
     */
    @Nonnull
    @Override
    public AbstractContainerMenu createMenu(final int windowId, final Inventory inventory, final Player player) 
    {
        return new NetherFurnaceContainer(windowId, inventory, this);
    }

    
    
}  // end class NetherFurnaceTileEntity
