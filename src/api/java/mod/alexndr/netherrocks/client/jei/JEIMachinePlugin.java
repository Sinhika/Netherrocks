package mod.alexndr.netherrocks.client.jei;

import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.constants.RecipeTypes;
import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.helpers.IJeiHelpers;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.registration.IGuiHandlerRegistration;
import mezz.jei.api.registration.IRecipeCatalystRegistration;
import mezz.jei.api.registration.IRecipeCategoryRegistration;
import mezz.jei.api.registration.IRecipeRegistration;
import mezz.jei.api.registration.IRecipeTransferRegistration;
import mezz.jei.api.runtime.IIngredientManager;
import mod.alexndr.netherrocks.Netherrocks;
import mod.alexndr.netherrocks.client.gui.NetherBlastFurnaceScreen;
import mod.alexndr.netherrocks.client.gui.NetherFurnaceScreen;
import mod.alexndr.netherrocks.client.gui.NetherSmokerScreen;
import mod.alexndr.netherrocks.content.container.NetherBlastFurnaceContainer;
import mod.alexndr.netherrocks.content.container.NetherFurnaceContainer;
import mod.alexndr.netherrocks.content.container.NetherSmokerContainer;
import mod.alexndr.netherrocks.init.ModBlocks;
import mod.alexndr.netherrocks.init.ModContainers;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;

@JeiPlugin
public class JEIMachinePlugin implements IModPlugin 
{
    private static final ResourceLocation ID = new ResourceLocation(Netherrocks.MODID, "nether_furnace_plugin");
    
    /**
     * Nether furnace fuel recipe type.
     */
    public static final RecipeType<NetherFurnaceFuelRecipe>  NETHER_FUEL = RecipeType.create(Netherrocks.MODID,
			"nether_fuel", NetherFurnaceFuelRecipe.class);
    
    
    /**
     * Register recipe catalysts.
     * Recipe Catalysts are ingredients that are needed in order to craft other things.
     * Vanilla examples of Recipe Catalysts are the Crafting Table and Furnace.
     */
    @Override
    public void registerRecipeCatalysts(IRecipeCatalystRegistration registry)
    {
        registry.addRecipeCatalyst(new ItemStack(ModBlocks.nether_furnace.get()), RecipeTypes.SMELTING);
        registry.addRecipeCatalyst(new ItemStack(ModBlocks.nether_blast_furnace.get()), RecipeTypes.BLASTING);
        registry.addRecipeCatalyst(new ItemStack(ModBlocks.nether_smoker.get()), RecipeTypes.SMOKING);
    }

    
    @Override
	public void registerCategories(IRecipeCategoryRegistration registration)
	{
		IJeiHelpers jeiHelpers = registration.getJeiHelpers();
		IGuiHelper guiHelper = jeiHelpers.getGuiHelper();
		
    	registration.addRecipeCategories(new NetherFuelCategory(guiHelper));
	}


	@Override
	public void registerRecipes(IRecipeRegistration registration)
	{
		IJeiHelpers jeiHelpers = registration.getJeiHelpers();
		IIngredientManager ingredientManager = registration.getIngredientManager();
		registration.addRecipes(NETHER_FUEL, NetherFuelRecipeMaker.getFuelRecipes(ingredientManager, jeiHelpers)); 
		registration.addIngredientInfo(new ItemStack(ModBlocks.nether_furnace.get().asItem()), VanillaTypes.ITEM_STACK, 
		        Component.translatable("netherrocks.nether_furnace.info"));
        registration.addIngredientInfo(new ItemStack(ModBlocks.nether_blast_furnace.get().asItem()), VanillaTypes.ITEM_STACK, 
                Component.translatable("netherrocks.nether_blast_furnace.info"));
        registration.addIngredientInfo(new ItemStack(ModBlocks.nether_smoker.get().asItem()), VanillaTypes.ITEM_STACK, 
                Component.translatable("netherrocks.nether_smoker.info"));
	}


	@Override
	public void registerRecipeTransferHandlers(IRecipeTransferRegistration registration)
	{
		registration.addRecipeTransferHandler(NetherFurnaceContainer.class, ModContainers.NETHER_FURNACE.get(), RecipeTypes.SMELTING, 0, 1, 3, 36);
		registration.addRecipeTransferHandler(NetherFurnaceContainer.class, ModContainers.NETHER_FURNACE.get(), NETHER_FUEL, 1, 1, 3, 36);
		registration.addRecipeTransferHandler(NetherSmokerContainer.class, ModContainers.NETHER_SMOKER.get(), RecipeTypes.SMOKING, 0, 1, 3, 36);
		registration.addRecipeTransferHandler(NetherSmokerContainer.class, ModContainers.NETHER_SMOKER.get(), NETHER_FUEL, 1, 1, 3, 36);
		registration.addRecipeTransferHandler(NetherBlastFurnaceContainer.class, ModContainers.NETHER_BLAST_FURNACE.get(), RecipeTypes.BLASTING, 0, 1, 3, 36);
		registration.addRecipeTransferHandler(NetherBlastFurnaceContainer.class, ModContainers.NETHER_BLAST_FURNACE.get(), NETHER_FUEL, 1, 1, 3, 36);
	}

	@Override
	public void registerGuiHandlers(IGuiHandlerRegistration registration)
	{
		registration.addRecipeClickArea(NetherFurnaceScreen.class, 78, 32, 28, 23, RecipeTypes.SMELTING, NETHER_FUEL);
		registration.addRecipeClickArea(NetherSmokerScreen.class, 78, 32, 28, 23, RecipeTypes.SMOKING, NETHER_FUEL);
		registration.addRecipeClickArea(NetherBlastFurnaceScreen.class, 78, 32, 28, 23, RecipeTypes.BLASTING, NETHER_FUEL);
	}

	@Override
    public ResourceLocation getPluginUid()
    {
        return ID;
    }

} // end class
