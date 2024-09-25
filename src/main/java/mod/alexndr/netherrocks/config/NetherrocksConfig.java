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

    // armor properties - fyrite
    private static final ModConfigSpec.IntValue serverFyriteBaseDefense;
    private static final ModConfigSpec.IntValue serverFyriteEnchantability;
    private static final ModConfigSpec.IntValue serverFyriteArmorDurability;
    private static final ModConfigSpec.DoubleValue serverFyriteToughness;
    private static final ModConfigSpec.DoubleValue serverFyriteKnockback;

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
        BUILDER.pop();
        BUILDER.push("illumenite");
        BUILDER.pop();
        BUILDER.push("dragonstone");
        BUILDER.pop();

        BUILDER.pop();
        BUILDER.push("Tool & Weapon Properties");
        BUILDER.push("argonite");
        BUILDER.pop();
        BUILDER.push("ashstone");
        BUILDER.pop();
        BUILDER.push("Fyrite");
        BUILDER.pop();
        BUILDER.push("Malachite");
        BUILDER.pop();
        BUILDER.push("illumenite");
        BUILDER.pop();
        BUILDER.push("dragonstone");
        BUILDER.pop();
        BUILDER.pop();
    } // end static block

    public static final ModConfigSpec SPEC = BUILDER.build();

    public static int illumeniteNVTime = 3600;        // night vision time (seconds)
    public static int illumeniteBlindnessTime = 60;   // target blindness time (seconds)
    public static int illumeniteSlowTime = 200;       // target slow time (seconds)
    public static int illumeniteSlowLevel = 3;        // slow level

    public static boolean addModLootToChests;
    public static boolean enableAshstoneGhastOre;

    public static ArmorProperties fyriteArmorRecord;

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

            // armor materials
            fyriteArmorRecord = new ArmorProperties(serverFyriteArmorDurability.get(), serverFyriteBaseDefense.get(),
                    serverFyriteEnchantability.get(), (float) serverFyriteToughness.getAsDouble(),
                    (float) serverFyriteKnockback.getAsDouble());

            // TODO
            // tool materials
            // TODO
        }
    } // end onLoad()


}  // end class NetherrocksConfig
