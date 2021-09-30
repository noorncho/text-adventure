package com.company;

public class Item {

    private String name;
    private int numUses, maxNumUses;
    private boolean usable;

    public Item(String name, int numUses, boolean usable) {
        this.name = name;
        this.numUses = this.maxNumUses = numUses;
        this.usable = usable;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMaxNumUses() {
        return maxNumUses;
    }

    public int getNumUses(){ return numUses; }

    public void reduceNumUses(){
        this.numUses--;
    }

    public boolean isUsable(){
        if (numUses == 0){
            this.usable = false;
            return false;
        }else{
            return usable;
        }
    }

    public void setUsable(boolean usable) {
        this.usable = usable;
    }

}
