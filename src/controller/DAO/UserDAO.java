package controller.DAO;

import controller.HibernateUtils;
import model.User;
import org.hibernate.HibernateException;

import java.util.ArrayList;

public class UserDAO {

    public UserDAO() {
        HibernateUtils.init();
    }

    public void create(User u) {
        try {
            HibernateUtils.em.getTransaction().begin();
            HibernateUtils.em.persist(u);
            HibernateUtils.em.getTransaction().commit();
            System.out.println(
                    "Insertion of :  (" + u.getIdUser() + "," + u.getFirstName() + "," + u.getLastName() + ")");

            //HibernateUtils.close();
        } catch (HibernateException err) {
            System.out.println(err.getCause() + "\n" + err.getMessage());
        }
    }

    public void delete(User u) {
        try {
            HibernateUtils.em.getTransaction().begin();
            HibernateUtils.em.remove(HibernateUtils.em.find(User.class, u.getIdUser()));
            HibernateUtils.em.getTransaction().commit();
            System.out.println(
                    "Deletion of :  (" + u.getIdUser() + "," + u.getFirstName() + "," + u.getLastName() + ")");

            //HibernateUtils.close();
        } catch (HibernateException err) {
            System.out.println(err.getCause() + "\n" + err.getMessage());
        }

    }

    public void update(User u) {

    }

    public ArrayList<User> read() {
        return null;
    }
}
