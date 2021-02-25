package jaxrsDB;


import jtaproject.Users;

import javax.ejb.LocalBean;
import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;



@LocalBean
@Singleton
public class UserRestManagment implements DBRestOperation  {

    @PersistenceContext(name = "Students")
    EntityManager em;


    @Override
    public String persist(Users user) {
        em.persist(user);
        return "User persist";
    }

    @Override
    public String merge(int id, String name, String surname, String birthDate, String address) {
        Users user = em.find(Users.class, id);
        if(user!=null) {
            user.setName(name);user.setSurname(surname);
            user.setBirthDate(birthDate);user.setAddress(address);
            em.merge(user);
        }
        return "User update";
    }

    @Override
    public String remove(int id) {
        Users user = em.find(Users.class, id);
        if (user!=null) {em.remove(user); }
        else {
            System.out.println(" Введите правильный id пользователя ");
        }
        return "User delete";
    }

    @Override
    public List<Users> selectAll() {
        Query query = em.createQuery("select u from Users u");
        List<Users> list = query.getResultList();

        return list;
    }
}
