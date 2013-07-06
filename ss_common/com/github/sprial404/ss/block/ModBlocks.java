package com.github.sprial404.ss.block;

import net.minecraft.block.Block;
import net.minecraftforge.common.MinecraftForge;

import com.github.sprial404.ss.lib.BlockIds;
import com.github.sprial404.ss.lib.Strings;
import com.github.sprial404.ss.lib.ToolClass;

import cpw.mods.fml.common.registry.GameRegistry;

public class ModBlocks {

    /* Mod block instances */
    public static Block topazOre;
    public static Block topazBlock;
    public static Block machineStructure;
    
    public static void init() {
        topazOre = new BlockTopazOre(BlockIds.TOPAZ_ORE);
        topazBlock = new BlockTopaz(BlockIds.TOPAZ_BLOCK);
        machineStructure = new BlockMachineStructure(BlockIds.MACHINE_STRUCTURE);
        
        GameRegistry.registerBlock(topazOre, Strings.TOPAZ_ORE);
        GameRegistry.registerBlock(topazBlock, Strings.TOPAZ_BLOCK);
        GameRegistry.registerBlock(machineStructure, Strings.MACHINE_STRUCTURE);
        
        MinecraftForge.setBlockHarvestLevel(topazOre, ToolClass.PICKAXE, 2);
        MinecraftForge.setBlockHarvestLevel(topazBlock, ToolClass.PICKAXE, 2);
        MinecraftForge.setBlockHarvestLevel(machineStructure, ToolClass.PICKAXE, 2);
        
        initBlockRecipes();
    }
    
    private static void initBlockRecipes() {
    }
}
