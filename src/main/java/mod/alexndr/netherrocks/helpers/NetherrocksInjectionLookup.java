package mod.alexndr.netherrocks.helpers;

import mod.alexndr.simplecorelib.api.helpers.InjectionTableLookup;

@SuppressWarnings("serial")
public class NetherrocksInjectionLookup extends InjectionTableLookup
{

    public NetherrocksInjectionLookup()
    {
        super();
        this.AddNetherAliases();
        this.AddStrongholdAliases();
        this.put("desert_pyramid", "desert_pyramid");
        this.put("jungle_temple", "jungle_temple");
        this.put("ruined_portal", "ruined_portal");
    } // end ctor

} // end class
