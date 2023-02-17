package it.beije.neumann.vanoli.rubrica;


import java.io.IOException;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

public class RubricaHBM {
	
	public static List<Contatto> LoadRubricaFromDB() throws ClassNotFoundException, IOException {		
		Session session = HBMsessionFactory.openSession();
		Query<Contatto> query = session.createQuery("SELECT c FROM Contatto as c");
		List<Contatto> contatti = query.getResultList();	
		return contatti;
	}

	public static void WriteRubricaToDB(List<Contatto> listaContatti) throws ClassNotFoundException, IOException {
		Session session = HBMsessionFactory.openSession();
		Transaction transaction = session.beginTransaction();		
		for (Contatto c: listaContatti) {				
			session.save(c);
		}
		transaction.commit();
	}
	
	//funzioni riga di comando	
	public static List<Contatto> elencoRubrica(String orderBy) {				
		Session session = HBMsessionFactory.openSession();
		Query<Contatto> query = session.createQuery("SELECT c FROM Contatto as c ORDER BY " + orderBy);
		List<Contatto> contatti = query.getResultList();	
		return contatti;
	}
	
	public static List<Contatto> cercaContatto(String nome, String cognome) {
		Session session = HBMsessionFactory.openSession();
		
		Query<Contatto> query = session.createQuery("SELECT c FROM Contatto as c WHERE nome = :param1 AND cognome = :param2");
		query.setParameter("param1", nome);
		query.setParameter("param2", cognome);
		List<Contatto> contatti = query.getResultList();	
		return contatti;
	}
	
	public static void inserisciContatto(Contatto c) {
		Session session = HBMsessionFactory.openSession();
		Transaction transaction = session.beginTransaction();		
		session.save(c);
		transaction.commit();
	}
	
	public static void editContatto(Contatto newC) {
		Session session = HBMsessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		Query<Contatto> query = session.createQuery("SELECT c FROM Contatto as c WHERE id = :param1");
		query.setParameter("param1", newC.getId());
		List<Contatto> contatti = query.getResultList();
		if (contatti.size() != 1) {
			throw new RuntimeException("Il DB si è rotto...");
		}
		Contatto oldC = contatti.get(0);
		oldC.setName(newC.getName());
		oldC.setSurname(newC.getSurname());
		oldC.setTelephone(newC.getTelephone());
		oldC.setEmail(newC.getEmail());
		oldC.setNote(newC.getNote());
		session.save(oldC);
		transaction.commit();
	}
	
	public static void deleteContatto(Contatto c) {
		Session session = HBMsessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		Query<Contatto> query = session.createQuery("SELECT c FROM Contatto as c WHERE id = :param1");
		query.setParameter("param1", c.getId());
		List<Contatto> contatti = query.getResultList();
		if (contatti.size() != 1) {
			throw new RuntimeException("Il DB si è rotto...");
		}
		session.delete(contatti.get(0));
		transaction.commit();
	}
	
	public static List<Contatto> trovaContattiDuplicati() {
		Session session = HBMsessionFactory.openSession();
		Query<Contatto> query = session.createQuery("SELECT nome, cognome, COUNT(*) FROM rubrica.contatti GROUP BY nome, cognome HAVING COUNT(*) > 1");
		List<Contatto> contatti = query.getResultList();	
		return contatti;		
	}
	/*
	public static List<Contatto> unisciContattiDuplicati() {
		
	}
	*/
	
}
