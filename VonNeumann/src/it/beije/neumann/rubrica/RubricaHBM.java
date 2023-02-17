package it.beije.neumann.rubrica;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class RubricaHBM {

	public static void main(String[] args) {
		
		Configuration configuration = new Configuration().configure();
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		
		Session session = sessionFactory.openSession();
		
//		Transaction transaction = session.getTransaction();
//		transaction.begin();
		Transaction transaction = session.beginTransaction();
				
		//INSERT
		Contatto contatto = new Contatto();
//		contatto.setId(9);
//		contatto.setName("Francesco");
//		contatto.setSurname("Rossi");
//		contatto.setEmail("francesco@giallo.it");
		
//		System.out.println("contatto PRE : " + contatto);
//		session.save(contatto);
//		System.out.println("contatto POST : " + contatto);

		//SELECT
		Query<Contatto> query = session.createQuery("SELECT c FROM Contatto as c");// WHERE surname = 'Rossi'");//HQL
		List<Contatto> contatti = query.getResultList();
//		for (Contatto c : contatti) {
//			System.out.println(c);
//		}
		System.out.println(contatti);

//		transaction.commit();
//		session.close();
//		session = sessionFactory.openSession();
//		transaction = session.beginTransaction();
		

		//UPDATE
		contatto = contatti.get(contatti.size()-1);
		//contatto.setId(9);
//		contatto.setName("Nicole");
//		contatto.setSurname("Viola");
//		contatto.setEmail("nicole@giallo.it");
//
//		System.out.println("contatto PRE : " + contatto);
//		session.save(contatto);
//		System.out.println("contatto POST : " + contatto);

		//DELETE
		session.delete(contatto);
		
		//if (true) throw new RuntimeException();

		transaction.commit();
		//transaction.rollback();
		
		System.out.println("session is open? " + session.isOpen());
	}

}
