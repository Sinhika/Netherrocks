package mod.alexndr.netherrocks.content;

import mod.alexndr.netherrocks.helpers.FyriteHandler;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.*;
import net.minecraft.world.item.context.UseOnContext;

import java.util.List;

public class FyriteSwordItem extends SwordItem
{

    public FyriteSwordItem()
    {
        super(NetherrocksItemTiers.FYRITE, new Item.Properties().attributes(
                SwordItem.createAttributes(NetherrocksItemTiers.FYRITE, 3, -2.4f)));
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
    
    @Override
    public void appendHoverText(ItemStack pStack, Item.TooltipContext pContext, List<Component> pTooltipComponents,
            TooltipFlag pIsAdvanced)
    {
        super.appendHoverText(pStack, pContext, pTooltipComponents, pIsAdvanced);
        pTooltipComponents.add(Component.translatable("netherrocks.fyrite_sword.info"));
    }


} // end class
