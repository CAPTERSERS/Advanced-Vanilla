package net.captersers.captercraft.fabric.datagen.providers;

import net.captersers.captercraft.CCMod;
import net.captersers.captercraft.registry.CCBlocks;
import net.captersers.captercraft.registry.CCItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.fabricmc.fabric.api.tag.convention.v2.ConventionalItemTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.recipes.*;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * Recipe Provider for mod
 * This class generates all crafting, smelting, and smithing recipes for the mod.
 *
 * @author Captersers Team
 * @since 1.0.0
 */
public class CCFabricRecipeProvider extends FabricRecipeProvider {

    /**
     * Constructor for the recipe provider
     *
     * @param output The data output for generating recipes
     * @param completableFuture Future for registry wrapper lookup
     */
    public CCFabricRecipeProvider(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> completableFuture) {
        super(output, completableFuture);
    }

    /**
     * This method is called by the data generation system to create all recipe JSON files.
     *
     * @param exporter The recipe exporter that handles writing recipe files
     */
    @Override
    public void buildRecipes(RecipeOutput exporter) {

        // Compacting recipes (nuggets to ingots and vice versa)
        offerReversibleCompactingRecipesWithReverseRecipeGroup(exporter, RecipeCategory.MISC, CCItems.COPPER_NUGGET.get(), RecipeCategory.MISC, Items.COPPER_INGOT, "copper_nuggets_from_copper_ingot");
        offerReversibleCompactingRecipesWithReverseRecipeGroup(exporter, RecipeCategory.MISC, CCItems.ENDERITE_INGOT.get(), RecipeCategory.BUILDING_BLOCKS, CCBlocks.BLOCK_OF_ENDERITE.get(), "enderite_ingot_from_enderite_block");

        // Furnace recipes for smelting and blasting
        offerFurnaceRecipe(exporter, List.of(
                CCItems.COPPER_HELMET.get(),
                CCItems.COPPER_CHESTPLATE.get(),
                CCItems.COPPER_LEGGINGS.get(),
                CCItems.COPPER_BOOTS.get(),
                CCItems.COPPER_AXE.get(),
                CCItems.COPPER_PICKAXE.get(),
                CCItems.COPPER_SHOVEL.get(),
                CCItems.COPPER_HOE.get(),
                CCItems.COPPER_SWORD.get()), RecipeCategory.MISC, CCItems.COPPER_NUGGET.get(), 0.7F, 200, 100, "copper_nugget_from_copper_items");

        // Raw block smelting recipes
        offerFurnaceRecipe(exporter, List.of(Items.RAW_COPPER_BLOCK), RecipeCategory.MISC, Items.COPPER_BLOCK, 6.3F, 1800, 900, "ore_block_from_raw_block");
        offerFurnaceRecipe(exporter, List.of(Items.RAW_GOLD_BLOCK), RecipeCategory.MISC, Items.GOLD_BLOCK, 6.3F, 1800, 900, "ore_block_from_raw_block");
        offerFurnaceRecipe(exporter, List.of(Items.RAW_IRON_BLOCK), RecipeCategory.MISC, Items.IRON_BLOCK, 6.3F, 1800, 900, "ore_block_from_raw_block");
        offerFurnaceRecipe(exporter, List.of(CCBlocks.VOID_SHARD.get()), RecipeCategory.MISC, CCItems.ENDERITE_SHARD.get(), 3.0F, 300, 100, "enderite_shard_from_void_shard");

        // Combat category recipes (armor and weapons)
        offerCopperRecipe(RecipeCategory.COMBAT, CCItems.COPPER_BOOTS.get(), 1, Items.COPPER_INGOT, "# #", "# #", "   ", exporter);
        offerCopperRecipe(RecipeCategory.COMBAT, CCItems.COPPER_CHESTPLATE.get(), 1, Items.COPPER_INGOT,"# #", "###", "###", exporter);
        offerCopperRecipe(RecipeCategory.COMBAT, CCItems.COPPER_HELMET.get(), 1, Items.COPPER_INGOT, "###", "# #", "   ", exporter);
        offerCopperRecipe(RecipeCategory.COMBAT, CCItems.COPPER_LEGGINGS.get(), 1, Items.COPPER_INGOT,"###", "# #", "# #", exporter);
        offerCopperToolRecipe(RecipeCategory.COMBAT, CCItems.COPPER_SWORD.get(), "C", "C", "S", exporter);

        // Enderite upgrade recipes (smithing table upgrades)
        offerEnderiteUpgradeRecipe(Items.NETHERITE_BOOTS, RecipeCategory.COMBAT, CCItems.ENDERITE_BOOTS.get(), exporter);
        offerEnderiteUpgradeRecipe(Items.NETHERITE_CHESTPLATE, RecipeCategory.COMBAT, CCItems.ENDERITE_CHESTPLATE.get(), exporter);
        offerEnderiteUpgradeRecipe(Items.NETHERITE_HELMET, RecipeCategory.COMBAT, CCItems.ENDERITE_HELMET.get(), exporter);
        offerEnderiteUpgradeRecipe(Items.NETHERITE_LEGGINGS, RecipeCategory.COMBAT, CCItems.ENDERITE_LEGGINGS.get(), exporter);
        offerEnderiteUpgradeRecipe(Items.NETHERITE_SWORD, RecipeCategory.COMBAT, CCItems.ENDERITE_SWORD.get(), exporter);

        // Misc category recipes
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, CCItems.ENDERITE_INGOT.get(), 1)
                .pattern("DED")
                .pattern("EOE")
                .pattern("DED")
                .define('E', CCItems.ENDERITE_SHARD.get())
                .define('D', Items.DIAMOND)
                .define('O', Items.ENDER_EYE)
                .unlockedBy(hasItem(CCItems.ENDERITE_SHARD.get()), has(CCItems.ENDERITE_SHARD.get()))
                .unlockedBy(hasItem(Items.DIAMOND), has(Items.DIAMOND))
                .unlockedBy(hasItem(Items.ENDER_EYE), has(Items.ENDER_EYE))
                .save(exporter, CCMod.id(hasItem(CCItems.ENDERITE_INGOT.get())));

