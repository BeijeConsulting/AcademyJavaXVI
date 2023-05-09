package it.beije.neumann.db3;


import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;


@Component
public class Db3JpaEntityManager {
	
	private static EntityManagerFactory emfactory = null;

	private Db3JpaEntityManager() {}
	
	@Bean(name = "entityManagerFactory")
	public static synchronized EntityManagerFactory getInstance() {
		System.setProperty("hibernate.show_sql", "true");
		try {
			if (emfactory == null) {
				emfactory = Persistence.createEntityManagerFactory("VonNeumann");
			}
			return emfactory;
		} catch(Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
}