package mod.alexndr.netherrocks.config;

import mod.alexndr.netherrocks.Netherrocks;
import mod.alexndr.simplecorelib.api.config.SimpleConfig;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.event.config.ModConfigEvent;
import net.neoforged.neoforge.common.ModConfigSpec;

public class NetherrocksConfig  extends SimpleConfig
{
    private static final ModConfigSpec.Builder BUILDER = new ModConfigSpec.Builder();

    private static final ModConfigSpec.BooleanValue serverAddModLootToChests;
    private static final ModConfigSpec.BooleanValue serverEnableAshstoneGhastOre;
    private static final ModConfigSpec.IntValue serverIllumeniteNVTime;
    private static final ModConfigSpec.IntValue serverIllumeniteBlindnessTime;
    private static final ModConfigSpec.IntValue serverIllumeniteSlowTime;
    private static final ModConfigSpec.IntValue serverIllumeniteSlowLevel;
    private static final ModConfigSpec.BooleanValue serverIllumeniteHasGlowingEffect;

    // armor properties - fyrite
    private static final ModConfigSpec.IntValue serverFyriteBaseDefense;
    private static final ModConfigSpec.IntValue serverFyriteEnchantability;
    private static final ModConfigSpec.IntValue serverFyriteArmorDurability;
    private static final ModConfigSpec.DoubleValue serverFyriteToughness;
    private static final ModConfigSpec.DoubleValue serverFyriteKnockback;

    // armor properties - Malachite
    private static final ModConfigSpec.IntValue serverMalachiteBaseDefense;
    private static final ModConfigSpec.IntValue serverMalachiteEnchantability;
    private static final ModConfigSpec.IntValue serverMalachiteArmorDurability;
    private static final ModConfigSpec.DoubleValue serverMalachiteToughness;
    private static final ModConfigSpec.DoubleValue serverMalachiteKnockback;

    // armor properties - Illumenite
    private static final ModConfigSpec.IntValue serverIllumeniteBaseDefense;
    private static final ModConfigSpec.IntValue serverIllumeniteEnchantability;
    private static final ModConfigSpec.IntValue serverIllumeniteArmorDurability;
    private static final ModConfigSpec.DoubleValue serverIllumeniteToughness;
    private static final ModConfigSpec.DoubleValue serverIllumeniteKnockback;

    // armor properties - Dragonstone
    private static final ModConfigSpec.IntValue serverDragonstoneBaseDefense;
    private static final ModConfigSpec.IntValue serverDragonstoneEnchantability;
    private static final ModConfigSpec.IntValue serverDragonstoneArmorDurability;
    private static final ModConfigSpec.DoubleValue serverDragonstoneToughness;
    private static final ModConfigSpec.DoubleValue serverDragonstoneKnockback;

    // tool properties - Argonite
    private static final ModConfigSpec.IntValue serverArgoniteUses;
    private static final ModConfigSpec.DoubleValue serverArgoniteSpeedBonus;
    private static final ModConfigSpec.DoubleValue serverArgoniteAttackBonus;
    private static final ModConfigSpec.IntValue serverArgoniteToolEnchantabilty;

    // tool properties - Ashstone
    private static final ModConfigSpec.IntValue serverAshstoneUses;
    private static final ModConfigSpec.DoubleValue serverAshstoneSpeedBonus;
    private static final ModConfigSpec.DoubleValue serverAshstoneAttackBonus;
    private static final ModConfigSpec.IntValue serverAshstoneToolEnchantabilty;

    // tool properties - Fyrite
    private static final ModConfigSpec.IntValue serverFyriteUses;
    private static final ModConfigSpec.DoubleValue serverFyriteSpeedBonus;
    private static final ModConfigSpec.DoubleValue serverFyriteAttackBonus;
    private static final ModConfigSpec.IntValue serverFyriteToolEnchantabilty;

    // tool properties - Illumenite
    private static final ModConfigSpec.IntValue serverIllumeniteUses;
    private static final ModConfigSpec.DoubleValue serverIllumeniteSpeedBonus;
    private static final ModConfigSpec.DoubleValue serverIllumeniteAttackBonus;
    private static final ModConfigSpec.IntValue serverIllumeniteToolEnchantabilty;

