package mod.alexndr.netherrocks.content;

import java.util.function.Supplier;

import mod.alexndr.netherrocks.init.ModItems;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.ArmorItem.Type;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.util.Lazy;

public enum NetherrocksArmorMaterial implements ArmorMaterial
{
    FYRITE ("netherrocks:fyrite", 5, new int [] {3,4,5,3}, 7,
            SoundEvents.ARMOR_EQUIP_CHAIN , 0.0F, 0.0F,
            ()-> { return Ingredient.of(ModItems.fyrite_ingot.get());} ),
    MALACHITE ("netherrocks:malachite", 16, new int [] {2,4,4,2}, 39,
            SoundEvents.ARMOR_EQUIP_IRON , 0.0F, 0.0F,
            ()-> { return Ingredient.of(ModItems.malachite_ingot.get());} ),
    ILLUMENITE ("netherrocks:illumenite", 12, new int [] {3,5,5,4}, 15,
            SoundEvents.ARMOR_EQUIP_CHAIN , 0.0F, 0.0F,
            ()-> { return Ingredient.of(ModItems.illumenite_ingot.get());} ),
    DRAGONSTONE ("netherrocks:dragonstone", 48, new int [] {3,7,9,3}, 27,
    SoundEvents.ARMOR_EQUIP_GOLD, 2.0F, 0.1F,
        ()-> { return Ingredient.of(ModItems.dragonstone_gem.get());} );

    private static final int[] MAX_DAMAGE_ARRAY = new int[]{13, 15, 16, 11};
    private final String name;
    private final int maxDamageFactor;
    private final int[] damageReductionAmountArray;
    private final int enchantability;
    private final SoundEvent soundEvent;
    private final float toughness;
    private final Lazy<Ingredient> repairMaterial;
    private final float knockbackResistance;

    private NetherrocksArmorMaterial(String nameIn, int maxDamageIn, int[] drAmtArray,
                                     int enchantabilityIn, SoundEvent soundIn,
                                     float toughnessIn, float knockResistanceIn,
                                     Supplier<Ingredient> repairMatIn)
    {
        name = nameIn;
        maxDamageFactor = maxDamageIn;
        damageReductionAmountArray = drAmtArray;
        enchantability = enchantabilityIn;
        soundEvent = soundIn;
        toughness = toughnessIn;
        knockbackResistance = knockResistanceIn;
        repairMaterial = Lazy.of(repairMatIn);
    } // end ctor()

    @Override
    public int getDurabilityForType(Type pType) {
        return MAX_DAMAGE_ARRAY[pType.getSlot().getIndex()] * this.maxDamageFactor;
    }

    @Override
    public int getDefenseForType(Type pType) {
        return this.damageReductionAmountArray[pType.getSlot().getIndex()];
    }

    @Override
    public int getEnchantmentValue() {
        return this.enchantability;
    }

    @Override
    public SoundEvent getEquipSound() {
        return this.soundEvent;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return this.repairMaterial.get();
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public String getName() {
        return this.name;
    }

    @Override
    public float getToughness() {
        return this.toughness;
    }

    @Override
    public float getKnockbackResistance()
    {
        return knockbackResistance;
    }

}  // end class NetherrocksArmorMaterial
