package mod.alexndr.netherrocks.init;

import java.util.function.Supplier;

import javax.annotation.Nonnull;

import mod.alexndr.netherrocks.Netherrocks;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public final class ModTabGroups
{

    public static final CreativeModeTab MOD_ITEM_GROUP =
            new ModTabGroup(Netherrocks.MODID, () -> new ItemStack(ModItems.fyrite_pickaxe.get()));

    public static final class ModTabGroup extends CreativeModeTab
    {

        @Nonnull
        private final Supplier<ItemStack> iconSupplier;

        /**
         * @param name  String: mod id
         * @param iconSupplier
         */
        public ModTabGroup(@Nonnull final String name, @Nonnull final Supplier<ItemStack> iconSupplier)
        {
            super(name);
            this.iconSupplier = iconSupplier;
        }

        @Override
        @Nonnull
        public ItemStack makeIcon() {
            return iconSupplier.get();
        }

    } // end ModTabGroup()

}  // end class ModTabGroup
