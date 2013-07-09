package com.github.sprial404.ss.item;

import java.util.ArrayList;

import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

import com.github.sprial404.ss.core.util.EnergyStack;
import com.github.sprial404.ss.core.util.ItemUtil;
import com.github.sprial404.ss.core.util.OreStack;
import com.github.sprial404.ss.lib.Reference;

/**
 * Sprial-Security
 * 
 * CustomWrappedStack
 * 
 * @author Sprial404
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class CustomWrappedStack {

    private int stackSize;
    private ItemStack itemStack;
    private OreStack oreStack;
    private EnergyStack energyStack;

    /**
     * Creates a new CustomWrappedStack object which wraps the given input.
     * Valid inputs would be ItemStacks or OreStacks. If something other than an
     * ItemStack or an OreStack is used as input, nothing is wrapped and the
     * size of the wrapped stack is set to -1 to indicate an invalid wrapped
     * stack.
     * 
     * @param object
     *            The newly created wrapped stack object
     */
    public CustomWrappedStack(Object object) {

        /*
         * We are given an ItemStack to wrap
         */
        if (object instanceof ItemStack) {

            ItemStack itemStack = (ItemStack) object;

            /*
             * If the ItemStack does not exist in the OreDictionary, wrap it as
             * an ItemStack
             */
            if (OreDictionary.getOreID(itemStack) == Reference.ORE_DICTIONARY_NOT_FOUND) {
                this.itemStack = itemStack.copy();
                oreStack = null;
                energyStack = null;
                stackSize = this.itemStack.stackSize;
                this.itemStack.stackSize = 1;
            }
            /*
             * Else the ItemStack exists in the OreDictionary, so wrap it as an
             * OreStack instead of an ItemStack
             */
            else {
                this.itemStack = null;
                oreStack = new OreStack(itemStack);
                energyStack = null;
                stackSize = oreStack.stackSize;
                oreStack.stackSize = 1;
            }
        }
        /*
         * Or we are given an OreStack to wrap
         */
        else if (object instanceof OreStack) {

            itemStack = null;
            oreStack = (OreStack) object;
            energyStack = null;
            stackSize = oreStack.stackSize;
            oreStack.stackSize = 1;
        }
        else if (object instanceof ArrayList) {

            itemStack = null;

            ArrayList<?> objectList = (ArrayList<?>) object;

            if (!objectList.isEmpty()) {
                for (Object listElement : objectList) {
                    if (listElement instanceof ItemStack) {
                        ItemStack stack = (ItemStack) listElement;

                        if (OreDictionary.getOreID(stack) != Reference.ORE_DICTIONARY_NOT_FOUND) {
                            oreStack = new OreStack(stack);
                            stackSize = oreStack.stackSize;
                            oreStack.stackSize = 1;
                            break;
                        }
                    }
                }
            }

            energyStack = null;
        }
        /*
         * Or we are given an EnergyStack to wrap
         */
        else if (object instanceof EnergyStack) {
            itemStack = null;
            oreStack = null;
            energyStack = (EnergyStack) object;
            stackSize = energyStack.stackSize;
            energyStack.stackSize = 1;
        }
        /*
         * Else, we are given something we cannot wrap
         */
        else {
            stackSize = -1;
        }
    }

    /**
     * Returns the stack size of the wrapped stack, or -1 if we wrapped an
     * invalid input
     * 
     * @return The size of the wrapped stack
     */
    public int getStackSize() {

        return stackSize;
    }

    /**
     * Sets the size of the wrapped stack
     * 
     * @param stackSize
     *            The new size of the wrapped stack
     */
    public void setStackSize(int stackSize) {

        this.stackSize = stackSize;
    }

    /**
     * Returns the wrapped stack
     * 
     * @return The wrapped ItemStack, OreStack, or EnergyStack, or null if
     *         something other than an ItemStack, OreStack, or EnergyStack was
     *         used to create this object
     */
    public Object getWrappedStack() {

        if (itemStack != null) {
            return itemStack;
        }
        else if (oreStack != null) {
            return oreStack;
        }
        else if (energyStack != null) {
            return energyStack;
        }

        return null;
    }

    @Override
    public boolean equals(Object object) {

        if (!(object instanceof CustomWrappedStack))
            return false;

        CustomWrappedStack customWrappedStack = (CustomWrappedStack) object;

        if (itemStack != null) {
            if (customWrappedStack.itemStack != null)
                return ItemUtil.compare(itemStack, customWrappedStack.itemStack) && stackSize == customWrappedStack.itemStack.stackSize;
            else if (customWrappedStack.oreStack != null) {
                for (ItemStack oreDictItemStack : OreDictionary.getOres(customWrappedStack.oreStack.oreName)) {
                    if (ItemUtil.compare(itemStack, oreDictItemStack) && stackSize == customWrappedStack.stackSize)
                        return true;
                }
            }
        }
        else if (oreStack != null) {
            if (customWrappedStack.itemStack != null) {
                for (ItemStack oreDictItemStack : OreDictionary.getOres(oreStack.oreName)) {
                    if (ItemUtil.compare(customWrappedStack.itemStack, oreDictItemStack) && stackSize == customWrappedStack.stackSize)
                        return true;
                }
            }
            else if (customWrappedStack.oreStack != null)
                return oreStack.oreName.equalsIgnoreCase(customWrappedStack.oreStack.oreName) && stackSize == customWrappedStack.stackSize;
        }
        else if (energyStack != null) {
            if (customWrappedStack.energyStack != null) {
                return energyStack.energyName.equalsIgnoreCase(customWrappedStack.energyStack.energyName) && stackSize == customWrappedStack.stackSize;
            }
        }

        return false;
    }

    @Override
    public String toString() {

        StringBuilder stringBuilder = new StringBuilder();

        if (itemStack != null) {
            stringBuilder.append(String.format("%sxitemStack[%s:%s:%s:%s]", this.stackSize, itemStack.itemID, itemStack.getItemDamage(), itemStack.getItemName(), itemStack.getItem().getClass().getCanonicalName()));
        }
        else if (oreStack != null) {
            stringBuilder.append(String.format("%dxoreDictionary.%s", stackSize, oreStack.oreName));
        }
        else if (energyStack != null) {
            stringBuilder.append(String.format("%dxenergyStack.%s", stackSize, energyStack.energyName));
        }

        return stringBuilder.toString();
    }

    @Override
    public int hashCode() {

        int hashCode = 1;

        hashCode = 37 * hashCode + stackSize;

        if (itemStack != null) {
            hashCode = 37 * hashCode + itemStack.itemID;

            if (itemStack.getItemDamage() == OreDictionary.WILDCARD_VALUE) {
                hashCode = 37 * hashCode;
            }
            else {
                hashCode = 37 * hashCode + itemStack.getItemDamage();
            }

            hashCode = 37 * hashCode + itemStack.getItemName().hashCode();
        }
        else if (oreStack != null) {
            hashCode = 37 * hashCode + oreStack.oreName.hashCode();
        }
        else if (energyStack != null) {
            hashCode = 37 * hashCode + energyStack.energyName.hashCode();
        }

        return hashCode;
    }
}
