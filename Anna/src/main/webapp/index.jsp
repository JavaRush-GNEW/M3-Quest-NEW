<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="uk">
<head>
    <title>Випробування богів</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
            crossorigin="anonymous"></script>
    <link rel="stylesheet" href="css/styles.css">
</head>
<body>
<div class="container">
    <img src="resources/images/gods.jpg" alt="Боги Олімпу" class="w-50 game-image">
    <h1 class="mt-4 display-5 fw-bold text-uppercase text-shadow">Ласкаво просимо, смертний!</h1>
    <p class="lead">Світ на межі загибелі. Оракули передбачили катастрофу – гігантський вогняний астероїд мчить до
        Землі.
        Жодна смертна істота не здатна його зупинити. Але у тебе є шанс…</p>
    <p>Боги Олімпу готові дарувати тобі силу, що зможе відвернути катастрофу. Проте їхні дари треба заслужити –
        на тебе чекають випробування. Кожен з богів перевірить твою мудрість, мужність і вірність.
        Помилка означає загибель.</p>
    <p class="lead text-danger fw-bold">Чи готовий ти прийняти виклик?</p>
    <form action="quiz" method="get">
        <button type="submit" class="btn btn-custom btn-lg">Прийняти виклик</button>
    </form>
</div>
</body>
</html>