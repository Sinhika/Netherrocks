package mod.alexndr.netherrocks.helpers;

import mod.alexndr.netherrocks.init.ModItems;
import mod.alexndr.simplecorelib.helpers.IWeaponEffectHelper;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;

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
            target.addEffect(new EffectInstance(Effects.POISON, 50));
        }
        return false;
    }

} // end class
