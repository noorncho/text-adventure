package com.company;

import java.util.Random;
import java.util.Scanner;

public class Basement {
    Player player;
    Enemy[] enemies;
    Game game;

    public Basement(Player player, Game game){
        this.player = player;
        this.enemies = new Enemy[2];
        enemies[0] = (new Enemy("Guard", 10, 4, 1, 10, 20));
        this.game = game;
        intro();

    }

    public void intro(){
        System.out.println();
        System.out.println("Hello. You have woke up in a dark basement, with a single door.");
        System.out.println("What would like to do first? ");
        System.out.println("(L)ook around? or (O)pen Door? or anything else to quit?");
        Scanner scan = new Scanner(System.in);
        if(scan.next().equalsIgnoreCase("L")){
            System.out.println("A dagger has been added to your inventory.");
            player.inventory.add(new Weapon("Old Dagger", 3, 5,5));
            player.addMoney(5);
            System.out.println("Time to leave the room. Press (O) to continue");
            if(scan.next().equalsIgnoreCase("O")){
                firstHallway();
            }
        }else if(scan.next().equalsIgnoreCase("o")){
            System.out.println("You have left the room and the door locks behind you.");
            firstHallway();
        }
    }

    public void firstHallway(){
        System.out.println("<<Oh no! You have been spotted by an enemy. Time to choose?>>");
        System.out.println("(1) Fight? or (2) Bribe?");
        Scanner scan  = new Scanner(System.in);
        int choice = scan.nextInt();
        switch (choice){
            case 1:
                System.out.println("Let the battle begin!");
                fight(1);
                System.out.println("Your first battle is Over");
                break;
            case 2:
                if(player.getGold() < 10){
                    System.out.println("You don't have enough money to bribe your way out.");
                    System.out.println("Prepare to fight.");
                    fight(1);
                }else{
                    System.out.println("You were able to avoid a battle.");
                    System.out.println("Lets proceed");
                    System.out.println();
                    break;
                }
        }

        if(player.alive){
            enemies[0].setAlive(false);
            System.out.println("Congratulations!!!! You survived your first battle!");
            System.out.println("Lets check your rewards!");
            player.getEquippedWeapon().reduceNumUses();
            player.checkRewards(enemies[0]);
            System.out.println("Not bad. Let's check your current stats.");
            player.stats();
        }else{
            System.out.println("NOTICE: YOU HAVE DIED");
            System.out.println("Oh no! It seems you were not able to defeat your first enemy.");
            System.out.println("Looks like I have to try picking better players in the future.");
            System.out.println("Anyway, thanks for playing.");
            System.out.println("Bye Bye.");
            game.gameOver();
        }

        if(player.getCurrentHp() < player.getMaxHp()){
            System.out.println("<<It looks like you took some damage.>>");
            System.out.println("<<Lets try and fixed that.>>");
            HealingPotion hp1 = new HealingPotion("Common Healing Potion", 5);
            HealingPotion hp2 = new HealingPotion("Common Healing Potion", 5);
            System.out.println("<<Here are 2 healing potions for you troubles>>");
            System.out.println("Would you like to use them? (1) yes / (2) no");
            choice = scan.nextInt();
            switch (choice){
                case 1:
                    player.restoreHp(hp1.getMaxRestore());
                    player.restoreHp(hp2.getMaxRestore());
                    player.stats();
                    System.out.println("<<Great. Now that you look much better>>");
                    System.out.println( player.getName() + ": Thanks??");
                    break;
                case 2:
                    System.out.println("<<That's fine with me.>>");
                    System.out.println("<<They might be more helpful later anyway.>>");
                    player.inventory.add(hp1);
                    player.inventory.add(hp2);
                    break;
            }
        }
        System.out.println("<<Now lets get you out of here. Please don't throw up.>>");
        System.out.println("<<3...2...1...>>");
        System.out.println();
        System.out.println( "     **********NOTICE**********\n" +
                            " You have now cleared the tutorial area. \n" +
                            "   We look forward to your adventures.");

        //Leave the first scene and move to the city to continue on
        City city = new City(player);
    }

    public void fight(int numEnemies){
        Enemy enemy = enemies[0];
        BattleLogic battleLogic = new BattleLogic();
        battleLogic.battle(player, enemy);
    }
}
