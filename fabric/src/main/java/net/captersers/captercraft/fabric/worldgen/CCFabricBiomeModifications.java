package net.captersers.captercraft.fabric.worldgen;

import net.captersers.captercraft.CCMod;
import net.captersers.captercraft.worldgen.CCPlacedFeatures;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.world.level.levelgen.GenerationStep;

/**
 * Handles biome modifications for world generation features.
 * This class is responsible for adding custom world generation features to specific biomes.
 *
 * @author Captersers Team
 * @since 1.0.0
 */
public class CCFabricBiomeModifications {

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
        CCMod.LOGGER.info("Registering worldgen features for biomes...");

        // Add Void Shard generation to End biomes
        BiomeModifications.addFeature(
                BiomeSelectors.foundInTheEnd(),
                GenerationStep.Decoration.UNDERGROUND_ORES,
                CCPlacedFeatures.VOID_SHARD_PLACED
        );

        // Log successful registration with generation details
        CCMod.LOGGER.info("Worldgen features registered successfully!");
        CCMod.LOGGER.info("Void Shard will generate in End biomes with 2 veins per chunk, size 3, height 0-128");
    }
}