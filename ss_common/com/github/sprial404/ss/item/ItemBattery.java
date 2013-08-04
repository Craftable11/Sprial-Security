package com.github.sprial404.ss.item;

import com.github.sprial404.ss.SprialSecurity;
import com.github.sprial404.ss.energy.BatteryType;
import com.github.sprial404.ss.energy.EnergyStorage;
import com.github.sprial404.ss.lib.Strings;

public class ItemBattery extends ItemSS {

    protected EnergyStorage storage;
    
    public ItemBattery(int id) {
        super(id);
        this.setUnlocalizedName(Strings.BATTERY_NAME);
        this.setCreativeTab(SprialSecurity.tabsSS);
        storage = new EnergyStorage(25, BatteryType.LARGE);
    }
}
