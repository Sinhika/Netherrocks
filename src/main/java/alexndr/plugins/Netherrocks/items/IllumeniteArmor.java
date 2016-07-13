package alexndr.plugins.Netherrocks.items;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.EntityEquipmentSlot;
import alexndr.api.content.items.SimpleArmor;
import alexndr.plugins.Netherrocks.Content;
import alexndr.plugins.Netherrocks.Netherrocks;

public class IllumeniteArmor extends SimpleArmor 
{
	protected boolean noFallDamage = true;
	
	public IllumeniteArmor(EntityEquipmentSlot slot, boolean noFallDamage) 
	{
		super(Netherrocks.plugin, Content.armorIllumenite, slot);
		this.noFallDamage = noFallDamage;
	}

	public boolean preventsFallDamage(EntityPlayer player) 
	{
		if (noFallDamage && isFullSet(player)) {
			return true;
		}
		return false;
	}
} // end class
