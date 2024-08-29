package mod.alexndr.netherrocks.init;

import mod.alexndr.netherrocks.Netherrocks;
import mod.alexndr.netherrocks.content.*;
import net.minecraft.world.item.*;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

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
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(Netherrocks.MODID);
    
   // ingots and nuggets, dusts and crushed ore
    public static final DeferredItem<Item> argonite_ingot = ITEMS.register("argonite_ingot",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> argonite_nugget = ITEMS.register("argonite_nugget",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> argonite_dust = ITEMS.register("argonite_dust",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> crushed_argonite_ore = ITEMS.register("crushed_argonite_ore",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> raw_argonite = ITEMS.register("raw_argonite",
            () -> new Item(new Item.Properties()));
   
    public static final DeferredItem<Item> dragonstone_gem = ITEMS.register("dragonstone_gem",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> ashstone_gem = ITEMS.register("ashstone_gem",
            () -> new Item(new Item.Properties()));
    
    public static final DeferredItem<Item> fyrite_ingot = ITEMS.register("fyrite_ingot",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> fyrite_nugget = ITEMS.register("fyrite_nugget",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> fyrite_dust = ITEMS.register("fyrite_dust",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> crushed_fyrite_ore = ITEMS.register("crushed_fyrite_ore",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> raw_fyrite = ITEMS.register("raw_fyrite",
            () -> new Item(new Item.Properties()));
    
    public static final DeferredItem<Item> illumenite_ingot = ITEMS.register("illumenite_ingot",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> illumenite_nugget = ITEMS.register("illumenite_nugget",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> illumenite_dust = ITEMS.register("illumenite_dust",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> crushed_illumenite_ore = ITEMS.register("crushed_illumenite_ore",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> raw_illumenite = ITEMS.register("raw_illumenite",
            () -> new Item(new Item.Properties()));
    
    public static final DeferredItem<Item> malachite_ingot = ITEMS.register("malachite_ingot",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> malachite_nugget = ITEMS.register("malachite_nugget",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> malachite_dust = ITEMS.register("malachite_dust",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> crushed_malachite_ore = ITEMS.register("crushed_malachite_ore",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> raw_malachite = ITEMS.register("raw_malachite",
            () -> new Item(new Item.Properties()));


    // TOOLS & WEAPONS
    // swords
    public static final DeferredItem<SwordItem> argonite_sword = ITEMS.register("argonite_sword",
            () -> new SwordItem(NetherrocksItemTiers.ARGONITE, 3, -2.4F,
                    new Item.Properties()));
    public static final DeferredItem<FyriteSwordItem> fyrite_sword = ITEMS.register("fyrite_sword",
            () -> new FyriteSwordItem(NetherrocksItemTiers.FYRITE, 3, -2.4F,
                    new Item.Properties()));
    public static final DeferredItem<IllumeniteSwordItem> illumenite_sword = ITEMS.register("illumenite_sword",
            () -> new IllumeniteSwordItem(NetherrocksItemTiers.ILLUMENITE, 3, -2.4F,
                    new Item.Properties()));
    public static final DeferredItem<MalachiteSwordItem> malachite_sword = ITEMS.register("malachite_sword",
            () -> new MalachiteSwordItem(NetherrocksItemTiers.MALACHITE, 3, -2.4F,
                    new Item.Properties()));
    public static final DeferredItem<SwordItem> ashstone_sword = ITEMS.register("ashstone_sword",
            () ->  new SwordItem(NetherrocksItemTiers.ASHSTONE, 3, -2.4F,
                    new Item.Properties()));
    public static final DeferredItem<SwordItem> dragonstone_sword = ITEMS.register("dragonstone_sword",
            () -> new SwordItem(NetherrocksItemTiers.DRAGONSTONE, 3, -2.4F,
                    new Item.Properties()));

    // pickaxes
    public static final DeferredItem<PickaxeItem> argonite_pickaxe = ITEMS.register("argonite_pickaxe",
            () -> new PickaxeItem(NetherrocksItemTiers.ARGONITE, 1, -2.8F,
                    new Item.Properties()));
    public static final DeferredItem<FyritePickaxeIteam> fyrite_pickaxe = ITEMS.register("fyrite_pickaxe",
            () -> new FyritePickaxeIteam(NetherrocksItemTiers.FYRITE, 1, -2.8F,
                    new Item.Properties()));
    public static final DeferredItem<PickaxeItem> malachite_pickaxe = ITEMS.register("malachite_pickaxe",
            () -> new PickaxeItem(NetherrocksItemTiers.MALACHITE, 1, -2.8F,
                    new Item.Properties()));
    public static final DeferredItem<PickaxeItem> ashstone_pickaxe = ITEMS.register("ashstone_pickaxe",
            () -> new PickaxeItem(NetherrocksItemTiers.ASHSTONE, 1, -2.8F,
                    new Item.Properties()));
    public static final DeferredItem<PickaxeItem> dragonstone_pickaxe = ITEMS.register("dragonstone_pickaxe",
            () -> new PickaxeItem(NetherrocksItemTiers.DRAGONSTONE, 1, -2.8F,
                    new Item.Properties()));

    // axes
   public static final DeferredItem<AxeItem> argonite_axe = ITEMS.register("argonite_axe",
            () -> new AxeItem(NetherrocksItemTiers.ARGONITE, 5.0F, -3.1F,
                    new Item.Properties()));
    public static final DeferredItem<FyriteAxeItem> fyrite_axe = ITEMS.register("fyrite_axe",
            () -> new FyriteAxeItem(NetherrocksItemTiers.FYRITE, 5.0F, -3.1F,
                    new Item.Properties()));
    public static final DeferredItem<MalachiteAxeItem> malachite_axe = ITEMS.register("malachite_axe",
            () -> new MalachiteAxeItem(NetherrocksItemTiers.MALACHITE, 5.0F, -3.1F,
                    new Item.Properties()));
    public static final DeferredItem<AxeItem> ashstone_axe = ITEMS.register("ashstone_axe",
            () -> new AxeItem(NetherrocksItemTiers.ASHSTONE, 6.0F, -3.1F,
                    new Item.Properties()));
    public static final DeferredItem<AxeItem> dragonstone_axe = ITEMS.register("dragonstone_axe",
            () -> new AxeItem(NetherrocksItemTiers.DRAGONSTONE, 1.0F, -3.0F,
                    new Item.Properties()));

    // shovels
    public static final DeferredItem<ShovelItem> argonite_shovel = ITEMS.register("argonite_shovel",
            () -> new ShovelItem(NetherrocksItemTiers.ARGONITE, 1.5F, -3.0F,
            new Item.Properties()));
    public static final DeferredItem<FyriteShovelItem> fyrite_shovel = ITEMS.register("fyrite_shovel",
            () -> new FyriteShovelItem(NetherrocksItemTiers.FYRITE, 1.5F, -3.0F,
                    new Item.Properties()));
    public static final DeferredItem<ShovelItem> malachite_shovel = ITEMS.register("malachite_shovel",
            () -> new ShovelItem(NetherrocksItemTiers.MALACHITE, 1.5F, -3.0F,
                    new Item.Properties()));
    public static final DeferredItem<ShovelItem> ashstone_shovel = ITEMS.register("ashstone_shovel",
            () -> new ShovelItem(NetherrocksItemTiers.ASHSTONE, 1.5F, -3.0F,
                    new Item.Properties()));
    public static final DeferredItem<ShovelItem> dragonstone_shovel = ITEMS.register("dragonstone_shovel",
            () -> new ShovelItem(NetherrocksItemTiers.DRAGONSTONE, 1.5F, -3.0F,
                    new Item.Properties()));

    // hoes
    public static final DeferredItem<HoeItem> argonite_hoe = ITEMS.register("argonite_hoe",
            () -> new HoeItem(NetherrocksItemTiers.ARGONITE, -1, -2.0F,
                    new Item.Properties()));
    public static final DeferredItem<HoeItem> malachite_hoe = ITEMS.register("malachite_hoe",
            () -> new HoeItem(NetherrocksItemTiers.MALACHITE, -1, -2.0F,
                    new Item.Properties()));
    public static final DeferredItem<HoeItem> ashstone_hoe = ITEMS.register("ashstone_hoe",
            () -> new HoeItem(NetherrocksItemTiers.ASHSTONE, -1, -2.0F,
                    new Item.Properties()));
    public static final DeferredItem<HoeItem> dragonstone_hoe = ITEMS.register("dragonstone_hoe",
            () -> new HoeItem(NetherrocksItemTiers.DRAGONSTONE, -1, -2.0F,
                    new Item.Properties()));

    // shears
    public static final DeferredItem<ShearsItem> argonite_shears = ITEMS.register("argonite_shears",
            () -> new ShearsItem(new Item.Properties().durability(NetherrocksItemTiers.ARGONITE.getUses())
                    ));
    public static final DeferredItem<ShearsItem> ashstone_shears = ITEMS.register("ashstone_shears",
            () -> new ShearsItem(new Item.Properties().durability(NetherrocksItemTiers.ASHSTONE.getUses())
                    ));
    public static final DeferredItem<ShearsItem> dragonstone_shears = ITEMS.register("dragonstone_shears",
            () -> new ShearsItem(new Item.Properties().durability(NetherrocksItemTiers.DRAGONSTONE.getUses())
                    ));
    public static final DeferredItem<ShearsItem> malachite_shears = ITEMS.register("malachite_shears",
            () -> new ShearsItem(new Item.Properties().durability(NetherrocksItemTiers.MALACHITE.getUses())
                    ));
    public static final DeferredItem<FyriteShearsItem> fyrite_shears = ITEMS.register("fyrite_shears",
            () -> new FyriteShearsItem(new Item.Properties().durability(NetherrocksItemTiers.FYRITE.getUses())
                    ));
    
    // ARMOR
    // dragonstone
   public static final DeferredItem<ArmorItem> dragonstone_helmet = ITEMS.register("dragonstone_helmet",
            () -> new ArmorItem(NetherrocksArmorMaterial.DRAGONSTONE, ArmorItem.Type.HELMET,
                    new Item.Properties()));
    public static final DeferredItem<ArmorItem> dragonstone_leggings = ITEMS.register("dragonstone_leggings",
            () -> new ArmorItem(NetherrocksArmorMaterial.DRAGONSTONE, ArmorItem.Type.LEGGINGS,
                    new Item.Properties()));
    public static final DeferredItem<ArmorItem> dragonstone_chestplate = ITEMS.register("dragonstone_chestplate",
            () -> new ArmorItem(NetherrocksArmorMaterial.DRAGONSTONE, ArmorItem.Type.CHESTPLATE,
                    new Item.Properties()));
    public static final DeferredItem<ArmorItem> dragonstone_boots = ITEMS.register("dragonstone_boots",
            () -> new ArmorItem(NetherrocksArmorMaterial.DRAGONSTONE, ArmorItem.Type.BOOTS,
                    new Item.Properties()));

    // fyrite
    public static final DeferredItem<FyriteArmorItem> fyrite_helmet = ITEMS.register("fyrite_helmet",
            () -> new FyriteArmorItem(NetherrocksArmorMaterial.FYRITE, ArmorItem.Type.HELMET,
                    new Item.Properties()));
    public static final DeferredItem<FyriteArmorItem> fyrite_leggings = ITEMS.register("fyrite_leggings",
            () -> new FyriteArmorItem(NetherrocksArmorMaterial.FYRITE, ArmorItem.Type.LEGGINGS,
                    new Item.Properties()));
    public static final DeferredItem<FyriteArmorItem> fyrite_chestplate = ITEMS.register("fyrite_chestplate",
            () -> new FyriteArmorItem(NetherrocksArmorMaterial.FYRITE, ArmorItem.Type.CHESTPLATE,
                    new Item.Properties()));
    public static final DeferredItem<FyriteArmorItem> fyrite_boots = ITEMS.register("fyrite_boots",
            () -> new FyriteArmorItem(NetherrocksArmorMaterial.FYRITE, ArmorItem.Type.BOOTS,
                    new Item.Properties()));

     // illumenite
    public static final DeferredItem<IllumeniteArmorItem> illumenite_helmet = ITEMS.register("illumenite_helmet",
            () -> new IllumeniteArmorItem(NetherrocksArmorMaterial.ILLUMENITE, ArmorItem.Type.HELMET,
                    new Item.Properties()));
    public static final DeferredItem<IllumeniteArmorItem> illumenite_leggings = ITEMS.register("illumenite_leggings",
            () -> new IllumeniteArmorItem(NetherrocksArmorMaterial.ILLUMENITE, ArmorItem.Type.LEGGINGS,
                    new Item.Properties()));
    public static final DeferredItem<IllumeniteArmorItem> illumenite_chestplate = ITEMS.register("illumenite_chestplate",
            () -> new IllumeniteArmorItem(NetherrocksArmorMaterial.ILLUMENITE, ArmorItem.Type.CHESTPLATE,
                    new Item.Properties()));
    public static final DeferredItem<IllumeniteArmorItem> illumenite_boots = ITEMS.register("illumenite_boots",
            () -> new IllumeniteArmorItem(NetherrocksArmorMaterial.ILLUMENITE, ArmorItem.Type.BOOTS,
                    new Item.Properties()));

    // malachite
    public static final DeferredItem<MalachiteArmorItem> malachite_helmet = ITEMS.register("malachite_helmet",
            () -> new MalachiteArmorItem(NetherrocksArmorMaterial.MALACHITE, ArmorItem.Type.HELMET,
                    new Item.Properties()));
    public static final DeferredItem<MalachiteArmorItem> malachite_leggings = ITEMS.register("malachite_leggings",
            () -> new MalachiteArmorItem(NetherrocksArmorMaterial.MALACHITE, ArmorItem.Type.LEGGINGS,
                    new Item.Properties()));
    public static final DeferredItem<MalachiteArmorItem> malachite_chestplate = ITEMS.register("malachite_chestplate",
            () -> new MalachiteArmorItem(NetherrocksArmorMaterial.MALACHITE, ArmorItem.Type.CHESTPLATE,
                    new Item.Properties()));
    public static final DeferredItem<MalachiteArmorItem> malachite_boots = ITEMS.register("malachite_boots",
            () -> new MalachiteArmorItem(NetherrocksArmorMaterial.MALACHITE, ArmorItem.Type.BOOTS,
                    new Item.Properties()));

    
} // end class ModItems
