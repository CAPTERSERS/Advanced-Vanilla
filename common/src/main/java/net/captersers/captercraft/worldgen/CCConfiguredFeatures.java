package net.captersers.captercraft.worldgen;

import net.captersers.captercraft.CCMod;
import net.captersers.captercraft.registry.CCBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockMatchTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;

import java.util.List;

/**
 * Configured Features for mod
 * This class handles the configuration of world generation features like ores and structures.
 *
 * @author Captersers Team
 * @since 1.0.0
 */
public class CCConfiguredFeatures {

    /**
     * Registry key for the Void Shard ore feature
     * This feature generates void shard ores in the End dimension.
     */
    public static final ResourceKey<ConfiguredFeature<?, ?>> VOID_SHARD = resourceKey("void_shard");

    /**
     * Creates a registry key for a configured feature
     *
     * @param name The name of the feature
     * @return A registry key for the configured feature
     *
     * @see ResourceKey
     * @see Registries#CONFIGURED_FEATURE
     */
    private static ResourceKey<ConfiguredFeature<?, ?>> resourceKey(String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, CCMod.id(name));
    }

    /**
     * Registers a configured feature with the given parameters
     *
     * @param context The registration context
     * @param key The registry key for the feature
     * @param feature The feature to register
     * @param featureConfig The configuration for the feature
     * @param <FC> The feature configuration type
     * @param <F> The feature type
     *
     * @see ConfiguredFeature
     * @see Feature
     * @see OreConfiguration
     */
    private static <FC extends OreConfiguration, F extends Feature<FC>> void register(BootstrapContext<ConfiguredFeature<?, ?>> context, ResourceKey<ConfiguredFeature<?, ?>> key, F feature, FC featureConfig) {
        context.register(key, new ConfiguredFeature<>(feature, featureConfig));
    }

    /**
     * Bootstrap method to register all configured features,
     * This method is called during mod initialization to set up world generation features.
     *
     * @param context The registration context
     * @see BootstrapContext
     * @see ConfiguredFeature
     */
    public static void bootstrap(BootstrapContext<ConfiguredFeature<?, ?>> context) {

        // Rule test for End Stone blocks - allows void shards to generate in End Stone
        RuleTest endStoneRule = new BlockMatchTest(Blocks.END_STONE);

        // Default state for the Void Shard block
        BlockState voidShardDefaultState = CCBlocks.VOID_SHARD.get().defaultBlockState();

        // List of ore generation targets - where and what to generate
        List<OreConfiguration.TargetBlockState> endOreTargets = List.of(OreConfiguration.target(endStoneRule, voidShardDefaultState));

        // Register the Void Shard ore feature with size 3 (veins of 3 blocks)
        register(context, VOID_SHARD, Feature.ORE, new OreConfiguration(endOreTargets, 3));
    }
}