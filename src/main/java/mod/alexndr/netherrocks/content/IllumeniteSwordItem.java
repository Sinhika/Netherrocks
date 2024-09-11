package mod.alexndr.netherrocks.content;

import mod.alexndr.netherrocks.helpers.IllumeniteHandler;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.TooltipFlag;

import java.util.List;

public class IllumeniteSwordItem extends SwordItem
{

    public IllumeniteSwordItem()
    {
        super(NetherrocksItemTiers.ILLUMENITE, new Item.Properties().attributes(
                SwordItem.createAttributes(NetherrocksItemTiers.ILLUMENITE, 3, -2.4f));
    }

    @Override
    public boolean hurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker)
    {
        return IllumeniteHandler.INSTANCE.hitEntity(stack, target, attacker) &&
                super.hurtEnemy(stack, target, attacker);
    }
    
    @Override
    public void appendHoverText(ItemStack pStack, Item.TooltipContext pContext, List<Component> pTooltipComponents,
            TooltipFlag pIsAdvanced)
    {
        pTooltipComponents.add(Component.translatable("netherrocks.illumenite_sword.info"));
    }

} // end class
