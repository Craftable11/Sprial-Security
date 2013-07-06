package com.github.sprial404.ss.item;

import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;

import com.github.sprial404.ss.SprialSecurity;
import com.github.sprial404.ss.lib.Strings;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemPlasmaCell extends ItemSS {
    
    public ItemPlasmaCell(int id) {
        super(id);
        this.setUnlocalizedName(Strings.PLASMA_CELL_NAME);
        this.setCreativeTab(SprialSecurity.tabsSS);
        maxStackSize = 64;
    }
    
    @Override
    @SideOnly(Side.CLIENT)
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public void addInformation(ItemStack par1ItemStack,
            EntityPlayer par2EntityPlayer, List par3List, boolean par4) {
        par3List.add(EnumChatFormatting.BLUE + "Energy Stored: 25/100");
    }
}
