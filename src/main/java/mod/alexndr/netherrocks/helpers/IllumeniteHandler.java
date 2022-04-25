package mod.alexndr.netherrocks.helpers;

import mod.alexndr.netherrocks.config.NetherrocksConfig;
import mod.alexndr.simplecorelib.api.helpers.IWeaponEffectHelper;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;

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
        attacker.addEffect(new MobEffectInstance(MobEffects.NIGHT_VISION, NetherrocksConfig.illumeniteNVTime));
        target.addEffect(new MobEffectInstance(MobEffects.BLINDNESS, NetherrocksConfig.illumeniteBlindnessTime));
        target.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 
                                NetherrocksConfig.illumeniteSlowTime, 
                                NetherrocksConfig.illumeniteSlowLevel));
        return true;
    } // end hitEntity


}  // end class IllumeniteHandler
