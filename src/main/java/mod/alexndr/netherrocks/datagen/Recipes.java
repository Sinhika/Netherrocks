package mod.alexndr.netherrocks.datagen;

import mod.alexndr.netherrocks.Netherrocks;
import mod.alexndr.netherrocks.config.NetherrocksConfig;
import mod.alexndr.netherrocks.init.ModBlocks;
import mod.alexndr.netherrocks.init.ModItems;
import mod.alexndr.netherrocks.init.ModTags;
import mod.alexndr.simplecorelib.api.datagen.SimpleRecipeProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.neoforge.common.crafting.ConditionalRecipe;
import net.neoforged.neoforge.common.crafting.conditions.ICondition;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.CompletableFuture;

public class Recipes extends SimpleRecipeProvider
{
//    private RecipeSetBuilder setbuilder;
    
	public Recipes(PackOutput pOutput, CompletableFuture<HolderLookup.Provider> lookupProvider)
	{
		super(pOutput, lookupProvider, Netherrocks.MODID);
//        setbuilder = new RecipeSetBuilder(Netherrocks.MODID);
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
    } // end registerRecipes() 
	
    
    protected void registerMiscRecipes(RecipeOutput pRecipeOutput)
    {
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
				.save(pRecipeOutput);

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
    	buildSimpleToolSet(pRecipeOutput, Ingredient.of(ModItems.argonite_ingot.get()), 
    			"argonite", has(ModItems.argonite_ingot.get()), true);
       	buildSimpleToolSet(pRecipeOutput, Ingredient.of(ModItems.ashstone_gem.get()), 
    			"ashstone", has(ModItems.ashstone_gem.get()), true);
       	buildSimpleToolSet(pRecipeOutput, Ingredient.of(ModItems.dragonstone_gem.get()), 
    			"dragonstone", has(ModItems.dragonstone_gem.get()), true);
       	buildSimpleToolSet(pRecipeOutput, Ingredient.of(ModItems.illumenite_ingot.get()), 
    			"illumenite", has(ModItems.illumenite_ingot.get()), true);
       	buildSimpleToolSet(pRecipeOutput, Ingredient.of(ModItems.fyrite_ingot.get()), 
    			"fyrite", has(ModItems.fyrite_ingot.get()), true);
       	buildSimpleToolSet(pRecipeOutput, Ingredient.of(ModItems.malachite_ingot.get()), 
    			"malachite", has(ModItems.malachite_ingot.get()), true);
    } // end registerToolRecipes()
    
