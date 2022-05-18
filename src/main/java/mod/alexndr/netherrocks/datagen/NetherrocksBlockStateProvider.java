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
        // MODELS
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
    
        // ITEM MODELS
        this.itemModels().withExistingParent("argonite_pressure_plate", new ResourceLocation(Netherrocks.MODID, "block/argonite_plate"));
        this.itemModels().withExistingParent("ashstone_pressure_plate", new ResourceLocation(Netherrocks.MODID, "block/ashstone_plate"));
        this.itemModels().withExistingParent("dragonstone_pressure_plate", new ResourceLocation(Netherrocks.MODID, "block/dragonstone_plate"));
        this.itemModels().withExistingParent("fyrite_pressure_plate", new ResourceLocation(Netherrocks.MODID, "block/fyrite_plate"));
        this.itemModels().withExistingParent("illumenite_pressure_plate", new ResourceLocation(Netherrocks.MODID, "block/illumenite_plate"));
        this.itemModels().withExistingParent("malachite_pressure_plate", new ResourceLocation(Netherrocks.MODID, "block/malachite_plate"));
       
        // BLOCKSTATES
        this.buildWeightedPressurePlateBlockState(ModBlocks.argonite_pressure_plate.get(), argonitePlateModel, argonitePlateModel_down);
        this.buildWeightedPressurePlateBlockState(ModBlocks.ashstone_pressure_plate.get(), ashstonePlateModel, ashstonePlateModel_down);
        this.buildWeightedPressurePlateBlockState(ModBlocks.dragonstone_pressure_plate.get(), dragonstonePlateModel, dragonstonePlateModel_down);
        this.buildWeightedPressurePlateBlockState(ModBlocks.fyrite_pressure_plate.get(), fyritePlateModel, fyritePlateModel_down);
        this.buildWeightedPressurePlateBlockState(ModBlocks.illumenite_pressure_plate.get(), illumenitePlateModel, illumenitePlateModel_down);
        this.buildWeightedPressurePlateBlockState(ModBlocks.malachite_pressure_plate.get(), malachitePlateModel, malachitePlateModel_down);
               
    } // end registerStatesAndModels()

} // end class
