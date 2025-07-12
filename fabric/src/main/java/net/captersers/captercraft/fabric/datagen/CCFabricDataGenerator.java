package net.captersers.captercraft.fabric.datagen;

import net.captersers.captercraft.fabric.datagen.providers.*;
import net.captersers.captercraft.worldgen.*;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;

public class CCFabricDataGenerator implements DataGeneratorEntrypoint {

    /**
     * Initializes the data generator and registers all data providers.
     *
     * @param fabricDataGenerator The Fabric data generator instance
     *
     * @see FabricDataGenerator.Pack
     */
    @Override
    public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {

        // Create a new data pack for our mod
        FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

        // Generates loot tables for blocks (what drops when blocks are broken)
        pack.addProvider(CCFabricBlockLootTableProvider::new);

        // Generates block tags (grouping blocks by properties)
        pack.addProvider(CCFabricBlockTagProvider::new);

        // Generates item tags (grouping items by properties)
        pack.addProvider(CCFabricItemTagProvider::new);

        // Generates block and item models (3D models and textures)
        pack.addProvider(CCFabricModelProvider::new);

        // Generates crafting recipes and smelting recipes
        pack.addProvider(CCFabricRecipeProvider::new);

        // Generates world generation data (ore generation, structures)
        pack.addProvider(CCFabricWorldGeneratorProvider::new);
    }

    /**
     * Builds and registers custom registries for world generation features.
     * This method allows us to register our custom configured and placed features.
     *
     * @param registryBuilder The registry builder instance
     */
    @Override
    public void buildRegistry(RegistrySetBuilder registryBuilder) {

        // Register configured features (definition of ores/structures to generate)
        registryBuilder.add(Registries.CONFIGURED_FEATURE, CCConfiguredFeatures::bootstrap);

        // Register placed features (how the features are generated in the world)
        registryBuilder.add(Registries.PLACED_FEATURE, CCPlacedFeatures::bootstrap);
    }
}