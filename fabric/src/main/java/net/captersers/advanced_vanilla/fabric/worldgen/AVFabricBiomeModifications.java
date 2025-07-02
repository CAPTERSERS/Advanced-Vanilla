package net.captersers.advanced_vanilla.fabric.worldgen;

import net.captersers.advanced_vanilla.AVMod;
import net.captersers.advanced_vanilla.worldgen.AVPlacedFeatures;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.world.level.levelgen.GenerationStep;

/**
 * Handles biome modifications for world generation features.
 * This class is responsible for adding custom world generation features to specific biomes.
 *
 * @author Advanced Vanilla Team
 * @since 1.0.0
 */
public class AVFabricBiomeModifications {

    /**
     * Initializes and registers world generation features for specific biomes.
     * This method configures where custom blocks and structures will be generated in the world.
     *
     * @see BiomeModifications#addFeature
     * @see BiomeSelectors#foundInTheEnd()
     * @see GenerationStep.Decoration#UNDERGROUND_ORES
     */
    public static void init() {

        // Log the start of worldgen feature registration
        AVMod.LOGGER.info("Registering worldgen features for biomes...");

        // Add Void Shard generation to End biomes
        BiomeModifications.addFeature(
                BiomeSelectors.foundInTheEnd(),
                GenerationStep.Decoration.UNDERGROUND_ORES,
                AVPlacedFeatures.VOID_SHARD
        );

        // Log successful registration with generation details
        AVMod.LOGGER.info("Worldgen features registered successfully!");
        AVMod.LOGGER.info("Void Shard will generate in End biomes with 2 veins per chunk, size 3, height 0-128");
    }
}