    protected void registerArmorRecipes(RecipeOutput pRecipeOutput)
    {
    	buildSimpleArmorSet(pRecipeOutput, Ingredient.of(ModItems.dragonstone_gem.get()), 
    			"dragonstone", has(ModItems.dragonstone_gem.get()), null);
    	buildSimpleArmorSet(pRecipeOutput, Ingredient.of(ModItems.fyrite_ingot.get()), "fyrite", 
    			has(ModItems.fyrite_ingot.get()), null);
    	buildSimpleArmorSet(pRecipeOutput, Ingredient.of(ModItems.illumenite_ingot.get()), "illumenite", 
    			has(ModItems.illumenite_ingot.get()), null);
    	buildSimpleArmorSet(pRecipeOutput, Ingredient.of(ModItems.malachite_ingot.get()), "malachite", 
    			has(ModItems.malachite_ingot.get()), null);
    } // end registerArmorRecipes()
    
    
    protected void registerAestheticRecipes(RecipeOutput pRecipeOutput)
    {
    	buildSimpleAestheticBlocks(pRecipeOutput, Ingredient.of(ModItems.argonite_ingot.get()), "argonite", 
 			has(ModItems.argonite_ingot.get()), flag("aesthetics_enabled"));
    	buildSimpleAestheticBlocks(pRecipeOutput, Ingredient.of(ModItems.ashstone_gem.get()), "ashstone", 
 			has(ModItems.ashstone_gem.get()), flag("aesthetics_enabled"));
    	buildSimpleAestheticBlocks(pRecipeOutput, Ingredient.of(ModItems.dragonstone_gem.get()), "dragonstone", 
 			has(ModItems.dragonstone_gem.get()), flag("aesthetics_enabled"));
    	buildSimpleAestheticBlocks(pRecipeOutput, Ingredient.of(ModItems.fyrite_ingot.get()), "fyrite", 
 			has(ModItems.fyrite_ingot.get()), flag("aesthetics_enabled"));
    	buildSimpleAestheticBlocks(pRecipeOutput, Ingredient.of(ModItems.illumenite_ingot.get()), "illumenite", 
 			has(ModItems.illumenite_ingot.get()), flag("aesthetics_enabled"));
    	buildSimpleAestheticBlocks(pRecipeOutput, Ingredient.of(ModItems.malachite_ingot.get()), "malachite", 
 			has(ModItems.malachite_ingot.get()), flag("aesthetics_enabled"));
    } // end registerAestheticRecipes()
    
    
    protected void registerStorageRecipes(RecipeOutput pRecipeOutput)
    {
        buildSimpleStorageRecipes(pRecipeOutput, ModItems.raw_fyrite.get(), 
        		ModBlocks.raw_fyrite_block.get(), null, has(ModItems.raw_fyrite.get()));
        buildSimpleStorageRecipes(pRecipeOutput, ModItems.raw_illumenite.get(), 
        		ModBlocks.raw_illumenite_block.get(), null, has(ModItems.raw_illumenite.get()));
        buildSimpleStorageRecipes(pRecipeOutput, ModItems.raw_argonite.get(), 
        		ModBlocks.raw_argonite_block.get(), null, has(ModItems.raw_argonite.get()));
        buildSimpleStorageRecipes(pRecipeOutput, ModItems.raw_malachite.get(), 
        		ModBlocks.raw_malachite_block.get(), null, has(ModItems.raw_malachite.get()));
        
        buildSimpleStorageRecipes(pRecipeOutput, ModItems.argonite_ingot.get(), 
        		ModBlocks.argonite_block.get().asItem(), ModItems.argonite_nugget.get(), 
        		has(ModItems.argonite_ingot.get()));
        buildSimpleStorageRecipes(pRecipeOutput, ModItems.fyrite_ingot.get(), 
        		ModBlocks.fyrite_block.get().asItem(), ModItems.fyrite_nugget.get(), 
        		has(ModItems.fyrite_ingot.get()));
        buildSimpleStorageRecipes(pRecipeOutput, ModItems.illumenite_ingot.get(), 
        		ModBlocks.illumenite_block.get().asItem(), ModItems.illumenite_nugget.get(), 
        		has(ModItems.illumenite_ingot.get()));
        buildSimpleStorageRecipes(pRecipeOutput, ModItems.malachite_ingot.get(), 
        		ModBlocks.malachite_block.get().asItem(), ModItems.malachite_nugget.get(), 
        		has(ModItems.malachite_ingot.get()));
        buildSimpleStorageRecipes(pRecipeOutput, ModItems.ashstone_gem.get(), 
        		ModBlocks.ashstone_block.get().asItem(), null, 
        		has(ModItems.ashstone_gem.get()));
        buildSimpleStorageRecipes(pRecipeOutput, ModItems.dragonstone_gem.get(), 
        		ModBlocks.dragonstone_block.get().asItem(), null, 
        		has(ModItems.dragonstone_gem.get()));
    } // end registerStorageRecipes()
    
    
    protected void registerFurnaceRecipes(RecipeOutput pRecipeOutput)
    {
        buildOre2IngotRecipes(pRecipeOutput, Ingredient.of(ModItems.raw_fyrite.get()), ModItems.fyrite_ingot.get(), 
                has(ModItems.raw_fyrite.get()), 0.8F, 200);
        buildOre2IngotRecipes(pRecipeOutput, Ingredient.of(ModItems.raw_illumenite.get()), ModItems.illumenite_ingot.get(), 
                has(ModItems.raw_illumenite.get()), 0.8F, 200);
        buildOre2IngotRecipes(pRecipeOutput, Ingredient.of(ModItems.raw_argonite.get()), ModItems.argonite_ingot.get(), 
                has(ModItems.raw_argonite.get()), 0.7F, 200);
        buildOre2IngotRecipes(pRecipeOutput, Ingredient.of(ModItems.raw_malachite.get()), ModItems.malachite_ingot.get(), 
                has(ModItems.raw_malachite.get()), 0.5F, 200);
        
        buildOre2IngotRecipes(pRecipeOutput, Ingredient.of(ModBlocks.ashstone_ore.get()), ModItems.ashstone_gem.get(), 
                has(ModBlocks.ashstone_ore.get()), 0.8F, 200, "_from_ore");
        buildOre2IngotRecipes(pRecipeOutput, Ingredient.of(ModBlocks.dragonstone_ore.get()), ModItems.dragonstone_gem.get(), 
                has(ModBlocks.dragonstone_ore.get()), 0.8F, 200, "_from_ore");
        buildOre2IngotRecipes(pRecipeOutput, Ingredient.of(ModBlocks.fyrite_ore.get()), ModItems.fyrite_ingot.get(), 
                has(ModBlocks.fyrite_ore.get()), 0.8F, 200, "_from_ore");
        buildOre2IngotRecipes(pRecipeOutput, Ingredient.of(ModBlocks.illumenite_ore.get()), ModItems.illumenite_ingot.get(), 
                has(ModBlocks.illumenite_ore.get()), 0.8F, 200, "_from_ore");
        buildOre2IngotRecipes(pRecipeOutput, Ingredient.of(ModBlocks.argonite_ore.get()), ModItems.argonite_ingot.get(), 
                has(ModBlocks.argonite_ore.get()), 0.7F, 200, "_from_ore");
        buildOre2IngotRecipes(pRecipeOutput, Ingredient.of(ModBlocks.malachite_ore.get()), ModItems.malachite_ingot.get(), 
                has(ModBlocks.malachite_ore.get()), 0.5F, 200, "_from_ore");
        
        // vanilla recycling
        buildVanillaRecyclingRecipes(pRecipeOutput, Ingredient.of(ModItems.argonite_axe.get(),
        		ModItems.argonite_hoe.get(), ModItems.argonite_pickaxe.get(), ModItems.argonite_shovel.get(),
        		ModItems.argonite_sword.get()), ModItems.argonite_nugget.get(),
        		has(ModItems.argonite_axe.get()), 0.3F, 200);
        buildVanillaRecyclingRecipes(pRecipeOutput, Ingredient.of(ModItems.fyrite_axe.get(),
        		ModItems.fyrite_pickaxe.get(), ModItems.fyrite_shovel.get(), ModItems.fyrite_boots.get(),
        		ModItems.fyrite_sword.get(), ModItems.fyrite_chestplate.get(), ModItems.fyrite_helmet.get(),
        		ModItems.fyrite_leggings.get()), 
        		ModItems.fyrite_nugget.get(), has(ModItems.fyrite_axe.get()), 0.3F, 200);
        buildVanillaRecyclingRecipes(pRecipeOutput, Ingredient.of(ModItems.illumenite_boots.get(),
        		ModItems.illumenite_sword.get(), ModItems.illumenite_chestplate.get(), ModItems.illumenite_helmet.get(),
        		ModItems.illumenite_leggings.get()), 
        		ModItems.illumenite_nugget.get(), has(ModItems.illumenite_sword.get()), 0.3F, 200);
        buildVanillaRecyclingRecipes(pRecipeOutput, Ingredient.of(ModItems.malachite_axe.get(),
        		ModItems.malachite_pickaxe.get(), ModItems.malachite_shovel.get(), ModItems.malachite_boots.get(),
        		ModItems.malachite_sword.get(), ModItems.malachite_chestplate.get(), ModItems.malachite_helmet.get(),
        		ModItems.malachite_leggings.get(), ModItems.malachite_hoe.get()), 
        		ModItems.malachite_nugget.get(), has(ModItems.malachite_axe.get()), 0.3F, 200);
        
    } // end registerFurnaceRecipes()
    
