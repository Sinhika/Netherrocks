package mod.alexndr.netherrocks.content;

import mod.alexndr.netherrocks.init.ModTiles;
import mod.alexndr.simplecorelib.api.content.VeryAbstractFurnaceBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.stats.Stats;
import net.minecraft.world.Containers;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.items.ItemStackHandler;
import net.minecraftforge.network.NetworkHooks;

import net.minecraft.world.level.block.state.BlockBehaviour.Properties;

public class NetherFurnaceBlock extends VeryAbstractFurnaceBlock
{
    private static final String DISPLAY_NAME = "block.netherrocks.nether_furnace";

   public NetherFurnaceBlock(final Properties builder)
    {
        super(builder);
    } // end ctor


    /**
    * Called on the logical server when a BlockState with a TileEntity is replaced by another BlockState.
    * We use this method to drop all the items from our tile entity's inventory and update comparators near our block.
    *
    * @deprecated Call via {@link BlockState#onReplaced(World, BlockPos, BlockState, boolean)}
    * Implementing/overriding is fine.
    */
   @SuppressWarnings("dep-ann")
@Override
   public void onRemove(BlockState oldState, Level worldIn, BlockPos pos, BlockState newState, boolean isMoving) 
   {
        if (oldState.getBlock() != newState.getBlock())
        {
            BlockEntity tileEntity = worldIn.getBlockEntity(pos);
            if (tileEntity instanceof NetherFurnaceTileEntity)
            {
                final ItemStackHandler inventory = ((NetherFurnaceTileEntity) tileEntity).inventory;
                for (int slot = 0; slot < inventory.getSlots(); ++slot)
                    Containers.dropItemStack(worldIn, pos.getX(), pos.getY(), pos.getZ(),
                            inventory.getStackInSlot(slot));
            }
        }
        // call this or tile entities don't get cleaned up!
        super.onRemove(oldState, worldIn, pos, newState, isMoving);
    }

	@Override
	public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level, BlockState bstate, BlockEntityType<T> entityType) 
	{
		return createFurnaceTicker(level, entityType, ModTiles.NETHER_FURNACE.get());
	}


	@Override
	public BlockEntity newBlockEntity(BlockPos bpos, BlockState bstate) {
		return new NetherFurnaceTileEntity(bpos, bstate);
	}


   @Override
    protected void openContainer(Level level, BlockPos bpos, Player player) 
    {
        BlockEntity be = level.getBlockEntity(bpos);
        if (be instanceof NetherFurnaceTileEntity) 
        {
            MenuProvider containerProvider = new MenuProvider() {
                @Override
                public Component getDisplayName() {
                    return new TranslatableComponent(DISPLAY_NAME);
                }
                
                @Override
                public AbstractContainerMenu createMenu(int windowId, Inventory playerInventory, Player playerEntity)
                {
                    return new NetherFurnaceContainer(windowId, playerInventory, bpos, playerEntity);
                }
            }; // end anonymous-class
            NetworkHooks.openScreen((ServerPlayer) player, containerProvider, be.getBlockPos());
            player.awardStat(Stats.INTERACT_WITH_FURNACE);
        } // end-if
        else {
            throw new IllegalStateException("Our named container provider is missing!");
        }
    } // end openContainer

}  // end class NetherFurnaceBlock
