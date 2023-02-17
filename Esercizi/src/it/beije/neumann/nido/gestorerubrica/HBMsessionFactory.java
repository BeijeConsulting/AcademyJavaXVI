package it.beije.neumann.nido.gestorerubrica;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class HBMsessionFactory {

	private HBMsessionFactory() {}
	
	private static SessionFactory sessionFactory;
	
	public static Session openSession() {
		if (sessionFactory == null) {
			
			Configuration configuration = new Configuration().configure()
					.addAnnotatedClass(Contact.class);

			sessionFactory = configuration.buildSessionFactory();
		}
		
		return sessionFactory.openSession();
	}

}
