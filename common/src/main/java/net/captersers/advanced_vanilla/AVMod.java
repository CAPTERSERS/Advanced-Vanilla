package net.captersers.advanced_vanilla;

import net.captersers.advanced_vanilla.item.AVArmorMaterials;
import net.captersers.advanced_vanilla.registry.AVBlocks;
import net.captersers.advanced_vanilla.registry.AVCreativeModeTabs;
import net.captersers.advanced_vanilla.registry.AVItems;
import net.minecraft.resources.ResourceLocation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class AVMod {

    /** The unique identifier for mod */
    public static final String MOD_ID = "advanced_vanilla";

    /** Logger instance for this mod to handle debug and info messages */
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    public static void init() {
        LOGGER.info("Initializing Advanced Vanilla mod...");

        // Initialize all custom blocks and their properties
        AVBlocks.init();
        LOGGER.info("AVBlocks initialized successfully!");

        // Initialize all custom items (tools, armor, materials)
        AVItems.init();
        LOGGER.info("AVItems initialized successfully!");

        // Set up creative inventory item groups and categories
        AVCreativeModeTabs.init();
        LOGGER.info("AVCreativeModeTabs initialized successfully!");

        // Configure custom armor material properties and durability
        AVArmorMaterials.init();
        LOGGER.info("AVArmorMaterials initialized successfully!");

        LOGGER.info("Advanced Vanilla mod initialization completed!");


    }

    public static ResourceLocation id(String path) {
        return ResourceLocation.fromNamespaceAndPath(AVMod.MOD_ID, path);
    }
}