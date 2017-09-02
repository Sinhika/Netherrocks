package alexndr.plugins.Netherrocks.helpers;

import alexndr.api.content.items.SimpleArmor;
import alexndr.api.helpers.game.IWeaponEffectHelper;
import alexndr.plugins.Netherrocks.Settings;
import alexndr.plugins.Netherrocks.items.IllumeniteArmor;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraftforge.event.entity.living.LivingFallEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

/** Helper class for handling Illumenite properties */
public class IllumeniteHandler implements IWeaponEffectHelper
{
	public static IllumeniteHandler INSTANCE = new IllumeniteHandler();
	
	/* singleton class, therefore private constructor */
	private IllumeniteHandler() {
	}

	/**
	 * Hitting things is briefly blinding, but it gives you night vision.
	 * @param stack
	 * @param target
	 * @param attacker
	 * @return
	 */
	public boolean hitEntity(ItemStack stack, EntityLivingBase target,
			EntityLivingBase attacker) 
	{
        attacker.addPotionEffect(new PotionEffect(MobEffects.NIGHT_VISION, Settings.illumeniteNVTime));
        attacker.addPotionEffect(new PotionEffect(MobEffects.BLINDNESS, Settings.illumeniteBlindnessTime));
        if(!(target instanceof EntityPlayer))
        {
        	target.addPotionEffect(new PotionEffect(MobEffects.SLOWNESS, 
        			Settings.illumeniteSlowTime,Settings.illumeniteSlowLevel));
        }
		return true;
	} // end hitEntity

	@SubscribeEvent
	public void onLivingFallEvent(LivingFallEvent event)
	{
		// first, is it a player?
		if (event.getEntityLiving() instanceof EntityPlayer)
		{
			EntityPlayer player = (EntityPlayer) event.getEntityLiving();
			ItemArmor[] armor = { null, null, null, null };
			SimpleArmor.getArmorSet(player, armor);
			
			// second, is player wearing an IllumeniteArmor?
			if ( ! (armor[0] instanceof IllumeniteArmor))
			{
				return;
			}
			IllumeniteArmor apiece = (IllumeniteArmor) armor[0];
			
			// is illumenite armor actually set to prevent fall damage?
			// (IllumeniteArmor.preventsFallDamage() also checks for wearing
			//  a full set)
			if ( apiece.preventsFallDamage(player)) 
			{
				event.setDamageMultiplier(0.0F);
			}
		} // end-if player
	} // end onLivingFallEvent
} // end class