        // Redstone category recipes
        offerCopperRecipe(RecipeCategory.REDSTONE, CCBlocks.MEDIUM_WEIGHTED_PRESSURE_PLATE.get(), 1, Items.COPPER_INGOT, "##", "  ", "  ", exporter);

        // Tools category recipes
        offerCopperToolRecipe(RecipeCategory.TOOLS, CCItems.COPPER_AXE.get(), "CC", "CS", " S", exporter);
        offerCopperToolRecipe(RecipeCategory.TOOLS, CCItems.COPPER_HOE.get(), "CC", " S", " S", exporter);
        offerCopperToolRecipe(RecipeCategory.TOOLS, CCItems.COPPER_PICKAXE.get(), "CCC", " S ", " S ", exporter);
        offerCopperToolRecipe(RecipeCategory.TOOLS, CCItems.COPPER_SHOVEL.get(), "C", "S", "S", exporter);

        // Enderite tool upgrade recipes
        offerEnderiteUpgradeRecipe(Items.NETHERITE_AXE, RecipeCategory.TOOLS, CCItems.ENDERITE_AXE.get(), exporter);
        offerEnderiteUpgradeRecipe(Items.NETHERITE_HOE, RecipeCategory.TOOLS, CCItems.ENDERITE_HOE.get(), exporter);
        offerEnderiteUpgradeRecipe(Items.NETHERITE_PICKAXE, RecipeCategory.TOOLS, CCItems.ENDERITE_PICKAXE.get(), exporter);
        offerEnderiteUpgradeRecipe(Items.NETHERITE_SHOVEL, RecipeCategory.TOOLS, CCItems.ENDERITE_SHOVEL.get(), exporter);

