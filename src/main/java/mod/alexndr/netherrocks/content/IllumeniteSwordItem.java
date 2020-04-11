package mod.alexndr.netherrocks.content;

import mod.alexndr.netherrocks.helpers.IllumeniteHandler;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;

public class IllumeniteSwordItem extends SwordItem
{

    public IllumeniteSwordItem(IItemTier tier, int attackDamageIn, float attackSpeedIn, Properties builder)
    {
        super(tier, attackDamageIn, attackSpeedIn, builder);
    }

    @Override
    public boolean hitEntity(ItemStack stack, LivingEntity target, LivingEntity attacker)
    {
        return IllumeniteHandler.INSTANCE.hitEntity(stack, target, attacker) &&
                super.hitEntity(stack, target, attacker);
    }
    
} // end class
