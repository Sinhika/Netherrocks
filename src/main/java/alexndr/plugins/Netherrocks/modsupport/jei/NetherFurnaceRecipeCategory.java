package alexndr.plugins.Netherrocks.modsupport.jei;

import alexndr.plugins.Netherrocks.gui.NetherFurnaceGui;
import mezz.jei.api.IGuiHelper;
import mezz.jei.api.gui.IDrawableAnimated;
import mezz.jei.api.gui.IDrawableStatic;
import mezz.jei.api.recipe.IRecipeCategory;
import mezz.jei.api.recipe.IRecipeWrapper;
import net.minecraft.util.ResourceLocation;

public abstract class NetherFurnaceRecipeCategory<T extends IRecipeWrapper> implements IRecipeCategory<IRecipeWrapper> 
{
	protected static final int inputSlot = 0;
	protected static final int fuelSlot = 1;
	protected static final int outputSlot = 2;

	protected final ResourceLocation backgroundLocation;
	protected final IDrawableAnimated flame;
	protected final IDrawableAnimated arrow;
	
	public NetherFurnaceRecipeCategory(IGuiHelper guiHelper) 
	{
		backgroundLocation = new ResourceLocation(NetherFurnaceGui.getGuiTexture().toString());

		IDrawableStatic flameDrawable = guiHelper.createDrawable(backgroundLocation, 176, 0, 14, 14);
		flame = guiHelper.createAnimatedDrawable(flameDrawable, 300, IDrawableAnimated.StartDirection.TOP, true);

		IDrawableStatic arrowDrawable = guiHelper.createDrawable(backgroundLocation, 176, 14, 24, 17);
		this.arrow = guiHelper.createAnimatedDrawable(arrowDrawable, 200, IDrawableAnimated.StartDirection.LEFT, false);
		
	} // end ctor

} // end class
