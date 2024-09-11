package mod.alexndr.netherrocks.content;

import java.util.List;

import mod.alexndr.netherrocks.helpers.FyriteHandler;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.*;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;

public class FyriteAxeItem extends AxeItem
{

    public FyriteAxeItem()
    {
        super(NetherrocksItemTiers.FYRITE, new Item.Properties().attributes(
                AxeItem.createAttributes(NetherrocksItemTiers.FYRITE, 5.0F, -3.1F)));
    }

    @Override
    public InteractionResult useOn(UseOnContext context)
    {
        InteractionResult result = super.useOn(context);
        FyriteHandler.INSTANCE.onItemUse(context);
        return result;
    }

    @Override
    public boolean hurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker)
    {
        return FyriteHandler.INSTANCE.hitEntity(stack, target, attacker)
                && super.hurtEnemy(stack, target, attacker);
    }

    @Override
    public boolean mineBlock(ItemStack stack, Level worldIn, BlockState state, BlockPos pos,
            LivingEntity entityLiving)
    {
        FyriteHandler.INSTANCE.afterBlockSmelt(worldIn, pos, true);
        return super.mineBlock(stack, worldIn, state, pos, entityLiving);
    }

    @Override
    public void appendHoverText(ItemStack pStack, Item.TooltipContext pContext, List<Component> pTooltipComponents,
            TooltipFlag pIsAdvanced)
    {
        super.appendHoverText(pStack, pContext, pTooltipComponents, pIsAdvanced);
        pTooltipComponents.add(Component.translatable("netherrocks.fyrite_axe.info"));
    }


} // end class