        // Smithing template copying recipe
        copySmithingTemplate(exporter, CCItems.ENDERITE_UPGRADE_SMITHING_TEMPLATE.get(), Items.END_STONE);
    }

    private static @NotNull String hasItem(@NotNull ItemLike item){
        return "has_" + BuiltInRegistries.ITEM.getKey(item.asItem()).getPath();
    }

    /**
     * Creates a tag-based criterion string for recipe unlocking
     *
     * @param tag The tag to check for
     * @return A formatted string for the criterion
     */
    private static @NotNull String hasTag(@NotNull TagKey<Item> tag) {
        return "has_" + tag.location().toString();
    }

    /**
     * Creates reversible compacting recipes for an item, allowing conversion between a compacted result
     * (e.g., block form) and the original item (e.g., ingot or nugget form).
     *
     * @param output The {@link RecipeOutput} instance used to output the recipes.
     * @param item The original {@link ItemLike} instance from which the compacted form is created.
     * @param result The {@link ItemLike} instance representing the compacted form of the item.
     * @param name A string name used to generate the recipe identifiers.
     */
    protected static void offerReversibleCompactingRecipesWithReverseRecipeGroup(RecipeOutput output, RecipeCategory category, ItemLike item, RecipeCategory categoryCompress, ItemLike result, String name) {

        // Generate a recipe for compressing item into block
        ShapedRecipeBuilder.shaped(categoryCompress, result)
                .pattern("###")
                .pattern("###")
                .pattern("###")
                .define('#', item)
                .unlockedBy("has_" + BuiltInRegistries.ITEM.getKey(item.asItem()).getPath(), has(item))
                .save(output, CCMod.id(name + "_compress"));

        // Generate a recipe for uncompressing block into item
        ShapelessRecipeBuilder.shapeless(category, item, 9)
                .requires(result)
                .unlockedBy("has_" + BuiltInRegistries.ITEM.getKey(result.asItem()).getPath(), has(result))
                .save(output, CCMod.id(name + "_uncompress"));
    }

    /**
     * Creates an enderite upgrade recipe using the smithing table
     * This method generates a smithing transform recipe that upgrades netherite items to enderite.
     *
     * @param input The base item to upgrade (netherite item)
     * @param category The recipe category
     * @param output The upgraded item (enderite item)
     * @param exporter The recipe exporter
     *
     * @see SmithingTransformRecipeBuilder
     * @see CCItems#ENDERITE_UPGRADE_SMITHING_TEMPLATE
     * @see CCItems#ENDERITE_INGOT
     */
    protected static void offerEnderiteUpgradeRecipe(ItemLike input, RecipeCategory category, ItemLike output, RecipeOutput exporter) {
        SmithingTransformRecipeBuilder.smithing(Ingredient.of(CCItems.ENDERITE_UPGRADE_SMITHING_TEMPLATE.get()), Ingredient.of(input), Ingredient.of(CCItems.ENDERITE_INGOT.get()), category, output.asItem())
                .unlocks(hasItem(CCItems.ENDERITE_INGOT.get()), has(CCItems.ENDERITE_INGOT.get()))
                .save(exporter, CCMod.id(hasItem(output)));
    }

    /**
     * Creates a shaped crafting recipe for copper items
     * This method generates a 3x3 crafting grid recipe with the specified pattern.
     *
     * @param category The recipe category
     * @param output The item to craft
     * @param count The number of items to produce
     * @param input The input material (copper ingot)
     * @param patternOne First row of the crafting pattern
     * @param patternTwo Second row of the crafting pattern
     * @param patternThree Third row of the crafting pattern
     * @param exporter The recipe exporter
     *
     * @see ShapedRecipeBuilder
     * @see Items#COPPER_INGOT
     */
    protected static void offerCopperRecipe(RecipeCategory category, ItemLike output, int count, ItemLike input, String patternOne, String patternTwo, String patternThree, RecipeOutput exporter) {
        ShapedRecipeBuilder.shaped(category, output, count)
                .define('#', input)
                .pattern(patternOne)
                .pattern(patternTwo)
                .pattern(patternThree)
                .unlockedBy(hasItem(input), has(input))
                .save(exporter, CCMod.id(hasItem(output)));
    }

    /**
     * Creates a shaped crafting recipe for copper tools
     * This method generates tool recipes that require copper ingots and wooden rods.
     *
     * @param category The recipe category
     * @param output The tool to craft
     * @param patternOne First row of the crafting pattern
     * @param patternTwo Second row of the crafting pattern
     * @param patternThree Third row of the crafting pattern
     * @param exporter The recipe exporter
     *
     * @see ShapedRecipeBuilder
     * @see Items#COPPER_INGOT
     * @see ConventionalItemTags#WOODEN_RODS
     */
    private static void offerCopperToolRecipe(RecipeCategory category, ItemLike output, String patternOne, String patternTwo, String patternThree, RecipeOutput exporter) {
        ShapedRecipeBuilder.shaped(category, output, 1)
                .define('C', Items.COPPER_INGOT)
                .define('S', ConventionalItemTags.WOODEN_RODS)
                .pattern(patternOne)
                .pattern(patternTwo)
                .pattern(patternThree)
                .unlockedBy(hasItem(Items.COPPER_INGOT), has(Items.COPPER_INGOT))
                .unlockedBy(hasTag(ConventionalItemTags.WOODEN_RODS), has(ConventionalItemTags.WOODEN_RODS))
                .save(exporter, CCMod.id(hasItem(output)));
    }

    /**
     * Creates both smelting and blasting recipes for the same inputs
     * This method generates both furnace smelting and blast furnace blasting recipes.
     * Blasting recipes cook faster but require a blast furnace.
     *
     * @param exporter The recipe exporter
     * @param inputs List of items that can be smelted/blasted
     * @param category The recipe category
     * @param output The resulting item
     * @param experience Experience points gained from the recipe
     * @param cookingTime Base cooking time for smelting
     * @param cookingTimeReduction Time reduction for blasting (faster cooking)
     * @param group The recipe group name
     *
     * @see RecipeProvider#oreBlasting
     * @see RecipeProvider#oreSmelting
     */
    protected static void offerFurnaceRecipe(RecipeOutput exporter, List<ItemLike> inputs, RecipeCategory category, ItemLike output, float experience, int cookingTime, int cookingTimeReduction, String group) {

        // Recipes for oreBlasting (blast furnace - faster cooking)
        oreBlasting(exporter, inputs, category, output, experience, cookingTime - cookingTimeReduction, group);

        // Recipes for oreSmelting (regular furnace - slower cooking)
        oreSmelting(exporter, inputs, category, output, experience, cookingTime, group);
    }
}