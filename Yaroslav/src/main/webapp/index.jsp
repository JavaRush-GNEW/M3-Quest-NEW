<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Start Game</title>
    <meta charset="UTF-8">
</head>
<body>
<h1>Welcome to the Text Adventure!</h1>
<form action="game" method="post">
    <label>Enter your name:</label>
    <input type="text" name="playerName" required>
    <button type="submit">Start</button>
</form>
</body>
</html>