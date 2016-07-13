package alexndr.plugins.Netherrocks.items;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;
import alexndr.api.content.items.SimpleArmor;
import alexndr.plugins.Netherrocks.Content;
import alexndr.plugins.Netherrocks.Netherrocks;

public class MalachiteArmor extends SimpleArmor 
{
	protected boolean hasJumpBoost = true;
	protected int jumpBoostFactor = 1;
	
	public MalachiteArmor(EntityEquipmentSlot slot, boolean hasJumpBoost, int jFactor) 
	{
		super(Netherrocks.plugin, Content.armorMalachite, slot);
		this.hasJumpBoost = hasJumpBoost;
		this.jumpBoostFactor = jFactor;
	}

	@Override
	public void onArmorTick(World world, EntityPlayer player,
			ItemStack itemStack) 
	{
		// must be wearing full set and not sneaking
		if (hasJumpBoost && this.isFullSet(player) && ! player.isSneaking()) 
		{
			player.addPotionEffect(
					new PotionEffect(MobEffects.JUMP_BOOST, 2, jumpBoostFactor));
		}
		super.onArmorTick(world, player, itemStack);
	}

	
} // end class
