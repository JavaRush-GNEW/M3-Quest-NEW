<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.game.model.Player" %>
<%
    Player player = (Player) session.getAttribute("player");
%>
<html>
<head>
    <title>Game Over</title>
    <meta charset="UTF-8">
</head>
<body>
<h1>Game Over!</h1>
<p>Player Name: <%= player.getName() %></p>
<p>Games Played: <%= player.getGamesPlayed() %></p>
<p>Games Won: <%= player.getGamesWon() %></p>

<form action="index.jsp">
    <button type="submit">Play Again</button>
</form>
</body>
</html>