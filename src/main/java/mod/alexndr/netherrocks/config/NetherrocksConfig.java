package mod.alexndr.netherrocks.config;

import net.minecraft.world.gen.placement.CountRangeConfig;

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

    // Vein/Chunk Count, MinHeight, MaxHeightBase, MaxHeight
    public static CountRangeConfig argonite_cfg;
    public static int argonite_veinsize = 6;
    public static CountRangeConfig ashstone_cfg;
    public static int ashstone_veinsize = 5;
    public static CountRangeConfig dragonstone_cfg;
    public static int dragonstone_veinsize = 5;
    public static CountRangeConfig fyrite_cfg;
    public static int fyrite_veinsize = 6;
    public static CountRangeConfig malachite_cfg;
    public static int malachite_veinsize = 7;

    public static CountRangeConfig illumenite_cfg;
    public static int illumenite_veinsize = 15;

}  // end class NetherrocksConfig
