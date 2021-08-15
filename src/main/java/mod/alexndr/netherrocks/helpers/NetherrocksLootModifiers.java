package mod.alexndr.netherrocks.helpers;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Nonnull;

import com.google.gson.JsonObject;

import net.minecraft.world.SimpleContainer;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.SmeltingRecipe;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.common.loot.GlobalLootModifierSerializer;
import net.minecraftforge.common.loot.LootModifier;
import net.minecraftforge.items.ItemHandlerHelper;

public class NetherrocksLootModifiers
{

    public static class AutoSmeltLootModifier extends LootModifier
    {

        protected AutoSmeltLootModifier(LootItemCondition[] conditionsIn)
        {
            super(conditionsIn);
        }

        @Nonnull
        @Override
        protected List<ItemStack> doApply(List<ItemStack> generatedLoot, LootContext context)
        {
            ArrayList<ItemStack> ret = new ArrayList<ItemStack>();
            generatedLoot.forEach((stack) -> ret.add(smelt(stack, context)));
            return ret;
        }

        protected static ItemStack smelt(ItemStack stack, LootContext context)
        {
            return context.getLevel().getRecipeManager()
                    .getRecipeFor(RecipeType.SMELTING, new SimpleContainer(stack),context.getLevel())
                    .map(SmeltingRecipe::getResultItem)
                    .filter(itemStack -> !itemStack.isEmpty())
                    .map(itemStack -> ItemHandlerHelper.copyStackWithSize(itemStack, stack.getCount() * itemStack.getCount()))
                    .orElse(stack);
       }

        public static class Serializer extends GlobalLootModifierSerializer<AutoSmeltLootModifier>
        {

            @Override
            public AutoSmeltLootModifier read(ResourceLocation location, JsonObject object,
                    LootItemCondition[] ailootcondition)
            {
                return new AutoSmeltLootModifier(ailootcondition);
            }

            @Override
            public JsonObject write(AutoSmeltLootModifier instance)
            {
                return makeConditions(instance.conditions);
            }

        } // end class Serializer

    } // end class AutoSmeltLootModifier

} // end class
