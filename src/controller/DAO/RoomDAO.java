package controller.DAO;

import controller.HibernateUtils;
import model.Room;
import org.hibernate.HibernateException;

import javax.persistence.Query;
import java.util.ArrayList;

public class RoomDAO {

    /**
     * Method to create a new room
     *
     * @param r the new user
     */
    public void create(Room r) {
        try {
            if (HibernateUtils.em.find(Room.class, r.getIdRoom()) == null) {
                HibernateUtils.em.getTransaction().begin();
                HibernateUtils.em.persist(r);
                HibernateUtils.em.getTransaction().commit();
                System.out.println(
                        "Insertion of Room : " + r.getIdRoom());
            } else {
                System.out.println("A room with the same Id exists in the DataBase!");
            }
        } catch (HibernateException err) {
            System.out.println(err.getCause() + "\n" + err.getMessage());
        }
    }

    /**
     * Method which removes an existing room from the database
     *
     * @param r the room to be removed
     */
    public void delete(Room r) {
        try {
            if (HibernateUtils.em.find(Room.class, r.getIdRoom()) != null) {
                HibernateUtils.em.getTransaction().begin();
                HibernateUtils.em.remove(HibernateUtils.em.find(Room.class, r.getIdRoom()));
                HibernateUtils.em.getTransaction().commit();
                System.out.println(
                        "Deletion of Room : " + r.getIdRoom());
            } else {
                System.out.println("This room does not exist!");
            }
        } catch (HibernateException err) {
            System.out.println(err.getCause() + "\n" + err.getMessage());
        }
    }

    /**
     * Method to obtain the rooms list from the database
     *
     * @return list
     */
    public ArrayList<Room> read() {
        try {
            Query query = HibernateUtils.em.createQuery("from Room");
            ArrayList<Room> list = (ArrayList<Room>) query.getResultList();
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
