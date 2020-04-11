package mod.alexndr.netherrocks.init;

import mod.alexndr.netherrocks.Netherrocks;
import mod.alexndr.netherrocks.content.FyriteArmorItem;
import mod.alexndr.netherrocks.content.FyriteAxeItem;
import mod.alexndr.netherrocks.content.FyritePickaxeIteam;
import mod.alexndr.netherrocks.content.FyriteShovelItem;
import mod.alexndr.netherrocks.content.FyriteSwordItem;
import mod.alexndr.netherrocks.content.IllumeniteArmorItem;
import mod.alexndr.netherrocks.content.IllumeniteSwordItem;
import mod.alexndr.netherrocks.content.MalachiteArmorItem;
import mod.alexndr.netherrocks.content.NetherrocksArmorMaterial;
import mod.alexndr.netherrocks.content.NetherrocksItemTier;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.AxeItem;
import net.minecraft.item.HoeItem;
import net.minecraft.item.Item;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ShovelItem;
import net.minecraft.item.SwordItem;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

/**
 * Holds a list of all our {@link Item}s.
 * Suppliers that create Items are added to the DeferredRegister.
 * The DeferredRegister is then added to our mod event bus in our constructor.
 * When the Item Registry Event is fired by Forge and it is time for the mod to
 * register its Items, our Items are created and registered by the DeferredRegister.
 * The Item Registry Event will always be called after the Block registry is filled.
 * Note: This supports registry overrides.
 *
 * @author Sinhika, notes by Cadiboo.
 */
public final class ModItems
{
    public static final DeferredRegister<Item> ITEMS = 
            new DeferredRegister<>(ForgeRegistries.ITEMS, Netherrocks.MODID);
    
   // ingots and nuggets
    public static final RegistryObject<Item> argonite_ingot = ITEMS.register("argonite_ingot",
            () -> new Item(new Item.Properties().group(ModTabGroups.MOD_ITEM_GROUP)));
    public static final RegistryObject<Item> argonite_nugget = ITEMS.register("argonite_nugget",
            () -> new Item(new Item.Properties().group(ModTabGroups.MOD_ITEM_GROUP)));
    public static final RegistryObject<Item> dragonstone_gem = ITEMS.register("dragonstone_gem",
            () -> new Item(new Item.Properties().group(ModTabGroups.MOD_ITEM_GROUP)));
    public static final RegistryObject<Item> ashstone_gem = ITEMS.register("ashstone_gem",
            () -> new Item(new Item.Properties().group(ModTabGroups.MOD_ITEM_GROUP)));
    public static final RegistryObject<Item> fyrite_ingot = ITEMS.register("fyrite_ingot",
            () -> new Item(new Item.Properties().group(ModTabGroups.MOD_ITEM_GROUP)));
    public static final RegistryObject<Item> fyrite_nugget = ITEMS.register("fyrite_nugget",
            () -> new Item(new Item.Properties().group(ModTabGroups.MOD_ITEM_GROUP)));
    public static final RegistryObject<Item> illumenite_ingot = ITEMS.register("illumenite_ingot",
            () -> new Item(new Item.Properties().group(ModTabGroups.MOD_ITEM_GROUP)));
    public static final RegistryObject<Item> illumenite_nugget = ITEMS.register("illumenite_nugget",
            () -> new Item(new Item.Properties().group(ModTabGroups.MOD_ITEM_GROUP)));
    public static final RegistryObject<Item> malachite_ingot = ITEMS.register("malachite_ingot",
            () -> new Item(new Item.Properties().group(ModTabGroups.MOD_ITEM_GROUP)));
    public static final RegistryObject<Item> malachite_nugget = ITEMS.register("malachite_nugget",
            () -> new Item(new Item.Properties().group(ModTabGroups.MOD_ITEM_GROUP)));


