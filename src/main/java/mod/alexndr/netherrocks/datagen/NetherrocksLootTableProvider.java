package mod.alexndr.netherrocks.datagen;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Supplier;

import com.mojang.datafixers.util.Pair;

import mod.alexndr.netherrocks.init.ModBlocks;
import mod.alexndr.netherrocks.init.ModItems;
import mod.alexndr.simplecorelib.datagen.BlockLootTableProvider;
import net.minecraft.data.DataGenerator;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSet;
import net.minecraft.world.level.storage.loot.LootTable.Builder;
import net.minecraft.resources.ResourceLocation;

public class NetherrocksLootTableProvider extends BlockLootTableProvider
{

    public NetherrocksLootTableProvider(DataGenerator dataGeneratorIn)
    {
        super(dataGeneratorIn);
        // TODO Auto-generated constructor stub
    }

    @Override
    protected List<Pair<Supplier<Consumer<BiConsumer<ResourceLocation, Builder>>>, LootContextParamSet>> getTables()
    {
        tables.clear();
        standardDropTable(ModBlocks.argonite_block.get());
        standardDropTable(ModBlocks.raw_argonite_block.get());
        specialDropTable(ModBlocks.argonite_ore.get(), ModItems.raw_argonite.get());
        standardDropTable(ModBlocks.ashstone_block.get());
        specialDropTable(ModBlocks.ashstone_ore.get(), ModItems.ashstone_gem.get());
        standardDropTable(ModBlocks.dragonstone_block.get());
        specialDropTable(ModBlocks.dragonstone_ore.get(), ModItems.dragonstone_gem.get());
        standardDropTable(ModBlocks.fyrite_block.get());
        standardDropTable(ModBlocks.raw_fyrite_block.get());
        specialDropTable(ModBlocks.fyrite_ore.get(), ModItems.raw_fyrite.get());
        standardDropTable(ModBlocks.illumenite_block.get());
        standardDropTable(ModBlocks.raw_illumenite_block.get());
        specialDropTable(ModBlocks.illumenite_ore.get(), ModItems.raw_illumenite.get());
        standardDropTable(ModBlocks.malachite_block.get());
        standardDropTable(ModBlocks.raw_malachite_block.get());
        specialDropTable(ModBlocks.malachite_ore.get(), ModItems.raw_malachite.get());
        
        copyNameDropTable(ModBlocks.nether_blast_furnace.get(), 
                          ModBlocks.nether_blast_furnace.get().asItem());
        copyNameDropTable(ModBlocks.nether_furnace.get(), 
                          ModBlocks.nether_furnace.get().asItem());
        copyNameDropTable(ModBlocks.nether_smoker.get(), 
                          ModBlocks.nether_smoker.get().asItem());
        
        return tables;
    } // end getTables()
    
    
} // end class
