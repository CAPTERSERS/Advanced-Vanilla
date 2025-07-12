package net.captersers.captercraft.fabric.datagen.providers;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricDynamicRegistryProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;

import java.util.concurrent.CompletableFuture;

/**
 * World Generator Provider for mod
 * This class handles the generation of world generation data during the data generation process.
 *
 * @author Captersers Team
 * @since 1.0.0
 */
public class CCFabricWorldGeneratorProvider extends FabricDynamicRegistryProvider {

    /**
     * Constructor for the World Generator Provider
     *
     * @param output The data output instance for writing generated data
     * @param registriesFuture A future that will provide access to the registry wrapper lookup
     * @see FabricDataOutput
     * @see HolderLookup.Provider
     * @see CompletableFuture
     */
    public CCFabricWorldGeneratorProvider(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

    /**
     * Configures the world generation data by adding all configured and placed features
     *
     * @param registries The registry wrapper lookup providing access to all registries
     * @param entries    The entry collection where world generation data will be added
     * @see HolderLookup.Provider
     * @see Registries#CONFIGURED_FEATURE
     * @see Registries#PLACED_FEATURE
     */
    @Override
    protected void configure(HolderLookup.Provider registries, Entries entries) {

        // Add all configured features to the data generation output
        entries.addAll(registries.lookupOrThrow(Registries.CONFIGURED_FEATURE));

        // Add all placed features to the data generation output
        entries.addAll(registries.lookupOrThrow(Registries.PLACED_FEATURE));
    }

    /**
     * Returns the name of this data provider for identification purposes
     * This name is used in logs and error messages to identify which provider
     * generated specific data or encountered errors during the data generation process.
     *
     * @return The provider name as a String
     */
    @Override
    public String getName() {
        return "Advanced Vanilla World Generator";
    }
}