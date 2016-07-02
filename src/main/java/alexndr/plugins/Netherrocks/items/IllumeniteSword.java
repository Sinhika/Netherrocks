package alexndr.plugins.Netherrocks.items;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import alexndr.api.content.items.SimpleSword;
import alexndr.plugins.Netherrocks.Content;
import alexndr.plugins.Netherrocks.Netherrocks;
import alexndr.plugins.Netherrocks.Settings;

public class IllumeniteSword extends SimpleSword {

	public IllumeniteSword() 
	{
		super(Netherrocks.plugin, Content.toolIllumenite);
		addToolTip("netherrocks.illumenite_sword.info");
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean hitEntity(ItemStack stack, EntityLivingBase target,
			EntityLivingBase attacker) 
	{
        attacker.addPotionEffect(new PotionEffect(MobEffects.NIGHT_VISION, Settings.illumeniteNVTime.asInt()));
        attacker.addPotionEffect(new PotionEffect(MobEffects.BLINDNESS, Settings.illumeniteBlindnessTime.asInt()));
        if(!(target instanceof EntityPlayer))
        {
        	target.addPotionEffect(new PotionEffect(MobEffects.SLOWNESS, 
        			Settings.illumeniteSlowTime.asInt(), 
        			Settings.illumeniteSlowLevel.asInt()));
        }
		return super.hitEntity(stack, target, attacker);
	}


} // end class
