package mod.alexndr.netherrocks.content;

import mod.alexndr.netherrocks.init.ModItems;
import mod.alexndr.netherrocks.init.ModTags;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.neoforged.neoforge.common.SimpleTier;

public final class NetherrocksItemTiers
{

	public static final Tier ARGONITE = new SimpleTier(BlockTags.INCORRECT_FOR_NETHERITE_TOOL, 1300, 8.0F, 3.0F, 18,
			()->Ingredient.of(ModItems.argonite_ingot.get()));

	public static final Tier ASHSTONE = new SimpleTier(BlockTags.INCORRECT_FOR_DIAMOND_TOOL, 900, 16.0F, 2.0F, 7,
					()->Ingredient.of(ModItems.ashstone_gem.get()));
			
	public static final Tier DRAGONSTONE = new SimpleTier(ModTags.Blocks.INCORRECT_FOR_DRAGONSTONE_TOOL,
			4000, 10.0F, 8.0F, 27, ()->Ingredient.of(ModItems.dragonstone_gem.get()));
			
	public static final Tier FYRITE = new SimpleTier(BlockTags.INCORRECT_FOR_DIAMOND_TOOL, 150, 8.0F, 4.0F, 7,
					()->Ingredient.of(ModItems.fyrite_ingot.get()));
			
	public static final Tier ILLUMENITE = new SimpleTier(BlockTags.INCORRECT_FOR_DIAMOND_TOOL, 700, 8.0F, 4.0F, 15,
					()->Ingredient.of(ModItems.illumenite_ingot.get()));
			
	public static final Tier MALACHITE = new SimpleTier(BlockTags.INCORRECT_FOR_DIAMOND_TOOL,  700, 9.0F, 3.0F, 39,
					()->Ingredient.of(ModItems.malachite_ingot.get()));

} // end class
