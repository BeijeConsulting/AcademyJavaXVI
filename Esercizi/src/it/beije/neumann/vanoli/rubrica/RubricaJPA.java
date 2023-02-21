package it.beije.neumann.vanoli.rubrica;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

public class RubricaJPA implements RubricaInterface{
	
	public List<Contatto> LoadRubricaFromDB() {		
		EntityManager entityManager = JPAEntityFactory.createEntityManager();
		Query query = entityManager.createQuery("SELECT c FROM Contatto as c");
		List<Contatto> contatti = query.getResultList();
		entityManager.close();
		return contatti;
	}
	
	public void WriteRubricaToDB(List<Contatto> listaContatti) {
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
	public List<Contatto> elencoRubrica(String orderBy) {				
		EntityManager entityManager = JPAEntityFactory.createEntityManager();
		Query query = entityManager.createQuery("SELECT c FROM Contatto as c ORDER BY " + orderBy);
		List<Contatto> contatti = query.getResultList();
		entityManager.close();
		return contatti;
	}

	public List<Contatto> cercaContatto(String nome, String cognome) {
		EntityManager entityManager = JPAEntityFactory.createEntityManager();
		
		Query query = entityManager.createQuery("SELECT c FROM Contatto as c WHERE nome = :param1 AND cognome = :param2");
		query.setParameter("param1", nome);
		query.setParameter("param2", cognome);
		List<Contatto> contatti = query.getResultList();	
		return contatti;
	}
	
	public void inserisciContatto(Contatto c) {
		EntityManager entityManager = JPAEntityFactory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();		
		c.setId(0);
		entityManager.persist(c);		
		transaction.commit();
		entityManager.close();
	}
	
	public void editContatto(Contatto newC) {
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
		oldC.setNome(newC.getNome());
		oldC.setCognome(newC.getCognome());
		oldC.setTelefono(newC.getTelefono());
		oldC.setEmail(newC.getEmail());
		oldC.setNote(newC.getNote());
		entityManager.persist(oldC);
		transaction.commit();
		entityManager.close();
	}
	
	public void deleteContatto(Contatto c) {
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
	
	public List<Contatto> trovaContattiDuplicati() {
		EntityManager entityManager = JPAEntityFactory.createEntityManager();
		Query query = entityManager.createQuery("SELECT c1 FROM Contatto as c1 WHERE EXISTS (SELECT c2 FROM Contatto as c2 WHERE c2.nome = c1.nome AND c2.cognome = c1.cognome AND c2.id <> c1.id)");
		List<Contatto> contatti = query.getResultList();
		entityManager.close();
		return contatti;
	}
}
