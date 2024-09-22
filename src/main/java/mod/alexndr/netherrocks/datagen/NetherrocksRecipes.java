package mod.alexndr.netherrocks.datagen;

import mod.alexndr.netherrocks.Netherrocks;
import mod.alexndr.netherrocks.init.ModBlocks;
import mod.alexndr.netherrocks.init.ModItems;
import mod.alexndr.netherrocks.init.ModTags;
import mod.alexndr.simplecorelib.api.datagen.SimpleRecipeProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.data.recipes.SmithingTransformRecipeBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.Blocks;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class NetherrocksRecipes extends SimpleRecipeProvider
{

	public NetherrocksRecipes(PackOutput pOutput, CompletableFuture<HolderLookup.Provider> lookupProvider)
	{
		super(pOutput, lookupProvider, Netherrocks.MODID);
	}

    @Override
    protected void buildRecipes(@NotNull RecipeOutput pRecipeOutput)
    {
        registerStorageRecipes(pRecipeOutput);
        registerMiscRecipes(pRecipeOutput);
        registerToolRecipes(pRecipeOutput);
        registerArmorRecipes(pRecipeOutput);
        registerFurnaceRecipes(pRecipeOutput);
        registerAestheticRecipes(pRecipeOutput);
        registerSilentsFurnaceRecipes(pRecipeOutput);
		registerSmithingRecipes(pRecipeOutput);
    } // end registerRecipes() 

	protected static void dragonstoneSmithing(RecipeOutput recipeOutput, Item ingredientItem, RecipeCategory category,
											  Item resultItem)
	{
		SmithingTransformRecipeBuilder.smithing(
						Ingredient.of(ModItems.dragonstone_upgrade_smithing_template.get()),
						Ingredient.of(ingredientItem), Ingredient.of(ModItems.dragonstone_gem.get()),
						category, resultItem)
				.unlocks("has_dragonstone_gem", has(ModItems.dragonstone_gem.get()))
				.save(recipeOutput, new ResourceLocation(Netherrocks.MODID, getItemName(resultItem) + "_smithing"));
	}

	protected void registerSmithingRecipes(RecipeOutput recipeOutput)
	{
		dragonstoneSmithing(recipeOutput, Items.NETHERITE_BOOTS, RecipeCategory.COMBAT, ModItems.dragonstone_boots.get());
		dragonstoneSmithing(recipeOutput, Items.NETHERITE_CHESTPLATE, RecipeCategory.COMBAT, ModItems.dragonstone_chestplate.get());
		dragonstoneSmithing(recipeOutput, Items.NETHERITE_HELMET, RecipeCategory.COMBAT, ModItems.dragonstone_helmet.get());
		dragonstoneSmithing(recipeOutput, Items.NETHERITE_LEGGINGS, RecipeCategory.COMBAT, ModItems.dragonstone_leggings.get());
		dragonstoneSmithing(recipeOutput, Items.NETHERITE_SWORD, RecipeCategory.COMBAT, ModItems.dragonstone_sword.get());
		dragonstoneSmithing(recipeOutput, Items.NETHERITE_SHOVEL, RecipeCategory.TOOLS, ModItems.dragonstone_shovel.get());
		dragonstoneSmithing(recipeOutput, Items.NETHERITE_AXE, RecipeCategory.TOOLS, ModItems.dragonstone_axe.get());
		dragonstoneSmithing(recipeOutput, Items.NETHERITE_PICKAXE, RecipeCategory.TOOLS, ModItems.dragonstone_pickaxe.get());
		dragonstoneSmithing(recipeOutput, Items.NETHERITE_HOE, RecipeCategory.TOOLS, ModItems.dragonstone_hoe.get());

	} // end registerSmithingRecipes()
    
    protected void registerMiscRecipes(RecipeOutput pRecipeOutput)
    {
		ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.dragonstone_upgrade_smithing_template.get())
				.define('C', Items.DIAMOND)
				.define('X', ModItems.dragonstone_upgrade_smithing_template.get())
				.define('Z', Blocks.NETHERRACK)
				.pattern("CXC")
				.pattern("CZC")
				.pattern("CCC")
				.unlockedBy("has_item", has(ModItems.dragonstone_upgrade_smithing_template.get()))
				.save(pRecipeOutput);

    	// nether furnace recipes
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.nether_furnace.get())
	        .define('S', Blocks.NETHERRACK)
	        .define('Y', Items.FLINT_AND_STEEL)
	        .pattern("SSS")
	        .pattern("SYS")
	        .pattern("SSS")
	        .unlockedBy("has_item", has(Blocks.NETHERRACK))
	        .save(pRecipeOutput);
        
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.nether_smoker.get())
	        .define('#', ItemTags.LOGS)
	        .define('X', ModBlocks.nether_furnace.get())
	        .pattern(" # ")
	        .pattern("#X#")
	        .pattern(" # ")
	        .unlockedBy("has_item", has(ModBlocks.nether_furnace.get()))
	        .save(pRecipeOutput);
       
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.nether_blast_furnace.get())
	        .define('#', Items.NETHER_BRICK)
	        .define('I', Items.IRON_INGOT)
	        .define('X', ModBlocks.nether_furnace.get())
	        .pattern("III")
	        .pattern("IXI")
	        .pattern("###")
	        .unlockedBy("has_item", has(ModBlocks.nether_furnace.get()))
	        .save(pRecipeOutput);
        
		ShapedRecipeBuilder.shaped(RecipeCategory.BREWING, Items.GHAST_TEAR, 4)
                .define('#', Items.LAVA_BUCKET)
                .define('B', ModTags.Items.ORES_ASHSTONE)
                .pattern("BBB")
                .pattern("B#B")
                .pattern("BBB")
                .unlockedBy("has_item", has(ModBlocks.ashstone_ore.get()))
				.save(pRecipeOutput, new ResourceLocation(Netherrocks.MODID, getItemName(Items.GHAST_TEAR)));

        // pressure_plates
        this.buildSimplePressurePlate(pRecipeOutput, Ingredient.of(ModItems.argonite_ingot.get()),
                ModBlocks.argonite_pressure_plate.get(), has(ModItems.argonite_ingot.get()));
        this.buildSimplePressurePlate(pRecipeOutput, Ingredient.of(ModItems.fyrite_ingot.get()),
                ModBlocks.fyrite_pressure_plate.get(), has(ModItems.fyrite_ingot.get()));
        this.buildSimplePressurePlate(pRecipeOutput, Ingredient.of(ModItems.illumenite_ingot.get()),
                ModBlocks.illumenite_pressure_plate.get(), has(ModItems.illumenite_ingot.get()));
        this.buildSimplePressurePlate(pRecipeOutput, Ingredient.of(ModItems.malachite_ingot.get()),
                ModBlocks.malachite_pressure_plate.get(), has(ModItems.malachite_ingot.get()));
        this.buildSimplePressurePlate(pRecipeOutput, Ingredient.of(ModItems.ashstone_gem.get()),
                ModBlocks.ashstone_pressure_plate.get(), has(ModItems.ashstone_gem.get()));
        this.buildSimplePressurePlate(pRecipeOutput, Ingredient.of(ModItems.dragonstone_gem.get()),
                ModBlocks.dragonstone_pressure_plate.get(), has(ModItems.dragonstone_gem.get()));
        
    } // end registerMiscRecipes
    
    
    protected void registerToolRecipes(RecipeOutput pRecipeOutput)
    {
		ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.dragonstone_shears.get())
				.define('S', ModItems.dragonstone_gem.get())
				.pattern(" S")
				.pattern("S ")
				.unlockedBy("has_item", has(ModItems.dragonstone_gem.get()))
				.save(pRecipeOutput);

    	buildSimpleToolSet(pRecipeOutput, Ingredient.of(ModItems.argonite_ingot.get()), 
    			"argonite", has(ModItems.argonite_ingot.get()), true);
       	buildSimpleToolSet(pRecipeOutput, Ingredient.of(ModItems.ashstone_gem.get()), 
    			"ashstone", has(ModItems.ashstone_gem.get()), true);
