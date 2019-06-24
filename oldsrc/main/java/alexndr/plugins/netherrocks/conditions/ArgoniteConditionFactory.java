package alexndr.plugins.netherrocks.conditions;

import java.util.function.BooleanSupplier;

import com.google.gson.JsonObject;

import alexndr.plugins.netherrocks.ModInfo;
import alexndr.plugins.netherrocks.Settings;
import net.minecraft.util.JsonUtils;
import net.minecraftforge.common.crafting.IConditionFactory;
import net.minecraftforge.common.crafting.JsonContext;

public class ArgoniteConditionFactory implements IConditionFactory {

	@Override
	public BooleanSupplier parse(JsonContext context, JsonObject json) 
	{
		boolean value = JsonUtils.getBoolean(json , "value", true);
		String key = JsonUtils.getString(json, "type");
		
		if (key.equals(ModInfo.ID + ":argonite_tools_enabled")) {
			return () -> Settings.argoniteTools.isEnabled() == value;
		}
		else if (key.equals(ModInfo.ID + ":argonite_block_enabled")) {
			return () -> Settings.argoniteBlock.isEnabled() == value;
		}
		else if (key.equals(ModInfo.ID + ":argonite_ingot_enabled")) {
			return () -> Settings.argoniteIngot.isEnabled() == value;
		}
		return null;
	}

}
