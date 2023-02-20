package it.beije.neumann.nido.gestorerubrica;

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
