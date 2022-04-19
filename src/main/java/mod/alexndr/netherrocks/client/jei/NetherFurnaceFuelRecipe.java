package mod.alexndr.netherrocks.client.jei;

import java.util.Collection;

import mod.alexndr.simplecorelib.client.jei.AlternateFuelRecipe;
import net.minecraft.world.item.ItemStack;

public class NetherFurnaceFuelRecipe extends AlternateFuelRecipe
{

    public NetherFurnaceFuelRecipe(Collection<ItemStack> input, int burnTime)
    {
        super(input, burnTime);
        BURN_TIME_STANDARD = 100;
    }

} // end class
