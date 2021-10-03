package com.company;

public class BossRoom {
    Player player;

    public BossRoom(Player player){
        this.player = player;
        intro();
    }

    public void intro(){
        System.out.println("You have entered the final room");
        System.out.println("\n<< Hey you need to prepare yourself. >>");
        System.out.println("<< This is the Master Suite Lounge, where the House Owner resides >>");
        System.out.println(": The person responsible for looking me in this mad house?");
        System.out.println("<< Yes, but...>>");
        System.out.println(": But...nothing. I want out and defeating them is house I get out.");
        System.out.println("<< ??? >>");
        System.out.println(": At least wish me luck.");
        System.out.println("<< Good Luck >>");
        System.out.println("\nThe guide disappears and you brace yourself before entering.");
        BossEnemy  bossEnemy = new BossEnemy(player);
    }
}
