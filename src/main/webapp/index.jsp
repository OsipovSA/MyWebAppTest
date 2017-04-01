<%@ page import="models.User" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Test</title>
</head>
<body>
<form method="post">
    <div style="text-align:center">
        <H1>Добро пожаловать в глобальное управление пользователями!</H1>
        <br>
        <input type="submit" value="Добавить пользователя">
    </div>
</form>
<%
    ArrayList<User> list = (ArrayList<User>) request.getAttribute("users");
%>
<table>
    <%
        if(list!=null){%>
        <tr><th>Login</th><th>Name</th><th>Password</th><th>Role</th></tr>
            <%for(User user:list){%>
                <tr align="center">
                    <td><%=user.getLogin()%></td>
                    <td><%=user.getName()%></td>
                    <td><%=user.getPassword()%></td>
                    <td><%=user.getRole()%></td>
                </tr>
            <%}
        }
    %>
</table>
</body>
</html>