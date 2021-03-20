package mod.alexndr.netherrocks.init;

import mod.alexndr.netherrocks.Netherrocks;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

import javax.annotation.Nonnull;
import java.util.function.Supplier;

public final class ModTabGroups
{

    public static final ItemGroup MOD_ITEM_GROUP =
            new ModTabGroup(Netherrocks.MODID, () -> new ItemStack(ModItems.fyrite_pickaxe.get()));

    public static final class ModTabGroup extends ItemGroup
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
