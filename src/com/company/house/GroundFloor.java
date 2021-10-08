package com.company.house;

import com.company.City;
import com.company.Enemy;
import com.company.Player;

import java.util.Scanner;

public class GroundFloor {
    Player player;
    Enemy[] enemies;

    public GroundFloor(Player player){
        this.player = player;
        enemies = new Enemy[5];
        intro();
    }

    public void intro(){
        System.out.println("\n \n \n");
        System.out.println("You wake up on the on the cold floor in a large seemingly empty room.");
        System.out.println("Looking around, you realize that you are in a Grand Entry way of what seems like and " +
                "empty house.");
        System.out.println("Getting to your feet, you dust off your clothes and look around to get a better bearing " +
                "of yourself.");
        System.out.println("The house seems well taken care off but is eerily silent.");
        System.out.println("There are two door, one to your right and left, a grand staircase in front and the main " +
                "door behind you.");
        firstChoice();
    }

    private void firstChoice() {
        System.out.println("\nWhere would you like to go?\nEnter a number: \n(1) Right Door\n(2) Left Door\n(3) " +
                "Staircase\n(4) Main Door ");
        Scanner scan = new Scanner(System.in);
        int choice = scan.nextInt();
        switch (choice){
            case 1:
                System.out.println("\nYou have decided to try the right door.");
                rightDoor();
                break;
            case 2:
                System.out.println("\nYou have decided to try the left door");
                //lockedDoor();
                leftRoom();
                break;
            case 3:
                System.out.println("\nYou have decided to take the stairs");
                System.out.println("You begin to make your way to the next floor of the house.");
                BossRoom bossRoom = new BossRoom(player);
                break;
            case 4:
                System.out.println("\nMaking the obvious choice you try the main door");
                System.out.println("Giving the door a strong tug, it does not budge.");
                System.out.println("You will have to find another way out of this house.");
                firstChoice();
                break;
            default:
                System.out.println("Invalid Option. Try Again");
                firstChoice();
        }
    }

    public void lockedDoor(){
        System.out.println("Looks like that door is locked, and you will have to find another way.");
        firstChoice();
    }

    public void rightDoor(){
        System.out.println("The door unlocks and you walk in and find yourself walking into a library.");
    }

    public void leftRoom(){
        System.out.println("The door unlocks and you walk into a long empty hallway.");
        System.out.println("As you take a step forward the door slams shut behind you and the floor open under you.");
        System.out.println("You black out as you continue to fall.");
        System.out.println("\n \n");
        City city = new City(player);
    }
}
