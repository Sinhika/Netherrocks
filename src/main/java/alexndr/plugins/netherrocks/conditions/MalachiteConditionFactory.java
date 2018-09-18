package alexndr.plugins.netherrocks.conditions;

import java.util.function.BooleanSupplier;

import com.google.gson.JsonObject;

import alexndr.plugins.netherrocks.ModInfo;
import alexndr.plugins.netherrocks.Settings;
import net.minecraft.util.JsonUtils;
import net.minecraftforge.common.crafting.IConditionFactory;
import net.minecraftforge.common.crafting.JsonContext;

public class MalachiteConditionFactory implements IConditionFactory {

	@Override
	public BooleanSupplier parse(JsonContext context, JsonObject json) 
	{
		boolean value = JsonUtils.getBoolean(json , "value", true);
		String key = JsonUtils.getString(json, "type");
		
		if (key.equals(ModInfo.ID + ":malachite_tools_enabled")) {
			return () -> Settings.malachiteTools.isEnabled() == value;
		}
		else if (key.equals(ModInfo.ID + ":malachite_armor_enabled")) {
			return () -> Settings.malachiteArmor.isEnabled() == value;
		}
		else if (key.equals(ModInfo.ID + ":malachite_block_enabled")) {
			return () -> Settings.malachiteBlock.isEnabled() == value;
		}
		else if (key.equals(ModInfo.ID + ":malachite_ingot_enabled")) {
			return () -> Settings.malachiteIngot.isEnabled() == value;
		}
		return null;
	}

} // end class
