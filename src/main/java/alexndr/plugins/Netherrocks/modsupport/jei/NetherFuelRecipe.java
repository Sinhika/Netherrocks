package alexndr.plugins.Netherrocks.modsupport.jei;

import java.util.Collection;

import mezz.jei.api.IGuiHelper;
import mezz.jei.api.ingredients.IIngredients;
import mezz.jei.plugins.vanilla.furnace.FuelRecipe;
import net.minecraft.item.ItemStack;

public class NetherFuelRecipe extends FuelRecipe {

	public NetherFuelRecipe(IGuiHelper guiHelper, Collection<ItemStack> input, int burnTime) 
	{
		super(guiHelper, input, burnTime);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void getIngredients(IIngredients ingredients) 
	{
		super.getIngredients(ingredients);
		// TODO Auto-generated method stub
	}

} // end class
