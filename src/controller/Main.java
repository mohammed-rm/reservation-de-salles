package controller;

import controller.DAO.UserDAO;
import model.User;

public class Main {

    public static void main(String[] args){


        System.out.println("test");

        HibernateUtils.init();

        User user = new User();
        user.setIdUser(0);
        user.setFirstName("Bob");
        user.setLastName("boby");

        /*System.out.println(user.getFirstName() + " " + user.getLastName());
        HibernateUtils.em.getTransaction().begin();
        HibernateUtils.em.persist(user);
        HibernateUtils.em.getTransaction().commit();

        */

        UserDAO us = new UserDAO();
        us.create(user);
        us.delete(user);

        HibernateUtils.close();





    }
}
