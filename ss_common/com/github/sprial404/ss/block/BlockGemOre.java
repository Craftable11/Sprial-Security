package com.github.sprial404.ss.block;

import java.util.List;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

import com.github.sprial404.ss.SprialSecurity;
import com.github.sprial404.ss.lib.ItemIds;
import com.github.sprial404.ss.lib.Reference;
import com.github.sprial404.ss.lib.Strings;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockGemOre extends Block {

    @SideOnly(Side.CLIENT)
    private Icon[] icons;
    
    public BlockGemOre(int id) {
        super(id, Material.rock);
        this.setUnlocalizedName(Strings.GEM_ORE_NAME);
        this.setCreativeTab(SprialSecurity.tabsSS);
        this.setHardness(3.0F);
        this.setResistance(5.0F);
        this.setStepSound(soundStoneFootstep);
    }
    
    @Override
    public int idDropped(int par1, Random rand, int par3) {
        return ItemIds.GEM;
    }
    
    @Override
    public int damageDropped(int meta) {
        return meta;
    }
    
    @Override
    public int quantityDropped(int meta, int fortune, Random rand) {
        if (meta < 0 || meta >= this.icons.length)
            meta = 0;
        
        if (meta == 0)
            return 2 + fortune < 1 ? 0 : rand.nextInt(3);
        else if (meta == 1 || meta == 3 || meta == 6)
            return 1 + fortune < 3 ? 0 : rand.nextInt(1);
        else if (meta == 2)
            return 1;
        else if (meta == 4)
            return 1;
        else if (meta == 5)
            return 2 + fortune < 2 ? 0 : rand.nextInt(2);
        else if (meta == 7)
            return 1;
        else if (meta == 8)
            return 1;
        else
            return 1;
    }
    
    @Override
    public void dropBlockAsItemWithChance(World world, int x, int y, int z, int meta, float par6, int fortune) {
        super.dropBlockAsItemWithChance(world, x, y, z, meta, par6, fortune);
        
        if (meta < 0 || meta >= this.icons.length)
            meta = 0;
        
        int xp = 0;
        
        if (meta == 0)
            xp = MathHelper.getRandomIntegerInRange(world.rand, 2, 3);
        else if (meta == 1 | meta == 3)
            xp = MathHelper.getRandomIntegerInRange(world.rand, 3, 5);
        else if (meta == 2)
            xp = 1;
        else if (meta == 4)
            xp = MathHelper.getRandomIntegerInRange(world.rand, 4, 6);
        else if (meta == 5)
            xp = MathHelper.getRandomIntegerInRange(world.rand, 2, 5);
        else if (meta == 6)
            xp = MathHelper.getRandomIntegerInRange(world.rand, 1, 4);
        else if (meta == 7)
            xp = MathHelper.getRandomIntegerInRange(world.rand, 2, 4);
        else if (meta == 8)
            xp = 1;
        else
            xp = 1;
        
        this.dropXpOnBlockBreak(world, x, y, z, xp);
    }
    
    @Override
    @SideOnly(Side.CLIENT)
    public Icon getIcon(int side, int meta) {
        if (meta < 0 || meta >= this.icons.length)
            meta = 0;

        return this.icons[meta];
    }
    
    @Override
    @SuppressWarnings({ "rawtypes", "unchecked" })
    @SideOnly(Side.CLIENT)
    public void getSubBlocks(int id, CreativeTabs creativeTab, List list) {
        for (int i = 0; i < icons.length; i++)
            list.add(new ItemStack(id, 1, i));
    }
    
    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister iconRegister) {
        icons = new Icon[Strings.GEM_NAMES.length];
        
        for (int i = 0; i < icons.length; i++)
            iconRegister.registerIcon(Reference.MOD_ID.toLowerCase() + ":" + Strings.GEM_ORE_NAME);
    }
}
