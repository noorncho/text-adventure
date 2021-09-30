package com.company;

public class City {

    Player player;

    public City(Player player){
        this.player = player;
        intro();
    }

    public void intro(){
        System.out.println("Waking up in the bushes you stubble to your feet, and throw up immediately.");
        System.out.println("The last thing you remember are fighting against a guard in a basement, and some annoying" +
                " voice telling you not to throw up.");
        System.out.println("Looking around, it would appear that you are just outside the gates of a large city.");
        System.out.println("Dusting off your clothes, you join the line of people and wagons trying to get into the " +
                "city.");

    }
}
