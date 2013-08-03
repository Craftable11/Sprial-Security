package com.github.sprial404.ss.configuration;

/**
 * Sprial-Security
 * 
 * ConfigurationSettings
 * 
 * @author Sprial404
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class ConfigurationSettings {

    /*
     * Version check related settings
     */
    public static boolean DISPLAY_VERSION_RESULT;
    public static final String DISPLAY_VERSION_RESULT_CONFIGNAME = "version_check.display_results";
    public static final boolean DISPLAY_VERSION_RESULT_DEFAULT = true;

    public static String LAST_DISCOVERED_VERSION;
    public static final String LAST_DISCOVERED_VERSION_CONFIGNAME = "version_check.last_discovered_version";
    public static final String LAST_DISCOVERED_VERSION_DEFAULT = "";

    public static String LAST_DISCOVERED_VERSION_TYPE;
    public static final String LAST_DISCOVERED_VERSION_TYPE_CONFIGNAME = "version_check.last_discovered_version_type";
    public static final String LAST_DISCOVERED_VERSION_TYPE_DEFAULT = "";
    
    /*
     * Fingerprint settings
     */
    public static int FINGERPRINT_LENGTH;
    public static final String FINGERPRINT_LENGTH_CONFIGNAME = "fingerprint.length";
    public static final int FINGERPRINT_LENGTH_DEFAULT = 20;
    
    /*
     * Audio config settings
     */
    public static String ENABLE_SOUNDS;
    public static final String ENABLE_SOUNDS_CONFIGNAME = "sounds.enabled";
    public static final String ENABLE_SOUNDS_DEFAULT = "all";
    
    /*
     * Graphic config settings
     */
    // Whether or not EE3 particle fx are enabled
    public static boolean ENABLE_PARTICLE_FX;
    public static final String ENABLE_PARTICLE_FX_CONFIGNAME = "particle_fx.enabled";
    public static final boolean ENABLE_PARTICLE_FX_DEFAULT = true;
    
    /*
     * Keybinding related config settings
     */
    // Toggle key
    public static final String KEYBINDING_TOGGLE = "key.toggle";
    public static final int KEYBINDING_TOGGLE_DEFAULT = 34;
}
