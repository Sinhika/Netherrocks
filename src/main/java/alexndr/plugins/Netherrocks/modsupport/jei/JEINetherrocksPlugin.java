package alexndr.plugins.Netherrocks.modsupport.jei;

import alexndr.plugins.Netherrocks.Content;
import mezz.jei.api.BlankModPlugin;
import mezz.jei.api.IModRegistry;
import mezz.jei.api.JEIPlugin;
import mezz.jei.api.recipe.VanillaRecipeCategoryUid;
import net.minecraft.item.ItemStack;

@JEIPlugin
public class JEINetherrocksPlugin extends BlankModPlugin 
{

	@Override
	public void register(IModRegistry registry) 
	{
        registry.addRecipeCatalyst(new ItemStack(Content.nether_furnace), 
        							VanillaRecipeCategoryUid.SMELTING);
	}


} // end class
