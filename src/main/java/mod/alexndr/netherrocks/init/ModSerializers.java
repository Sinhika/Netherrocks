package mod.alexndr.netherrocks.init;

import com.mojang.serialization.MapCodec;
import mod.alexndr.netherrocks.Netherrocks;
import mod.alexndr.netherrocks.helpers.NetherrocksLootModifiers.AutoSmeltLootModifier;
import mod.alexndr.netherrocks.helpers.NetherrocksLootModifiers.GhastOreLootModifier;
import net.neoforged.neoforge.common.loot.IGlobalLootModifier;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

import java.util.function.Supplier;

public final class ModSerializers
{
    public static final DeferredRegister<MapCodec<? extends IGlobalLootModifier>> GLM =
            DeferredRegister.create(NeoForgeRegistries.Keys.GLOBAL_LOOT_MODIFIER_SERIALIZERS, Netherrocks.MODID);
    
    public static final Supplier<MapCodec<AutoSmeltLootModifier>> AUTO_SMELT_TOOL
        = GLM.register("auto_smelt_tool", ()-> AutoSmeltLootModifier.CODEC);

    public static final Supplier<MapCodec<GhastOreLootModifier>> GHAST_ORE_LOOT
        = GLM.register("ghast_ore_loot", () -> GhastOreLootModifier.CODEC);

    public static final Supplier<MapCodec<? extends IGlobalLootModifier>> CHEST_LOOT
        = GLM.register("chest_loot", () -> NetherrocksChestLootModifier.CODEC);
} // end class
