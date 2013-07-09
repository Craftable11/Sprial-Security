package com.github.sprial404.ss.block;

import net.minecraft.block.material.Material;

import com.github.sprial404.ss.SprialSecurity;
import com.github.sprial404.ss.lib.Strings;

/**
 * Sprial-Security
 * 
 * BlockMachineStructure
 * 
 * @author Sprial404
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class BlockMachineStructure extends BlockSS {

    public BlockMachineStructure(int id) {
        super(id, Material.iron);
        this.setUnlocalizedName(Strings.MACHINE_STRUCTURE_NAME);
        this.setCreativeTab(SprialSecurity.tabsSS);
        this.setHardness(5.0F);
        this.setResistance(20.0F);
        this.setStepSound(soundMetalFootstep);
    }
}
