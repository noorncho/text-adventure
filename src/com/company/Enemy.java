package com.company;

public class Enemy {
    public String name;
    public int maxHp, currentHp, level;
    public int gold, rewardExp;
    public int maxAttackDamage;
    private boolean alive;

    public Enemy(String name, int maxHp, int maxAttackDamage, int level, int gold, int rewardExp) {
        this.name = name;
        this.currentHp = this.maxHp = maxHp;
        this.maxAttackDamage = maxAttackDamage;
        this.level = level;
        this.gold = gold;
        this.rewardExp = rewardExp;
        alive = true;
    }

    public boolean isAlive() {
        return alive;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }
}
