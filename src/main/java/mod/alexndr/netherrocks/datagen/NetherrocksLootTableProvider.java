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
import net.minecraft.loot.LootParameterSet;
import net.minecraft.loot.LootTable.Builder;
import net.minecraft.util.ResourceLocation;

public class NetherrocksLootTableProvider extends BlockLootTableProvider
{

    public NetherrocksLootTableProvider(DataGenerator dataGeneratorIn)
    {
        super(dataGeneratorIn);
        // TODO Auto-generated constructor stub
    }

    @Override
    protected List<Pair<Supplier<Consumer<BiConsumer<ResourceLocation, Builder>>>, LootParameterSet>> getTables()
    {
        tables.clear();
        standardDropTable(ModBlocks.argonite_block.get());
        standardDropTable(ModBlocks.argonite_ore.get());
        standardDropTable(ModBlocks.ashstone_block.get());
        specialDropTable(ModBlocks.ashstone_ore.get(), ModItems.ashstone_gem.get());
        standardDropTable(ModBlocks.dragonstone_block.get());
        specialDropTable(ModBlocks.dragonstone_ore.get(), ModItems.dragonstone_gem.get());
        standardDropTable(ModBlocks.fyrite_block.get());
        standardDropTable(ModBlocks.fyrite_ore.get());
        standardDropTable(ModBlocks.illumenite_block.get());
        standardDropTable(ModBlocks.illumenite_ore.get());
        standardDropTable(ModBlocks.malachite_block.get());
        standardDropTable(ModBlocks.malachite_ore.get());
        copyNameDropTable(ModBlocks.nether_blast_furnace.get(), 
                          ModBlocks.nether_blast_furnace.get().asItem());
        copyNameDropTable(ModBlocks.nether_furnace.get(), 
                          ModBlocks.nether_furnace.get().asItem());
        copyNameDropTable(ModBlocks.nether_smoker.get(), 
                          ModBlocks.nether_smoker.get().asItem());
        
        return tables;
    } // end getTables()
    
    
} // end class
