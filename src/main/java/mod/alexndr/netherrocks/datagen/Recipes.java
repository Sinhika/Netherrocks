package mod.alexndr.netherrocks.datagen;

import java.util.function.Consumer;

import mod.alexndr.netherrocks.Netherrocks;
import mod.alexndr.netherrocks.config.NetherrocksConfig;
import mod.alexndr.netherrocks.init.ModBlocks;
import mod.alexndr.netherrocks.init.ModItems;
import mod.alexndr.simplecorelib.datagen.ISimpleConditionBuilder;
import mod.alexndr.simplecorelib.datagen.RecipeSetBuilder;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.crafting.conditions.ICondition;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

public class Recipes extends RecipeProvider implements IConditionBuilder, ISimpleConditionBuilder
{
    private RecipeSetBuilder setbuilder;
    
	public Recipes(DataGenerator generatorIn)
	{
		super(generatorIn);
        setbuilder = new RecipeSetBuilder(Netherrocks.MODID);
	}

    protected void buildCraftingRecipes(Consumer<FinishedRecipe> consumer)
    {
        registerStorageRecipes(consumer);
//        registerMiscRecipes(consumer);
//        registerToolRecipes(consumer);
//        registerArmorRecipes(consumer);
        registerFurnaceRecipes(consumer);
        registerAestheticRecipes(consumer);
    } // end registerRecipes() 
	
    
    protected void registerAestheticRecipes(Consumer<FinishedRecipe> consumer)
    {
    	setbuilder.buildSimpleAestheticBlocks(consumer, Ingredient.of(ModItems.argonite_ingot.get()), "argonite", 
 			has(ModItems.argonite_ingot.get()), flag("aesthetics_enabled"));
    	setbuilder.buildSimpleAestheticBlocks(consumer, Ingredient.of(ModItems.ashstone_gem.get()), "ashstone", 
 			has(ModItems.ashstone_gem.get()), flag("aesthetics_enabled"));
    	setbuilder.buildSimpleAestheticBlocks(consumer, Ingredient.of(ModItems.dragonstone_gem.get()), "dragonstone", 
 			has(ModItems.dragonstone_gem.get()), flag("aesthetics_enabled"));
    	setbuilder.buildSimpleAestheticBlocks(consumer, Ingredient.of(ModItems.fyrite_ingot.get()), "fyrite", 
 			has(ModItems.fyrite_ingot.get()), flag("aesthetics_enabled"));
    	setbuilder.buildSimpleAestheticBlocks(consumer, Ingredient.of(ModItems.illumenite_ingot.get()), "illumenite", 
 			has(ModItems.illumenite_ingot.get()), flag("aesthetics_enabled"));
    	setbuilder.buildSimpleAestheticBlocks(consumer, Ingredient.of(ModItems.malachite_ingot.get()), "malachite", 
 			has(ModItems.malachite_ingot.get()), flag("aesthetics_enabled"));
    }
    
    protected void registerStorageRecipes(Consumer<FinishedRecipe> consumer)
    {
        setbuilder.buildSimpleStorageRecipes(consumer, ModItems.raw_fyrite.get(), 
        		ModBlocks.raw_fyrite_block.get(), null, has(ModItems.raw_fyrite.get()));
        setbuilder.buildSimpleStorageRecipes(consumer, ModItems.raw_illumenite.get(), 
        		ModBlocks.raw_illumenite_block.get(), null, has(ModItems.raw_illumenite.get()));
        setbuilder.buildSimpleStorageRecipes(consumer, ModItems.raw_argonite.get(), 
        		ModBlocks.raw_argonite_block.get(), null, has(ModItems.raw_argonite.get()));
        setbuilder.buildSimpleStorageRecipes(consumer, ModItems.raw_malachite.get(), 
        		ModBlocks.raw_malachite_block.get(), null, has(ModItems.raw_malachite.get()));
    }
    
    protected void registerFurnaceRecipes(Consumer<FinishedRecipe> consumer)
    {
        setbuilder.buildOre2IngotRecipes(consumer, Ingredient.of(ModItems.raw_fyrite.get()), ModItems.fyrite_ingot.get(), 
                has(ModItems.raw_fyrite.get()), 0.8F, 200);
        setbuilder.buildOre2IngotRecipes(consumer, Ingredient.of(ModItems.raw_illumenite.get()), ModItems.illumenite_ingot.get(), 
                has(ModItems.raw_illumenite.get()), 0.8F, 200);
        setbuilder.buildOre2IngotRecipes(consumer, Ingredient.of(ModItems.raw_argonite.get()), ModItems.argonite_ingot.get(), 
                has(ModItems.raw_argonite.get()), 0.7F, 200);
        setbuilder.buildOre2IngotRecipes(consumer, Ingredient.of(ModItems.raw_malachite.get()), ModItems.malachite_ingot.get(), 
                has(ModItems.raw_malachite.get()), 0.5F, 200);
        
        setbuilder.buildOre2IngotRecipes(consumer, Ingredient.of(ModBlocks.fyrite_ore.get()), ModItems.fyrite_ingot.get(), 
                has(ModBlocks.fyrite_ore.get()), 0.8F, 200, "_from_ore");
        setbuilder.buildOre2IngotRecipes(consumer, Ingredient.of(ModBlocks.illumenite_ore.get()), ModItems.illumenite_ingot.get(), 
                has(ModBlocks.illumenite_ore.get()), 0.8F, 200, "_from_ore");
        setbuilder.buildOre2IngotRecipes(consumer, Ingredient.of(ModBlocks.argonite_ore.get()), ModItems.argonite_ingot.get(), 
                has(ModBlocks.argonite_ore.get()), 0.7F, 200, "_from_ore");
        setbuilder.buildOre2IngotRecipes(consumer, Ingredient.of(ModBlocks.malachite_ore.get()), ModItems.malachite_ingot.get(), 
                has(ModBlocks.malachite_ore.get()), 0.5F, 200, "_from_ore");
    }
    
	@Override
	public ICondition flag(String arg0)
	{
		return impl_flag(Netherrocks.MODID, NetherrocksConfig.INSTANCE, arg0);
	}

} // end class
