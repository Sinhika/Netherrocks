package mod.alexndr.netherrocks.helpers;

import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;

public class IllumeniteHandler implements IWeaponEffectHelper
{
    public static IllumeniteHandler INSTANCE = new IllumeniteHandler();

    /* singleton class, therefore private constructor */
    private IllumeniteHandler() {}

    /**
     * Hitting things is briefly blinding, but it gives you night vision.
     * @param stack
     * @param target
     * @param attacker
     * @return
     */
    @Override
    public boolean hitEntity(ItemStack stack, LivingEntity target, LivingEntity attacker)
    {
        // TODO
        return false;
    } // end hitEntity


}  // end class IllumeniteHandler
