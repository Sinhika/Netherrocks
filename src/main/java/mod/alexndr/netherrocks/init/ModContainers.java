package mod.alexndr.netherrocks.init;

import mod.alexndr.netherrocks.Netherrocks;
import mod.alexndr.netherrocks.content.NetherBlastFurnaceContainer;
import mod.alexndr.netherrocks.content.NetherFurnaceContainer;
import mod.alexndr.netherrocks.content.NetherSmokerContainer;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.inventory.MenuType;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

/**
 * Holds a list of all our {@link MenuType}s.
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
            DeferredRegister.create(Registries.MENU, Netherrocks.MODID);
    
   public static Supplier<MenuType<NetherFurnaceContainer>> NETHER_FURNACE =
           CONTAINER_TYPES.register("nether_furnace", 
                   () ->  new MenuType<>(NetherFurnaceContainer::new, FeatureFlags.DEFAULT_FLAGS));
   
   public static Supplier<MenuType<NetherSmokerContainer>> NETHER_SMOKER =
           CONTAINER_TYPES.register("nether_smoker",
                   () ->  new MenuType<>(NetherSmokerContainer::new, FeatureFlags.DEFAULT_FLAGS));

   public static Supplier<MenuType<NetherBlastFurnaceContainer>> NETHER_BLAST_FURNACE =
           CONTAINER_TYPES.register("nether_blast_furnace",
                   () ->  new MenuType<>(NetherBlastFurnaceContainer::new, FeatureFlags.DEFAULT_FLAGS));

}  // end class ModContainers
