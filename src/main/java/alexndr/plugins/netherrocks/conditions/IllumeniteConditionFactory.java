package alexndr.plugins.netherrocks.conditions;

import java.util.function.BooleanSupplier;

import com.google.gson.JsonObject;

import alexndr.plugins.netherrocks.ModInfo;
import alexndr.plugins.netherrocks.Settings;
import net.minecraft.util.JsonUtils;
import net.minecraftforge.common.crafting.IConditionFactory;
import net.minecraftforge.common.crafting.JsonContext;

public class IllumeniteConditionFactory implements IConditionFactory {

	@Override
	public BooleanSupplier parse(JsonContext context, JsonObject json) 
	{
		boolean value = JsonUtils.getBoolean(json , "value", true);
		String key = JsonUtils.getString(json, "type");
		
		if (key.equals(ModInfo.ID + ":illumenite_tools_enabled")) {
			return () -> Settings.illumeniteTools.isEnabled() == value;
		}
		else if (key.equals(ModInfo.ID + ":illumenite_armor_enabled")) {
			return () -> Settings.illumeniteArmor.isEnabled() == value;
		}
		else if (key.equals(ModInfo.ID + ":illumenite_block_enabled")) {
			return () -> Settings.illumeniteBlock.isEnabled() == value;
		}
		else if (key.equals(ModInfo.ID + ":illumenite_ingot_enabled")) {
			return () -> Settings.illumeniteIngot.isEnabled() == value;
		}
		return null;
	}

} // end class
