package test;

import main.Player;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {

    @Test
    void getName() {
        Player player = new Player();
        String newName = "JohanGet";
        player.setName(newName);
        assertEquals(player.getName(), newName);
    }

    @Test
    void setName() {
        Player player = new Player();
        String newName = "Johanset";
        player.setName(newName);
        assertEquals(player.getName(), newName);
    }

    @Test
    void getPoints() {
        Player player = new Player();
        int newPoints = 2;
        player.setPoints(newPoints);
        assertEquals(player.getPoints(), newPoints);
    }

    @Test
    void setPoints() {
        Player player = new Player();
        int newPoints = 4;
        player.setPoints(newPoints);
        assertEquals(player.getPoints(), newPoints);
    }
}