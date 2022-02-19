package mod.alexndr.netherrocks.content;

import mod.alexndr.netherrocks.api.content.AbstractNetherFurnaceTileEntity;
import mod.alexndr.netherrocks.init.ModTiles;
import net.minecraft.core.BlockPos;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.block.state.BlockState;

public class NetherSmokerTileEntity extends AbstractNetherFurnaceTileEntity
{

    public NetherSmokerTileEntity(BlockPos blockpos, BlockState blockstate)
    {
        super(ModTiles.NETHER_SMOKER.get(), blockpos, blockstate, RecipeType.SMOKING);
    }

    
    @Override
    protected int getBurnDuration(ItemStack fuelstack)
    {
        return super.getBurnDuration(fuelstack)/2;
    }

 } // end class
