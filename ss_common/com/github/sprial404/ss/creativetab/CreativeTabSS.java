package com.github.sprial404.ss.creativetab;

import com.github.sprial404.ss.lib.ItemIds;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.creativetab.CreativeTabs;

public class CreativeTabSS extends CreativeTabs {

    public CreativeTabSS(int par1, String par2Str) {
        super(par1, par2Str);
    }
    
    @Override
    @SideOnly(Side.CLIENT)
    /**
     * the itemID for the item to be displayed on the tab
     */
    public int getTabIconItemIndex() {
        return ItemIds.PLASMA_INGOT;
    }
}
