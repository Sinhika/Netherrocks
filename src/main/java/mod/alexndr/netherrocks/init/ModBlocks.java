package mod.alexndr.netherrocks.init;


import mod.alexndr.netherrocks.Netherrocks;
import mod.alexndr.netherrocks.content.block.FyritePressurePlateBlock;
import mod.alexndr.netherrocks.content.block.NetherBlastFurnaceBlock;
import mod.alexndr.netherrocks.content.block.NetherFurnaceBlock;
import mod.alexndr.netherrocks.content.block.NetherSmokerBlock;
import mod.alexndr.simplecorelib.api.content.MultifunctionPressurePlateBlock;
import mod.alexndr.simplecorelib.api.helpers.LightUtils;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

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
    public static final DeferredRegister.Blocks BLOCKS =
            DeferredRegister.createBlocks(Netherrocks.MODID);
    
    // Ore Blocks
    public static final DeferredBlock<DropExperienceBlock> argonite_ore = BLOCKS.register("argonite_ore",
            () -> new DropExperienceBlock(ConstantInt.of(0), BlockBehaviour.Properties.of().mapColor(MapColor.STONE)
                    .sound(SoundType.NETHER_ORE).strength( 5.0F, 30.0F).requiresCorrectToolForDrops()));

    public static final DeferredBlock<DropExperienceBlock> ashstone_ore = BLOCKS.register("ashstone_ore",
            () -> new DropExperienceBlock(ConstantInt.of(1), BlockBehaviour.Properties.of().mapColor(MapColor.STONE)
                    .sound(SoundType.NETHER_ORE)
                    .strength( 5.0F, 30.0F).requiresCorrectToolForDrops()));

    public static final DeferredBlock<DropExperienceBlock> dragonstone_ore = BLOCKS.register("dragonstone_ore",
            () -> new DropExperienceBlock(ConstantInt.of(1), BlockBehaviour.Properties.of().mapColor(MapColor.STONE).sound(SoundType.NETHER_ORE)
                    .strength( 5.0F, 30.0F).requiresCorrectToolForDrops()));

    public static final DeferredBlock<DropExperienceBlock> fyrite_ore = BLOCKS.register("fyrite_ore",
            () -> new DropExperienceBlock(ConstantInt.of(0), BlockBehaviour.Properties.of().mapColor(MapColor.STONE).sound(SoundType.NETHER_ORE)
                    .strength( 3.0F, 30.0F).requiresCorrectToolForDrops()));

    public static final DeferredBlock<DropExperienceBlock> illumenite_ore = BLOCKS.register("illumenite_ore",
            () -> new DropExperienceBlock(ConstantInt.of(0), BlockBehaviour.Properties.of().mapColor(MapColor.STONE).sound(SoundType.GLASS)
                    .strength( 1.0F, 30.0F).requiresCorrectToolForDrops()
                    .lightLevel(LightUtils.setFixedLight(15))));

    public static final DeferredBlock<DropExperienceBlock> malachite_ore = BLOCKS.register("malachite_ore",
            () -> new DropExperienceBlock(ConstantInt.of(0), BlockBehaviour.Properties.of().mapColor(MapColor.STONE).sound(SoundType.NETHER_ORE)
                    .strength( 3.0F, 30.0F).requiresCorrectToolForDrops()));
    
    // evil clone of ashstone_ore for use when ghast_ore_enabled.
