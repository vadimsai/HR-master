package jdbcproject;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import java.sql.SQLException;
import java.util.List;


public interface DbJdbcOperations {
    public String insertDB(String name, String surname, String birthDate, String address);
    public String deleteDB(int id);
    public String updateDB(int id, String name, String surname, String birthDate, String address);
    public List<String> getById(int id);
    public List<String> getAll();
    public List<UserJdbc> getall(int id);
}
