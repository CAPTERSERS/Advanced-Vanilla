package net.captersers.captercraft;

import net.captersers.captercraft.item.*;
import net.captersers.captercraft.registry.*;
import net.minecraft.resources.ResourceLocation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class CCMod {

    /** The unique identifier for mod */
    public static final String MOD_ID = "captercraft";

    /** Logger instance for this mod to handle debug and info messages */
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    public static void init() {
        LOGGER.info("Initializing Advanced Vanilla mod...");

        // Initialize all custom blocks and their properties
        CCBlocks.init();
        LOGGER.info("AVBlocks initialized successfully!");

        // Initialize all custom items (tools, armor, materials)
        CCItems.init();
        LOGGER.info("AVItems initialized successfully!");

        // Set up creative inventory item groups and categories
        CCCreativeModeTabs.init();
        LOGGER.info("AVCreativeModeTabs initialized successfully!");

        // Configure custom armor material properties and durability
        CCArmorMaterials.init();
        LOGGER.info("AVArmorMaterials initialized successfully!");

        LOGGER.info("Advanced Vanilla mod initialization completed!");
    }

    public static ResourceLocation id(String path) {
        return ResourceLocation.fromNamespaceAndPath(CCMod.MOD_ID, path);
    }
}