    private void registerSilentsFurnaceRecipes(RecipeOutput pRecipeOutput)
    {
        buildOre2IngotRecipes(pRecipeOutput, 
                Ingredient.of(ModItems.argonite_dust.get().asItem()), ModItems.argonite_ingot.get(),
                has(ModItems.argonite_dust.get().asItem()), 0.7F, 200, "_from_dust");
        buildOre2IngotRecipes(pRecipeOutput, 
                Ingredient.of(ModItems.fyrite_dust.get().asItem()), ModItems.fyrite_ingot.get(),
                has(ModItems.fyrite_dust.get().asItem()), 0.8F, 200, "_from_dust");
        buildOre2IngotRecipes(pRecipeOutput, 
                Ingredient.of(ModItems.illumenite_dust.get().asItem()), ModItems.illumenite_ingot.get(),
                has(ModItems.illumenite_dust.get().asItem()), 0.8F, 200, "_from_dust");
        buildOre2IngotRecipes(pRecipeOutput, 
                Ingredient.of(ModItems.malachite_dust.get().asItem()), ModItems.malachite_ingot.get(),
                has(ModItems.malachite_dust.get().asItem()), 0.5F, 200, "_from_dust");
        
        buildOre2IngotRecipes(pRecipeOutput, 
                Ingredient.of(ModItems.crushed_argonite_ore.get().asItem()), ModItems.argonite_ingot.get(),
                has(ModItems.crushed_argonite_ore.get().asItem()), 0.7F, 200, "_from_chunks");
        buildOre2IngotRecipes(pRecipeOutput, 
                Ingredient.of(ModItems.crushed_fyrite_ore.get().asItem()), ModItems.fyrite_ingot.get(),
                has(ModItems.crushed_fyrite_ore.get().asItem()), 0.8F, 200, "_from_chunks");
        buildOre2IngotRecipes(pRecipeOutput, 
                Ingredient.of(ModItems.crushed_illumenite_ore.get().asItem()), ModItems.illumenite_ingot.get(),
                has(ModItems.crushed_illumenite_ore.get().asItem()), 0.8F, 200, "_from_chunks");
        buildOre2IngotRecipes(pRecipeOutput, 
                Ingredient.of(ModItems.crushed_malachite_ore.get().asItem()), ModItems.malachite_ingot.get(),
                has(ModItems.crushed_malachite_ore.get().asItem()), 0.5F, 200, "_from_chunks");
   } // end registerFurnaceRecipes()

	@Override
	public ICondition flag(String arg0)
	{
		return impl_flag(Netherrocks.MODID, NetherrocksConfig.INSTANCE, arg0);
	}

} // end class
