package it.beije.neumann.web.nido.rubrica.model;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAentityFactory {

	private JPAentityFactory() {
	}

	private static EntityManagerFactory EMFactory;

	public static EntityManager getEntityManager(String persistenceUnitName) {
		if (EMFactory == null) {

			EMFactory = Persistence.createEntityManagerFactory(persistenceUnitName);
		}

		return EMFactory.createEntityManager();

	}

}
