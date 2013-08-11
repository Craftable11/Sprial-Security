package com.github.sprial404.ss.security;

import com.github.sprial404.ss.lib.Strings;

import net.minecraft.nbt.NBTTagCompound;

public class Identity {

    private String username;
    
    private Fingerprint fingerprint;
    
    public Identity(String username) {
        this.username = username;
        fingerprint = new Fingerprint();
    }
    
    public void writeIdentityToNBT(NBTTagCompound nbtTagCompound) {
        nbtTagCompound.setString(Strings.NBT_USERNAME, username);
        fingerprint.writeFingerprintToNBT(nbtTagCompound);
    }
    
    public void readIdentityFromNBT(NBTTagCompound nbtTagCompound) {
        this.username = nbtTagCompound.getString(Strings.NBT_USERNAME);
        fingerprint.readFingerprintFromNBT(nbtTagCompound);
    }
}