    // TOOLS & WEAPONS
    // swords
    // TODO will need to change classes when tools effects implemented.
    public static final RegistryObject<SwordItem> argonite_sword = ITEMS.register("argonite_sword",
            () -> new SwordItem(NetherrocksItemTier.ARGONITE, 3, -2.4F,
                    new Item.Properties().group(ModTabGroups.MOD_ITEM_GROUP)));
    public static final RegistryObject<FyriteSwordItem> fyrite_sword = ITEMS.register("fyrite_sword",
            () -> new FyriteSwordItem(NetherrocksItemTier.FYRITE, 3, -2.4F,
                    new Item.Properties().group(ModTabGroups.MOD_ITEM_GROUP)));
    public static final RegistryObject<IllumeniteSwordItem> illumenite_sword = ITEMS.register("illumenite_sword",
            () -> new IllumeniteSwordItem(NetherrocksItemTier.ILLUMENITE, 3, -2.4F,
                    new Item.Properties().group(ModTabGroups.MOD_ITEM_GROUP)));
    public static final RegistryObject<SwordItem> malachite_sword = ITEMS.register("malachite_sword",
            () -> new SwordItem(NetherrocksItemTier.MALACHITE, 3, -2.4F,
                    new Item.Properties().group(ModTabGroups.MOD_ITEM_GROUP)));
    public static final RegistryObject<SwordItem> ashstone_sword = ITEMS.register("ashstone_sword",
            () ->  new SwordItem(NetherrocksItemTier.ASHSTONE, 3, -2.4F,
                    new Item.Properties().group(ModTabGroups.MOD_ITEM_GROUP)));
    public static final RegistryObject<SwordItem> dragonstone_sword = ITEMS.register("dragonstone_sword",
            () -> new SwordItem(NetherrocksItemTier.DRAGONSTONE, 3, -2.4F,
                    new Item.Properties().group(ModTabGroups.MOD_ITEM_GROUP)));

    // pickaxes
    // TODO will need to change classes when tools effects implemented.
    public static final RegistryObject<PickaxeItem> argonite_pickaxe = ITEMS.register("argonite_pickaxe",
            () -> new PickaxeItem(NetherrocksItemTier.ARGONITE, 1, -2.8F,
                    new Item.Properties().group(ModTabGroups.MOD_ITEM_GROUP)));
    public static final RegistryObject<FyritePickaxeIteam> fyrite_pickaxe = ITEMS.register("fyrite_pickaxe",
            () -> new FyritePickaxeIteam(NetherrocksItemTier.FYRITE, 1, -2.8F,
                    new Item.Properties().group(ModTabGroups.MOD_ITEM_GROUP)));
    public static final RegistryObject<PickaxeItem> malachite_pickaxe = ITEMS.register("malachite_pickaxe",
            () -> new PickaxeItem(NetherrocksItemTier.MALACHITE, 1, -2.8F,
                    new Item.Properties().group(ModTabGroups.MOD_ITEM_GROUP)));
    public static final RegistryObject<PickaxeItem> ashstone_pickaxe = ITEMS.register("ashstone_pickaxe",
            () -> new PickaxeItem(NetherrocksItemTier.ASHSTONE, 1, -2.8F,
                    new Item.Properties().group(ModTabGroups.MOD_ITEM_GROUP)));
    public static final RegistryObject<PickaxeItem> dragonstone_pickaxe = ITEMS.register("dragonstone_pickaxe",
            () -> new PickaxeItem(NetherrocksItemTier.DRAGONSTONE, 1, -2.8F,
                    new Item.Properties().group(ModTabGroups.MOD_ITEM_GROUP)));

    // axes
    // TODO will need to change classes when tools effects implemented.
   public static final RegistryObject<AxeItem> argonite_axe = ITEMS.register("argonite_axe",
            () -> new AxeItem(NetherrocksItemTier.ARGONITE, 7.0F, -3.1F,
                    new Item.Properties().group(ModTabGroups.MOD_ITEM_GROUP)));
    public static final RegistryObject<FyriteAxeItem> fyrite_axe = ITEMS.register("fyrite_axe",
            () -> new FyriteAxeItem(NetherrocksItemTier.FYRITE, 7.0F, -3.1F,
                    new Item.Properties().group(ModTabGroups.MOD_ITEM_GROUP)));
    public static final RegistryObject<AxeItem> malachite_axe = ITEMS.register("malachite_axe",
            () -> new AxeItem(NetherrocksItemTier.MALACHITE, 7.0F, -3.1F,
                    new Item.Properties().group(ModTabGroups.MOD_ITEM_GROUP)));
    public static final RegistryObject<AxeItem> ashstone_axe = ITEMS.register("ashstone_axe",
            () -> new AxeItem(NetherrocksItemTier.ASHSTONE, 7.0F, -3.1F,
                    new Item.Properties().group(ModTabGroups.MOD_ITEM_GROUP)));
    public static final RegistryObject<AxeItem> dragonstone_axe = ITEMS.register("dragonstone_axe",
            () -> new AxeItem(NetherrocksItemTier.DRAGONSTONE, 7.0F, -3.1F,
                    new Item.Properties().group(ModTabGroups.MOD_ITEM_GROUP)));

