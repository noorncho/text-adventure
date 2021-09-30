package com.company;

import java.util.Scanner;

public class Game {
    Player player;
    Basement basement;

    public Game(){
        gameIntro();
    }

    public void gameIntro(){
        System.out.println("Welcome to the Little Adventure.");
        System.out.println("Before we start, what should we call you?");
        Scanner scan = new Scanner(System.in);
        String playerName = scan.next();
        System.out.println("Hello " + playerName + ".");
        System.out.println("Shall we proceed? (y/n)");
        String choice = scan.next();

        if(choice.equalsIgnoreCase("Y")){
            System.out.println("Let's Begin");
            player = new Player(playerName);
            player.stats();
            basement = new Basement(player, this);

        }else if(choice.equalsIgnoreCase("N")){
            gameOver();

        }else{
            System.out.println("Invalid Input.");
            gameOver();
        }
    }

    public void gameOver(){
        System.out.println("Thank you for playing!");
        System.out.println("Goodbye!");
        System.exit(0);
    }
}
