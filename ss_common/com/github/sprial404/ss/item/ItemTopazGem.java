package com.github.sprial404.ss.item;

import com.github.sprial404.ss.SprialSecurity;
import com.github.sprial404.ss.lib.Strings;

public class ItemTopazGem extends ItemSS {

    public ItemTopazGem(int id) {
        super(id);
        this.setUnlocalizedName(Strings.TOPAZ_GEM);
        this.setCreativeTab(SprialSecurity.tabsSS);
        this.maxStackSize = 64;
    }

    
}
