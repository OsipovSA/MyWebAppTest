package servlets;

import dao.UsersDAO;
import services.MySQLConfiguration;

import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by Sergey on 01.04.2017.
 */
@WebServlet(name = "MainServlet", urlPatterns = "")
public class MainServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        try {
            request.getSession().setAttribute("users", new UsersDAO(new MySQLConfiguration().getConnection()).getAllUsers());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
