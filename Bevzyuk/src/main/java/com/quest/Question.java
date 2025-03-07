package com.quest;

import java.util.Map;

public class Question {
    private String text;
    private Map<String, Integer> options;
    private boolean isEnding;

    public Question(String text, Map<String, Integer> options, boolean isEnding) {
        this.text = text;
        this.options = options;
        this.isEnding = isEnding;
    }

    public String getText() {
        return text;
    }

    public Map<String, Integer> getOptions() {
        return options;
    }

    public boolean isEnding() {
        return isEnding;
    }
}