    // tool properties - Malachite
    private static final ModConfigSpec.IntValue serverMalachiteUses;
    private static final ModConfigSpec.DoubleValue serverMalachiteSpeedBonus;
    private static final ModConfigSpec.DoubleValue serverMalachiteAttackBonus;
    private static final ModConfigSpec.IntValue serverMalachiteToolEnchantabilty;

    // tool properties - Dragonstone
    private static final ModConfigSpec.IntValue serverDragonstoneUses;
    private static final ModConfigSpec.DoubleValue serverDragonstoneSpeedBonus;
    private static final ModConfigSpec.DoubleValue serverDragonstoneAttackBonus;
    private static final ModConfigSpec.IntValue serverDragonstoneToolEnchantabilty;


    static {
        BUILDER.push("General");
        serverAddModLootToChests = BUILDER.comment("Add Netherrocks items to chest loot?")
                .translation(Netherrocks.MODID + ".config.serverAddModLootToChests")
                .define("AddModLootToChests", true);
        serverEnableAshstoneGhastOre = BUILDER.comment("Enable Ashstone to double as ghast tear ore?")
                .translation(Netherrocks.MODID + "config.EnableAshstoneGhastOre")
                .define("EnableAshstoneGhastOre", false);
        BUILDER.pop();
        BUILDER.push("Illumenite Properties");
        serverIllumeniteNVTime = BUILDER.comment("Illumenite Night Vision duration(seconds)")
                        .defineInRange("illumeniteNVTime", 3600, 1, 9999);
        serverIllumeniteBlindnessTime = BUILDER.comment("Illumenite target blindness time (seconds)")
                        .defineInRange("illumeniteBlindnessTime", 60, 1, 9999);
        serverIllumeniteSlowTime = BUILDER.comment("Illumenite target slowed time (seconds)")
                        .defineInRange("illumeniteSlowTime", 180, 1, 9999);
        serverIllumeniteSlowLevel = BUILDER.comment("Illumenite target slowed level")
                        .defineInRange("illumeniteSlowLevel", 3, 1, 5);
        serverIllumeniteHasGlowingEffect = BUILDER.comment("Illumenite armor has Glowing effect")
                        .define("IllumeniteHasGlowingEffect", false);
        BUILDER.pop();
        BUILDER.push("Armor Properties");
        BUILDER.push("Fyrite");
        serverFyriteBaseDefense = BUILDER.comment("Body Defense - base from which other defense values are calculated")
                        .defineInRange("fyriteBodyDefense", 4, 1, 20);
        serverFyriteEnchantability = BUILDER.comment("Fyrite Armor Enchantability")
                        .defineInRange("fyriteArmorEnchantibility", 7, 1, 99);
        serverFyriteArmorDurability = BUILDER.comment("Base durability for fyrite armor")
                .defineInRange("fyriteArmorDurability", 5, 1, 99);
        serverFyriteToughness = BUILDER.comment("Toughness for fyrite armor")
                .defineInRange("fyriteToughness", 0.0, 0.0, 10.0);
        serverFyriteKnockback = BUILDER.comment("Knockback Resistance for fyrite armor")
                .defineInRange("fyriteKnockback", 0.0, 0.0, 10.0);
        BUILDER.pop();
        BUILDER.push("Malachite");
        serverMalachiteBaseDefense = BUILDER.comment("Body Defense - base from which other defense values are calculated")
                .defineInRange("MalachiteBodyDefense", 4, 1, 20);
        serverMalachiteEnchantability = BUILDER.comment("Malachite Armor Enchantability")
                .defineInRange("MalachiteArmorEnchantibility", 39, 1, 99);
        serverMalachiteArmorDurability = BUILDER.comment("Base durability for Malachite armor")
                .defineInRange("MalachiteArmorDurability", 16, 1, 99);
        serverMalachiteToughness = BUILDER.comment("Toughness for Malachite armor")
                .defineInRange("MalachiteToughness", 0.0, 0.0, 10.0);
        serverMalachiteKnockback = BUILDER.comment("Knockback Resistance for Malachite armor")
                .defineInRange("MalachiteKnockback", 0.0, 0.0, 10.0);
        BUILDER.pop();
        BUILDER.push("illumenite");
        serverIllumeniteBaseDefense = BUILDER.comment("Body Defense - base from which other defense values are calculated")
                .defineInRange("IllumeniteBodyDefense", 5, 1, 20);
        serverIllumeniteEnchantability = BUILDER.comment("Illumenite Armor Enchantability")
                .defineInRange("IllumeniteArmorEnchantibility", 15, 1, 99);
        serverIllumeniteArmorDurability = BUILDER.comment("Base durability for Illumenite armor")
                .defineInRange("IllumeniteArmorDurability", 12, 1, 99);
        serverIllumeniteToughness = BUILDER.comment("Toughness for Illumenite armor")
                .defineInRange("IllumeniteToughness", 0.0, 0.0, 10.0);
        serverIllumeniteKnockback = BUILDER.comment("Knockback Resistance for Illumenite armor")
                .defineInRange("IllumeniteKnockback", 0.0, 0.0, 10.0);
        BUILDER.pop();
        BUILDER.push("dragonstone");
        serverDragonstoneBaseDefense = BUILDER.comment("Body Defense - base from which other defense values are calculated")
                .defineInRange("DragonstoneBodyDefense", 7, 1, 20);
        serverDragonstoneEnchantability = BUILDER.comment("Dragonstone Armor Enchantability")
                .defineInRange("DragonstoneArmorEnchantibility", 27, 1, 99);
        serverDragonstoneArmorDurability = BUILDER.comment("Base durability for Dragonstone armor")
                .defineInRange("DragonstoneArmorDurability", 48, 1, 99);
        serverDragonstoneToughness = BUILDER.comment("Toughness for Dragonstone armor")
                .defineInRange("DragonstoneToughness", 2.0, 0.0, 10.0);
        serverDragonstoneKnockback = BUILDER.comment("Knockback Resistance for Dragonstone armor")
                .defineInRange("DragonstoneKnockback", 0.1, 0.0, 10.0);
        BUILDER.pop();

        BUILDER.pop();
        BUILDER.push("Tool & Weapon Properties");
        BUILDER.push("argonite");
        serverArgoniteUses = BUILDER.comment("Uses before Argonite tool breaks, aka Durability")
                        .defineInRange("ArgoniteUses", 1300, 1, 9999);
        serverArgoniteSpeedBonus = BUILDER.comment("Speed (efficiency) bonus for Argonite added to base tool speed")
                        .defineInRange("ArgoniteSpeedBonus", 8.0, 0.0, 99.0);
        serverArgoniteAttackBonus = BUILDER.comment("Argonite Attack Damage Bonus to base tool damage")
                        .defineInRange("ArgoniteAttackBonus", 3.0, -1.0, 99.0);
        serverArgoniteToolEnchantabilty = BUILDER.comment("Argonite tool enchantability")
                        .defineInRange("ArgoniteToolEnchantabilty", 18, 0, 99);
        BUILDER.pop();
        BUILDER.push("ashstone");
        serverAshstoneUses = BUILDER.comment("Uses before Ashstone tool breaks, aka Durability")
                .defineInRange("AshstoneUses", 900, 1, 9999);
        serverAshstoneSpeedBonus = BUILDER.comment("Speed (efficiency) bonus for Ashstone added to base tool speed")
                .defineInRange("AshstoneSpeedBonus", 16.0, 0.0, 99.0);
        serverAshstoneAttackBonus = BUILDER.comment("Ashstone Attack Damage Bonus to base tool damage")
                .defineInRange("AshstoneAttackBonus", 2.0, -1.0, 99.0);
        serverAshstoneToolEnchantabilty = BUILDER.comment("Ashstone tool enchantability")
                .defineInRange("AshstoneToolEnchantabilty", 7, 0, 99);
        BUILDER.pop();
        BUILDER.push("Fyrite");
        serverFyriteUses = BUILDER.comment("Uses before Fyrite tool breaks, aka Durability")
                .defineInRange("FyriteUses", 150, 1, 9999);
        serverFyriteSpeedBonus = BUILDER.comment("Speed (efficiency) bonus for Fyrite added to base tool speed")
                .defineInRange("FyriteSpeedBonus", 8.0, 0.0, 99.0);
        serverFyriteAttackBonus = BUILDER.comment("Fyrite Attack Damage Bonus to base tool damage")
                .defineInRange("FyriteAttackBonus", 4.0, -1.0, 99.0);
        serverFyriteToolEnchantabilty = BUILDER.comment("Fyrite tool enchantability")
                .defineInRange("FyriteToolEnchantabilty", 7, 0, 99);
        BUILDER.pop();
        BUILDER.push("illumenite");
        serverIllumeniteUses = BUILDER.comment("Uses before Illumenite tool breaks, aka Durability")
                .defineInRange("IllumeniteUses", 700, 1, 9999);
        serverIllumeniteSpeedBonus = BUILDER.comment("Speed (efficiency) bonus for Illumenite added to base tool speed")
                .defineInRange("IllumeniteSpeedBonus", 8.0, 0.0, 99.0);
        serverIllumeniteAttackBonus = BUILDER.comment("Illumenite Attack Damage Bonus to base tool damage")
                .defineInRange("IllumeniteAttackBonus", 4.0, -1.0, 99.0);
        serverIllumeniteToolEnchantabilty = BUILDER.comment("Illumenite tool enchantability")
                .defineInRange("IllumeniteToolEnchantabilty", 15, 0, 99);
        BUILDER.pop();
        BUILDER.push("Malachite");
        serverMalachiteUses = BUILDER.comment("Uses before Malachite tool breaks, aka Durability")
                .defineInRange("MalachiteUses", 700, 1, 9999);
        serverMalachiteSpeedBonus = BUILDER.comment("Speed (efficiency) bonus for Malachite added to base tool speed")
                .defineInRange("MalachiteSpeedBonus", 9.0, 0.0, 99.0);
        serverMalachiteAttackBonus = BUILDER.comment("Malachite Attack Damage Bonus to base tool damage")
                .defineInRange("MalachiteAttackBonus", 3.0, -1.0, 99.0);
        serverMalachiteToolEnchantabilty = BUILDER.comment("Malachite tool enchantability")
                .defineInRange("MalachiteToolEnchantabilty", 39, 0, 99);
        BUILDER.pop();
        BUILDER.push("dragonstone");
        serverDragonstoneUses = BUILDER.comment("Uses before Dragonstone tool breaks, aka Durability")
                .defineInRange("DragonstoneUses", 4000, 1, 9999);
        serverDragonstoneSpeedBonus = BUILDER.comment("Speed (efficiency) bonus for Dragonstone added to base tool speed")
                .defineInRange("DragonstoneSpeedBonus", 10.0, 0.0, 99.0);
        serverDragonstoneAttackBonus = BUILDER.comment("Dragonstone Attack Damage Bonus to base tool damage")
                .defineInRange("DragonstoneAttackBonus", 8.0, -1.0, 99.0);
        serverDragonstoneToolEnchantabilty = BUILDER.comment("Dragonstone tool enchantability")
                .defineInRange("DragonstoneToolEnchantabilty", 27, 0, 99);
        BUILDER.pop();
        BUILDER.pop();
    } // end static block

