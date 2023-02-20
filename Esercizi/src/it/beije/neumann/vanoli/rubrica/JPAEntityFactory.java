package it.beije.neumann.vanoli.rubrica;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class JPAEntityFactory {

	private JPAEntityFactory() {}
	
	private static EntityManagerFactory entityManagerFactory;
	
	public static EntityManager createEntityManager() {
		if (entityManagerFactory == null) {
			System.out.println("creo EntityManager factory...");
			entityManagerFactory = Persistence.createEntityManagerFactory("Esercizi");			
		}		
		return entityManagerFactory.createEntityManager();
	}

}
