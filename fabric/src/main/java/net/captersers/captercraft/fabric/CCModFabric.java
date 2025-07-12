package net.captersers.captercraft.fabric;

import net.captersers.captercraft.CCMod;
import net.captersers.captercraft.fabric.worldgen.CCFabricBiomeModifications;
import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class CCModFabric implements ModInitializer {
    @Override
    public void onInitialize() {

        // Run our common setup.
        CCMod.init();

        // Logger instance for this mod to handle debug and info messages
        Logger LOGGER = LoggerFactory.getLogger(CCMod.MOD_ID);

        // Set up world generation features and biome modifications
        CCFabricBiomeModifications.init();
        LOGGER.info("AVFabricBiomeModifications initialized successfully!");
    }
}
