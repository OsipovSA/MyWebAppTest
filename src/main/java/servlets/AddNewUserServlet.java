package servlets;

import dao.UsersDAO;
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
@WebServlet(name = "AddNewUserServlet", urlPatterns = "/AddNewUser")
public class AddNewUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if(request.getParameter("CreateUser")!=null)
        {
            if(request.getParameter("Login")!=null && request.getParameter("Name")!=null &&
                    request.getParameter("Password")!=null && request.getParameter("Role")!=null) {
                // Добавляем пользователя и переходим на главную страницу
                try {
                    new UsersDAO(new MySQLConfiguration().getConnection()).addUser(request.getParameter("Login"),request.getParameter("Name"),request.getParameter("Password"),request.getParameter("Role"));
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                request.getRequestDispatcher("index.jsp").forward(request, response);
            }else{
                // Надо как-то сказать что не заполнено
                StringBuilder st = new StringBuilder("");
                if(request.getParameter("Login")==null){st.append("Не заполнен поле Login <br>");};
                if(request.getParameter("Name")==null){st.append("Не заполнено поле Name <br>");};
                if(request.getParameter("Password")==null){st.append("Не заполнено поле  Password <br>");};
                if(request.getParameter("Role")==null){st.append("Не заполнено поле Role <br>");};
                request.setAttribute("mistake",st);
                request.getRequestDispatcher("WEB-INF/AddNewUser.jsp.jsp").forward(request, response);
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
