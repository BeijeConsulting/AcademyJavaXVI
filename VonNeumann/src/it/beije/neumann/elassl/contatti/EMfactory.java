package it.beije.neumann.elassl.contatti;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EMfactory {
private EMfactory() {}
	
	private static EntityManagerFactory entityManagerFactory;
	
	public static EntityManager openEntityManager() {
		if (entityManagerFactory == null) {
			System.out.println("creo EntityManagerFactory...");
			
			entityManagerFactory =  Persistence.createEntityManagerFactory("VonNeumann");
		}
		
		return entityManagerFactory.createEntityManager();
	}
}
