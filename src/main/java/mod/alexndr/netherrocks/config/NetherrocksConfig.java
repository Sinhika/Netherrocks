package mod.alexndr.netherrocks.config;

import java.util.HashMap;
import java.util.Map;

import mod.alexndr.simplecorelib.config.ISimpleConfig;
import mod.alexndr.simplecorelib.config.ModOreConfig;

public class NetherrocksConfig  implements ISimpleConfig
{
    private static Map<String, Boolean> flags = new HashMap<>();

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

    public static NetherrocksConfig INSTANCE = new NetherrocksConfig();

    @Override
    public void clear()
    {
        flags.clear();
    }

    @Override
    public boolean getFlag(String n)
    {
        Boolean obj = flags.get(n);
        return obj != null && obj;
    }

    @Override
    public void putFlag(String n, boolean val)
    {
        flags.put(n, val);
    }
}  // end class NetherrocksConfig
