package com.github.sprial404.ss.security;

import net.minecraft.nbt.NBTTagCompound;

import com.github.sprial404.ss.core.util.FingerprintHelper;
import com.github.sprial404.ss.lib.Strings;

/**
 * Sprial-Security
 * 
 * Fingerprint
 * 
 * This is not the Fingerprint you are looking for. Thats if your looking for
 * Mod's Fingerprint.
 * 
 * @author Sprial404
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public final class Fingerprint {

    public static final Fingerprint EMPTY = new Fingerprint();

    private String fingerprint;

    private String username;

    public Fingerprint(String username) {
        this(username, FingerprintHelper.generateFingprint());
    }

    public Fingerprint(String username, String fingerprint) {
        this.username = username;
        this.fingerprint = fingerprint;
    }

    private Fingerprint() {
        this.username = "";
        this.fingerprint = "";
    }

    public String getFingerprint() {
        return fingerprint;
    }

    public String getUsername() {
        return username;
    }

    public void readFromNBT(NBTTagCompound nbtTagCompound) {
        this.username = nbtTagCompound.getString(Strings.NBT_USERNAME);
        this.fingerprint = nbtTagCompound.getString(Strings.NBT_FINGERPRINT);
    }

    public NBTTagCompound writeToNBT(NBTTagCompound nbtTagCompound) {
        nbtTagCompound.setString(Strings.NBT_USERNAME, username);
        nbtTagCompound.setString(Strings.NBT_FINGERPRINT, fingerprint);

        return nbtTagCompound;
    }

    @Override
    public String toString() {
        return String.format("Fingerprint [fingerprint=%s, username=%s]", fingerprint, username);
    }
}
