package alexndr.plugins.Netherrocks;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.item.EntityXPOrb;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.util.MathHelper;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;
import alexndr.api.core.ContentRegistry;
import alexndr.api.core.ContentTypes;
import alexndr.api.helpers.game.TabHelper;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

/**
 * @author AleXndrTheGr8st
 */
public class NetherPickaxe extends ItemPickaxe
{
	private final ToolMaterial toolMaterial;
	
	public NetherPickaxe(ToolMaterial toolMaterial)
	{
		super(toolMaterial);
		this.toolMaterial = toolMaterial;
		this.setCreativeTab(TabHelper.toolsTab());
		this.setHarvestLevel("pickaxe", toolMaterial.getHarvestLevel());
	}
	
	/**
	 * Code that makes the Fyrite Pickaxe drop the smelted item rather than the normal drop.
	 * Only affects the Fyrite Pickaxe.
	 */
	@Override
	public boolean onBlockStartBreak(ItemStack itemstack, int i, int j, int k, EntityPlayer player)
	{
		Random random = new Random();
		if(this == Content.fyrite_pickaxe && !player.capabilities.isCreativeMode)
		{
			Boolean flag = false;
			World world = player.worldObj;
			Block block = world.getBlock(i, j, k);
			int meta = world.getBlockMetadata(i, j, k);

			NBTTagList ench = itemstack.getEnchantmentTagList();
			short level = 0;
			if(ench != null)
			{
				for (int x = 0; x < ench.tagCount(); x++)
				{
					NBTTagCompound nbt = ench.getCompoundTagAt(x);
					short id = nbt.getShort("id");
					if (id == Enchantment.fortune.effectId)
					{
						level = nbt.getShort("lvl");
					}
				}
			}
			
			ArrayList<ItemStack> items = block.getDrops(world, i, j, k, meta, level);
			if(items == null || items.size() == 0)
			{
				return false;
			}
			if(block != null && this.getDigSpeed(itemstack, block, meta) > 1.0F)
			{
				for (ItemStack item : items)
				{
					if (FurnaceRecipes.smelting().getSmeltingResult(item) == null)
					{
						return false;
					}
					
		            int var3 = random.nextInt(level + 2) - 1;

		            if (var3 < 0)
		            {
		                var3 = 0;
		            }
		            
		            int quantity = block.quantityDropped(random) * (var3 + 1);
					
					ItemStack drop = new ItemStack(FurnaceRecipes.smelting().getSmeltingResult(item).copy().getItem(), quantity, FurnaceRecipes.smelting().getSmeltingResult(item).copy().getItemDamage());
					world.playSoundEffect(i + 0.5F, j + 0.5F, k + 0.5F,
							block.stepSound.getBreakSound(),
							(block.stepSound.getVolume() + 1.0F) / 2.0F,
							block.stepSound.getPitch() * 0.8F);
					
					world.setBlock(i, j, k, Blocks.air);
					if(!world.isRemote)
					{
						EntityItem entityitem = new EntityItem(world, i + 0.5, j + 0.5, k + 0.5, drop);
						world.spawnEntityInWorld(entityitem);
						
						try {
							int exp = drop.stackSize;
							float expFloat = FurnaceRecipes.smelting().func_151398_b(FurnaceRecipes.smelting().getSmeltingResult(item).copy());
							int expAmount;
							if(expFloat == 0.0F)
								exp = 0;
							else if(expFloat < 1.0F) {
								expAmount = MathHelper.floor_float(exp * expFloat);
								if(expAmount < MathHelper.ceiling_float_int(exp * expFloat) && (float)Math.random() < exp * expFloat - expAmount) {
									++expAmount;
								}
								exp = expAmount;
							}
							while(exp > 0) {
								expAmount = EntityXPOrb.getXPSplit(exp);
								exp -= expAmount;
								world.spawnEntityInWorld(new EntityXPOrb(world, i + 0.5, j + 0.5, k + 0.5, expAmount));
							}
						} catch(Exception e) {
							e.printStackTrace();
						}
					}
					itemstack.damageItem(1, player);
					
					flag = true;
				}
			}

			return flag;
		}
		else return false;
	}
	
    /**
     * Sets the icon for the item. 
     */
    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister iconRegister) 
    {
    	 this.itemIcon = iconRegister.registerIcon("netherrocks:" + (this.getUnlocalizedName().substring(5)));
    }
    
	@Override
	public boolean getIsRepairable(ItemStack par1ItemStack, ItemStack par2ItemStack)
	{
		return this.toolMaterial.getRepairItemStack() == par2ItemStack ? true : super.getIsRepairable(par1ItemStack, par2ItemStack);
	}
	
	/**
	 * Registers the item in the GameRegistry, with the name given, and sends the name through to setUnlocalizedName in the super class.
	 */
	@Override
	public NetherPickaxe setUnlocalizedName(String unlocalizedName)
	{
		super.setUnlocalizedName(unlocalizedName);
		GameRegistry.registerItem(this, unlocalizedName);
		ContentRegistry.registerItem(this, unlocalizedName, "netherrocks", ContentTypes.Item.TOOL);
		return this;
	}
	
	@Override
	public void addInformation(ItemStack stack, EntityPlayer par2EntityPlayer, List par3List, boolean par4)
	{
		if(this == Content.fyrite_pickaxe)
		{
			par3List.add(StatCollector.translateToLocal("netherrocks.fyrite_pickaxe.info"));
		}
	}
}
