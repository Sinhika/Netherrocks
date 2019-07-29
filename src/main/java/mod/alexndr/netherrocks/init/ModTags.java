package mod.alexndr.netherrocks.init;

import mod.alexndr.netherrocks.Netherrocks;
import net.minecraft.item.Item;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.Tag;
import net.minecraft.util.ResourceLocation;

/**
 * Holds tag collections this mod needs to keep track of.
 */
public class ModTags
{
    private static ResourceLocation tagFyriteTools = new ResourceLocation(Netherrocks.MODID, "fyrite_tools");

    public static Tag<Item> getFyriteTools()
    {
        return ItemTags.getCollection().getOrCreate(tagFyriteTools);
    }

}  // end class ModTags
