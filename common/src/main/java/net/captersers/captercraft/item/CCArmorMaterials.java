package net.captersers.captercraft.item;

import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.captersers.captercraft.CCMod;
import net.captersers.captercraft.registry.CCItems;
import net.minecraft.Util;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.Registries;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;

import java.util.EnumMap;
import java.util.List;
import java.util.function.Supplier;

/**
 * Manages custom armor materials for the mod.
 * This class defines and registers new armor material types that can be used to create custom armor sets with specific properties.
 *
 * @author Captersers Team
 * @since 1.0.0
 */
public class CCArmorMaterials {

    private static final DeferredRegister<ArmorMaterial> ARMOR_MATERIALS = DeferredRegister.create(CCMod.MOD_ID, Registries.ARMOR_MATERIAL);

    /**
     * Copper armor material with basic protection values.
     * Provides low-tier armor protection suitable for early game progression.
     *
     * @see Items#COPPER_INGOT
     * @see SoundEvents#ARMOR_EQUIP_GENERIC
     */
    public static final RegistrySupplier<ArmorMaterial> COPPER = register("copper", Util.make(new EnumMap<>(ArmorItem.Type.class), (enumMap) -> {
        enumMap.put(ArmorItem.Type.BOOTS, 1);
        enumMap.put(ArmorItem.Type.LEGGINGS, 3);
        enumMap.put(ArmorItem.Type.CHESTPLATE, 4);
        enumMap.put(ArmorItem.Type.HELMET, 2);
        enumMap.put(ArmorItem.Type.BODY, 3);
    }), 8, SoundEvents.ARMOR_EQUIP_IRON, 0.0F, 0.0F, () -> Ingredient.of(Items.COPPER_INGOT));

    /**
     * Enderite armor material with high-end protection values.
     * Provides superior armor protection suitable for end-game content.
     *
     * @see CCItems#ENDERITE_INGOT
     * @see SoundEvents#ARMOR_EQUIP_NETHERITE
     */
    public static final RegistrySupplier<ArmorMaterial> ENDERITE = register("enderite",
            Util.make(new EnumMap<>(ArmorItem.Type.class), (enumMap) -> {
                enumMap.put(ArmorItem.Type.BOOTS, 4);
                enumMap.put(ArmorItem.Type.LEGGINGS, 7);
                enumMap.put(ArmorItem.Type.CHESTPLATE, 9);
                enumMap.put(ArmorItem.Type.HELMET, 4);
                enumMap.put(ArmorItem.Type.BODY, 12);
            }), 18, SoundEvents.ARMOR_EQUIP_NETHERITE, 4.5F, 0.2F, () ->
                    Ingredient.of(CCItems.ENDERITE_INGOT.get()));

    /**
     * Registers a new armor material in the Minecraft registry system.
     * Creates and configures an ArmorMaterial instance with the specified properties.
     *
     * @param name The registry name for the armor material
     * @param defense Defense values for each armor piece
     * @param enchantmentValue The enchantability modifier
     * @param equipSound The sound played when equipping the armor
     * @param toughness The armor toughness value
     * @param knockbackResistance The knockback resistance value
     * @param repairIngredient The ingredient used to repair the armor
     * @return A registry entry containing the registered armor material
     *
     * @see ArmorMaterial
     * @see Holder
     * @see Registry#register
     * @see CCMod#id(String)
     */
    private static RegistrySupplier<ArmorMaterial> register(String name, EnumMap<ArmorItem.Type, Integer> defense, int enchantmentValue, Holder<SoundEvent> equipSound, float toughness, float knockbackResistance, Supplier<Ingredient> repairIngredient) {
        return ARMOR_MATERIALS.register(name, () -> new ArmorMaterial(
                defense,
                enchantmentValue,
                equipSound,
                repairIngredient,
                List.of(new ArmorMaterial.Layer(CCMod.id(name))),
                toughness,
                knockbackResistance)
        );
    }

    /**
     * Initializes and registers custom armor materials for the Advanced Vanilla mod.
     * This method is responsible for setting up all the predefined armor material types
     * used in the game to ensure they are recognized and available for use.
     *
     * @see #COPPER
     * @see #ENDERITE
     */
    public static void init() {
        ARMOR_MATERIALS.register();
    }
}