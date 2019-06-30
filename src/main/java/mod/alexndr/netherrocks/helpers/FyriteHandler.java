package mod.alexndr.netherrocks.helpers;

import mod.alexndr.netherrocks.Netherrocks;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUseContext;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid=Netherrocks.MODID, bus=Mod.EventBusSubscriber.Bus.FORGE)
public class FyriteHandler implements IWeaponEffectHelper, IHarvestEffectHelper
{
    public static FyriteHandler INSTANCE = new FyriteHandler();

    private FyriteHandler() {}

    @SubscribeEvent
    @Override
    public void onHarvestDrops(BlockEvent.HarvestDropsEvent event)
    {
        // TODO
    }

    @Override
    public boolean hitEntity(ItemStack stack, LivingEntity target, LivingEntity attacker)
    {
        // TODO
        return false;
    }

	 /** show flame flash after block auto-smelted
	 * @param world
	 * @param pos
	 * @param was_effective
	 */
    public void afterBlockSmelt(World world, BlockPos pos, boolean was_effective)
    {
        // TODO
    }

    public ActionResultType onItemUse(ItemUseContext context)
    {
        // TODO
        return ActionResultType.PASS;
    }
}  // end class FyriteHandler
