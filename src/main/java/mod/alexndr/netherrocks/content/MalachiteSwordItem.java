package mod.alexndr.netherrocks.content;

import java.util.List;

import mod.alexndr.netherrocks.helpers.MalachiteHandler;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;

public class MalachiteSwordItem extends SwordItem
{

    public MalachiteSwordItem()
    {
        super(NetherrocksItemTiers.MALACHITE, new Item.Properties().attributes(
                SwordItem.createAttributes(NetherrocksItemTiers.MALACHITE, 3, -2.4f)));
    }

    @Override
    public boolean hurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker)
    {
        return MalachiteHandler.INSTANCE.hitEntity(stack, target, attacker)
                && super.hurtEnemy(stack, target, attacker);
    }
    
    @Override
    public void appendHoverText(ItemStack pStack, Item.TooltipContext pContext, List<Component> pTooltipComponents,
                                TooltipFlag pIsAdvanced)
    {
        super.appendHoverText(pStack, pContext, pTooltipComponents, pIsAdvanced);
        pTooltipComponents.add(Component.translatable("netherrocks.malachite_sword.info"));
    }

} // end class
