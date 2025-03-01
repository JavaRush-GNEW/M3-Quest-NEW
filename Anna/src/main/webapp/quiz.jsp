<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.ArrayList" %>
<%
    String questionText = (String) session.getAttribute("currentQuestionText");
    ArrayList<String> answers = (ArrayList<String>) session.getAttribute("currentQuestionAnswers");

    String godImage = "resources/images/gods.jpg";

    if (questionText.contains("Зевс")) {
        godImage = "resources/images/zeus.png";
    } else if (questionText.contains("Посейдон")) {
        godImage = "resources/images/poseidon.webp";
    } else if (questionText.contains("Афіна")) {
        godImage = "resources/images/athena.webp";
    } else if (questionText.contains("Аїд")) {
        godImage = "resources/images/hades.webp";
    } else if (questionText.contains("Арес")) {
        godImage = "resources/images/ares.jpg";
    }
%>

<html lang="uk">
<head>
    <title>Випробування богів</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <link rel="stylesheet" href="css/styles.css">
</head>
<body>
<div class="container d-flex justify-content-center align-items-center vh-100">
    <div class="card text-center w-75">
        <h2 class="card-title">Випробування богів</h2>
        <img src="<%= godImage %>" class="img-fluid mx-auto d-block" style="height: 250px;" alt="Бог Олімпу">
        <div class="card-body">
            <p class="card-text fs-4"><%= questionText %>
            </p>
            <form action="quiz" method="post">
                <% for (int i = 0; i < answers.size(); i++) { %>
                <button type="submit" name="answer" value="<%= i %>" class="btn btn-primary d-block my-2 w-50 mx-auto">
                    <%= answers.get(i) %>
                </button>
                <% } %>
            </form>
        </div>
    </div>
</div>
</body>
</html>