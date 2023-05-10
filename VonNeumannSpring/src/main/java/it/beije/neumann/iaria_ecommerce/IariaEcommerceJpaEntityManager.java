package it.beije.neumann.iaria_ecommerce;


import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;


@Component
public class IariaEcommerceJpaEntityManager {
	
	private static EntityManagerFactory emfactory = null;

	private IariaEcommerceJpaEntityManager() {}
	
	@Bean(name = "entityManagerFactory")
	public static synchronized EntityManagerFactory getInstance() {
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