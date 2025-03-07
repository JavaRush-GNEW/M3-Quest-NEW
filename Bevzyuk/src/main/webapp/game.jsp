<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.Map" %>
<%@ page import="com.quest.Question" %>
<%@ page import="javax.servlet.http.HttpSession" %>
<html>
<head>
    <title>Квест</title>
    <link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
<%
    session = request.getSession();
    String playerName = (String) session.getAttribute("playerName");
    Integer step = (Integer) session.getAttribute("step");
    Map<Integer, Question> questions = (Map<Integer, Question>) session.getAttribute("questions");

    Question question = (questions != null) ? questions.get(step) : null;

    String headerText;
    if (question != null && !question.isEnding()) {
        headerText = "Удачі, " + (playerName != null ? playerName : "Гравцю") + "! Обери свій шлях:";
    } else if (question != null && question.isEnding()) {
        headerText = "Кінець гри, " + (playerName != null ? playerName : "Гравцю") + "!";
    } else {
        headerText = "Щось пішло не так, спробуй ще раз!";
    }
%>

<h2><%= headerText %></h2>

<% if (question != null) { %>
<p><%= question.getText() %></p>

<% if (!question.isEnding()) { %>
<form action="game" method="post">
    <% for (String option : question.getOptions().keySet()) { %>
    <button type="submit" name="choice" value="<%= option %>"><%= option %></button>
    <% } %>
</form>
<% } else { %>
<p><strong>Гра закінчена!</strong></p>
<a href="restart">Почати знову</a>
<% } %>
<% } else { %>
<p>Щось пішло не так. <a href="restart">Спробуйте знову</a></p>
<% } %>
</body>
</html>