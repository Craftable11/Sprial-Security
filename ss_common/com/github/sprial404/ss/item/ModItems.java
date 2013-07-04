package com.github.sprial404.ss.item;

import com.github.sprial404.ss.lib.ItemIds;

import net.minecraft.item.Item;


public class ModItems {

    /* Mod item instances */
    public static Item plasmaIngot;
    public static Item plasmaCell;
    
    public static void init() {
        /* Initialize each mod item individually */
        plasmaIngot = new ItemPlasmaIngot(ItemIds.PLASMA_INGOT);
        plasmaCell = new ItemPlasmaCell(ItemIds.PLASMA_CELL);
    }
}
