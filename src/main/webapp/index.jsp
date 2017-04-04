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
            <br><br><br>
        </div>
<%
    ArrayList<User> list = (ArrayList<User>) request.getAttribute("users");
    if(list!=null){%>
        <div align="center">
           <table border="1">
                <tr><th>Login</th><th>Name</th><th>Password</th><th>Role</th></tr>
                <%for(User user:list){%>
                    <tr align="center">
                        <td width="100"><%=user.getLogin()%></td>
                        <td width="100"><%=user.getName()%></td>
                        <td width="100"><%=user.getPassword()%></td>
                        <td width="100"><%=user.getRole()%></td>
                        <form method="get" action="/edituser">
                            <input type="hidden" name="id" value=<%user.getId().toString();%>>
                            <input type="submit" name="EditUser" value="Редактировать">
                        </form>
                        <form method="post" action="/deleteuser">
                            <input type="hidden" name="id" value=<%user.getId().toString();%>>
                            <input type="submit" name="DeleteUser" value="Удалить">
                        </form>
                    </tr>
                <%}%>
           </table>
        </div>
    <%}%>
</body>
</html>