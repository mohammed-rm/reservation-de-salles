package controller;

import controller.DAO.UserDAO;
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
        us.read();

        HibernateUtils.close();





    }
}