    // shovels
    // TODO will need to change classes when tools effects implemented.
    public static final RegistryObject<ShovelItem> argonite_shovel = ITEMS.register("argonite_shovel",
            () -> new ShovelItem(NetherrocksItemTier.ARGONITE, 1.5F, -3.0F,
            new Item.Properties().group(ModTabGroups.MOD_ITEM_GROUP)));
    public static final RegistryObject<FyriteShovelItem> fyrite_shovel = ITEMS.register("fyrite_shovel",
            () -> new FyriteShovelItem(NetherrocksItemTier.FYRITE, 1.5F, -3.0F,
                    new Item.Properties().group(ModTabGroups.MOD_ITEM_GROUP)));
    public static final RegistryObject<ShovelItem> malachite_shovel = ITEMS.register("malachite_shovel",
            () -> new ShovelItem(NetherrocksItemTier.MALACHITE, 1.5F, -3.0F,
                    new Item.Properties().group(ModTabGroups.MOD_ITEM_GROUP)));
    public static final RegistryObject<ShovelItem> ashstone_shovel = ITEMS.register("ashstone_shovel",
            () -> new ShovelItem(NetherrocksItemTier.ASHSTONE, 1.5F, -3.0F,
                    new Item.Properties().group(ModTabGroups.MOD_ITEM_GROUP)));
    public static final RegistryObject<ShovelItem> dragonstone_shovel = ITEMS.register("dragonstone_shovel",
            () -> new ShovelItem(NetherrocksItemTier.DRAGONSTONE, 1.5F, -3.0F,
                    new Item.Properties().group(ModTabGroups.MOD_ITEM_GROUP)));

    // hoes
    // TODO will need to change classes when tools effects implemented.
    public static final RegistryObject<HoeItem> argonite_hoe = ITEMS.register("argonite_hoe",
            () -> new HoeItem(NetherrocksItemTier.ARGONITE,-2.0F,
                    new Item.Properties().group(ModTabGroups.MOD_ITEM_GROUP)));
    public static final RegistryObject<HoeItem> malachite_hoe = ITEMS.register("malachite_hoe",
            () -> new HoeItem(NetherrocksItemTier.MALACHITE, -2.0F,
                    new Item.Properties().group(ModTabGroups.MOD_ITEM_GROUP)));
    public static final RegistryObject<HoeItem> ashstone_hoe = ITEMS.register("ashstone_hoe",
            () -> new HoeItem(NetherrocksItemTier.ASHSTONE, -2.0F,
                    new Item.Properties().group(ModTabGroups.MOD_ITEM_GROUP)));
    public static final RegistryObject<HoeItem> dragonstone_hoe = ITEMS.register("dragonstone_hoe",
            () -> new HoeItem(NetherrocksItemTier.DRAGONSTONE, -2.0F,
                    new Item.Properties().group(ModTabGroups.MOD_ITEM_GROUP)));

    // ARMOR
    // dragonstone
   public static final RegistryObject<ArmorItem> dragonstone_helmet = ITEMS.register("dragonstone_helmet",
            () -> new ArmorItem(NetherrocksArmorMaterial.DRAGONSTONE, EquipmentSlotType.HEAD,
                    new Item.Properties().group(ModTabGroups.MOD_ITEM_GROUP)));
    public static final RegistryObject<ArmorItem> dragonstone_leggings = ITEMS.register("dragonstone_leggings",
            () -> new ArmorItem(NetherrocksArmorMaterial.DRAGONSTONE, EquipmentSlotType.LEGS,
                    new Item.Properties().group(ModTabGroups.MOD_ITEM_GROUP)));
    public static final RegistryObject<ArmorItem> dragonstone_chestplate = ITEMS.register("dragonstone_chestplate",
            () -> new ArmorItem(NetherrocksArmorMaterial.DRAGONSTONE, EquipmentSlotType.CHEST,
                    new Item.Properties().group(ModTabGroups.MOD_ITEM_GROUP)));
    public static final RegistryObject<ArmorItem> dragonstone_boots = ITEMS.register("dragonstone_boots",
            () -> new ArmorItem(NetherrocksArmorMaterial.DRAGONSTONE, EquipmentSlotType.FEET,
                    new Item.Properties().group(ModTabGroups.MOD_ITEM_GROUP)));

