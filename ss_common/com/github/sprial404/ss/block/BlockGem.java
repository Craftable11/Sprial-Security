package com.github.sprial404.ss.block;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;

import com.github.sprial404.ss.SprialSecurity;
import com.github.sprial404.ss.lib.Reference;
import com.github.sprial404.ss.lib.Strings;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockGem extends Block {

    @SideOnly(Side.CLIENT)
    private Icon[] icons;

    public BlockGem(int id) {
        super(id, Material.iron);
        this.setUnlocalizedName(Strings.GEM_BLOCK_NAME);
        this.setCreativeTab(SprialSecurity.tabsSS);
        this.setHardness(5.0F);
        this.setResistance(10.0F);
        this.setStepSound(soundMetalFootstep);
    }

    @Override
    public int damageDropped(int meta) {
        return meta;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public Icon getIcon(int side, int meta) {
        if (meta < 0 || meta >= icons.length) {
            meta = 0;
        }

        return icons[meta];
    }

    @Override
    @SuppressWarnings({ "rawtypes", "unchecked" })
    @SideOnly(Side.CLIENT)
    public void getSubBlocks(int id, CreativeTabs creativeTab, List list) {
        for (int i = 0; i < icons.length; i++) {
            list.add(new ItemStack(id, 1, i));
        }
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister iconRegister) {
        icons = new Icon[Strings.GEM_NAMES.length];

        for (int i = 0; i < icons.length; i++) {
            iconRegister.registerIcon(Reference.MOD_ID.toLowerCase() + ":"
                    + Strings.GEM_BLOCK_NAME);
        }
    }
}
