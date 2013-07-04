package com.github.sprial404.ss.block;

import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraftforge.common.MinecraftForge;

import com.github.sprial404.ss.item.ModItems;
import com.github.sprial404.ss.lib.BlockIds;
import com.github.sprial404.ss.lib.Strings;
import com.github.sprial404.ss.lib.ToolClass;

import cpw.mods.fml.common.registry.GameRegistry;

public class ModBlocks {

    /* Mod block instances */
    public static Block plasmaOre;
    public static Block plasmaBlock;
    
    public static void init() {
        plasmaOre = new BlockPlasmaOre(BlockIds.PLASMA_ORE);
        plasmaBlock = new BlockPlasma(BlockIds.PLASMA_BLOCK);
        
        GameRegistry.registerBlock(plasmaOre, Strings.PLASMA_ORE_NAME);
        GameRegistry.registerBlock(plasmaBlock, Strings.PLASMA_BLOCK_NAME);
        
        MinecraftForge.setBlockHarvestLevel(plasmaOre, ToolClass.PICKAXE, 2);
        MinecraftForge.setBlockHarvestLevel(plasmaBlock, ToolClass.PICKAXE, 2);
        
        initBlockRecipes();
    }
    
    private static void initBlockRecipes() {
        GameRegistry.addRecipe(new ItemStack(plasmaBlock), new Object[] { "iii", "iii", "iii", Character.valueOf('i'), ModItems.plasmaIngot });
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.plasmaIngot, 9), new Object[] { new ItemStack(plasmaBlock) });
        FurnaceRecipes.smelting().addSmelting(BlockIds.PLASMA_ORE, new ItemStack(ModItems.plasmaIngot), 1.0F);
    }
}
