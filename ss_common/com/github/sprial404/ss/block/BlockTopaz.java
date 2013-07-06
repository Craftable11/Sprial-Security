package com.github.sprial404.ss.block;

import com.github.sprial404.ss.SprialSecurity;
import com.github.sprial404.ss.lib.Strings;

import net.minecraft.block.material.Material;

public class BlockTopaz extends BlockSS {

    public BlockTopaz(int id) {
        super(id, Material.iron);
        this.setUnlocalizedName(Strings.TOPAZ_BLOCK);
        this.setCreativeTab(SprialSecurity.tabsSS);
        this.setStepSound(soundMetalFootstep);
        this.setHardness(5.0F);
        this.setResistance(10.0F);
    }
}
