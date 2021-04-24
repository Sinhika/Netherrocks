package mod.alexndr.netherrocks.helpers;

import mod.alexndr.simplecorelib.helpers.InjectionTableLookup;

@SuppressWarnings("serial")
public class NetherrocksInjectionLookup extends InjectionTableLookup
{

    public NetherrocksInjectionLookup()
    {
        super();
        
        // nether loot in the nether.
        this.replace("nether_bridge", "bastion");
        
        // we don't have a 'village_house' table.
        this.replace("village_savanna_house", null);
        this.replace("village_plains_house", null);
        this.replace("village_desert_house", null);
        this.replace("village_snowy_house", null);
        this.replace("village_taiga_house", null);

        // some locations shouldn't have nether loot.
        this.replace("shipwreck_supply", null);
        this.replace("shipwreck_map", null);
        this.replace("shipwreck_treasure", null);
        this.replace("underwater_ruin_small", null);
        this.replace("underwater_ruin_big", null);
        this.replace("abandoned_mineshaft", null);
        this.replace("igloo_chest", null);
        this.replace("simple_dungeon", null);
        this.replace("village_armorer", null);
        this.replace("village_mason", null);
        this.replace("village_toolsmith", null);
        this.replace("village_weaponsmith", null);
        
        // these tables all present as themselves.
        // nether loot near the nether; table present as itself.
        this.remove("ruined_portal");
    } // end ctor

} // end class
