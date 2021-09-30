package com.company;

public class HealingPotion extends Item{
    private int maxRestore;
    
    public HealingPotion(String name, int maxRestore) {
        super(name, 1, true);
        this.maxRestore = maxRestore;
    }

    public int getMaxRestore() {
        return maxRestore;
    }

    public void usePotion(HealingPotion healingPotion){
        healingPotion.reduceNumUses();
        healingPotion.setUsable(false);
    }
}
