package alexndr.plugins.netherrocks.conditions;

import java.util.function.BooleanSupplier;

import com.google.gson.JsonObject;

import alexndr.plugins.netherrocks.ModInfo;
import alexndr.plugins.netherrocks.Settings;
import net.minecraft.util.JsonUtils;
import net.minecraftforge.common.crafting.IConditionFactory;
import net.minecraftforge.common.crafting.JsonContext;

public class DragonstoneConditionFactory implements IConditionFactory {

	@Override
	public BooleanSupplier parse(JsonContext context, JsonObject json) 
	{
		boolean value = JsonUtils.getBoolean(json , "value", true);
		String key = JsonUtils.getString(json, "type");
		
		if (key.equals(ModInfo.ID + ":dragonstone_tools_enabled")) {
			return () -> Settings.dragonstoneTools.isEnabled() == value;
		}
		else if (key.equals(ModInfo.ID + ":dragonstone_armor_enabled")) {
			return () -> Settings.dragonstoneArmor.isEnabled() == value;
		}
		else if (key.equals(ModInfo.ID + ":dragonstone_block_enabled")) {
			return () -> Settings.dragonstoneBlock.isEnabled() == value;
		}
		else if (key.equals(ModInfo.ID + ":dragonstone_gem_enabled")) {
			return () -> Settings.dragonstoneGem.isEnabled() == value;
		}
		return null;
	}

}
