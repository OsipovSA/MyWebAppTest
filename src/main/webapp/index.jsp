<%@ page import="models.User" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Test</title>
</head>
<body>
Hello world!!!
<!--
<form action="index.jsp" method="post">
    <input type="submit" value="OK">
</form>
<%
    ArrayList<User> list = (ArrayList<User>) request.getSession().getAttribute("users");
%>
<table>
    <tr><th>Login</th><th>Name</th><th>Password</th><th>Role</th></tr>
    <%
        if(list!=null){
            for(User user:list){%>
    <tr align="center"><td><%=user.getLogin()%></td><td><%=user.getName()%></td><td><%=user.getPassword()%></td><td><%=user.getRole()%></td></tr>
    <%}
    }
    %>
</table>
-->
</body>
</html>