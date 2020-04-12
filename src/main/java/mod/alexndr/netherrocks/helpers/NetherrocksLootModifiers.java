package mod.alexndr.netherrocks.helpers;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Nonnull;

import com.google.gson.JsonObject;

import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipe;
import net.minecraft.item.crafting.IRecipeType;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.storage.loot.LootContext;
import net.minecraft.world.storage.loot.conditions.ILootCondition;
import net.minecraftforge.common.loot.GlobalLootModifierSerializer;
import net.minecraftforge.common.loot.LootModifier;
import net.minecraftforge.items.ItemHandlerHelper;

public class NetherrocksLootModifiers
{

    public static class AutoSmeltLootModifier extends LootModifier
    {

        protected AutoSmeltLootModifier(ILootCondition[] conditionsIn)
        {
            super(conditionsIn);
            // TODO Auto-generated constructor stub
        }

        @Nonnull
        @Override
        protected List<ItemStack> doApply(List<ItemStack> generatedLoot, LootContext context)
        {
            ArrayList<ItemStack> ret = new ArrayList<ItemStack>();
            generatedLoot.forEach((stack) -> ret.add(smelt(stack, context)));
            return ret;
        }

        private static ItemStack smelt(ItemStack stack, LootContext context)
        {
            return context.getWorld().getRecipeManager()
                    .getRecipe(IRecipeType.SMELTING, new Inventory(stack), context.getWorld())
                    .map(FurnaceRecipe::getRecipeOutput)
                    .filter(itemStack -> !itemStack.isEmpty())
                    .map(itemStack -> ItemHandlerHelper.copyStackWithSize(itemStack, stack.getCount() * itemStack.getCount()))
                    .orElse(stack);
       }

        public static class Serializer extends GlobalLootModifierSerializer<AutoSmeltLootModifier>
        {

            @Override
            public AutoSmeltLootModifier read(ResourceLocation location, JsonObject object,
                    ILootCondition[] ailootcondition)
            {
                return new AutoSmeltLootModifier(ailootcondition);
            }

        } // end class Serializer

    } // end class AutoSmeltLootModifier

} // end class
