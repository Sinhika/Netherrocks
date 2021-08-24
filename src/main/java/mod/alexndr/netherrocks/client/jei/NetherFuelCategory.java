package mod.alexndr.netherrocks.client.jei;

import com.mojang.blaze3d.vertex.PoseStack;

import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.gui.IRecipeLayout;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.gui.drawable.IDrawableAnimated;
import mezz.jei.api.gui.drawable.IDrawableStatic;
import mezz.jei.api.gui.ingredient.IGuiItemStackGroup;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.ingredients.IIngredients;
import mod.alexndr.netherrocks.Netherrocks;
import mod.alexndr.netherrocks.api.jei.AlternateFuelRecipe;
import mod.alexndr.netherrocks.api.jei.IconDrawable;
import mod.alexndr.netherrocks.api.jei.VeryAbstractFurnaceVariantCategory;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.resources.ResourceLocation;

public class NetherFuelCategory extends VeryAbstractFurnaceVariantCategory<AlternateFuelRecipe>
{
	public static final ResourceLocation UID = new ResourceLocation(Netherrocks.MODID, "nether_furnace_fuel");
	
	private final IDrawableStatic background;
	private final IDrawableStatic flameTransparentBackground;
	private final ResourceLocation flameSpriteResource = new ResourceLocation(Netherrocks.MODID, "textures/gui/flame");
	
	private final Component localizedName;


	public NetherFuelCategory(IGuiHelper guiHelper) 
	{
		super(guiHelper);

		// width of the recipe depends on the text, which is different in each language
		Minecraft minecraft = Minecraft.getInstance();
		Font fontRenderer = minecraft.font;
		Component smeltCountText = AlternateFuelRecipe.createSmeltCountText(100000);
		int stringWidth = fontRenderer.width(smeltCountText.getString());

		background = guiHelper.drawableBuilder(VeryAbstractFurnaceVariantCategory.RECIPE_GUI_VANILLA, 0, 134, 18, 34)
			.addPadding(0, 0, 0, stringWidth + 20)
			.build();

		flameTransparentBackground = new IconDrawable(flameSpriteResource, 14, 14);
		localizedName = new TranslatableComponent("gui.jei.category.fuel");
	} // end ctor


	@Override
	public ResourceLocation getUid()
	{
		return UID;
	}


	@Override
	public Class<? extends AlternateFuelRecipe> getRecipeClass()
	{
		return AlternateFuelRecipe.class;
	}


	@Override
	public Component getTitle()
	{
		return localizedName;
	}


	@Override
	public IDrawable getBackground()
	{
		return background;
	}


	@Override
	public IDrawable getIcon()
	{
		return flameTransparentBackground;
	}


	@Override
	public void setIngredients(AlternateFuelRecipe recipe, IIngredients ingredients)
	{
		ingredients.setInputs(VanillaTypes.ITEM, recipe.getInputs());
	}


	@Override
	public void setRecipe(IRecipeLayout recipeLayout, AlternateFuelRecipe recipe, IIngredients ingredients)
	{
		IGuiItemStackGroup guiItemStacks = recipeLayout.getItemStacks();

		guiItemStacks.init(fuelSlot, true, 0, 16);
		guiItemStacks.set(ingredients);
	}

	@Override
	public void draw(AlternateFuelRecipe recipe, PoseStack poseStack, double mouseX, double mouseY) {
		IDrawableAnimated flame = recipe.getFlame();
		flame.draw(poseStack, 1, 0);
		Minecraft minecraft = Minecraft.getInstance();
		Component smeltCountText = recipe.getSmeltCountText();
		minecraft.font.draw(poseStack, smeltCountText, 24, 13, 0xFF808080);
	}

} // end class
