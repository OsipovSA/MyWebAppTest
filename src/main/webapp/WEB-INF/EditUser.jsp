<%--
  Created by IntelliJ IDEA.
  User: Sergey
  Date: 01.04.2017
  Time: 23:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit user</title>
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
    <h1> Отредактируйте значения полей: </h1>
    <form method="post">
        Логин:  <input type="text" name="Login" value=<%=request.getAttribute("Login")%>>
        Имя:    <input type="text" name="Name" value=<%=request.getAttribute("Name")%>>
        Пароль: <input type="text" name="Password" value=<%=request.getAttribute("Password")%>>
        Роль:   <input type="text" name="Role" value=<%=request.getAttribute("Role")%>>
        <br><br>
        <input type="hidden" name="id" value=<%=request.getAttribute("id")%>>
        <input type="submit" name="SaveUser" value="Сохранить изменения">
        <input type="submit" name="ReturnUser" value="Отказаться">
    </form>
</div>
</body>
</html>
