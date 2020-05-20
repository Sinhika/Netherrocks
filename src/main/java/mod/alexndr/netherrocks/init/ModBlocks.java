package mod.alexndr.netherrocks.init;

import mod.alexndr.netherrocks.Netherrocks;
import mod.alexndr.netherrocks.content.NetherBlastFurnaceBlock;
import mod.alexndr.netherrocks.content.NetherFurnaceBlock;
import mod.alexndr.netherrocks.content.NetherSmokerBlock;
import mod.alexndr.netherrocks.content.SimpleMetalBlock;
import net.minecraft.block.Block;
import net.minecraft.block.OreBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.fml.RegistryObject;
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
            new DeferredRegister<>(ForgeRegistries.BLOCKS, Netherrocks.MODID);
    
    // Ore Blocks
    public static final RegistryObject<OreBlock> argonite_ore = BLOCKS.register("argonite_ore",
            () -> new OreBlock(Block.Properties.create(Material.ROCK)
                    .hardnessAndResistance( 5.0F, 30.0F)
                    .harvestTool(ToolType.PICKAXE).harvestLevel(3)));
    public static final RegistryObject<OreBlock> ashstone_ore = BLOCKS.register("ashstone_ore",
            () -> new OreBlock(Block.Properties.create(Material.ROCK)
                    .hardnessAndResistance( 5.0F, 30.0F)
                    .harvestTool(ToolType.PICKAXE).harvestLevel(3)));
    public static final RegistryObject<OreBlock> dragonstone_ore = BLOCKS.register("dragonstone_ore",
            () -> new OreBlock(Block.Properties.create(Material.ROCK)
                    .hardnessAndResistance( 5.0F, 30.0F)
                    .harvestTool(ToolType.PICKAXE).harvestLevel(3)));
    public static final RegistryObject<OreBlock> fyrite_ore = BLOCKS.register("fyrite_ore",
            () -> new OreBlock(Block.Properties.create(Material.ROCK)
                    .hardnessAndResistance( 3.0F, 30.0F)
                    .harvestTool(ToolType.PICKAXE).harvestLevel(2)));
    public static final RegistryObject<OreBlock> illumenite_ore = BLOCKS.register("illumenite_ore",
            () -> new OreBlock(Block.Properties.create(Material.ROCK)
                    .hardnessAndResistance( 1.0F, 30.0F)
                    .harvestTool(ToolType.PICKAXE).harvestLevel(2)
                    .lightValue(15)));
    public static final RegistryObject<OreBlock> malachite_ore = BLOCKS.register("malachite_ore",
            () -> new OreBlock(Block.Properties.create(Material.ROCK)
                    .hardnessAndResistance( 3.0F, 30.0F)
                    .harvestTool(ToolType.PICKAXE).harvestLevel(2)));

    // Metal Blocks
   public static final RegistryObject<Block> ashstone_block = BLOCKS.register("ashstone_block",
            () -> new Block(Block.Properties.create(Material.ROCK)
                    .hardnessAndResistance(7.0F, 72.0F)
                    .harvestTool(ToolType.PICKAXE).harvestLevel(1)));
    public static final RegistryObject<Block> dragonstone_block = BLOCKS.register("dragonstone_block",
            () -> new Block(Block.Properties.create(Material.ROCK, MaterialColor.NETHERRACK)
                    .hardnessAndResistance(10.0F, 72.0F)
                    .harvestTool(ToolType.PICKAXE).harvestLevel(1)));
    public static final RegistryObject<SimpleMetalBlock> argonite_block = BLOCKS.register("argonite_block",
            () -> new SimpleMetalBlock(Block.Properties.create(Material.IRON, MaterialColor.BLUE)
                    .hardnessAndResistance(7.0F, 72.0F)
                    .harvestTool(ToolType.PICKAXE).harvestLevel(1)));
    public static final RegistryObject<SimpleMetalBlock> fyrite_block = BLOCKS.register("fyrite_block",
            () -> new SimpleMetalBlock(Block.Properties.create(Material.IRON, MaterialColor.TNT)
                    .hardnessAndResistance(7.0F, 72.0F)
                    .harvestTool(ToolType.PICKAXE).harvestLevel(1)));
    public static final RegistryObject<SimpleMetalBlock> illumenite_block = BLOCKS.register("illumenite_block",
            () -> new SimpleMetalBlock(Block.Properties.create(Material.GLASS, MaterialColor.YELLOW)
                    .hardnessAndResistance(7.0F, 72.0F).sound(SoundType.GLASS)
                    .harvestTool(ToolType.PICKAXE).harvestLevel(1)
                    .lightValue(15)));
    public static final RegistryObject<SimpleMetalBlock> malachite_block = BLOCKS.register("malachite_block",
            () -> new SimpleMetalBlock(Block.Properties.create(Material.IRON, MaterialColor.EMERALD)
                    .hardnessAndResistance(7.0F, 72.0F)
                    .harvestTool(ToolType.PICKAXE).harvestLevel(1)));

    // Furnace
    public static final RegistryObject<NetherFurnaceBlock> nether_furnace = BLOCKS.register("nether_furnace",
            () -> new NetherFurnaceBlock(Block.Properties.create(Material.ROCK)
                    .hardnessAndResistance(3.5F, 12.0F)
                    .lightValue(13).harvestTool(ToolType.PICKAXE)));
    public static final RegistryObject<NetherSmokerBlock> nether_smoker = BLOCKS.register("nether_smoker",
            () -> new NetherSmokerBlock(Block.Properties.create(Material.ROCK)
                    .hardnessAndResistance(3.5F, 12.0F)
                    .lightValue(13).harvestTool(ToolType.PICKAXE)));
    public static final RegistryObject<NetherBlastFurnaceBlock> nether_blast_furnace = BLOCKS.register("nether_blast_furnace",
            () -> new NetherBlastFurnaceBlock(Block.Properties.create(Material.ROCK)
                    .hardnessAndResistance(3.5F, 12.0F)
                    .lightValue(13).harvestTool(ToolType.PICKAXE)));
  
}  // end class ModBlocks
