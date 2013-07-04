package com.github.sprial404.ss.item;

import com.github.sprial404.ss.SprialSecurity;
import com.github.sprial404.ss.lib.Strings;

public class ItemPlasmaIngot extends ItemSS {

    public ItemPlasmaIngot(int id) {
        super(id);
        this.setUnlocalizedName(Strings.PLASMA_INGOT_NAME);
        this.setCreativeTab(SprialSecurity.tabsSS);
        maxStackSize = 64;
    }

}
