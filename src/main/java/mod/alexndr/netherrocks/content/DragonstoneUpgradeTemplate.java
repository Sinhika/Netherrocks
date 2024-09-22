package mod.alexndr.netherrocks.content;

import mod.alexndr.netherrocks.Netherrocks;
import net.minecraft.Util;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.SmithingTemplateItem;

import java.util.List;

public class DragonstoneUpgradeTemplate extends SmithingTemplateItem
{
    protected static final Component DRAGONSTONE_UPGRADE_APPLIES_TO = Component.translatable(
                    Util.makeDescriptionId("item", new ResourceLocation(Netherrocks.MODID,
                            "smithing_template.dragonstone_upgrade.applies_to"))
            )
            .withStyle(DESCRIPTION_FORMAT);
    protected static final Component DRAGONSTONE_UPGRADE_INGREDIENTS = Component.translatable(
                    Util.makeDescriptionId("item", new ResourceLocation(Netherrocks.MODID,
                            "smithing_template.dragonstone_upgrade.ingredients"))
            )
            .withStyle(DESCRIPTION_FORMAT);
    protected static final Component DRAGONSTONE_UPGRADE_BASE_SLOT_DESCRIPTION = Component.translatable(
            Util.makeDescriptionId("item", new ResourceLocation(Netherrocks.MODID,
                    "smithing_template.dragonstone_upgrade.base_slot_description"))
    );
    protected static final Component DRAGONSTONE_UPGRADE_ADDITIONS_SLOT_DESCRIPTION = Component.translatable(
            Util.makeDescriptionId("item", new ResourceLocation(Netherrocks.MODID,
                    "smithing_template.dragonstone_upgrade.additions_slot_description"))
    );

    protected static final Component DRAGONSTONE_UPGRADE = Component.translatable(Util.makeDescriptionId("upgrade",
                    new ResourceLocation(Netherrocks.MODID,"dragonstone_upgrade_smithing_template")))
            .withStyle(TITLE_FORMAT);

    public DragonstoneUpgradeTemplate()
    {
        super(DRAGONSTONE_UPGRADE_APPLIES_TO, DRAGONSTONE_UPGRADE_INGREDIENTS, DRAGONSTONE_UPGRADE,
                DRAGONSTONE_UPGRADE_BASE_SLOT_DESCRIPTION, DRAGONSTONE_UPGRADE_ADDITIONS_SLOT_DESCRIPTION,
                createDragonstoneUpgradeIconList(),
                createDragonstoneUpgradeMaterialList());
    }

    public static SmithingTemplateItem createDragonstoneUpgradeTemplate()
    {
        return new DragonstoneUpgradeTemplate();
    }

    protected static List<ResourceLocation> createDragonstoneUpgradeIconList()
    {
        return List.of(
                EMPTY_SLOT_HELMET,
                EMPTY_SLOT_SWORD,
                EMPTY_SLOT_CHESTPLATE,
                EMPTY_SLOT_PICKAXE,
                EMPTY_SLOT_LEGGINGS,
                EMPTY_SLOT_AXE,
                EMPTY_SLOT_BOOTS,
                EMPTY_SLOT_HOE,
                EMPTY_SLOT_SHOVEL
        );
    }

    protected static List<ResourceLocation> createDragonstoneUpgradeMaterialList()
    {
        return List.of(EMPTY_SLOT_INGOT);
    }

} // end class
