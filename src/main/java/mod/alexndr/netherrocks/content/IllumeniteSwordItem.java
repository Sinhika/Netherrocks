package mod.alexndr.netherrocks.content;

import java.util.List;

import mod.alexndr.netherrocks.helpers.IllumeniteHandler;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;

import net.minecraft.world.item.Item.Properties;

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
    
    @Override
    public void appendHoverText(ItemStack pStack, Level pLevel, List<Component> pTooltipComponents,
            TooltipFlag pIsAdvanced)
    {
        super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
        pTooltipComponents.add(new TranslatableComponent("netherrocks.illumenite_sword.info"));
    }

} // end class
