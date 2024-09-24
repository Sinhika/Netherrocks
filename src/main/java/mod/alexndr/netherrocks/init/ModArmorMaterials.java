package mod.alexndr.netherrocks.init;

import mod.alexndr.netherrocks.Netherrocks;
import mod.alexndr.netherrocks.config.NetherrocksConfig;
import net.minecraft.Util;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.crafting.Ingredient;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.EnumMap;
import java.util.List;

public final class ModArmorMaterials
{
    public static final DeferredRegister<ArmorMaterial> ARMOR_MATERIALS =
            DeferredRegister.create(BuiltInRegistries.ARMOR_MATERIAL, Netherrocks.MODID);

    public static final Holder<ArmorMaterial> FYRITE = ARMOR_MATERIALS.register("fyrite", () -> new ArmorMaterial (
                    Util.make(new EnumMap<>(ArmorItem.Type.class), map -> {
                        map.put(ArmorItem.Type.BOOTS, NetherrocksConfig.fyriteArmorRecord.baseDefense()-1);
                        map.put(ArmorItem.Type.LEGGINGS, NetherrocksConfig.fyriteArmorRecord.baseDefense());
                        map.put(ArmorItem.Type.CHESTPLATE, NetherrocksConfig.fyriteArmorRecord.baseDefense()+1);
                        map.put(ArmorItem.Type.HELMET, NetherrocksConfig.fyriteArmorRecord.baseDefense()-1);
                        map.put(ArmorItem.Type.BODY, NetherrocksConfig.fyriteArmorRecord.baseDefense());
                    }),
                NetherrocksConfig.fyriteArmorRecord.enchantability(),
            SoundEvents.ARMOR_EQUIP_CHAIN,
                    () -> Ingredient.of(ModItems.fyrite_ingot.get()),
                    List.of( new ArmorMaterial.Layer(new ResourceLocation(Netherrocks.MODID, "fyrite"))),
                NetherrocksConfig.fyriteArmorRecord.toughness(), NetherrocksConfig.fyriteArmorRecord.knockbackResistance()
            )); // end fyrite

public static final Holder<ArmorMaterial> MALACHITE = ARMOR_MATERIALS.register("malachite", () -> new ArmorMaterial (
        Util.make(new EnumMap<>(ArmorItem.Type.class), map -> {
            map.put(ArmorItem.Type.BOOTS, 2);
            map.put(ArmorItem.Type.LEGGINGS, 4);
            map.put(ArmorItem.Type.CHESTPLATE, 4);
            map.put(ArmorItem.Type.HELMET, 2);
            map.put(ArmorItem.Type.BODY, 4);
        }),
        39, SoundEvents.ARMOR_EQUIP_IRON,
        () -> Ingredient.of(ModItems.malachite_ingot.get()),
        List.of( new ArmorMaterial.Layer(new ResourceLocation(Netherrocks.MODID, "malachite"))),
        0,0)); // end malachite

public static final Holder<ArmorMaterial> ILLUMENITE = ARMOR_MATERIALS.register("illumenite", () -> new ArmorMaterial (
        Util.make(new EnumMap<>(ArmorItem.Type.class), map -> {
            map.put(ArmorItem.Type.BOOTS, 3);
            map.put(ArmorItem.Type.LEGGINGS, 5);
            map.put(ArmorItem.Type.CHESTPLATE, 5);
            map.put(ArmorItem.Type.HELMET, 4);
            map.put(ArmorItem.Type.BODY, 5);
        }),
        15, SoundEvents.ARMOR_EQUIP_CHAIN,
        () -> Ingredient.of(ModItems.illumenite_ingot.get()),
        List.of( new ArmorMaterial.Layer(new ResourceLocation(Netherrocks.MODID, "illumenite"))),
        0,0)); // end illumenite

public static final Holder<ArmorMaterial> DRAGONSTONE = ARMOR_MATERIALS.register("dragonstone", () -> new ArmorMaterial (
        Util.make(new EnumMap<>(ArmorItem.Type.class), map -> {
            map.put(ArmorItem.Type.BOOTS, 3);
            map.put(ArmorItem.Type.LEGGINGS, 7);
            map.put(ArmorItem.Type.CHESTPLATE, 9);
            map.put(ArmorItem.Type.HELMET, 3);
            map.put(ArmorItem.Type.BODY, 7);
        }),
        27, SoundEvents.ARMOR_EQUIP_GOLD,
        () -> Ingredient.of(ModItems.dragonstone_gem.get()),
        List.of( new ArmorMaterial.Layer(new ResourceLocation(Netherrocks.MODID, "dragonstone"))),
        0,0)); // end illumenite

} // end class