    public static final ModConfigSpec SPEC = BUILDER.build();

    public static int illumeniteNVTime = 3600;        // night vision time (seconds)
    public static int illumeniteBlindnessTime = 60;   // target blindness time (seconds)
    public static int illumeniteSlowTime = 200;       // target slow time (seconds)
    public static int illumeniteSlowLevel = 3;        // slow level
    public static boolean illumeniteHasGlowingEffect;

    public static boolean addModLootToChests;
    public static boolean enableAshstoneGhastOre;

    public static ArmorProperties fyriteArmorRecord;
    public static ArmorProperties malachiteArmorRecord;
    public static ArmorProperties illumeniteArmorRecord;
    public static ArmorProperties dragonstoneArmorRecord;

    public static ToolProperties argoniteToolRecord;
    public static ToolProperties ashstoneToolRecord;
    public static ToolProperties fyriteToolRecord;
    public static ToolProperties malachiteToolRecord;
    public static ToolProperties illumeniteToolRecord;
    public static ToolProperties dragonstoneToolRecord;

    public static void onLoadStartup(final ModConfigEvent.Loading event)
    {
        if (event.getConfig().getType() == ModConfig.Type.STARTUP)
        {
            addModLootToChests = serverAddModLootToChests.get();
            enableAshstoneGhastOre = serverEnableAshstoneGhastOre.get();
            illumeniteNVTime = serverIllumeniteNVTime.get();
            illumeniteBlindnessTime = serverIllumeniteBlindnessTime.get();
            illumeniteSlowTime = serverIllumeniteSlowTime.get();
            illumeniteSlowLevel = serverIllumeniteSlowLevel.get();
            illumeniteHasGlowingEffect = serverIllumeniteHasGlowingEffect.get();

            // armor materials
            fyriteArmorRecord = new ArmorProperties(serverFyriteArmorDurability.get(), serverFyriteBaseDefense.get(),
                    serverFyriteEnchantability.get(), (float) serverFyriteToughness.getAsDouble(),
                    (float) serverFyriteKnockback.getAsDouble());
            malachiteArmorRecord = new ArmorProperties(serverMalachiteArmorDurability.get(), serverMalachiteBaseDefense.get(),
                    serverMalachiteEnchantability.get(), (float) serverMalachiteToughness.getAsDouble(),
                    (float) serverMalachiteKnockback.getAsDouble());
            illumeniteArmorRecord = new ArmorProperties(serverIllumeniteArmorDurability.get(), serverIllumeniteBaseDefense.get(),
                    serverIllumeniteEnchantability.get(), (float) serverIllumeniteToughness.getAsDouble(),
                    (float) serverIllumeniteKnockback.getAsDouble());
            dragonstoneArmorRecord = new ArmorProperties(serverDragonstoneArmorDurability.get(), serverDragonstoneBaseDefense.get(),
                    serverDragonstoneEnchantability.get(), (float) serverDragonstoneToughness.getAsDouble(),
                    (float) serverDragonstoneKnockback.getAsDouble());

            // tool materials
            argoniteToolRecord = new ToolProperties(serverArgoniteUses.get(), (float) serverArgoniteSpeedBonus.getAsDouble(),
                    (float) serverArgoniteAttackBonus.getAsDouble(), serverArgoniteToolEnchantabilty.get());
            ashstoneToolRecord = new ToolProperties(serverAshstoneUses.get(), (float) serverAshstoneSpeedBonus.getAsDouble(),
                    (float) serverAshstoneAttackBonus.getAsDouble(), serverAshstoneToolEnchantabilty.get());
            fyriteToolRecord = new ToolProperties(serverFyriteUses.get(), (float) serverFyriteSpeedBonus.getAsDouble(),
                    (float) serverFyriteAttackBonus.getAsDouble(), serverFyriteToolEnchantabilty.get());
            illumeniteToolRecord = new ToolProperties(serverIllumeniteUses.get(), (float) serverIllumeniteSpeedBonus.getAsDouble(),
                    (float) serverIllumeniteAttackBonus.getAsDouble(), serverIllumeniteToolEnchantabilty.get());
            malachiteToolRecord = new ToolProperties(serverMalachiteUses.get(), (float) serverMalachiteSpeedBonus.getAsDouble(),
                    (float) serverMalachiteAttackBonus.getAsDouble(), serverMalachiteToolEnchantabilty.get());
            dragonstoneToolRecord = new ToolProperties(serverDragonstoneUses.get(), (float) serverDragonstoneSpeedBonus.getAsDouble(),
                    (float) serverDragonstoneAttackBonus.getAsDouble(), serverDragonstoneToolEnchantabilty.get());
        }
    } // end onLoad()


}  // end class NetherrocksConfig
