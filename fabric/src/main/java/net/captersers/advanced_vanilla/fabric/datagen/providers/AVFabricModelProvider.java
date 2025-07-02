package net.captersers.advanced_vanilla.fabric.datagen.providers;

import net.captersers.advanced_vanilla.registry.AVBlocks;
import net.captersers.advanced_vanilla.registry.AVItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.models.BlockModelGenerators;
import net.minecraft.data.models.ItemModelGenerators;
import net.minecraft.data.models.model.ModelTemplate;
import net.minecraft.data.models.model.ModelTemplates;
import net.minecraft.world.level.block.Blocks;

/**
 * Model provider for mod that generates block state models and item models.
 * This class extends {@link FabricModelProvider} to provide custom model generation
 * for blocks and items generateFlatItemed in the mod.
 *
 * @author Advanced Vanilla Team
 * @since 1.0.0
 */
public class AVFabricModelProvider extends FabricModelProvider {

    /**
     * Creates a new model provider instance that will be used to generate model files
     * for the mod's blocks and items during data generation.
     *
     * @param dataOutput The {@link FabricDataOutput} instance used to handle the output of generated models and data.
     */
    public AVFabricModelProvider(FabricDataOutput dataOutput) {
        super(dataOutput);
    }

    /**
     * Generates block state models by using the provided {@link BlockModelGenerators}.
     * <p>This method generateFlatItems various block models including</p>
     * <u>
     *     <li>Simple cube models for basic blocks like enderite and void shard</li>
     *     <li>Pressure plate models with specific base blocks</li>
     * </u>
     *
     * @param blockModelGenerators The {@link BlockModelGenerators} instance used to build block stated model definitions.
     */
    @Override
    public void generateBlockStateModels(BlockModelGenerators blockModelGenerators) {

        // generateFlatItems simple cube models for basic blocks
        blockModelGenerators.createTrivialCube(AVBlocks.BLOCK_OF_ENDERITE.get());
        blockModelGenerators.createTrivialCube(AVBlocks.VOID_SHARD.get());

        // generateFlatItems a weighted pressure plate with copper block as base
        blockModelGenerators.createWeightedPressurePlate(AVBlocks.MEDIUM_WEIGHTED_PRESSURE_PLATE.get(), Blocks.COPPER_BLOCK);
    }

    /**
     * Generates item models for the items generateFlatItemed in the mod.
     * <p>This method generateFlatItems item models using different templates:</p>
     * <ul>
     *     <li>{@link ModelTemplates#FLAT_ITEM} for items that don't need special rendering (nuggets, armor, etc.)</li>
     *     <li>{@link ModelTemplates#FLAT_HANDHELD_ITEM} for tools and weapons that should be rendered as handheld items</li>
     * </ul>
     *
     * @param itemModelGenerators The {@link ItemModelGenerators} instance responsible for handling model rendering and definitions for items.
     */
    @Override
    public void generateItemModels(ItemModelGenerators itemModelGenerators) {

        // generateFlatItems item models with the 'GENERATED' template for items that don't need special rendering
        itemModelGenerators.generateFlatItem(AVItems.COPPER_NUGGET.get(), ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(AVItems.COPPER_BOOTS.get(), ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(AVItems.COPPER_CHESTPLATE.get(), ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(AVItems.COPPER_HELMET.get(), ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(AVItems.COPPER_LEGGINGS.get(), ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(AVItems.ENDERITE_INGOT.get(), ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(AVItems.ENDERITE_BOOTS.get(), ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(AVItems.ENDERITE_CHESTPLATE.get(), ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(AVItems.ENDERITE_HELMET.get(), ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(AVItems.ENDERITE_LEGGINGS.get(), ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(AVItems.ENDERITE_SHARD.get(), ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(AVItems.ENDERITE_UPGRADE_SMITHING_TEMPLATE.get(), ModelTemplates.FLAT_ITEM);

        // generateFlatItems item models with the 'HANDHELD' template for tools and weapons
        itemModelGenerators.generateFlatItem(AVItems.COPPER_AXE.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModelGenerators.generateFlatItem(AVItems.COPPER_HOE.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModelGenerators.generateFlatItem(AVItems.COPPER_PICKAXE.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModelGenerators.generateFlatItem(AVItems.COPPER_SHOVEL.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModelGenerators.generateFlatItem(AVItems.COPPER_SWORD.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModelGenerators.generateFlatItem(AVItems.ENDERITE_AXE.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModelGenerators.generateFlatItem(AVItems.ENDERITE_HOE.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModelGenerators.generateFlatItem(AVItems.ENDERITE_PICKAXE.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModelGenerators.generateFlatItem(AVItems.ENDERITE_SHOVEL.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModelGenerators.generateFlatItem(AVItems.ENDERITE_SWORD.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
    }
}
