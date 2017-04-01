<%@ page import="models.User" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Test</title>
</head>
<body>
        <div align="center">
            <br>
            <H1>Добро пожаловать в глобальное управление пользователями!</H1>
            <br>
            <a href="/addnewuser"><button>Добавить пользователя</button></a>
        </div>
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