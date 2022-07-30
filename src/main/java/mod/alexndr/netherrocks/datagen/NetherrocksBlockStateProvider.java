package mod.alexndr.netherrocks.datagen;

import mod.alexndr.netherrocks.Netherrocks;
import mod.alexndr.netherrocks.init.ModBlocks;
import mod.alexndr.simplecorelib.api.datagen.SimpleBlockStateProvider;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;

public class NetherrocksBlockStateProvider extends SimpleBlockStateProvider
{

    public NetherrocksBlockStateProvider(DataGenerator gen,  ExistingFileHelper exFileHelper)
    {
        super(gen, Netherrocks.MODID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels()
    {
        // BLOCKSATES -- "ghast" ore, evil clone of ashstone ore.
        this.simpleBlock(ModBlocks.ghast_ore.get(), 
                this.models().cubeAll("ghast_ore", new ResourceLocation(Netherrocks.MODID, "block/ashstone_ore")));
                        
        // ITEM MODELS -- ghast ore
        this.itemModels().withExistingParent("ghast_ore", new ResourceLocation(Netherrocks.MODID, "block/ashstone_ore"));
        
        this.generateBrickStatesAndModels();
        this.generatePressurePlateStatesAndModels();
        this.generateBarStatesAndModels();
        this.generateDoorStatesAndModels();
    } // end registerStatesAndModels()

    private void generateBrickStatesAndModels()
    {
        // BLOCKSTATES -- brick blocks, but have "cut_metal" texture names.
        this.simpleBlock(ModBlocks.argonite_bricks.get(), 
                this.models().cubeAll("argonite_bricks", new ResourceLocation(Netherrocks.MODID, "block/cut_argonite")));
        this.simpleBlock(ModBlocks.fyrite_bricks.get(), 
                this.models().cubeAll("fyrite_bricks", new ResourceLocation(Netherrocks.MODID, "block/cut_fyrite")));
        this.simpleBlock(ModBlocks.illumenite_bricks.get(), 
                this.models().cubeAll("illumenite_bricks", new ResourceLocation(Netherrocks.MODID, "block/cut_illumenite")));
        this.simpleBlock(ModBlocks.malachite_bricks.get(), 
                this.models().cubeAll("malachite_bricks", new ResourceLocation(Netherrocks.MODID, "block/cut_malachite")));
        this.simpleBlock(ModBlocks.ashstone_bricks.get(), 
                this.models().cubeAll("ashstone_bricks", new ResourceLocation(Netherrocks.MODID, "block/ashstone_small_bricks")));
        this.simpleBlock(ModBlocks.dragonstone_bricks.get(), 
                this.models().cubeAll("dragonstone_bricks", new ResourceLocation(Netherrocks.MODID, "block/dragonstone_bricks")));
       
       // BLOCKSTATES -- brick slabs, but have "cut_metal" texture names.
        this.slabBlock(ModBlocks.argonite_brick_slab.get(), new ResourceLocation(Netherrocks.MODID, "block/argonite_bricks"), 
                new ResourceLocation(Netherrocks.MODID, "block/cut_argonite"));
        this.slabBlock(ModBlocks.fyrite_brick_slab.get(), new ResourceLocation(Netherrocks.MODID, "block/fyrite_bricks"), 
                new ResourceLocation(Netherrocks.MODID, "block/cut_fyrite"));
        this.slabBlock(ModBlocks.illumenite_brick_slab.get(), new ResourceLocation(Netherrocks.MODID, "block/illumenite_bricks"), 
                new ResourceLocation(Netherrocks.MODID, "block/cut_illumenite"));
        this.slabBlock(ModBlocks.malachite_brick_slab.get(), new ResourceLocation(Netherrocks.MODID, "block/malachite_bricks"), 
                new ResourceLocation(Netherrocks.MODID, "block/cut_malachite"));
        this.slabBlock(ModBlocks.ashstone_brick_slab.get(), new ResourceLocation(Netherrocks.MODID, "block/ashstone_bricks"), 
                new ResourceLocation(Netherrocks.MODID, "block/ashstone_small_bricks"));
        this.slabBlock(ModBlocks.dragonstone_brick_slab.get(), new ResourceLocation(Netherrocks.MODID, "block/dragonstone_bricks"), 
                new ResourceLocation(Netherrocks.MODID, "block/dragonstone_bricks"));

        // BLOCKSTATES -- brick stairs, but have "cut metal" textures.
        this.stairsBlock(ModBlocks.argonite_brick_stairs.get(), new ResourceLocation(Netherrocks.MODID, "block/cut_argonite"));
        this.stairsBlock(ModBlocks.fyrite_brick_stairs.get(), new ResourceLocation(Netherrocks.MODID, "block/cut_fyrite"));
        this.stairsBlock(ModBlocks.illumenite_brick_stairs.get(), new ResourceLocation(Netherrocks.MODID, "block/cut_illumenite"));
        this.stairsBlock(ModBlocks.malachite_brick_stairs.get(), new ResourceLocation(Netherrocks.MODID, "block/cut_malachite"));
        this.stairsBlock(ModBlocks.ashstone_brick_stairs.get(), new ResourceLocation(Netherrocks.MODID, "block/ashstone_small_bricks"));
        this.stairsBlock(ModBlocks.dragonstone_brick_stairs.get(), new ResourceLocation(Netherrocks.MODID, "block/dragonstone_bricks"));
      
     
        // ITEM MODELS -- brick blocks
        this.itemModels().withExistingParent("argonite_bricks", new ResourceLocation(Netherrocks.MODID, "block/argonite_bricks"));
        this.itemModels().withExistingParent("argonite_brick_slab", new ResourceLocation(Netherrocks.MODID, "block/argonite_brick_slab"));
        this.itemModels().withExistingParent("argonite_brick_stairs", new ResourceLocation(Netherrocks.MODID, "block/argonite_brick_stairs"));
        this.itemModels().withExistingParent("fyrite_bricks", new ResourceLocation(Netherrocks.MODID, "block/fyrite_bricks"));
        this.itemModels().withExistingParent("fyrite_brick_slab", new ResourceLocation(Netherrocks.MODID, "block/fyrite_brick_slab"));
        this.itemModels().withExistingParent("fyrite_brick_stairs", new ResourceLocation(Netherrocks.MODID, "block/fyrite_brick_stairs"));
        this.itemModels().withExistingParent("illumenite_bricks", new ResourceLocation(Netherrocks.MODID, "block/illumenite_bricks"));
        this.itemModels().withExistingParent("illumenite_brick_slab", new ResourceLocation(Netherrocks.MODID, "block/illumenite_brick_slab"));
        this.itemModels().withExistingParent("illumenite_brick_stairs", new ResourceLocation(Netherrocks.MODID, "block/illumenite_brick_stairs"));
        this.itemModels().withExistingParent("malachite_bricks", new ResourceLocation(Netherrocks.MODID, "block/malachite_bricks"));
        this.itemModels().withExistingParent("malachite_brick_slab", new ResourceLocation(Netherrocks.MODID, "block/malachite_brick_slab"));
        this.itemModels().withExistingParent("malachite_brick_stairs", new ResourceLocation(Netherrocks.MODID, "block/malachite_brick_stairs"));
        this.itemModels().withExistingParent("ashstone_bricks", new ResourceLocation(Netherrocks.MODID, "block/ashstone_bricks"));
        this.itemModels().withExistingParent("ashstone_brick_slab", new ResourceLocation(Netherrocks.MODID, "block/ashstone_brick_slab"));
        this.itemModels().withExistingParent("ashstone_brick_stairs", new ResourceLocation(Netherrocks.MODID, "block/ashstone_brick_stairs"));
        this.itemModels().withExistingParent("dragonstone_bricks", new ResourceLocation(Netherrocks.MODID, "block/dragonstone_bricks"));
        this.itemModels().withExistingParent("dragonstone_brick_slab", new ResourceLocation(Netherrocks.MODID, "block/dragonstone_brick_slab"));
        this.itemModels().withExistingParent("dragonstone_brick_stairs", new ResourceLocation(Netherrocks.MODID, "block/dragonstone_brick_stairs"));
    } // end generateBrickStatesAndModels()
    
    
    private void generatePressurePlateStatesAndModels()
    {
        // MODELS -- pressure plates
        ModelFile argonitePlateModel = this.models().pressurePlate("argonite_plate", 
                new ResourceLocation(Netherrocks.MODID, "block/argonite_block"));
        ModelFile argonitePlateModel_down = this.models().pressurePlateDown("argonite_plate_down", 
                new ResourceLocation(Netherrocks.MODID, "block/argonite_block"));
        ModelFile ashstonePlateModel = this.models().pressurePlate("ashstone_plate", 
                new ResourceLocation(Netherrocks.MODID, "block/ashstone_block"));
        ModelFile ashstonePlateModel_down = this.models().pressurePlateDown("ashstone_plate_down", 
                new ResourceLocation(Netherrocks.MODID, "block/ashstone_block"));
        ModelFile dragonstonePlateModel = this.models().pressurePlate("dragonstone_plate", 
                new ResourceLocation(Netherrocks.MODID, "block/dragonstone_block"));
        ModelFile dragonstonePlateModel_down = this.models().pressurePlateDown("dragonstone_plate_down", 
                new ResourceLocation(Netherrocks.MODID, "block/dragonstone_block"));
        ModelFile fyritePlateModel = this.models().pressurePlate("fyrite_plate", 
                new ResourceLocation(Netherrocks.MODID, "block/fyrite_block"));
        ModelFile fyritePlateModel_down = this.models().pressurePlateDown("fyrite_plate_down", 
                new ResourceLocation(Netherrocks.MODID, "block/fyrite_block"));
        ModelFile illumenitePlateModel = this.models().pressurePlate("illumenite_plate", 
                new ResourceLocation(Netherrocks.MODID, "block/illumenite_block"));
        ModelFile illumenitePlateModel_down = this.models().pressurePlateDown("illumenite_plate_down", 
                new ResourceLocation(Netherrocks.MODID, "block/illumenite_block"));
        ModelFile malachitePlateModel = this.models().pressurePlate("malachite_plate", 
                new ResourceLocation(Netherrocks.MODID, "block/malachite_block"));
        ModelFile malachitePlateModel_down = this.models().pressurePlateDown("malachite_plate_down", 
                new ResourceLocation(Netherrocks.MODID, "block/malachite_block"));
    
        
        // ITEM MODELS -- pressure plates
        this.itemModels().withExistingParent("argonite_pressure_plate", new ResourceLocation(Netherrocks.MODID, "block/argonite_plate"));
        this.itemModels().withExistingParent("ashstone_pressure_plate", new ResourceLocation(Netherrocks.MODID, "block/ashstone_plate"));
        this.itemModels().withExistingParent("dragonstone_pressure_plate", new ResourceLocation(Netherrocks.MODID, "block/dragonstone_plate"));
        this.itemModels().withExistingParent("fyrite_pressure_plate", new ResourceLocation(Netherrocks.MODID, "block/fyrite_plate"));
        this.itemModels().withExistingParent("illumenite_pressure_plate", new ResourceLocation(Netherrocks.MODID, "block/illumenite_plate"));
        this.itemModels().withExistingParent("malachite_pressure_plate", new ResourceLocation(Netherrocks.MODID, "block/malachite_plate"));
         
        // BLOCKSTATES -- pressure plates
        this.buildWeightedPressurePlateBlockState(ModBlocks.argonite_pressure_plate.get(), argonitePlateModel, argonitePlateModel_down);
        this.buildWeightedPressurePlateBlockState(ModBlocks.ashstone_pressure_plate.get(), ashstonePlateModel, ashstonePlateModel_down);
        this.buildWeightedPressurePlateBlockState(ModBlocks.dragonstone_pressure_plate.get(), dragonstonePlateModel, dragonstonePlateModel_down);
        this.buildWeightedPressurePlateBlockState(ModBlocks.fyrite_pressure_plate.get(), fyritePlateModel, fyritePlateModel_down);
        this.buildWeightedPressurePlateBlockState(ModBlocks.illumenite_pressure_plate.get(), illumenitePlateModel, illumenitePlateModel_down);
        this.buildWeightedPressurePlateBlockState(ModBlocks.malachite_pressure_plate.get(), malachitePlateModel, malachitePlateModel_down);
   } // end generatePressurePlateStatesAndModels()
    
    private void generateBarStatesAndModels()
    {
        this.buildBarsBlockState(ModBlocks.argonite_bars.get(), modLoc("block/argonite_bars"));
        this.buildBarsBlockState(ModBlocks.fyrite_bars.get(), modLoc("block/fyrite_bars"));
        this.buildBarsBlockState(ModBlocks.ashstone_bars.get(), modLoc("block/ashstone_bars"));
        this.buildBarsBlockState(ModBlocks.dragonstone_bars.get(), modLoc("block/dragonstone_bars"));
        this.buildBarsBlockState(ModBlocks.illumenite_bars.get(), modLoc("block/illumenite_bars"));
        this.buildBarsBlockState(ModBlocks.malachite_bars.get(), modLoc("block/malachite_bars"));
            
        this.basicBlockItem(ModBlocks.argonite_bars.get());
        this.basicBlockItem(ModBlocks.fyrite_bars.get());
        this.basicBlockItem(ModBlocks.ashstone_bars.get());
        this.basicBlockItem(ModBlocks.dragonstone_bars.get());
        this.basicBlockItem(ModBlocks.illumenite_bars.get());
        this.basicBlockItem(ModBlocks.malachite_bars.get());
    } // end generateBarStatesAndModels()
    
    
    private void generateDoorStatesAndModels()
    {
        // BLOCKSTATES & BLOCK MODELS
        this.doorBlockWithRenderType(ModBlocks.argonite_door.get(), modLoc("block/argonite_door_lower"), 
               modLoc("block/argonite_door_upper"), "cutout");
        this.doorBlockWithRenderType(ModBlocks.ashstone_door.get(), modLoc("block/ashstone_door_lower"), 
                modLoc("block/ashstone_door_upper"), "cutout");
        this.doorBlockWithRenderType(ModBlocks.dragonstone_door.get(), modLoc("block/dragonstone_door_lower"), 
                modLoc("block/dragonstone_door_upper"), "cutout");
        this.doorBlockWithRenderType(ModBlocks.fyrite_door.get(), modLoc("block/fyrite_door_lower"), 
                modLoc("block/fyrite_door_upper"), "cutout");
        this.doorBlockWithRenderType(ModBlocks.illumenite_door.get(), modLoc("block/illumenite_door_lower"), 
                modLoc("block/illumenite_door_upper"), "cutout");
        this.doorBlockWithRenderType(ModBlocks.malachite_door.get(), modLoc("block/malachite_door_lower"), 
                modLoc("block/malachite_door_upper"), "cutout");
 
        // ITEM MODELS
        this.itemModels().basicItem(ModBlocks.argonite_door.get().asItem());
        this.itemModels().basicItem(ModBlocks.ashstone_door.get().asItem());
        this.itemModels().basicItem(ModBlocks.dragonstone_door.get().asItem());
        this.itemModels().basicItem(ModBlocks.fyrite_door.get().asItem());
        this.itemModels().basicItem(ModBlocks.illumenite_door.get().asItem());
        this.itemModels().basicItem(ModBlocks.malachite_door.get().asItem());

    } // end generateDoorStatesAndModels()
    
} // end class
