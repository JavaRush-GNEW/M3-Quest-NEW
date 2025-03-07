package controller;

import model.Scene;
import service.QuizService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/quiz")
public class QuizServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        QuizService quizService = (QuizService) session.getAttribute("quizService");

        if (quizService == null || request.getParameter("restart") != null) {
            quizService = new QuizService();
            session.setAttribute("quizService", quizService);
        }

        Scene currentScene = quizService.getCurrentScene();
        request.setAttribute("scene", currentScene);
        request.getRequestDispatcher("quiz.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        QuizService quizService = (QuizService) session.getAttribute("quizService");

        int answer = Integer.parseInt(request.getParameter("answer"));
        Scene currentScene = quizService.makeStep(answer);
        session.setAttribute("currentScene", currentScene);

        request.setAttribute("scene", currentScene);
        request.setAttribute("questions", currentScene.getQuestions());
        request.getRequestDispatcher("quiz.jsp").forward(request, response);
    }
}
