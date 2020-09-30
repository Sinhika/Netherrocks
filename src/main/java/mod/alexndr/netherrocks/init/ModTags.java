package mod.alexndr.netherrocks.init;

import mod.alexndr.netherrocks.Netherrocks;
import net.minecraft.item.Item;
import net.minecraft.tags.ITag;
import net.minecraft.tags.ItemTags;
import net.minecraft.util.ResourceLocation;

/**
 * Holds tag collections this mod needs to keep track of.
 */
public class ModTags
{
    private static ResourceLocation
        tagNetherFurnaceFuels = new ResourceLocation(Netherrocks.MODID, "nether_furnace_fuels");

    public static ITag<Item> getnetherFurnaceFuels()
    {
        return ItemTags.getCollection().get(tagNetherFurnaceFuels);
    }

}  // end class ModTags
