package com.github.sprial404.ss.energy;

/**
 * Sprial-Security
 * 
 * EnergyStorage
 * 
 * @author Sprial404
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class EnergyStorage {

    public static final double BATTERY_SIZE_PER_CELL = 10.0;
    public static final int MAX_CELLS = 4;

    private double amount;
    private int cells;

    public EnergyStorage() {
        this(0, 1);
    }

    public EnergyStorage(double amount) {
        this(amount, 1);
    }

    public EnergyStorage(double amount, int cells) {
        this.amount = amount < 0 ? 0 : amount;
        this.cells = cells <= 0 || cells > MAX_CELLS ? 1 : cells;
    }

    public EnergyStorage(int cells) {
        this(0, cells);
    }

    public double addEnergy(double amount) {
        amount = amount < 0 || amount + this.amount <= getSize() ? 0 : amount;

        this.amount += amount;

        return amount;
    }

    public double getAmount() {
        return amount;
    }

    public int getCells() {
        return cells;
    }

    public double getSize() {
        return cells * BATTERY_SIZE_PER_CELL;
    }

    public double removeEnergy(double amount) {
        amount = amount < 0 || amount > this.amount ? 0 : amount;

        this.amount -= amount;

        return amount;
    }

    @Override
    public String toString() {
        return String.format("EnergyStorage [amount=%s, cells=%s, size=%s]", amount, cells, getSize());
    }
}
