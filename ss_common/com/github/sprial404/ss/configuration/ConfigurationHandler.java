package com.github.sprial404.ss.configuration;

import static net.minecraftforge.common.Configuration.CATEGORY_GENERAL;

import java.io.File;
import java.util.logging.Level;

import net.minecraftforge.common.Configuration;

import com.github.sprial404.ss.lib.BlockIds;
import com.github.sprial404.ss.lib.ItemIds;
import com.github.sprial404.ss.lib.Reference;
import com.github.sprial404.ss.lib.Strings;

import cpw.mods.fml.common.FMLLog;

/**
 * Sprial-Security
 * 
 * ConfigurationHandler
 * 
 * @author Sprial404
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class ConfigurationHandler {

    public static Configuration configuration;

    public static final String CATEGORY_KEYBIND = "keybindings";
    public static final String CATEGORY_GRAPHICS = "graphics";
    public static final String CATEGORY_AUDIO = "audio";
    public static final String CATEGORY_BLOCK_PROPERTIES = Configuration.CATEGORY_BLOCK + Configuration.CATEGORY_SPLITTER + "properties";
    
    public static void init(File configFile) {
        configuration = new Configuration(configFile);
        
        try {
            /* General configs */
            ConfigurationSettings.DISPLAY_VERSION_RESULT = configuration.get(CATEGORY_GENERAL, ConfigurationSettings.DISPLAY_VERSION_RESULT_CONFIGNAME, ConfigurationSettings.DISPLAY_VERSION_RESULT_DEFAULT).getBoolean(ConfigurationSettings.DISPLAY_VERSION_RESULT_DEFAULT);
            ConfigurationSettings.LAST_DISCOVERED_VERSION = configuration.get(CATEGORY_GENERAL, ConfigurationSettings.LAST_DISCOVERED_VERSION_CONFIGNAME, ConfigurationSettings.LAST_DISCOVERED_VERSION_DEFAULT).getString();
            ConfigurationSettings.LAST_DISCOVERED_VERSION_TYPE = configuration.get(CATEGORY_GENERAL, ConfigurationSettings.LAST_DISCOVERED_VERSION_TYPE_CONFIGNAME, ConfigurationSettings.LAST_DISCOVERED_VERSION_TYPE_DEFAULT).getString();
            
            /* Graphic configs */
            ConfigurationSettings.ENABLE_PARTICLE_FX = configuration.get(CATEGORY_GRAPHICS, ConfigurationSettings.ENABLE_PARTICLE_FX_CONFIGNAME, ConfigurationSettings.ENABLE_PARTICLE_FX_DEFAULT).getBoolean(ConfigurationSettings.ENABLE_PARTICLE_FX_DEFAULT);
            
            /* Audio configs */
            ConfigurationSettings.ENABLE_SOUNDS = configuration.get(CATEGORY_AUDIO, ConfigurationSettings.ENABLE_SOUNDS_CONFIGNAME, ConfigurationSettings.ENABLE_SOUNDS_DEFAULT).getString();
            
            /* Block configs */
            BlockIds.GEM_BLOCK = configuration.getBlock(Strings.GEM_BLOCK_NAME, BlockIds.GEM_BLOCK_DEFAULT).getInt(BlockIds.GEM_BLOCK_DEFAULT);
            BlockIds.GEM_ORE = configuration.getBlock(Strings.GEM_ORE_NAME, BlockIds.GEM_ORE_DEFAULT).getInt(BlockIds.GEM_ORE_DEFAULT);
            BlockIds.MACHINE_STRUCTURE = configuration.getBlock(Strings.MACHINE_STRUCTURE_NAME, BlockIds.MACHINE_STRUCTURE_DEFAULT).getInt(BlockIds.MACHINE_STRUCTURE_DEFAULT);
            
            /* Block property configs */
            configuration.addCustomCategoryComment(CATEGORY_BLOCK_PROPERTIES, "Custom block properties");
            
            /* Item configs */
            ItemIds.GEM = configuration.getItem(Strings.GEM_NAME, ItemIds.GEM_DEFAULT).getInt(ItemIds.GEM_DEFAULT);
            
            /* KeyBinding configs */
            configuration.addCustomCategoryComment(CATEGORY_KEYBIND, "Keybindings for Sprial Security. See http://www.minecraftwiki.net/wiki/Key_codes for mapping of key codes to keyboard keys");
        } catch (Exception e) {
            FMLLog.log(Level.SEVERE, e, Reference.MOD_ID + " has had a problem loading its configuration");
            
        } finally {
            configuration.save();
        }
    }
    
    public static void set(String categoryName, String propertyName, String newValue) {

        configuration.load();
        if (configuration.getCategoryNames().contains(categoryName)) {
            if (configuration.getCategory(categoryName).containsKey(propertyName)) {
                configuration.getCategory(categoryName).get(propertyName).set(newValue);
            }
        }
        configuration.save();
    }
}
