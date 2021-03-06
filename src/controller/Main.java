package controller;

import controller.DAO.ReservationDAO;
import controller.DAO.RoomDAO;
import controller.DAO.UserDAO;
import model.Reservation;
import model.Room;
import model.User;
import view.ApplicationWindow;

import java.awt.*;

public class Main {

    public static void main(String[] args){

        HibernateUtils.init();

        /*EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    ApplicationWindow app = new ApplicationWindow();
                } catch (Exception e) {
                  e.printStackTrace();
              }
          }
        });*/

        User user = new User();
        user.setIdUser(7);
        user.setFirstName("bob");
        user.setLastName("tom");
        UserDAO us = new UserDAO();
        us.create(user);
        //us.delete(user);
        //us.update(user);
        us.read();

        Room room = new Room();
        room.setIdRoom(4);
        RoomDAO rm = new RoomDAO();
        rm.create(room);
        //rm.delete(room);
        rm.read();

        Reservation resa = new Reservation();
        resa.setIdReservation(1);
        resa.setUser(user);
        resa.setRoom(room);
        resa.setBeginTime(resa.stringToLDT("2022-01-21 10:00:00"));
        resa.setEndTime(resa.stringToLDT("2022-01-21 12:00:00"));
        ReservationDAO resD = new ReservationDAO();
        resD.create(resa);
        //resD.delete(resa);
        //resD.update(resa);
        resD.read();

        HibernateUtils.close();

    }
}
