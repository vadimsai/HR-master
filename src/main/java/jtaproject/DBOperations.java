package jtaproject;


import javax.ejb.Local;
import javax.transaction.*;
import java.util.Date;
import java.util.List;

/**
 *
 * @Interface for JTA module
 *
 */

@Local
public interface DBOperations {
    public String persist(Users user);
    public String merge(int id, String name, String surname, String email, String address);
    public String remove(int id);
    public List<Users> selectAll();
}
