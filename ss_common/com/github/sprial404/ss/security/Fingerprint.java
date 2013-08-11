package com.github.sprial404.ss.security;

import java.util.Random;

import net.minecraft.nbt.NBTTagCompound;

import com.github.sprial404.ss.configuration.ConfigurationSettings;
import com.github.sprial404.ss.core.util.LogHelper;
import com.github.sprial404.ss.lib.Strings;

public class Fingerprint {

    private static final String CHARACTERS = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    
    private static Random rand = new Random();
    
    private String fingerprint;
    
    public Fingerprint() {
        generateFingerprint();
    }

    private void generateFingerprint() {
        for (int i = 0; i < ConfigurationSettings.FINGERPRINT_LENGTH; i++)
            fingerprint += CHARACTERS.charAt(rand.nextInt(CHARACTERS.length()));
    }
    
    public void writeFingerprintToNBT(NBTTagCompound nbtTagCompound) {
        nbtTagCompound.setString(Strings.NBT_FINGERPRINT, fingerprint);
    }
    
    public void readFingerprintFromNBT(NBTTagCompound nbtTagCompound) {
        String fingerprint = nbtTagCompound.getString(Strings.NBT_FINGERPRINT);
        
        if (fingerprint.length() == ConfigurationSettings.FINGERPRINT_LENGTH) {
            this.fingerprint = fingerprint;
        }
        
        LogHelper.warning("Tempered Fingerprint Found - INVAILD LENGTH");
        LogHelper.warning("Creating a new Fingerprint");
        
        generateFingerprint();
    }
    
    public boolean verify(String fingerprint) {
        return this.fingerprint == fingerprint;
    }
}
