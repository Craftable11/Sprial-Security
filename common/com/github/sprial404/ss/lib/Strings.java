package com.github.sprial404.ss.lib;

/**
 * Sprial-Security
 * 
 * Strings
 * 
 * @author Sprial404
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class Strings {

    /* General keys */
    public static final String TRUE = "true";
    public static final String FALSE = "false";
    public static final String TOKEN_DELIMITER = ".";
    
    /* Localization Prefixes */
    public static final String RESOURCE_PREFIX = Reference.MOD_ID.toLowerCase() + ":";

    /* Fingerprint check related constants */
    public static final String NO_FINGERPRINT_MESSAGE = "The copy of Sprial Security that you are running is a development version of the mod, and as such may be unstable and/or incomplete.";
    public static final String INVALID_FINGERPRINT_MESSAGE = "The copy of Sprial Security that you are running has been modified from the original, and unpredictable things may happen. Please consider re-downloading the original version of the mod.";

    /* Version check related constants */
    public static final String VERSION_CHECK_INIT_LOG_MESSAGE = "version.init_log_message";
    public static final String UNINITIALIZED_MESSAGE = "version.uninitialized";
    public static final String CURRENT_MESSAGE = "version.current";
    public static final String OUTDATED_MESSAGE = "version.outdated";
    public static final String GENERAL_ERROR_MESSAGE = "version.general_error";
    public static final String FINAL_ERROR_MESSAGE = "version.final_error";
    public static final String MC_VERSION_NOT_FOUND = "version.mc_version_not_found";
    
    /* NBT related constants */
    public static final String NBT_ITEM_DISPLAY = "display";
    public static final String NBT_ITEM_COLOR = "color";
    public static final String NBT_TE_STATE_KEY = "teState";
    public static final String NBT_TE_DIRECTION_KEY = "teDirection";
    public static final String NBT_TE_CUSTOM_NAME = "CustomName";
    public static final String NBT_ENCODED_RECIPE_OUTPUT = "recipeOutput";
    public static final String NBT_ENCODED_RECIPE_INPUTS = "recipeInputs";
    public static final String NBT_ENCODED_RECIPE_INPUT_PREFIX = "recipeInput_";
    public static final String NBT_ENCODED_ATTR_TYPE = "type";
    public static final String NBT_ENCODED_ATTR_TYPE_ITEM = "ItemStack";
    public static final String NBT_ENCODED_ATTR_TYPE_ORE = "OreStack";
    public static final String NBT_ENCODED_ATTR_TYPE_ENERGY = "EnergyStack";
    public static final String NBT_ENCODED_ATTR_SIZE = "Count";
    public static final String NBT_ENCODED_ATTR_ITEM_ID = "id";
    public static final String NBT_ENCODED_ATTR_ITEM_META = "Damage";
    public static final String NBT_ENCODED_ATTR_ITEM_TAG_COMPOUND = "tag";
    public static final String NBT_ENCODED_ATTR_ORE_NAME = "oreName";
    public static final String NBT_ENCODED_ATTR_ENERGY_NAME = "energyName";

    /* Block name constants */

    /* Item name constants */

    /* TileEntity name constants */

    /* Container related constants */
    public static final String CONTAINER_INVENTORY = "container.inventory";
    public static final String CONTAINER_PORTABLE_CRAFTING = "container.crafting";
}