//       	buildSimpleToolSet(pRecipeOutput, Ingredient.of(ModItems.dragonstone_gem.get()),
//    			"dragonstone", has(ModItems.dragonstone_gem.get()), true);
       	buildSimpleToolSet(pRecipeOutput, Ingredient.of(ModItems.illumenite_ingot.get()), 
    			"illumenite", has(ModItems.illumenite_ingot.get()), true);
       	buildSimpleToolSet(pRecipeOutput, Ingredient.of(ModItems.fyrite_ingot.get()), 
    			"fyrite", has(ModItems.fyrite_ingot.get()), true);
       	buildSimpleToolSet(pRecipeOutput, Ingredient.of(ModItems.malachite_ingot.get()), 
    			"malachite", has(ModItems.malachite_ingot.get()), true);
    } // end registerToolRecipes()
    
    protected void registerArmorRecipes(RecipeOutput pRecipeOutput)
    {
//    	buildSimpleArmorSet(pRecipeOutput, Ingredient.of(ModItems.dragonstone_gem.get()),
//    			"dragonstone", has(ModItems.dragonstone_gem.get()));
    	buildSimpleArmorSet(pRecipeOutput, Ingredient.of(ModItems.fyrite_ingot.get()), "fyrite", 
    			has(ModItems.fyrite_ingot.get()));
    	buildSimpleArmorSet(pRecipeOutput, Ingredient.of(ModItems.illumenite_ingot.get()), "illumenite", 
    			has(ModItems.illumenite_ingot.get()));
    	buildSimpleArmorSet(pRecipeOutput, Ingredient.of(ModItems.malachite_ingot.get()), "malachite", 
    			has(ModItems.malachite_ingot.get()));
    } // end registerArmorRecipes()
    
    
    protected void registerAestheticRecipes(RecipeOutput pRecipeOutput)
    {
    	buildSimpleAestheticBlocks(pRecipeOutput, Ingredient.of(ModItems.argonite_ingot.get()), "argonite", 
 			has(ModItems.argonite_ingot.get()));
    	buildSimpleAestheticBlocks(pRecipeOutput, Ingredient.of(ModItems.ashstone_gem.get()), "ashstone", 
 			has(ModItems.ashstone_gem.get()));
    	buildSimpleAestheticBlocks(pRecipeOutput, Ingredient.of(ModItems.dragonstone_gem.get()), "dragonstone", 
 			has(ModItems.dragonstone_gem.get()));
    	buildSimpleAestheticBlocks(pRecipeOutput, Ingredient.of(ModItems.fyrite_ingot.get()), "fyrite", 
 			has(ModItems.fyrite_ingot.get()));
    	buildSimpleAestheticBlocks(pRecipeOutput, Ingredient.of(ModItems.illumenite_ingot.get()), "illumenite", 
 			has(ModItems.illumenite_ingot.get()));
    	buildSimpleAestheticBlocks(pRecipeOutput, Ingredient.of(ModItems.malachite_ingot.get()), "malachite", 
 			has(ModItems.malachite_ingot.get()));
    } // end registerAestheticRecipes()
    
    
    protected void registerStorageRecipes(RecipeOutput pRecipeOutput)
    {
        buildSimpleStorageRecipes(pRecipeOutput, ModItems.raw_fyrite.get(), 
        		ModBlocks.raw_fyrite_block.get(), null);
        buildSimpleStorageRecipes(pRecipeOutput, ModItems.raw_illumenite.get(), 
        		ModBlocks.raw_illumenite_block.get(), null);
        buildSimpleStorageRecipes(pRecipeOutput, ModItems.raw_argonite.get(), 
        		ModBlocks.raw_argonite_block.get(), null);
        buildSimpleStorageRecipes(pRecipeOutput, ModItems.raw_malachite.get(), 
        		ModBlocks.raw_malachite_block.get(), null);
        
        buildSimpleStorageRecipes(pRecipeOutput, ModItems.argonite_ingot.get(), 
        		ModBlocks.argonite_block.get().asItem(), ModItems.argonite_nugget.get());
        buildSimpleStorageRecipes(pRecipeOutput, ModItems.fyrite_ingot.get(), 
        		ModBlocks.fyrite_block.get().asItem(), ModItems.fyrite_nugget.get());
        buildSimpleStorageRecipes(pRecipeOutput, ModItems.illumenite_ingot.get(), 
        		ModBlocks.illumenite_block.get().asItem(), ModItems.illumenite_nugget.get());
        buildSimpleStorageRecipes(pRecipeOutput, ModItems.malachite_ingot.get(), 
        		ModBlocks.malachite_block.get().asItem(), ModItems.malachite_nugget.get());
        buildSimpleStorageRecipes(pRecipeOutput, ModItems.ashstone_gem.get(), 
        		ModBlocks.ashstone_block.get().asItem(), null);
        buildSimpleStorageRecipes(pRecipeOutput, ModItems.dragonstone_gem.get(), 
        		ModBlocks.dragonstone_block.get().asItem(), null);
    } // end registerStorageRecipes()
    
    
    protected void registerFurnaceRecipes(RecipeOutput pRecipeOutput)
    {
        buildOre2IngotRecipes(pRecipeOutput, List.of(ModItems.raw_fyrite.get()), ModItems.fyrite_ingot.get(),
               0.8F, 200, "fyrite_ingots");
        buildOre2IngotRecipes(pRecipeOutput, List.of(ModItems.raw_illumenite.get()), ModItems.illumenite_ingot.get(),
               0.8F, 200, "illumenite_ingots");
        buildOre2IngotRecipes(pRecipeOutput, List.of(ModItems.raw_argonite.get()), ModItems.argonite_ingot.get(),
                0.7F, 200, "argonite_ingots");
        buildOre2IngotRecipes(pRecipeOutput, List.of(ModItems.raw_malachite.get()), ModItems.malachite_ingot.get(),
                0.5F, 200, "malachite_ingots");
        
        buildOre2IngotRecipes(pRecipeOutput, List.of(ModBlocks.ashstone_ore.get()), ModItems.ashstone_gem.get(),
                0.8F, 200, "ashstone_gems");
        buildOre2IngotRecipes(pRecipeOutput, List.of(ModBlocks.dragonstone_ore.get()), ModItems.dragonstone_gem.get(),
                0.8F, 200, "dragonstone_gems");
        buildOre2IngotRecipes(pRecipeOutput, List.of(ModBlocks.fyrite_ore.get()), ModItems.fyrite_ingot.get(),
                0.8F, 200, "fyrite_ingots");
        buildOre2IngotRecipes(pRecipeOutput, List.of(ModBlocks.illumenite_ore.get()), ModItems.illumenite_ingot.get(),
                0.8F, 200, "illumenite_ingots");
        buildOre2IngotRecipes(pRecipeOutput, List.of(ModBlocks.argonite_ore.get()), ModItems.argonite_ingot.get(),
                 0.7F, 200, "argonite_ingots");
        buildOre2IngotRecipes(pRecipeOutput, List.of(ModBlocks.malachite_ore.get()), ModItems.malachite_ingot.get(),
                 0.5F, 200, "malachite_ingots");
        
        // vanilla recycling
        buildVanillaRecyclingRecipes(pRecipeOutput, List.of(ModItems.argonite_axe.get(),
        		ModItems.argonite_hoe.get(), ModItems.argonite_pickaxe.get(), ModItems.argonite_shovel.get(),
        		ModItems.argonite_sword.get()), ModItems.argonite_nugget.get(),
        		0.3F, 200, "argonite_recycling");
        buildVanillaRecyclingRecipes(pRecipeOutput, List.of(ModItems.fyrite_axe.get(),
        		ModItems.fyrite_pickaxe.get(), ModItems.fyrite_shovel.get(), ModItems.fyrite_boots.get(),
        		ModItems.fyrite_sword.get(), ModItems.fyrite_chestplate.get(), ModItems.fyrite_helmet.get(),
        		ModItems.fyrite_leggings.get()), 
        		ModItems.fyrite_nugget.get(), 0.3F, 200, "fyrite_recycling");
        buildVanillaRecyclingRecipes(pRecipeOutput, List.of(ModItems.illumenite_boots.get(),
        		ModItems.illumenite_sword.get(), ModItems.illumenite_chestplate.get(), ModItems.illumenite_helmet.get(),
        		ModItems.illumenite_leggings.get()), 
        		ModItems.illumenite_nugget.get(), 0.3F, 200, "illumenite_recycling");
        buildVanillaRecyclingRecipes(pRecipeOutput, List.of(ModItems.malachite_axe.get(),
        		ModItems.malachite_pickaxe.get(), ModItems.malachite_shovel.get(), ModItems.malachite_boots.get(),
        		ModItems.malachite_sword.get(), ModItems.malachite_chestplate.get(), ModItems.malachite_helmet.get(),
        		ModItems.malachite_leggings.get(), ModItems.malachite_hoe.get()), 
        		ModItems.malachite_nugget.get(), 0.3F, 200, "malachite_recycling");
        
    } // end registerFurnaceRecipes()

    private void registerSilentsFurnaceRecipes(RecipeOutput pRecipeOutput)
    {
        buildOre2IngotRecipes(pRecipeOutput,
				List.of(ModItems.argonite_dust.get().asItem()), ModItems.argonite_ingot.get(),
                0.7F, 200, "argonite_ingots");
        buildOre2IngotRecipes(pRecipeOutput,
				List.of(ModItems.fyrite_dust.get().asItem()), ModItems.fyrite_ingot.get(),
                 0.8F, 200, "fyrite_ingots");
        buildOre2IngotRecipes(pRecipeOutput,
				List.of(ModItems.illumenite_dust.get().asItem()), ModItems.illumenite_ingot.get(),
                 0.8F, 200, "illumenite_ingots");
        buildOre2IngotRecipes(pRecipeOutput,
				List.of(ModItems.malachite_dust.get().asItem()), ModItems.malachite_ingot.get(),
                 0.5F, 200, "malachite_ingots");

        buildOre2IngotRecipes(pRecipeOutput,
				List.of(ModItems.crushed_argonite_ore.get().asItem()), ModItems.argonite_ingot.get(),
                0.7F, 200, "argonite_ingots");
        buildOre2IngotRecipes(pRecipeOutput,
				List.of(ModItems.crushed_fyrite_ore.get().asItem()), ModItems.fyrite_ingot.get(),
                0.8F, 200, "fyrite_ingots");
        buildOre2IngotRecipes(pRecipeOutput,
				List.of(ModItems.crushed_illumenite_ore.get().asItem()), ModItems.illumenite_ingot.get(),
                0.8F, 200, "illumenite_ingots");
        buildOre2IngotRecipes(pRecipeOutput,
				List.of(ModItems.crushed_malachite_ore.get().asItem()), ModItems.malachite_ingot.get(),
                0.5F, 200, "malachite_ingots");
   } // end registerFurnaceRecipes()

} // end class
