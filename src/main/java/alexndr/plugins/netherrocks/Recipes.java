package alexndr.plugins.netherrocks;

/**
 * @author AleXndrTheGr8st
 */
public class Recipes 
{
//	public static void doRecipes()
//	{
//		//Block Recipes
//		GameRegistry.addRecipe(new ItemStack(Content.malachite_block, 1),
//				new Object[] { "XXX", "XXX", "XXX", Character.valueOf('X'),
//						Content.malachite_ingot });
//		GameRegistry.addRecipe(new ItemStack(Content.ashstone_block, 1),
//				new Object[] { "XXX", "XXX", "XXX", Character.valueOf('X'),
//						Content.ashstone_gem });
//		GameRegistry.addRecipe(new ItemStack(Content.illumenite_block, 1),
//				new Object[] { "XXX", "XXX", "XXX", Character.valueOf('X'),
//						Content.illumenite_ingot });
//		GameRegistry.addRecipe(new ItemStack(Content.dragonstone_block, 1),
//				new Object[] { "XXX", "XXX", "XXX", Character.valueOf('X'),
//						Content.dragonstone_gem });
//		GameRegistry.addRecipe(new ItemStack(Content.argonite_block, 1),
//				new Object[] { "XXX", "XXX", "XXX", Character.valueOf('X'),
//						Content.argonite_ingot });
//		GameRegistry.addRecipe(new ItemStack(Content.nether_furnace, 1),
//				new Object[] { "XXX", "XYX", "XXX", Character.valueOf('X'),
//						Blocks.NETHERRACK, Character.valueOf('Y'),
//						Items.FLINT_AND_STEEL });
//				
//		//Item Recipes
//		GameRegistry.addShapelessRecipe(new ItemStack(Content.fyrite_ingot, 9),
//				new Object[] { Content.fyrite_block });
//		GameRegistry.addShapelessRecipe(new ItemStack(Content.malachite_ingot,
//				9), new Object[] { Content.malachite_block });
//		GameRegistry.addShapelessRecipe(new ItemStack(Content.ashstone_gem, 9),
//				new Object[] { Content.ashstone_block });
//		GameRegistry.addShapelessRecipe(new ItemStack(Content.illumenite_ingot,
//				9), new Object[] { Content.illumenite_block });
//		GameRegistry.addShapelessRecipe(new ItemStack(Content.dragonstone_gem,
//				9), new Object[] { Content.dragonstone_block });
//		GameRegistry.addShapelessRecipe(
//				new ItemStack(Content.argonite_ingot, 9),
//				new Object[] { Content.argonite_block });
//					
//		//Tool Recipes
//			//Malachite Tool Recipes
//		GameRegistry.addRecipe(new ShapedOreRecipe(Content.malachite_pickaxe, true,
//						new Object[] { "XXX", " Y ", " Y ",
//								Character.valueOf('X'),
//								Content.malachite_ingot,
//								Character.valueOf('Y'), "stickWood" }));
//		GameRegistry.addRecipe(new ShapedOreRecipe(Content.malachite_axe, true,
//						new Object[] { "XX ", "XY ", " Y ",
//								Character.valueOf('X'),
//								Content.malachite_ingot,
//								Character.valueOf('Y'), "stickWood" }));
//		GameRegistry.addRecipe(new ShapedOreRecipe(Content.malachite_shovel, true,
//						new Object[] { "X", "Y", "Y", Character.valueOf('X'),
//								Content.malachite_ingot,
//								Character.valueOf('Y'), "stickWood" }));
//		GameRegistry.addRecipe(new ShapedOreRecipe(Content.malachite_sword, true,
//						new Object[] { "X", "X", "Y", Character.valueOf('X'),
//								Content.malachite_ingot,
//								Character.valueOf('Y'), "stickWood" }));
//		GameRegistry.addRecipe(new ShapedOreRecipe(Content.malachite_hoe, true,
//						new Object[] { "XX ", " Y ", " Y ",
//								Character.valueOf('X'),
//								Content.malachite_ingot,
//								Character.valueOf('Y'), "stickWood" }));
//					
//		// Ashstone Tool Recipes
//		GameRegistry.addRecipe(new ShapedOreRecipe(Content.ashstone_pickaxe,
//				true, new Object[] { "XXX", " Y ", " Y ",
//						Character.valueOf('X'), Content.ashstone_gem,
//						Character.valueOf('Y'), "stickWood" }));
//		GameRegistry.addRecipe(new ShapedOreRecipe(Content.ashstone_axe, true,
//				new Object[] { "XX ", "XY ", " Y ", Character.valueOf('X'),
//						Content.ashstone_gem, Character.valueOf('Y'),
//						"stickWood" }));
//		GameRegistry.addRecipe(new ShapedOreRecipe(Content.ashstone_shovel,
//				true, new Object[] { "X", "Y", "Y", Character.valueOf('X'),
//						Content.ashstone_gem, Character.valueOf('Y'),
//						"stickWood" }));
//		GameRegistry.addRecipe(new ShapedOreRecipe(Content.ashstone_sword,
//				true, new Object[] { "X", "X", "Y", Character.valueOf('X'),
//						Content.ashstone_gem, Character.valueOf('Y'),
//						"stickWood" }));
//		GameRegistry.addRecipe(new ShapedOreRecipe(Content.ashstone_hoe, true,
//				new Object[] { "XX ", " Y ", " Y ", Character.valueOf('X'),
//						Content.ashstone_gem, Character.valueOf('Y'),
//						"stickWood" }));
//					
//		// Dragonstone Tool Recipes
//		GameRegistry.addRecipe(new ShapedOreRecipe(Content.dragonstone_pickaxe,
//				true, new Object[] { "XXX", " Y ", " Y ",
//						Character.valueOf('X'), Content.dragonstone_gem,
//						Character.valueOf('Y'), "stickWood" }));
//		GameRegistry.addRecipe(new ShapedOreRecipe(Content.dragonstone_axe,
//				true, new Object[] { "XX ", "XY ", " Y ",
//						Character.valueOf('X'), Content.dragonstone_gem,
//						Character.valueOf('Y'), "stickWood" }));
//		GameRegistry.addRecipe(new ShapedOreRecipe(Content.dragonstone_shovel,
//				true, new Object[] { "X", "Y", "Y", Character.valueOf('X'),
//						Content.dragonstone_gem, Character.valueOf('Y'),
//						"stickWood" }));
//		GameRegistry.addRecipe(new ShapedOreRecipe(Content.dragonstone_sword,
//				true, new Object[] { "X", "X", "Y", Character.valueOf('X'),
//						Content.dragonstone_gem, Character.valueOf('Y'),
//						"stickWood" }));
//		GameRegistry.addRecipe(new ShapedOreRecipe(Content.dragonstone_hoe,
//				true, new Object[] { "XX ", " Y ", " Y ",
//						Character.valueOf('X'), Content.dragonstone_gem,
//						Character.valueOf('Y'), "stickWood" }));
//					
//		// Argonite Tool Recipes
//		GameRegistry.addRecipe(new ShapedOreRecipe(Content.argonite_pickaxe,
//				true, new Object[] { "XXX", " Y ", " Y ",
//						Character.valueOf('X'), Content.argonite_ingot,
//						Character.valueOf('Y'), "stickWood" }));
//		GameRegistry.addRecipe(new ShapedOreRecipe(Content.argonite_axe, true,
//				new Object[] { "XX ", "XY ", " Y ", Character.valueOf('X'),
//						Content.argonite_ingot, Character.valueOf('Y'),
//						"stickWood" }));
//		GameRegistry.addRecipe(new ShapedOreRecipe(Content.argonite_shovel,
//				true, new Object[] { "X", "Y", "Y", Character.valueOf('X'),
//						Content.argonite_ingot, Character.valueOf('Y'),
//						"stickWood" }));
//		GameRegistry.addRecipe(new ShapedOreRecipe(Content.argonite_sword,
//				true, new Object[] { "X", "X", "Y", Character.valueOf('X'),
//						Content.argonite_ingot, Character.valueOf('Y'),
//						"stickWood" }));
//		GameRegistry.addRecipe(new ShapedOreRecipe(Content.argonite_hoe, true,
//				new Object[] { "XX ", " Y ", " Y ", Character.valueOf('X'),
//						Content.argonite_ingot, Character.valueOf('Y'),
//						"stickWood" }));
//
//		// Special Tool Recipes
//		GameRegistry.addRecipe(new ShapedOreRecipe(Content.fyrite_sword, true,
//				new Object[] { "X", "X", "Y", Character.valueOf('X'),
//						Content.fyrite_ingot, Character.valueOf('Y'),
//						"stickWood" }));
//		GameRegistry.addRecipe(new ShapedOreRecipe(Content.fyrite_axe, true,
//				new Object[] { "XX ", "XY ", " Y ", Character.valueOf('X'),
//						Content.fyrite_ingot, Character.valueOf('Y'),
//						"stickWood" }));
//		GameRegistry.addRecipe(new ShapedOreRecipe(Content.fyrite_shovel,
//				true, new Object[] { "X", "Y", "Y", Character.valueOf('X'),
//						Content.fyrite_ingot, Character.valueOf('Y'),
//						"stickWood" }));
//		
//		GameRegistry.addRecipe(new ShapedOreRecipe(Content.illumenite_sword,
//				true, new Object[] { "X", "X", "Y", Character.valueOf('X'),
//						Content.illumenite_ingot, Character.valueOf('Y'),
//						"stickWood" }));
//		GameRegistry.addRecipe(new ShapedOreRecipe(Content.fyrite_pickaxe,
//				true, new Object[] { "XXX", " Y ", " Y ",
//						Character.valueOf('X'), Content.fyrite_ingot,
//						Character.valueOf('Y'), "stickWood" }));
//
//		// Armor Recipes
//		// Fyrite Armor Recipes
//		GameRegistry.addRecipe(new ItemStack(Content.fyrite_helmet, 1),
//				new Object[] { "XXX", "X X", Character.valueOf('X'),
//						Content.fyrite_ingot });
//		GameRegistry.addRecipe(new ItemStack(Content.fyrite_chestplate, 1),
//				new Object[] { "X X", "XXX", "XXX", Character.valueOf('X'),
//						Content.fyrite_ingot });
//		GameRegistry.addRecipe(new ItemStack(Content.fyrite_leggings, 1),
//				new Object[] { "XXX", "X X", "X X", Character.valueOf('X'),
//						Content.fyrite_ingot });
//		GameRegistry.addRecipe(new ItemStack(Content.fyrite_boots, 1),
//				new Object[] { "X X", "X X", Character.valueOf('X'),
//						Content.fyrite_ingot });
//					
//		// Malachite Armor Recipes
//		GameRegistry.addRecipe(new ItemStack(Content.malachite_helmet, 1),
//				new Object[] { "XXX", "X X", Character.valueOf('X'),
//						Content.malachite_ingot });
//		GameRegistry.addRecipe(new ItemStack(Content.malachite_chestplate, 1),
//				new Object[] { "X X", "XXX", "XXX", Character.valueOf('X'),
//						Content.malachite_ingot });
//		GameRegistry.addRecipe(new ItemStack(Content.malachite_leggings, 1),
//				new Object[] { "XXX", "X X", "X X", Character.valueOf('X'),
//						Content.malachite_ingot });
//		GameRegistry.addRecipe(new ItemStack(Content.malachite_boots, 1),
//				new Object[] { "X X", "X X", Character.valueOf('X'),
//						Content.malachite_ingot });
//
//		// Illumenite Armor Recipes
//		GameRegistry.addRecipe(new ItemStack(Content.illumenite_helmet, 1),
//				new Object[] { "XXX", "X X", Character.valueOf('X'),
//						Content.illumenite_ingot });
//		GameRegistry.addRecipe(new ItemStack(Content.illumenite_chestplate, 1),
//				new Object[] { "X X", "XXX", "XXX", Character.valueOf('X'),
//						Content.illumenite_ingot });
//		GameRegistry.addRecipe(new ItemStack(Content.illumenite_leggings, 1),
//				new Object[] { "XXX", "X X", "X X", Character.valueOf('X'),
//						Content.illumenite_ingot });
//		GameRegistry.addRecipe(new ItemStack(Content.illumenite_boots, 1),
//				new Object[] { "X X", "X X", Character.valueOf('X'),
//						Content.illumenite_ingot });
//
//		// Dragonstone Armor Recipes
//		GameRegistry.addRecipe(new ItemStack(Content.dragonstone_helmet, 1),
//				new Object[] { "XXX", "X X", Character.valueOf('X'),
//						Content.dragonstone_gem });
//		GameRegistry.addRecipe(
//				new ItemStack(Content.dragonstone_chestplate, 1), new Object[] {
//						"X X", "XXX", "XXX", Character.valueOf('X'),
//						Content.dragonstone_gem });
//		GameRegistry.addRecipe(new ItemStack(Content.dragonstone_leggings, 1),
//				new Object[] { "XXX", "X X", "X X", Character.valueOf('X'),
//						Content.dragonstone_gem });
//		GameRegistry.addRecipe(new ItemStack(Content.dragonstone_boots, 1),
//				new Object[] { "X X", "X X", Character.valueOf('X'),
//						Content.dragonstone_gem });
//
//	} // end doRecipes()

} // end class
