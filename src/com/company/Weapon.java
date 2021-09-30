package com.company;

public class Weapon extends Item{
    private int minDamage, maxDamage, integrity;

    public Weapon(String name, int minDamage, int maxDamage, int integrity) {
        super(name);
        this.minDamage = minDamage;
        this.maxDamage = maxDamage;
        this.integrity = integrity;
    }

    public int getMinDamage() {
        return minDamage;
    }

    public int getMaxDamage() {
        return maxDamage;
    }

    public int getIntegrity() {
        return integrity;
    }

}
