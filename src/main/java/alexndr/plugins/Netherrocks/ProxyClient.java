package alexndr.plugins.Netherrocks;

import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.relauncher.Side;
import alexndr.api.helpers.game.RenderItemHelper;

public class ProxyClient extends ProxyCommon 
{
	RenderItemHelper renderHelper = new RenderItemHelper(Netherrocks.plugin);
	
	@Override
	public void PreInit(FMLPreInitializationEvent event)
	{	
		super.PreInit(event);
		if(event.getSide() == Side.CLIENT) 
		{
			renderHelper.renderItemsAndBlocks();
			renderHelper.renderItemStuff(event);
		}
	} // end PreInit

	@Override
	public void Init(FMLInitializationEvent event)
	{
		super.Init(event);
	} // end Init()

	@Override
	public void PostInit(FMLPostInitializationEvent event)
	{
		super.PostInit(event);
	} // end PostInit()

} // end class
