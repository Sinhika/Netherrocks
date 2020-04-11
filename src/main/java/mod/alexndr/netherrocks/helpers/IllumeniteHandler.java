package mod.alexndr.netherrocks.helpers;

import mod.alexndr.netherrocks.config.NetherrocksConfig;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;

public class IllumeniteHandler implements IWeaponEffectHelper
{
    public static IllumeniteHandler INSTANCE = new IllumeniteHandler();

    /* singleton class, therefore private constructor */
    private IllumeniteHandler() {}

    /**
     * Hitting things blinds and slows the target, but it gives you night vision.
     * @param stack
     * @param target
     * @param attacker
     * @return
     */
    @Override
    public boolean hitEntity(ItemStack stack, LivingEntity target, LivingEntity attacker)
    {
        attacker.addPotionEffect(new EffectInstance(Effects.NIGHT_VISION, NetherrocksConfig.illumeniteNVTime));
        target.addPotionEffect(new EffectInstance(Effects.BLINDNESS, NetherrocksConfig.illumeniteBlindnessTime));
        target.addPotionEffect(new EffectInstance(Effects.SLOWNESS, 
                                NetherrocksConfig.illumeniteSlowTime, 
                                NetherrocksConfig.illumeniteSlowLevel));
        return true;
    } // end hitEntity


}  // end class IllumeniteHandler
