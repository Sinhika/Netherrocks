package mod.alexndr.netherrocks.init;

import mod.alexndr.netherrocks.ModUtil;
import mod.alexndr.netherrocks.Netherrocks;
import mod.alexndr.netherrocks.content.NetherFurnaceTileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.registries.ObjectHolder;

@ObjectHolder(Netherrocks.MODID)
public final class ModTiles
{
    // tile entity type
    public static TileEntityType<NetherFurnaceTileEntity> NETHER_FURNACE =
        ModUtil._null();

}  // end class ModTiles
