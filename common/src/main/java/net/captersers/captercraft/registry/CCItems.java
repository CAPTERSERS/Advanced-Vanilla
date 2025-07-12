package net.captersers.captercraft.registry;

import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.captersers.captercraft.CCMod;
import net.captersers.captercraft.item.CCArmorMaterials;
import net.captersers.captercraft.item.CCSmithingTemplateItem;
import net.captersers.captercraft.item.CCTiers;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.*;

import java.util.function.Supplier;

public class CCItems {

    private static final DeferredRegister<Item> ITEMS = DeferredRegister.create(CCMod.MOD_ID, Registries.ITEM);

    public static final RegistrySupplier<Item> BLOCK_OF_ENDERITE = register("block_of_enderite",
            () -> new BlockItem(CCBlocks.BLOCK_OF_ENDERITE.get(), new Item.Properties().fireResistant()));
    public static final RegistrySupplier<Item> MEDIUM_WEIGHTED_PRESSURE_PLATE = register("medium_weighted_pressure_plate",
            () -> new BlockItem(CCBlocks.MEDIUM_WEIGHTED_PRESSURE_PLATE.get(), new Item.Properties()));
    public static final RegistrySupplier<Item> VOID_SHARD = register("void_shard",
            () -> new BlockItem(CCBlocks.VOID_SHARD.get(), new Item.Properties().fireResistant()));

    public static final RegistrySupplier<Item> COPPER_NUGGET = register("copper_nugget",
            () -> new Item(new Item.Properties()));
    public static final RegistrySupplier<Item> ENDERITE_INGOT = register("enderite_ingot",
            () -> new Item(new Item.Properties().fireResistant()));
    public static final RegistrySupplier<Item> ENDERITE_SHARD = register("enderite_shard",
            () -> new Item(new Item.Properties().fireResistant()));
    public static final RegistrySupplier<Item> ENDERITE_UPGRADE_SMITHING_TEMPLATE = register("enderite_upgrade_smithing_template",
            CCSmithingTemplateItem::createEnderiteUpgradeTemplate);

    // Copper Amor
    public static final RegistrySupplier<Item> COPPER_BOOTS = register("copper_boots",
            () -> new ArmorItem(CCArmorMaterials.COPPER, ArmorItem.Type.BOOTS, new Item.Properties().durability(ArmorItem.Type.BOOTS.getDurability(10))));
    public static final RegistrySupplier<Item> COPPER_CHESTPLATE = register("copper_chestplate",
            () -> new ArmorItem(CCArmorMaterials.COPPER, ArmorItem.Type.CHESTPLATE, new Item.Properties().durability(ArmorItem.Type.CHESTPLATE.getDurability(10))));
    public static final RegistrySupplier<Item> COPPER_HELMET = register("copper_helmet",
            () -> new ArmorItem(CCArmorMaterials.COPPER, ArmorItem.Type.HELMET, new Item.Properties().durability(ArmorItem.Type.HELMET.getDurability(10))));
    public static final RegistrySupplier<Item> COPPER_LEGGINGS = register("copper_leggings",
            () -> new ArmorItem(CCArmorMaterials.COPPER, ArmorItem.Type.LEGGINGS, new Item.Properties().durability(ArmorItem.Type.LEGGINGS.getDurability(10))));

    // Enderite Armor
    public static final RegistrySupplier<Item> ENDERITE_BOOTS = register("enderite_boots",
            () -> new ArmorItem(CCArmorMaterials.ENDERITE, ArmorItem.Type.BOOTS, new Item.Properties().fireResistant().durability(ArmorItem.Type.BOOTS.getDurability(42))));
    public static final RegistrySupplier<Item> ENDERITE_CHESTPLATE = register("enderite_chestplate",
            () -> new ArmorItem(CCArmorMaterials.ENDERITE, ArmorItem.Type.CHESTPLATE, new Item.Properties().fireResistant().durability(ArmorItem.Type.CHESTPLATE.getDurability(42))));
    public static final RegistrySupplier<Item> ENDERITE_HELMET = register("enderite_helmet",
            () -> new ArmorItem(CCArmorMaterials.ENDERITE, ArmorItem.Type.HELMET, new Item.Properties().fireResistant().durability(ArmorItem.Type.HELMET.getDurability(42))));
    public static final RegistrySupplier<Item> ENDERITE_LEGGINGS = register("enderite_leggings",
            () -> new ArmorItem(CCArmorMaterials.ENDERITE, ArmorItem.Type.LEGGINGS, new Item.Properties().fireResistant().durability(ArmorItem.Type.LEGGINGS.getDurability(42))));

    // Copper Tools
    public static final RegistrySupplier<Item> COPPER_AXE = register("copper_axe", () -> new AxeItem(CCTiers.COPPER, new Item.Properties().attributes(AxeItem.createAttributes(CCTiers.COPPER, 6.5F, -3.2F))));
    public static final RegistrySupplier<Item> COPPER_HOE = register("copper_hoe", () -> new HoeItem(CCTiers.COPPER, new Item.Properties().attributes(HoeItem.createAttributes(CCTiers.COPPER, -1.5F, -1.5F))));
    public static final RegistrySupplier<Item> COPPER_PICKAXE = register("copper_pickaxe", () -> new PickaxeItem(CCTiers.COPPER, new Item.Properties().attributes(PickaxeItem.createAttributes(CCTiers.COPPER, 1.0F, -2.8F))));
    public static final RegistrySupplier<Item> COPPER_SHOVEL = register("copper_shovel", () -> new ShovelItem(CCTiers.COPPER, new Item.Properties().attributes(ShovelItem.createAttributes(CCTiers.COPPER, 1.5F, -3.0F))));
    public static final RegistrySupplier<Item> COPPER_SWORD = register("copper_sword", () -> new SwordItem(CCTiers.COPPER, new Item.Properties().attributes(SwordItem.createAttributes(CCTiers.COPPER, 3, -2.4F))));

    public static final RegistrySupplier<Item> ENDERITE_AXE = register("enderite_axe", () -> new AxeItem(CCTiers.ENDERITE, new Item.Properties().fireResistant().attributes(AxeItem.createAttributes(CCTiers.ENDERITE, 5.0F, -2.5F))));
    public static final RegistrySupplier<Item> ENDERITE_HOE = register("enderite_hoe", () -> new HoeItem(CCTiers.ENDERITE, new Item.Properties().fireResistant().attributes(HoeItem.createAttributes(CCTiers.ENDERITE, -4.0F, 1.0F))));
    public static final RegistrySupplier<Item> ENDERITE_PICKAXE = register("enderite_pickaxe", () -> new PickaxeItem(CCTiers.ENDERITE, new Item.Properties().fireResistant().attributes(PickaxeItem.createAttributes(CCTiers.ENDERITE, 1.0F, -2.4F))));
    public static final RegistrySupplier<Item> ENDERITE_SHOVEL = register("enderite_shovel", () -> new ShovelItem(CCTiers.ENDERITE, new Item.Properties().fireResistant().attributes(ShovelItem.createAttributes(CCTiers.ENDERITE, 1.5F, -2.5F))));
    public static final RegistrySupplier<Item> ENDERITE_SWORD = register("enderite_sword", () -> new SwordItem(CCTiers.ENDERITE, new Item.Properties().fireResistant().attributes(SwordItem.createAttributes(CCTiers.ENDERITE, 3, -2.0F))));

    public static void init() {
        ITEMS.register();
    }

    public static RegistrySupplier<Item> register(String name, Supplier<Item> item){
        return ITEMS.register(CCMod.id(name), item);
    }
}