package mod.alexndr.netherrocks.config;

import net.minecraft.world.gen.placement.CountRangeConfig;

public class NetherrocksConfig
{
    public static boolean enableArgoniteOre;
    public static boolean enableAshstoneOre;
    public static boolean enableDragonstoneOre;
    public static boolean enableFyriteOre;
    public static boolean enableIllumeniteOre;
    public static boolean enableMalachiteOre;

    // Vein/Chunk Count, MinHeight, MaxHeightBase, MaxHeight
    public static CountRangeConfig argonite_cfg = new CountRangeConfig(10, 0, 0, 128);
    public static int argonite_veinsize = 6;
    public static CountRangeConfig ashstone_cfg = new CountRangeConfig(10, 0, 0, 128);
    public static int ashstone_veinsize = 5;
    public static CountRangeConfig dragonstone_cfg = new CountRangeConfig(7, 0, 0, 128);
    public static int dragonstone_veinsize = 5;
    public static CountRangeConfig fyrite_cfg = new CountRangeConfig(10, 0, 0, 128);
    public static int fyrite_veinsize = 6;
    public static CountRangeConfig malachite_cfg = new CountRangeConfig(10, 0, 0, 128);
    public static int malachite_veinsize = 7;

    public static CountRangeConfig illumenite_cfg = new CountRangeConfig(5, 0, 0, 128);
    public static int illumenite_veinsize = 15;

}  // end class NetherrocksConfig
