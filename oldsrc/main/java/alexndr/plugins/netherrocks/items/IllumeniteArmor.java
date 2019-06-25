package alexndr.plugins.netherrocks.items;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.EntityEquipmentSlot;
import alexndr.api.content.items.SimpleArmor;
import alexndr.plugins.netherrocks.Content;
import alexndr.plugins.netherrocks.Netherrocks;

public class IllumeniteArmor extends SimpleArmor 
{
	protected boolean noFallDamage = true;
	
	public IllumeniteArmor(String name, EntityEquipmentSlot slot, boolean noFallDamage) 
	{
		super(name, Netherrocks.plugin, Content.armorIllumenite, slot);
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