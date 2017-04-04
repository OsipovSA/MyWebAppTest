package dao;

import executor.Executor;
import models.User;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by Sergey on 26.03.2017.
 */
public class UsersDAO {

    private Executor executor;

    public UsersDAO(Connection connection) {
        this.executor = new Executor(connection);
    }

    public User getUserById(long id) throws SQLException {
        return executor.execQuery("select * from users where id=" + id, result -> {
            result.next();
            return new User(result.getLong(1), result.getString(2),result.getString(3),result.getString(4),result.getString(5));
        });
    }

    public ArrayList<User> getAllUsers() throws SQLException {
        ArrayList<User> users = new ArrayList<>();
        return executor.execQuery("select * from users", result -> {
            while (result.next()) {
                users.add(new User(result.getLong(1), result.getString(2), result.getString(3), result.getString(4), result.getString(5)));
            }
             return users;
            }
        );
    }

    public long getUserId(String login) throws SQLException {
        return executor.execQuery("select * from users where login='" + login + "'", result -> {
            result.next();
            return result.getLong(1);
        });
    }

    public void addUser(String login, String name, String password, String role) throws SQLException {
        executor.execUpdate("insert into users (login, name, password, role) values ('"+login+"', '"+name+"', '"+password+"','"+role+"')");
    }

    public void updateUserById(long id, String login, String name, String password, String role) throws SQLException{
        executor.execUpdate("update users set login = '"+login+"', name = '"+name+"', password = '"+password+"', role = '"+role+"' where  id = '"+id+"");
    }

    public void deleteUserById(Long id) throws SQLException {
        executor.execUpdate("delete from users where id = '"+id+"'");
    }

    public void deleteUserByLogin(String login) throws SQLException {
        executor.execUpdate("delete from users where login = '"+login+"'");
    }

    public void createTable() throws SQLException {
        executor.execUpdate("CREATE TABLE if not exist users (\n" +
                "  'id' BIGINT(20) NOT NULL AUTO_INCREMENT,\n" +
                "  'login' VARCHAR(50) NOT NULL,\n" +
                "  'name' VARCHAR(100) NULL,\n" +
                "  'password' VARCHAR(20) NULL,\n" +
                "  'role' VARCHAR(100) NULL,\n" +
                "  PRIMARY KEY ('id'));");
    }

    public void dropTable() throws SQLException {
        executor.execUpdate("drop table users");
    }

}
