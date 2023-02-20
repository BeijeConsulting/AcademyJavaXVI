package it.beije.neumann.rubrica;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class RubricaEntityManager {
	
	private RubricaEntityManager() {}

	private static EntityManagerFactory entityManagerFactory;

    public static EntityManager getEntityManager() {
        if (entityManagerFactory == null) {
            System.out.println("creo EntityManagerFactory...");

            entityManagerFactory = Persistence.createEntityManagerFactory("VonNeumann");

        }
        return entityManagerFactory.createEntityManager();
    }
}
