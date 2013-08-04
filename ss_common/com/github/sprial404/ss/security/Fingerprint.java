package com.github.sprial404.ss.security;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;

public class Fingerprint extends SecurityModule {

    public EntityPlayer player;
    public String fingerprint;
    
    public Fingerprint() {
        super();
    }

    @Override
    public void writeToNBT(NBTTagList par1nbtTagList) {
        NBTTagCompound compound = new NBTTagCompound();
    }

    @Override
    public void readFromNBT(NBTTagList par1nbtTagList) {
        // TODO Auto-generated method stub
        
    }
}
