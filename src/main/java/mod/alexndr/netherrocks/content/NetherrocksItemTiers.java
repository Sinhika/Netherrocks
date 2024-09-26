package mod.alexndr.netherrocks.content;

import mod.alexndr.netherrocks.config.NetherrocksConfig;
import mod.alexndr.netherrocks.init.ModItems;
import mod.alexndr.netherrocks.init.ModTags;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.neoforged.neoforge.common.SimpleTier;

public final class NetherrocksItemTiers
{

	public static final Tier ARGONITE = new SimpleTier(BlockTags.INCORRECT_FOR_NETHERITE_TOOL,
			NetherrocksConfig.argoniteToolRecord.uses(), NetherrocksConfig.argoniteToolRecord.speedBonus(),
			NetherrocksConfig.argoniteToolRecord.attackDamageBonus(), NetherrocksConfig.argoniteToolRecord.enchantability(),
			()->Ingredient.of(ModItems.argonite_ingot.get()));

	public static final Tier ASHSTONE = new SimpleTier(BlockTags.INCORRECT_FOR_DIAMOND_TOOL,
			NetherrocksConfig.ashstoneToolRecord.uses(), NetherrocksConfig.ashstoneToolRecord.speedBonus(),
			NetherrocksConfig.ashstoneToolRecord.attackDamageBonus(), NetherrocksConfig.ashstoneToolRecord.enchantability(),
					()->Ingredient.of(ModItems.ashstone_gem.get()));
			
	public static final Tier DRAGONSTONE = new SimpleTier(ModTags.Blocks.INCORRECT_FOR_DRAGONSTONE_TOOL,
			NetherrocksConfig.dragonstoneToolRecord.uses(), NetherrocksConfig.dragonstoneToolRecord.speedBonus(),
			NetherrocksConfig.dragonstoneToolRecord.attackDamageBonus(), NetherrocksConfig.dragonstoneToolRecord.enchantability(), 
			()->Ingredient.of(ModItems.dragonstone_gem.get()));
			
	public static final Tier FYRITE = new SimpleTier(BlockTags.INCORRECT_FOR_DIAMOND_TOOL,
			NetherrocksConfig.fyriteToolRecord.uses(), NetherrocksConfig.fyriteToolRecord.speedBonus(),
			NetherrocksConfig.fyriteToolRecord.attackDamageBonus(), NetherrocksConfig.fyriteToolRecord.enchantability(),
					()->Ingredient.of(ModItems.fyrite_ingot.get()));
			
	public static final Tier ILLUMENITE = new SimpleTier(BlockTags.INCORRECT_FOR_DIAMOND_TOOL,
			NetherrocksConfig.illumeniteToolRecord.uses(), NetherrocksConfig.illumeniteToolRecord.speedBonus(),
			NetherrocksConfig.illumeniteToolRecord.attackDamageBonus(), NetherrocksConfig.illumeniteToolRecord.enchantability(),
					()->Ingredient.of(ModItems.illumenite_ingot.get()));
			
	public static final Tier MALACHITE = new SimpleTier(BlockTags.INCORRECT_FOR_DIAMOND_TOOL,
			NetherrocksConfig.malachiteToolRecord.uses(), NetherrocksConfig.malachiteToolRecord.speedBonus(),
			NetherrocksConfig.malachiteToolRecord.attackDamageBonus(), NetherrocksConfig.malachiteToolRecord.enchantability(),
					()->Ingredient.of(ModItems.malachite_ingot.get()));

} // end class
