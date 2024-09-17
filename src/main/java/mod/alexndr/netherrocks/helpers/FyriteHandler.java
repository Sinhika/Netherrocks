package mod.alexndr.netherrocks.helpers;

import mod.alexndr.simplecorelib.api.helpers.IWeaponEffectHelper;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseFireBlock;
import net.minecraft.world.level.block.CampfireBlock;
import net.minecraft.world.level.block.CandleBlock;
import net.minecraft.world.level.block.CandleCakeBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.gameevent.GameEvent;

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
         if (target.getRemainingFireTicks() <= 100) {
             target.igniteForSeconds(100);
         }
         return true;    
    } // end hitEntity()

	 /** show flame flash after block auto-smelted
	 * @param world
	 * @param pos
	 * @param was_effective
	 */
    public void afterBlockSmelt(Level world, BlockPos pos, boolean was_effective)
    {
        //Netherrocks.LOGGER.info("tried to after-smelt");
        if (was_effective && world.isClientSide())
        {
            RandomSource random = world.random;
            for(int i = 0; i < 3; i++) {
                world.addParticle(ParticleTypes.FLAME,
                                    pos.getX() + random.nextDouble() * 0.6D,
                                    pos.getY() + random.nextDouble() * 0.6D, 
                                    pos.getZ() + random.nextDouble() * 0.6D,
                                    0.0D, 0.0D, 0.0D);
            } // end-for    
        } // end-if
    }

    public InteractionResult onItemUse(UseOnContext context)
    {
        BlockPos pos = context.getClickedPos();
        ItemStack stack = context.getItemInHand();
        Player playerIn = context.getPlayer();
        Level worldIn = context.getLevel();
        BlockState blockstate = worldIn.getBlockState(pos);

        if (stack.isEmpty()) {
            return InteractionResult.FAIL;
        }
        BlockPos adjacentPos = pos.relative(context.getClickedFace());
        
        if (!playerIn.mayUseItemAt(adjacentPos, context.getClickedFace(), stack))
        {
            return InteractionResult.FAIL;
        }
        if (!CampfireBlock.canLight(blockstate) && !CandleBlock.canLight(blockstate) && !CandleCakeBlock.canLight(blockstate)) 
        {
	        if (BaseFireBlock.canBePlacedAt(worldIn, adjacentPos, context.getHorizontalDirection())) 
	        {
	            worldIn.playSound(playerIn, adjacentPos, SoundEvents.FIRE_AMBIENT, SoundSource.BLOCKS, 1.0F, 1.0F);
	            BlockState blockstate1 = BaseFireBlock.getState(worldIn, adjacentPos);
	            worldIn.setBlock(adjacentPos, blockstate1, 11);
	            worldIn.gameEvent(playerIn, GameEvent.BLOCK_PLACE, pos);
	            ItemStack itemstack = context.getItemInHand();
	            if (playerIn instanceof ServerPlayer) 
	            {
	               CriteriaTriggers.PLACED_BLOCK.trigger((ServerPlayer) playerIn, adjacentPos, itemstack);
	               itemstack.hurtAndBreak(1, playerIn, LivingEntity.getSlotForHand(context.getHand()));
	            } // end-if ServerPlayer

	            return InteractionResult.sidedSuccess(worldIn.isClientSide());
	        } // end if can place fire
	        else {
	            return InteractionResult.FAIL;
	         }
        } // end-if not campfire, candle, etc.
        else {
        	worldIn.playSound(playerIn, pos, SoundEvents.FLINTANDSTEEL_USE, SoundSource.BLOCKS, 1.0F, worldIn.getRandom().nextFloat() * 0.4F + 0.8F);
        	worldIn.setBlock(pos, blockstate.setValue(BlockStateProperties.LIT, Boolean.valueOf(true)), 11);
        	worldIn.gameEvent(playerIn, GameEvent.BLOCK_PLACE, pos);
            if (playerIn != null) {
            	context.getItemInHand().hurtAndBreak(1, playerIn, LivingEntity.getSlotForHand(context.getHand()));
            }
            return InteractionResult.sidedSuccess(worldIn.isClientSide());
         }
    } // end onItemUse()
    
}  // end class FyriteHandler
