<%@ page import="model.Scene" %>
<%@ page import="model.Question" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <title>Квест</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
    <style>
        body {
            justify-content: center;
            align-items: center;
            font-size: 25px;
            height: 100vh;
            text-align: center;
            margin: 0;
            background: black url('https://wallpapers.com/images/hd/spooky-desktop-4teoicop8jgnvcbh.jpg') no-repeat center;
            color: white;
            text-shadow: 2px 2px 4px rgba(0, 0, 0, 0.7);
        }
    </style>
</head>
<body>

    <h1>Квестова гра</h1>
    <%
        Scene scene = (Scene) request.getAttribute("scene");
    %>

    <h2>Локація: <%= scene.getName() %></h2>

    <% if (scene.isFinal()) { %>
    <p><b><%= scene.getName() %></b></p>
    <form action="/restart" method="get">
        <button type="submit" name="restart" value="true">Почати заново</button>
    </form>
    <% } else { %>
    <form action="/quiz" method="post">
        <%
            List<Question> questions = scene.getQuestions();
            if (questions != null) {
                for (int i = 0; i < questions.size(); i++) {
                    Question question = questions.get(i);
        %>
        <input type="radio" name="answer" value="<%= i %>" required>
        <label><%= question.getName() %></label><br>
        <%
                }
            }
        %>

        <button type="submit">Вибрати</button>
    </form>
    <% } %>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
</body>
</html>
