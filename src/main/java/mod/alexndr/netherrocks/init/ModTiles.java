package mod.alexndr.netherrocks.init;

import mod.alexndr.netherrocks.Netherrocks;
import mod.alexndr.netherrocks.content.NetherBlastFurnaceTileEntity;
import mod.alexndr.netherrocks.content.NetherFurnaceTileEntity;
import mod.alexndr.netherrocks.content.NetherSmokerTileEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

/**
 * Holds a list of all our {@link TileEntityType}s.
 * Suppliers that create TileEntityTypes are added to the DeferredRegister.
 * The DeferredRegister is then added to our mod event bus in our constructor.
 * When the TileEntityType Registry Event is fired by Forge and it is time for the mod to
 * register its TileEntityTypes, our TileEntityTypes are created and registered by the DeferredRegister.
 * The TileEntityType Registry Event will always be called after the Block and Item registries are filled.
 * Note: This supports registry overrides.
 *
 * @author Sinhika, notes by Cadiboo
 */
public final class ModTiles
{
    public static final DeferredRegister<BlockEntityType<?>> TILE_ENTITY_TYPES = 
            DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, Netherrocks.MODID);

    // tile entity type
    // We don't have a datafixer for our TileEntities, so we pass null into build.
    public static RegistryObject<BlockEntityType<NetherFurnaceTileEntity>> NETHER_FURNACE =
            TILE_ENTITY_TYPES.register("nether_furnace", 
                    () -> BlockEntityType.Builder.of(NetherFurnaceTileEntity::new, 
                            ModBlocks.nether_furnace.get()).build(null));

    public static RegistryObject<BlockEntityType<NetherSmokerTileEntity>> NETHER_SMOKER =
            TILE_ENTITY_TYPES.register("nether_smoker", 
                    () -> BlockEntityType.Builder.of(NetherSmokerTileEntity::new, 
                            ModBlocks.nether_smoker.get()).build(null));
    
    public static RegistryObject<BlockEntityType<NetherBlastFurnaceTileEntity>> NETHER_BLAST_FURNACE =
            TILE_ENTITY_TYPES.register("nether_blast_furnace", 
                    () -> BlockEntityType.Builder.of(NetherBlastFurnaceTileEntity::new, 
                            ModBlocks.nether_blast_furnace.get()).build(null));
}  // end class ModTiles
