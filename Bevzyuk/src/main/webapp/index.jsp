<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Квест: Початок</title>
    <link rel="stylesheet" type="text/css" href="style.css">
</head>
<body class="start-page">
<div class="container">
    <h1>🔮 Ласкаво просимо до квесту! 🔮</h1>
    <p>Відчуй себе справжнім шукачем пригод! Введи своє ім’я та вирушай у подорож повну таємниць і небезпек.</p>
    <form action="game" method="get">
        <label for="playerName">Як тебе звати?</label>
        <input type="text" id="playerName" name="playerName" placeholder="Введіть ім'я" required>
        <button type="submit">🔓 Почати гру</button>
    </form>
</div>
</body>
</html>
