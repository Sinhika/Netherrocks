package mod.alexndr.netherrocks.init;


import mod.alexndr.netherrocks.Netherrocks;
import mod.alexndr.netherrocks.content.NetherBlastFurnaceBlock;
import mod.alexndr.netherrocks.content.NetherFurnaceBlock;
import mod.alexndr.netherrocks.content.NetherSmokerBlock;
import mod.alexndr.simplecorelib.content.VeryAbstractFurnaceBlock;
import mod.alexndr.simplecorelib.helpers.LightUtils;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.OreBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraftforge.fmllegacy.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

/**
 * Holds a list of all our {@link Block}s.
 * Suppliers that create Blocks are added to the DeferredRegister.
 * The DeferredRegister is then added to our mod event bus in our constructor.
 * When the Block Registry Event is fired by Forge and it is time for the mod to
 * register its Blocks, our Blocks are created and registered by the DeferredRegister.
 * The Block Registry Event will always be called before the Item registry is filled.
 * Note: This supports registry overrides.
 *
 * @author Sinhika, notes by Cadiboo
 */
public final class ModBlocks
{
    public static final DeferredRegister<Block> BLOCKS = 
            DeferredRegister.create(ForgeRegistries.BLOCKS, Netherrocks.MODID);
    
    // Ore Blocks
    public static final RegistryObject<OreBlock> argonite_ore = BLOCKS.register("argonite_ore",
            () -> new OreBlock(Block.Properties.of(Material.STONE)
                    .strength( 5.0F, 30.0F).requiresCorrectToolForDrops()));
    public static final RegistryObject<OreBlock> ashstone_ore = BLOCKS.register("ashstone_ore",
            () -> new OreBlock(Block.Properties.of(Material.STONE)
                    .strength( 5.0F, 30.0F).requiresCorrectToolForDrops()));
    public static final RegistryObject<OreBlock> dragonstone_ore = BLOCKS.register("dragonstone_ore",
            () -> new OreBlock(Block.Properties.of(Material.STONE)
                    .strength( 5.0F, 30.0F).requiresCorrectToolForDrops()));
    public static final RegistryObject<OreBlock> fyrite_ore = BLOCKS.register("fyrite_ore",
            () -> new OreBlock(Block.Properties.of(Material.STONE)
                    .strength( 3.0F, 30.0F).requiresCorrectToolForDrops()));
    public static final RegistryObject<OreBlock> illumenite_ore = BLOCKS.register("illumenite_ore",
            () -> new OreBlock(Block.Properties.of(Material.STONE)
                    .strength( 1.0F, 30.0F).requiresCorrectToolForDrops()
                    .lightLevel(LightUtils.setFixedLight(15))));
    public static final RegistryObject<OreBlock> malachite_ore = BLOCKS.register("malachite_ore",
            () -> new OreBlock(Block.Properties.of(Material.STONE)
                    .strength( 3.0F, 30.0F).requiresCorrectToolForDrops()));

    // Metal Blocks
   public static final RegistryObject<Block> ashstone_block = BLOCKS.register("ashstone_block",
            () -> new Block(Block.Properties.of(Material.STONE)
                    .strength(7.0F, 72.0F).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> dragonstone_block = BLOCKS.register("dragonstone_block",
            () -> new Block(Block.Properties.of(Material.STONE, MaterialColor.NETHER)
                    .strength(10.0F, 72.0F).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> argonite_block = BLOCKS.register("argonite_block",
            () -> new Block(Block.Properties.of(Material.METAL, MaterialColor.COLOR_BLUE)
                    .strength(7.0F, 72.0F).sound(SoundType.METAL).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> raw_argonite_block = BLOCKS.register("raw_argonite_block",
            () -> new Block(Block.Properties.of(Material.METAL, MaterialColor.COLOR_BLUE)
                    .strength(7.0F, 72.0F).sound(SoundType.METAL).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> fyrite_block = BLOCKS.register("fyrite_block",
            () -> new Block(Block.Properties.of(Material.METAL, MaterialColor.FIRE)
                    .strength(7.0F, 72.0F).sound(SoundType.METAL).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> dark_fyrite_block = BLOCKS.register("dark_fyrite_block",
            () -> new Block(Block.Properties.of(Material.METAL, MaterialColor.FIRE)
                    .strength(7.0F, 72.0F).sound(SoundType.METAL).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> raw_fyrite_block = BLOCKS.register("raw_fyrite_block",
            () -> new Block(Block.Properties.of(Material.METAL, MaterialColor.FIRE)
                    .strength(7.0F, 72.0F).sound(SoundType.METAL).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> illumenite_block = BLOCKS.register("illumenite_block",
            () -> new Block(Block.Properties.of(Material.GLASS, MaterialColor.COLOR_YELLOW)
                    .strength(7.0F, 72.0F).sound(SoundType.GLASS).requiresCorrectToolForDrops()
                    .lightLevel(LightUtils.setFixedLight(15))));
    public static final RegistryObject<Block> raw_illumenite_block = BLOCKS.register("raw_illumenite_block",
            () -> new Block(Block.Properties.of(Material.GLASS, MaterialColor.COLOR_YELLOW)
                    .strength(7.0F, 72.0F).sound(SoundType.GLASS).requiresCorrectToolForDrops()
                    .lightLevel(LightUtils.setFixedLight(15))));
    public static final RegistryObject<Block> malachite_block = BLOCKS.register("malachite_block",
            () -> new Block(Block.Properties.of(Material.METAL, MaterialColor.EMERALD)
                    .strength(7.0F, 72.0F).sound(SoundType.METAL).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> raw_malachite_block = BLOCKS.register("raw_malachite_block",
            () -> new Block(Block.Properties.of(Material.METAL, MaterialColor.EMERALD)
                    .strength(7.0F, 72.0F).sound(SoundType.METAL).requiresCorrectToolForDrops()));

    // Furnace
    public static final RegistryObject<VeryAbstractFurnaceBlock> nether_furnace = BLOCKS.register("nether_furnace",
            () -> new NetherFurnaceBlock(Block.Properties.of(Material.STONE)
                    .strength(3.5F, 12.0F)
                    .lightLevel(LightUtils.setSwitchedLight(BlockStateProperties.LIT, 13)).requiresCorrectToolForDrops()));
    public static final RegistryObject<VeryAbstractFurnaceBlock> nether_smoker = BLOCKS.register("nether_smoker",
            () -> new NetherSmokerBlock(Block.Properties.of(Material.STONE)
                    .strength(3.5F, 12.0F)
                    .lightLevel(LightUtils.setSwitchedLight(BlockStateProperties.LIT, 13)).requiresCorrectToolForDrops()));
    public static final RegistryObject<VeryAbstractFurnaceBlock> nether_blast_furnace = BLOCKS.register("nether_blast_furnace",
            () -> new NetherBlastFurnaceBlock(Block.Properties.of(Material.STONE)
                    .strength(3.5F, 12.0F)
                    .lightLevel(LightUtils.setSwitchedLight(BlockStateProperties.LIT, 13)).requiresCorrectToolForDrops()));
  
}  // end class ModBlocks
