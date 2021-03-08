<%--
  Created by IntelliJ IDEA.
  User: it
  Date: 07.03.2021
  Time: 23:17
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link rel="preconnect" href="https://fonts.google.com/">
    <link href="https://fonts.googleapis.com/css2?family=Cormorant:ital,wght@0,300;0,400;0,600;0,700;1,300;1,400;1,600;1,700&display=swap" rel="stylesheet">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

            <title>Title</title>

    <style>
        <%@include file='css/css2.css' %>
    </style>

    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" type="text/css" href="${pageContext.servletContext.contextPath}/css/css2.css"/>
</head>
<body>
<div class="ref">
    <a href="http://localhost:8080/HrProject-1.0-SNAPSHOT/pictures/site.html" class="button" >ПЕРЕЙТИ НА ГЛАВНУЮ</a>
</div>


<small hidden>
    ॐ भूर्भुवः स्वः
    तत् सवितुर्वरेण्यं
    भर्गो देवस्य धीमहि
    धियो यो नः प्रचोदयात्</small>



<section class="zada">
    <h4>ЗАДАНИЕ</h4>
    <div class="content">
        <p>Необходимо разработать веб-приложение, позволяющее управлять пользователями
            (создавать, редактировать, просматривать список и детали, удалять)
            Функциональные требования к веб-приложению:
            Наличие RESTful интерфейса;
            Поддержка операций управления (создания, чтения, редактирования и удаления) пользователями.
            Пользователь определяется следующими значениями:
            Имя,
            Фамилия,
            email,
            Адрес проживания.
            Наличие пользовательского WEB-интерфейса</p>

        <p>Задание реализованно в трех вариантах: 1 - jdbc+servlet, 2 - jta+ejb+hibernate, 3 - restw+jta+ejb+hibernate.
            В базе MySql с одной-общей таблицей для всех вариантов.</p>

        <p>Реализацию смотрите ниже, также прилагаю ссылку на репозиторий GitHab с реализацией данного задания</p>

        <div >
            <a href="https://github.com/vadimsai/HR-master.git/" target="_blank" >https://github.com/vadimsai/HR-master.git</a>
        </div>

        <p>Также прилагаю ссылку на скачивание моего резюме</p>
        <div >
            <a href="./файлы/1.1 1.GitIntroduction.pdf" target="_blank" download="">Скачать резюме</a>
        </div>

    </div>
</section>




