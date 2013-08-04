package com.github.sprial404.ss.energy;

/**
 * Sprial-Security
 * 
 * BatteryType
 * 
 * @author Sprial404
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public enum BatteryType {

    TINY(1.0F), SMALL(10.0F), NORMAL(30.0F), BIG(50.0F), LARGE(55.0F), CREATIVE(-1.0F), UNKNOWN(0.0F);
    
    /**
     * Size of BatteryType
     */
    public final float size;

    public static final BatteryType[] VALID_BATTERIES = { TINY, SMALL, NORMAL, BIG, LARGE, CREATIVE };
    
    /**
     * @param size Size of BatteryType
     */
    private BatteryType(float size) {
        this.size = size;
    }

    /**
     * Gets the Name
     * 
     * @return Returns Name of BatteryType
     */
    public String getName() {
        switch (this) {
            case TINY:
                return "Tiny";
            case SMALL:
                return "Small";
            case NORMAL:
                return "Normal";
            case BIG:
                return "Big";
            case LARGE:
                return "Large";
            case CREATIVE:
                return "Creative";
            default:
                return "Unknown";
        }
    }

    /**
     * Get BatteryType from the Id
     * 
     * @param id The Id of the battery
     * @return The Corresponding BatteryType
     */
    public static BatteryType getBatteryType(int id) {
        if (id >= 0 && id < VALID_BATTERIES.length)
            return VALID_BATTERIES[id];
        return UNKNOWN;
    }
    
    /* (non-Javadoc)
     * @see java.lang.Enum#toString()
     */
    @Override
    public String toString() {
        return String.format("BatteryType [name=%s, size=%s]", getName(), size);
    }
}
