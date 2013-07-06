package com.github.sprial404.ss.item;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import com.github.sprial404.ss.block.ModBlocks;
import com.github.sprial404.ss.lib.ItemIds;

import cpw.mods.fml.common.registry.GameRegistry;

public class ModItems {

    /* Mod item instances */
    public static Item topazGem;
    
    public static void init() {
        /* Initialize each mod item individually */
        topazGem = new ItemTopazGem(ItemIds.TOPAZ_GEM);
        
        GameRegistry.addRecipe(new ItemStack(ModBlocks.topazBlock), new Object[] { "TTT", "TTT", "TTT", Character.valueOf('T'), topazGem });
        GameRegistry.addShapelessRecipe(new ItemStack(topazGem, 9), new Object[] { new ItemStack(ModBlocks.topazBlock) });
    }
}
