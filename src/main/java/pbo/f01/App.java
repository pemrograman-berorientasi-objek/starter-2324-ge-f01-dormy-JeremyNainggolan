package pbo.f01;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import pbo.f01.controller.Dormy;

/**
 * @author 12S22002 - Jeremy Nainggolan
 * @author 12S22049 - Agnes Harefa
 */
public class App {

    private static EntityManagerFactory factory;
    private static EntityManager entityManager;
    static Dormy dormy = new Dormy();
    
    public static void main(String[] _args) {
        factory = Persistence.createEntityManagerFactory("dormy_pu");
        entityManager = factory.createEntityManager();
        dormy.run(entityManager);
    }

}