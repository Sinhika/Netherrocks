package mod.alexndr.netherrocks.content;

import mod.alexndr.netherrocks.init.ModItems;
import net.minecraft.item.IItemTier;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.LazyLoadBase;

import java.util.function.Supplier;

public enum NetherrocksItemTier implements IItemTier
{
   ARGONITE(1, 1300, 8.0F, 3.0F, 18,
            ()->{ return Ingredient.fromItems(ModItems.argonite_ingot);}),
   ASHSTONE(3, 900, 16.0F, 2.0F, 7,
            ()->{ return Ingredient.fromItems(ModItems.ashstone_gem);}),
   DRAGONSTONE(4, 4000, 10.0F, 8.0F, 27,
            ()->{ return Ingredient.fromItems(ModItems.dragonstone_gem);}),
   FYRITE(3, 150, 8.0F, 4.0F, 7,
            ()->{ return Ingredient.fromItems(ModItems.fyrite_ingot);}),
   ILLUMENITE(3, 700, 8.0F, 4.0F, 7,
            ()->{ return Ingredient.fromItems(ModItems.illumenite_ingot);}),
   MALACHITE(3, 700, 9.0F, 3.0F, 39,
                  ()->{ return Ingredient.fromItems(ModItems.malachite_ingot);});

   private final int harvestLevel;
   private final int maxUses;
   private final float efficiency;
   private final float attackDamage;
   private final int enchantability;
   private final LazyLoadBase<Ingredient> repairMaterial;

   private NetherrocksItemTier(int harvestLevelIn, int maxUsesIn, float efficiencyIn, float attackDamageIn, int enchantabilityIn,
                               Supplier<Ingredient> repairMaterialIn)
   {
      this.harvestLevel = harvestLevelIn;
      this.maxUses = maxUsesIn;
      this.efficiency = efficiencyIn;
      this.attackDamage = attackDamageIn;
      this.enchantability = enchantabilityIn;
      this.repairMaterial = new LazyLoadBase<>(repairMaterialIn);
   }

   @Override
   public int getMaxUses() {
      return this.maxUses;
   }

   @Override
   public float getEfficiency() {
      return this.efficiency;
   }

   @Override
   public float getAttackDamage() {
      return this.attackDamage;
   }

   @Override
   public int getHarvestLevel() {
      return this.harvestLevel;
   }

   @Override
   public int getEnchantability() {
      return this.enchantability;
   }

   @Override
   public Ingredient getRepairMaterial() {
      return this.repairMaterial.getValue();
   }
}  // end class SimpleOresItemTier
