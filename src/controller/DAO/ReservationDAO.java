package controller.DAO;

import controller.HibernateUtils;
import model.Reservation;
import org.hibernate.HibernateException;

import javax.persistence.Query;
import java.util.ArrayList;

public class ReservationDAO {

    public ReservationDAO() {
        HibernateUtils.init();
    }

    /**
     * Method to create a new reservation
     *
     * @param r the new reservation
     */
    public void create(Reservation r) {
        try {
            if (HibernateUtils.em.find(Reservation.class, r.getIdReservation()) == null) {
                HibernateUtils.em.getTransaction().begin();
                HibernateUtils.em.persist(r);
                HibernateUtils.em.getTransaction().commit();
                System.out.println(
                        "Insertion of :  (" + r.getIdReservation() + "," + r.getRoom() + "," + r.getUser() + "," + r.getBeginTime() + ","+ r.getEndTime() + ")");
            } else {
                System.out.println("Reservation with the same Id exists in the DataBase!");
            }
        } catch (HibernateException err) {
            System.out.println(err.getCause() + "\n" + err.getMessage());
        }
    }

    /**
     * Method which removes an existing reservation from the database
     *
     * @param r the reservation to be removed
     */
    public void delete(Reservation r) {
        try {
            if (HibernateUtils.em.find(Reservation.class, r.getIdReservation()) != null) {
                HibernateUtils.em.getTransaction().begin();
                HibernateUtils.em.remove(HibernateUtils.em.find(Reservation.class, r.getIdReservation()));
                HibernateUtils.em.getTransaction().commit();
                System.out.println(
                        "Deletion of :  (" + r.getIdReservation() + "," + r.getRoom() + "," + r.getUser() + "," + r.getBeginTime() + ","+ r.getEndTime() + ")");
            } else {
                System.out.println("This reservation does not exist!");
            }
        } catch (HibernateException err) {
            System.out.println(err.getCause() + "\n" + err.getMessage());
        }

    }

    /**
     * Method which updates an existing Reservation in the database
     *
     * @param r the reservation to be updated
     */
    public void update(Reservation r) {
        try {
            if (HibernateUtils.em.find(Reservation.class, r.getIdReservation()) != null) {
                HibernateUtils.em.getTransaction().begin();
                HibernateUtils.em.merge(r);
                HibernateUtils.em.getTransaction().commit();
                System.out.println(
                        "Update made of :  (" + r.getIdReservation() + "," + r.getRoom() + "," + r.getUser() + "," + r.getBeginTime() + ","+ r.getEndTime()+ ")");
            } else {
                System.out.println("This user does not exist!");
            }
        } catch (HibernateException err) {
            System.out.println(err.getCause() + "\n" + err.getMessage());
        }

    }

    /**
     * Method to obtain the reservations list from the database
     *
     * @return list
     */
    public ArrayList<Reservation> read() {
        try {
            Query query = HibernateUtils.em.createQuery("from Reservation ");
            ArrayList<Reservation> list = (ArrayList<Reservation>) query.getResultList();
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
