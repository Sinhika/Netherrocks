package mod.alexndr.netherrocks.helpers;

import mod.alexndr.netherrocks.ModUtil;
import mod.alexndr.netherrocks.Netherrocks;
import mod.alexndr.netherrocks.content.NetherrocksArmorMaterial;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.living.LivingFallEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid= Netherrocks.MODID, bus=Mod.EventBusSubscriber.Bus.FORGE)
public class IllumeniteHandler implements IWeaponEffectHelper
{
    public static IllumeniteHandler INSTANCE = new IllumeniteHandler();

    /* singleton class, therefore private constructor */
    private IllumeniteHandler() {}

    /**
     * Hitting things is briefly blinding, but it gives you night vision.
     * @param stack
     * @param target
     * @param attacker
     * @return
     */
    @Override
    public boolean hitEntity(ItemStack stack, LivingEntity target, LivingEntity attacker)
    {
        // TODO
        return false;
    } // end hitEntity

    @SubscribeEvent
    public void onLivingFallEvent(LivingFallEvent event)
    {
        // first, is it a player?
        if (event.getEntityLiving() instanceof PlayerEntity)
        {
            PlayerEntity player = (PlayerEntity) event.getEntityLiving();

            // are they wearing full illumenite armor?
            if (ModUtil.isPlayerWearingFullSet(player,
                                               NetherrocksArmorMaterial.ILLUMENITE))
            {
                event.setDamageMultiplier(0.0F);
            } // end-if full set of Illumenite
        } // end-if player
    } // end onLivingFallEvent

}  // end class IllumeniteHandler
