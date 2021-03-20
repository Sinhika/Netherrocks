package mod.alexndr.netherrocks.content;

import mod.alexndr.netherrocks.helpers.FyriteHandler;
import net.minecraft.block.BlockState;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.AxeItem;
import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUseContext;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class FyriteAxeItem extends AxeItem
{

    public FyriteAxeItem(IItemTier tier, float attackDamageIn, float attackSpeedIn, Properties builder)
    {
        super(tier, attackDamageIn, attackSpeedIn, builder);
    }

    @Override
    public ActionResultType useOn(ItemUseContext context)
    {
        ActionResultType result = super.useOn(context);
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
    public boolean mineBlock(ItemStack stack, World worldIn, BlockState state, BlockPos pos,
            LivingEntity entityLiving)
    {
        FyriteHandler.INSTANCE.afterBlockSmelt(worldIn, pos, true);
        return super.mineBlock(stack, worldIn, state, pos, entityLiving);
    }


} // end class
