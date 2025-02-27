package com.game.model;

public class GameState {
    private final Story story;
    private String currentScene;
    private boolean gameOver;

    public GameState() {
        this.story = new Story();
        this.currentScene = "start";
        this.gameOver = false;
    }

    public void processChoice(String choice) {
        Story.Scene scene = story.getScene(currentScene);

        if (scene != null) {
            System.out.println("=== PROCESSING CHOICE ===");
            System.out.println("Current scene: " + currentScene);
            System.out.println("Scene text: " + scene.getText());
            System.out.println("Available choices: " + scene.getChoices().keySet());
            System.out.println("Player input: '" + choice + "' (Length: " + choice.length() + ")");

            String normalizedChoice = choice.trim().toLowerCase();
            System.out.println("After processing: '" + normalizedChoice + "' (Length: " + normalizedChoice.length() + ")");

            if (scene.getChoices().containsKey(normalizedChoice)) {
                currentScene = scene.getChoices().get(normalizedChoice);
                gameOver = story.isEndScene(currentScene);

                System.out.println("Choice accepted! New scene: " + currentScene);
                System.out.println("New scene text: " + story.getScene(currentScene).getText());
                System.out.println("=== END OF PROCESSING ===");
            } else {
                System.out.println("Invalid choice! Try again.");
            }
        } else {
            System.out.println("Error: Scene not found.");
        }
    }

    public String getCurrentText() {
        Story.Scene scene = story.getScene(currentScene);
        return (scene != null) ? scene.getText() : "Error loading scene.";
    }

    public boolean isGameOver() {
        return gameOver;
    }
}