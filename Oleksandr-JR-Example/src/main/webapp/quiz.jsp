<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page contentType="text/html;charset=UTF-8" %>


<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <title>FQ HTML</title>


    <style>
        table, th, td {
            border: 1px solid black;
            border-collapse: collapse;
            padding: 8px;
        }
    </style>

</head>

<body>


<%--<%= request.getSession().getAttribute("questions")  %>--%>

<h2>Test</h2>
<%= session.getAttribute("test") %>


</body>

</html>
