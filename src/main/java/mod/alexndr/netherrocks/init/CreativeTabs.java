package mod.alexndr.netherrocks.init;

import mod.alexndr.netherrocks.Netherrocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public final class CreativeTabs
{

//    public static final CreativeModeTab MOD_ITEM_GROUP =
//            new ModTabGroup(Netherrocks.MODID, () -> new ItemStack(ModItems.fyrite_pickaxe.get()));

	// formerly MOD_ITEM_GROUP
	public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = 
			DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Netherrocks.MODID);
	
	public static final DeferredHolder<CreativeModeTab, CreativeModeTab> SIMPLEORES_TAB =
			CREATIVE_MODE_TABS.register("simplecore_tab",
			() -> CreativeModeTab.builder()
				.title(Component.translatable("item_group." + Netherrocks.MODID + ".tab"))
				.icon(() -> new ItemStack(ModItems.fyrite_pickaxe.get()))
				.displayItems((parameters, output) -> {
					output.acceptAll(ModBlocks.BLOCKS.getEntries().stream()
										.map(DeferredHolder::get)
										.map(b -> (new ItemStack(b.asItem())))
										.toList()
										);
					output.acceptAll(ModItems.ITEMS.getEntries().stream()
							.map(DeferredHolder::get)
							.map(b -> (new ItemStack(b)))
							.toList()
							);
				}).build());

}  // end class ModTabGroup
