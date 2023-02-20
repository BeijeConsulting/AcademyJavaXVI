package it.beije.neumann.vanoli.rubrica;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.Transaction;



public class RubricaJPA {
	
	public static List<Contatto> LoadRubricaFromDB() {		
		EntityManager entityManager = JPAEntityFactory.createEntityManager();
		Query query = entityManager.createQuery("SELECT c FROM Contatto as c");
		List<Contatto> contatti = query.getResultList();
		entityManager.close();
		return contatti;
	}
	
	public static void WriteRubricaToDB(List<Contatto> listaContatti) {
		EntityManager entityManager = JPAEntityFactory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		for (Contatto c: listaContatti) {
			c.setId(0);
			entityManager.persist(c);
		}
		transaction.commit();
		entityManager.close();
	}
	
	//funzioni riga di comando	
	public static List<Contatto> elencoRubrica(String orderBy) {				
		EntityManager entityManager = JPAEntityFactory.createEntityManager();
		Query query = entityManager.createQuery("SELECT c FROM Contatto as c ORDER BY " + orderBy);
		List<Contatto> contatti = query.getResultList();
		entityManager.close();
		return contatti;
	}

	public static List<Contatto> cercaContatto(String nome, String cognome) {
		EntityManager entityManager = JPAEntityFactory.createEntityManager();
		
		Query query = entityManager.createQuery("SELECT c FROM Contatto as c WHERE nome = :param1 AND cognome = :param2");
		query.setParameter("param1", nome);
		query.setParameter("param2", cognome);
		List<Contatto> contatti = query.getResultList();	
		return contatti;
	}
	
	public static void inserisciContatto(Contatto c) {
		EntityManager entityManager = JPAEntityFactory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();		
		c.setId(0);
		entityManager.persist(c);		
		transaction.commit();
		entityManager.close();
	}
	
	public static void editContatto(Contatto newC) {
		EntityManager entityManager = JPAEntityFactory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		Query query = entityManager.createQuery("SELECT c FROM Contatto as c WHERE id = :param1");
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
		entityManager.persist(oldC);
		transaction.commit();
		entityManager.close();
	}
	
	public static void deleteContatto(Contatto c) {
		EntityManager entityManager = JPAEntityFactory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		Query query = entityManager.createQuery("SELECT c FROM Contatto as c WHERE id = :param1");
		query.setParameter("param1", c.getId());
		List<Contatto> contatti = query.getResultList();
		if (contatti.size() != 1) {
			throw new RuntimeException("Il DB si è rotto...");
		}
		entityManager.remove(contatti.get(0));
		transaction.commit();
		entityManager.close();
	}
	
	public static List<Contatto> trovaContattiDuplicati() {
		EntityManager entityManager = JPAEntityFactory.createEntityManager();
		Query query = entityManager.createQuery("SELECT c1 FROM Contatto as c1 WHERE EXISTS (SELECT c2 FROM Contatto as c2 WHERE c2.name = c1.name AND c2.surname = c1.surname AND c2.id <> c1.id)");
		List<Contatto> contatti = query.getResultList();
		entityManager.close();
		return contatti;
	}
	
	/*
	public static void main(String[] args) {
		
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Esercizi");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		
		//INSERT
		Contatto contatto = new Contatto();
//		contatto.setId(9);
		contatto.setName("Paride");
		contatto.setSurname("Gialli");
		contatto.setEmail("paride@giallo.it");
		
		System.out.println("contatto PRE : " + contatto);
		entityManager.persist(contatto);
		System.out.println("contatto POST : " + contatto);

		//SELECT JPQL
//		Query query = entityManager.createQuery("SELECT c FROM Contatto as c");
//		List<Contatto> contatti = query.getResultList();
////		for (Contatto c : contatti) {
////			System.out.println(c);
////		}
//		System.out.println(contatti);
		
		contatto = entityManager.find(Contatto.class, 1);
		System.out.println(contatto);

		//UPDATE
//		contatto = contatti.get(contatti.size()-1);
		//contatto.setId(9);
//		contatto.setName("Youness");
//		contatto.setSurname("Verde");
//		contatto.setEmail("youness@verde.it");
//
//		System.out.println("contatto PRE : " + contatto);
//		entityManager.persist(contatto);
//		System.out.println("contatto POST : " + contatto);

		//DELETE
//		entityManager.remove(contatto);
		
		transaction.commit();
		//transaction.rollback();

		entityManager.close();
	}
*/
}
