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

public class FyritePickaxeIteam extends PickaxeItem
{

    public FyritePickaxeIteam()
    {
        super(NetherrocksItemTiers.FYRITE, new Item.Properties().attributes(
                PickaxeItem.createAttributes(NetherrocksItemTiers.FYRITE,1, -2.8F)));
    }

    @Override
    public boolean mineBlock(ItemStack stack, Level worldIn, BlockState state, BlockPos pos,
            LivingEntity entityLiving)
    {
        FyriteHandler.INSTANCE.afterBlockSmelt(worldIn, pos, true);
        return super.mineBlock(stack, worldIn, state, pos, entityLiving);
    }

    @Override
    public InteractionResult useOn(UseOnContext context)
    {
        InteractionResult result = super.useOn(context);
        FyriteHandler.INSTANCE.onItemUse(context);
        return result;
    }

    @Override
    public void appendHoverText(ItemStack pStack, Item.TooltipContext pContext, List<Component> pTooltipComponents,
            TooltipFlag pIsAdvanced)
    {
        super.appendHoverText(pStack, pContext, pTooltipComponents, pIsAdvanced);
        pTooltipComponents.add(Component.translatable("netherrocks.fyrite_pickaxe.info"));
    }

} // end class
