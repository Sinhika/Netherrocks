package mod.alexndr.netherrocks.datagen;

import mod.alexndr.netherrocks.Netherrocks;
import mod.alexndr.netherrocks.helpers.NetherrocksLootModifiers;
import mod.alexndr.netherrocks.init.ModTags;
import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.data.DataGenerator;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.predicates.MatchTool;
import net.minecraftforge.common.data.GlobalLootModifierProvider;

public class LootModifierProvider extends GlobalLootModifierProvider
{

    public LootModifierProvider(DataGenerator gen)
    {
        super(gen, Netherrocks.MODID);
    }

    @Override
    protected void start()
    {
        add("auto_smelt_tool", new NetherrocksLootModifiers.AutoSmeltLootModifier( 
                new LootItemCondition[] {
                        MatchTool.toolMatches(ItemPredicate.Builder.item().of(ModTags.Items.AUTO_SMELT_TOOLS)).build()
                }));
    }

} // end class
