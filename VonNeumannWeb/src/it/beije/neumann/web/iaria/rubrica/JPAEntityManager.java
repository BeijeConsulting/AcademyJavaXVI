package it.beije.neumann.web.iaria.rubrica;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAEntityManager {

	private JPAEntityManager() {}
	
	private static EntityManagerFactory entityManagerFactory;
	
	//Singleton
	public static EntityManagerFactory openEntityManager() {
		if(entityManagerFactory == null) {
			//Crea entityManager
			entityManagerFactory = Persistence.createEntityManagerFactory("VonNeumannWeb");
		}
		return entityManagerFactory;
	}

}
