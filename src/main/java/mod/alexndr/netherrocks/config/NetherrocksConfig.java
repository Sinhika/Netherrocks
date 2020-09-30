package mod.alexndr.netherrocks.config;

import mod.alexndr.simplecorelib.config.ModOreConfig;

public class NetherrocksConfig
{
    public static final int illumeniteNVTime = 3600;        // night vision time (seconds)
    public static final int illumeniteBlindnessTime = 60;   // target blindness time (seconds)
    public static final int illumeniteSlowTime = 200;       // target slow time (seconds)
    public static final int illumeniteSlowLevel = 3;        // slow level
    
    
    public static boolean enableArgoniteOre;
    public static boolean enableAshstoneOre;
    public static boolean enableDragonstoneOre;
    public static boolean enableFyriteOre;
    public static boolean enableIllumeniteOre;
    public static boolean enableMalachiteOre;
    public static boolean addModLootToChests;

    // Vein/Chunk Count, MinHeight, MaxHeightBase, MaxHeight
    public static ModOreConfig argonite_cfg;
    public static ModOreConfig ashstone_cfg;
    public static ModOreConfig dragonstone_cfg;
    public static ModOreConfig fyrite_cfg;
    public static ModOreConfig malachite_cfg;
    public static ModOreConfig illumenite_cfg;

}  // end class NetherrocksConfig
