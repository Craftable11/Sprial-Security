package com.github.sprial404.ss.energy;

public enum EnergyType {

    FUEL(10, 0),
    SUPERFUEL(20.0F, 2.0F),
    PLASMA(30.0F, 4.0F),
    NUCLEAR(60, 10.0F),
    // BUILDCRAFT(26.0F, 3.0F),
    // INDUSTIALCRAFT(24.0F, 6.0F),
    OTHER(5.0F, 1.0F),
    UNKNOWN(0.0F, 0.0F);
    
    public final float efficiency;
    public final float batteryModifer;
    public static final EnergyType[] VALID_TYPES = { FUEL, SUPERFUEL, PLASMA, NUCLEAR, /* BUILDCRAFT, INDUSTIALCRAFT, */ OTHER };
    
    private EnergyType(float efficiency, float batterModifer) {
        this.efficiency = efficiency;
        this.batteryModifer = batterModifer;
    }
    
    public String getName() {
        switch(this) {
            case FUEL:
                return "Fuel";
            case SUPERFUEL:
                return "Superfuel";
            case PLASMA:
                return "Plasma";
            case NUCLEAR:
                return "Nuclear";
            // case BUILDCRAFT:
               // return "Buildcraft";
            // case INDUSTIALCRAFT:
               // return "Industialcraft";
            default:
                return "Other";
        }
    }
    
    public String getSymbol() {
        switch(this) {
            case FUEL:
                return "F";
            case SUPERFUEL:
                return "SF";
            case PLASMA:
                return "P";
            case NUCLEAR:
                return "N";
            // case BUILDCRAFT:
               // return "MJ";
            // case INDUSTIALCRAFT:
               // return "IC";
            default:
                return "O";
        }
    }
    
    public static EnergyType getEnergyType(int id) {
        if (id >= 0 && id < VALID_TYPES.length)
            return VALID_TYPES[id];
        return UNKNOWN;
    }
    
    @Override
    public String toString() {
        return String.format("EnergyType [name=%s, efficiency=%s]", getName(), efficiency);
    }
}
