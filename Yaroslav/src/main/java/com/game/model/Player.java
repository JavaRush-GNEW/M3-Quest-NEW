package com.game.model;

import java.io.Serializable;

public class Player implements Serializable {
    private String name;
    private int gamesPlayed;
    private int gamesWon;

    public Player(String name) {
        this.name = name;
        this.gamesPlayed = 0;
        this.gamesWon = 0;
    }

    public String getName() {
        return name;
    }

    public int getGamesPlayed() {
        return gamesPlayed;
    }

    public int getGamesWon() {
        return gamesWon;
    }

    public void incrementGamesPlayed() {
        gamesPlayed++;
    }

    public void incrementGamesWon() {
        gamesWon++;
    }
}