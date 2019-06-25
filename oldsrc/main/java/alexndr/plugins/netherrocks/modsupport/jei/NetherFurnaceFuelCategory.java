package alexndr.plugins.netherrocks.modsupport.jei;

import javax.annotation.Nullable;

import alexndr.api.helpers.game.Translator;
import alexndr.plugins.netherrocks.ModInfo;
import mezz.jei.api.IGuiHelper;
import mezz.jei.api.gui.IDrawable;
import mezz.jei.api.gui.IGuiItemStackGroup;
import mezz.jei.api.gui.IRecipeLayout;
import mezz.jei.api.ingredients.IIngredients;
import mezz.jei.api.recipe.IRecipeWrapper;
import net.minecraft.util.ResourceLocation;

public class NetherFurnaceFuelCategory extends NetherFurnaceRecipeCategory<NetherFuelRecipe> 
{
	public static final String UID = "netherrocks.netherfurnace.fuel";
	
	private final IDrawable background;
	private final IDrawable flame2;
	private final String localizedName;

	public NetherFurnaceFuelCategory(IGuiHelper guiHelper) 
	{
		super(guiHelper);
		background = guiHelper.drawableBuilder(backgroundLocation, 55, 38, 18, 32).build();

		ResourceLocation recipeBackgroundResource = new ResourceLocation(JEI_Constants.RESOURCE_DOMAIN, 
				JEI_Constants.TEXTURE_RECIPE_BACKGROUND_PATH);
		flame2 = guiHelper.createDrawable(recipeBackgroundResource, 215, 0, 14, 14);
		localizedName = Translator.translateToLocal("gui.jei.category.fuel");
	} // end ctor()

	@Override
	public String getUid() {
		return NetherFurnaceFuelCategory.UID;
	}

	@Override
	public String getTitle() {
		return localizedName;
	}

	@Override
	public String getModName() {
		return ModInfo.NAME;
	}

	@Override
	public IDrawable getBackground() {
		return background;
	}
	
	@Nullable
	@Override
	public IDrawable getIcon() {
		return flame2;
	}

	@Override
	public void setRecipe(IRecipeLayout recipeLayout, IRecipeWrapper recipeWrapper, 
			IIngredients ingredients) 
	{
		IGuiItemStackGroup guiItemStacks = recipeLayout.getItemStacks();
		guiItemStacks.init(fuelSlot, true, 0, 14);
		guiItemStacks.set(ingredients);
	}

} // end class