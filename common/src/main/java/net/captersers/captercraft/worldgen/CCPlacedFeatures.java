package net.captersers.captercraft.worldgen;

import net.captersers.captercraft.CCMod;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.*;

import java.util.List;

/**
 * Manages the placement of world generation features for the mod.
 * This class handles how configured features are placed in the world, including
 * placement modifiers like count, height range, and biome restrictions.
 *
 * @author Captersers Team
 * @since 1.0.0
 */
public class CCPlacedFeatures {

    /**
     * Registry key for the void shard placed feature.
     * This feature determines how void shards are distributed in the world.
     */
    public static final ResourceKey<PlacedFeature> VOID_SHARD_PLACED = registerKey("void_shard_placed");

    /**
     * Creates a registry key for a placed feature with the given name.
     *
     * @param name The name of the placed feature
     * @return A registry key for the placed feature
     *
     * @see ResourceKey
     */
    private static ResourceKey<PlacedFeature> registerKey(String name) {
        return ResourceKey.create(Registries.PLACED_FEATURE, CCMod.id(name));
    }

    /**
     * Registers a placed feature with the given configuration and placement modifiers.
     * This method creates a new PlacedFeature and registers it in the game's registry.
     *
     * @param context The registerable context for placing features
     * @param key The registry key for the placed feature
     * @param config The configured feature to be placed
     * @param modifiers The list of placement modifiers
     *
     * @see BootstrapContext
     * @see PlacedFeature
     * @see PlacementModifier
     */
    private static void register(BootstrapContext<PlacedFeature> context, ResourceKey<PlacedFeature> key, Holder<ConfiguredFeature<?, ?>> config, List<PlacementModifier> modifiers) {
        context.register(key, new PlacedFeature(config, List.copyOf(modifiers)));
    }

    /**
     * Bootstraps all placed features for the mod.
     * This method is called during mod initialization to register all placed features
     * with their respective configurations and placement modifiers.
     *
     * @param context The registerable context for placing features
     *
     * @see BootstrapContext
     * @see CCConfiguredFeatures
     */
    public static void bootstrap(BootstrapContext<PlacedFeature> context) {

        // Get the registry lookup for configured features
        HolderGetter<ConfiguredFeature<?, ?>> configuredFeatures = context.lookup(Registries.CONFIGURED_FEATURE);

        // Register void shard placed feature with 2 attempts per chunk, uniform distribution from Y=0 to Y=128o
        register(context, VOID_SHARD_PLACED, configuredFeatures.getOrThrow(CCConfiguredFeatures.VOID_SHARD),
                Modifiers.modifiersCount(2, HeightRangePlacement.uniform(VerticalAnchor.absolute(0), VerticalAnchor.absolute(128)))
        );
    }

    /**
     * Utility class containing helper methods for creating common placement modifier combinations.
     * These methods simplify the creation of standard placement modifier lists used throughout the mod.
     *
     * @see PlacementModifier
     */
    public static class Modifiers {

        /**
         * Creates a standard list of placement modifiers with count and height modifiers.
         * This includes square placement (for chunk-based distribution), height range, and biome placement.
         *
         * @param countModifier The modifier that controls how many features to place
         * @param heightModifier The modifier that controls the height range for placement
         * @return A list of placement modifiers
         *
         * @see CountPlacement
         * @see HeightRangePlacement
         * @see InSquarePlacement
         * @see BiomeFilter
         */
        public static List<PlacementModifier> modifiers(PlacementModifier countModifier, PlacementModifier heightModifier) {
            return List.of(countModifier, InSquarePlacement.spread(), heightModifier, BiomeFilter.biome());
        }

        /**
         * Creates placement modifiers with a fixed count of features per chunk.
         *
         * @param count The number of features to attempt to place per chunk
         * @param heightModifier The modifier that controls the height range for placement
         * @return A list of placement modifiers
         *
         * @see CountPlacement
         */
        public static List<PlacementModifier> modifiersCount(int count, PlacementModifier heightModifier) {
            return modifiers(CountPlacement.of(count), heightModifier);
        }
    }
}