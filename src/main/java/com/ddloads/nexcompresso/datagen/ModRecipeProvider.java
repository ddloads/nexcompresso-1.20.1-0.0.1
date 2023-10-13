package com.ddloads.nexcompresso.datagen;

import com.ddloads.nexcompresso.NexCompresso;
import com.ddloads.nexcompresso.block.ModBlocks;
import com.ddloads.nexcompresso.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

import java.util.List;
import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public ModRecipeProvider(PackOutput pOutput) {
        super(pOutput);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> pWriter) {
        // For Compressed Dust Block: Assuming it's made from 9 Dust items in a 3x3 pattern
        addShapedRecipe(pWriter,RecipeCategory.BUILDING_BLOCKS , ModBlocks.COMPRESSED_COBBLESTONE.get(), "DDD", "DDD", "DDD", 'D', Items.COBBLESTONE);
        addShapedRecipe(pWriter,RecipeCategory.BUILDING_BLOCKS , ModBlocks.COMPRESSED_GRAVEL.get(), "DDD", "DDD", "DDD", 'D', Items.GRAVEL);
        addShapedRecipe(pWriter,RecipeCategory.BUILDING_BLOCKS , ModBlocks.COMPRESSED_DIRT.get(), "DDD", "DDD", "DDD", 'D', Items.DIRT);
        addShapedRecipe(pWriter,RecipeCategory.BUILDING_BLOCKS , ModBlocks.COMPRESSED_SAND.get(), "DDD", "DDD", "DDD", 'D', Items.SAND);
        addShapedRecipe(pWriter,RecipeCategory.BUILDING_BLOCKS , ModBlocks.SKY_STONE_BLOCK.get(), "DDD", "DDD", "DDD", 'D', ModItems.SKY_STONE.get());

        // For Crude Sieve: Assuming it's made from 8 sticks in an O-shape
        addShapedRecipe(pWriter, RecipeCategory.MISC, ModBlocks.CRUDE_SIEVE.get(), "S S", "S S", "SSS", 'S', Items.STICK);

        // For Flint Mesh Module: Assuming it's a piece of flint surrounded by iron ingots
        //addModuleRecipe(pWriter, ModItems.FLINT_MESH_MODULE.get(), 'F', Items.FLINT, 'I', Items.IRON_INGOT);

        // For Skystone Hammer: Assuming a T-shaped Skystone head with a stick handle
        addToolRecipe(pWriter, ModItems.STONE_HAMMER.get(), 'H', Items.STICK, 'M', Items.COBBLESTONE);
        addToolRecipe(pWriter, ModItems.IRON_HAMMER.get(), 'H', Items.STICK, 'M', Items.IRON_INGOT);
        addToolRecipe(pWriter, ModItems.DIAMOND_HAMMER.get(), 'H', Items.STICK, 'M', Items.DIAMOND);
        addToolRecipe(pWriter, ModItems.SKY_STONE_HAMMER.get(), 'H', Items.STICK, 'M', ModItems.SKY_STONE.get());

    }

    protected static void oreSmelting(Consumer<FinishedRecipe> pFinishedRecipeConsumer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTIme, String pGroup) {
        oreCooking(pFinishedRecipeConsumer, RecipeSerializer.SMELTING_RECIPE, pIngredients, pCategory, pResult, pExperience, pCookingTIme, pGroup, "_from_smelting");
    }

    protected static void oreBlasting(Consumer<FinishedRecipe> pFinishedRecipeConsumer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup) {
        oreCooking(pFinishedRecipeConsumer, RecipeSerializer.BLASTING_RECIPE, pIngredients, pCategory, pResult, pExperience, pCookingTime, pGroup, "_from_blasting");
    }

    protected static void oreCooking(Consumer<FinishedRecipe> pFinishedRecipeConsumer, RecipeSerializer<? extends AbstractCookingRecipe> pCookingSerializer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup, String pRecipeName) {
        for(ItemLike itemlike : pIngredients) {
            SimpleCookingRecipeBuilder.generic(Ingredient.of(itemlike), pCategory, pResult,
                    pExperience, pCookingTime, pCookingSerializer)
                    .group(pGroup).unlockedBy(getHasName(itemlike), has(itemlike))
                    .save(pFinishedRecipeConsumer, NexCompresso.MOD_ID + ":" + getItemName(pResult) + pRecipeName + "_" + getItemName(itemlike));
        }

    }


    private void addShapedRecipe(Consumer<FinishedRecipe> pWriter,RecipeCategory pCategory, ItemLike result, String pattern1, String pattern2, String pattern3, char symbol, ItemLike ingredient) {
        ShapedRecipeBuilder.shaped(pCategory,result)
                .pattern(pattern1)
                .pattern(pattern2)
                .pattern(pattern3)
                .define(symbol, ingredient)
                .unlockedBy(getHasName(ingredient), has(ingredient))
                .save(pWriter);
    }

    private void addShapelessRecipe(Consumer<FinishedRecipe> pWriter,RecipeCategory pCategory, ItemLike result, ItemLike... ingredients) {
        ShapelessRecipeBuilder.shapeless(pCategory,result)
                .requires(ingredients)
                .unlockedBy(getHasName(result), has(result))
                .save(pWriter);
    }

    private void addToolRecipe(Consumer<FinishedRecipe> pWriter, ItemLike pResult, char handle, ItemLike handleItem, char head, ItemLike headItem) {
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS,pResult)
                .pattern("MMM")
                .pattern("MHM")
                .pattern(" H ")
                .define('M', headItem)
                .define('H', handleItem)
                .unlockedBy(getHasName(handleItem), has(handleItem))
                .unlockedBy(getHasName(headItem), has(headItem))
                .save(pWriter);
    }

    private void addModuleRecipe(Consumer<FinishedRecipe> pWriter, ItemLike result, char core, ItemLike coreItem, char casing, ItemLike casingItem) {
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC,result)
                .pattern("CCC")
                .pattern("CXC")
                .pattern("CCC")
                .define('X', coreItem)
                .define('C', casingItem)
                .unlockedBy(getHasName(coreItem), has(coreItem))
                .unlockedBy(getHasName(casingItem), has(casingItem))
                .save(pWriter);
    }

}
