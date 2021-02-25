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

    <table class="table"  >
        <tr >
            <th>id</th>
            <th>Name</th>
            <th>Surname</th>
            <th>Birth Date</th>
            <th>Address</th>
        </tr>
        <c:forEach var="user" items="${list}" >
        <tr>
            <td>${user.id}</td>
            <td>${user.name}</td>
            <td>${user.surname}</td>
            <td>${user.birthDate}</td>
            <td>${user.address}</td>
            </c:forEach >
        </tr>
    </table>
</form>

                  <h4>JDBC</h4>

<form action="ServletByIdJdbc" method="GET">
    <input class="input" type="number" name="id" placeholder="Введите id пользователя">
    <button class="btn" type="submit">GetById</button>


    <table class="table"  >
        <tr >
            <th>id</th>
            <th>Name</th>
            <th>Surname</th>
            <th>Birth Date</th>
            <th>Address</th>
        </tr>

        <c:forEach var="user" items="${model.list}" >
        <tr>
            <td>${user.id}</td>
            <td>${user.name_user}</td>
            <td>${user.surname}</td>
            <td>${user.email}</td>
            <td>${user.address}</td>
            </c:forEach >
        </tr>
    </table>
</form>






<form action="ServletDeleteJdbc" method="GET">

    <div class="form-group">
        <input class="input" type="number" name="id" placeholder="Введите id пользователя">
    </div>

    <button class="btn" type="submit">REMOVE</button>
</form>



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




</body>
</html>
