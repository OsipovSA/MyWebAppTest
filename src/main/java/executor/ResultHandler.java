package executor;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Sergey on 26.03.2017.
 */

public interface ResultHandler<T> {
	T handle(ResultSet resultSet) throws SQLException;
}
