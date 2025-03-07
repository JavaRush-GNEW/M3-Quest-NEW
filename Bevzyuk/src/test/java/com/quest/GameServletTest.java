package com.quest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class GameServletTest {

    @InjectMocks
    private GameServlet servlet;

    @Mock
    private HttpServletRequest request;

    @Mock
    private HttpServletResponse response;

    @Mock
    private HttpSession session;

    @Mock
    private RequestDispatcher dispatcher;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        servlet.init();

        when(request.getSession()).thenReturn(session);
        when(request.getRequestDispatcher("game.jsp")).thenReturn(dispatcher);
    }

    @Test
    void testInitQuestions() {
        assertNotNull(servlet.questions, "questions не має бути null");
        assertEquals("Ти стоїш перед дверима. Що робити?", servlet.questions.get(1).getText());
    }

    @Test
    void testDoGet_SetsSessionAttributesAndForwards() throws ServletException, IOException {
        when(request.getParameter("playerName")).thenReturn("Тарас");

        servlet.doGet(request, response);

        verify(session).setAttribute("questions", servlet.questions);
        verify(session).setAttribute("playerName", "Тарас");
        verify(session).setAttribute("step", 1);
        verify(dispatcher).forward(request, response);
    }

    @Test
    void testDoPost_UpdatesStepAndRedirects() throws IOException {
        when(session.getAttribute("step")).thenReturn(1);
        when(request.getParameter("choice")).thenReturn("Відкрити двері");

        Map<Integer, Question> questions = servlet.questions;
        Question currentQuestion = questions.get(1);
        Integer expectedNextStep = currentQuestion.getOptions().get("Відкрити двері");

        servlet.doPost(request, response);

        verify(session).setAttribute("step", expectedNextStep);
        verify(response).sendRedirect("game.jsp");
    }
}

