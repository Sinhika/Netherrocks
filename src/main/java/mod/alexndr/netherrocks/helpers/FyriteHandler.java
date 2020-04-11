package mod.alexndr.netherrocks.helpers;

import net.minecraft.block.Blocks;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUseContext;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.common.extensions.IForgeBlockState;

public class FyriteHandler implements IWeaponEffectHelper
{
    public static FyriteHandler INSTANCE = new FyriteHandler();

    private FyriteHandler() {}

    /**
     * set target on fire if it's not already on fire.
     */
    @Override
    public boolean hitEntity(ItemStack stack, LivingEntity target, LivingEntity attacker)
    {
         if (target.getFireTimer() <= 100) {
             target.setFire(100);
         }
         return true;    
    } // end hitEntity()

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
        BlockPos adjacentPos = context.getPos();
        BlockPos pos = context.getPos();
        ItemStack stack = context.getItem();
        PlayerEntity playerIn = context.getPlayer();
        World worldIn = context.getWorld();
        
        if (stack.isEmpty()) {
            return ActionResultType.PASS;
        }
        switch (context.getFace()) 
        {
        case DOWN:
            adjacentPos = pos.down();
            break;
        case UP:
            adjacentPos = pos.up();
            break;
        case NORTH:
            adjacentPos = pos.north();
            break;
        case SOUTH:
            adjacentPos = pos.south();
            break;
        case EAST:
            adjacentPos = pos.east();
            break;
        case WEST:
            adjacentPos = pos.west();
            break;
        } // end switch
        if (!playerIn.canPlayerEdit(adjacentPos, context.getFace(), stack))
        {
            return ActionResultType.PASS;
        }
        IForgeBlockState targetBlock = worldIn.getBlockState(adjacentPos);
        if (targetBlock.isAir(worldIn, adjacentPos))
        {
            if (worldIn.isRemote) {
                playerIn.playSound(SoundEvents.BLOCK_FIRE_AMBIENT, 1.0F, 1.0F);
            }
            worldIn.setBlockState(adjacentPos, Blocks.FIRE.getDefaultState());
            stack.attemptDamageItem(1, worldIn.rand, null);
        }
        return ActionResultType.PASS;
    } // end onItemUse()
    
}  // end class FyriteHandler
