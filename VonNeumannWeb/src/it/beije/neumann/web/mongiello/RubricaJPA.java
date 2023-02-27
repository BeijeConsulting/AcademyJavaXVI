package it.beije.neumann.web.mongiello;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

public class RubricaJPA {
	
	public List<Contatto> getDatabase(){
		
		EntityManager entityManager = JPAentityManagerFactory.createEntityManager();
		Query query = entityManager.createQuery("SELECT c FROM Contatto as c");
		List<Contatto> contatti = query.getResultList();
		entityManager.close();
		return contatti;
	}
	
	public void inserisciContatto(Contatto contatto) {
		EntityManager entityManager = JPAentityManagerFactory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		entityManager.persist(contatto);
		transaction.commit();
		entityManager.close();
	}
	
}
