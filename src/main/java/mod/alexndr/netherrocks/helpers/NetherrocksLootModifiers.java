package mod.alexndr.netherrocks.helpers;

import java.util.function.Supplier;

import org.jetbrains.annotations.NotNull;

import com.google.common.base.Suppliers;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;

import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import mod.alexndr.netherrocks.config.NetherrocksConfig;
import mod.alexndr.netherrocks.init.ModItems;
import net.minecraft.core.RegistryAccess;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.neoforged.neoforge.common.loot.IGlobalLootModifier;
import net.neoforged.neoforge.common.loot.LootModifier;
import net.neoforged.neoforge.items.ItemHandlerHelper;

public class NetherrocksLootModifiers
{
    
    public static class AutoSmeltLootModifier extends LootModifier
    {
        public static final Supplier<Codec<AutoSmeltLootModifier>> CODEC = 
                Suppliers.memoize( () -> RecordCodecBuilder.create( inst -> codecStart(inst).apply(inst, AutoSmeltLootModifier::new)));
        
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
                    .map((a)->a.getResultItem(registryAccess))
                    .filter(itemStack -> !itemStack.isEmpty())
                    .map(itemStack -> ItemHandlerHelper.copyStackWithSize(itemStack, stack.getCount() * itemStack.getCount()))
                    .orElse(stack);
       }

        @Override
        public Codec<? extends IGlobalLootModifier> codec()
        {
            return CODEC.get();
        }

    } // end class AutoSmeltLootModifier

    public static class GhastOreLootModifier extends LootModifier
    {
        public static final Supplier<Codec<GhastOreLootModifier>> CODEC = 
                Suppliers.memoize( () -> RecordCodecBuilder.create( inst -> codecStart(inst).apply(inst, GhastOreLootModifier::new)));
        
        public GhastOreLootModifier(LootItemCondition[] conditionsIn)
        {
            super(conditionsIn);
        }

        @Override
        public Codec<? extends IGlobalLootModifier> codec()
        {
            return CODEC.get();
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
    
} // end class
