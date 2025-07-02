package net.captersers.advanced_vanilla.registry;

import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.DeferredSupplier;
import net.captersers.advanced_vanilla.AVMod;
import net.minecraft.Util;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;


public class AVCreativeModeTabs {
    // DeferredRegister for tabs
    private static final DeferredRegister<CreativeModeTab> TABS = DeferredRegister.create(AVMod.MOD_ID, Registries.CREATIVE_MODE_TAB);

    private static final Component TITLE = Component.translatable(Util.makeDescriptionId("category", AVMod.id("tab")));

    // Tabs
    public static DeferredSupplier<CreativeModeTab> ADVANCED_VANILLA_TAB = TABS.register("advanced_vanilla_tab", () -> CreativeModeTab.builder(CreativeModeTab.Row.TOP, 0)
            .title(TITLE)
            .icon(() -> new ItemStack(AVBlocks.BLOCK_OF_ENDERITE.get()))
            .displayItems((itemDisplayParameters, output) -> {
                // Building Blocks
                output.accept(AVBlocks.BLOCK_OF_ENDERITE.get());
                // Natural Blocks
                output.accept(AVBlocks.VOID_SHARD.get());
                // Redstone Blocks
                output.accept(AVBlocks.MEDIUM_WEIGHTED_PRESSURE_PLATE.get());
                // Tools & Utilities
                output.accept(AVItems.COPPER_SHOVEL.get());
                output.accept(AVItems.COPPER_PICKAXE.get());
                output.accept(AVItems.COPPER_AXE.get());
                output.accept(AVItems.COPPER_HOE.get());
                output.accept(AVItems.ENDERITE_SHOVEL.get());
                output.accept(AVItems.ENDERITE_PICKAXE.get());
                output.accept(AVItems.ENDERITE_AXE.get());
                output.accept(AVItems.ENDERITE_HOE.get());
                // Combat
                output.accept(AVItems.COPPER_SWORD.get());
                output.accept(AVItems.ENDERITE_SWORD.get());
                output.accept(AVItems.COPPER_HELMET.get());
                output.accept(AVItems.COPPER_CHESTPLATE.get());
                output.accept(AVItems.COPPER_LEGGINGS.get());
                output.accept(AVItems.COPPER_BOOTS.get());
                output.accept(AVItems.ENDERITE_HELMET.get());
                output.accept(AVItems.ENDERITE_CHESTPLATE.get());
                output.accept(AVItems.ENDERITE_LEGGINGS.get());
                output.accept(AVItems.ENDERITE_BOOTS.get());
                // Ingredients
                output.accept(AVItems.COPPER_NUGGET.get());
                output.accept(AVItems.ENDERITE_SHARD.get());
                output.accept(AVItems.ENDERITE_INGOT.get());
                output.accept(AVItems.ENDERITE_UPGRADE_SMITHING_TEMPLATE.get());
            })
            .build());

    public static void init() {
        TABS.register();
    }
}
