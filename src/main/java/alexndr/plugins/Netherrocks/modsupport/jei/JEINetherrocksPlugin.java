package alexndr.plugins.Netherrocks.modsupport.jei;

import alexndr.plugins.Netherrocks.Content;
import mezz.jei.api.BlankModPlugin;
import mezz.jei.api.IGuiHelper;
import mezz.jei.api.IJeiHelpers;
import mezz.jei.api.IModRegistry;
import mezz.jei.api.JEIPlugin;
import mezz.jei.api.recipe.IRecipeCategoryRegistration;
import mezz.jei.api.recipe.VanillaRecipeCategoryUid;
import net.minecraft.item.ItemStack;

@JEIPlugin
public class JEINetherrocksPlugin extends BlankModPlugin 
{

	@Override
	public void register(IModRegistry registry) 
	{
		final IJeiHelpers jeiHelpers = registry.getJeiHelpers();
		
		registry.addRecipes(NetherFuelRecipeMaker.getFuelRecipes(jeiHelpers), 
							NetherFurnaceFuelCategory.UID);
        registry.addRecipeCatalyst(new ItemStack(Content.nether_furnace), 
        							VanillaRecipeCategoryUid.SMELTING,
        							NetherFurnaceFuelCategory.UID);
	}

	@Override
	public void registerCategories(IRecipeCategoryRegistration registry) 
	{
		super.registerCategories(registry);
		final IJeiHelpers jeiHelpers = registry.getJeiHelpers();
		final IGuiHelper guiHelper = jeiHelpers.getGuiHelper();
		registry.addRecipeCategories(new NetherFurnaceFuelCategory(guiHelper));
	} // end registerCategories()


} // end class
