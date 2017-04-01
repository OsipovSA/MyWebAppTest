<%--
  Created by IntelliJ IDEA.
  User: Sergey
  Date: 01.04.2017
  Time: 23:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add user</title>
</head>
<body>
    <% if(request.getAttribute("mistake")!=null){%>
        <br>
        <div style="color:red; text-align: center">
        <h2>
        Необходимо заполнить все поля:
        <br>
            <%=request.getAttribute("mistake")%>
        </h2>
        </div>
    <%}
    %>
    <br>
    <div style="text-align:center">
    <h1> Укажите значения полей: </h1>
        <form method="post">
            Логин:  <input type="text" name="Login">
            Имя:    <input type="text" name="Name">
            Пароль: <input type="password" name="Password">
            Роль:   <input type="text" name="Role">
            <br><br>
            <input type="submit" name="CreateUser" value="Создать пользователя">
        </form>
    </div>
</body>
</html>
