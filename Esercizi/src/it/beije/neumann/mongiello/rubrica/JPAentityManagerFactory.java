package it.beije.neumann.mongiello.rubrica;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.hibernate.Session;

public class JPAentityManagerFactory {
	
	private JPAentityManagerFactory() {}
	
	private static EntityManagerFactory entityManagerFactory;
	
	public static EntityManager createEntityManager() {

		if(entityManagerFactory == null) {
			System.out.println("creo EntisyManagerFactory...");
			entityManagerFactory = Persistence.createEntityManagerFactory("Esercizi");
			
		}
		return entityManagerFactory.createEntityManager();
	}
}