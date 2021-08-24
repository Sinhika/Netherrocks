package mod.alexndr.netherrocks.api.jei;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.google.common.base.Preconditions;

import mezz.jei.api.gui.drawable.IDrawableAnimated;
import mezz.jei.api.helpers.IGuiHelper;
import mod.alexndr.simplecorelib.content.VeryAbstractFurnaceTileEntity;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.item.ItemStack;

public class AlternateFuelRecipe
{
	private final List<ItemStack> inputs;
	private final Component smeltCountText;
	private final IDrawableAnimated flame;
	
	
	public AlternateFuelRecipe(IGuiHelper guiHelper, Collection<ItemStack> input, int burnTime)
	{
		Preconditions.checkArgument(burnTime > 0, "burn time must be greater than 0");
		this.inputs = new ArrayList<>(input);
		this.smeltCountText = createSmeltCountText(burnTime);
		this.flame = guiHelper.drawableBuilder(VeryAbstractFurnaceVariantCategory.RECIPE_GUI_VANILLA, 82, 114, 14, 14)
			.buildAnimated(burnTime, IDrawableAnimated.StartDirection.TOP, true);
	}

	public List<ItemStack> getInputs() {
		return inputs;
	}

	public Component getSmeltCountText() {
		return smeltCountText;
	}

	public IDrawableAnimated getFlame() {
		return flame;
	}

	public static Component createSmeltCountText(int burnTime) {
		if (burnTime == VeryAbstractFurnaceTileEntity.BURN_TIME_STANDARD) {
			return new TranslatableComponent("gui.jei.category.fuel.smeltCount.single");
		} else {
			NumberFormat numberInstance = NumberFormat.getNumberInstance();
			numberInstance.setMaximumFractionDigits(2);
			String smeltCount = numberInstance.format(burnTime / ((float) VeryAbstractFurnaceTileEntity.BURN_TIME_STANDARD));
			return new TranslatableComponent("gui.jei.category.fuel.smeltCount", smeltCount);
		}
	}
} // end class
