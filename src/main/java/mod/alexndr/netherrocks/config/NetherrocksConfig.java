package mod.alexndr.netherrocks.config;

import mod.alexndr.simplecorelib.api.config.SimpleConfig;

public class NetherrocksConfig  extends SimpleConfig
{
    public static NetherrocksConfig INSTANCE = new NetherrocksConfig();

    public static final int illumeniteNVTime = 3600;        // night vision time (seconds)
    public static final int illumeniteBlindnessTime = 60;   // target blindness time (seconds)
    public static final int illumeniteSlowTime = 200;       // target slow time (seconds)
    public static final int illumeniteSlowLevel = 3;        // slow level
    
    public static boolean addModLootToChests;
    public static boolean enableAshstoneGhastOre;
    
}  // end class NetherrocksConfig
