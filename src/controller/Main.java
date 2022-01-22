package controller;

import controller.DAO.RoomDAO;
import controller.DAO.UserDAO;
import model.Room;
import model.User;

public class Main {

    public static void main(String[] args){


        System.out.println("test");

        HibernateUtils.init();

        User user = new User();
        user.setIdUser(2);
        user.setFirstName("Bobooooo");
        user.setLastName("bobyyyyy");

        /*System.out.println(user.getFirstName() + " " + user.getLastName());
        HibernateUtils.em.getTransaction().begin();
        HibernateUtils.em.persist(user);
        HibernateUtils.em.getTransaction().commit();

        */

        UserDAO us = new UserDAO();
        //us.create(user);
        //us.delete(user);
        //us.update(user);
        //us.read();

        Room room = new Room();
        room.setIdRoom(108);
        RoomDAO rm = new RoomDAO();
        //rm.create(room);
        //rm.delete(room);
        //rm.read();


        HibernateUtils.close();





    }
}
