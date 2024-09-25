package mod.alexndr.netherrocks.init;

import mod.alexndr.netherrocks.Netherrocks;
import mod.alexndr.simplecorelib.api.helpers.TagUtils;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

/**
 * Holds tag collections this mod needs to keep track of.
 */
public class ModTags
{

    public static class Items
    {
        public static final TagKey<Item> ORES_ASHSTONE = TagUtils.cTag("ores/ashstone");
        public static final TagKey<Item> AUTO_SMELT_TOOLS = TagUtils.modTag(Netherrocks.MODID, "auto_smelt_tools");
    }
    
    public static class Blocks 
    {
        public static final TagKey<Block> ORES_ASHSTONE = TagUtils.cBlockTag("ores/ashstone");
        public static final TagKey<Block> NEEDS_DRAGONSTONE_TOOL =
                TagUtils.modBlockTag(Netherrocks.MODID, "needs_dragonstone_tool");
        public static final TagKey<Block> INCORRECT_FOR_DRAGONSTONE_TOOL =
                TagUtils.modBlockTag(Netherrocks.MODID, "incorrect_for_dragonstone_tool");
    }
    
}  // end class ModTags
