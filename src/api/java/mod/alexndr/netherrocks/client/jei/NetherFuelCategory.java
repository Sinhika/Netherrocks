package mod.alexndr.netherrocks.client.jei;

import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.drawable.IDrawableAnimated;
import mezz.jei.api.gui.ingredient.IRecipeSlotsView;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.RecipeType;
import mod.alexndr.netherrocks.Netherrocks;
import mod.alexndr.simplecorelib.api.client.jei.VeryAbstractFurnaceVariantCategory;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;

public class NetherFuelCategory extends VeryAbstractFurnaceVariantCategory<NetherFurnaceFuelRecipe>
{
	public static final ResourceLocation UID = new ResourceLocation(Netherrocks.MODID, "nether_furnace_fuel");
	
	public NetherFuelCategory(IGuiHelper guiHelper) 
	{
		super(guiHelper);
		localizedName = Component.translatable("gui.netherrocks.category.fuel");
	} // end ctor


	@Override
    public RecipeType<NetherFurnaceFuelRecipe> getRecipeType()
    {
        return JEIMachinePlugin.NETHER_FUEL;
    }


 	@Override
    public void setRecipe(IRecipeLayoutBuilder builder, NetherFurnaceFuelRecipe recipe, IFocusGroup focuses)
    {
	    super.setRecipe(builder, recipe, focuses);
	    builder.addSlot(RecipeIngredientRole.INPUT, 1, 17).addItemStacks(recipe.getInputs());
    }

	@Override
	public void draw(NetherFurnaceFuelRecipe recipe,  IRecipeSlotsView recipeSlotsView,  GuiGraphics guiGraphics, double mouseX, double mouseY) 
	{
		IDrawableAnimated flame = this.getFlame();
		flame.draw(guiGraphics, 1, 0);
		drawCookTime(recipe, guiGraphics, 24, 13);
	}

	protected void drawCookTime(NetherFurnaceFuelRecipe recipe, GuiGraphics guiGraphics, int x, int y) 
	{
		this.smeltCountText = createSmeltCountText(recipe.getBurnTime());
		Minecraft minecraft = Minecraft.getInstance();
		Font fontRenderer = minecraft.font;
		int stringWidth = fontRenderer.width(smeltCountText);
		guiGraphics.drawString(fontRenderer, smeltCountText, getWidth() - stringWidth, y, 0xFF808080, false);
	}


} // end class
