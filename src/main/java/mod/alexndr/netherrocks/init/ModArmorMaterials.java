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
            map.put(ArmorItem.Type.BOOTS, NetherrocksConfig.malachiteArmorRecord.baseDefense()-2);
            map.put(ArmorItem.Type.LEGGINGS, NetherrocksConfig.malachiteArmorRecord.baseDefense());
            map.put(ArmorItem.Type.CHESTPLATE, NetherrocksConfig.malachiteArmorRecord.baseDefense());
            map.put(ArmorItem.Type.HELMET, NetherrocksConfig.malachiteArmorRecord.baseDefense()-2);
            map.put(ArmorItem.Type.BODY, NetherrocksConfig.malachiteArmorRecord.baseDefense());
        }),
        NetherrocksConfig.malachiteArmorRecord.enchantability(), SoundEvents.ARMOR_EQUIP_IRON,
        () -> Ingredient.of(ModItems.malachite_ingot.get()),
        List.of( new ArmorMaterial.Layer(new ResourceLocation(Netherrocks.MODID, "malachite"))),
        NetherrocksConfig.malachiteArmorRecord.toughness(), NetherrocksConfig.malachiteArmorRecord.knockbackResistance()
)); // end malachite

public static final Holder<ArmorMaterial> ILLUMENITE = ARMOR_MATERIALS.register("illumenite", () -> new ArmorMaterial (
        Util.make(new EnumMap<>(ArmorItem.Type.class), map -> {
            map.put(ArmorItem.Type.BOOTS, NetherrocksConfig.illumeniteArmorRecord.baseDefense()-2);
            map.put(ArmorItem.Type.LEGGINGS, NetherrocksConfig.illumeniteArmorRecord.baseDefense());
            map.put(ArmorItem.Type.CHESTPLATE,NetherrocksConfig.illumeniteArmorRecord.baseDefense());
            map.put(ArmorItem.Type.HELMET, NetherrocksConfig.illumeniteArmorRecord.baseDefense()-1);
            map.put(ArmorItem.Type.BODY, NetherrocksConfig.illumeniteArmorRecord.baseDefense());
        }),
        NetherrocksConfig.illumeniteArmorRecord.enchantability(), SoundEvents.ARMOR_EQUIP_CHAIN,
        () -> Ingredient.of(ModItems.illumenite_ingot.get()),
        List.of( new ArmorMaterial.Layer(new ResourceLocation(Netherrocks.MODID, "illumenite"))),
        NetherrocksConfig.illumeniteArmorRecord.toughness(), NetherrocksConfig.illumeniteArmorRecord.knockbackResistance()
)); // end illumenite

public static final Holder<ArmorMaterial> DRAGONSTONE = ARMOR_MATERIALS.register("dragonstone", () -> new ArmorMaterial (
        Util.make(new EnumMap<>(ArmorItem.Type.class), map -> {
            map.put(ArmorItem.Type.BOOTS, NetherrocksConfig.dragonstoneArmorRecord.baseDefense()-4);
            map.put(ArmorItem.Type.LEGGINGS,NetherrocksConfig.dragonstoneArmorRecord.baseDefense());
            map.put(ArmorItem.Type.CHESTPLATE, NetherrocksConfig.dragonstoneArmorRecord.baseDefense()+2);
            map.put(ArmorItem.Type.HELMET, NetherrocksConfig.dragonstoneArmorRecord.baseDefense()-4);
            map.put(ArmorItem.Type.BODY, NetherrocksConfig.dragonstoneArmorRecord.baseDefense());
        }),
        NetherrocksConfig.dragonstoneArmorRecord.enchantability(), SoundEvents.ARMOR_EQUIP_GOLD,
        () -> Ingredient.of(ModItems.dragonstone_gem.get()),
        List.of( new ArmorMaterial.Layer(new ResourceLocation(Netherrocks.MODID, "dragonstone"))),
        NetherrocksConfig.dragonstoneArmorRecord.toughness(), NetherrocksConfig.dragonstoneArmorRecord.knockbackResistance()
)); // end dragonstone

} // end class
