package com.polsl.stylometry.model;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

/**
 * Centralizes database connection logic.
 *
 * @author Marcin Knyć
 */
public class EntityManagerSingleton {
    //custom singleton logic:
    private static EntityManagerSingleton instance = null;

    public static EntityManagerSingleton getInstance(){
        return instance;
    }

    public static void setInstance(EntityManagerSingleton analysis) {
        instance = analysis;
    }

    private final EntityManagerFactory entityManagerFactory;

    public EntityManager getEntityManager() {
        return entityManager;
    }

    public void reset() {
        entityManager.close();
//        entityManagerFactory.close();
//        entityManagerFactory = Persistence.createEntityManagerFactory("default");
        entityManager = entityManagerFactory.createEntityManager();
    }

    private EntityManager entityManager;

    public EntityManagerSingleton(){
        entityManagerFactory = Persistence.createEntityManagerFactory("default");
        entityManager = entityManagerFactory.createEntityManager();
    }

}
