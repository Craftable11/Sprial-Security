package com.github.sprial404.ss.creativetab;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

/**
 * Sprial-Security
 * 
 * CreativeTabSS
 * 
 * @author Sprial404
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class CreativeTabSS extends CreativeTabs {

    public CreativeTabSS(int tabID, String tabLabel) {
        super(tabID, tabLabel);
    }

    @Override
    @SideOnly(Side.CLIENT)
    /**
     * the itemID for the item to be displayed on the tab
     */
    public int getTabIconItemIndex() {
        return Item.redstone.itemID;
    }
}
