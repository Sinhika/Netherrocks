package mod.alexndr.netherrocks.content;

import mod.alexndr.netherrocks.init.ModContainers;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.container.AbstractFurnaceContainer;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipeType;
import net.minecraft.util.IIntArray;

public class NetherFurnaceContainer extends AbstractFurnaceContainer
{
    public NetherFurnaceContainer( int p_i50103_3_, PlayerInventory p_i50103_4_)
    {
        super(ModContainers.NETHER_FURNACE, IRecipeType.SMELTING, p_i50103_3_, p_i50103_4_);
    }

    public NetherFurnaceContainer( int p_i50104_3_, PlayerInventory p_i50104_4_, IInventory p_i50104_5_, IIntArray p_i50104_6_)
    {
        super(ModContainers.NETHER_FURNACE, IRecipeType.SMELTING, p_i50104_3_, p_i50104_4_, p_i50104_5_,
              p_i50104_6_);
    }

    @Override
    protected boolean isFuel(ItemStack p_217058_1_)
    {
        return NetherFurnaceTileEntity.isFuel(p_217058_1_);
    }
}  // end class NetherFurnaceContainer
