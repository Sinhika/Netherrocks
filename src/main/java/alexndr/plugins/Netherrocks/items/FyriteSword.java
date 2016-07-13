package alexndr.plugins.Netherrocks.items;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import alexndr.api.content.items.SimpleSword;
import alexndr.plugins.Netherrocks.Content;
import alexndr.plugins.Netherrocks.Netherrocks;
import alexndr.plugins.Netherrocks.helpers.FyriteHandler;

public class FyriteSword extends SimpleSword 
{

	public FyriteSword() {
		super(Netherrocks.plugin, Content.toolFyrite);
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
	public EnumActionResult onItemUse(ItemStack stack, EntityPlayer playerIn,
			World worldIn, BlockPos pos, EnumHand hand, EnumFacing facing,
			float hitX, float hitY, float hitZ) 
	{
		EnumActionResult result 
			= FyriteHandler.INSTANCE.onItemUse(stack, playerIn, worldIn, pos, hand, facing, 
					hitX, hitY, hitZ);
		if (result != EnumActionResult.PASS) {
			return result;
		}
		else {
			return super.onItemUse(stack, playerIn, worldIn, pos, hand, facing, 
					hitX, hitY, hitZ);
		}
	} // onItemUse()

	
} // end class
