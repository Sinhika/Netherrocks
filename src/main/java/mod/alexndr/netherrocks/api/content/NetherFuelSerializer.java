package mod.alexndr.netherrocks.api.content;

import java.util.Map;

import com.mojang.serialization.Codec;

import net.minecraft.world.item.Item;
import net.minecraftforge.registries.ForgeRegistries;

/** 
 * place to implement codecs/dynamic-ops for a "item" => burn_time map.
 * @author Sinhika
 *
 */
public final class NetherFuelSerializer
{
    public static final Codec<Map<Item, Integer>> CODEC = Codec.unboundedMap(ForgeRegistries.ITEMS.getCodec(), Codec.INT);
    
} // end class
