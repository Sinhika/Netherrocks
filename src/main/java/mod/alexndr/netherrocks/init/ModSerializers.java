package mod.alexndr.netherrocks.init;

import com.mojang.serialization.Codec;

import mod.alexndr.netherrocks.Netherrocks;
import mod.alexndr.netherrocks.helpers.NetherrocksLootModifiers.AutoSmeltLootModifier;
import mod.alexndr.netherrocks.helpers.NetherrocksLootModifiers.GhastOreLootModifier;
import net.neoforged.neoforge.common.loot.IGlobalLootModifier;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.ForgeRegistries;
import net.neoforged.neoforge.registries.RegistryObject;

public final class ModSerializers
{
    public static final DeferredRegister<Codec<? extends IGlobalLootModifier>> GLM = 
            DeferredRegister.create(ForgeRegistries.Keys.GLOBAL_LOOT_MODIFIER_SERIALIZERS, Netherrocks.MODID);
    
    public static final RegistryObject<Codec<AutoSmeltLootModifier>> AUTO_SMELT_TOOL 
        = GLM.register("auto_smelt_tool", AutoSmeltLootModifier.CODEC);
    
    public static final RegistryObject<Codec<GhastOreLootModifier>> GHAST_ORE_LOOT
        = GLM.register("ghast_ore_loot", GhastOreLootModifier.CODEC);
    
} // end class
