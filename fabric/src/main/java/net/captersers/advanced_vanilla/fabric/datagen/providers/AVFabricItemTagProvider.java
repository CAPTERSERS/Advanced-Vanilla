package net.captersers.advanced_vanilla.fabric.datagen.providers;

import net.captersers.advanced_vanilla.registry.AVItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.tags.ItemTags;

import java.util.concurrent.CompletableFuture;

/**
 * Item Tag Provider for mod
 * This class generates item tags that categorize items for various game mechanics
 *
 * @author Advanced Vanilla Team
 * @since 1.0.0
 */
public class AVFabricItemTagProvider extends FabricTagProvider.ItemTagProvider {

    /**
     * Constructor for the Item Tag Provider
     *
     * @param output The data output for generating tags
     * @param completableFuture Future containing registry wrapper lookup
     */
    public AVFabricItemTagProvider(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> completableFuture) {
        super(output, completableFuture);
    }

    /**
     * Configures all item tags for the mod
     * This method creates tags for armor pieces and tools, allowing them to be
     * recognized by game mechanics like anvils, crafting tables, etc.
     *
     * @param lookup Registry wrapper lookup for accessing game registries
     */
    @Override
    public void addTags(HolderLookup.Provider lookup) {

        // Head armor allows items to be used in helmet slots
        getOrCreateTagBuilder(ItemTags.HEAD_ARMOR)
                .add(AVItems.COPPER_HELMET.get())
                .add(AVItems.ENDERITE_HELMET.get());

        // Chest armor allows items to be used in chestplate slots
        getOrCreateTagBuilder(ItemTags.CHEST_ARMOR)
                .add(AVItems.COPPER_CHESTPLATE.get())
                .add(AVItems.ENDERITE_CHESTPLATE.get());

        // Leg armor allows items to be used in legging slots
        getOrCreateTagBuilder(ItemTags.LEG_ARMOR)
                .add(AVItems.COPPER_LEGGINGS.get())
                .add(AVItems.ENDERITE_LEGGINGS.get());

        // Foot armor allows items to be used in boots slots
        getOrCreateTagBuilder(ItemTags.FOOT_ARMOR)
                .add(AVItems.COPPER_BOOTS.get())
                .add(AVItems.ENDERITE_BOOTS.get());

        // Axe tag allows items to be recognized as axes for various mechanics
        getOrCreateTagBuilder(ItemTags.AXES)
                .add(AVItems.COPPER_AXE.get())
                .add(AVItems.ENDERITE_AXE.get());

        // Hoes tag allows items to be recognized as hoes for farming mechanics
        getOrCreateTagBuilder(ItemTags.HOES)
                .add(AVItems.COPPER_HOE.get())
                .add(AVItems.ENDERITE_HOE.get());

        // Pickaxe tag allows items to be recognized as pickaxes for mining mechanics
        getOrCreateTagBuilder(ItemTags.PICKAXES)
                .add(AVItems.COPPER_PICKAXE.get())
                .add(AVItems.ENDERITE_PICKAXE.get());

        // Shovel tag allows items to be recognized as shovels for digging mechanics
        getOrCreateTagBuilder(ItemTags.SHOVELS)
                .add(AVItems.COPPER_SHOVEL.get())
                .add(AVItems.ENDERITE_SHOVEL.get());

        // Swords tag allows items to be recognized as swords for combat mechanics
        getOrCreateTagBuilder(ItemTags.SWORDS)
                .add(AVItems.COPPER_SWORD.get())
                .add(AVItems.ENDERITE_SWORD.get());
    }
}
