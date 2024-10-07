package mod.alexndr.netherrocks.init;

import mod.alexndr.netherrocks.Netherrocks;
import mod.alexndr.netherrocks.content.block_entity.NetherBlastFurnaceTileEntity;
import mod.alexndr.netherrocks.content.block_entity.NetherFurnaceTileEntity;
import mod.alexndr.netherrocks.content.container.NetherSmokerTileEntity;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

/**
 * Holds a list of all our {@link BlockEntityType}s.
 * Suppliers that create BlockEntityType are added to the DeferredRegister.
 * The DeferredRegister is then added to our mod event bus in our constructor.
 * When the BlockEntityType Registry Event is fired by Forge and it is time for the mod to
 * register its BlockEntityType, our TileEntityTypes are created and registered by the DeferredRegister.
 * The BlockEntityType Registry Event will always be called after the Block and Item registries are filled.
 * Note: This supports registry overrides.
 *
 * @author Sinhika, notes by Cadiboo
 */
public final class ModTiles
{
    public static final DeferredRegister<BlockEntityType<?>> TILE_ENTITY_TYPES = 
            DeferredRegister.create(Registries.BLOCK_ENTITY_TYPE, Netherrocks.MODID);

    // tile entity type
    // We don't have a datafixer for our TileEntities, so we pass null into build.
    public static DeferredHolder<BlockEntityType<?>,BlockEntityType<NetherFurnaceTileEntity>> NETHER_FURNACE =
            TILE_ENTITY_TYPES.register("nether_furnace", 
                    () -> BlockEntityType.Builder.of(NetherFurnaceTileEntity::new, 
                            ModBlocks.nether_furnace.get()).build(null));

    public static DeferredHolder<BlockEntityType<?>,BlockEntityType<NetherSmokerTileEntity>> NETHER_SMOKER =
            TILE_ENTITY_TYPES.register("nether_smoker", 
                    () -> BlockEntityType.Builder.of(NetherSmokerTileEntity::new, 
                            ModBlocks.nether_smoker.get()).build(null));
    
    public static DeferredHolder<BlockEntityType<?>,BlockEntityType<NetherBlastFurnaceTileEntity>> NETHER_BLAST_FURNACE =
            TILE_ENTITY_TYPES.register("nether_blast_furnace", 
                    () -> BlockEntityType.Builder.of(NetherBlastFurnaceTileEntity::new, 
                            ModBlocks.nether_blast_furnace.get()).build(null));
}  // end class ModTiles
