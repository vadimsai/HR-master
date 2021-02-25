package jtaproject;


import javax.ejb.*;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.Date;
import java.util.List;


@LocalBean
@Singleton
public class UserManagement implements DBOperations{
    @PersistenceContext(name = "Students")
    EntityManager em;


    @Override
    public void persist(Users user) {
        em.persist(user);
    }
    @Override
    public void merge(int id, String name, String surname, String birthDate, String address)
        {
            Users user = em.find(Users.class, id);
            if(user!=null) {
              user.setName(name);user.setSurname(surname);
              user.setBirthDate(birthDate);user.setAddress(address);
              em.merge(user);
              }
        }


    @Override
    public void remove(int id) {
        Users user = em.find(Users.class, id);
        if (user!=null) {em.remove(user); }
        else {
            System.out.println(" Введите правильный id пользователя ");
        }
    }

    @Override
    public List<Users> selectAll() {
        Query query = em.createQuery("select u from Users u");
        List<Users> list = query.getResultList();

        return list;
    }


}
