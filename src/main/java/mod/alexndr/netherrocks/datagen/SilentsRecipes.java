package mod.alexndr.netherrocks.datagen;

import java.util.function.Consumer;

import mod.alexndr.netherrocks.Netherrocks;
import mod.alexndr.netherrocks.config.NetherrocksConfig;
import mod.alexndr.netherrocks.init.ModItems;
import mod.alexndr.simplecorelib.datagen.ISimpleConditionBuilder;
import mod.alexndr.simplecorelib.datagen.RecipeSetBuilder;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.crafting.conditions.ICondition;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

public class SilentsRecipes extends RecipeProvider implements ISimpleConditionBuilder, IConditionBuilder
{
    private RecipeSetBuilder setbuilder;

    public SilentsRecipes(DataGenerator generatorIn)
    {
        super(generatorIn);
        setbuilder = new RecipeSetBuilder(Netherrocks.MODID);
    }

    @Override
    protected void buildCraftingRecipes(Consumer<FinishedRecipe> consumer)
    {
        registerFurnaceRecipes(consumer);
    } // end registerRecipes()

    private void registerFurnaceRecipes(Consumer<FinishedRecipe> consumer)
    {
        setbuilder.buildOre2IngotRecipes(consumer, 
                Ingredient.of(ModItems.argonite_dust.get().asItem()), ModItems.argonite_ingot.get(),
                has(ModItems.argonite_dust.get().asItem()), 0.7F, 200, "_from_dust");
        setbuilder.buildOre2IngotRecipes(consumer, 
                Ingredient.of(ModItems.fyrite_dust.get().asItem()), ModItems.fyrite_ingot.get(),
                has(ModItems.fyrite_dust.get().asItem()), 0.8F, 200, "_from_dust");
        setbuilder.buildOre2IngotRecipes(consumer, 
                Ingredient.of(ModItems.illumenite_dust.get().asItem()), ModItems.illumenite_ingot.get(),
                has(ModItems.illumenite_dust.get().asItem()), 0.8F, 200, "_from_dust");
        setbuilder.buildOre2IngotRecipes(consumer, 
                Ingredient.of(ModItems.malachite_dust.get().asItem()), ModItems.malachite_ingot.get(),
                has(ModItems.malachite_dust.get().asItem()), 0.5F, 200, "_from_dust");
        
        setbuilder.buildOre2IngotRecipes(consumer, 
                Ingredient.of(ModItems.crushed_argonite_ore.get().asItem()), ModItems.argonite_ingot.get(),
                has(ModItems.crushed_argonite_ore.get().asItem()), 0.7F, 200, "_from_chunks");
        setbuilder.buildOre2IngotRecipes(consumer, 
                Ingredient.of(ModItems.crushed_fyrite_ore.get().asItem()), ModItems.fyrite_ingot.get(),
                has(ModItems.crushed_fyrite_ore.get().asItem()), 0.8F, 200, "_from_chunks");
        setbuilder.buildOre2IngotRecipes(consumer, 
                Ingredient.of(ModItems.crushed_illumenite_ore.get().asItem()), ModItems.illumenite_ingot.get(),
                has(ModItems.crushed_illumenite_ore.get().asItem()), 0.8F, 200, "_from_chunks");
        setbuilder.buildOre2IngotRecipes(consumer, 
                Ingredient.of(ModItems.crushed_malachite_ore.get().asItem()), ModItems.malachite_ingot.get(),
                has(ModItems.crushed_malachite_ore.get().asItem()), 0.5F, 200, "_from_chunks");
   } // end registerFurnaceRecipes()
    
    @Override
    public ICondition flag(String name)
    {
        return impl_flag(Netherrocks.MODID, NetherrocksConfig.INSTANCE, name);
    }

} // end class
