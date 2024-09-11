package mod.alexndr.netherrocks.content;

import net.minecraft.core.Holder;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.*;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

import java.util.List;

public class IllumeniteArmorItem extends ArmorItem
{
    public IllumeniteArmorItem(Holder<ArmorMaterial> materialIn, Type slot, Properties builder)
    {
        super(materialIn, slot, builder);
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public void appendHoverText(ItemStack stack, Item.TooltipContext pContext, List<Component> tooltip, TooltipFlag flagIn)
    {
        super.appendHoverText(stack, pContext, tooltip, flagIn);
        tooltip.add(Component.translatable("netherrocks.illumenite_armor.info"));
    }
}  // end class IllumeniteArmorItem
