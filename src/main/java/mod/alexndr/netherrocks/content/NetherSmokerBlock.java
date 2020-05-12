package mod.alexndr.netherrocks.content;

import mod.alexndr.netherrocks.api.content.AbstractNetherSmokerBlock;
import mod.alexndr.netherrocks.init.ModTiles;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.stats.Stats;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.NetworkHooks;
import net.minecraftforge.items.ItemStackHandler;

public class NetherSmokerBlock extends AbstractNetherSmokerBlock
{

    public NetherSmokerBlock(Properties builder)
    {
        super(builder);
    }

    @Override
    public TileEntity createTileEntity(BlockState state, IBlockReader world)
    {
        return ModTiles.NETHER_SMOKER.get().create();
    }

    @Override
    public void onReplaced(BlockState oldState, World worldIn, BlockPos pos, BlockState newState, boolean isMoving)
    {
        if (oldState.getBlock() != newState.getBlock())
        {
            TileEntity tileEntity = worldIn.getTileEntity(pos);
            if (tileEntity instanceof NetherSmokerTileEntity)
            {
                final ItemStackHandler inventory = ((NetherSmokerTileEntity) tileEntity).inventory;
                for (int slot = 0; slot < inventory.getSlots(); ++slot)
                    InventoryHelper.spawnItemStack(worldIn, pos.getX(), pos.getY(), pos.getZ(),
                            inventory.getStackInSlot(slot));
            }
        }
    }

    @Override
    public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player,
            Hand handIn, BlockRayTraceResult hit)
    {
        if (!worldIn.isRemote) {
            final TileEntity tileEntity = worldIn.getTileEntity(pos);
            if (tileEntity instanceof NetherSmokerTileEntity) 
            {
                NetworkHooks.openGui((ServerPlayerEntity) player, (NetherSmokerTileEntity) tileEntity, pos);
                player.addStat(Stats.INTERACT_WITH_SMOKER);
            }
        }
        return ActionResultType.SUCCESS;

    }

} // end-class
