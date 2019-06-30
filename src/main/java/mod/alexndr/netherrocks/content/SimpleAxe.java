package mod.alexndr.netherrocks.content;

import net.minecraft.item.AxeItem;
import net.minecraft.item.IItemTier;

/**
 * The only reason this class exists is because some idiot made AxeItem have a
 * protected constructor. WHY??
 */
public class SimpleAxe extends AxeItem
{
  public SimpleAxe(IItemTier tier, float attackDamageIn, float attackSpeedIn,
                   Properties builder)
  {
      super(tier, attackDamageIn, attackSpeedIn, builder);
  }
}  // end class SimpleAxe
