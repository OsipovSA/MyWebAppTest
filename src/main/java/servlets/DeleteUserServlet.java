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
 * Created by Sergey on 04.04.2017.
 */
@WebServlet(name = "DeleteServlet", urlPatterns = "/deleteuser")
public class DeleteUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Удаляем
        String id = "";
        if((id = request.getParameter("id"))!=null && (id = request.getParameter("id"))!=""){
            try {
                new UsersDAO(new MySQLConfiguration().getConnection()).deleteUserById(Long.parseLong(id));

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        // Возвращаемся на центр
        response.sendRedirect("/");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
