package com.github.sprial404.ss.energy;

import com.github.sprial404.ss.lib.Colours;
import com.github.sprial404.ss.lib.Strings;

import net.minecraft.nbt.NBTTagCompound;

/**
 * Sprial-Security
 * 
 * EnergyStorage
 * 
 * @author Sprial404
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class EnergyStorage {

    private double amount;

    private BatteryType batteryType;

    private EnergyType energyType;
    
    public EnergyStorage() {
        this(BatteryType.NORMAL);
    }
    public EnergyStorage(BatteryType batteryType) {
        this(0, batteryType);
    }
    public EnergyStorage(EnergyType energyType) {
        this(0, BatteryType.NORMAL, energyType);
    }
    
    public EnergyStorage(double amount, BatteryType batteryType) {
        this(amount, batteryType, EnergyType.PLASMA);
    }
    
    public EnergyStorage(double amount, BatteryType batteryType, EnergyType energyType) {
        this.batteryType = batteryType;
        this.energyType = energyType;
        this.amount = amount < 0 || amount > getSize() ? 0 : amount;
    }

    public double addEnergy(double amount) {
        if (batteryType == BatteryType.CREATIVE)
            return amount;

        if (!(amount < 0 || this.amount + amount > getSize())
                || batteryType == BatteryType.UNKNOWN) {
            this.amount += amount;
            return amount;
        }

        return 0;
    }

    public String getColourFromAmount() {
        if (getPercentage() < 25)
            return Colours.TEXT_COLOUR_PREFIX_RED;
        else if (getPercentage() < 50)
            return Colours.TEXT_COLOUR_PREFIX_YELLOW;
        else if (getPercentage() < 75)
            return Colours.TEXT_COLOUR_PREFIX_ORANGE;
        else if (getPercentage() < 100)
            return Colours.TEXT_COLOUR_PREFIX_GREEN;
        return Colours.TEXT_COLOUR_PREFIX_GRAY;
    }
    
    public double removeEnergy(double amount) {
        if (batteryType == BatteryType.CREATIVE)
            return amount;

        if (!(amount < 0 || this.amount - amount < 0)
                || batteryType == BatteryType.UNKNOWN) {
            this.amount -= amount;
            return amount;
        }

        return 0;
    }

    public double getAmount() {
        return amount;
    }
    
    public int getPercentage() {
        return (int) (amount / getSize() * 100);
    }
    
    public double getSize() {
        return batteryType.size * energyType.batteryModifer;
    }

    public EnergyType getEnergyType() {
        return energyType;
    }
    
    public BatteryType getBatteryType() {
        return batteryType;
    }

    public NBTTagCompound writeToNBT(NBTTagCompound par1NBTTagCompound) {
        par1NBTTagCompound.setDouble(Strings.NBT_AMOUNT, amount);
        par1NBTTagCompound.setInteger(Strings.NBT_BATTERY_TYPE, batteryType.ordinal());
        par1NBTTagCompound.setInteger(Strings.NBT_ENERGY_TYPE, energyType.ordinal());

        return par1NBTTagCompound;
    }

    public void readFromNBT(NBTTagCompound par1NBTTagCompound) {
        amount = par1NBTTagCompound.getDouble(Strings.NBT_AMOUNT);
        batteryType = BatteryType.getBatteryType(par1NBTTagCompound.getInteger(Strings.NBT_BATTERY_TYPE));
        energyType = EnergyType.getEnergyType(par1NBTTagCompound.getInteger(Strings.NBT_ENERGY_TYPE));
    }

    @Override
    public String toString() {
        return String.format("EnergyStorage [energy=%s, maxiumEnergy=%s, energyType=%s]",
                getPercentage() + "%", getSize(), energyType.getName());
    }
}
