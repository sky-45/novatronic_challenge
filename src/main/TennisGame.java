package main;

import java.util.Scanner;
import java.util.HashMap;

public class TennisGame {
    private Player firstPlayer;
    private Player secondPlayer;
    private final HashMap<Integer,String> hashLabelScores;

    public TennisGame(){
        this.hashLabelScores = new HashMap<>();
        this.hashLabelScores.put(0,"Love");
        this.hashLabelScores.put(1,"Fifteen");
        this.hashLabelScores.put(2,"Thirty");
        this.hashLabelScores.put(3,"Forty");
    }
    public void setPlayers(Player player1,Player player2) {
        this.setFirstPlayer(player1);
        this.setSecondPlayer(player2);
        this.firstPlayer.setPoints(0);
        this.firstPlayer.setPoints(0);
    }
    private Player calculateWinner(){
        double probability = Math.random();

        return probability < 0.5 ? firstPlayer : secondPlayer;
    }
    private void assignPointsToWinner(Player winner) {
        if(winner.getName().equals(this.firstPlayer.getName())){
            this.firstPlayer.setPoints(this.firstPlayer.getPoints() + 1);
        }
        else{
            this.secondPlayer.setPoints(this.secondPlayer.getPoints() + 1);
        }
    }
    private boolean verifyIfWinner() {
        int firstPlayerPoints = this.firstPlayer.getPoints();
        int secondPlayerPoints = this.secondPlayer.getPoints();
        int difference = Math.abs(firstPlayerPoints - secondPlayerPoints);

        return (firstPlayerPoints >= 4 || secondPlayerPoints >= 4 ) && difference >= 2;
    }
    private String score() {
        int firstPlayerPoints = this.firstPlayer.getPoints();
        int secondPlayerPoints = this.secondPlayer.getPoints();

        if(this.verifyIfWinner()){
            if(firstPlayerPoints > secondPlayerPoints){
                return "Felicidades, Player ganador: " + this.firstPlayer.getName();
            }
            return "Felicidades, Player ganador: " + this.secondPlayer.getName();
        }

        if(firstPlayerPoints == secondPlayerPoints && firstPlayerPoints >= 3 ){
            return "Deuce";
        }
        if(firstPlayerPoints >= 3 && secondPlayerPoints >= 3 && Math.abs(firstPlayerPoints - secondPlayerPoints) == 1){
            return "Advantage: " + this.getPlayerNameWithAdvantage();
        }

        return "Player "+this.firstPlayer.getName()+" points: " + this.hashLabelScores.get(firstPlayerPoints) + ",Player "+this.firstPlayer.getName()+" points:" + this.hashLabelScores.get(secondPlayerPoints);
    }
    private String getPlayerNameWithAdvantage(){
        int firstPlayerPoints = this.firstPlayer.getPoints();
        int secondPlayerPoints = this.secondPlayer.getPoints();
        if(secondPlayerPoints > firstPlayerPoints){
            return this.secondPlayer.getName();
        }
        return this.firstPlayer.getName();
    }

    public void startGame() {
        boolean isThereAWinner = false;
        do{
            System.out.println("### INICIANDO RONDA ###");
            Player roundWinner = this.calculateWinner();
            this.assignPointsToWinner(roundWinner);
            String scoreStr = this.score();
            System.out.println(scoreStr);
            isThereAWinner = this.verifyIfWinner();
            Animations.wait(1000);
        }while(!isThereAWinner);
    }
    public void resetPoints(){
        this.firstPlayer.setPoints(0);
        this.secondPlayer.setPoints(0);

    }
    public boolean askContinueGame(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("###########################################");
        System.out.print("Desea continuar con el juego ? (1/Si, 2/No): ");
        String continueResult = scanner.next();


        boolean validAnswer = continueResult.equals("1") || continueResult.equals("2");

        while(!validAnswer && scanner.hasNextLine()) {
            System.out.println("Ingrese una de las opciones permitidas (1/Si, 2/No)");
            continueResult = scanner.nextLine();
            validAnswer = continueResult.equals("1") || continueResult.equals("2");
        }

        return Integer.parseInt(continueResult) == 1;
    }
    public void initializePlayers() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese el nombre del primer player:");
        String nameFirstPlayer = scanner.nextLine();

        System.out.println("Ingrese el nombre del segundo player:");
        String nameSecondPlayer = scanner.nextLine();

        Player firstPlayer = new Player();
        firstPlayer.setName(nameFirstPlayer);
        Player secondPlayer = new Player();
        secondPlayer.setName(nameSecondPlayer);

        this.setPlayers(firstPlayer, secondPlayer);
    }
    public Player getFirstPlayer() {
        return firstPlayer;
    }
    public void setFirstPlayer(Player firstPlayer) {
        this.firstPlayer = firstPlayer;
    }
    public Player getSecondPlayer() {
        return secondPlayer;
    }
    public void setSecondPlayer(Player secondPlayer) {
        this.secondPlayer = secondPlayer;
    }
}
