package mod.alexndr.netherrocks.content;

import java.util.List;

import mod.alexndr.netherrocks.Netherrocks;
import mod.alexndr.netherrocks.init.ModItems;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.SimpleTier;
import net.neoforged.neoforge.common.TierSortingRegistry;

public final class NetherrocksItemTiers
{
	public static final TagKey<Block> ARGONITE_TAG = 
			BlockTags.create(new ResourceLocation(Netherrocks.MODID, "needs_argonite_tool"));
	public static final TagKey<Block> ASHSTONE_TAG = 
			BlockTags.create(new ResourceLocation(Netherrocks.MODID, "needs_ashstone_tool"));
	public static final TagKey<Block> DRAGONSTONE_TAG = 
			BlockTags.create(new ResourceLocation(Netherrocks.MODID, "needs_dragonstone_tool"));
	public static final TagKey<Block> FYRITE_TAG = 
			BlockTags.create(new ResourceLocation(Netherrocks.MODID, "needs_fyrite_tool"));
	public static final TagKey<Block> ILLUMENITE_TAG = 
			BlockTags.create(new ResourceLocation(Netherrocks.MODID, "needs_illumenite_tool"));
	public static final TagKey<Block> MALACHITE_TAG = 
			BlockTags.create(new ResourceLocation(Netherrocks.MODID, "needs_malachite_tool"));
	
	public static final Tier ARGONITE = TierSortingRegistry.registerTier(
			new SimpleTier(Tiers.NETHERITE.getLevel(), 1300, 8.0F, 3.0F, 18, ARGONITE_TAG, 
					()->Ingredient.of(ModItems.argonite_ingot.get())), new ResourceLocation(Netherrocks.MODID, "argonite"),
					List.of(Tiers.NETHERITE), List.of());

	public static final Tier ASHSTONE = TierSortingRegistry.registerTier(
			new SimpleTier(Tiers.DIAMOND.getLevel(), 900, 16.0F, 2.0F, 7, ASHSTONE_TAG, 
					()->Ingredient.of(ModItems.ashstone_gem.get())), new ResourceLocation(Netherrocks.MODID, "ashstone"),
					List.of(Tiers.DIAMOND), List.of(Tiers.NETHERITE));
			
	public static final Tier DRAGONSTONE = TierSortingRegistry.registerTier(
			new SimpleTier(Tiers.NETHERITE.getLevel(), 4000, 10.0F, 8.0F, 27, DRAGONSTONE_TAG, 
					()->Ingredient.of(ModItems.dragonstone_gem.get())), new ResourceLocation(Netherrocks.MODID, "dragonstone"),
					List.of(Tiers.NETHERITE, ARGONITE), List.of());
			
	public static final Tier FYRITE = TierSortingRegistry.registerTier(
			new SimpleTier(Tiers.DIAMOND.getLevel(), 150, 8.0F, 4.0F, 7, FYRITE_TAG, 
					()->Ingredient.of(ModItems.fyrite_ingot.get())), new ResourceLocation(Netherrocks.MODID, "fyrite"),
					List.of(Tiers.DIAMOND), List.of(ASHSTONE, Tiers.NETHERITE));
			
	public static final Tier ILLUMENITE = TierSortingRegistry.registerTier(
			new SimpleTier(Tiers.DIAMOND.getLevel(), 700, 8.0F, 4.0F, 15, ILLUMENITE_TAG, 
					()->Ingredient.of(ModItems.illumenite_ingot.get())), new ResourceLocation(Netherrocks.MODID, "illumenite"),
					List.of(Tiers.DIAMOND, FYRITE), List.of(ASHSTONE, Tiers.NETHERITE));
			
	public static final Tier MALACHITE = TierSortingRegistry.registerTier(
			new SimpleTier(Tiers.DIAMOND.getLevel(),  700, 9.0F, 3.0F, 39, MALACHITE_TAG, 
					()->Ingredient.of(ModItems.malachite_ingot.get())), new ResourceLocation(Netherrocks.MODID, "malachite"),
					List.of(Tiers.DIAMOND, FYRITE), List.of(ASHSTONE, Tiers.NETHERITE));

} // end class
