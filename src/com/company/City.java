package com.company;

import java.util.Scanner;

public class City {

    Player player;
    public boolean hasID;

    public City(Player player){
        this.player = player;
        hasID = false;
        intro();
    }

    public void intro(){
        System.out.println("\n \n \n");
        System.out.println("Waking up in the bushes you stubble to your feet, and throw up immediately.");
        System.out.println("The last thing you remember are fighting against a guard in a basement, and some annoying" +
                " voice telling you not to throw up.");
        System.out.println("Looking around, it would appear that you are just outside the gates of a large city.");
        System.out.println("Dusting off your clothes, you join the line of people and wagons trying to get into the " +
                "city.");
        cityEntrance();
    }

    public void cityEntrance(){
        Scanner scan = new Scanner(System.in);
        if(player.getLevel() == 2){
            System.out.println("Standing in line something pulls at your arm.");
            System.out.println("Old Beggar: Spare some change for an old beggar.");
            System.out.println("What do you do? (1) Give them some change / (2) Tell them to go away\n");
            int choice = scan.nextInt();
            switch (choice){
                case 1:
                    System.out.println(player.getName()+": Sure. It's not much but it is something.");
                    System.out.println("You give the old beggar 2G.");
                    player.spendGold(2);
                    System.out.println("Old Beggar: Thank you. Your generosity will be rewarded.");
                    System.out.println(player.getName() + ":Your welcome.");
                    System.out.println("Old Beggar: For your generosity");
                    System.out.println("The beggar hands you a small pouch with a few coins and a letter of " +
                            "identification.");
                    System.out.println(player.getName() + "Thank you. This is exactly what I...");
                    System.out.println("Before you can respond, the Beggar has disappeared and you are almost at the " +
                            "front of the line.");
                    Item item = new Item("Player ID", 2000, true);
                    player.inventory.add(item);
                    player.gainExp(2);
                    player.addGold(10);
                    break;
                case 2:
                    System.out.println("You shake the beggar off your arm.");
                    System.out.println(player.getName()+ "Go away. I don't have anything to give you.");
                    System.out.println("Old Beggar: A little generosity can result in greater gifts.");
                    break;
            }
        }

        if(!hasID){
            for(Item item: player.inventory){
                if(item.getName() == "Player ID"){

                }
            }
        }
    }
}
