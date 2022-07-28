package mod.alexndr.netherrocks.init;


import mod.alexndr.netherrocks.Netherrocks;
import mod.alexndr.netherrocks.content.FyritePressurePlateBlock;
import mod.alexndr.netherrocks.content.NetherBlastFurnaceBlock;
import mod.alexndr.netherrocks.content.NetherFurnaceBlock;
import mod.alexndr.netherrocks.content.NetherSmokerBlock;
import mod.alexndr.simplecorelib.api.content.MultifunctionPressurePlateBlock;
import mod.alexndr.simplecorelib.api.content.VeryAbstractFurnaceBlock;
import mod.alexndr.simplecorelib.api.helpers.LightUtils;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DoorBlock;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.IronBarsBlock;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

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
    public static final RegistryObject<DropExperienceBlock> argonite_ore = BLOCKS.register("argonite_ore",
            () -> new DropExperienceBlock(Block.Properties.of(Material.STONE).sound(SoundType.NETHER_ORE)
                    .strength( 5.0F, 30.0F).requiresCorrectToolForDrops()));
    public static final RegistryObject<DropExperienceBlock> ashstone_ore = BLOCKS.register("ashstone_ore",
            () -> new DropExperienceBlock(Block.Properties.of(Material.STONE).sound(SoundType.NETHER_ORE)
                    .strength( 5.0F, 30.0F).requiresCorrectToolForDrops()));
    public static final RegistryObject<DropExperienceBlock> dragonstone_ore = BLOCKS.register("dragonstone_ore",
            () -> new DropExperienceBlock(Block.Properties.of(Material.STONE).sound(SoundType.NETHER_ORE)
                    .strength( 5.0F, 30.0F).requiresCorrectToolForDrops()));
    public static final RegistryObject<DropExperienceBlock> fyrite_ore = BLOCKS.register("fyrite_ore",
            () -> new DropExperienceBlock(Block.Properties.of(Material.STONE).sound(SoundType.NETHER_ORE)
                    .strength( 3.0F, 30.0F).requiresCorrectToolForDrops()));
    public static final RegistryObject<DropExperienceBlock> illumenite_ore = BLOCKS.register("illumenite_ore",
            () -> new DropExperienceBlock(Block.Properties.of(Material.STONE).sound(SoundType.GLASS)
                    .strength( 1.0F, 30.0F).requiresCorrectToolForDrops()
                    .lightLevel(LightUtils.setFixedLight(15))));
    public static final RegistryObject<DropExperienceBlock> malachite_ore = BLOCKS.register("malachite_ore",
            () -> new DropExperienceBlock(Block.Properties.of(Material.STONE).sound(SoundType.NETHER_ORE)
                    .strength( 3.0F, 30.0F).requiresCorrectToolForDrops()));
    
    // evil clone of ashstone_ore for use when ghast_ore_enabled.
    public static final RegistryObject<DropExperienceBlock> ghast_ore = BLOCKS.register("ghast_ore",
            () -> new DropExperienceBlock(Block.Properties.of(Material.STONE).sound(SoundType.NETHER_ORE)
                    .strength( 5.0F, 30.0F).requiresCorrectToolForDrops()));
    
    // Metal Blocks
   public static final RegistryObject<Block> ashstone_block = BLOCKS.register("ashstone_block",
            () -> new Block(Block.Properties.of(Material.STONE)
                    .strength(7.0F, 1200.0F).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> dragonstone_block = BLOCKS.register("dragonstone_block",
            () -> new Block(Block.Properties.of(Material.STONE, MaterialColor.NETHER)
                    .strength(10.0F, 1200.0F).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> argonite_block = BLOCKS.register("argonite_block",
            () -> new Block(Block.Properties.of(Material.METAL, MaterialColor.COLOR_BLUE)
                    .strength(7.0F, 72.0F).sound(SoundType.METAL).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> raw_argonite_block = BLOCKS.register("raw_argonite_block",
            () -> new Block(Block.Properties.of(Material.METAL, MaterialColor.COLOR_BLUE)
                    .strength(7.0F, 72.0F).sound(SoundType.METAL).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> fyrite_block = BLOCKS.register("fyrite_block",
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
                    .strength(3.5F, 12.0F).sound(SoundType.NETHER_ORE)
                    .lightLevel(LightUtils.setSwitchedLight(BlockStateProperties.LIT, 13)).requiresCorrectToolForDrops()));
    public static final RegistryObject<VeryAbstractFurnaceBlock> nether_smoker = BLOCKS.register("nether_smoker",
            () -> new NetherSmokerBlock(Block.Properties.of(Material.STONE)
                    .strength(3.5F, 12.0F).sound(SoundType.NETHER_ORE)
                    .lightLevel(LightUtils.setSwitchedLight(BlockStateProperties.LIT, 13)).requiresCorrectToolForDrops()));
    public static final RegistryObject<VeryAbstractFurnaceBlock> nether_blast_furnace = BLOCKS.register("nether_blast_furnace",
            () -> new NetherBlastFurnaceBlock(Block.Properties.of(Material.STONE)
                    .strength(3.5F, 12.0F).sound(SoundType.NETHER_ORE)
                    .lightLevel(LightUtils.setSwitchedLight(BlockStateProperties.LIT, 13)).requiresCorrectToolForDrops()));
  
    // AESTHETICS STUFF
    // Blocks - bricks - Netherrocks
    public static RegistryObject<Block> argonite_bricks = BLOCKS.register("argonite_bricks",
            () -> new Block(Block.Properties.copy(argonite_block.get())));
    public static RegistryObject<Block> ashstone_bricks = BLOCKS.register("ashstone_bricks",
            () -> new Block(Block.Properties.copy(ashstone_block.get())));
    public static RegistryObject<Block> dragonstone_bricks = BLOCKS.register("dragonstone_bricks",
            () -> new Block(Block.Properties.copy(dragonstone_block.get())));
    public static RegistryObject<Block> fyrite_bricks = BLOCKS.register("fyrite_bricks",
            () -> new Block(Block.Properties.copy(fyrite_block.get())));
    public static RegistryObject<Block> illumenite_bricks = BLOCKS.register("illumenite_bricks",
            () -> new Block(Block.Properties.copy(illumenite_block.get())
                    .lightLevel(LightUtils.setFixedLight(15))));
    public static RegistryObject<Block> malachite_bricks = BLOCKS.register("malachite_bricks",
            () -> new Block(Block.Properties.copy(malachite_block.get())));

    // Blocks - slabs - netherrocks
    public static RegistryObject<SlabBlock> argonite_brick_slab = BLOCKS.register("argonite_brick_slab",
            () -> new SlabBlock(SlabBlock.Properties.copy(argonite_block.get())));
    public static RegistryObject<SlabBlock> ashstone_brick_slab = BLOCKS.register("ashstone_brick_slab",
            () -> new SlabBlock(SlabBlock.Properties.copy(ashstone_block.get())));
    public static RegistryObject<SlabBlock> dragonstone_brick_slab = BLOCKS.register("dragonstone_brick_slab",
            () -> new SlabBlock(SlabBlock.Properties.copy(dragonstone_block.get())));
    public static RegistryObject<SlabBlock> fyrite_brick_slab = BLOCKS.register("fyrite_brick_slab",
            () -> new SlabBlock(SlabBlock.Properties.copy(fyrite_block.get())));
    public static RegistryObject<SlabBlock> illumenite_brick_slab = BLOCKS.register("illumenite_brick_slab",
            () -> new SlabBlock(SlabBlock.Properties.copy(illumenite_block.get())
                    .lightLevel(LightUtils.setFixedLight(15))));
    public static RegistryObject<SlabBlock> malachite_brick_slab = BLOCKS.register("malachite_brick_slab",
            () -> new SlabBlock(SlabBlock.Properties.copy(malachite_block.get())));
    
    // Blocks - stairs - netherrocks
    public static RegistryObject<StairBlock> argonite_brick_stairs = BLOCKS.register("argonite_brick_stairs", 
            () -> new StairBlock( () -> argonite_bricks.get().defaultBlockState(), 
                                   Block.Properties.copy(argonite_bricks.get())));
    public static RegistryObject<StairBlock> ashstone_brick_stairs = BLOCKS.register("ashstone_brick_stairs", 
            () -> new StairBlock( () -> ashstone_bricks.get().defaultBlockState(), 
                                   Block.Properties.copy(ashstone_bricks.get())));
    public static RegistryObject<StairBlock> dragonstone_brick_stairs = BLOCKS.register("dragonstone_brick_stairs", 
            () -> new StairBlock( () -> dragonstone_bricks.get().defaultBlockState(), 
                                   Block.Properties.copy(dragonstone_bricks.get())));
    public static RegistryObject<StairBlock> fyrite_brick_stairs = BLOCKS.register("fyrite_brick_stairs", 
            () -> new StairBlock( () -> fyrite_bricks.get().defaultBlockState(), 
                                   Block.Properties.copy(fyrite_bricks.get())));
    public static RegistryObject<StairBlock> illumenite_brick_stairs = BLOCKS.register("illumenite_brick_stairs", 
            () -> new StairBlock( () -> illumenite_bricks.get().defaultBlockState(), 
                                   Block.Properties.copy(illumenite_bricks.get())));
    public static RegistryObject<StairBlock> malachite_brick_stairs = BLOCKS.register("malachite_brick_stairs", 
            () -> new StairBlock( () -> malachite_bricks.get().defaultBlockState(), 
                                   Block.Properties.copy(malachite_bricks.get())));
   
    // Blocks - doors - netherrocks
    public static RegistryObject<DoorBlock> argonite_door = BLOCKS.register("argonite_door",
            () -> new DoorBlock(Block.Properties.copy(argonite_bricks.get()).noOcclusion()));
    public static RegistryObject<DoorBlock> ashstone_door = BLOCKS.register("ashstone_door",
            () -> new DoorBlock(Block.Properties.copy(ashstone_bricks.get()).noOcclusion()));
    public static RegistryObject<DoorBlock> dragonstone_door = BLOCKS.register("dragonstone_door",
            () -> new DoorBlock(Block.Properties.copy(dragonstone_bricks.get()).noOcclusion()));
    public static RegistryObject<DoorBlock> fyrite_door = BLOCKS.register("fyrite_door",
            () -> new DoorBlock(Block.Properties.copy(fyrite_bricks.get()).noOcclusion()));
    public static RegistryObject<DoorBlock> illumenite_door = BLOCKS.register("illumenite_door",
            () -> new DoorBlock(Block.Properties.copy(illumenite_bricks.get()).noOcclusion()));
    public static RegistryObject<DoorBlock> malachite_door = BLOCKS.register("malachite_door",
            () -> new DoorBlock(Block.Properties.copy(malachite_bricks.get()).noOcclusion()));
   
    // Blocks - bars - netherrocks
    public static RegistryObject<IronBarsBlock> argonite_bars = BLOCKS.register("argonite_bars",
            () -> new IronBarsBlock(Block.Properties.of(Material.METAL, MaterialColor.NONE)
                    .strength(7.0F).requiresCorrectToolForDrops().sound(SoundType.METAL).noOcclusion()));
    public static RegistryObject<IronBarsBlock> ashstone_bars = BLOCKS.register("ashstone_bars",
            () -> new IronBarsBlock(Block.Properties.of(Material.STONE, MaterialColor.NONE)
                    .strength(7.0F).requiresCorrectToolForDrops().sound(SoundType.STONE).noOcclusion()));
    public static RegistryObject<IronBarsBlock> dragonstone_bars = BLOCKS.register("dragonstone_bars",
            () -> new IronBarsBlock(Block.Properties.of(Material.STONE, MaterialColor.NONE)
                    .strength(10.0F).requiresCorrectToolForDrops().sound(SoundType.STONE).noOcclusion()));
    public static RegistryObject<IronBarsBlock> fyrite_bars = BLOCKS.register("fyrite_bars",
            () -> new IronBarsBlock(Block.Properties.of(Material.METAL, MaterialColor.NONE)
                    .strength(7.0F).requiresCorrectToolForDrops().sound(SoundType.METAL).noOcclusion()));
    public static RegistryObject<IronBarsBlock> illumenite_bars = BLOCKS.register("illumenite_bars",
            () -> new IronBarsBlock(Block.Properties.of(Material.METAL, MaterialColor.NONE)
                    .strength(7.0F).requiresCorrectToolForDrops().sound(SoundType.METAL).noOcclusion()
                    .lightLevel(LightUtils.setFixedLight(14))));
    public static RegistryObject<IronBarsBlock> malachite_bars = BLOCKS.register("malachite_bars",
            () -> new IronBarsBlock(Block.Properties.of(Material.METAL, MaterialColor.NONE)
                    .strength(7.0F).requiresCorrectToolForDrops().sound(SoundType.METAL).noOcclusion()));
   
    // pressure plates
    // argonite = heavy weighted plate with a slow rebound.
    public static final RegistryObject<MultifunctionPressurePlateBlock> argonite_pressure_plate = BLOCKS.register(
            "argonite_pressure_plate", () -> new MultifunctionPressurePlateBlock(150, MultifunctionPressurePlateBlock.Sensitivity.EVERYTHING_WEIGHTED,
                    20,  Block.Properties.of(Material.METAL, MaterialColor.COLOR_BLUE).noCollission().strength(0.5F).sound(SoundType.METAL)));
    // ashstone - stone plate with a very slow rebound.
    public static final RegistryObject<MultifunctionPressurePlateBlock> ashstone_pressure_plate = BLOCKS.register(
            "ashstone_pressure_plate", () -> new MultifunctionPressurePlateBlock(15, MultifunctionPressurePlateBlock.Sensitivity.LIVING,
                    40,  Block.Properties.of(Material.STONE).noCollission().strength(0.5F).sound(SoundType.STONE)));
    // dragonstone - stone plate with very quick rebound.
    public static final RegistryObject<MultifunctionPressurePlateBlock> dragonstone_pressure_plate = BLOCKS.register(
            "dragonstone_pressure_plate", () -> new MultifunctionPressurePlateBlock(15, MultifunctionPressurePlateBlock.Sensitivity.LIVING,
                    10,  Block.Properties.of(Material.STONE, MaterialColor.NETHER).noCollission().strength(0.5F).sound(SoundType.STONE)));
    // malachite - normal light weighted plate.
    public static final RegistryObject<MultifunctionPressurePlateBlock> malachite_pressure_plate = BLOCKS.register(
            "malachite_pressure_plate", () -> new MultifunctionPressurePlateBlock(15, MultifunctionPressurePlateBlock.Sensitivity.EVERYTHING_WEIGHTED,
                    20,  Block.Properties.of(Material.METAL, MaterialColor.EMERALD).noCollission().strength(0.5F).sound(SoundType.METAL)));
    // illumenite - light weighted plate that glows.
    public static final RegistryObject<MultifunctionPressurePlateBlock> illumenite_pressure_plate = BLOCKS.register(
            "illumenite_pressure_plate", () -> new MultifunctionPressurePlateBlock(15, MultifunctionPressurePlateBlock.Sensitivity.EVERYTHING_WEIGHTED,
                    20,  Block.Properties.of(Material.GLASS, MaterialColor.COLOR_YELLOW).noCollission().strength(0.5F).sound(SoundType.GLASS)
            .lightLevel(LightUtils.setFixedLight(15))));
          
    // fyrite - light weighted plate that sets entities on fire.
    public static final RegistryObject<FyritePressurePlateBlock> fyrite_pressure_plate = BLOCKS.register("fyrite_pressure_plate", 
            () -> new FyritePressurePlateBlock());
   
}  // end class ModBlocks