    // fyrite
    public static final RegistryObject<FyriteArmorItem> fyrite_helmet = ITEMS.register("fyrite_helmet",
            () -> new FyriteArmorItem(NetherrocksArmorMaterial.FYRITE, EquipmentSlotType.HEAD,
                    new Item.Properties().group(ModTabGroups.MOD_ITEM_GROUP)));
    public static final RegistryObject<FyriteArmorItem> fyrite_leggings = ITEMS.register("fyrite_leggings",
            () -> new FyriteArmorItem(NetherrocksArmorMaterial.FYRITE, EquipmentSlotType.LEGS,
                    new Item.Properties().group(ModTabGroups.MOD_ITEM_GROUP)));
    public static final RegistryObject<FyriteArmorItem> fyrite_chestplate = ITEMS.register("fyrite_chestplate",
            () -> new FyriteArmorItem(NetherrocksArmorMaterial.FYRITE, EquipmentSlotType.CHEST,
                    new Item.Properties().group(ModTabGroups.MOD_ITEM_GROUP)));
    public static final RegistryObject<FyriteArmorItem> fyrite_boots = ITEMS.register("fyrite_boots",
            () -> new FyriteArmorItem(NetherrocksArmorMaterial.FYRITE, EquipmentSlotType.FEET,
                    new Item.Properties().group(ModTabGroups.MOD_ITEM_GROUP)));

     // illumenite
    public static final RegistryObject<IllumeniteArmorItem> illumenite_helmet = ITEMS.register("illumenite_helmet",
            () -> new IllumeniteArmorItem(NetherrocksArmorMaterial.ILLUMENITE, EquipmentSlotType.HEAD,
                    new Item.Properties().group(ModTabGroups.MOD_ITEM_GROUP)));
    public static final RegistryObject<IllumeniteArmorItem> illumenite_leggings = ITEMS.register("illumenite_leggings",
            () -> new IllumeniteArmorItem(NetherrocksArmorMaterial.ILLUMENITE, EquipmentSlotType.LEGS,
                    new Item.Properties().group(ModTabGroups.MOD_ITEM_GROUP)));
    public static final RegistryObject<IllumeniteArmorItem> illumenite_chestplate = ITEMS.register("illumenite_chestplate",
            () -> new IllumeniteArmorItem(NetherrocksArmorMaterial.ILLUMENITE, EquipmentSlotType.CHEST,
                    new Item.Properties().group(ModTabGroups.MOD_ITEM_GROUP)));
    public static final RegistryObject<IllumeniteArmorItem> illumenite_boots = ITEMS.register("illumenite_boots",
            () -> new IllumeniteArmorItem(NetherrocksArmorMaterial.ILLUMENITE, EquipmentSlotType.FEET,
                    new Item.Properties().group(ModTabGroups.MOD_ITEM_GROUP)));

    // malachite
    public static final RegistryObject<MalachiteArmorItem> malachite_helmet = ITEMS.register("malachite_helmet",
            () -> new MalachiteArmorItem(NetherrocksArmorMaterial.MALACHITE, EquipmentSlotType.HEAD,
                    new Item.Properties().group(ModTabGroups.MOD_ITEM_GROUP)));
    public static final RegistryObject<MalachiteArmorItem> malachite_leggings = ITEMS.register("malachite_leggings",
            () -> new MalachiteArmorItem(NetherrocksArmorMaterial.MALACHITE, EquipmentSlotType.LEGS,
                    new Item.Properties().group(ModTabGroups.MOD_ITEM_GROUP)));
    public static final RegistryObject<MalachiteArmorItem> malachite_chestplate = ITEMS.register("malachite_chestplate",
            () -> new MalachiteArmorItem(NetherrocksArmorMaterial.MALACHITE, EquipmentSlotType.CHEST,
                    new Item.Properties().group(ModTabGroups.MOD_ITEM_GROUP)));
    public static final RegistryObject<MalachiteArmorItem> malachite_boots = ITEMS.register("malachite_boots",
            () -> new MalachiteArmorItem(NetherrocksArmorMaterial.MALACHITE, EquipmentSlotType.FEET,
                    new Item.Properties().group(ModTabGroups.MOD_ITEM_GROUP)));

} // end class ModItems
