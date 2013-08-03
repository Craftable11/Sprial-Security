package com.github.sprial404.ss.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;

import com.github.sprial404.ss.SprialSecurity;
import com.github.sprial404.ss.lib.Reference;
import com.github.sprial404.ss.lib.Strings;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

/**
 * Sprial-Security
 * 
 * BlockMachineStructure
 * 
 * @author Sprial404
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class BlockMachineStructure extends Block {

    public BlockMachineStructure(int id) {
        super(id, Material.iron);
        this.setUnlocalizedName(Strings.MACHINE_STRUCTURE_NAME);
        this.setCreativeTab(SprialSecurity.tabsSS);
        this.setHardness(5.0F);
        this.setResistance(20.0F);
        this.setStepSound(soundMetalFootstep);
    }
    
    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister iconRegister) {
        iconRegister.registerIcon(Reference.MOD_ID.toLowerCase() + ":" + Strings.MACHINE_STRUCTURE_NAME);
    }
}
