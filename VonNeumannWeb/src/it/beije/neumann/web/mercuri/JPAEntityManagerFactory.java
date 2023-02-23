package it.beije.neumann.web.mercuri;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class JPAEntityManagerFactory {

	private JPAEntityManagerFactory() {}
	
	private static EntityManagerFactory entityManagerFactory;
	
	public static EntityManager createEntityManager() {
		
		if (entityManagerFactory == null) {
			System.out.println("creo EntityManagerFactory...");

			entityManagerFactory = Persistence.createEntityManagerFactory("VonNeumann");
		}
		
		return entityManagerFactory.createEntityManager();
	}

}
