package alexndr.plugins.Netherrocks.items;

import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import alexndr.api.content.items.SimplePickaxe;
import alexndr.plugins.Netherrocks.Content;
import alexndr.plugins.Netherrocks.Netherrocks;
import alexndr.plugins.Netherrocks.helpers.FyriteHandler;

public class FyritePickaxe extends SimplePickaxe 
{

	public FyritePickaxe() 
	{
		super(Netherrocks.plugin, Content.toolFyrite);
	}

	@Override
	public boolean onBlockDestroyed(ItemStack stack, World worldIn,
			IBlockState state, BlockPos pos, EntityLivingBase entityLiving) 
	{
		FyriteHandler.INSTANCE.afterBlockSmelt(worldIn, pos, true);

		return super.onBlockDestroyed(stack, worldIn, state, pos, entityLiving);
	}

	@Override
	public EnumActionResult clOnItemUse(EntityPlayer playerIn,
			World worldIn, BlockPos pos, EnumHand hand, EnumFacing facing,
			float hitX, float hitY, float hitZ) 
	{
		EnumActionResult result 
			= FyriteHandler.INSTANCE.onItemUse(playerIn, worldIn, pos, hand, facing, 
					hitX, hitY, hitZ);
		if (result != EnumActionResult.PASS) {
			return result;
		}
		else {
			return super.clOnItemUse(playerIn, worldIn, pos, hand, facing, 
					hitX, hitY, hitZ);
		}
	} // onItemUse()

	
} // end class
