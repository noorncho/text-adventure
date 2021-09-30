package com.company;

import java.util.ArrayList;

public class Player {
    private String name;
    private int level, gold;
    private int maxHp, currentHp;
    private int maxAttack;
    private int currentExp, requiredExp;
    public int defaultMaxAttack;
    ArrayList<Item> inventory;
    private Weapon equippedWeapon;
    public boolean alive;

    public Player(String name) {
        this.name = name;
        this.level = 1;
        this.currentHp = this.maxHp = 10;
        this.gold = this.currentExp = 0;
        this.requiredExp = 20;
        this.defaultMaxAttack = this.maxAttack = 3;
        this.inventory = new ArrayList<Item>();
        this.equippedWeapon = null;
        this.alive = true;
    }

    public void stats(){
        System.out.println("Name: " + name);
        System.out.println("Level: " + level);
        System.out.println("HP: " + currentHp + "/" + maxHp);
        System.out.println("Gold: " + gold + "G");
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public void leveUp(int gainedExp){
        int totalExp = currentExp + gainedExp;
        if(totalExp >= requiredExp){
            currentExp = totalExp % requiredExp;
            System.out.println("You have leveled up!");
            level++;
            requiredExp = (int) (level * Math.pow(20, level));
        }
    }

    public int getMaxHp() {
        return maxHp;
    }

    public void setMaxHp(int maxHp) {
        this.maxHp = maxHp;
    }

    public int getCurrentHp() {
        return currentHp;
    }

    public void setCurrentHp(int currentHp) {
        this.currentHp = currentHp;
    }

    public void takeDamage(int damage){
        this.currentHp -= damage;
    }

    public int getMaxAttack() {
        return maxAttack;
    }

    public void setMaxAttack(int maxAttack) {
        this.maxAttack = maxAttack;
    }

    public int getGold() {
        return gold;
    }

    public void addMoney(int money) {
        this.gold += money;
    }

    public void equipWeapon(Item weapon){
        equippedWeapon = (Weapon) weapon;
    }

    public Item getEquippedWeapon(){
        return this.equippedWeapon;
    }

    public void showInventory(){
        System.out.println("Inventory");
        System.out.println("---------");
        if(inventory.isEmpty()){
            System.out.println("Empty");
        }else {
            for(Item i: inventory){
                int index = inventory.indexOf(i);
                Item item = inventory.get(index);
                if(inventory.get(index) instanceof Weapon){
                    System.out.println(index + ": " + item.getName() + " [Type: Weapon]");
                }else{
                    System.out.println(index + ": " + inventory.get(index).getName());
                }
            }
        }
        System.out.println();
    }

    public void checkRewards(Enemy enemy){
        gold += enemy.gold;
        leveUp(enemy.rewardExp);
    }
}
