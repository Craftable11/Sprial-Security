package com.github.sprial404.ss.item;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;

import com.github.sprial404.ss.lib.Strings;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemBlockGem extends ItemBlock {

    private final Block theBlock;

    public ItemBlockGem(int id, Block block) {
        super(id);
        theBlock = block;
        this.setUnlocalizedName(Strings.GEM_BLOCK_NAME);
        this.setMaxDamage(0);
        this.setHasSubtypes(true);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public Icon getIconFromDamage(int damage) {
        return theBlock.getIcon(2, damage);
    }

    @Override
    public int getMetadata(int meta) {
        return meta;
    }

    @Override
    public String getUnlocalizedName(ItemStack itemStack) {
        int i = itemStack.getItemDamage();

        if (i < 0 || i >= Strings.GEM_NAMES.length) {
            i = 0;
        }

        return super.getUnlocalizedName() + Strings.GEM_NAMES[i];
    }
}
