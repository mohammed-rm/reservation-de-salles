package controller.DAO;

import controller.HibernateUtils;
import model.User;
import org.hibernate.HibernateException;

import javax.persistence.Query;
import java.util.ArrayList;

public class UserDAO {

    public UserDAO() {
        HibernateUtils.init();
    }

    /**
     * Method to create a new user
     *
     * @param u the new user
     */
    public void create(User u) {
        try {
            if (HibernateUtils.em.find(User.class, u.getIdUser()) == null) {
                HibernateUtils.em.getTransaction().begin();
                HibernateUtils.em.persist(u);
                HibernateUtils.em.getTransaction().commit();
                System.out.println(
                        "Insertion of :  (" + u.getIdUser() + "," + u.getFirstName() + "," + u.getLastName() + ")");
            } else {
                System.out.println("User with the same Id exists in the DataBase!");
            }
        } catch (HibernateException err) {
            System.out.println(err.getCause() + "\n" + err.getMessage());
        }
    }

    /**
     * Method which removes an existing user from the database
     *
     * @param u the user to be removed
     */
    public void delete(User u) {
        try {
            if (HibernateUtils.em.find(User.class, u.getIdUser()) != null) {
                HibernateUtils.em.getTransaction().begin();
                HibernateUtils.em.remove(HibernateUtils.em.find(User.class, u.getIdUser()));
                HibernateUtils.em.getTransaction().commit();
                System.out.println(
                        "Deletion of :  (" + u.getIdUser() + "," + u.getFirstName() + "," + u.getLastName() + ")");
            } else {
                System.out.println("This user does not exist!");
            }
        } catch (HibernateException err) {
            System.out.println(err.getCause() + "\n" + err.getMessage());
        }

    }

    /**
     * Method which updates an existing user in the database
     *
     * @param u the user to be updated
     */
    public void update(User u) {
        try {
            if (HibernateUtils.em.find(User.class, u.getIdUser()) != null) {
                HibernateUtils.em.getTransaction().begin();
                HibernateUtils.em.merge(u);
                HibernateUtils.em.getTransaction().commit();
                System.out.println(
                        "Update made of :  (" + u.getIdUser() + "," + u.getFirstName() + "," + u.getLastName() + ")");
            } else {
                System.out.println("This user does not exist!");
            }
        } catch (HibernateException err) {
            System.out.println(err.getCause() + "\n" + err.getMessage());
        }

    }

    /**
     * Method to obtain the users list from the database
     *
     * @return list the list of users
     */
    public ArrayList<User> read() {
        try {
            Query query = HibernateUtils.em.createQuery("from User");
            ArrayList<User> list = (ArrayList<User>) query.getResultList();
            int i = 0;
            while (!list.isEmpty() && i < list.size()) {
                System.out.println(list.get(i));
                ++i;
            }
            return list;
        } catch (HibernateException err) {
            System.out.println(err.getCause() + "\n" + err.getMessage());
        }
        return null;
    }
}
