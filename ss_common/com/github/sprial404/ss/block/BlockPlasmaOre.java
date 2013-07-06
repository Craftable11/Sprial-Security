package com.github.sprial404.ss.block;

import net.minecraft.block.material.Material;

import com.github.sprial404.ss.SprialSecurity;
import com.github.sprial404.ss.lib.Strings;

public class BlockPlasmaOre extends BlockSS {

    public BlockPlasmaOre(int id) {
        super(id, Material.rock);
        this.setUnlocalizedName(Strings.PLASMA_ORE_NAME);
        this.setCreativeTab(SprialSecurity.tabsSS);
        this.setHardness(3.0F);
        this.setResistance(5.0F);
        this.setStepSound(soundStoneFootstep);
    }
}
