package net.captersers.captercraft.registry;

import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.DeferredSupplier;
import net.captersers.captercraft.CCMod;
import net.minecraft.Util;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class CCCreativeModeTabs {

    // DeferredRegister for tabs
    private static final DeferredRegister<CreativeModeTab> TABS = DeferredRegister.create(CCMod.MOD_ID, Registries.CREATIVE_MODE_TAB);

    private static final Component TITLE = Component.translatable(Util.makeDescriptionId("category", CCMod.id("tab")));

    // Tabs
    public static DeferredSupplier<CreativeModeTab> CAPTERCRAFT_TAB = TABS.register("captercraft", () -> CreativeModeTab.builder(CreativeModeTab.Row.TOP, 0)
            .title(TITLE)
            .icon(() -> new ItemStack(CCBlocks.BLOCK_OF_ENDERITE.get()))
            .displayItems((itemDisplayParameters, output) -> {
                // Building Blocks
                output.accept(CCBlocks.BLOCK_OF_ENDERITE.get());
                // Natural Blocks
                output.accept(CCBlocks.VOID_SHARD.get());
                // Redstone Blocks
                output.accept(CCBlocks.MEDIUM_WEIGHTED_PRESSURE_PLATE.get());
                // Tools & Utilities
                output.accept(CCItems.COPPER_SHOVEL.get());
                output.accept(CCItems.COPPER_PICKAXE.get());
                output.accept(CCItems.COPPER_AXE.get());
                output.accept(CCItems.COPPER_HOE.get());
                output.accept(CCItems.ENDERITE_SHOVEL.get());
                output.accept(CCItems.ENDERITE_PICKAXE.get());
                output.accept(CCItems.ENDERITE_AXE.get());
                output.accept(CCItems.ENDERITE_HOE.get());
                // Combat
                output.accept(CCItems.COPPER_SWORD.get());
                output.accept(CCItems.ENDERITE_SWORD.get());
                output.accept(CCItems.COPPER_HELMET.get());
                output.accept(CCItems.COPPER_CHESTPLATE.get());
                output.accept(CCItems.COPPER_LEGGINGS.get());
                output.accept(CCItems.COPPER_BOOTS.get());
                output.accept(CCItems.ENDERITE_HELMET.get());
                output.accept(CCItems.ENDERITE_CHESTPLATE.get());
                output.accept(CCItems.ENDERITE_LEGGINGS.get());
                output.accept(CCItems.ENDERITE_BOOTS.get());
                // Ingredients
                output.accept(CCItems.COPPER_NUGGET.get());
                output.accept(CCItems.ENDERITE_SHARD.get());
                output.accept(CCItems.ENDERITE_INGOT.get());
                output.accept(CCItems.ENDERITE_UPGRADE_SMITHING_TEMPLATE.get());
            })
            .build());

    public static void init() {
        TABS.register();
    }
}