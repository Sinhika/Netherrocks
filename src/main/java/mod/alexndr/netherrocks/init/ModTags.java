package mod.alexndr.netherrocks.init;

import mod.alexndr.netherrocks.Netherrocks;
import mod.alexndr.simplecorelib.api.helpers.TagUtils;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 * Holds tag collections this mod needs to keep track of.
 */
public class ModTags
{
    private static final TagKey<Item> tagNetherFurnaceFuels_asTool
        = TagUtils.modTag(Netherrocks.MODID, "nether_furnace_fuels/as_tool");
    private static final TagKey<Item> tagNetherFurnaceFuels_asIngot
        = TagUtils.modTag(Netherrocks.MODID, "nether_furnace_fuels/as_ingot");
    private static final TagKey<Item> tagNetherFurnaceFuels_asBlock
        = TagUtils.modTag(Netherrocks.MODID, "nether_furnace_fuels/as_block");
    private static final TagKey<Item> tagNetherFurnaceFuels_asSlab
        = TagUtils.modTag(Netherrocks.MODID, "nether_furnace_fuels/as_slab");
    private static final TagKey<Item> tagNetherFurnaceFuels_asDoor
        = TagUtils.modTag(Netherrocks.MODID, "nether_furnace_fuels/as_door");
    private static final TagKey<Item> tagNetherFurnaceFuels_asBars
        = TagUtils.modTag(Netherrocks.MODID, "nether_furnace_fuels/as_bars");
    private static final TagKey<Item> tagNetherFurnaceFuels_asBlazeRod
        = TagUtils.modTag(Netherrocks.MODID, "nether_furnace_fuels/as_blaze_rod");
    private static final TagKey<Item> tagNetherFurnaceFuels_asBlazePowder
        = TagUtils.modTag(Netherrocks.MODID, "nether_furnace_fuels/as_blaze_powder");

    public static Iterable<Holder<Item>> getnetherFurnaceFuels(String qualifier)
    {

        if (qualifier == "as_tool") {
            return BuiltInRegistries.ITEM.getTagOrEmpty(tagNetherFurnaceFuels_asTool);
        }
        else if (qualifier == "as_ingot")
        {
            return BuiltInRegistries.ITEM.getTagOrEmpty(tagNetherFurnaceFuels_asIngot);
        }
        else if (qualifier == "as_block")
        {
            return BuiltInRegistries.ITEM.getTagOrEmpty(tagNetherFurnaceFuels_asBlock);
        }
        else if (qualifier == "as_slab")
        {
            return BuiltInRegistries.ITEM.getTagOrEmpty(tagNetherFurnaceFuels_asSlab);
        }
        else if (qualifier == "as_door")
        {
            return BuiltInRegistries.ITEM.getTagOrEmpty(tagNetherFurnaceFuels_asDoor);
        }
        else if (qualifier == "as_bars")
        {
            return BuiltInRegistries.ITEM.getTagOrEmpty(tagNetherFurnaceFuels_asBars);
        }
        else if (qualifier == "as_blaze_rod")
        {
            return BuiltInRegistries.ITEM.getTagOrEmpty(tagNetherFurnaceFuels_asBlazeRod);
        }
        else if (qualifier == "as_blaze_powder")
        {
            return BuiltInRegistries.ITEM.getTagOrEmpty(tagNetherFurnaceFuels_asBlazePowder);
        }
       return null;
    } // end getnetherFurnaceFuels
    
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
