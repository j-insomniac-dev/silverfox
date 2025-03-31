package dev.insomniacdev.silverfox.datagen;

import dev.insomniacdev.silverfox.Silverfox;
import dev.insomniacdev.silverfox.registry.ModBlocks;
import dev.insomniacdev.silverfox.registry.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    private static final List<ItemLike> SILVER_SMELTABLES = List.of(
            ModItems.RAW_SILVER.get(), ModBlocks.SILVER_ORE.get(), ModBlocks.DEEPSLATE_SILVER_ORE.get(), ModBlocks.MOON_SILVER_ORE.get());

    public ModRecipeProvider(PackOutput pOutput) {
        super(pOutput);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> pWriter) {
        oreSmelting(pWriter, SILVER_SMELTABLES, RecipeCategory.MISC, ModItems.SILVER_INGOT.get(), 0.25f, 200, "silver");
        oreBlasting(pWriter, SILVER_SMELTABLES, RecipeCategory.MISC, ModItems.SILVER_INGOT.get(), 0.25f, 100, "silver");

        compressFullRecipe(pWriter, ModBlocks.SILVER_STORAGE_BLOCK.get(), ModItems.SILVER_INGOT.get(), RecipeCategory.BUILDING_BLOCKS, ModItems.SILVER_INGOT.get());
        compressFullRecipe(pWriter, ModBlocks.RAW_SILVER_STORAGE_BLOCK.get(), ModItems.RAW_SILVER.get(), RecipeCategory.BUILDING_BLOCKS, ModItems.RAW_SILVER.get());
        compressFullRecipe(pWriter, ModItems.SILVER_INGOT.get(), ModItems.SILVER_NUGGET.get(), RecipeCategory.MISC, ModItems.SILVER_INGOT.get());
        decompressRecipe(pWriter, ModItems.SILVER_INGOT.get(), 9, ModBlocks.SILVER_STORAGE_BLOCK.get(), RecipeCategory.MISC, ModItems.SILVER_INGOT.get());
        decompressRecipe(pWriter, ModItems.SILVER_NUGGET.get(), 9, ModItems.SILVER_INGOT.get(), RecipeCategory.MISC, ModItems.SILVER_INGOT.get());
        decompressRecipe(pWriter, ModItems.RAW_SILVER.get(), 9, ModBlocks.RAW_SILVER_STORAGE_BLOCK.get(), RecipeCategory.MISC, ModItems.SILVER_INGOT.get());

    }

    // Crafts 9 items into 1 item (e.g. ingots -> block)
    protected static void compressFullRecipe(Consumer<FinishedRecipe> finishedRecipeConsumer, ItemLike result, ItemLike input,
                                             RecipeCategory category, ItemLike unlockedBy) {
        ShapedRecipeBuilder.shaped(category, result)
                .pattern("###")
                .pattern("###")
                .pattern("###")
                .define('#', input)
                .unlockedBy(getHasName(unlockedBy), has(unlockedBy))
                .save(finishedRecipeConsumer, result.asItem() + "_from_" + input.asItem());
    }

    // Crafts 1 item into `count` items (e.g. block -> ingots)
    protected static void decompressRecipe(Consumer<FinishedRecipe> finishedRecipeConsumer, ItemLike result, int count, ItemLike input,
                                           RecipeCategory category, ItemLike unlockedBy) {
        ShapelessRecipeBuilder.shapeless(category, result, count)
                .requires(input)
                .unlockedBy(getHasName(unlockedBy), has(unlockedBy))
                .save(finishedRecipeConsumer, result.asItem() + "_from_" + input.asItem());
    }

    protected static void oreSmelting(Consumer<FinishedRecipe> pFinishedRecipeConsumer, List<ItemLike> pIngredients,
                                      RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTIme, String pGroup) {

        oreCooking(pFinishedRecipeConsumer, RecipeSerializer.SMELTING_RECIPE, pIngredients, pCategory, pResult, pExperience, pCookingTIme, pGroup, "_from_smelting");
    }

    protected static void oreBlasting(Consumer<FinishedRecipe> pFinishedRecipeConsumer, List<ItemLike> pIngredients,
                                      RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup) {

        oreCooking(pFinishedRecipeConsumer, RecipeSerializer.BLASTING_RECIPE, pIngredients, pCategory, pResult, pExperience, pCookingTime, pGroup, "_from_blasting");
    }

    protected static void oreCooking(Consumer<FinishedRecipe> pFinishedRecipeConsumer, RecipeSerializer<? extends AbstractCookingRecipe> pCookingSerializer,
                                     List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup, String pRecipeName) {

        Iterator var9 = pIngredients.iterator();

        while(var9.hasNext()) {
            ItemLike itemlike = (ItemLike)var9.next();
            SimpleCookingRecipeBuilder.generic(Ingredient.of(new ItemLike[]{itemlike}), pCategory, pResult, pExperience, pCookingTime, pCookingSerializer)
                    .group(pGroup).unlockedBy(getHasName(itemlike), has(itemlike))
                    .save(pFinishedRecipeConsumer, Silverfox.MODID + ":" + getItemName(pResult) + pRecipeName + "_" + getItemName(itemlike));
        }

    }
}
