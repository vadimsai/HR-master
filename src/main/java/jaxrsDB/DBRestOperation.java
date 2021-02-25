package jaxrsDB;

import jtaproject.Users;


import javax.ejb.Local;
import javax.ejb.Singleton;
import java.util.List;

@Local
public interface DBRestOperation {
    public String persist(Users user);
    public String merge(int id, String name, String surname, String birthDate, String address);
    public String remove(int id);
    public List<Users> selectAll();
}
