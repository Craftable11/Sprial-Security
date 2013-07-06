package com.github.sprial404.ss.block;

import java.util.Random;

import net.minecraft.block.material.Material;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

import com.github.sprial404.ss.SprialSecurity;
import com.github.sprial404.ss.lib.ItemIds;
import com.github.sprial404.ss.lib.Strings;

public class BlockTopazOre extends BlockSS {
    
    public BlockTopazOre(int id) {
        super(id, Material.rock);
        this.setUnlocalizedName(Strings.TOPAZ_ORE);
        this.setCreativeTab(SprialSecurity.tabsSS);
        this.setStepSound(soundStoneFootstep);
        this.setHardness(3.0F);
        this.setResistance(5.0F);
    }
    
    @Override
    public int idDropped(int par1, Random par2Random, int par3) {
        return ItemIds.TOPAZ_GEM;
    }
    
    @Override
    public int quantityDropped(Random par1Random) {
        return  1 + par1Random.nextInt(3);
    }
    
    @Override
    public int quantityDroppedWithBonus(int par1, Random par2Random) {
        if (par1 > 0)
        {
            int j = par2Random.nextInt(par1 + 2) - 1;

            if (j < 0)
                j = 0;

            return this.quantityDropped(par2Random) * (j + 1);
        }
        else
            return this.quantityDropped(par2Random);
    }
    
    @Override
    public void dropBlockAsItemWithChance(World par1World, int par2, int par3, int par4, int par5, float par6, int par7) {
        super.dropBlockAsItemWithChance(par1World, par2, par3, par4, par5, par6, par7);
        
        this.dropXpOnBlockBreak(par1World, par2, par3, par4, MathHelper.getRandomIntegerInRange(par1World.rand, 3, 7));
    }
}
