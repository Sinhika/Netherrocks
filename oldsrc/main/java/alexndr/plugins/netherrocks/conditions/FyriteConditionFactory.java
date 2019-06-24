package alexndr.plugins.netherrocks.conditions;

import java.util.function.BooleanSupplier;

import com.google.gson.JsonObject;

import alexndr.plugins.netherrocks.ModInfo;
import alexndr.plugins.netherrocks.Settings;
import net.minecraft.util.JsonUtils;
import net.minecraftforge.common.crafting.IConditionFactory;
import net.minecraftforge.common.crafting.JsonContext;

public class FyriteConditionFactory implements IConditionFactory {

	@Override
	public BooleanSupplier parse(JsonContext context, JsonObject json) 
	{
		boolean value = JsonUtils.getBoolean(json , "value", true);
		String key = JsonUtils.getString(json, "type");
		
		if (key.equals(ModInfo.ID + ":fyrite_tools_enabled")) {
			return () -> Settings.fyriteTools.isEnabled() == value;
		}
		else if (key.equals(ModInfo.ID + ":fyrite_armor_enabled")) {
			return () -> Settings.fyriteArmor.isEnabled() == value;
		}
		else if (key.equals(ModInfo.ID + ":fyrite_block_enabled")) {
			return () -> Settings.fyriteBlock.isEnabled() == value;
		}
		else if (key.equals(ModInfo.ID + ":fyrite_ingot_enabled")) {
			return () -> Settings.fyriteIngot.isEnabled() == value;
		}
		return null;
	}

} // end class
