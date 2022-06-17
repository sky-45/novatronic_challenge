package main;

public class Main {
    public static void main(String[] args) {

        TennisGame tennisGame = new TennisGame();

        Animations.launchGameAnimation();
        tennisGame.initializePlayers();

        boolean continueGame = true;

        do{
            tennisGame.startGame();
            continueGame = tennisGame.askContinueGame();
            if(continueGame) tennisGame.resetPoints();
        }while(continueGame);

        Animations.closeGameAnimation();
    }
}