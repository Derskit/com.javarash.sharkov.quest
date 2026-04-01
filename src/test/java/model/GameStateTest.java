package model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class GameStateTest {

    @Test
    void testSetAndGetUsername() {
        GameState state = new GameState();
        state.setUsername("player");

        assertEquals("player", state.getUsername());
    }

    @Test
    void testSetAndGetScene() {
        GameState state = new GameState();
        state.setCurrentScene(2);

        assertEquals(2, state.getCurrentScene());
    }

    @Test
    void testSetAndGetSteps() {
        GameState state = new GameState();
        state.setSteps(5);

        assertEquals(5, state.getSteps());
    }

    @Test
    void testInitialValues() {
        GameState state = new GameState();

        assertNull(state.getUsername());
        assertEquals(0, state.getCurrentScene());
        assertEquals(0, state.getSteps());
    }
}