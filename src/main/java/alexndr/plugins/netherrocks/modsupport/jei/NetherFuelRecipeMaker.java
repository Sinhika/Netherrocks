package alexndr.plugins.netherrocks.modsupport.jei;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import alexndr.plugins.netherrocks.tiles.NetherFurnaceTileEntity;
import mezz.jei.api.IGuiHelper;
import mezz.jei.api.IJeiHelpers;
import mezz.jei.api.recipe.IStackHelper;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

public final class NetherFuelRecipeMaker 
{
	private NetherFuelRecipeMaker() {}

	public static List<NetherFuelRecipe> getFuelRecipes(IJeiHelpers helpers) 
	{
		IGuiHelper guiHelper = helpers.getGuiHelper();
		IStackHelper stackHelper = helpers.getStackHelper();
		List<ItemStack> fuelStacks = NetherFurnaceTileEntity.getFuels();

		Set<String> oreDictNames = new HashSet<String>();
		List<NetherFuelRecipe> fuelRecipes = new ArrayList<NetherFuelRecipe>(fuelStacks.size());
		
		for (ItemStack fuelStack : fuelStacks) 
		{
			if (fuelStack == null) {
				continue;
			}

			int[] oreIDs = OreDictionary.getOreIDs(fuelStack);
			if (oreIDs.length > 0) {
				for (int oreID : oreIDs) {
					String name = OreDictionary.getOreName(oreID);
					if (oreDictNames.contains(name)) {
						continue;
					}

					oreDictNames.add(name);
					List<ItemStack> oreDictFuels = OreDictionary.getOres(name);
					List<ItemStack> oreDictFuelsSet = stackHelper.getAllSubtypes(oreDictFuels);
					removeNoBurnTime(oreDictFuelsSet);
					if (oreDictFuels.isEmpty()) {
						continue;
					}
					int burnTime = getBurnTime(oreDictFuels.get(0));

					fuelRecipes.add(new NetherFuelRecipe(guiHelper, oreDictFuelsSet, burnTime));
				}
			}  // end-if
			else {
				List<ItemStack> fuels = stackHelper.getSubtypes(fuelStack);
				removeNoBurnTime(fuels);
				if (fuels.isEmpty()) {
					continue;
				}
				int burnTime = getBurnTime(fuels.get(0));
				fuelRecipes.add(new NetherFuelRecipe(guiHelper, fuels, burnTime));
			} // end-else
		} // end-for
		
		return fuelRecipes;
	} // end getFuelRecipes()
	
	private static void removeNoBurnTime(List<ItemStack> itemStacks) 
	{
		Iterator<ItemStack> iterator = itemStacks.iterator();
		while (iterator.hasNext()) {
			ItemStack itemStack = iterator.next();
			if (getBurnTime(itemStack) == 0) {
				iterator.remove();
			}
		}
	} // end removeNoBurnTime()

	private static int getBurnTime(ItemStack itemStack) 
	{
		return NetherFurnaceTileEntity.getItemBurnTime(itemStack);
	}	
} // end-class
