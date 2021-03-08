package jtaproject;


import javax.ejb.*;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.Date;
import java.util.List;

/**
 *@autor VADIM NOVIKOV
 * class UserManagement-  implementation of database access methods for JTA module
 *
 */

@LocalBean
@Singleton
public class UserManagement implements DBOperations{
    @PersistenceContext(name = "Students")
    EntityManager em;


    @Override
    public String persist(Users user) {

       if(!(user.getName().equals("") || user.getSurname().equals(""))){
       em.persist(user);}else {return "the name and surname field is required";}
       return "user persist";
    }



    @Override
    public String merge(int id, String name, String surname, String email, String address)
        { if(!(name.equals("")||surname.equals(""))) {
            Users user = em.find(Users.class, id);
            if (user != null) {
                user.setName(name);
                user.setSurname(surname);
                user.setEmail(email);
                user.setAddress(address);
                em.merge(user);
            }else {return "the user does not exist";}
        }else {return "the name and surname field is required";}
        return "user merge";
        }


    @Override
    public String remove(int id) {
        Users user = em.find(Users.class, id);
        if (user!=null) {em.remove(user); }
        else {return "there is no user with this id"; }
        return "user remove";
    }

    @Override
    public List<Users> selectAll() {
        Query query = em.createQuery("select u from Users u");
        List<Users> list = query.getResultList();

        return list;
    }


}
