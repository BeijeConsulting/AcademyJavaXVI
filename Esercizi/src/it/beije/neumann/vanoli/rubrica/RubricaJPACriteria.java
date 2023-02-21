package it.beije.neumann.vanoli.rubrica;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.Transaction;



public class RubricaJPACriteria implements RubricaInterface{
	
	public List<Contatto> LoadRubricaFromDB() {		
		EntityManager entityManager = JPAEntityFactory.createEntityManager();
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<Contatto> cr = cb.createQuery(Contatto.class);
		Root<Contatto> root = cr.from(Contatto.class);
		cr.select(root);
		Query query = entityManager.createQuery(cr);
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
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<Contatto> cr = cb.createQuery(Contatto.class);
		Root<Contatto> root = cr.from(Contatto.class);
		cr.select(root).orderBy(cb.asc(root.get(orderBy)));
		Query query = entityManager.createQuery(cr);
		List<Contatto> contatti = query.getResultList();
		entityManager.close();
		return contatti;
	}

	public List<Contatto> cercaContatto(String nome, String cognome) {
		EntityManager entityManager = JPAEntityFactory.createEntityManager();
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<Contatto> cr = cb.createQuery(Contatto.class);
		Root<Contatto> root = cr.from(Contatto.class);
		cr.select(root).where(cb.and(cb.equal(root.get("nome"), nome), 
									 cb.equal(root.get("cognome"), cognome)));
		Query query = entityManager.createQuery(cr);
		List<Contatto> contatti = query.getResultList();
		entityManager.close();
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
		Query query = entityManager.createQuery("SELECT c1 FROM Contatto as c1 WHERE EXISTS (SELECT c2 FROM Contatto as c2 WHERE c2.name = c1.name AND c2.surname = c1.surname AND c2.id <> c1.id)");
		List<Contatto> contatti = query.getResultList();
		entityManager.close();
		return contatti;
	}
}
