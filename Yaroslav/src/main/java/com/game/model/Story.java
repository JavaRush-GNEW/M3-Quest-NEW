package com.game.model;

import java.util.HashMap;
import java.util.Map;

public class Story {
    private final Map<String, Scene> scenes = new HashMap<>();

    public Story() {
        scenes.put("start", new Scene("You stand at a fork in the road. Where do you go? (left/right)",
                Map.of("left", "left_path", "right", "right_path")));

        scenes.put("left_path", new Scene("You found a chest. Open it? (yes/no)",
                Map.of("yes", "open", "no", "ignore")));

        scenes.put("right_path", new Scene("You met a wolf. Run away? (yes/no)",
                Map.of("yes", "run", "no", "fight")));

        scenes.put("open", new Scene("You found a treasure! (end)", Map.of()));
        scenes.put("ignore", new Scene("You walked away empty-handed. (end)", Map.of()));
        scenes.put("run", new Scene("You escaped safely. (end)", Map.of()));
        scenes.put("fight", new Scene("The wolf was stronger... (end)", Map.of()));
    }

    public Scene getScene(String sceneKey) {
        return scenes.getOrDefault(sceneKey, new Scene("Error: Unknown scene", Map.of()));
    }

    public boolean isEndScene(String sceneKey) {
        return !scenes.getOrDefault(sceneKey, new Scene("", Map.of())).hasChoices();
    }

    public static class Scene {
        private final String text;
        private final Map<String, String> choices;

        public Scene(String text, Map<String, String> choices) {
            this.text = text;
            this.choices = choices;
        }

        public String getText() {
            return text;
        }

        public Map<String, String> getChoices() {
            return choices;
        }

        public boolean hasChoices() {
            return !choices.isEmpty();
        }
    }
}