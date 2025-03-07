<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="uk">
<head>
  <meta charset="UTF-8">
  <title>Квестова гра</title>
  <style>
    body {
      font-family: Arial, sans-serif;
      font-size: 25px;
      text-align: center;
      padding: 50px;
      background: black url('https://wallpapers.com/images/hd/spooky-desktop-4teoicop8jgnvcbh.jpg') no-repeat center;
      color: white;
      text-shadow: 2px 2px 4px rgba(0, 0, 0, 0.7);
    }

    h1 { color: #FFD700; }

    .start-btn {
      background-color: #4CAF50;
      color: white;
      padding: 15px 30px;
      font-size: 18px;
      border: none;
      cursor: pointer;
      margin-top: 20px;
      border-radius: 10px;
      transition: 0.3s;
    }

    .start-btn:hover {
      background-color: #45a049;
      transform: scale(1.1); /* Легка анімація при наведенні */
    }
  </style>
</head>
<body>
<h1>Ласкаво просимо у квестову гру "Тінь минулого"</h1>
<p>Група учасників отримує загадковий лист із запрошенням до старовинного маєтку на околиці міста.
  Лист написаний від імені відомого історика Артема Лисенка, який зник безвісти 20 років тому.
  Він стверджує, що залишив у маєтку докази давньої змови, яка може змінити історію...</p>

<form action="quiz" method="get">
  <button type="submit" class="start-btn">Почати гру</button>
</form>
</body>
</html>
