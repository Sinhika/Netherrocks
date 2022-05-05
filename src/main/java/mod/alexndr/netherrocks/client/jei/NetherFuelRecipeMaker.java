package mod.alexndr.netherrocks.client.jei;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.helpers.IJeiHelpers;
import mezz.jei.api.runtime.IIngredientManager;
import mod.alexndr.netherrocks.api.content.AbstractNetherFurnaceTileEntity;
import net.minecraft.world.item.ItemStack;

public final class NetherFuelRecipeMaker
{
	private static final Logger LOGGER = LogManager.getLogger();

	private NetherFuelRecipeMaker() {}

	public static List<NetherFurnaceFuelRecipe> getFuelRecipes(IIngredientManager ingredientManager, IJeiHelpers helpers) 
	{
		Collection<ItemStack> allItemStacks = ingredientManager.getAllIngredients(VanillaTypes.ITEM);
		List<NetherFurnaceFuelRecipe> fuelRecipes = new ArrayList<>();
		for (ItemStack stack : allItemStacks) 
		{
			int burnTime = getBurnTime(stack);
			if (burnTime > 0) {
				fuelRecipes.add(new NetherFurnaceFuelRecipe(Collections.singleton(stack), burnTime));
			}
		}
		return fuelRecipes;
	} // end getFuelRecipes()

	private static int getBurnTime(ItemStack itemStack) 
	{
		try {
			return AbstractNetherFurnaceTileEntity.getBurnTime(itemStack, null);
		} 
		catch (RuntimeException | LinkageError e) 
		{
			String itemStackInfo = itemStack.toString();
			LOGGER.error("Failed to check if item is fuel {}.", itemStackInfo, e);
			return 0;
		}
	} // end getBurnTime
	
} // end class
