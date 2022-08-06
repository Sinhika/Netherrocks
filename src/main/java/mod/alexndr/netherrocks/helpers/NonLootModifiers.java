package mod.alexndr.netherrocks.helpers;

import java.util.Map;
import java.util.function.Supplier;

import org.jetbrains.annotations.NotNull;

import com.google.common.base.Suppliers;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;

import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraftforge.common.loot.IGlobalLootModifier;
import net.minecraftforge.common.loot.LootModifier;
import net.minecraftforge.registries.ForgeRegistries;

public class NonLootModifiers 
{
/** 
 * place to implement codecs/dynamic-ops for a "item" => burn_time map.
 * {
 * [
 *      {
 *      "item" : "netherrocks:fyrite_ingot",
 *      "burn_time" : 8000
 *      }.
 *      {
 *      "item" : "minecraft:netherrack",
 *      "burn_time" : 200
 *      }
 *      
 * ]
 * }
 * @author Sinhika
 *
 */
    public static class NetherFuelSerializer  extends LootModifier
    {
        public static final Codec<Map<Item, Integer>> MAP_CODEC = Codec.unboundedMap(ForgeRegistries.ITEMS.getCodec(), Codec.INT);
        public static final Supplier<Codec<NetherFuelSerializer>> CODEC = Suppliers.memoize(
                () -> RecordCodecBuilder.create(inst -> codecStart(inst).and(
                        inst.group(
                                MAP_CODEC.decode(m -> m.burnTimes)
                        )).apply(inst, NetherFuelSerializer::new));
                
//        private final Item nether_fuel_item;
//        private final int burn_time;
        private static Map<Item, Integer> burnTimes;
        
        public NetherFuelSerializer(LootItemCondition[] conditionsIn, Map<Item, Integer> burnTimesMap)
        {
            super(conditionsIn);
            this.burnTimes = burnTimesMap;
         }
    
         @Override
        public Codec<? extends IGlobalLootModifier> codec()
        {
            return CODEC.get();
        }

         /**
          * we don't actually want to do any loot here.
          */
        @Override
        protected @NotNull ObjectArrayList<ItemStack> doApply(ObjectArrayList<ItemStack> generatedLoot, LootContext context)
        {
            return generatedLoot;
        }

         
    } // end class NetherFuelSerializer

} // end class
