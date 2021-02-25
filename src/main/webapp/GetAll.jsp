<%@ page import="jtaproject.Users" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Collections" %><%--
  Created by IntelliJ IDEA.
  User: it
  Date: 24.01.2021
  Time: 0:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<h4>REST JTA EJB</h4>

<form action="http://localhost:8080/HrProject_war/restDB/persist" method="POST">

    <div class="form-group">
        <input class="input" type="text" name="name" placeholder="Введите ваше имя">
    </div>

    <div class="form-group">
        <input class="input" type="text" name="surname" placeholder="Введите вашу фамилию">
    </div>

    <div class="form-group">
        <input class="input" type="text" name="birthDate" placeholder="Введите год рождения">
    </div>

    <div class="form-group">
        <input class="input" type="text" name="address" placeholder="Введите адресс">
    </div>

    <button class="btn" type="submit">PERSIST</button>

    <% out.print(request.getParameter("message")); %>

</form>


<form action="http://localhost:8080/HrProject_war/restDB/update" method="POST">

    <div class="form-group">
        <input class="input" type="number" name="id" placeholder="Введите ваше id">
    </div>

    <div class="form-group">
        <input class="input" type="text" name="name" placeholder="Введите ваше имя">
    </div>

    <div class="form-group">
        <input class="input" type="text" name="surname" placeholder="Введите вашу фамилию">
    </div>

    <div class="form-group">
        <input class="input" type="text" name="birthDate" placeholder="Введите год рождения">
    </div>

    <div class="form-group">
        <input class="input" type="text" name="address" placeholder="Введите адресс">
    </div>

    <button class="btn" type="submit">MERGE</button>

    <% out.print(request.getParameter("messagee")); %>
</form>


<form action="http://localhost:8080/HrProject_war/restDB/delete" method="POST">

    <div class="form-group">
        <input class="input" type="number" name="id" placeholder="Введите id пользователя">
    </div>

    <button class="btn" type="submit">REMOVE</button>


</form>

    <form action="http://localhost:8080/HrProject_war/restDB/Allxml" method="GET">
        <button class="btn" type="submit">GetALL XML</button>
    </form>

    <form action="http://localhost:8080/HrProject_war/restDB/Alljson" method="GET">
        <button class="btn" type="submit">GetALL JSON</button>
    </form>




</body>
</html>
