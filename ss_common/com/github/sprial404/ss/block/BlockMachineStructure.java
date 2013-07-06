package com.github.sprial404.ss.block;

import com.github.sprial404.ss.SprialSecurity;
import com.github.sprial404.ss.lib.Strings;

import net.minecraft.block.material.Material;

public class BlockMachineStructure extends BlockSS {

    public BlockMachineStructure(int id) {
        super(id, Material.iron);
        this.setUnlocalizedName(Strings.MACHINE_STRUCTURE);
        this.setCreativeTab(SprialSecurity.tabsSS);
        this.setHardness(5.0F);
        this.setResistance(20.0F);
        this.setStepSound(soundMetalFootstep);
    }
}
