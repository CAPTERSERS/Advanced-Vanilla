package net.captersers.advanced_vanilla.fabric.datagen.providers;

import net.captersers.advanced_vanilla.registry.AVBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.core.HolderLookup;

import java.util.concurrent.CompletableFuture;

/**
 * Provider for generating block loot tables in the Advanced Vanilla mod.
 * This class extends {@link FabricBlockLootTableProvider} to define custom loot drop behaviors
 * for blocks registered in {@link AVBlocks}.
 *
 * @author Advanced Vanilla Team
 * @since 1.0.0
 */
public class AVFabricBlockLootTableProvider extends FabricBlockLootTableProvider {

    /**
     * Initializes the provider with the specified data output and registry wrapper lookup.
     * This provider is responsible for generating loot table data for blocks in the mod.
     *
     * @param output The {@link FabricDataOutput} instance used to handle the output of generated loot table data.
     * @param completableFuture A {@link CompletableFuture} providing the {@link HolderLookup.Provider} used for managing
     *                          block registration and lookup during loot table generation.
     */
    public AVFabricBlockLootTableProvider(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> completableFuture) {
        super(output, completableFuture);
    }

    /**
     * Generates the necessary loot tables for the blocks defined in the mod.
     *
     * <p>Current blocks with loot tables:</p>
     * <ul>
     *   <li>{@link AVBlocks#MEDIUM_WEIGHTED_PRESSURE_PLATE} - Medium weighted pressure plate</li>
     *   <li>{@link AVBlocks#BLOCK_OF_ENDERITE} - Block of enderite</li>
     *   <li>{@link AVBlocks#VOID_SHARD} - Void shard</li>
     * </ul>
     */
    @Override
    public void generate() {

        // Loot table for blocks that drop themselves when broken
        dropSelf(AVBlocks.MEDIUM_WEIGHTED_PRESSURE_PLATE.get());
        dropSelf(AVBlocks.BLOCK_OF_ENDERITE.get());
        dropSelf(AVBlocks.VOID_SHARD.get());
    }
}