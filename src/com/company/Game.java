package com.company;

import java.util.Scanner;

public class Game {
    Player player;
    Basement basement;

    public Game(){
        gameTitle();
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

    public void gameTitle(){
        /* Ogre - Font
        System.out.println("   __ _ _   _   _          _       _                 _                  \n"
                + "  / /(_) |_| |_| | ___    /_\\   __| |_   _____ _ __ | |_ _   _ _ __ ___ \n" + " / / | | __| __| " +
                "|/ _ \\  //_\\\\ / _` \\ \\ / / _ \\ '_ \\| __| | | | '__/ _ \\ \n" + "/ /__| | |_| |_| |  __/ /  _ " +
                " \\ (_| |\\ V /  __/ | | | |_| |_| | | |  __/ \n" + "\\____/_|\\__|\\__|_|\\___| \\_/ \\_/\\__,_| " +
                "\\_/ \\___|_| |_|\\__|\\__,_|_|  \\___|\n"+ "\n");
        */
        System.out.println("");
        System.out.println("   __ _ _   _   _               _       _                 _                  \n"
                + "  / /(_| |_| |_| | ___         /_\\   __| __   _____ _ __ | |_ _   _ _ __ ___ \n"
                + " / / | | __| __| |/ _ \\       //_\\\\ / _` \\ \\ / / _ | '_ \\| __| | | | '__/ _ \\ \n"
                + "/ /__| | |_| |_| |  __/      /  _  | (_| |\\ V |  __| | | | |_| |_| | | |  __/ \n"
                + "\\____|_|\\__|\\__|_|\\___|      \\_/ \\_/\\__,_| \\_/ \\___|_| |_|\\__|\\__,_|_|  \\___|\n"
                + "                                                                             ");

    }
}
