package mod.alexndr.netherrocks.init;

import mod.alexndr.netherrocks.Netherrocks;
import mod.alexndr.netherrocks.content.NetherBlastFurnaceContainer;
import mod.alexndr.netherrocks.content.NetherFurnaceContainer;
import mod.alexndr.netherrocks.content.NetherSmokerContainer;
import net.minecraft.world.inventory.MenuType;
import net.neoforged.neoforge.common.extensions.IMenuTypeExtension;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.ForgeRegistries;
import net.neoforged.neoforge.registries.RegistryObject;

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
    public static final DeferredRegister<MenuType<?>> CONTAINER_TYPES = 
            DeferredRegister.create(ForgeRegistries.MENU_TYPES, Netherrocks.MODID);
    
   public static RegistryObject<MenuType<NetherFurnaceContainer>> NETHER_FURNACE =
           CONTAINER_TYPES.register("nether_furnace", 
                   () -> IMenuTypeExtension.create((windowId, inv, data) 
                           -> new NetherFurnaceContainer(windowId, inv, data.readBlockPos(), inv.player)));
   
   public static RegistryObject<MenuType<NetherSmokerContainer>> NETHER_SMOKER =
           CONTAINER_TYPES.register("nether_smoker", 
                   () -> IMenuTypeExtension.create((windowId, inv, data) 
                           -> new NetherSmokerContainer(windowId, inv, data.readBlockPos(), inv.player)));
   
   public static RegistryObject<MenuType<NetherBlastFurnaceContainer>> NETHER_BLAST_FURNACE =
           CONTAINER_TYPES.register("nether_blast_furnace", 
                   () -> IMenuTypeExtension.create((windowId, inv, data) 
                           -> new NetherBlastFurnaceContainer(windowId, inv, data.readBlockPos(), inv.player)));
   
}  // end class ModContainers
