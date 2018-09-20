package alexndr.plugins.netherrocks.modsupport.jei;

import java.awt.Color;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import com.google.common.base.Preconditions;

import alexndr.api.helpers.game.Translator;
import mezz.jei.api.IGuiHelper;
import mezz.jei.api.gui.IDrawableAnimated;
import mezz.jei.api.ingredients.IIngredients;
import mezz.jei.api.recipe.IRecipeWrapper;
import net.minecraft.client.Minecraft;
import net.minecraft.item.ItemStack;

/**
 * cut & paste from jei vanilla.FuelRecipe class, because the vanilla plugin isn't part of the API.
 * @author Sinhika
 *
 */
public class NetherFuelRecipe implements IRecipeWrapper 
{
	private final List<List<ItemStack>> inputs;
	private final String smeltCountString;
	private final IDrawableAnimated flame;


	public NetherFuelRecipe(IGuiHelper guiHelper, Collection<ItemStack> input, int burnTime) 
	{
		Preconditions.checkArgument(burnTime > 0, "burn time must be greater than 0");
		List<ItemStack> inputList = new ArrayList<>(input);
		this.inputs = Collections.singletonList(inputList);

		if (burnTime == 200) {
			this.smeltCountString = Translator.translateToLocal("gui.jei.category.fuel.smeltCount.single");
		} else {
			NumberFormat numberInstance = NumberFormat.getNumberInstance();
			numberInstance.setMaximumFractionDigits(2);
			String smeltCount = numberInstance.format(burnTime / 200f);
			this.smeltCountString = Translator.translateToLocalFormatted("gui.jei.category.fuel.smeltCount", smeltCount);
		}

		this.flame = guiHelper.drawableBuilder(JEI_Constants.RECIPE_GUI_VANILLA, 82, 114, 14, 14)
			.buildAnimated(burnTime, IDrawableAnimated.StartDirection.TOP, true);
	}

	@Override
	public void getIngredients(IIngredients ingredients) {
		ingredients.setInputLists(ItemStack.class, inputs);
	}

	@Override
	public void drawInfo(Minecraft minecraft, int recipeWidth, int recipeHeight, int mouseX, int mouseY) {
		flame.draw(minecraft, 1, 0);
		minecraft.fontRenderer.drawString(smeltCountString, 24, 13, Color.gray.getRGB());
	}

} // end class
