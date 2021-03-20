package mod.alexndr.netherrocks.content;

import mod.alexndr.netherrocks.helpers.FyriteHandler;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUseContext;
import net.minecraft.item.SwordItem;
import net.minecraft.util.ActionResultType;

public class FyriteSwordItem extends SwordItem
{

    public FyriteSwordItem(IItemTier tier, int attackDamageIn, float attackSpeedIn, Properties builder)
    {
        super(tier, attackDamageIn, attackSpeedIn, builder);
    }

    @Override
    public boolean hurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker)
    {
        return  FyriteHandler.INSTANCE.hitEntity(stack, target, attacker)
                && super.hurtEnemy(stack, target, attacker);
    }

    @Override
    public ActionResultType useOn(ItemUseContext context)
    {
        ActionResultType result = super.useOn(context);
        FyriteHandler.INSTANCE.onItemUse(context);
        return result;
    } // end onItemUse()
    
} // end class
