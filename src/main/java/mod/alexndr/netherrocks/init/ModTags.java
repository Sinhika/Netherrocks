package mod.alexndr.netherrocks.init;

import mod.alexndr.netherrocks.Netherrocks;
import mod.alexndr.simplecorelib.api.helpers.TagUtils;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.tags.ITag;

/**
 * Holds tag collections this mod needs to keep track of.
 */
public class ModTags
{
    private static TagKey<Item> tagNetherFurnaceFuels_asTool
        = TagUtils.modTag(Netherrocks.MODID, "nether_furnace_fuels/as_tool");
    private static TagKey<Item> tagNetherFurnaceFuels_asIngot
        = TagUtils.modTag(Netherrocks.MODID, "nether_furnace_fuels/as_ingot");
    private static TagKey<Item> tagNetherFurnaceFuels_asBlock
        = TagUtils.modTag(Netherrocks.MODID, "nether_furnace_fuels/as_block");
    private static TagKey<Item> tagNetherFurnaceFuels_asSlab
        = TagUtils.modTag(Netherrocks.MODID, "nether_furnace_fuels/as_slab");
    private static TagKey<Item> tagNetherFurnaceFuels_asDoor
        = TagUtils.modTag(Netherrocks.MODID, "nether_furnace_fuels/as_door");
    private static TagKey<Item> tagNetherFurnaceFuels_asBars
        = TagUtils.modTag(Netherrocks.MODID, "nether_furnace_fuels/as_bars");
    private static TagKey<Item> tagNetherFurnaceFuels_asBlazeRod
        = TagUtils.modTag(Netherrocks.MODID, "nether_furnace_fuels/as_blaze_rod");
    private static TagKey<Item> tagNetherFurnaceFuels_asBlazePowder
        = TagUtils.modTag(Netherrocks.MODID, "nether_furnace_fuels/as_blaze_powder");

    public static ITag<Item> getnetherFurnaceFuels(String qualifier)
    {
        if (qualifier == "as_tool") {
            return ForgeRegistries.ITEMS.tags().getTag(tagNetherFurnaceFuels_asTool);
        }
        else if (qualifier == "as_ingot")
        {
            return ForgeRegistries.ITEMS.tags().getTag(tagNetherFurnaceFuels_asIngot);
        }
        else if (qualifier == "as_block")
        {
            return ForgeRegistries.ITEMS.tags().getTag(tagNetherFurnaceFuels_asBlock);
        }
        else if (qualifier == "as_slab")
        {
            return ForgeRegistries.ITEMS.tags().getTag(tagNetherFurnaceFuels_asSlab);
        }
        else if (qualifier == "as_door")
        {
            return ForgeRegistries.ITEMS.tags().getTag(tagNetherFurnaceFuels_asDoor);
        }
        else if (qualifier == "as_bars")
        {
            return ForgeRegistries.ITEMS.tags().getTag(tagNetherFurnaceFuels_asBars);
        }
        else if (qualifier == "as_blaze_rod")
        {
            return ForgeRegistries.ITEMS.tags().getTag(tagNetherFurnaceFuels_asBlazeRod);
        }
        else if (qualifier == "as_blaze_powder")
        {
            return ForgeRegistries.ITEMS.tags().getTag(tagNetherFurnaceFuels_asBlazePowder);
        }
       return null;
    } // end getnetherFurnaceFuels
    
    public static class Items
    {
        public static final TagKey<Item> ORES_ASHSTONE = TagUtils.forgeTag("ores/ashstone");
        public static final TagKey<Item> AUTO_SMELT_TOOLS = TagUtils.modTag(Netherrocks.MODID, "auto_smelt_tools");
    }
    
    public static class Blocks 
    {
        public static final TagKey<Block> ORES_ASHSTONE = TagUtils.forgeBlockTag("ores/ashstone");
   }
}  // end class ModTags
