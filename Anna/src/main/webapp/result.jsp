<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="uk">
<head>
    <title>Результат</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
            crossorigin="anonymous"></script>
    <link rel="stylesheet" href="css/styles.css">
</head>
<body class="text-center d-flex justify-content-center align-items-center vh-100">
<div class="card p-4 w-50">
    <h2 class="mt-4">
        <% Boolean win = (Boolean) session.getAttribute("win"); %>
        <% if (win != null && win) { %>
        <img src="resources/images/gods.jpg" class="w-50 game-image" alt="Боги Олімпу">
        <p style="margin-top: 20px">Вітаємо! Ти пройшов усі випробування! Ти гідний отримати дари від Нас, та зможеш
            відвернути катастрофу!</p>
        <% } else { %>
        <p>На жаль, ти програв. Боги не дали тобі сили.</p>
        <% } %>
    </h2>
    <form action="quiz" method="get">
        <button type="submit" class="btn btn-custom mt-3">Почати спочатку</button>
    </form>
</div>
</body>
</html>