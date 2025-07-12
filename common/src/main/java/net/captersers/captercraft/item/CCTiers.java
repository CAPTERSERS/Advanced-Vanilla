package net.captersers.captercraft.item;

import net.captersers.captercraft.registry.CCItems;
import net.captersers.captercraft.tags.CCBlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.Block;
import org.jetbrains.annotations.NotNull;

/**
 * Enumeration that defines custom tool material tiers for the mod.
 * This enum implements {@link Tier} to provide custom tool properties including durability, mining speed, attack damage, enchantability, and repair ingredients.
 *
 * @author Captersers Team
 * @since 1.0.0
 */
public enum CCTiers implements Tier {

    /**
     * Copper tier
     * <p>Properties:</p>
     * <ul>
     *     <li>Durability: 180 uses</li>
     *     <li>Mining Speed: 5.0x multiplier</li>
     *     <li>Attack Damage: +1.5 damage</li>
     *     <li>Enchantability: 8 (moderate enchantment quality)</li>
     *     <li>Repair Material: {@link Items#COPPER_INGOT}</li>
     *     <li>Incorrect Blocks: {@link CCBlockTags#INCORRECT_FOR_COPPER_TOOL}</li>
     * </ul>
     */
    COPPER(CCBlockTags.INCORRECT_FOR_COPPER_TOOL, 180, 5.0F, 1.5F, 8, Ingredient.of(Items.COPPER_INGOT)),

    /**
     * Enderite tier
     * <p>Properties:</p>
     * <ul>
     *     <li>Durability: 3120 uses (very high)</li>
     *     <li>Mining Speed: 10.0x multiplier (very fast)</li>
     *     <li>Attack Damage: +5.0 damage (high damage)</li>
     *     <li>Enchantability: 18 (excellent enchantment quality)</li>
     *     <li>Repair Material: {@link CCItems#ENDERITE_INGOT}</li>
     *     <li>Incorrect Blocks: {@link CCBlockTags#INCORRECT_FOR_ENDERITE_TOOL}</li>
     * </ul>
     */
    ENDERITE(CCBlockTags.INCORRECT_FOR_ENDERITE_TOOL, 3120, 10.0F, 5.0F, 18, Ingredient.of(CCItems.ENDERITE_INGOT.get()));

    /** The base attack damage bonus for this tool tier */
    private final float damage;

    /** The enchantability value determining enchantment quality */
    private final int enchantmentValue;

    /** Tag specifying blocks that don't drop properly with this tool tier */
    private final TagKey<Block> incorrectBlocksForDrops;

    /** The ingredient used to repair tools of this tier in an anvil */
    private final Ingredient repairIngredient;

    /** The mining speed multiplier for this tool tier */
    private final float speed;

    /** The total durability (number of uses) for this tool tier */
    private final int uses;

    /**
     * Constructs a new tool material tier with the specified properties.
     *
     * @param incorrectBlockForDrops A {@link TagKey<Block>} specifying blocks that this tool tier
     *                                cannot harvest properly. These blocks will not drop their
     *                                intended loot when mined with tools of this tier.
     * @param uses The total number of uses (durability) before the tool breaks.
     * @param speed The mining speed multiplier. Higher values mean faster block breaking
     *              for blocks the tool is effective against.
     * @param damage The base attack damage bonus added to the tool's weapon damage.
     * @param enchantmentValue The enchantability value. Higher values result in better
     *                         and more numerous enchantments when enchanting.
     * @param repairIngredient The {@link Ingredient} used to repair tools of this tier
     *                         in an anvil. This determines what materials can be used
     *                         to restore durability.
     */
    CCTiers(TagKey<Block> incorrectBlockForDrops, int uses, float speed, float damage, int enchantmentValue, Ingredient repairIngredient) {
        this.incorrectBlocksForDrops = incorrectBlockForDrops;
        this.uses = uses;
        this.speed = speed;
        this.damage = damage;
        this.enchantmentValue = enchantmentValue;
        this.repairIngredient = repairIngredient;
    }

    /**
     * Returns the total durability (number of uses) for this tool tier.
     * This value represents how many times the tool can be used before it breaks.
     * Higher durability means the tool lasts longer during gameplay.
     *
     * @return The durability value representing the number of uses before the tool breaks.
     */

    public int getUses() {
        return this.uses;
    }

    /**
     * Returns the mining speed multiplier for this tool tier.
     * This value determines how quickly the tool breaks blocks it is effective against.
     * The speed is multiplied by the base breaking speed of the block type.
     *
     * @return The efficiency value representing how quickly the tool breaks blocks it is effective against.
     */

    public float getSpeed() {
        return this.speed;
    }

    /**
     * Returns the base attack damage bonus for this tool tier.
     * This value is added to the tool's base weapon damage when used in combat.
     * Higher values result in more powerful attacks.
     *
     * @return The attack damage bonus value for this tool tier, which is added to the tool's base damage.
     */

    public float getAttackDamageBonus() {
        return this.damage;
    }

    /**
     * Returns the tag specifying blocks that this tool tier cannot harvest properly.
     * Blocks in this tag will not drop their intended loot when mined with tools
     * of this tier. This is used to prevent players from collecting valuable resources
     * with inappropriate tools.
     *
     * @return A {@link TagKey<Block>} specifying the blocks categorized as incorrect for drops with this tool tier.
     */

    public @NotNull TagKey<Block> getIncorrectBlocksForDrops() {
        return this.incorrectBlocksForDrops;
    }

    /**
     * Returns the enchantability value for this tool tier.
     * The enchantability value determines the quality and quantity of enchantments
     * that can be applied to tools created with this tier. Higher values result
     * in better enchantments and more enchantment options.
     *
     * @return The enchantability value of the tool tier.
     */

    public int getEnchantmentValue() {
        return this.enchantmentValue;
    }

    /**
     * Returns the repair ingredient for this tool tier.
     * This ingredient is used in an anvil to repair tools made from this tier.
     * The ingredient determines what materials can be used to restore durability
     * to damaged tools.
     *
     * @return An {@link Ingredient} representing the material used to repair tools of this tier.
     */

    public @NotNull Ingredient getRepairIngredient() {
        return this.repairIngredient;
    }
}