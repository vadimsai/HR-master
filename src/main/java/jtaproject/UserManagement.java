package jtaproject;


import interfaseanduser.DBOperations;
import interfaseanduser.Users;

import javax.ejb.*;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/**
 *@autor VADIM NOVIKOV
 * class UserManagement-  implementation of database access methods for JTA module and restful service
 *
 */


@LocalBean
@Singleton
public class UserManagement implements DBOperations {
    @PersistenceContext(name = "Students")
   private EntityManager em;


    @Override
    public String insert(Users user) {

       if(!(user.getName().equals("") || user.getSurname().equals(""))){
       em.persist(user);}else {return "the name and surname field is required";}
       return "user persist";
    }


    public String update(int id, Users users)
        {  { if(!(users.getName().equals("")||users.getSurname().equals(""))) {
            Users user = em.find(Users.class, id);
            if (user != null) {
                user.setName(users.getName());
                user.setSurname(users.getSurname());
                user.setEmail(users.getEmail());
                user.setAddress(users.getAddress());
                em.merge(user);

            }else {return "the user does not exist";}
        }else {return "the name and surname field is required";}
            return "user merge";
        }
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

    @Override
    public List<Users> getById(int id) {
        Query query = em.createQuery("select u from Users u where id=id");
        List<Users> list = query.getResultList();

        return list;
    }

}
