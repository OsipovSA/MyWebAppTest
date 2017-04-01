package services;

import java.sql.Connection;

/**
 * Created by Sergey on 26.03.2017.
 */
public class DBService {
    Connection connection;

    public DBService(Connection connection) {
        this.connection = connection;
    }
}
