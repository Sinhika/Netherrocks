package alexndr.plugins.Netherrocks.helpers;

import java.util.ListIterator;
import java.util.Random;

import net.minecraft.block.state.IBlockState;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Enchantments;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import alexndr.api.helpers.game.ToolHelper;
import alexndr.plugins.Netherrocks.Content;

/** Helper class for handling Fyrite properties */
public class FyriteHandler 
{
	/**
	 * Fyrite smelts blocks on harvest. This is the event handler that handles
	 * the BlockEvent.HarvestDropsEvent. Original code improved by borrowing from
	 * Tinker's Construct autosmelt code.
	 * 
	 * @param event
	 */
	@SubscribeEvent
	public void onHarvestDrops(BlockEvent.HarvestDropsEvent event) 
	{
	
		// do not change harvest drops if non-player or we are using silk touch.
		EntityPlayer player = event.getHarvester();
		if (player == null) return;
		if (event.isSilkTouching()) return;
		
		Random random = event.getWorld().rand;
		boolean was_effective = false;
		
		// check if tool exists and is a fyrite tool.
		ItemStack tool = player.getHeldItem(player.getActiveHand());
		if (tool == null) return;
		Item toolItem = tool.getItem();
		if (! (toolItem instanceof ItemTool)) return;
		
//		LogHelper.info("this tool is a tool");
		if ( ((ItemTool) tool.getItem()).getToolMaterial() == Content.toolFyrite ) 
		{
//			LogHelper.info("this tool is made of fyrite");
			IBlockState state = event.getState();
			
			// if fyrite tool, and can harvest this block effectively, smelt the drops
			if (ToolHelper.isEffective(tool, state)) 
			{
//				LogHelper.info("This tool is effective");
				// iterate over the drops and do stuff...
				ListIterator<ItemStack> dropList = event.getDrops().listIterator();
				while (dropList.hasNext())
				{
					ItemStack drop = dropList.next();
					// is there a smelted version of this drop?
					ItemStack smelted = FurnaceRecipes.instance().getSmeltingResult(drop);
					if (smelted != null) 
					{
						smelted = smelted.copy();
						smelted.stackSize = drop.stackSize;
						
						// apply fortune enchantment to smelting results
						int fortune = EnchantmentHelper.getEnchantmentLevel(
													Enchantments.FORTUNE, tool);
						if (fortune > 0) {
							smelted.stackSize *= random.nextInt(fortune + 1) + 1;
						}
						// replace original drop stack with smelted results.
						dropList.set(smelted);
						
						// drop the xp for smelting.
						float xp = FurnaceRecipes.instance().getSmeltingExperience(smelted);
						if (xp < 1 && Math.random() < xp) {
							xp += 1.0f;
						}
						if (xp >= 1.0f) {
							state.getBlock().dropXpOnBlockBreak(event.getWorld(), 
																event.getPos(), (int) xp);
						} // end-if xp
						was_effective = true;
					} // end-if smelted
				} // end-while
				afterBlockSmelt(event.getWorld(), event.getPos(), was_effective);
			} // end-if effective
		} // end-if fyrite tool
	} // end onHarvestDrops()

	public void afterBlockSmelt(World world, BlockPos pos, boolean was_effective)
	{
		if (world.isRemote && was_effective)
		{
			Random random = world.rand;
			for(int i = 0; i < 3; i++) {
		        world.spawnParticle(EnumParticleTypes.FLAME,
		                            pos.getX() + random.nextDouble(),
		                            pos.getY() + random.nextDouble(), 
		                            pos.getZ() + random.nextDouble(),
		                            0.0D, 0.0D, 0.0D);
			} // end-for	
		} // end-if
	} // end afterBlockBreak()
	
} // end class
