package com.github.sprial404.ss.block;

import net.minecraft.block.Block;
import net.minecraftforge.common.MinecraftForge;

import com.github.sprial404.ss.item.ItemBlockGemOre;
import com.github.sprial404.ss.lib.BlockIds;
import com.github.sprial404.ss.lib.Strings;
import com.github.sprial404.ss.lib.ToolClass;

import cpw.mods.fml.common.registry.GameRegistry;

/**
 * Sprial-Security
 * 
 * ModBlocks
 * 
 * @author Sprial404
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class ModBlocks {

    /* Mod block instances */
    public static Block gemOre;
    public static Block machineStructure;
    
    public static void init() {
        gemOre = new BlockGemOre(BlockIds.GEM_ORE);
        machineStructure = new BlockMachineStructure(BlockIds.MACHINE_STRUCTURE);
        
        GameRegistry.registerBlock(gemOre, ItemBlockGemOre.class, Strings.GEM_ORE_NAME);
        GameRegistry.registerBlock(machineStructure, Strings.MACHINE_STRUCTURE_NAME);
        
        MinecraftForge.setBlockHarvestLevel(gemOre, ToolClass.PICKAXE, 2);
        MinecraftForge.setBlockHarvestLevel(machineStructure, ToolClass.PICKAXE, 2);
        
        initBlockRecipes();
    }
    
    private static void initBlockRecipes() {
    }
}
