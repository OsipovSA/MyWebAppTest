package servlets;

import dao.UsersDAO;
import models.User;
import services.MySQLConfiguration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by Sergey on 02.04.2017.
 */
@WebServlet(name = "EditUserServlet", urlPatterns = "/edituser")
public class EditUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if(request.getParameter("SaveUser")!=null)
        {
            if(request.getParameter("Login")!=null && request.getParameter("Login")!=""
                    && request.getParameter("Name")!=null && request.getParameter("Name")!=""
                    && request.getParameter("Password")!=null && request.getParameter("Password")!=""
                    && request.getParameter("Role")!=null && request.getParameter("Role")!="") {
                // Добавляем пользователя и переходим на главную страницу
                try {
                    new UsersDAO(new MySQLConfiguration().getConnection()).updateUserById(Long.parseLong(request.getParameter("id")),request.getParameter("Login"),request.getParameter("Name"),request.getParameter("Password"),request.getParameter("Role"));
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                //request.getRequestDispatcher("index.jsp").forward(request, response);
                response.sendRedirect("/");
            }else{
                // Надо как-то сказать что не заполнено
                StringBuilder st = new StringBuilder("");
                st.append("Login: "+request.getParameter("Login")+"<br>");
                st.append("Name: "+request.getParameter("Name")+"<br>");
                st.append("Password: "+request.getParameter("Password")+"<br>");
                st.append("Role: "+request.getParameter("Role")+"<br>");
                request.setAttribute("mistake",st);
                request.getRequestDispatcher("WEB-INF/EditUser.jsp").forward(request, response);
            }
        }else{
            // Тут просто возврат
            response.sendRedirect("/");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = "";
        if((id = request.getParameter("id"))!=null && (id = request.getParameter("id"))!=""){
            try {
                User user = new UsersDAO(new MySQLConfiguration().getConnection()).getUserById(Long.parseLong(id));
                request.setAttribute("id",user.getId().toString());
                request.setAttribute("Login",user.getLogin());
                request.setAttribute("Name",user.getName());
                request.setAttribute("Password",user.getPassword());
                request.setAttribute("Role",user.getRole());

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
