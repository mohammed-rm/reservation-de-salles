package controller;

import model.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.lang.module.Configuration;

public class Main {

    public static void main(String[] args){


        System.out.println("test");

        EntityClass.init();

        User user = new User();
        user.setIdUser(1);
        user.setFirstName("Bob");
        user.setLastName("boby");

        EntityClass.em.getTransaction().begin();
        EntityClass.em.persist(user);
        EntityClass.em.getTransaction().commit();

        EntityClass.close();





    }
}
