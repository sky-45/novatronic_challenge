package test;

import main.Player;
import main.TennisGame;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TennisGameTest {

    @Test
    void setPlayers() {
        Player p1 = new Player();
        Player p2 = new Player();
        TennisGame game = new TennisGame();
        game.setPlayers(p1, p2);
        assertEquals(game.getFirstPlayer().getName(), p1.getName());
        assertEquals(game.getSecondPlayer().getName(), p2.getName());
    }

    @Test
    void resetPoints() {
        Player p1 = new Player();
        p1.setName("johan 1");
        Player p2 = new Player();
        p2.setName("johan 2");
        TennisGame game = new TennisGame();
        game.setPlayers(p1, p2);
        game.assignPointsToWinner(game.getFirstPlayer());
        game.assignPointsToWinner(game.getSecondPlayer());
        game.resetPoints();
        assertEquals(game.getFirstPlayer().getPoints(), 0);
        assertEquals(game.getSecondPlayer().getPoints(), 0);
    }

    @Test
    void getFirstPlayer() {
        Player p1 = new Player();
        p1.setName("johan 1");
        Player p2 = new Player();
        p2.setName("johan 2");
        TennisGame game = new TennisGame();
        game.setPlayers(p1, p2);

        game.resetPoints();
        assertEquals(game.getFirstPlayer().getName(), p1.getName());
    }

    @Test
    void setFirstPlayer() {
        Player p1 = new Player();
        p1.setName("johan 1");
        TennisGame game = new TennisGame();
        game.setFirstPlayer(p1);
        assertEquals(game.getFirstPlayer().getName(), p1.getName());
    }

    @Test
    void getSecondPlayer() {
        Player p1 = new Player();
        p1.setName("johan 1");
        Player p2 = new Player();
        p2.setName("johan 2");
        TennisGame game = new TennisGame();
        game.setPlayers(p1, p2);

        game.resetPoints();
        assertEquals(game.getSecondPlayer().getName(), p2.getName());
    }

    @Test
    void setSecondPlayer() {
        Player p2 = new Player();
        p2.setName("johan 2");
        TennisGame game = new TennisGame();
        game.setSecondPlayer(p2);
        assertEquals(game.getSecondPlayer().getName(), p2.getName());
    }
}