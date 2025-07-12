package net.captersers.captercraft.item;

import net.captersers.captercraft.CCMod;
import net.minecraft.ChatFormatting;
import net.minecraft.Util;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.SmithingTemplateItem;

import java.util.List;

/**
 * Utility class for creating Smithing Template items for the mod.
 * This class provides methods to create custom Smithing Templates that define upgrade recipes for items like armor and tools using the Enderite material.
 *
 * @author Captersers Team
 * @since 1.0.0
 */
public class CCSmithingTemplateItem {

    // Constants for formatting Component in the Smithing Template
    private static final ChatFormatting TITLE = ChatFormatting.GRAY;
    private static final ChatFormatting DESCRIPTION = ChatFormatting.BLUE;

    // Resource locations for empty armor slots and empty materials
    private static final ResourceLocation EMPTY_SLOT_HELMET = ResourceLocation.withDefaultNamespace("item/empty_armor_slot_helmet");
    private static final ResourceLocation EMPTY_SLOT_CHESTPLATE = ResourceLocation.withDefaultNamespace("item/empty_armor_slot_chestplate");
    private static final ResourceLocation EMPTY_SLOT_LEGGINGS = ResourceLocation.withDefaultNamespace("item/empty_armor_slot_leggings");
    private static final ResourceLocation EMPTY_SLOT_BOOTS = ResourceLocation.withDefaultNamespace("item/empty_armor_slot_boots");
    private static final ResourceLocation EMPTY_SLOT_HOE = ResourceLocation.withDefaultNamespace("item/empty_slot_hoe");
    private static final ResourceLocation EMPTY_SLOT_AXE = ResourceLocation.withDefaultNamespace("item/empty_slot_axe");
    private static final ResourceLocation EMPTY_SLOT_SWORD = ResourceLocation.withDefaultNamespace("item/empty_slot_sword");
    private static final ResourceLocation EMPTY_SLOT_SHOVEL = ResourceLocation.withDefaultNamespace("item/empty_slot_shovel");
    private static final ResourceLocation EMPTY_SLOT_PICKAXE = ResourceLocation.withDefaultNamespace("item/empty_slot_pickaxe");
    private static final ResourceLocation EMPTY_SLOT_INGOT = ResourceLocation.withDefaultNamespace("item/empty_slot_ingot");

    // Component components for the Smithing Template
    private static final Component ENDERITE_UPGRADE_APPLIES_TO = Component.translatable(Util.makeDescriptionId("item", CCMod.id("smithing_template.enderite_upgrade.applies_to"))).withStyle(DESCRIPTION);
    private static final Component ENDERITE_UPGRADE_INGREDIENTS = Component.translatable(Util.makeDescriptionId("item", CCMod.id("smithing_template.enderite_upgrade.ingredients"))).withStyle(DESCRIPTION);
    private static final Component ENDERITE_UPGRADE_BASE_SLOT_DESCRIPTION = Component.translatable(Util.makeDescriptionId("item", CCMod.id("smithing_template.enderite_upgrade.base_slot_description")));
    private static final Component ENDERITE_UPGRADE_ADDITIONS_SLOT_DESCRIPTION = Component.translatable(Util.makeDescriptionId("item", CCMod.id("smithing_template.enderite_upgrade.additions_slot_description")));
    private static final Component ENDERITE_UPGRADE = Component.translatable(Util.makeDescriptionId("upgrade", CCMod.id("enderite_upgrade"))).withStyle(TITLE);

    /**
     * Creates a Smithing Template item for Enderite upgrades.
     * This template defines the visual appearance and behavior of the Enderite
     * upgrade smithing template, including which items can be upgraded and
     * what materials are required.
     *
     * @return A configured {@link SmithingTemplateItem} for Enderite upgrades
     *
     * @see SmithingTemplateItem#SmithingTemplateItem
     * @see #createEnderiteUpgradeEmptySlotList()
     * @see #createEnderiteUpgradeEmptyMaterialList()
     */
    public static SmithingTemplateItem createEnderiteUpgradeTemplate() {
        return new SmithingTemplateItem(ENDERITE_UPGRADE_APPLIES_TO, ENDERITE_UPGRADE_INGREDIENTS, ENDERITE_UPGRADE, ENDERITE_UPGRADE_BASE_SLOT_DESCRIPTION, ENDERITE_UPGRADE_ADDITIONS_SLOT_DESCRIPTION, createEnderiteUpgradeEmptySlotList(), createEnderiteUpgradeEmptyMaterialList());
    }

    /**
     * Creates a list of empty slot ResourceLocations for items that can be upgraded with Enderite.
     * This list defines which item types can be upgraded using the Enderite
     * smithing template, including all armor pieces and tools.
     *
     * @return A list of {@link ResourceLocation}s representing empty slots for upgradeable items
     *
     * @see ResourceLocation
     * @see List
     */
    private static List<ResourceLocation> createEnderiteUpgradeEmptySlotList() {
        return List.of(EMPTY_SLOT_HELMET, EMPTY_SLOT_SWORD, EMPTY_SLOT_CHESTPLATE, EMPTY_SLOT_PICKAXE, EMPTY_SLOT_LEGGINGS, EMPTY_SLOT_AXE, EMPTY_SLOT_BOOTS, EMPTY_SLOT_HOE, EMPTY_SLOT_SHOVEL);
    }

    /**
     * Creates a list of empty material slot ResourceLocations for the Enderite upgrade.
     * This list defines what material slots are available in the smithing template, specifically the slot where Enderite ingots can be placed.
     *
     * @return A list of {@link ResourceLocation}s representing empty material slots
     *
     * @see ResourceLocation
     * @see List
     */
    private static List<ResourceLocation> createEnderiteUpgradeEmptyMaterialList() {
        return List.of(EMPTY_SLOT_INGOT);
    }
}