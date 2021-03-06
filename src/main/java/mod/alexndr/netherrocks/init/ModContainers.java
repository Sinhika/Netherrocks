package mod.alexndr.netherrocks.init;

import mod.alexndr.netherrocks.Netherrocks;
import mod.alexndr.netherrocks.content.NetherBlastFurnaceContainer;
import mod.alexndr.netherrocks.content.NetherFurnaceContainer;
import mod.alexndr.netherrocks.content.NetherSmokerContainer;
import net.minecraft.inventory.container.ContainerType;
import net.minecraftforge.common.extensions.IForgeContainerType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

/**
 * Holds a list of all our {@link ContainerType}s.
 * Suppliers that create ContainerTypes are added to the DeferredRegister.
 * The DeferredRegister is then added to our mod event bus in our constructor.
 * When the ContainerType Registry Event is fired by Forge and it is time for the mod to
 * register its ContainerTypes, our ContainerTypes are created and registered by the DeferredRegister.
 * The ContainerType Registry Event will always be called after the Block and Item registries are filled.
 * Note: This supports registry overrides.
 *
 * @author Sinhika, notes by Cadiboo
 */
public final class ModContainers
{
    public static final DeferredRegister<ContainerType<?>> CONTAINER_TYPES = 
            DeferredRegister.create(ForgeRegistries.CONTAINERS, Netherrocks.MODID);
    
   public static RegistryObject<ContainerType<NetherFurnaceContainer>> NETHER_FURNACE =
           CONTAINER_TYPES.register("nether_furnace", 
                   () -> IForgeContainerType.create(NetherFurnaceContainer::new));
   
   public static RegistryObject<ContainerType<NetherSmokerContainer>> NETHER_SMOKER =
           CONTAINER_TYPES.register("nether_smoker", 
                   () -> IForgeContainerType.create(NetherSmokerContainer::new));
   
   public static RegistryObject<ContainerType<NetherBlastFurnaceContainer>> NETHER_BLAST_FURNACE =
           CONTAINER_TYPES.register("nether_blast_furnace", 
                   () -> IForgeContainerType.create(NetherBlastFurnaceContainer::new));
   
}  // end class ModContainers
