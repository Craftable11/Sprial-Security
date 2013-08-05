package com.github.sprial404.ss.security;

import java.util.Random;

import net.minecraft.nbt.NBTTagCompound;

import com.github.sprial404.ss.configuration.ConfigurationSettings;
import com.github.sprial404.ss.lib.Strings;

public final class Fingerprint {

    private Random rand = new Random();
    
    private static final Character[] CHARACTERS = {
      'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j',
      'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't',
      'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', 
      '4', '5', '6', '7', '8', '9'
    };
    
    private String username;
    private String fingerprint;
    
    public Fingerprint(String username) {
        this.username = username;
        this.fingerprint = generateFingerprint();
    }
    
    private String generateFingerprint() {
        StringBuilder builder = new StringBuilder(20);
        
        for (int i = 1; i < ConfigurationSettings.FINGERPRINT_LENGTH; i++) {
            builder.append(CHARACTERS[rand.nextInt(CHARACTERS.length)]);
        }
        
        return builder.toString();
    }

    public NBTTagCompound writeToNBT(NBTTagCompound par1NBTTagCompound) {
        par1NBTTagCompound.setString(Strings.NBT_USERNAME, username);
        par1NBTTagCompound.setString(Strings.NBT_FINGERPRINT, fingerprint);
        
        return par1NBTTagCompound;
    }

    public void readFromNBT(NBTTagCompound par1NBTTagCompound) {
        this.username = par1NBTTagCompound.getString(Strings.NBT_USERNAME);
        this.fingerprint = par1NBTTagCompound.getString(Strings.NBT_FINGERPRINT);
    }

    public String getUsername() {
        return username;
    }
    
    public boolean verify(String fingerprint) {
        return this.fingerprint.equals(fingerprint);
    }
}
