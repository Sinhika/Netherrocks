package mod.alexndr.netherrocks.content;

import mod.alexndr.netherrocks.api.content.AbstractNetherBlastFurnaceBlock;
import mod.alexndr.netherrocks.init.ModTiles;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.entity.player.Player;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.Containers;
import net.minecraft.stats.Stats;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionHand;
import net.minecraft.core.BlockPos;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraftforge.fml.network.NetworkHooks;
import net.minecraftforge.items.ItemStackHandler;

import net.minecraft.world.level.block.state.BlockBehaviour.Properties;

public class NetherBlastFurnaceBlock extends AbstractNetherBlastFurnaceBlock
{

    public NetherBlastFurnaceBlock(Properties builder)
    {
        super(builder);
    }

    @Override
    public BlockEntity createTileEntity(BlockState state, BlockGetter world)
    {
        return ModTiles.NETHER_BLAST_FURNACE.get().create();
    }

    @SuppressWarnings("deprecation")
    @Override
    public void onRemove(BlockState oldState, Level worldIn, BlockPos pos, BlockState newState, boolean isMoving)
    {
        if (oldState.getBlock() != newState.getBlock())
        {
            BlockEntity tileEntity = worldIn.getBlockEntity(pos);
            if (tileEntity instanceof NetherBlastFurnaceTileEntity)
            {
                final ItemStackHandler inventory = ((NetherBlastFurnaceTileEntity) tileEntity).inventory;
                for (int slot = 0; slot < inventory.getSlots(); ++slot)
                    Containers.dropItemStack(worldIn, pos.getX(), pos.getY(), pos.getZ(),
                            inventory.getStackInSlot(slot));
            }
        }
        // call this or tile entities don't get cleaned up!
        super.onRemove(oldState, worldIn, pos, newState, isMoving);
    } // end onRemove

    @Override
    public InteractionResult use(BlockState state, Level worldIn, BlockPos pos, Player player,
            InteractionHand handIn, BlockHitResult hit)
    {
        if (!worldIn.isClientSide) {
            final BlockEntity tileEntity = worldIn.getBlockEntity(pos);
            if (tileEntity instanceof NetherBlastFurnaceTileEntity) 
            {
                NetworkHooks.openGui((ServerPlayer) player, (NetherBlastFurnaceTileEntity) tileEntity, pos);
                player.awardStat(Stats.INTERACT_WITH_BLAST_FURNACE);
            }
        }
        return InteractionResult.SUCCESS;
    }

} // end class
