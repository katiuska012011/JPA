package com.latam.alura.tienda.utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JAPUtils {
    private static EntityManagerFactory factory = Persistence.createEntityManagerFactory("stock_control");
    public static EntityManager getEntityManager() {
        return factory.createEntityManager();
    }
}
