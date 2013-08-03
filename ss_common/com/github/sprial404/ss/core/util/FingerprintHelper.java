package com.github.sprial404.ss.core.util;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;

import com.github.sprial404.ss.configuration.ConfigurationSettings;
import com.github.sprial404.ss.security.Fingerprint;

/**
 * Sprial-Security
 * 
 * FingerprintHelper
 * 
 * @author Sprial404
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class FingerprintHelper {

    private static Random rand = new Random();
    private static File fingerprintFile = new File("." + File.separator + "fingerprints.dat");
    
    public static Set<Fingerprint> fingerprints = new HashSet<Fingerprint>();
    
    public static final Character[] CHARACTERS = {
        'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k',
        'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'w', 'x',
        'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'
    };

    public static void init() {
        if (!fingerprintFile.exists()) {
            NBTTagCompound fingerprintTagCompound = new NBTTagCompound();
            
            DataOutputStream stream = null;
            try {
                if (!fingerprintFile.exists() && !fingerprintFile.createNewFile())
                    return;
                
                stream = new DataOutputStream(new FileOutputStream(fingerprintFile));
                NBTBase.writeNamedTag(fingerprintTagCompound, stream);
                stream.close();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if(stream != null)
                    try {
                        stream.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
            }
        }
            
        
        load();
    }
    
    public static void load() {
        NBTTagCompound fingerprintTagCompound = new NBTTagCompound();
        
        DataInputStream stream = null;
        try {
            if (!fingerprintFile.exists() && !fingerprintFile.createNewFile())
                return;
            
            stream = new DataInputStream(new FileInputStream(fingerprintFile));
            fingerprintTagCompound = (NBTTagCompound) NBTBase.readNamedTag(stream);
            stream.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(stream != null)
                try {
                    stream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }
        
        for (Object object : fingerprintTagCompound.getTags())
            if (object instanceof NBTTagCompound) {
                NBTTagCompound tag = (NBTTagCompound) object;
                Fingerprint fingerprint = Fingerprint.EMPTY;
                fingerprint.readFromNBT(tag);
                if (!fingerprints.contains(fingerprint))
                    fingerprints.add(fingerprint);
            }
    }
    
    public static void save() {
        NBTTagCompound fingerprintTagCompound = new NBTTagCompound();
        
        for(Fingerprint fingerprint : fingerprints)
            fingerprintTagCompound.setTag("", fingerprint.writeToNBT(new NBTTagCompound()));
        
        DataOutputStream stream = null;
        try {
            if (!fingerprintFile.exists() && !fingerprintFile.createNewFile())
                return;
            
            stream = new DataOutputStream(new FileOutputStream(fingerprintFile));
            NBTBase.writeNamedTag(fingerprintTagCompound, stream);
            stream.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(stream != null)
                try {
                    stream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }
    }
    
    public static String generateFingprint() {
        StringBuilder builder = new StringBuilder();
        
        for (int i = 0; i < ConfigurationSettings.FINGERPRINT_LENGTH; i++) {
            builder.append(CHARACTERS[rand.nextInt(CHARACTERS.length)]);
        }
        
        return builder.toString();
    }

    public static void onPlayerLogin(EntityPlayer player) {
        for (Fingerprint fingerprint : fingerprints)
            if (fingerprint.getUsername() == player.username)
                return;
        
        fingerprints.add(new Fingerprint(player.username));
        save();
    }
}
