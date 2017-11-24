package alexndr.plugins.netherrocks.items;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import alexndr.api.content.items.SimpleSword;
import alexndr.plugins.netherrocks.Content;
import alexndr.plugins.netherrocks.Netherrocks;
import alexndr.plugins.netherrocks.helpers.FyriteHandler;

public class FyriteSword extends SimpleSword 
{

	public FyriteSword(String name) {
		super(name, Netherrocks.plugin, Content.toolFyrite);
		addToolTip("netherrocks.fyrite_sword.info");
	}

	@Override
	public boolean hitEntity(ItemStack stack, EntityLivingBase target,
			EntityLivingBase attacker) 
	{
		return FyriteHandler.INSTANCE.hitEntity(stack, target, attacker)
				&& super.hitEntity(stack, target, attacker);
	} // end hitEntity

	@Override
	public EnumActionResult onItemUse(EntityPlayer player, World worldIn, BlockPos pos, EnumHand hand,
										EnumFacing facing, float hitX, float hitY, float hitZ)	
	{
		EnumActionResult result 
			= FyriteHandler.INSTANCE.onItemUse(player, worldIn, pos, hand, facing, 
					hitX, hitY, hitZ);
		if (result != EnumActionResult.PASS) {
			return result;
		}
		else {
			return super.onItemUse(player, worldIn, pos, hand, facing, 
					hitX, hitY, hitZ);
		}
	} // onItemUse()

	
} // end class
