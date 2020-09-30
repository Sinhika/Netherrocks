package mod.alexndr.netherrocks.content;

import mod.alexndr.netherrocks.init.ModItems;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.LazyValue;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.function.Supplier;

public enum NetherrocksArmorMaterial implements IArmorMaterial
{
    FYRITE ("netherrocks:fyrite", 5, new int [] {3,4,5,3}, 7,
            SoundEvents.ITEM_ARMOR_EQUIP_CHAIN , 0.0F, 0.0F,
            ()-> { return Ingredient.fromItems(ModItems.fyrite_ingot.get());} ),
    MALACHITE ("netherrocks:malachite", 16, new int [] {2,4,4,2}, 39,
            SoundEvents.ITEM_ARMOR_EQUIP_IRON , 0.0F, 0.0F,
            ()-> { return Ingredient.fromItems(ModItems.malachite_ingot.get());} ),
    ILLUMENITE ("netherrocks:illumenite", 12, new int [] {3,5,5,4}, 15,
            SoundEvents.ITEM_ARMOR_EQUIP_CHAIN , 0.0F, 0.0F,
            ()-> { return Ingredient.fromItems(ModItems.illumenite_ingot.get());} ),
    DRAGONSTONE ("netherrocks:dragonstone", 48, new int [] {3,7,9,3}, 27,
    SoundEvents.ITEM_ARMOR_EQUIP_GOLD, 2.0F, 0.1F,
        ()-> { return Ingredient.fromItems(ModItems.dragonstone_gem.get());} );

    private static final int[] MAX_DAMAGE_ARRAY = new int[]{13, 15, 16, 11};
    private final String name;
    private final int maxDamageFactor;
    private final int[] damageReductionAmountArray;
    private final int enchantability;
    private final SoundEvent soundEvent;
    private final float toughness;
    private final LazyValue<Ingredient> repairMaterial;
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
        repairMaterial = new LazyValue<>(repairMatIn);
    } // end ctor()

    @Override
    public int getDurability(EquipmentSlotType slotIn) {
        return MAX_DAMAGE_ARRAY[slotIn.getIndex()] * this.maxDamageFactor;
    }

    @Override
    public int getDamageReductionAmount(EquipmentSlotType slotIn) {
        return this.damageReductionAmountArray[slotIn.getIndex()];
    }

    @Override
    public int getEnchantability() {
        return this.enchantability;
    }

    @Override
    public SoundEvent getSoundEvent() {
        return this.soundEvent;
    }

    @Override
    public Ingredient getRepairMaterial() {
        return this.repairMaterial.getValue();
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
