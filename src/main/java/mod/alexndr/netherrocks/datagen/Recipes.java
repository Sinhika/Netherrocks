package mod.alexndr.netherrocks.datagen;

import java.util.function.Consumer;

import mod.alexndr.netherrocks.Netherrocks;
import mod.alexndr.netherrocks.config.NetherrocksConfig;
import mod.alexndr.netherrocks.init.ModBlocks;
import mod.alexndr.netherrocks.init.ModItems;
import mod.alexndr.simplecorelib.api.datagen.ISimpleConditionBuilder;
import mod.alexndr.simplecorelib.api.datagen.RecipeSetBuilder;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.crafting.ConditionalRecipe;
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

    @Override
    protected void buildCraftingRecipes(Consumer<FinishedRecipe> consumer)
    {
        registerStorageRecipes(consumer);
        registerMiscRecipes(consumer);
        registerToolRecipes(consumer);
        registerArmorRecipes(consumer);
        registerFurnaceRecipes(consumer);
        registerAestheticRecipes(consumer);
    } // end registerRecipes() 
	
    
    protected void registerMiscRecipes(Consumer<FinishedRecipe> consumer)
    {
    	// nether furnace recipes
        ShapedRecipeBuilder.shaped(ModBlocks.nether_furnace.get())
	        .define('S', Blocks.NETHERRACK)
	        .define('Y', Items.FLINT_AND_STEEL)
	        .pattern("SSS")
	        .pattern("SYS")
	        .pattern("SSS")
	        .unlockedBy("has_item", has(Blocks.NETHERRACK))
	        .save(consumer);
        
        ShapedRecipeBuilder.shaped(ModBlocks.nether_smoker.get())
	        .define('#', ItemTags.LOGS)
	        .define('X', ModBlocks.nether_furnace.get())
	        .pattern(" # ")
	        .pattern("#X#")
	        .pattern(" # ")
	        .unlockedBy("has_item", has(ModBlocks.nether_furnace.get()))
	        .save(consumer);
       
        ShapedRecipeBuilder.shaped(ModBlocks.nether_blast_furnace.get())
	        .define('#', Items.NETHER_BRICK)
	        .define('I', Items.IRON_INGOT)
	        .define('X', ModBlocks.nether_furnace.get())
	        .pattern("III")
	        .pattern("IXI")
	        .pattern("###")
	        .unlockedBy("has_item", has(ModBlocks.nether_furnace.get()))
	        .save(consumer);
        
        ResourceLocation recipe_name = setbuilder.make_resource("ghast_tears_from_ashstone_ore");
        ConditionalRecipe.builder().addCondition(flag("ghast_ore_enabled"))
            .addRecipe( ShapedRecipeBuilder.shaped(Items.GHAST_TEAR, 4)
                .define('#', Items.LAVA_BUCKET)
                .define('B', ModBlocks.ashstone_ore.get())
                .pattern("BBB")
                .pattern("B#B")
                .pattern("BBB")
                .unlockedBy("has_item", has(ModBlocks.ashstone_ore.get()))
                ::save)
            .setAdvancement(recipe_name, 
                    setbuilder.build_advancement_with_condition(recipe_name, flag("ghast_ore_enabled"), 
                            has(ModBlocks.ashstone_ore.get())))
            .build(consumer, recipe_name);
            
            
        
        // pressure_plates
        this.setbuilder.buildSimplePressurePlate(consumer, Ingredient.of(ModItems.argonite_ingot.get()),
                ModBlocks.argonite_pressure_plate.get(), has(ModItems.argonite_ingot.get()));
        this.setbuilder.buildSimplePressurePlate(consumer, Ingredient.of(ModItems.fyrite_ingot.get()),
                ModBlocks.fyrite_pressure_plate.get(), has(ModItems.fyrite_ingot.get()));
        this.setbuilder.buildSimplePressurePlate(consumer, Ingredient.of(ModItems.illumenite_ingot.get()),
                ModBlocks.illumenite_pressure_plate.get(), has(ModItems.illumenite_ingot.get()));
        this.setbuilder.buildSimplePressurePlate(consumer, Ingredient.of(ModItems.malachite_ingot.get()),
                ModBlocks.malachite_pressure_plate.get(), has(ModItems.malachite_ingot.get()));
        this.setbuilder.buildSimplePressurePlate(consumer, Ingredient.of(ModItems.ashstone_gem.get()),
                ModBlocks.ashstone_pressure_plate.get(), has(ModItems.ashstone_gem.get()));
        this.setbuilder.buildSimplePressurePlate(consumer, Ingredient.of(ModItems.dragonstone_gem.get()),
                ModBlocks.dragonstone_pressure_plate.get(), has(ModItems.dragonstone_gem.get()));
        
    } // end registerMiscRecipes
    
    
    protected void registerToolRecipes(Consumer<FinishedRecipe> consumer)
    {
    	setbuilder.buildSimpleToolSet(consumer, Ingredient.of(ModItems.argonite_ingot.get()), 
    			"argonite", has(ModItems.argonite_ingot.get()), null, true);
       	setbuilder.buildSimpleToolSet(consumer, Ingredient.of(ModItems.ashstone_gem.get()), 
    			"ashstone", has(ModItems.ashstone_gem.get()), null, true);
       	setbuilder.buildSimpleToolSet(consumer, Ingredient.of(ModItems.dragonstone_gem.get()), 
    			"dragonstone", has(ModItems.dragonstone_gem.get()), null, true);
       	setbuilder.buildSimpleToolSet(consumer, Ingredient.of(ModItems.illumenite_ingot.get()), 
    			"illumenite", has(ModItems.illumenite_ingot.get()), null, true);
       	setbuilder.buildSimpleToolSet(consumer, Ingredient.of(ModItems.fyrite_ingot.get()), 
    			"fyrite", has(ModItems.fyrite_ingot.get()), null, true);
       	setbuilder.buildSimpleToolSet(consumer, Ingredient.of(ModItems.malachite_ingot.get()), 
    			"malachite", has(ModItems.malachite_ingot.get()), null, true);
    } // end registerToolRecipes()
    
    protected void registerArmorRecipes(Consumer<FinishedRecipe> consumer)
    {
    	setbuilder.buildSimpleArmorSet(consumer, Ingredient.of(ModItems.dragonstone_gem.get()), 
    			"dragonstone", has(ModItems.dragonstone_gem.get()), null);
    	setbuilder.buildSimpleArmorSet(consumer, Ingredient.of(ModItems.fyrite_ingot.get()), "fyrite", 
    			has(ModItems.fyrite_ingot.get()), null);
    	setbuilder.buildSimpleArmorSet(consumer, Ingredient.of(ModItems.illumenite_ingot.get()), "illumenite", 
    			has(ModItems.illumenite_ingot.get()), null);
    	setbuilder.buildSimpleArmorSet(consumer, Ingredient.of(ModItems.malachite_ingot.get()), "malachite", 
    			has(ModItems.malachite_ingot.get()), null);
    } // end registerArmorRecipes()
    
    
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
    } // end registerAestheticRecipes()
    
    
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
        
        setbuilder.buildSimpleStorageRecipes(consumer, ModItems.argonite_ingot.get(), 
        		ModBlocks.argonite_block.get().asItem(), ModItems.argonite_nugget.get(), 
        		has(ModItems.argonite_ingot.get()));
        setbuilder.buildSimpleStorageRecipes(consumer, ModItems.fyrite_ingot.get(), 
        		ModBlocks.fyrite_block.get().asItem(), ModItems.fyrite_nugget.get(), 
        		has(ModItems.fyrite_ingot.get()));
        setbuilder.buildSimpleStorageRecipes(consumer, ModItems.illumenite_ingot.get(), 
        		ModBlocks.illumenite_block.get().asItem(), ModItems.illumenite_nugget.get(), 
        		has(ModItems.illumenite_ingot.get()));
        setbuilder.buildSimpleStorageRecipes(consumer, ModItems.malachite_ingot.get(), 
        		ModBlocks.malachite_block.get().asItem(), ModItems.malachite_nugget.get(), 
        		has(ModItems.malachite_ingot.get()));
        setbuilder.buildSimpleStorageRecipes(consumer, ModItems.ashstone_gem.get(), 
        		ModBlocks.ashstone_block.get().asItem(), null, 
        		has(ModItems.ashstone_gem.get()));
        setbuilder.buildSimpleStorageRecipes(consumer, ModItems.dragonstone_gem.get(), 
        		ModBlocks.dragonstone_block.get().asItem(), null, 
        		has(ModItems.dragonstone_gem.get()));
    } // end registerStorageRecipes()
    
    
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
        
        setbuilder.buildOre2IngotRecipes(consumer, Ingredient.of(ModBlocks.ashstone_ore.get()), ModItems.ashstone_gem.get(), 
                has(ModBlocks.ashstone_ore.get()), 0.8F, 200, "_from_ore");
        setbuilder.buildOre2IngotRecipes(consumer, Ingredient.of(ModBlocks.dragonstone_ore.get()), ModItems.dragonstone_gem.get(), 
                has(ModBlocks.dragonstone_ore.get()), 0.8F, 200, "_from_ore");
        setbuilder.buildOre2IngotRecipes(consumer, Ingredient.of(ModBlocks.fyrite_ore.get()), ModItems.fyrite_ingot.get(), 
                has(ModBlocks.fyrite_ore.get()), 0.8F, 200, "_from_ore");
        setbuilder.buildOre2IngotRecipes(consumer, Ingredient.of(ModBlocks.illumenite_ore.get()), ModItems.illumenite_ingot.get(), 
                has(ModBlocks.illumenite_ore.get()), 0.8F, 200, "_from_ore");
        setbuilder.buildOre2IngotRecipes(consumer, Ingredient.of(ModBlocks.argonite_ore.get()), ModItems.argonite_ingot.get(), 
                has(ModBlocks.argonite_ore.get()), 0.7F, 200, "_from_ore");
        setbuilder.buildOre2IngotRecipes(consumer, Ingredient.of(ModBlocks.malachite_ore.get()), ModItems.malachite_ingot.get(), 
                has(ModBlocks.malachite_ore.get()), 0.5F, 200, "_from_ore");
        
        // vanilla recycling
        setbuilder.buildVanillaRecyclingRecipes(consumer, Ingredient.of(ModItems.argonite_axe.get(),
        		ModItems.argonite_hoe.get(), ModItems.argonite_pickaxe.get(), ModItems.argonite_shovel.get(),
        		ModItems.argonite_sword.get()), ModItems.argonite_nugget.get(),
        		has(ModItems.argonite_axe.get()), 0.3F, 200);
        setbuilder.buildVanillaRecyclingRecipes(consumer, Ingredient.of(ModItems.fyrite_axe.get(),
        		ModItems.fyrite_pickaxe.get(), ModItems.fyrite_shovel.get(), ModItems.fyrite_boots.get(),
        		ModItems.fyrite_sword.get(), ModItems.fyrite_chestplate.get(), ModItems.fyrite_helmet.get(),
        		ModItems.fyrite_leggings.get()), 
        		ModItems.fyrite_nugget.get(), has(ModItems.fyrite_axe.get()), 0.3F, 200);
        setbuilder.buildVanillaRecyclingRecipes(consumer, Ingredient.of(ModItems.illumenite_boots.get(),
        		ModItems.illumenite_sword.get(), ModItems.illumenite_chestplate.get(), ModItems.illumenite_helmet.get(),
        		ModItems.illumenite_leggings.get()), 
        		ModItems.illumenite_nugget.get(), has(ModItems.illumenite_sword.get()), 0.3F, 200);
        setbuilder.buildVanillaRecyclingRecipes(consumer, Ingredient.of(ModItems.malachite_axe.get(),
        		ModItems.malachite_pickaxe.get(), ModItems.malachite_shovel.get(), ModItems.malachite_boots.get(),
        		ModItems.malachite_sword.get(), ModItems.malachite_chestplate.get(), ModItems.malachite_helmet.get(),
        		ModItems.malachite_leggings.get(), ModItems.malachite_hoe.get()), 
        		ModItems.malachite_nugget.get(), has(ModItems.malachite_axe.get()), 0.3F, 200);
        
    } // end registerFurnaceRecipes()
    
	@Override
	public ICondition flag(String arg0)
	{
		return impl_flag(Netherrocks.MODID, NetherrocksConfig.INSTANCE, arg0);
	}

} // end class
