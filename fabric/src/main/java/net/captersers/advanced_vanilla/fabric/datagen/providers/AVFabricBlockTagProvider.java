package net.captersers.advanced_vanilla.fabric.datagen.providers;

import net.captersers.advanced_vanilla.registry.AVBlocks;
import net.captersers.advanced_vanilla.tags.AVBlockTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Blocks;

import java.util.concurrent.CompletableFuture;

/**
 * Block Tag Provider for mod
 * This class generates block tags that define various properties and behaviors
 * for blocks in the mod, such as mining requirements and tool compatibility.
 *
 * @author Advanced Vanilla Team
 * @since 1.0.0
 */
public class AVFabricBlockTagProvider extends FabricTagProvider.BlockTagProvider {

    /**
     * Constructor for the Block Tag Provider
     *
     * @param output The data output for generating tags
     * @param completableFuture Future containing registry wrapper lookup
     */
    public AVFabricBlockTagProvider(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> completableFuture) {
        super(output, completableFuture);
    }

    /**
     * Configures all block tags for the mod
     * This method defines which blocks require specific tools, which tools are incorrect
     * for certain blocks, and which blocks can be mined with specific tools.
     *
     * @param lookup Registry wrapper lookup for accessing block registries
     */
    @Override
    public void addTags(HolderLookup.Provider lookup) {

        // Create tags for blocks that cannot be mined efficiently with copper tools
        getOrCreateTagBuilder(AVBlockTags.INCORRECT_FOR_COPPER_TOOL)
                // Vanilla blocks that are too hard for copper tools
                .add(Blocks.ANCIENT_DEBRIS)
                .add(Blocks.DEEPSLATE_DIAMOND_ORE)
                .add(Blocks.DEEPSLATE_EMERALD_ORE)
                .add(Blocks.DIAMOND_ORE)
                .add(Blocks.DIAMOND_BLOCK)
                .add(Blocks.EMERALD_ORE)
                .add(Blocks.EMERALD_BLOCK)
                .add(Blocks.NETHERITE_BLOCK)
                .add(Blocks.OBSIDIAN)
                // Mod blocks that are too hard for copper tools
                .add(AVBlocks.BLOCK_OF_ENDERITE.get())
                .add(AVBlocks.VOID_SHARD.get());

        // Create tag for blocks that cannot be mined efficiently with enderite tools
        getOrCreateTagBuilder(AVBlockTags.INCORRECT_FOR_ENDERITE_TOOL);

        // Create tags for blocks that require diamond or better tools to mine
        getOrCreateTagBuilder(BlockTags.NEEDS_DIAMOND_TOOL)
                // Mod blocks that require diamond tools
                .add(AVBlocks.BLOCK_OF_ENDERITE.get())
                .add(AVBlocks.VOID_SHARD.get());

        // Create tags for blocks that require stone or better tools to mine
        getOrCreateTagBuilder(BlockTags.NEEDS_STONE_TOOL)
                // Mod blocks that require stone tools
                .add(AVBlocks.MEDIUM_WEIGHTED_PRESSURE_PLATE.get());

        // Create tags for blocks that can be mined with pickaxes
        getOrCreateTagBuilder(BlockTags.MINEABLE_WITH_PICKAXE)
                // Mod blocks that are mineable with pickaxes
                .add(AVBlocks.BLOCK_OF_ENDERITE.get())
                .add(AVBlocks.MEDIUM_WEIGHTED_PRESSURE_PLATE.get())
                .add(AVBlocks.VOID_SHARD.get());
    }
}
