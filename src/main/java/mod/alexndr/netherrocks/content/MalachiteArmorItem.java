package mod.alexndr.netherrocks.content;

import java.util.List;

import javax.annotation.Nullable;

import mod.alexndr.simplecorelib.helpers.ArmorUtils;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class MalachiteArmorItem extends ArmorItem
{

    protected final int jumpBoostFactor = 1;

    public MalachiteArmorItem(IArmorMaterial materialIn, EquipmentSlotType slot, Properties builder)
    {
        super(materialIn, slot, builder);
    }

    @Override
    public void onArmorTick(ItemStack stack, World world, PlayerEntity player)
    {
 	// must be wearing full set and not sneaking
		if (ArmorUtils.isPlayerWearingFullSet(player, NetherrocksArmorMaterial.MALACHITE) 
				&& ! player.isSneaking())
		{
			player.addPotionEffect(new EffectInstance(Effects.JUMP_BOOST, 2, jumpBoostFactor, false, false));
					//new PotionEffect(MobEffects.JUMP_BOOST, 2, jumpBoostFactor));
		}
		super.onArmorTick(stack, world, player);
    } // end onArmorTick()

    @Override
    @OnlyIn(Dist.CLIENT)
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn)
    {
        super.addInformation(stack, worldIn, tooltip, flagIn);
        tooltip.add(new TranslationTextComponent("netherrocks.malachite_armor.info"));
    }
}  // end class MalachiteArmorItem
