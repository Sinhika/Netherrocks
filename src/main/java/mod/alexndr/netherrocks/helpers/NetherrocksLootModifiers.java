package mod.alexndr.netherrocks.helpers;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import mod.alexndr.netherrocks.config.NetherrocksConfig;
import mod.alexndr.netherrocks.init.ModItems;
import mod.alexndr.netherrocks.init.ModCodecs;
import mod.alexndr.simplecorelib.api.loot.AbstractChestLootModifier;
import net.minecraft.core.RegistryAccess;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.neoforged.neoforge.common.loot.IGlobalLootModifier;
import net.neoforged.neoforge.common.loot.LootModifier;
import org.jetbrains.annotations.NotNull;

public class NetherrocksLootModifiers
{
    
    public static class AutoSmeltLootModifier extends LootModifier
    {
        public static final MapCodec<AutoSmeltLootModifier> CODEC =
                RecordCodecBuilder.mapCodec( inst -> LootModifier.codecStart(inst).apply(inst, AutoSmeltLootModifier::new));
        
        public AutoSmeltLootModifier(LootItemCondition[] conditionsIn)
        {
            super(conditionsIn);
        }
        
        @Override
        protected @NotNull ObjectArrayList<ItemStack> doApply(ObjectArrayList<ItemStack> generatedLoot,
                LootContext context)
        {
            ObjectArrayList<ItemStack> ret = new ObjectArrayList<ItemStack>();
            generatedLoot.forEach((stack) -> ret.add(smelt(stack, context)));
            return ret;
        }

        
        protected static ItemStack smelt(ItemStack stack, LootContext context)
        {
        	ServerLevel level = context.getLevel();
        	RegistryAccess registryAccess = level.registryAccess();
            return context.getLevel().getRecipeManager()
                    .getRecipeFor(RecipeType.SMELTING, new SimpleContainer(stack), level)
                    .map((a)->a.value().getResultItem(registryAccess))
                    .filter(itemStack -> !itemStack.isEmpty())
                    .map(itemStack -> itemStack.copyWithCount(stack.getCount() * itemStack.getCount()))
                    .orElse(stack);
       }

        @Override
        public MapCodec<? extends IGlobalLootModifier> codec()
        {
            return ModCodecs.AUTO_SMELT_TOOL.get();
        }

    } // end class AutoSmeltLootModifier

    public static class GhastOreLootModifier extends LootModifier
    {
        public static final MapCodec<GhastOreLootModifier> CODEC =
                RecordCodecBuilder.mapCodec( inst -> LootModifier.codecStart(inst).apply(inst, GhastOreLootModifier::new));
        
        public GhastOreLootModifier(LootItemCondition[] conditionsIn)
        {
            super(conditionsIn);
        }

        @Override
        public MapCodec<? extends IGlobalLootModifier> codec()
        {
            return ModCodecs.GHAST_ORE_LOOT.get();
        }

        @Override
        protected @NotNull ObjectArrayList<ItemStack> doApply(ObjectArrayList<ItemStack> generatedLoot,
                LootContext context)
        {
            // pass loot thru and do nothing if AshstoneGhastOre not enabled.
            if (! NetherrocksConfig.enableAshstoneGhastOre)
            {
                return generatedLoot;
            }
            ObjectArrayList<ItemStack> ret = new ObjectArrayList<ItemStack>();
            generatedLoot.forEach((x) -> ret.add(substitute(x)));
            return ret;
        } // end GhastOreLootModifier.doApply

        protected static ItemStack substitute(ItemStack stack)
        {
            if (stack.getItem() == ModItems.ashstone_gem.get())
            {
                return new ItemStack(Items.GHAST_TEAR);
            }
            return stack;
        } // end substitute()
        
    } // end class GhastOreLootModifer

    public static class NetherrocksChestLootModifier extends AbstractChestLootModifier
    {
        public static final MapCodec<NetherrocksChestLootModifier> CODEC =
                RecordCodecBuilder.mapCodec(inst -> LootModifier.codecStart(inst)
                        .and(ResourceKey.codec(Registries.LOOT_TABLE).fieldOf("lootTable")
                                .forGetter((m) -> m.lootTable))
                        .apply(inst, NetherrocksChestLootModifier::new));

        public NetherrocksChestLootModifier(LootItemCondition[] conditionsIn,
                                            ResourceKey<LootTable> lootTable)
        {
            super(conditionsIn, lootTable);
        }

        @Override protected @NotNull ObjectArrayList<ItemStack> doApply(
                @NotNull ObjectArrayList<ItemStack> generatedLoot, LootContext context)
        {
            if (NetherrocksConfig.addModLootToChests) {
                return super.doApply(generatedLoot, context);
            }
            else {
                return generatedLoot;
            }
        }

        @Override public @NotNull MapCodec<? extends IGlobalLootModifier> codec()
        {
            return ModCodecs.CHEST_LOOT.get();
        }
    }
} // end class
