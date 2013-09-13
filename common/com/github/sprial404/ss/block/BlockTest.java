package com.github.sprial404.ss.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;

public class BlockTest extends Block {

    public BlockTest() {
        super(9059, Material.iron);
        this.setUnlocalizedName("blockTest");
        this.setHardness(3.0F);
        this.setResistance(5.0F);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister par1IconRegister) {
        // TODO Auto-generated method stub
        super.registerIcons(par1IconRegister);
    }
}
