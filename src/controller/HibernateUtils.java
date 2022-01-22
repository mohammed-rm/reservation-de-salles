package controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class HibernateUtils {

    public static EntityManager em;
    private static EntityManagerFactory emf;

    public static void init() {
        emf = Persistence.createEntityManagerFactory("Persist");
        em = emf.createEntityManager();

    }

    public static void close() {
        em.close();
        emf.close();
    }
}
