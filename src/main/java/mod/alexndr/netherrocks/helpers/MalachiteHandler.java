package mod.alexndr.netherrocks.helpers;

import mod.alexndr.netherrocks.init.ModItems;
import mod.alexndr.simplecorelib.api.helpers.IWeaponEffectHelper;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;

public class MalachiteHandler implements IWeaponEffectHelper
{
    public static MalachiteHandler INSTANCE = new MalachiteHandler();
    
    public MalachiteHandler()  {}

    @Override
    public boolean hitEntity(ItemStack stack, LivingEntity target, LivingEntity attacker)
    {
        if (stack.getItem() == ModItems.malachite_axe.get() 
                || stack.getItem() == ModItems.malachite_sword.get())
        {
            target.addEffect(new MobEffectInstance(MobEffects.POISON, 50));
        }
        return false;
    }

} // end class
