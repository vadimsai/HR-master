package jtaproject;


import javax.ejb.Local;
import javax.ejb.LocalBean;
import javax.transaction.*;
import java.util.Date;
import java.util.List;

/**
 *@autor VADIM NOVIKOV
 *
 * @Interface for All
 */
@Local
public interface DBOperations {
    String insert(Users user);
    String update(int id, Users users);
    String remove(int id);
    List<Users> selectAll();
    List<Users> getById(int id);
}
