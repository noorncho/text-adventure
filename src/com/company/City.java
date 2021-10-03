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
        //First time coming to the city
        if(player.getLevel() == 2){
            System.out.println("\nStanding in line something pulls at your arm.");
            System.out.println("Old Beggar: Spare some change for an old beggar.");
            System.out.println("What do you do? (1) Give them some change / (2) Tell them to go away\n");
            int choice = scan.nextInt();
            switch (choice){
                case 1:
                    System.out.println(player.getName()+": Sure. It's not much but it is something.");
                    System.out.println("You give the old beggar 2 Gold.");
                    player.spendGold(2);
                    System.out.println("Old Beggar: Thank you. Your generosity will be rewarded.");
                    System.out.println(player.getName() + ":Your welcome.");
                    System.out.println("Old Beggar: For your generosity");
                    System.out.println("The beggar hands you a small pouch with a few coins and a letter of " +
                            "identification.\n");
                    System.out.println(player.getName() + ": Thank you. This is exactly what I...");
                    System.out.println("Before you can respond, the Beggar has disappeared and you are almost at the " +
                            "front of the line.");
                    Item item = new Item("Player ID", 2000, true);
                    player.inventory.add(item);
                    hasID = true;
                    player.gainExp(2);
                    player.addGold(10);
                    break;
                case 2:
                    System.out.println("You shake the beggar off your arm.");
                    System.out.println(player.getName()+ "Go away. I don't have anything to give you.");
                    System.out.println("Old Beggar: A little generosity can result in greater gifts.");
                    System.out.println("Not thinking much about the Beggar, you focus back on the front of gates.");
                    break;
            }
        }

        //Every other time check if player has gained ID
        if(!hasID){
            for(Item item: player.inventory){
                if(item.getName() == "Player ID"){
                    hasID = true;
                    break;
                }
                if (item.getName() == "Temporary Player ID"){
                    hasID = true;
                    item.reduceNumUses();
                    break;
                }
            }
        }
        cityGate();
    }

    public void cityGate(){
        Scanner scan = new Scanner(System.in);
        int choice = 0;
        System.out.println();
        System.out.println("Gatekeeper: Identification?");
        if(hasID){
            System.out.println("\nYou hand the Gatekeeper your ID for them to review.");
            System.out.println("They scrutinize it, before writing something down and handing it back to you.");
            System.out.println("\nGatekeeper: Thank you, and Welcome to Salt Mark.");
            System.out.println(player.getName() + ": Thanks.");
            System.out.println("You take back your ID and enter the city.");
            cityTavern();
        }else{
            System.out.println(player.getName() + ": ID?");
            System.out.println("The Gatekeeper looks up over their glasses.");
            System.out.println("Gatekeeper: Yes, ID? All those entering the city are required to present ID. Do you " +
                    "have any?");
            System.out.println(player.getName() + ": No.");
            System.out.println("Gatekeeper: Then you will have to purchase a temporary one until you can acquire a " +
                    "proper one.");
            System.out.println(player.getName() + ": How much?");
            System.out.println("Gatekeeper: 50 Gold Pieces. Would you like to buy it?");
            System.out.println("Buy a temporary ID? (1) Yes / (2)No");
            choice = scan.nextInt();
            switch (choice){
                case 1:
                    if(player.getGold() >= 50){
                        System.out.println(": Sure.");
                        Item item = new Item("Temporary Player ID", 5, true);
                    }
                    break;
                case 2:
                    break;
            }
        }
    }

    private void cityTavern() {
    }
}
