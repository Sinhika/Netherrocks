package mod.alexndr.netherrocks.client.jei;

import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.constants.VanillaRecipeCategoryUid;
import mezz.jei.api.registration.IRecipeCatalystRegistration;
import mod.alexndr.netherrocks.Netherrocks;
import mod.alexndr.netherrocks.init.ModBlocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

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
    public ResourceLocation getPluginUid()
    {
        return ID;
    }

} // end class
