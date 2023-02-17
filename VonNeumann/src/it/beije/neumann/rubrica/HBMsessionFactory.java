package it.beije.neumann.rubrica;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class HBMsessionFactory {

	private HBMsessionFactory() {}
	
	private static SessionFactory sessionFactory;
	
	public static Session openSession() {
		if (sessionFactory == null) {
			System.out.println("creo SessionFactory...");
			
			Configuration configuration = new Configuration().configure()
					.addAnnotatedClass(Contatto.class);

			sessionFactory = configuration.buildSessionFactory();
		}
		
		return sessionFactory.openSession();
	}

}
