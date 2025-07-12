package net.captersers.captercraft.tags;

import net.captersers.captercraft.CCMod;
import net.minecraft.core.registries.Registries;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;

/**
 * Utility class for managing block tags in the mod.
 * This class provides centralized access to custom block tags that define
 * specific properties or behaviors for blocks in the mod.
 *
 * @author Captersers Team
 * @since 1.0.0
 */
public class CCBlockTags {

    /**
     * Tag for blocks that are incorrect or unsuitable for mining with copper tools.
     * Blocks tagged with this will break slower or not at all when mined with copper tools.
     */
    public static final TagKey<Block> INCORRECT_FOR_COPPER_TOOL = register("incorrect_for_copper_tool");

    /**
     * Tag for blocks that are incorrect or unsuitable for mining with enderite tools.
     * Blocks tagged with this will break slower or not at all when mined with enderite tools.
     */
    public static final TagKey<Block> INCORRECT_FOR_ENDERITE_TOOL = register("incorrect_for_enderite_tool");

    /**
     * Registers a new {@link TagKey} for a {@link Block} using the specified name.
     * This method creates a tag key that can be used to identify and group blocks
     * with similar properties or behaviors.
     *
     * @param name The name used to create the {@link TagKey}. It should be a unique identifier.
     * @return A {@link TagKey} associated with the specified name for {@link Block}s in the registry.
     */
    private static TagKey<Block> register(String name) {
        return TagKey.create(Registries.BLOCK, CCMod.id(name));
    }
}