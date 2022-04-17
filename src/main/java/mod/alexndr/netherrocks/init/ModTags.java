package mod.alexndr.netherrocks.init;

import mod.alexndr.netherrocks.Netherrocks;
import mod.alexndr.simplecorelib.helpers.TagUtils;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.tags.ITag;

/**
 * Holds tag collections this mod needs to keep track of.
 */
public class ModTags
{
    private static TagKey<Item> tagNetherFurnaceFuels 
        = TagUtils.modTag(Netherrocks.MODID, "nether_furnace_fuels");

    public static ITag<Item> getnetherFurnaceFuels()
    {
        return ForgeRegistries.ITEMS.tags().getTag(tagNetherFurnaceFuels);
        // return ItemTags.getAllTags().getTag(tagNetherFurnaceFuels);
    }

}  // end class ModTags
