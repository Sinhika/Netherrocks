package mod.alexndr.netherrocks.init;

import mod.alexndr.netherrocks.Netherrocks;
import net.minecraft.world.item.Item;
import net.minecraft.tags.Tag;
import net.minecraft.tags.ItemTags;
import net.minecraft.resources.ResourceLocation;

/**
 * Holds tag collections this mod needs to keep track of.
 */
public class ModTags
{
    private static ResourceLocation
        tagNetherFurnaceFuels = new ResourceLocation(Netherrocks.MODID, "nether_furnace_fuels");

    public static Tag<Item> getnetherFurnaceFuels()
    {
        return ItemTags.getAllTags().getTag(tagNetherFurnaceFuels);
    }

}  // end class ModTags
