package com.game.controller;

import com.game.model.GameState;
import com.game.model.Player;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/game")
public class GameServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        Player player = (Player) session.getAttribute("player");
        if (player == null) {
            String playerName = request.getParameter("playerName");
            if (playerName == null || playerName.trim().isEmpty()) {
                playerName = "Player";
            }
            player = new Player(playerName);
            session.setAttribute("player", player);
        }

        GameState gameState = (GameState) session.getAttribute("gameState");
        if (gameState == null) {
            gameState = new GameState();
            session.setAttribute("gameState", gameState);
        }

        if (gameState.getCurrentText().equals("You stand at a fork in the road. Where do you go? (left/right)")) {
            player.incrementGamesPlayed();
        }

        String userChoice = request.getParameter("choice");
        if (userChoice != null) {
            gameState.processChoice(userChoice);
        }

        if (gameState.isGameOver()) {
            if (gameState.getCurrentText().contains("treasure") || gameState.getCurrentText().contains("escaped")) {
                player.incrementGamesWon();
            }
            request.getRequestDispatcher("result.jsp").forward(request, response);
        } else {
            request.getRequestDispatcher("game.jsp").forward(request, response);
        }
    }
}