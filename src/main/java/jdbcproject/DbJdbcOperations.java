package jdbcproject;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import java.sql.SQLException;
import java.util.List;

/**
 *@autor VADIM NOVIKOV
 * @Interface for JDBC module
 *
 */

public interface DbJdbcOperations {
     String insertDB(Users users);
     String deleteDB(int id);
     String updateDB(Users users,int id);
     List<Users> getAll();
     List<Users> getById(int id);
}
