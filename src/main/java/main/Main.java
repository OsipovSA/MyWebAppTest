package main;

import dao.UsersDAO;
import models.User;
import services.MySQLConfiguration;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by Sergey on 26.03.2017.
 */
public class Main {
    public static void main(String[] args) {
        //Connection connection = new MySQLConfiguration().getConnection();
        //DBService dbService = new DBService(connection); //Передаем коннекцию тут. Если что - легко поменять на другую

        try {
            ArrayList<User> list = new UsersDAO(new MySQLConfiguration().getConnection()).getAllUsers();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
