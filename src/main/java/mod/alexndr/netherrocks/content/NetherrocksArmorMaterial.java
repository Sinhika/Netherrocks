package mod.alexndr.netherrocks.content;

import mod.alexndr.netherrocks.init.ModItems;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.LazyLoadBase;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.function.Supplier;

public enum NetherrocksArmorMaterial implements IArmorMaterial
{
    ARGONITE ("netherrocks:argonite", 8, new int [] {1,2,3,2}, 8,
            SoundEvents.ITEM_ARMOR_EQUIP_CHAIN , 0.0F,
            ()-> { return Ingredient.fromItems(ModItems.argonite_ingot);} ),
    DRAGONSTONE ("netherrocks:argonite", 8, new int [] {1,2,3,2}, 8,
    SoundEvents.ITEM_ARMOR_EQUIP_CHAIN , 0.0F,
        ()-> { return Ingredient.fromItems(ModItems.dragonstone_gem);} );
    // TODO

    // TODO
    private static final int[] MAX_DAMAGE_ARRAY = new int[]{13, 15, 16, 11};
    private final String name;
    private final int maxDamageFactor;
    private final int[] damageReductionAmountArray;
    private final int enchantability;
    private final SoundEvent soundEvent;
    private final float toughness;
    private final LazyLoadBase<Ingredient> repairMaterial;

    private NetherrocksArmorMaterial(String nameIn, int maxDamageIn, int[] drAmtArray,
                                     int enchantabilityIn, SoundEvent soundIn,
                                     float toughnessIn,
                                     Supplier<Ingredient> repairMatIn)
    {
        name = nameIn;
        maxDamageFactor = maxDamageIn;
        damageReductionAmountArray = drAmtArray;
        enchantability = enchantabilityIn;
        soundEvent = soundIn;
        toughness = toughnessIn;
        repairMaterial = new LazyLoadBase<>(repairMatIn);
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
}  // end class NetherrocksArmorMaterial
