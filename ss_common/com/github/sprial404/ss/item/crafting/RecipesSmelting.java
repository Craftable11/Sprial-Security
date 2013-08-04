package com.github.sprial404.ss.item.crafting;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;

import com.github.sprial404.ss.core.util.EnergyStack;
import com.github.sprial404.ss.item.CustomWrappedStack;
import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;

/**
 * Sprial-Security
 * 
 * RecipesSmelting
 * 
 * @author Sprial404
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class RecipesSmelting {

    private static Multimap<CustomWrappedStack, List<CustomWrappedStack>> smeltingRecipes = null;

    private static final CustomWrappedStack smeltingEnergy = new CustomWrappedStack(
            new EnergyStack(EnergyStack.VANILLA_SMELTING_ENERGY_NAME,
                    EnergyStack.VANILLA_SMELTING_ENERGY_THRESHOLD));

    public static Multimap<CustomWrappedStack, List<CustomWrappedStack>> getSmeltingRecipes() {

        if (smeltingRecipes == null) {
            init();
        }

        return smeltingRecipes;
    }

    private static void init() {
        smeltingRecipes = HashMultimap.create();

        @SuppressWarnings("unchecked")
        Map<Integer, ItemStack> smeltingList = FurnaceRecipes.smelting()
                .getSmeltingList();
        Map<List<Integer>, ItemStack> metaSmeltingList = FurnaceRecipes
                .smelting().getMetaSmeltingList();

        for (Integer i : smeltingList.keySet()) {
            smeltingRecipes.put(new CustomWrappedStack(smeltingList.get(i)),
                    Arrays.asList(smeltingEnergy, new CustomWrappedStack(
                            new ItemStack(i, 1, 0))));
        }

        for (List<Integer> idMetaPair : metaSmeltingList.keySet()) {
            if (idMetaPair.size() == 2) {
                smeltingRecipes
                        .put(new CustomWrappedStack(metaSmeltingList
                                .get(idMetaPair)), Arrays.asList(
                                smeltingEnergy, new CustomWrappedStack(
                                        new ItemStack(idMetaPair.get(0), 1,
                                                idMetaPair.get(1)))));
            }
        }
    }
}
