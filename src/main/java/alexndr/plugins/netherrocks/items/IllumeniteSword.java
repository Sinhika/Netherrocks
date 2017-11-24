package alexndr.plugins.netherrocks.items;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import alexndr.api.content.items.SimpleSword;
import alexndr.plugins.netherrocks.Content;
import alexndr.plugins.netherrocks.Netherrocks;
import alexndr.plugins.netherrocks.helpers.IllumeniteHandler;

public class IllumeniteSword extends SimpleSword {

	public IllumeniteSword(String name) 
	{
		super(name, Netherrocks.plugin, Content.toolIllumenite);
		addToolTip("netherrocks.illumenite_sword.info");
	}

	@Override
	public boolean hitEntity(ItemStack stack, EntityLivingBase target,
			EntityLivingBase attacker) 
	{
		return IllumeniteHandler.INSTANCE.hitEntity(stack, target, attacker) &&
				super.hitEntity(stack, target, attacker);
	}


} // end class
