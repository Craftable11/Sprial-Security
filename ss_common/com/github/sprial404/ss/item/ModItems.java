package com.github.sprial404.ss.item;

import net.minecraft.item.Item;

import com.github.sprial404.ss.lib.ItemIds;

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
    }
}
