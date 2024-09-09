package mod.alexndr.netherrocks.init;

import mod.alexndr.netherrocks.Netherrocks;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.properties.BlockSetType;

public final class ModBlockSetTypes 
{

	public static final BlockSetType FYRITE = BlockSetType.register(
			new BlockSetType(new ResourceLocation(Netherrocks.MODID, "fyrite").toString(),
					false, false, false, BlockSetType.PressurePlateSensitivity.EVERYTHING, SoundType.METAL,
					SoundEvents.IRON_DOOR_CLOSE, SoundEvents.IRON_DOOR_OPEN, SoundEvents.IRON_TRAPDOOR_CLOSE,
					SoundEvents.IRON_TRAPDOOR_OPEN, SoundEvents.FIRE_EXTINGUISH, SoundEvents.FLINTANDSTEEL_USE,
					SoundEvents.STONE_BUTTON_CLICK_OFF, SoundEvents.STONE_BUTTON_CLICK_ON));

	public static final BlockSetType ILLUMENITE = BlockSetType.register(
			new BlockSetType(new ResourceLocation(Netherrocks.MODID, "illumenite").toString(),
					false, true, false, BlockSetType.PressurePlateSensitivity.EVERYTHING,
					SoundType.GLASS, SoundEvents.GLASS_PLACE, SoundEvents.GLASS_HIT, SoundEvents.GLASS_PLACE,
					SoundEvents.GLASS_HIT, SoundEvents.GLASS_STEP, SoundEvents.GLASS_PLACE,
					SoundEvents.GLASS_STEP, SoundEvents.GLASS_PLACE));

} // end class
