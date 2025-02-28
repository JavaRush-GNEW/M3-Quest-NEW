package controller;

import model.Question;
import repository.QuestionRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "QuizServlet", value = "/quiz")
public class QuizServlet extends HttpServlet {
    private static final QuestionRepository questionRepository = QuestionRepository.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ArrayList<Question> questions = questionRepository.getAll();


        req.getSession().setAttribute("test", "Привіт!");


        // redirect

        resp.sendRedirect(req.getContextPath() + "/quiz.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Placeholder for POST handling logic
        resp.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "POST method is not supported.");
    }
}
