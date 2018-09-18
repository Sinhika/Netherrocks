package alexndr.plugins.netherrocks;

import java.util.List;

import com.google.common.collect.Lists;

/**
 * @author AleXndrTheGr8st
 */
public class ModInfo {
	public static final String ID = "netherrocks";
	public static final String NAME = "Netherrocks";
	public static final String VERSION = "@MODVERSION@";
	public static final String DESCRIPTION = "A plugin for SimpleCore API that adds 6 new ores to the Nether.";
	public static final String DEPENDENCIES = "required-after:simplecore@[1.7.2.0,);after:simpleores;after:jei@[4.8.0.105,)";
	public static final String ACCEPTED_VERSIONS = "[1.12,)";
	public static final String URL = "http://minecraft.curseforge.com/projects/netherrocks";
	public static final List<String> AUTHORS = Lists.newArrayList("AleXndrTheGr8st");
	public static final String CREDITS = "Created by AleXndrTheGr8st. Maintained by Sinhika";
	public static final String LOGO = "/assets/simplecore/logos/Netherrocks.png";
	public static final String PARENT = "";
	public static final boolean USEDEPENDENCYINFO = true;
	public static final String VERSIONURL = "https://raw.githubusercontent.com/Sinhika/Netherrocks/1.12/update.json";

}
