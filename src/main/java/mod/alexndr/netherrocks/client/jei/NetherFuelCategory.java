package mod.alexndr.netherrocks.client.jei;

import com.mojang.blaze3d.vertex.PoseStack;

import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.drawable.IDrawableAnimated;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.RecipeType;
import mod.alexndr.netherrocks.Netherrocks;
import mod.alexndr.simplecorelib.api.client.jei.VeryAbstractFurnaceVariantCategory;
import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.resources.ResourceLocation;

public class NetherFuelCategory extends VeryAbstractFurnaceVariantCategory<NetherFurnaceFuelRecipe>
{
	public static final ResourceLocation UID = new ResourceLocation(Netherrocks.MODID, "nether_furnace_fuel");
	
	public NetherFuelCategory(IGuiHelper guiHelper) 
	{
		super(guiHelper);
		localizedName = new TranslatableComponent("gui.netherrocks.category.fuel");
	} // end ctor


	@Override
    public RecipeType<NetherFurnaceFuelRecipe> getRecipeType()
    {
        return JEIMachinePlugin.NETHER_FUEL;
    }


    @Override
	public ResourceLocation getUid()
	{
		return UID;
	}


	@Override
	public Class<? extends NetherFurnaceFuelRecipe> getRecipeClass()
	{
		return NetherFurnaceFuelRecipe.class;
	}



	@Override
    public void setRecipe(IRecipeLayoutBuilder builder, NetherFurnaceFuelRecipe recipe, IFocusGroup focuses)
    {
	    super.setRecipe(builder, recipe, focuses);
	    builder.addSlot(RecipeIngredientRole.INPUT, 1, 17).addItemStacks(recipe.getInputs());
    }


	@Override
	public void draw(NetherFurnaceFuelRecipe recipe, PoseStack poseStack, double mouseX, double mouseY) 
	{
		IDrawableAnimated flame = this.getFlame();
		flame.draw(poseStack, 1, 0);
		Minecraft minecraft = Minecraft.getInstance();
		this.smeltCountText = createSmeltCountText(recipe.getBurnTime());
		minecraft.font.draw(poseStack, smeltCountText, 24, 13, 0xFF808080);
	}

} // end class
