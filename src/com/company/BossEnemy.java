package com.company;

public class BossEnemy {

    Player player;
    Enemy gameBoss;

    public BossEnemy(Player player){
        this.player = player;
        gameBoss = new Enemy("House Owner", 1000, 50, 50, 5000, 1000);
        intro();
    }

    public void intro(){
        bossFight();
    }

    public void bossFight(){
        BattleLogic battleLogic = new BattleLogic();
        battleLogic.battle(player, gameBoss);
        if(!player.alive){
            System.out.println("<<I did warn you before, that you might not be ready to face them.>>");
            System.out.println("<<But you didn't listen to me. They never listen to me.>>");
            System.out.println("<<Now look at you. But you did make better progress than the other.>>");
            System.out.println("<<Good effort though. Bye Bye.>>");
            System.out.println("\n\n********** NOTICE: **********");
            System.out.println("        YOU HAVE DIED!");
            System.out.println("WE HAD HIGH HOPES FOR YOU.");
            System.out.println("BUT APPRECIATE YOUR EFFORT");
            System.out.println("         GAME OVER!!");
        }
    }
}
