package com.github.sprial404.ss.block;

import com.github.sprial404.ss.lib.Reference;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.EntityLiving;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeDirection;

public abstract class BlockSS extends BlockContainer {

    public BlockSS(int par1, Material par2Material) {
        super(par1, par2Material);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister par1IconRegister) {
        blockIcon = par1IconRegister.registerIcon(Reference.MOD_ID.toLowerCase() + getUnlocalizedName2());
    }
    
    /**
     * Sets the direction of the block when placed
     */
    @Override
    public void onBlockPlacedBy(World par1World, int par2, int par3, int par4,
            EntityLiving par5EntityLiving, ItemStack par6ItemStack) {
        int direction = 0;
        int facing = MathHelper.floor_double(par5EntityLiving.rotationYaw * 4.0F / 360.0F + 0.5D) & 3;
        
        if (facing == 0) {
            direction = ForgeDirection.NORTH.ordinal();
        }
        else if (facing == 1) {
            direction = ForgeDirection.EAST.ordinal();
        }
        else if (facing == 2){
            direction = ForgeDirection.SOUTH.ordinal();
        }
        else if (facing == 3) {
            direction = ForgeDirection.WEST.ordinal();
        }
        
        par1World.setBlockMetadataWithNotify(par2, par3, par4, direction, 3);
        
        par1World.getBlockTileEntity(par2, par3, par4);
    }
}
