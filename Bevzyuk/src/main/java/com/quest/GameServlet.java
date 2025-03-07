package com.quest;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/game")
public class GameServlet extends HttpServlet {
    Map<Integer, Question> questions;

    @Override
    public void init() {
        questions = new HashMap<>();

        questions.put(1, new Question("Ти стоїш перед дверима. Що робити?", Map.of(
                "Відкрити двері", 2,
                "Йти геть", 9
        ), false));

        questions.put(2, new Question("Ти потрапив у темний коридор. Йти ліворуч чи праворуч?", Map.of(
                "Ліворуч", 3,
                "Праворуч", 4
        ), false));

        questions.put(3, new Question("Ти знайшов стару скриню. Взяти ключ?", Map.of(
                "Так", 6,
                "Ні", 7
        ), false));

        questions.put(4, new Question("Ти потрапив у пастку з шипами! Гра закінчена. 😵", Map.of(), true));

        questions.put(6, new Question("Ти підійшов до великих воріт. Відкрити їх ключем?", Map.of(
                "Відкрити", 8,
                "Повернутися", 2
        ), false));

        questions.put(7, new Question("Ти бачиш великі ворота, але вони зачинені. Що робити?", Map.of(
                "Повернутися", 2,
                "Сісти і чекати", 10
        ), false));

        questions.put(8, new Question("Вітаю! Ти відкрив ворота і знайшов величезний скарб! 🏆", Map.of(), true));

        questions.put(9, new Question("Ти вирішив покинути квест. Може, спробуєш ще раз? 🚪", Map.of(), true));

        questions.put(10, new Question("Ти сів чекати, але ніхто не прийшов... Гра закінчена. ⏳", Map.of(), true));
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession();

        Integer step = (Integer) session.getAttribute("step");

        String choice = request.getParameter("choice");

        Question currentQuestion = questions.get(step);
        Integer nextStep = currentQuestion.getOptions().get(choice);

        session.setAttribute("step", nextStep);

        response.sendRedirect("game.jsp");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        session.setAttribute("questions", questions);
        String playerName = request.getParameter("playerName");
        session.setAttribute("playerName", playerName);
        session.setAttribute("step", 1);

        request.getRequestDispatcher("game.jsp").forward(request, response);
    }
}
