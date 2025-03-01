package controller;

import model.Question;
import repository.QuestionRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "QuizServlet", value = "/quiz")
public class QuizServlet extends HttpServlet {
    private static final QuestionRepository questionRepository = QuestionRepository.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();

        if (session.getAttribute("gameOver") != null && (boolean) session.getAttribute("gameOver")) {
            session.invalidate();
            session = req.getSession(true);
        }

        ArrayList<Question> questions = questionRepository.getQuestions();
        session.setAttribute("questions", questions);

        Integer currentIndex = (Integer) session.getAttribute("currentIndex");
        if (currentIndex == null) {
            currentIndex = 0;
            session.setAttribute("currentIndex", currentIndex);
        }

        Question currentQuestion = questions.get(currentIndex);
        session.setAttribute("currentQuestionText", currentQuestion.getText());
        session.setAttribute("currentQuestionAnswers", currentQuestion.getAnswers());

        getServletContext().getRequestDispatcher("/quiz.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        ArrayList<Question> questions = (ArrayList<Question>) session.getAttribute("questions");
        Integer currentIndex = (Integer) session.getAttribute("currentIndex");

        if (questions == null || currentIndex == null) {
            resp.sendRedirect("index.jsp");
            return;
        }

        Question currentQuestion = questions.get(currentIndex);
        int correctAnswer = currentQuestion.getCorrectAnswer();
        int userAnswer = Integer.parseInt(req.getParameter("answer"));

        if (userAnswer == correctAnswer) {
            currentIndex++;
            if (currentIndex < questions.size()) {
                session.setAttribute("currentIndex", currentIndex);
                resp.sendRedirect("quiz");
            } else {
                session.setAttribute("gameOver", true);
                session.setAttribute("win", true);
                resp.sendRedirect("result.jsp");
            }
        } else {
            session.setAttribute("gameOver", true);
            session.setAttribute("win", false);
            resp.sendRedirect("result.jsp");
        }
    }
}