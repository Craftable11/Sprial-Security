package com.github.sprial404.ss.item;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import com.github.sprial404.ss.block.ModBlocks;
import com.github.sprial404.ss.lib.ItemIds;
import com.github.sprial404.ss.lib.Strings;

import cpw.mods.fml.common.registry.GameRegistry;

/**
 * Sprial-Security
 * 
 * ModItems
 * 
 * @author Sprial404
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class ModItems {

    /* Mod item instances */
    public static Item gems;
    public static Item battery;

    public static void init() {
        /* Initialize each mod item individually */
        gems = new ItemGem(ItemIds.GEM);
        battery = new ItemBattery(ItemIds.BATTERY);
        
        for (int i = 0; i < Strings.GEM_NAMES.length; i++) {
            GameRegistry.addRecipe(new ItemStack(ModBlocks.gemBlock, 1, i), new Object[] { "iii", "iii", "iii", Character.valueOf('i'), new ItemStack(gems, 1, i) });
            GameRegistry.addShapelessRecipe(new ItemStack(gems, 9, i), new Object[] { new ItemStack(ModBlocks.gemBlock, 1, i) });
        }
    }
}
