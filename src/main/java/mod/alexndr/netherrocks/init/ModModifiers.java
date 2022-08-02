package mod.alexndr.netherrocks.init;

import com.mojang.serialization.Codec;

import mod.alexndr.netherrocks.Netherrocks;
import mod.alexndr.netherrocks.helpers.NetherrocksLootModifiers.AutoSmeltLootModifier;
import mod.alexndr.netherrocks.helpers.NetherrocksLootModifiers.GhastOreLootModifier;
import net.minecraftforge.common.loot.IGlobalLootModifier;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public final class ModModifiers
{
    public static final DeferredRegister<Codec<? extends IGlobalLootModifier>> GLM = 
            DeferredRegister.create(ForgeRegistries.Keys.GLOBAL_LOOT_MODIFIER_SERIALIZERS, Netherrocks.MODID);
    
    public static final RegistryObject<Codec<AutoSmeltLootModifier>> AUTO_SMELT_TOOL 
        = GLM.register("auto_smelt_tool", AutoSmeltLootModifier.CODEC);
    
    public static final RegistryObject<Codec<GhastOreLootModifier>> GHAST_ORE_LOOT
        = GLM.register("ghast_ore_loot", GhastOreLootModifier.CODEC);
    
} // end class
