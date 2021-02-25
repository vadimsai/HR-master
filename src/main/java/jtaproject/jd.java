package jtaproject;

import javax.ejb.EJB;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class jd {

    public static void main(String[] args) {
        EntityManagerFactory emf= Persistence.createEntityManagerFactory("Students");
        EntityManager em=emf.createEntityManager();
       EntityTransaction et=em.getTransaction();

       et.begin();
       em.persist(new Users("SAI","SAI","SAI","AUM"));
       et.commit();


    }
}
