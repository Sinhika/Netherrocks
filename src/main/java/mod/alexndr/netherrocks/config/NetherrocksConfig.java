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
//    public static boolean enableAshstoneGhastOre;
    
    // Vein/Chunk Count, MinHeight, MaxHeightBase, MaxHeight
//    public static Lazy<ModOreConfig> argonite_cfg = Lazy.of(()->new ModOreConfig(ModOreConfig.FULL_RANGE, 
//                ConfigHolder.SERVER.serverArgoniteVeinSize.get(), ConfigHolder.SERVER.serverArgoniteVeinCount.get(), true,
//                VerticalAnchor.absolute(ConfigHolder.SERVER.serverArgoniteBottomHeight.get()),
//                VerticalAnchor.absolute(ConfigHolder.SERVER.serverArgoniteMaxHeight.get())));
//    
//    public static Lazy<ModOreConfig> ashstone_cfg = Lazy.of(()->new ModOreConfig(ModOreConfig.FULL_RANGE, 
//            ConfigHolder.SERVER.serverAshstoneVeinSize.get(), ConfigHolder.SERVER.serverAshstoneVeinCount.get(), true,
//            VerticalAnchor.absolute(ConfigHolder.SERVER.serverAshstoneBottomHeight.get()),
//            VerticalAnchor.absolute(ConfigHolder.SERVER.serverAshstoneMaxHeight.get())));
//
//    public static Lazy<ModOreConfig> dragonstone_cfg = Lazy.of(()->new ModOreConfig(ModOreConfig.FULL_RANGE,
//                ConfigHolder.SERVER.serverDragonstoneVeinSize.get(), ConfigHolder.SERVER.serverDragonstoneVeinCount.get(),
//                true,
//                VerticalAnchor.absolute(ConfigHolder.SERVER.serverDragonstoneBottomHeight.get()),
//                VerticalAnchor.absolute(ConfigHolder.SERVER.serverDragonstoneMaxHeight.get())));
//    
//    public static Lazy<ModOreConfig> fyrite_cfg = Lazy.of(()-> new ModOreConfig(ModOreConfig.FULL_RANGE, 
//                ConfigHolder.SERVER.serverFyriteVeinSize.get(), ConfigHolder.SERVER.serverFyriteVeinCount.get(), true,
//                VerticalAnchor.absolute(ConfigHolder.SERVER.serverFyriteBottomHeight.get()),
//                VerticalAnchor.absolute(ConfigHolder.SERVER.serverFyriteMaxHeight.get())));
//    
//    public static Lazy<ModOreConfig> malachite_cfg = Lazy.of(()->  new ModOreConfig(ModOreConfig.FULL_RANGE, 
//                ConfigHolder.SERVER.serverMalachiteVeinSize.get(),ConfigHolder.SERVER.serverMalachiteVeinCount.get(), true, 
//                VerticalAnchor.absolute(ConfigHolder.SERVER.serverMalachiteBottomHeight.get()),
//                VerticalAnchor.absolute(ConfigHolder.SERVER.serverMalachiteMaxHeight.get())));
//    
//    public static Lazy<ModOreConfig> illumenite_cfg = Lazy.of(()->new ModOreConfig(ModOreConfig.FULL_RANGE, 
//            ConfigHolder.SERVER.serverIllumeniteVeinSize.get(), ConfigHolder.SERVER.serverIllumeniteVeinCount.get(), true, 
//            VerticalAnchor.absolute(ConfigHolder.SERVER.serverIllumeniteBottomHeight.get()),
//            VerticalAnchor.absolute(ConfigHolder.SERVER.serverIllumeniteMaxHeight.get())));

}  // end class NetherrocksConfig
