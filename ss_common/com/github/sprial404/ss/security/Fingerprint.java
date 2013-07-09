package com.github.sprial404.ss.security;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagString;

import com.github.sprial404.ss.core.util.LogHelper;
import com.github.sprial404.ss.lib.Strings;

/**
 * Sprial-Security
 * 
 * Fingerprint
 * 
 * This is not the Fingerprint you are looking for. Thats if your looking for Mod's Fingerprint.
 * 
 * @author Sprial404
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class Fingerprint {
    
    private static Random rand = new Random();
    private static Map<String, String> fingerprints = new HashMap<String, String>();
    private static final File FINGERPRINT_FILE = new File("." + File.separator + "fingerprint.dat");
    private static final String[] CHARACTERS = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z" };
    
    private Fingerprint() {}
    
    /**
     * Creates a fingerprint for the player, if the player
     * doesn't already have one.
     * 
     * @param username The player's username.
     */
    public static void createFingerprint(String username) {
        if (exists(username))
            return;
        fingerprints.put(username, generateFingerprint());
        save();
    }
    
    /**
     * Gets the fingerprint for the player, if it exists.
     * 
     * @param username The player's username.
     * @return The fingerprint of the player.
     */
    public static String getFingerprint(String username) {
        return exists(username) ? fingerprints.get(username) : null;
    }
    
    /**
     * See if the player has a fingerprint.
     * 
     * @param username The player's username.
     * @return True, if fingerprint exists. Otherwise false.
     */
    public static boolean exists(String username) {
        return fingerprints.containsKey(username);
    }
    
    @SuppressWarnings("rawtypes")
    
    /**
     * Loads all existing fingerprints for file.
     */
    public static void load() {
        NBTTagCompound baseTag = null;
        
        try {
            DataInputStream stream =  new DataInputStream(new FileInputStream(FINGERPRINT_FILE));
            baseTag = (NBTTagCompound) NBTBase.readNamedTag(stream);
            stream.close();
        } catch (IOException e) {
            LogHelper.warning("Error occured when loading fingerprints: " + e);
        }
        
        if (baseTag == null)
            return;
        
        Map tagMap = new HashMap();
        
        /*
         * WARNING: The Following Code may Contain Reflections.
         * 
         * You have been Warned.
         */
        
        try {
            Method m = baseTag.getClass().getDeclaredMethod("getTagMap", baseTag.getClass());
            Method.setAccessible(new Method[] { m }, true);
            tagMap = (HashMap) m.invoke(tagMap, baseTag);
        } catch (Exception e) {
            LogHelper.warning("Error occured when reflecting in fingerprints: " + e);
        }
        
        /* End of Warning */
        
        fingerprints.clear();
        
        for (int i = 0; i < tagMap.size(); i++)
            fingerprints.put((String) tagMap.keySet().toArray()[i], ((NBTTagString) tagMap.values().toArray()[i]).data);
    }
    
    /**
     * Saves all fingerprints to file.
     */
    public static void save() {
        NBTTagCompound baseTag = new NBTTagCompound(Strings.NBT_FINGERPRINT);
        
        for (int i = 0; i < fingerprints.size(); i++)
            baseTag.setString((String) fingerprints.keySet().toArray()[i], (String) fingerprints.values().toArray()[i]);
        
        try {
            DataOutputStream stream = new DataOutputStream(new FileOutputStream(FINGERPRINT_FILE));
            NBTBase.writeNamedTag(baseTag, stream);
            stream.close();
        } catch (IOException e) {
            LogHelper.warning("Error occured when saving fingerprints: " + e);
        }
    }
    
    private static String generateFingerprint() {
        StringBuilder builder = new StringBuilder();
        
        for (int i = 0; i < 20; i++)
            builder.append(CHARACTERS[rand.nextInt(CHARACTERS.length)]);
        
        return builder.toString();
    }

    /**
     * Gets called when a player logs in.
     * 
     * @param player The player.
     */
    public static void onPlayerLogin(EntityPlayer player) { createFingerprint(player.username); }
}
