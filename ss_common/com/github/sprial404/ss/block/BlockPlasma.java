package com.github.sprial404.ss.block;

import com.github.sprial404.ss.SprialSecurity;
import com.github.sprial404.ss.lib.Strings;

import net.minecraft.block.material.Material;

public class BlockPlasma extends BlockSS {

    public BlockPlasma(int id) {
        super(id, Material.iron);
        this.setUnlocalizedName(Strings.PLASMA_BLOCK_NAME);
        this.setCreativeTab(SprialSecurity.tabsSS);
        this.setHardness(5.0F);
        this.setResistance(10.0F);
        this.setStepSound(soundMetalFootstep);
    }

}
