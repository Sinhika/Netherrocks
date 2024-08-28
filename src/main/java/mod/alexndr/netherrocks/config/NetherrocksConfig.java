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

    public static final ModConfigSpec.IntValue serverNetherrackBurnTime;
    public static final ModConfigSpec.IntValue serverFyriteBurnTime;
    public static final ModConfigSpec.IntValue serverBlazeRodBurnTime;
    public static final ModConfigSpec.IntValue serverBaseToolBurnTime;

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
        BUILDER.push("Nether Furnace Fuels");
        serverNetherrackBurnTime = BUILDER.comment("Ticks to consume 1 block of netherrack")
                .defineInRange("NetherrackBurnTime", 200, 1, 10000);
        serverFyriteBurnTime = BUILDER.comment("Ticks to consume 1 ingot of fyrite: base for several other burn times")
                .defineInRange("FyriteBurnTime", 8000, 1, 32000);
        serverBlazeRodBurnTime = BUILDER.comment("Ticks to consume 1 blaze rod; base for certain other burn times")
                .defineInRange("BlazeRodBurnTime", 2400, 1, 20000);
        serverBaseToolBurnTime = BUILDER.comment("Ticks to consume 1 fyrite tool")
                .defineInRange("BaseToolBurntime", 3200, 1, 32000);
        BUILDER.pop();        
    } // end static block

    public static final ModConfigSpec SPEC = BUILDER.build();

    public static int illumeniteNVTime = 3600;        // night vision time (seconds)
    public static int illumeniteBlindnessTime = 60;   // target blindness time (seconds)
    public static int illumeniteSlowTime = 200;       // target slow time (seconds)
    public static int illumeniteSlowLevel = 3;        // slow level
    public static int netherrackBurnTime = 200;
    public static int fyriteBurnTime = 8000;
    public static int blazeRodBurnTime = 2400;
    public static int baseToolBurnTime = 3200;

    public static boolean addModLootToChests;
    public static boolean enableAshstoneGhastOre;

    public static void onLoad(final ModConfigEvent.Loading event)
    {
        if (event.getConfig().getType() == ModConfig.Type.STARTUP)
        {
            addModLootToChests = serverAddModLootToChests.get();
            enableAshstoneGhastOre = serverEnableAshstoneGhastOre.get();
            illumeniteNVTime = serverIllumeniteNVTime.get();
            illumeniteBlindnessTime = serverIllumeniteBlindnessTime.get();
            illumeniteSlowTime = serverIllumeniteSlowTime.get();
            illumeniteSlowLevel = serverIllumeniteSlowLevel.get();
            netherrackBurnTime = serverNetherrackBurnTime.get();
            fyriteBurnTime = serverFyriteBurnTime.get();
            blazeRodBurnTime = serverBlazeRodBurnTime.get();
            baseToolBurnTime = serverBaseToolBurnTime.get();
        }
    } // end onLoad()

}  // end class NetherrocksConfig
