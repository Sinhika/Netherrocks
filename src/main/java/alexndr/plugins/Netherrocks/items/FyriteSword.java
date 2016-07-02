package alexndr.plugins.Netherrocks.items;

import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import alexndr.api.content.items.SimpleSword;
import alexndr.plugins.Netherrocks.Content;
import alexndr.plugins.Netherrocks.Netherrocks;

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
		if (!target.isBurning()) {
			target.setFire(100);
		}
		return super.hitEntity(stack, target, attacker);
	} // end hitEntity

	@Override
	public EnumActionResult onItemUse(ItemStack stack, EntityPlayer playerIn,
			World worldIn, BlockPos pos, EnumHand hand, EnumFacing facing,
			float hitX, float hitY, float hitZ) 
	{
		BlockPos adjacentPos = pos;
		switch (facing) 
		{
		case DOWN:
			adjacentPos = pos.down();
			break;
		case UP:
			adjacentPos = pos.up();
			break;
		case NORTH:
			adjacentPos = pos.north();
			break;
		case SOUTH:
			adjacentPos = pos.south();
			break;
		case EAST:
			adjacentPos = pos.east();
			break;
		case WEST:
			adjacentPos = pos.west();
			break;
		} // end switch
		if (!playerIn.canPlayerEdit(adjacentPos, facing, stack))
		{
	        return EnumActionResult.PASS;
		}
		IBlockState targetBlock = worldIn.getBlockState(adjacentPos);
		if (targetBlock.getBlock().isAir(targetBlock, worldIn, adjacentPos))
		{
			playerIn.playSound(SoundEvents.BLOCK_FIRE_AMBIENT, 1.0F, 1.0F);
			worldIn.setBlockState(adjacentPos, Blocks.FIRE.getDefaultState());
			stack.attemptDamageItem(1, worldIn.rand);
		}
		return super.onItemUse(stack, playerIn, worldIn, pos, hand, facing, hitX, hitY,
				hitZ);
	} // onItemUse()

	
} // end class
