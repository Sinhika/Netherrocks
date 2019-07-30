package mod.alexndr.netherrocks.init;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.ScreenManager;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;

public class ClientProxy implements IProxy
{
    @Override
    public void init()
    {
//        ScreenManager.registerFactory(ModContainers.NETHER_FURNACE, NetherFurnaceScreen::new);
    }

    @Override
    public World getClientWorld()
    {
        return Minecraft.getInstance().world;
    }

    @Override
    public PlayerEntity getClientPlayer()
    {
        return Minecraft.getInstance().player;
    }
}  // end class ClientProxy
