package com.game.model;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Map;

class StoryTest {
    private Story story;

    @BeforeEach
    void setUp() {
        story = new Story();
    }

    @Test
    void testGetScene_ValidScene() {
        Story.Scene scene = story.getScene("start");
        assertNotNull(scene, "Scene should not be null");
        assertEquals("You stand at a fork in the road. Where do you go? (left/right)", scene.getText());
        assertEquals(Map.of("left", "left_path", "right", "right_path"), scene.getChoices());
    }

    @Test
    void testGetScene_InvalidScene() {
        Story.Scene scene = story.getScene("invalid_key");
        assertNotNull(scene, "Scene should not be null");
        assertEquals("Error: Unknown scene", scene.getText());
        assertTrue(scene.getChoices().isEmpty(), "Unknown scene should have no choices");
    }

    @Test
    void testIsEndScene_True() {
        assertTrue(story.isEndScene("open"), "Scene 'open' should be an end scene");
        assertTrue(story.isEndScene("ignore"), "Scene 'ignore' should be an end scene");
        assertTrue(story.isEndScene("run"), "Scene 'run' should be an end scene");
        assertTrue(story.isEndScene("fight"), "Scene 'fight' should be an end scene");
    }

    @Test
    void testIsEndScene_False() {
        assertFalse(story.isEndScene("start"), "Scene 'start' should not be an end scene");
        assertFalse(story.isEndScene("left_path"), "Scene 'left_path' should not be an end scene");
        assertFalse(story.isEndScene("right_path"), "Scene 'right_path' should not be an end scene");
    }

    @Test
    void testSceneChoices() {
        Story.Scene scene = story.getScene("left_path");
        assertEquals(Map.of("yes", "open", "no", "ignore"), scene.getChoices());

        scene = story.getScene("right_path");
        assertEquals(Map.of("yes", "run", "no", "fight"), scene.getChoices());
    }
}