<section>
    <h4 class="e">JTA-EJB-HIBERNATE-MYSQL</h4>

    <div class="contente">

        <form class="all" action="ServletGetAll" method="POST">

            <div class="button">
                <button class="btn" type="submit">GetALL</button>
            </div>

            <table class="t">
                <tr>
                    <th>id</th>
                    <th>Name</th>
                    <th>Surname</th>
                    <th>email</th>
                    <th>Address</th>
                </tr>
                <c:forEach var="user" items="${list}">
                <tr>
                    <td>${user.id}</td>
                    <td>${user.name}</td>
                    <td>${user.surname}</td>
                    <td>${user.email}</td>
                    <td>${user.address}</td>
                    </c:forEach>
                </tr>
            </table>
        </form>


        <form class="persist"  action="ServletPersist" method="POST">

            <div class="button">
                <button class="btn" type="submit">PERSIST</button>
            </div>

            <div class="form-group">
                <input class="input" type="text" name="name" placeholder="Введитеимя имя пользователя">
                <input class="input" type="text" name="surname" placeholder="Введите фамилию пользователя">
                <input class="input" type="text" name="email" placeholder="Введите email">
                <input class="input" type="text" name="address" placeholder="Введите адресс">
            </div>
            ${pers}
        </form>


        <form class="merge"  action="ServletEdit" method="POST">

            <div class="button">
                <button class="btn" type="submit">MERGE</button>
            </div>

            <div class="form-group">
                <input class="inputM" type="number" name="id" placeholder="Введите id пользователя" required>
                <input class="input" type="text" name="name" placeholder="Введите имя пользователя">
                <input class="input" type="text" name="surname" placeholder="Введите surname">
                <input class="input" type="text" name="email" placeholder="Введите email">
                <input class="input" type="text" name="address" placeholder="Введите адресс">
            </div>
            ${merg}
        </form>


        <form class="remove"  action="ServletRemove" method="POST">

            <div class="button">
                <button class="btn" type="submit">REMOVE</button>
            </div>

            <div class="formR">
                <input class="inputR" type="number" name="id" placeholder="id" required>
            </div>
            ${rem}
        </form>

    </div>






    <h4 class="j">JDBC-SERVLET-MYSQL</h4>

    <div class="contentj">

        <form class="all" action="ServletGetAllJdbc" method="GET">

            <div class="button">
                <button class="btn" type="submit">GetALL</button>
            </div>

            <table class="t">
                <tr>
                    <th>id</th>
                    <th>Name</th>
                    <th>Surname</th>
                    <th>email</th>
                    <th>Address</th>
                </tr>

                <c:forEach var="userja" items="${listj}">
                <tr>
                    <td>${userja.id}</td>
                    <td>${userja.name}</td>
                    <td>${userja.surname}</td>
                    <td>${userja.email}</td>
                    <td>${userja.address}</td>
                    </c:forEach>
                </tr>
            </table>
        </form>



        <form class="all" action="ServletByIdJdbc" method="GET">

            <div class="button">
                <button class="btn" type="submit">GetById</button>
            </div>

            <div class="formR">
                <input class="inputM" type="number" name="id" placeholder="Введите id" required>
            </div>


            <table class="t">
                <tr>
                    <th>id</th>
                    <th>Name</th>
                    <th>Surname</th>
                    <th>email</th>
                    <th>Address</th>
                </tr>

                <c:forEach var="userj" items="${listji}">
                <tr>
                    <td>${userj.id}</td>
                    <td>${userj.name}</td>
                    <td>${userj.surname}</td>
                    <td>${userj.email}</td>
                    <td>${userj.address}</td>
                    </c:forEach>
                </tr>
            </table>
        </form>



        <form class="persist"  action="ServletInsertJdbc" method="POST">

            <div class="button">
                <button class="btn" type="submit">INSERT</button>
            </div>

            <div class="form-group">
                <input class="input" type="text" name="name" placeholder="Введите имя пользователя">
                <input class="input" type="text" name="surname" placeholder="Введите фамилию пользователя">
                <input class="input" type="text" name="email" placeholder="Введите email">
                <input class="input" type="text" name="address" placeholder="Введите адресс">
            </div>
            ${ins}
        </form>


        <form class="merge" action="ServletUpdateJdbc" method="POST">

            <div class="button">
                <button class="btn" type="submit">Update</button>
            </div>

            <div class="form-group">
                <input class="inputM" type="number" name="id" placeholder="Введите id" required>
                <input class="input" type="text" name="name" placeholder="Введите имя пользователя">
                <input class="input" type="text" name="surname" placeholder="Введите фамилию пользователя">
                <input class="input" type="text" name="email" placeholder="Введите email">
                <input class="input" type="text" name="address" placeholder="Введите адресс">
            </div>
            ${upd}
        </form>


        <form class="remove" action="ServletDeleteJdbc" method="GET">

            <div class="button">
                <button class="btn" type="submit">REMOVE</button>
            </div>

            <div class="formR">
                <input class="inputR" type="number" name="id" placeholder="id" required>
            </div>
            ${del}
        </form>

    </div>




    <h4 class="r">REST-JTA-EJB-HIBERNATE-MYSQL</h4>

    <div class="contentr">

        <form class="persist" action="http://localhost:8080/HrProject_war/restDB/persist" method="POST">

            <div class="button">
                <button class="btn" type="submit">PERSIST</button>
            </div>

            <div class="form-group">
                <input class="input" type="text" name="name" placeholder="Введите имя пользователя">
                <input class="input" type="text" name="surname" placeholder="Введите фамилию пользователя">
                <input class="input" type="text" name="email" placeholder="Введите email">
                <input class="input" type="text" name="address" placeholder="Введите адресс">
            </div>
            <%String p=request.getParameter("perr");
            if(p==null){out.print("");}else{out.print(p);}%>
        </form>


        <form class="merge" action="http://localhost:8080/HrProject_war/restDB/update" method="POST">

            <div class="button">
                <button class="btn" type="submit">MERGE</button>
            </div>

            <div class="form-group">
                <input class="inputM" type="number" name="id" placeholder="Введите id">
                <input class="input" type="text" name="name" placeholder="Введите имя пользователя">
                <input class="input" type="text" name="surname" placeholder="Введите фамилию пользователя">
                <input class="input" type="text" name="email" placeholder="Введите email">
                <input class="input" type="text" name="address" placeholder="Введите адресс">
            </div>
            <%String m=request.getParameter("merr");
            if(m==null){out.print("");}else{out.print(m);}%>
        </form>


        <form  class="getX" action="http://localhost:8080/HrProject_war/restDB/Allxml" method="GET">
            <div class="button">
                <button class="btn" type="submit">GetALL XML</button>
            </div>
        </form>

        <form class="getJ" action="http://localhost:8080/HrProject_war/restDB/Alljson" method="GET">
            <div class="button">
                <button class="btn" type="submit">GetALL JSON</button>
            </div>
        </form>


        <form class="remove" action="http://localhost:8080/HrProject_war/restDB/delete" method="POST">

            <div class="button">
                <button class="btn" type="submit">REMOVE</button>
            </div>

            <div class="formR">
                <input class="inputR" type="number" name="id" placeholder="id">
            </div>
            <%String r=request.getParameter("remr");
            if (r==null){out.print("");}else{out.print(r);}%>
        </form>
    </div>
</section>



<section class="zada">
    <h4>УЗНАЙТЕ ПОГОДУ В ВАШЕМ ГОРОДЕ</h4>
    <div class="content">
        <p>Реализация прогноза погоды(при помощи API) с выбором города.</p>
        <p> Реализованно с помощью https://openweathermap.org/api.</p>
        <p> Также прилагаю ссылку на репозиторий GitHab с реализацией данного задания.</p>
        <div >
            <a href="https://github.com/vadimsai/HR-master.git" >https://github.com/vadimsai/HR-master.git</a>
        </div>
    </div>
</section>


<section>
    <h4 class="e">Погода</h4>
    <div class="contenteW">
        <form class="fw" action="ControllerWeather" method="post">

            <div class="button">
                <button class="btn" type="submit">CLICK</button>
            </div>
            <input class="form_input" name="City" id="city" type="text" placeholder="Введите город">
        </form>
            ${weather}
    </div>
</section>
</body>
</html>
