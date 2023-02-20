package it.beije.neumann.rubrica.iaria_gestore_rubrica_jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JPAEntityManager {

	private JPAEntityManager() {}
	
	private static EntityManagerFactory entityManagerFactory;
	
	//Singleton
	public static EntityManagerFactory openEntityManager() {
		if(entityManagerFactory == null) {
			//Crea entityManager
			entityManagerFactory = Persistence.createEntityManagerFactory("VonNeumann");
		}
		return entityManagerFactory;
	}

}
