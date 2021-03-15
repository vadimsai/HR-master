package jtaproject;


import javax.ejb.Local;
import javax.transaction.*;
import java.util.Date;
import java.util.List;

/**
 *@autor VADIM NOVIKOV
 *
 * @Interface for All
 */

public interface DBOperations {
    String insert(Users user);
    String update(int id, Users users);
    String updatem(int id, String name,String surname, String email, String address);
    String remove(int id);
    List<Users> selectAll();
    List<Users> getById(int id);
}
