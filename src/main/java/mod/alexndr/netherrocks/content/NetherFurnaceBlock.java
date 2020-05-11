package mod.alexndr.netherrocks.content;

import javax.annotation.Nullable;

import mod.alexndr.netherrocks.api.content.AbstractNetherFurnaceBlock;
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

public class NetherFurnaceBlock extends AbstractNetherFurnaceBlock
{

   public NetherFurnaceBlock(final Properties builder)
    {
        super(builder);
    } // end ctor


   @Nullable
   @Override
   public TileEntity createTileEntity(final BlockState state, final IBlockReader world) {
       // Always use TileEntityType#create to allow registry overrides to work.
       return ModTiles.NETHER_FURNACE.get().create();
   }

    /**
    * Called on the logical server when a BlockState with a TileEntity is replaced by another BlockState.
    * We use this method to drop all the items from our tile entity's inventory and update comparators near our block.
    *
    * @deprecated Call via {@link BlockState#onReplaced(World, BlockPos, BlockState, boolean)}
    * Implementing/overriding is fine.
    */
   @Override
   public void onReplaced(BlockState oldState, World worldIn, BlockPos pos, BlockState newState, boolean isMoving) {
       if (oldState.getBlock() != newState.getBlock()) {
           TileEntity tileEntity = worldIn.getTileEntity(pos);
           if (tileEntity instanceof NetherFurnaceTileEntity) {
               final ItemStackHandler inventory = ((NetherFurnaceTileEntity) tileEntity).inventory;
               for (int slot = 0; slot < inventory.getSlots(); ++slot)
                   InventoryHelper.spawnItemStack(worldIn, pos.getX(), pos.getY(), pos.getZ(), inventory.getStackInSlot(slot));
           }
       }
   }

   /**
    * Called when a player right clicks our block.
    * We use this method to open our gui.
    *
    * @deprecated Call via {@link BlockState#onBlockActivated(World, PlayerEntity, Hand, BlockRayTraceResult)} whenever possible.
    * Implementing/overriding is fine.
    */
   @Override
   public ActionResultType onBlockActivated(final BlockState state, final World worldIn, final BlockPos pos, final PlayerEntity player, final Hand handIn, final BlockRayTraceResult hit) {
       if (!worldIn.isRemote) {
           final TileEntity tileEntity = worldIn.getTileEntity(pos);
           if (tileEntity instanceof NetherFurnaceTileEntity) 
           {
               NetworkHooks.openGui((ServerPlayerEntity) player, (NetherFurnaceTileEntity) tileEntity, pos);
               // since we don't use the AbstractModFurnaceBlock class from the Machines API, just
               // add the interaction code here.
               player.addStat(Stats.INTERACT_WITH_FURNACE);
           }
       }
       return ActionResultType.SUCCESS;
   }

   
}  // end class NetherFurnaceBlock
