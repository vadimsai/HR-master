<%--
  Created by IntelliJ IDEA.
  User: it
  Date: 10.01.2021
  Time: 23:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>


<h4>JTA EJB</h4>


<form action="ServletEdit" method="POST">

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
</form>


<!--Persist Form-->

<form action="ServletPersist" method="POST">

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
</form>


<!--Remove Form-->

<form action="ServletRemove" method="POST">

    <div class="form-group">
        <input class="input" type="number" name="id" placeholder="Введите id пользователя">
    </div>

    <button class="btn" type="submit">REMOVE</button>
</form>


<form action="ServletGetAll" method="POST">
    <button class="btn" type="submit">GetALL</button>

    <table class="table">
        <tr>
            <th>id</th>
            <th>Name</th>
            <th>Surname</th>
            <th>Birth Date</th>
            <th>Address</th>
        </tr>
        <c:forEach var="user" items="${list}">
        <tr>
            <td>${user.id}</td>
            <td>${user.name}</td>
            <td>${user.surname}</td>
            <td>${user.birthDate}</td>
            <td>${user.address}</td>
            </c:forEach>
        </tr>
    </table>
</form>


<h4>JDBC</h4>


<form action="ServletInsertJdbc" method="POST">

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

    <button class="btn" type="submit">INSERT</button>
</form>


<form action="ServletUpdateJdbc" method="POST">

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

    <button class="btn" type="submit">Update</button>
</form>


<form action="ServletByIdJdbc" method="GET">
    <input class="input" type="number" name="id" placeholder="Введите id пользователя">
    <button class="btn" type="submit">GetById</button>


    <table class="table">
        <tr>
            <th>id</th>
            <th>Name</th>
            <th>Surname</th>
            <th>Birth Date</th>
            <th>Address</th>
        </tr>

        <c:forEach var="userj" items="${listji}">
        <tr>
            <td>${userj.id}</td>
            <td>${userj.name}</td>
            <td>${userj.surname}</td>
            <td>${userj.birthDate}</td>
            <td>${userj.address}</td>
            </c:forEach>
        </tr>
    </table>
</form>


<form action="ServletGetAllJdbc" method="GET">
    <button class="btn" type="submit">GetAll</button>


    <table class="table">
        <tr>
            <th>id</th>
            <th>Name</th>
            <th>Surname</th>
            <th>Birth Date</th>
            <th>Address</th>
        </tr>

        <c:forEach var="userja" items="${listj}">
        <tr>
            <td>${userja.id}</td>
            <td>${userja.name}</td>
            <td>${userja.surname}</td>
            <td>${userja.birthDate}</td>
            <td>${userja.address}</td>
            </c:forEach>
        </tr>
    </table>
</form>


<form action="ServletDeleteJdbc" method="GET">

    <div class="form-group">
        <input class="input" type="number" name="id" placeholder="Введите id пользователя">
    </div>

    <button class="btn" type="submit">REMOVE</button>
</form>








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
