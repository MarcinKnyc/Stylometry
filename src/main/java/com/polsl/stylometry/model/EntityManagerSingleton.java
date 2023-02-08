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


    public EntityManager getEntityManager() {
        return entityManager;
    }

    private final EntityManager entityManager;

    public EntityManagerSingleton(){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        entityManager = entityManagerFactory.createEntityManager();
    }

}
