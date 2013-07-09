package com.github.sprial404.ss.item;

import java.util.List;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.Icon;
import net.minecraft.util.MathHelper;

import com.github.sprial404.ss.SprialSecurity;
import com.github.sprial404.ss.lib.Reference;
import com.github.sprial404.ss.lib.Strings;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

/**
 * Sprial-Security
 * 
 * ItemGem
 * 
 * @author Sprial404
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class ItemGem extends ItemSS {

    @SideOnly(Side.CLIENT)
    private Icon[] icons;
    
    public ItemGem(int id) {
        super(id);
        this.setHasSubtypes(true);
        this.setUnlocalizedName(Strings.GEM_NAME);
        this.setCreativeTab(SprialSecurity.tabsSS);
        this.maxStackSize = 64;
    }

    @Override
    public String getUnlocalizedName(ItemStack itemStack) {
        int meta = MathHelper.clamp_int(itemStack.getItemDamage(), 0, 8);
        return super.getUnlocalizedName() + Strings.GEM_NAMES[meta];
    }
    
    @Override
    @SideOnly(Side.CLIENT)
    public Icon getIconFromDamage(int meta) {
        int j = MathHelper.clamp_int(meta, 0, 8);
        return icons[j];
    }
    
    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister iconRegister) {
        icons = new Icon[Strings.GEM_NAMES.length];
        
        for (int i = 0; i < Strings.GEM_NAMES.length; i++)
            icons[i] = iconRegister.registerIcon(Reference.MOD_ID.toLowerCase() + ":" + Strings.GEM_NAME + Strings.GEM_NAMES[i]);
    }
    
    @Override
    public String getItemDisplayName(ItemStack itemStack) {
        int meta = MathHelper.clamp_int(itemStack.getItemDamage(), 0, 8);
        
        switch (meta) {
            case 0:
                return EnumChatFormatting.BLUE + super.getItemDisplayName(itemStack);
            case 3:
                return EnumChatFormatting.GRAY + super.getItemDisplayName(itemStack);
            case 4:
                return EnumChatFormatting.RED + super.getItemDisplayName(itemStack);
            case 5:
                return EnumChatFormatting.DARK_PURPLE + super.getItemDisplayName(itemStack);
            case 6:
                return EnumChatFormatting.GOLD + super.getItemDisplayName(itemStack);
            case 7:
                return EnumChatFormatting.DARK_GREEN + super.getItemDisplayName(itemStack);
            case 8:
                return EnumChatFormatting.GREEN + super.getItemDisplayName(itemStack);
        default:
            return EnumChatFormatting.WHITE + super.getItemDisplayName(itemStack);
        }
    }
    
    @Override
    @SuppressWarnings({ "unchecked", "rawtypes" })
    @SideOnly(Side.CLIENT)
    public void getSubItems(int id, CreativeTabs creativeTab, List list) {
        for (int meta = 0; meta < 9; meta++)
            list.add(new ItemStack(id, 1, meta));
    }
}
