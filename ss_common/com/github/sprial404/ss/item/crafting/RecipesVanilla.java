package com.github.sprial404.ss.item.crafting;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.item.crafting.IRecipe;

import com.github.sprial404.ss.core.util.RecipeHelper;
import com.github.sprial404.ss.item.CustomWrappedStack;
import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;

/**
 * Sprial-Security
 * 
 * RecipesVanilla
 * 
 * @author Sprial404
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class RecipesVanilla {

    private static Multimap<CustomWrappedStack, List<CustomWrappedStack>> vanillaRecipes = null;

    ArrayList<CustomWrappedStack> discoveredItems = new ArrayList<CustomWrappedStack>();

    public static Multimap<CustomWrappedStack, List<CustomWrappedStack>> getVanillaRecipes() {

        if (vanillaRecipes == null) {
            init();
        }

        return vanillaRecipes;
    }

    private static void init() {

        vanillaRecipes = HashMultimap.create();

        for (Object recipeObject : CraftingManager.getInstance().getRecipeList()) {

            if (recipeObject instanceof IRecipe) {

                IRecipe recipe = (IRecipe) recipeObject;
                ItemStack recipeOutput = recipe.getRecipeOutput();

                if (recipeOutput != null) {
                    ArrayList<CustomWrappedStack> recipeInputs = RecipeHelper.getRecipeInputs(recipe);
                    vanillaRecipes.put(new CustomWrappedStack(recipeOutput), recipeInputs);
                }
            }
        }
    }
}
