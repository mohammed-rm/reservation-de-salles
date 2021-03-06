package controller;

import controller.DAO.ReservationDAO;
import controller.DAO.RoomDAO;
import model.Reservation;
import model.Room;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Iterator;

public class Utilities {

    /**
     * @param datetime
     * @return LDT
     */
    public static LocalDateTime stringToLDT(String datetime) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime LDT = LocalDateTime.parse(datetime, formatter);
        return LDT;
    }

    /**
     * @param ldt
     * @return formattedDateTime
     */
    public static String LDTtoString(LocalDateTime ldt) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedDateTime = ldt.format(formatter);
        return formattedDateTime;
    }

    /**
     * This method returns the available room for the chosen period by the user
     *
     * @param beginDate
     * @param endDate
     * @return ret
     */
    public static ArrayList<Room> getAvailableRooms(LocalDateTime beginDate, LocalDateTime endDate) {
        RoomDAO daoroom = new RoomDAO();
        ReservationDAO daoresa = new ReservationDAO();

        ArrayList<Integer> unavailable = new ArrayList<Integer>();

        Iterator<Reservation> i = daoresa.read().iterator();
        while (i.hasNext()) {
            Reservation resa = i.next();
            // Begin time included = overlap with this period
            if (beginDate.isAfter(resa.getBeginTime()) && beginDate.isBefore(resa.getEndTime())) {
                unavailable.add(resa.getRoom().getIdRoom());
                // end time included = overlap with this period
            } else if (endDate.isAfter(resa.getBeginTime()) && beginDate.isBefore(resa.getEndTime())) {
                unavailable.add(resa.getRoom().getIdRoom());
            }
        }

        ArrayList<Room> ret = daoroom.read();

        for (int j = 0; j < ret.size(); j++)
            if (unavailable.contains(ret.get(j).getIdRoom()))
                ret.remove(j);

        return ret;
    }
}
