package jtaproject;


import javax.ejb.Local;
import javax.transaction.*;
import java.util.Date;
import java.util.List;

@Local
public interface DBOperations {
    public void persist(Users user);
    public void merge(int id, String name, String surname, String birthDate, String address);
    public void remove(int id);
    public List<Users> selectAll();
}
