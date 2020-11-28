package mod.alexndr.netherrocks.datagen;

import java.util.function.Consumer;

import mod.alexndr.netherrocks.Netherrocks;
import mod.alexndr.netherrocks.config.NetherrocksConfig;
import mod.alexndr.netherrocks.init.ModBlocks;
import mod.alexndr.netherrocks.init.ModItems;
import mod.alexndr.simplecorelib.datagen.CrushingRecipeBuilder;
import mod.alexndr.simplecorelib.datagen.ISimpleConditionBuilder;
import mod.alexndr.simplecorelib.datagen.RecipeSetBuilder;
import net.minecraft.block.Blocks;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.IFinishedRecipe;
import net.minecraft.data.RecipeProvider;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.crafting.conditions.ICondition;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

public class SilentsRecipes extends RecipeProvider implements ISimpleConditionBuilder, IConditionBuilder
{
    private static final int CRUSHING_CHUNKS_TIME = 300;
    private static final int CRUSHING_INGOT_TIME = 200;
    private static final int CRUSHING_ORE_TIME = 400;
    private static final float CRUSHING_CHUNKS_EXTRA_CHANCE = 0.1f;
    private static final float CRUSHING_ORE_STONE_CHANCE = 0.1f;
    
    private RecipeSetBuilder setbuilder;

    public SilentsRecipes(DataGenerator generatorIn)
    {
        super(generatorIn);
        setbuilder = new RecipeSetBuilder(Netherrocks.MODID);
    }

    @Override
    protected void registerRecipes(Consumer<IFinishedRecipe> consumer)
    {
        registerCrushingRecipes(consumer);
        registerFurnaceRecipes(consumer);
    } // end registerRecipes()

    private void registerFurnaceRecipes(Consumer<IFinishedRecipe> consumer)
    {
        setbuilder.buildOre2IngotRecipes(consumer, 
                Ingredient.fromItems(ModItems.argonite_dust.get().asItem()), ModItems.argonite_ingot.get(),
                hasItem(ModItems.argonite_dust.get().asItem()), 0.7F, 200, "_from_dust");
        setbuilder.buildOre2IngotRecipes(consumer, 
                Ingredient.fromItems(ModItems.fyrite_dust.get().asItem()), ModItems.fyrite_ingot.get(),
                hasItem(ModItems.fyrite_dust.get().asItem()), 0.8F, 200, "_from_dust");
        setbuilder.buildOre2IngotRecipes(consumer, 
                Ingredient.fromItems(ModItems.illumenite_dust.get().asItem()), ModItems.illumenite_ingot.get(),
                hasItem(ModItems.illumenite_dust.get().asItem()), 0.8F, 200, "_from_dust");
        setbuilder.buildOre2IngotRecipes(consumer, 
                Ingredient.fromItems(ModItems.malachite_dust.get().asItem()), ModItems.malachite_ingot.get(),
                hasItem(ModItems.malachite_dust.get().asItem()), 0.5F, 200, "_from_dust");
    } // end registerFurnaceRecipes()
    
    private void registerCrushingRecipes(Consumer<IFinishedRecipe> consumer)
    {
        CrushingRecipeBuilder.crushingOre(Netherrocks.MODID, ModBlocks.argonite_ore.get(),
                ModItems.crushed_argonite_ore.get(), CRUSHING_ORE_TIME, Blocks.COBBLESTONE, CRUSHING_ORE_STONE_CHANCE)
                .build(consumer);
        CrushingRecipeBuilder.crushingChunks(Netherrocks.MODID, ModItems.crushed_argonite_ore.get(),
                ModItems.argonite_dust.get(), CRUSHING_CHUNKS_TIME, CRUSHING_CHUNKS_EXTRA_CHANCE).build(consumer);
        CrushingRecipeBuilder
                .crushingIngot(Netherrocks.MODID, ModItems.argonite_ingot.get(), ModItems.argonite_dust.get(),
                        CRUSHING_CHUNKS_TIME)
                .build(consumer, new ResourceLocation(Netherrocks.MODID, "crushing/argonite_dust_from_ingot"));

        CrushingRecipeBuilder.crushingOre(Netherrocks.MODID, ModBlocks.fyrite_ore.get(),
                ModItems.crushed_fyrite_ore.get(), CRUSHING_ORE_TIME, Blocks.COBBLESTONE, CRUSHING_ORE_STONE_CHANCE)
                .build(consumer);
        CrushingRecipeBuilder.crushingChunks(Netherrocks.MODID, ModItems.crushed_fyrite_ore.get(),
                ModItems.fyrite_dust.get(), CRUSHING_CHUNKS_TIME, CRUSHING_CHUNKS_EXTRA_CHANCE).build(consumer);
        CrushingRecipeBuilder
                .crushingIngot(Netherrocks.MODID, ModItems.fyrite_ingot.get(), ModItems.fyrite_dust.get(),
                        CRUSHING_CHUNKS_TIME)
                .build(consumer, new ResourceLocation(Netherrocks.MODID, "crushing/fyrite_dust_from_ingot"));

        CrushingRecipeBuilder.crushingOre(Netherrocks.MODID, ModBlocks.illumenite_ore.get(),
                ModItems.crushed_illumenite_ore.get(), CRUSHING_ORE_TIME, Blocks.COBBLESTONE, CRUSHING_ORE_STONE_CHANCE)
                .build(consumer);
        CrushingRecipeBuilder
                .crushingChunks(Netherrocks.MODID, ModItems.crushed_illumenite_ore.get(),
                        ModItems.illumenite_dust.get(), CRUSHING_CHUNKS_TIME, CRUSHING_CHUNKS_EXTRA_CHANCE)
                .build(consumer);
        CrushingRecipeBuilder
                .crushingIngot(Netherrocks.MODID, ModItems.illumenite_ingot.get(), ModItems.illumenite_dust.get(),
                        CRUSHING_CHUNKS_TIME)
                .build(consumer, new ResourceLocation(Netherrocks.MODID, "crushing/illumenite_dust_from_ingot"));

        CrushingRecipeBuilder.crushingOre(Netherrocks.MODID, ModBlocks.malachite_ore.get(),
                ModItems.crushed_malachite_ore.get(), CRUSHING_ORE_TIME, Blocks.COBBLESTONE, CRUSHING_ORE_STONE_CHANCE)
                .build(consumer);
        CrushingRecipeBuilder.crushingChunks(Netherrocks.MODID, ModItems.crushed_malachite_ore.get(),
                ModItems.malachite_dust.get(), CRUSHING_CHUNKS_TIME, CRUSHING_CHUNKS_EXTRA_CHANCE).build(consumer);
        CrushingRecipeBuilder
                .crushingIngot(Netherrocks.MODID, ModItems.malachite_ingot.get(), ModItems.malachite_dust.get(),
                        CRUSHING_CHUNKS_TIME)
                .build(consumer, new ResourceLocation(Netherrocks.MODID, "crushing/malachite_dust_from_ingot"));
    } // end registerCrushingRecipes()
    
    @Override
    public ICondition flag(String name)
    {
        return impl_flag(Netherrocks.MODID, NetherrocksConfig.INSTANCE, name);
    }

} // end class
