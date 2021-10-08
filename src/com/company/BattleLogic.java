package com.company;

import java.util.Random;
import java.util.Scanner;

public class BattleLogic {

    /**
     * Battle Logic for single enemy
     * @param player
     * @param enemy
     */
    public void battle(Player player, Enemy enemy){
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
                if((player.inventory.get(index) instanceof Weapon) && player.inventory.get(index).isUsable()){
                    player.equipWeapon(player.inventory.get(index));
                    player.setMaxAttack(((Weapon) player.inventory.get(index)).getMaxDamage());
                    minAttack = ((Weapon) player.getEquippedWeapon()).getMinDamage();
                    player.inventory.remove(index);
                }
                System.out.println("Weapon Equipped. Fight Begin");
            }else{
                System.out.println("Fight Begin");
            }
        }else{
            System.out.println("Prepare to Battle.");
        }

        //Enemy enemy = enemies[0];
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

                }
            }
            System.out.println("Player: " + player.getCurrentHp() + "/" + player.getMaxHp());
            System.out.println("Enemy: " + enemy.currentHp + "/" + enemy.maxHp);

            System.out.println();
            turn++;
        }

        System.out.println("Fight Over");
    }
}
