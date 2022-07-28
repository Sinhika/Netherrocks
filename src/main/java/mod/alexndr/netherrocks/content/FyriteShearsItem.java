package mod.alexndr.netherrocks.content;

import java.util.List;

import javax.annotation.Nullable;

import mod.alexndr.netherrocks.helpers.FyriteHandler;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ShearsItem;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import net.minecraft.world.item.Item.Properties;

public class FyriteShearsItem extends ShearsItem
{

    public FyriteShearsItem(Properties p_43074_)
    {
        super(p_43074_);
    }

    
    @Override
    public InteractionResult interactLivingEntity(ItemStack stack, Player playerIn, LivingEntity entity,
            InteractionHand hand)
    {
        InteractionResult result =  super.interactLivingEntity(stack, playerIn, entity, hand);
        FyriteHandler.INSTANCE.hitEntity(stack, entity, playerIn);
        return result;
    }


    @Override
    public InteractionResult useOn(UseOnContext pContext)
    {
        InteractionResult result = super.useOn(pContext);
        FyriteHandler.INSTANCE.onItemUse(pContext);
        return result;
    }


    @Override
    @OnlyIn(Dist.CLIENT)
    public void appendHoverText(ItemStack stack, @Nullable Level worldIn, List<Component> tooltip, TooltipFlag flagIn)
    {
        super.appendHoverText(stack, worldIn, tooltip, flagIn);
        tooltip.add(new TranslatableComponent("netherrocks.fyrite_shears.info"));
    }

} // end class
