<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.game.model.GameState" %>
<%
    GameState gameState = (GameState) session.getAttribute("gameState");
%>
<html>
<head>
    <title>Text Adventure</title>
    <meta charset="UTF-8">
</head>
<body>
<h1>Text Adventure</h1>
<p><%= gameState.getCurrentText() %></p>

<form action="game" method="post">
    <input type="text" name="choice" placeholder="Enter your choice" required>
    <button type="submit">Choose</button>
</form>
</body>
</html>