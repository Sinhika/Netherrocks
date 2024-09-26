package mod.alexndr.netherrocks.content;

import mod.alexndr.netherrocks.config.NetherrocksConfig;
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

import java.util.List;

public class IllumeniteArmorItem extends ArmorItem
{
    public IllumeniteArmorItem(Holder<ArmorMaterial> materialIn, Type slot, Properties builder)
    {
        super(materialIn, slot, builder);
    }

    /**
     * Called each tick as long the item is in a player's inventory. Used by maps to check if it's in a player's hand and update its contents.
     *
     * @param stack
     * @param level
     * @param entity
     * @param slotId
     * @param isSelected
     */
    @Override public void inventoryTick(ItemStack stack, Level level, Entity entity, int slotId, boolean isSelected)
    {
        /* suggested replacement for stupidly obsolete onArmorTick */
        if (slotId >= 36 && slotId <= 39)
        {
            // must be wearing full set and not sneaking
            if (NetherrocksConfig.illumeniteHasGlowingEffect &&
                    ArmorUtils.isPlayerWearingFullSet((Player) entity, ModArmorMaterials.ILLUMENITE.value()))

            {
                ((Player) entity).addEffect(new MobEffectInstance(MobEffects.GLOWING, 20, 0));
            }
        }
        super.inventoryTick(stack, level, entity, slotId, isSelected);
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public void appendHoverText(ItemStack stack, Item.TooltipContext pContext, List<Component> tooltip, TooltipFlag flagIn)
    {
        super.appendHoverText(stack, pContext, tooltip, flagIn);
        tooltip.add(Component.translatable("netherrocks.illumenite_armor.info"));
    }
}  // end class IllumeniteArmorItem
