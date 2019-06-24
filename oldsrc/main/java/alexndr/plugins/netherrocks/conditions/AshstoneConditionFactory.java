package alexndr.plugins.netherrocks.conditions;

import java.util.function.BooleanSupplier;

import com.google.gson.JsonObject;

import alexndr.plugins.netherrocks.ModInfo;
import alexndr.plugins.netherrocks.Settings;
import net.minecraft.util.JsonUtils;
import net.minecraftforge.common.crafting.IConditionFactory;
import net.minecraftforge.common.crafting.JsonContext;

public class AshstoneConditionFactory implements IConditionFactory {

	@Override
	public BooleanSupplier parse(JsonContext context, JsonObject json) 
	{
		boolean value = JsonUtils.getBoolean(json , "value", true);
		String key = JsonUtils.getString(json, "type");
		
		if (key.equals(ModInfo.ID + ":ashstone_tools_enabled")) {
			return () -> Settings.ashstoneTools.isEnabled() == value;
		}
		else if (key.equals(ModInfo.ID + ":ashstone_block_enabled")) {
			return () -> Settings.ashstoneBlock.isEnabled() == value;
		}
		else if (key.equals(ModInfo.ID + ":ashstone_gem_enabled")) {
			return () -> Settings.ashstoneGem.isEnabled() == value;
		}
		return null;
	}

}
