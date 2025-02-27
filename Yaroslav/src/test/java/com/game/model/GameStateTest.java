package com.game.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class GameStateTest {
    private GameState gameState;

    @BeforeEach
    void setUp() {
        gameState = new GameState();
    }

    @Test
    void testInitialState() {
        assertEquals("You stand at a fork in the road. Where do you go? (left/right)", gameState.getCurrentText());
        assertFalse(gameState.isGameOver(), "Game should not be over at the start");
    }

    @Test
    void testProcessChoice_ValidPath_Left() {
        gameState.processChoice("left");
        assertEquals("You found a chest. Open it? (yes/no)", gameState.getCurrentText());
        assertFalse(gameState.isGameOver());
    }

    @Test
    void testProcessChoice_ValidPath_Right() {
        gameState.processChoice("right");
        assertEquals("You met a wolf. Run away? (yes/no)", gameState.getCurrentText());
        assertFalse(gameState.isGameOver());
    }

    @Test
    void testProcessChoice_Ending_Open() {
        gameState.processChoice("left");
        gameState.processChoice("yes"); // Opens the chest
        assertEquals("You found a treasure! (end)", gameState.getCurrentText());
        assertTrue(gameState.isGameOver(), "Game should be over after finding the treasure");
    }

    @Test
    void testProcessChoice_Ending_Run() {
        gameState.processChoice("right");
        gameState.processChoice("yes"); // Runs away from wolf
        assertEquals("You escaped safely. (end)", gameState.getCurrentText());
        assertTrue(gameState.isGameOver(), "Game should be over after escaping");
    }

    @Test
    void testProcessChoice_InvalidInput() {
        gameState.processChoice("unknown");
        assertEquals("You stand at a fork in the road. Where do you go? (left/right)", gameState.getCurrentText());
        assertFalse(gameState.isGameOver(), "Game should not be over after an invalid input");
    }
}