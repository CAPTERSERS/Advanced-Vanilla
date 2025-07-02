package net.captersers.advanced_vanilla.registry;

import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.captersers.advanced_vanilla.AVMod;
import net.captersers.advanced_vanilla.item.AVArmorMaterials;
import net.captersers.advanced_vanilla.item.AVSmithingTemplateItem;
import net.captersers.advanced_vanilla.item.AVTiers;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.*;

import java.util.function.Supplier;

public class AVItems {

    private static final DeferredRegister<Item> ITEMS = DeferredRegister.create(AVMod.MOD_ID, Registries.ITEM);

    public static final RegistrySupplier<Item> BLOCK_OF_ENDERITE = register("block_of_enderite",
            () -> new BlockItem(AVBlocks.BLOCK_OF_ENDERITE.get(), new Item.Properties().fireResistant()));
    public static final RegistrySupplier<Item> MEDIUM_WEIGHTED_PRESSURE_PLATE = register("medium_weighted_pressure_plate",
            () -> new BlockItem(AVBlocks.MEDIUM_WEIGHTED_PRESSURE_PLATE.get(), new Item.Properties()));
    public static final RegistrySupplier<Item> VOID_SHARD = register("void_shard",
            () -> new BlockItem(AVBlocks.VOID_SHARD.get(), new Item.Properties().fireResistant()));

    public static final RegistrySupplier<Item> COPPER_NUGGET = register("copper_nugget",
            () -> new Item(new Item.Properties()));
    public static final RegistrySupplier<Item> ENDERITE_INGOT = register("enderite_ingot",
            () -> new Item(new Item.Properties().fireResistant()));
    public static final RegistrySupplier<Item> ENDERITE_SHARD = register("enderite_shard",
            () -> new Item(new Item.Properties().fireResistant()));
    public static final RegistrySupplier<Item> ENDERITE_UPGRADE_SMITHING_TEMPLATE = register("enderite_upgrade_smithing_template",
            AVSmithingTemplateItem::createEnderiteUpgradeTemplate);

    // Copper Amor
    public static final RegistrySupplier<Item> COPPER_BOOTS = register("copper_boots",
            () -> new ArmorItem(AVArmorMaterials.COPPER, ArmorItem.Type.BOOTS, new Item.Properties().durability(ArmorItem.Type.BOOTS.getDurability(10))));
    public static final RegistrySupplier<Item> COPPER_CHESTPLATE = register("copper_chestplate",
            () -> new ArmorItem(AVArmorMaterials.COPPER, ArmorItem.Type.CHESTPLATE, new Item.Properties().durability(ArmorItem.Type.CHESTPLATE.getDurability(10))));
    public static final RegistrySupplier<Item> COPPER_HELMET = register("copper_helmet",
            () -> new ArmorItem(AVArmorMaterials.COPPER, ArmorItem.Type.HELMET, new Item.Properties().durability(ArmorItem.Type.HELMET.getDurability(10))));
    public static final RegistrySupplier<Item> COPPER_LEGGINGS = register("copper_leggings",
            () -> new ArmorItem(AVArmorMaterials.COPPER, ArmorItem.Type.LEGGINGS, new Item.Properties().durability(ArmorItem.Type.LEGGINGS.getDurability(10))));

    // Enderite Armor
    public static final RegistrySupplier<Item> ENDERITE_BOOTS = register("enderite_boots",
            () -> new ArmorItem(AVArmorMaterials.ENDERITE, ArmorItem.Type.BOOTS, new Item.Properties().fireResistant().durability(ArmorItem.Type.BOOTS.getDurability(42))));
    public static final RegistrySupplier<Item> ENDERITE_CHESTPLATE = register("enderite_chestplate",
            () -> new ArmorItem(AVArmorMaterials.ENDERITE, ArmorItem.Type.CHESTPLATE, new Item.Properties().fireResistant().durability(ArmorItem.Type.CHESTPLATE.getDurability(42))));
    public static final RegistrySupplier<Item> ENDERITE_HELMET = register("enderite_helmet",
            () -> new ArmorItem(AVArmorMaterials.ENDERITE, ArmorItem.Type.HELMET, new Item.Properties().fireResistant().durability(ArmorItem.Type.HELMET.getDurability(42))));
    public static final RegistrySupplier<Item> ENDERITE_LEGGINGS = register("enderite_leggings",
            () -> new ArmorItem(AVArmorMaterials.ENDERITE, ArmorItem.Type.LEGGINGS, new Item.Properties().fireResistant().durability(ArmorItem.Type.LEGGINGS.getDurability(42))));

    // Copper Tools
    public static final RegistrySupplier<Item> COPPER_AXE = register("copper_axe", () -> new AxeItem(AVTiers.COPPER, new Item.Properties().attributes(AxeItem.createAttributes(AVTiers.COPPER, 6.5F, -3.2F))));
    public static final RegistrySupplier<Item> COPPER_HOE = register("copper_hoe", () -> new HoeItem(AVTiers.COPPER, new Item.Properties().attributes(HoeItem.createAttributes(AVTiers.COPPER, -1.5F, -1.5F))));
    public static final RegistrySupplier<Item> COPPER_PICKAXE = register("copper_pickaxe", () -> new PickaxeItem(AVTiers.COPPER, new Item.Properties().attributes(PickaxeItem.createAttributes(AVTiers.COPPER, 1.0F, -2.8F))));
    public static final RegistrySupplier<Item> COPPER_SHOVEL = register("copper_shovel", () -> new ShovelItem(AVTiers.COPPER, new Item.Properties().attributes(ShovelItem.createAttributes(AVTiers.COPPER, 1.5F, -3.0F))));
    public static final RegistrySupplier<Item> COPPER_SWORD = register("copper_sword", () -> new SwordItem(AVTiers.COPPER, new Item.Properties().attributes(SwordItem.createAttributes(AVTiers.COPPER, 3, -2.4F))));

    public static final RegistrySupplier<Item> ENDERITE_AXE = register("enderite_axe", () -> new AxeItem(AVTiers.ENDERITE, new Item.Properties().fireResistant().attributes(AxeItem.createAttributes(AVTiers.ENDERITE, 5.0F, -2.5F))));
    public static final RegistrySupplier<Item> ENDERITE_HOE = register("enderite_hoe", () -> new HoeItem(AVTiers.ENDERITE, new Item.Properties().fireResistant().attributes(HoeItem.createAttributes(AVTiers.ENDERITE, -4.0F, 1.0F))));
    public static final RegistrySupplier<Item> ENDERITE_PICKAXE = register("enderite_pickaxe", () -> new PickaxeItem(AVTiers.ENDERITE, new Item.Properties().fireResistant().attributes(PickaxeItem.createAttributes(AVTiers.ENDERITE, 1.0F, -2.4F))));
    public static final RegistrySupplier<Item> ENDERITE_SHOVEL = register("enderite_shovel", () -> new ShovelItem(AVTiers.ENDERITE, new Item.Properties().fireResistant().attributes(ShovelItem.createAttributes(AVTiers.ENDERITE, 1.5F, -2.5F))));
    public static final RegistrySupplier<Item> ENDERITE_SWORD = register("enderite_sword", () -> new SwordItem(AVTiers.ENDERITE, new Item.Properties().fireResistant().attributes(SwordItem.createAttributes(AVTiers.ENDERITE, 3, -2.0F))));

    public static void init() {
        ITEMS.register();
    }

    public static RegistrySupplier<Item> register(String name, Supplier<Item> item){
        return ITEMS.register(AVMod.id(name), item);
    }
}