//    public static final DeferredBlock<DropExperienceBlock> ghast_ore = BLOCKS.register("ghast_ore",
//            () -> new DropExperienceBlock(BlockBehaviour.Properties.of().mapColor(MapColor.STONE).sound(SoundType.NETHER_ORE)
//                    .strength( 5.0F, 30.0F).requiresCorrectToolForDrops()));
    
    // Metal Blocks
   public static final DeferredBlock<Block> ashstone_block = BLOCKS.register("ashstone_block",
            () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.STONE)
                    .strength(7.0F, 1200.0F).requiresCorrectToolForDrops()));
    public static final DeferredBlock<Block> dragonstone_block = BLOCKS.register("dragonstone_block",
            () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.NETHER)
                    .strength(10.0F, 1200.0F).requiresCorrectToolForDrops()));
    public static final DeferredBlock<Block> argonite_block = BLOCKS.register("argonite_block",
            () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BLUE)
                    .strength(7.0F, 72.0F).sound(SoundType.METAL).requiresCorrectToolForDrops()));
    public static final DeferredBlock<Block> raw_argonite_block = BLOCKS.register("raw_argonite_block",
            () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BLUE)
                    .strength(7.0F, 72.0F).sound(SoundType.METAL).requiresCorrectToolForDrops()));
    public static final DeferredBlock<Block> fyrite_block = BLOCKS.register("fyrite_block",
            () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.FIRE)
                    .strength(7.0F, 72.0F).sound(SoundType.METAL).requiresCorrectToolForDrops()));
    public static final DeferredBlock<Block> raw_fyrite_block = BLOCKS.register("raw_fyrite_block",
            () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.FIRE)
                    .strength(7.0F, 72.0F).sound(SoundType.METAL).requiresCorrectToolForDrops()));
    public static final DeferredBlock<Block> illumenite_block = BLOCKS.register("illumenite_block",
            () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_YELLOW)
                    .strength(7.0F, 72.0F).sound(SoundType.GLASS).requiresCorrectToolForDrops()
                    .lightLevel(LightUtils.setFixedLight(15))));
    public static final DeferredBlock<Block> raw_illumenite_block = BLOCKS.register("raw_illumenite_block",
            () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_YELLOW)
                    .strength(7.0F, 72.0F).sound(SoundType.GLASS).requiresCorrectToolForDrops()
                    .lightLevel(LightUtils.setFixedLight(15))));
    public static final DeferredBlock<Block> malachite_block = BLOCKS.register("malachite_block",
            () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.EMERALD)
                    .strength(7.0F, 72.0F).sound(SoundType.METAL).requiresCorrectToolForDrops()));
    public static final DeferredBlock<Block> raw_malachite_block = BLOCKS.register("raw_malachite_block",
            () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.EMERALD)
                    .strength(7.0F, 72.0F).sound(SoundType.METAL).requiresCorrectToolForDrops()));

    // Furnace
    public static final DeferredBlock<NetherFurnaceBlock> nether_furnace = BLOCKS.register("nether_furnace",
            () -> new NetherFurnaceBlock(BlockBehaviour.Properties.of().mapColor(MapColor.STONE)
                    .strength(3.5F, 12.0F).sound(SoundType.NETHER_ORE)
                    .lightLevel(LightUtils.setSwitchedLight(BlockStateProperties.LIT, 13)).requiresCorrectToolForDrops()));

    public static final DeferredBlock<NetherSmokerBlock> nether_smoker = BLOCKS.register("nether_smoker",
            () -> new NetherSmokerBlock(BlockBehaviour.Properties.of().mapColor(MapColor.STONE)
                    .strength(3.5F, 12.0F).sound(SoundType.NETHER_ORE)
                    .lightLevel(LightUtils.setSwitchedLight(BlockStateProperties.LIT, 13)).requiresCorrectToolForDrops()));

    public static final DeferredBlock<NetherBlastFurnaceBlock> nether_blast_furnace = BLOCKS.register("nether_blast_furnace",
            () -> new NetherBlastFurnaceBlock(BlockBehaviour.Properties.of().mapColor(MapColor.STONE)
                    .strength(3.5F, 12.0F).sound(SoundType.NETHER_ORE)
                    .lightLevel(LightUtils.setSwitchedLight(BlockStateProperties.LIT, 13)).requiresCorrectToolForDrops()));
  
    // AESTHETICS STUFF
    // Blocks - bricks - Netherrocks
    public static DeferredBlock<Block> argonite_bricks = BLOCKS.register("argonite_bricks",
            () -> new Block(Block.Properties.ofFullCopy(argonite_block.get())));
    public static DeferredBlock<Block> ashstone_bricks = BLOCKS.register("ashstone_bricks",
            () -> new Block(Block.Properties.ofFullCopy(ashstone_block.get())));
    public static DeferredBlock<Block> dragonstone_bricks = BLOCKS.register("dragonstone_bricks",
            () -> new Block(Block.Properties.ofFullCopy(dragonstone_block.get())));
    public static DeferredBlock<Block> fyrite_bricks = BLOCKS.register("fyrite_bricks",
            () -> new Block(Block.Properties.ofFullCopy(fyrite_block.get())));
    public static DeferredBlock<Block> illumenite_bricks = BLOCKS.register("illumenite_bricks",
            () -> new Block(Block.Properties.ofFullCopy(illumenite_block.get())
                    .lightLevel(LightUtils.setFixedLight(15))));
    public static DeferredBlock<Block> malachite_bricks = BLOCKS.register("malachite_bricks",
            () -> new Block(Block.Properties.ofFullCopy(malachite_block.get())));

    // Blocks - slabs - netherrocks
    public static DeferredBlock<SlabBlock> argonite_brick_slab = BLOCKS.register("argonite_brick_slab",
            () -> new SlabBlock(SlabBlock.Properties.ofFullCopy(argonite_block.get())));
    public static DeferredBlock<SlabBlock> ashstone_brick_slab = BLOCKS.register("ashstone_brick_slab",
            () -> new SlabBlock(SlabBlock.Properties.ofFullCopy(ashstone_block.get())));
    public static DeferredBlock<SlabBlock> dragonstone_brick_slab = BLOCKS.register("dragonstone_brick_slab",
            () -> new SlabBlock(SlabBlock.Properties.ofFullCopy(dragonstone_block.get())));
    public static DeferredBlock<SlabBlock> fyrite_brick_slab = BLOCKS.register("fyrite_brick_slab",
            () -> new SlabBlock(SlabBlock.Properties.ofFullCopy(fyrite_block.get())));
    public static DeferredBlock<SlabBlock> illumenite_brick_slab = BLOCKS.register("illumenite_brick_slab",
            () -> new SlabBlock(SlabBlock.Properties.ofFullCopy(illumenite_block.get())
                    .lightLevel(LightUtils.setFixedLight(15))));
    public static DeferredBlock<SlabBlock> malachite_brick_slab = BLOCKS.register("malachite_brick_slab",
            () -> new SlabBlock(SlabBlock.Properties.ofFullCopy(malachite_block.get())));
    
    // Blocks - stairs - netherrocks
    public static DeferredBlock<StairBlock> argonite_brick_stairs = BLOCKS.register("argonite_brick_stairs", 
            () -> new StairBlock( argonite_bricks.get().defaultBlockState(),
                                   Block.Properties.ofFullCopy(argonite_bricks.get())));
    public static DeferredBlock<StairBlock> ashstone_brick_stairs = BLOCKS.register("ashstone_brick_stairs", 
            () -> new StairBlock( ashstone_bricks.get().defaultBlockState(),
                                   Block.Properties.ofFullCopy(ashstone_bricks.get())));
    public static DeferredBlock<StairBlock> dragonstone_brick_stairs = BLOCKS.register("dragonstone_brick_stairs", 
            () -> new StairBlock( dragonstone_bricks.get().defaultBlockState(),
                                   Block.Properties.ofFullCopy(dragonstone_bricks.get())));
    public static DeferredBlock<StairBlock> fyrite_brick_stairs = BLOCKS.register("fyrite_brick_stairs", 
            () -> new StairBlock( fyrite_bricks.get().defaultBlockState(),
                                   Block.Properties.ofFullCopy(fyrite_bricks.get())));
    public static DeferredBlock<StairBlock> illumenite_brick_stairs = BLOCKS.register("illumenite_brick_stairs", 
            () -> new StairBlock( illumenite_bricks.get().defaultBlockState(),
                                   Block.Properties.ofFullCopy(illumenite_bricks.get())));
    public static DeferredBlock<StairBlock> malachite_brick_stairs = BLOCKS.register("malachite_brick_stairs", 
            () -> new StairBlock( malachite_bricks.get().defaultBlockState(),
                                   Block.Properties.ofFullCopy(malachite_bricks.get())));
   
    // Blocks - doors - netherrocks
    public static DeferredBlock<DoorBlock> argonite_door = BLOCKS.register("argonite_door",
            () -> new DoorBlock(BlockSetType.IRON, BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BLUE)
                    .strength(7.0F, 72.0F)
            		.requiresCorrectToolForDrops().noOcclusion().pushReaction(PushReaction.DESTROY)));
    
    public static DeferredBlock<DoorBlock> ashstone_door = BLOCKS.register("ashstone_door",
            () -> new DoorBlock(BlockSetType.STONE, BlockBehaviour.Properties.of().mapColor(MapColor.STONE).strength(7.0F, 1200.0F)
            		.requiresCorrectToolForDrops().noOcclusion().pushReaction(PushReaction.DESTROY)));
            
    public static DeferredBlock<DoorBlock> dragonstone_door = BLOCKS.register("dragonstone_door",
            () -> new DoorBlock(BlockSetType.STONE, BlockBehaviour.Properties.of().mapColor(MapColor.NETHER)
                    .strength(10.0F, 1200.0F)
            		.requiresCorrectToolForDrops().noOcclusion().pushReaction(PushReaction.DESTROY)));
            
    public static DeferredBlock<DoorBlock> fyrite_door = BLOCKS.register("fyrite_door",
            () -> new DoorBlock(ModBlockSetTypes.FYRITE, BlockBehaviour.Properties.of().mapColor(MapColor.FIRE)
                    .strength(7.0F, 72.0F)
            		.requiresCorrectToolForDrops().noOcclusion().pushReaction(PushReaction.DESTROY)
					));
    
    public static DeferredBlock<DoorBlock> illumenite_door = BLOCKS.register("illumenite_door",
            () -> new DoorBlock(ModBlockSetTypes.ILLUMENITE, BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_YELLOW)
                    .strength(7.0F, 72.0F).lightLevel(LightUtils.setFixedLight(15))
            		.requiresCorrectToolForDrops().noOcclusion().pushReaction(PushReaction.DESTROY)
            		));
    
    public static DeferredBlock<DoorBlock> malachite_door = BLOCKS.register("malachite_door",
            () -> new DoorBlock(BlockSetType.COPPER, BlockBehaviour.Properties.of().mapColor(MapColor.EMERALD)
                    .strength(7.0F, 72.0F)
            		.requiresCorrectToolForDrops().noOcclusion().pushReaction(PushReaction.DESTROY)
					));
   
    // Blocks - bars - netherrocks
    public static DeferredBlock<IronBarsBlock> argonite_bars = BLOCKS.register("argonite_bars",
            () -> new IronBarsBlock(BlockBehaviour.Properties.of().mapColor(MapColor.NONE)
                    .strength(7.0F).requiresCorrectToolForDrops().sound(SoundType.METAL).noOcclusion()));
    public static DeferredBlock<IronBarsBlock> ashstone_bars = BLOCKS.register("ashstone_bars",
            () -> new IronBarsBlock(BlockBehaviour.Properties.of().mapColor(MapColor.NONE)
                    .strength(7.0F).requiresCorrectToolForDrops().sound(SoundType.STONE).noOcclusion()));
    public static DeferredBlock<IronBarsBlock> dragonstone_bars = BLOCKS.register("dragonstone_bars",
            () -> new IronBarsBlock(BlockBehaviour.Properties.of().mapColor(MapColor.NONE)
                    .strength(10.0F).requiresCorrectToolForDrops().sound(SoundType.STONE).noOcclusion()));
    public static DeferredBlock<IronBarsBlock> fyrite_bars = BLOCKS.register("fyrite_bars",
            () -> new IronBarsBlock(BlockBehaviour.Properties.of().mapColor(MapColor.NONE)
                    .strength(7.0F).requiresCorrectToolForDrops().sound(SoundType.METAL).noOcclusion()));
    public static DeferredBlock<IronBarsBlock> illumenite_bars = BLOCKS.register("illumenite_bars",
            () -> new IronBarsBlock(BlockBehaviour.Properties.of().mapColor(MapColor.NONE)
                    .strength(7.0F).requiresCorrectToolForDrops().sound(SoundType.METAL).noOcclusion()
                    .lightLevel(LightUtils.setFixedLight(14))));
    public static DeferredBlock<IronBarsBlock> malachite_bars = BLOCKS.register("malachite_bars",
            () -> new IronBarsBlock(BlockBehaviour.Properties.of().mapColor(MapColor.NONE)
                    .strength(7.0F).requiresCorrectToolForDrops().sound(SoundType.METAL).noOcclusion()));
   
    // pressure plates
    // argonite = heavy weighted plate with a slow rebound.
    public static final DeferredBlock<MultifunctionPressurePlateBlock> argonite_pressure_plate = BLOCKS.register(
            "argonite_pressure_plate", () -> new MultifunctionPressurePlateBlock(150,
                    MultifunctionPressurePlateBlock.Sensitivity.EVERYTHING_WEIGHTED,
                    20,  BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BLUE).noCollission().strength(0.5F)
                    .sound(SoundType.METAL), BlockSetType.GOLD));
    
    // ashstone - stone plate with a very slow rebound.
    public static final DeferredBlock<MultifunctionPressurePlateBlock> ashstone_pressure_plate = BLOCKS.register(
            "ashstone_pressure_plate", () -> new MultifunctionPressurePlateBlock(15,
                    MultifunctionPressurePlateBlock.Sensitivity.LIVING,
                    40,  BlockBehaviour.Properties.of().mapColor(MapColor.STONE).noCollission().strength(0.5F)
                    .sound(SoundType.STONE), BlockSetType.STONE));
    
    // dragonstone - stone plate with very quick rebound.
    public static final DeferredBlock<MultifunctionPressurePlateBlock> dragonstone_pressure_plate = BLOCKS.register(
            "dragonstone_pressure_plate", () -> new MultifunctionPressurePlateBlock(15,
                    MultifunctionPressurePlateBlock.Sensitivity.LIVING,
                    10,  BlockBehaviour.Properties.of().mapColor(MapColor.NETHER).noCollission().strength(0.5F)
                    .sound(SoundType.STONE), BlockSetType.STONE));
    
    // malachite - normal light weighted plate.
    public static final DeferredBlock<MultifunctionPressurePlateBlock> malachite_pressure_plate = BLOCKS.register(
            "malachite_pressure_plate", () -> new MultifunctionPressurePlateBlock(15,
                    MultifunctionPressurePlateBlock.Sensitivity.EVERYTHING_WEIGHTED,
                    20,  BlockBehaviour.Properties.of().mapColor(MapColor.EMERALD).noCollission().strength(0.5F)
                    .sound(SoundType.METAL), BlockSetType.IRON));
    
    // illumenite - light weighted plate that glows.
    public static final DeferredBlock<MultifunctionPressurePlateBlock> illumenite_pressure_plate = BLOCKS.register(
            "illumenite_pressure_plate", () -> new MultifunctionPressurePlateBlock(15,
                    MultifunctionPressurePlateBlock.Sensitivity.EVERYTHING_WEIGHTED,
                    20,  BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_YELLOW).noCollission().strength(0.5F)
                    .sound(SoundType.GLASS).lightLevel(LightUtils.setFixedLight(15)), ModBlockSetTypes.ILLUMENITE));
          
    // fyrite - light weighted plate that sets entities on fire.
    public static final DeferredBlock<FyritePressurePlateBlock> fyrite_pressure_plate = BLOCKS.register("fyrite_pressure_plate", 
            () -> new FyritePressurePlateBlock());
   
}  // end class ModBlocks
