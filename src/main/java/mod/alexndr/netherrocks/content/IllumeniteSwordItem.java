package mod.alexndr.netherrocks.content;

import mod.alexndr.netherrocks.helpers.IllumeniteHandler;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;

public class IllumeniteSwordItem extends SwordItem
{

    public IllumeniteSwordItem(Tier tier, int attackDamageIn, float attackSpeedIn, Properties builder)
    {
        super(tier, attackDamageIn, attackSpeedIn, builder);
    }

    @Override
    public boolean hurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker)
    {
        return IllumeniteHandler.INSTANCE.hitEntity(stack, target, attacker) &&
                super.hurtEnemy(stack, target, attacker);
    }
    
} // end class
