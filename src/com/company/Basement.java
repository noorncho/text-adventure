package com.company;

import java.util.Random;
import java.util.Scanner;

public class Basement {
    Player player;
    Enemy[] enemies;

    public Basement(Player player){
        this.player = player;
        this.enemies = new Enemy[2];
        enemies[0] = (new Enemy("Guard", 10, 4, 1, 10, 20));
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
            player.inventory.add(new Weapon("Old Dagger", 3, 5,65));
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
        System.out.println("Oh no! You have been spotted by an enemy. Time to choose?");
        System.out.println("(1) Fight? or (2) Bribe?");
        Scanner scan  = new Scanner(System.in);
        int choice = scan.nextInt();
        switch (choice){
            case 1:
                System.out.println("Let the battle begin!");
                battle();
                System.out.println("Your first battle is Over");
                break;
            case 2:
                if(player.getGold() < 10){
                    System.out.println("You don't have enough money to bribe your way out.");
                    System.out.println("Prepare to fight.");
                    battle();
                }else{
                    System.out.println("You were able to avoid a battle.");
                    System.out.println("Lets proceed");
                    System.out.println();
                    break;
                }
        }
    }

    public void battle(){
        int minAttack = 1;
        int maxAttack = player.getMaxAttack();

        //Give the player a chance to equip a weapon
        if(player.getEquippedWeapon() == null && !player.inventory.isEmpty()){
            System.out.println("Would you like to equip a weapon? (y/n) ");
            Scanner scan = new Scanner(System.in);
            if(scan.next().equalsIgnoreCase("y")){
                player.showInventory();
                System.out.println("Enter the number of the item you would like to use? ");
                int index = scan.nextInt();
                if(player.inventory.get(index) instanceof Weapon){
                    player.equipWeapon(player.inventory.get(index));
                    player.setMaxAttack(((Weapon) player.inventory.get(index)).getMaxDamage());
                    minAttack = ((Weapon) player.getEquippedWeapon()).getMinDamage();
                    player.inventory.remove(index);
                }
                System.out.println("Weapon Equipped. Fight Begin");
            }else{
                System.out.println("Fight Begin");
            }
        }

        Enemy enemy = enemies[0];
        Scanner scan = new Scanner(System.in);
        int turn = 1;
        Random rand = new Random();
        int playerChoice = 0;

        //Battle Logic
        while(enemy.currentHp > 0){
            if(player.getCurrentHp() <= 0){
                player.alive = false;
                break;
            }

            if(turn % 2 != 0){
                System.out.println("player turn");
                System.out.println("Select an option: (1)Attack (2)Block");
                int choice = scan.nextInt();
                playerChoice = choice;
                switch (choice){
                    case 1:
                        int randomAttack = rand.nextInt(maxAttack - minAttack + 1) + minAttack;
                        enemy.currentHp -= randomAttack;
                        System.out.println(enemy.currentHp);
                        System.out.println("You dealt " + randomAttack + " damage to the lv " + enemy.level +" " + enemy.name);
                        break;
                    case 2:
                        System.out.println("You chose to block.");
                        break;
                }
            }else{
                System.out.println(enemy.name + " turn");
                if(playerChoice == 2){
                    System.out.println("You took 1 damage!");
                    player.takeDamage(1);
                }else{
                    int attack = rand.nextInt(enemy.maxAttackDamage - 1 + 1) + 1;
                    player.takeDamage(attack);
                    System.out.println("The lv " + enemy.level + " "+ enemy.name + " dealt you " + attack + " damage.");
                    System.out.println(player.getCurrentHp());
                }
            }
            System.out.println();
            turn++;
        }

        System.out.println("Fight Over");

        if(player.alive){
            System.out.println("Congratulations!!!! You survived your first battle!");
            System.out.println("Lets check your rewards!");
            player.checkRewards(enemy);
        }else{
            System.out.println("NOTICE: YOU HAVE DIED");
            System.out.println("Oh no! It seems you were not able to defeat your first enemy.");
            System.out.println("Looks like I have to try picking better players in the future.");
            System.out.println("Anyway, thanks for playing.");
            System.out.println("Bye Bye.");
        }

    }
}
