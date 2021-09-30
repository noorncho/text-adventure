package com.company;

public class Weapon extends Item{
    private int minDamage, maxDamage;

    public Weapon(String name, int minDamage, int maxDamage, int numUses) {
        super(name, numUses, true);
        this.minDamage = minDamage;
        this.maxDamage = maxDamage;
    }

    public int getMinDamage() {
        return minDamage;
    }

    public int getMaxDamage() {
        return maxDamage;
    }

}
