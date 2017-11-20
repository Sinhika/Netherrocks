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

public class FyriteArmor extends SimpleArmor 
{
	protected boolean isFireproof = true;
	
	/** constructor */
	public FyriteArmor(String name, EntityEquipmentSlot slot, boolean isFireproof) 
	{
		super(name, Netherrocks.plugin, Content.armorFyrite, slot);
		this.isFireproof = isFireproof;
	}

	@Override
	public void onArmorTick(World world, EntityPlayer player,
			ItemStack itemStack) 
	{
		if (isFireproof && this.isFullSet(player))
		{
			player.addPotionEffect(new PotionEffect(MobEffects.FIRE_RESISTANCE, 2));
		}
		super.onArmorTick(world, player, itemStack);
	} // end onArmorTick.

	
} // end class
