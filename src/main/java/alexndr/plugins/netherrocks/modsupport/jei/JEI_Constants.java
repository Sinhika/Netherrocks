package alexndr.plugins.netherrocks.modsupport.jei;

import java.util.Locale;

import alexndr.plugins.netherrocks.ModInfo;
import net.minecraft.util.ResourceLocation;

/**
 * Selectively Cut & Pasted from mezz.jei.config.Constants
 * Because Mezz doesn't put important vanilla constants in his API.
 * @author Sinhika
 *
 */
public class JEI_Constants 
{
	// Textures
	public static final String RESOURCE_DOMAIN = ModInfo.ID.toLowerCase(Locale.ENGLISH);
	public static final String TEXTURE_GUI_PATH = "textures/gui/";
	public static final String TEXTURE_GUI_VANILLA = JEI_Constants.TEXTURE_GUI_PATH + "gui_vanilla.png";
	public static final String TEXTURE_RECIPE_BACKGROUND_PATH = JEI_Constants.TEXTURE_GUI_PATH + "recipe_background_2.png";
	
	public static final ResourceLocation RECIPE_GUI_VANILLA = new ResourceLocation(RESOURCE_DOMAIN, TEXTURE_GUI_VANILLA);
	public static final ResourceLocation RECIPE_BACKGROUND = new ResourceLocation(RESOURCE_DOMAIN, TEXTURE_RECIPE_BACKGROUND_PATH);

}
