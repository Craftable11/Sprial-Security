package com.github.sprial404.ss.item;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

/**
 * Sprial-Security
 * 
 * IKeyBound
 * 
 * @author Sprial404
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public interface IKeyBound {

    public abstract void doKeyBindingAction(EntityPlayer thePlayer, ItemStack itemStack, String keyBinding);
}
