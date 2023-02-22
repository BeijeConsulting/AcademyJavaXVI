package it.beije.neumann.mongiello.rubrica;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.persistence.criteria.Selection;
import javax.persistence.metamodel.EntityType;
import javax.persistence.metamodel.Metamodel;
import javax.persistence.metamodel.SingularAttribute;

public class RubricaCriteria {

	
	
	public void stampaDb(){
		EntityManager entityManager = JPAentityManagerFactory.createEntityManager();
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Contatto> criteriaQuery =  criteriaBuilder.createQuery(Contatto.class);
		
		Root<Contatto> root = criteriaQuery.from(Contatto.class);
		criteriaQuery.select(root);
				
		Query query = entityManager.createQuery(criteriaQuery);
		List<Contatto> contatti = query.getResultList();
		Contatto.stampaRubrica(contatti);
		entityManager.close();		
}
	
	
	
	
	public void editContatto(int id, String fieldToEdit, String newField) {
		EntityManager entityManager = JPAentityManagerFactory.createEntityManager();		
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaUpdate<Contatto> criteriaUpdate = criteriaBuilder.createCriteriaUpdate(Contatto.class);
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		Root<Contatto> root = criteriaUpdate.from(Contatto.class);
		criteriaUpdate.set(fieldToEdit, newField);
		criteriaUpdate.where( criteriaBuilder.equal(root.get("id"), id)  );
		entityManager.createQuery(criteriaUpdate).executeUpdate();
		
		transaction.commit();
		entityManager.close();
		
	}




	public void deleteContact(int id) {
		EntityManager entityManager = JPAentityManagerFactory.createEntityManager();		
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaDelete<Contatto> criteriaDelete = criteriaBuilder.createCriteriaDelete(Contatto.class);
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		Root<Contatto> root = criteriaDelete.from(Contatto.class);
		criteriaDelete.where( criteriaBuilder.equal(root.get("id"), id)  );
		entityManager.createQuery(criteriaDelete).executeUpdate();
		
		transaction.commit();
		entityManager.close();
		
	}




	public void order(String valore) {
		if( valore.equals("nome".toLowerCase().trim()) ) {
			valore = "name";
		}else if( valore.equals("cognome".toLowerCase().trim())) {
			valore = "surname";
		}
		
		EntityManager entityManager = JPAentityManagerFactory.createEntityManager();
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Contatto> criteriaQuery =  criteriaBuilder.createQuery(Contatto.class);
		
		Root<Contatto> root = criteriaQuery.from(Contatto.class);
		criteriaQuery.select(root);
		criteriaQuery.orderBy(criteriaBuilder.asc(root.get(valore)));		
		Query query = entityManager.createQuery(criteriaQuery);
		List<Contatto> contatti = query.getResultList();
		Contatto.stampaRubrica(contatti);
		entityManager.close();		
		
	}




	public void search(String surname) {
	
		EntityManager entityManager = JPAentityManagerFactory.createEntityManager();
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Contatto> criteriaQuery =  criteriaBuilder.createQuery(Contatto.class);
		
		Root<Contatto> root = criteriaQuery.from(Contatto.class);
		criteriaQuery.select(root);
		criteriaQuery.where( criteriaBuilder.equal(root.get("surname"), surname) );		
		Query query = entityManager.createQuery(criteriaQuery);
		List<Contatto> contatti = query.getResultList();
		Contatto.stampaRubrica(contatti);
		entityManager.close();
		
	}




	public void duplicate() {

		EntityManager entityManager = JPAentityManagerFactory.createEntityManager();
	
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Contatto> criteriaQuery = criteriaBuilder.createQuery(Contatto.class);
		
		Root<Contatto> c1 = criteriaQuery.from(Contatto.class);
		Root<Contatto> c2 = criteriaQuery.from(Contatto.class);

		Predicate sameName = criteriaBuilder.equal(c2.get("name"),c1.get("name"));
		Predicate sameSurname = criteriaBuilder.equal(c2.get("surname"),c1.get("surname"));
		Predicate differentId = criteriaBuilder.notEqual(c2.get("id"),c1.get("id"));
		criteriaQuery.where(criteriaBuilder.and(sameName, differentId ,sameSurname));
		
		
		Query query = entityManager.createQuery(criteriaQuery);
		
		List<Contatto> contatti = query.getResultList();
		Contatto.stampaRubrica(contatti);
		entityManager.close();
	}
	
	
}