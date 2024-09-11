package mod.alexndr.netherrocks.content;

import java.util.List;

import javax.annotation.Nullable;

import mod.alexndr.netherrocks.init.ModArmorMaterials;
import mod.alexndr.simplecorelib.api.helpers.ArmorUtils;
import net.minecraft.core.Holder;
import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

public class MalachiteArmorItem extends ArmorItem
{

    protected final int jumpBoostFactor = 1;

    public MalachiteArmorItem(Holder<ArmorMaterial> materialIn, Type slot, Properties builder)
    {
        super(materialIn, slot, builder);
    }

    @Override
    public void inventoryTick(ItemStack stack, Level world, Entity player, int pSlotId, boolean pIsSelected)
    {
        /* suggested replacement for stupidly obsolete onArmorTick */
        if (pSlotId >= 36 && pSlotId <= 39)
        {
            // must be wearing full set and not sneaking
            if (ArmorUtils.isPlayerWearingFullSet((Player) player, ModArmorMaterials.MALACHITE.value())
                    && !player.isShiftKeyDown()) {
                ((Player) player).addEffect(new MobEffectInstance(MobEffects.JUMP, 2, jumpBoostFactor, false, false));
                //new PotionEffect(MobEffects.JUMP_BOOST, 2, jumpBoostFactor));
            }
        }
		super.inventoryTick(stack, world, player, pSlotId, pIsSelected);
    } // end onArmorTick()

    @Override
    @OnlyIn(Dist.CLIENT)
    public void appendHoverText(ItemStack stack, Item.TooltipContext pContext, List<Component> tooltip, TooltipFlag flagIn)
    {
        super.appendHoverText(stack, pContext, tooltip, flagIn);
        tooltip.add(Component.translatable("netherrocks.malachite_armor.info"));
    }
}  // end class MalachiteArmorItem
