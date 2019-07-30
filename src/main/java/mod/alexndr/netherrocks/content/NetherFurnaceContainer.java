package mod.alexndr.netherrocks.content;

import mod.alexndr.netherrocks.init.ModContainers;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.inventory.container.AbstractFurnaceContainer;
import net.minecraft.inventory.container.ContainerType;
import net.minecraft.item.crafting.AbstractCookingRecipe;
import net.minecraft.item.crafting.IRecipeType;
import net.minecraft.util.IIntArray;
import net.minecraft.util.IntArray;

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
}  // end class NetherFurnaceContainer
