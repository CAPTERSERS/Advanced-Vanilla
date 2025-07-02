package net.captersers.advanced_vanilla.fabric;

import net.captersers.advanced_vanilla.AVMod;
import net.captersers.advanced_vanilla.fabric.worldgen.AVFabricBiomeModifications;
import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class AVModFabric implements ModInitializer {

    @Override
    public void onInitialize() {

        // Run our common setup.
        AVMod.init();

        // Logger instance for this mod to handle debug and info messages
        Logger LOGGER = LoggerFactory.getLogger(AVMod.MOD_ID);

        // Set up world generation features and biome modifications
        AVFabricBiomeModifications.init();
        LOGGER.info("AVFabricBiomeModifications initialized successfully!");
    }
}
