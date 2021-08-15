package mod.alexndr.netherrocks.content;

import mod.alexndr.netherrocks.helpers.FyriteHandler;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.InteractionResult;

import net.minecraft.world.item.Item.Properties;

public class FyriteSwordItem extends SwordItem
{

    public FyriteSwordItem(Tier tier, int attackDamageIn, float attackSpeedIn, Properties builder)
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
    public InteractionResult useOn(UseOnContext context)
    {
        InteractionResult result = super.useOn(context);
        FyriteHandler.INSTANCE.onItemUse(context);
        return result;
    } // end onItemUse()
    
} // end class
