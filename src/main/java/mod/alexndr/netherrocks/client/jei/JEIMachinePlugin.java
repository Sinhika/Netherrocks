package mod.alexndr.netherrocks.client.jei;

import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.constants.VanillaRecipeCategoryUid;
import mezz.jei.api.registration.IGuiHandlerRegistration;
import mezz.jei.api.registration.IRecipeCatalystRegistration;
import mezz.jei.api.registration.IRecipeTransferRegistration;
import mod.alexndr.netherrocks.Netherrocks;
import mod.alexndr.netherrocks.client.gui.NetherBlastFurnaceScreen;
import mod.alexndr.netherrocks.client.gui.NetherFurnaceScreen;
import mod.alexndr.netherrocks.client.gui.NetherSmokerScreen;
import mod.alexndr.netherrocks.content.NetherBlastFurnaceContainer;
import mod.alexndr.netherrocks.content.NetherFurnaceContainer;
import mod.alexndr.netherrocks.content.NetherSmokerContainer;
import mod.alexndr.netherrocks.init.ModBlocks;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;

@JeiPlugin
public class JEIMachinePlugin implements IModPlugin 
{
    private static final ResourceLocation ID = new ResourceLocation(Netherrocks.MODID, "main");

    /**
     * Register recipe catalysts.
     * Recipe Catalysts are ingredients that are needed in order to craft other things.
     * Vanilla examples of Recipe Catalysts are the Crafting Table and Furnace.
     */
    @Override
    public void registerRecipeCatalysts(IRecipeCatalystRegistration registry)
    {
        registry.addRecipeCatalyst(new ItemStack(ModBlocks.nether_furnace.get()), 
                VanillaRecipeCategoryUid.FURNACE);
        registry.addRecipeCatalyst(new ItemStack(ModBlocks.nether_blast_furnace.get()), 
                VanillaRecipeCategoryUid.BLASTING);
        registry.addRecipeCatalyst(new ItemStack(ModBlocks.nether_smoker.get()), 
                VanillaRecipeCategoryUid.SMOKING);
    }

    @Override
	public void registerRecipeTransferHandlers(IRecipeTransferRegistration registration)
	{
		registration.addRecipeTransferHandler(NetherFurnaceContainer.class, VanillaRecipeCategoryUid.FURNACE, 0, 1, 3, 36);
		//registration.addRecipeTransferHandler(NetherFurnaceContainer.class, VanillaRecipeCategoryUid.FUEL, 1, 1, 3, 36);
		registration.addRecipeTransferHandler(NetherSmokerContainer.class, VanillaRecipeCategoryUid.SMOKING, 0, 1, 3, 36);
		//registration.addRecipeTransferHandler(NetherSmokerContainer.class, VanillaRecipeCategoryUid.FUEL, 1, 1, 3, 36);
		registration.addRecipeTransferHandler(NetherBlastFurnaceContainer.class, VanillaRecipeCategoryUid.BLASTING, 0, 1, 3, 36);
		//registration.addRecipeTransferHandler(NetherBlastFurnaceContainer.class, VanillaRecipeCategoryUid.FUEL, 1, 1, 3, 36);
	}

	@Override
	public void registerGuiHandlers(IGuiHandlerRegistration registration)
	{
		registration.addRecipeClickArea(NetherFurnaceScreen.class, 78, 32, 28, 23, VanillaRecipeCategoryUid.FURNACE);
		registration.addRecipeClickArea(NetherSmokerScreen.class, 78, 32, 28, 23, VanillaRecipeCategoryUid.SMOKING);
		registration.addRecipeClickArea(NetherBlastFurnaceScreen.class, 78, 32, 28, 23, VanillaRecipeCategoryUid.BLASTING);
	}

	@Override
    public ResourceLocation getPluginUid()
    {
        return ID;
    }

} // end class
