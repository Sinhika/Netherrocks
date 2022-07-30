package mod.alexndr.netherrocks.content;

import java.util.List;

import javax.annotation.Nullable;

import mod.alexndr.simplecorelib.api.helpers.ArmorUtils;
import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class MalachiteArmorItem extends ArmorItem
{

    protected final int jumpBoostFactor = 1;

    public MalachiteArmorItem(ArmorMaterial materialIn, EquipmentSlot slot, Properties builder)
    {
        super(materialIn, slot, builder);
    }

    @Override
    public void onArmorTick(ItemStack stack, Level world, Player player)
    {
 	// must be wearing full set and not sneaking
		if (ArmorUtils.isPlayerWearingFullSet(player, NetherrocksArmorMaterial.MALACHITE) 
				&& ! player.isShiftKeyDown())
		{
			player.addEffect(new MobEffectInstance(MobEffects.JUMP, 2, jumpBoostFactor, false, false));
					//new PotionEffect(MobEffects.JUMP_BOOST, 2, jumpBoostFactor));
		}
		super.onArmorTick(stack, world, player);
    } // end onArmorTick()

    @Override
    @OnlyIn(Dist.CLIENT)
    public void appendHoverText(ItemStack stack, @Nullable Level worldIn, List<Component> tooltip, TooltipFlag flagIn)
    {
        super.appendHoverText(stack, worldIn, tooltip, flagIn);
        tooltip.add(Component.translatable("netherrocks.malachite_armor.info"));
    }
}  // end class MalachiteArmorItem
