package it.beije.neumann.elassl.contatti;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.persistence.criteria.Subquery;

import it.beije.neumann.rubrica.Contatto;

public class DBjpacriteria extends DBjpa {
	
	@Override
	public int updateContatto(Contatto contact) throws ClassNotFoundException {
		EntityManager entityManager = EMfactory.openEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<Contatto> cq = cb.createQuery(Contatto.class);
		// create a Root object
		Root<Contatto> rootContact = cq.from(Contatto.class);
		// Predicate object for filtering contacts by id
		Predicate isSearchedContact = cb.equal(rootContact.get("id"), contact.getId());
		//apply predicate to query
		cq.select(rootContact).where(isSearchedContact);
		transaction.begin();
		List<Contatto> toUpdate = entityManager.createQuery(cq).getResultList();
		for(Contatto c: toUpdate) { //I don't create different transactions because it will always be only one contact
			c.setName(contact.getName());
			c.setSurname(contact.getSurname());
			c.setEmail(contact.getEmail());
			c.setTelephone(contact.getTelephone());
			c.setNote(contact.getNote());
			entityManager.persist(c);
		}
		transaction.commit();
		entityManager.close();
		return 0;
	}

	@Override
	public List<Contatto> getDuplicates() throws ClassNotFoundException {
		
		EntityManager entityManager = EMfactory.openEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<Contatto> criteriaQuery = cb.createQuery(Contatto.class);
		Root<Contatto> c1 = criteriaQuery.from(Contatto.class);
		Root<Contatto> c2 = criteriaQuery.from(Contatto.class);
		criteriaQuery.select(c1);
		Predicate sameName = cb.equal(c2.get("name"),c1.get("name"));
		Predicate sameSurname = cb.equal(c2.get("surname"),c1.get("surname"));
		Predicate differentID = cb.notEqual(c2.get("id"),c1.get("id"));
		criteriaQuery.where(cb.and(sameName, sameSurname, differentID));
		
		/*
		//create query with specified return class
		CriteriaQuery<Contatto> criteriaQuery = cb.createQuery(Contatto.class);
		// create a Root object
		Root<Contatto> c1 = criteriaQuery.from(Contatto.class);
		// Predicate object for filtering contacts by id
		
		Subquery<Integer> subQuery = criteriaQuery.subquery(Integer.class);
		Root<Contatto> c2 = criteriaQuery.from(Contatto.class);
		
		subQuery.select(cb.literal(1));

		Predicate sameName = cb.equal(c2.get("name"),c1.get("name"));
		Predicate sameSurname = cb.equal(c2.get("surname"),c1.get("surname"));
		Predicate differentID = cb.notEqual(c2.get("id"),c1.get("id"));
		subQuery.where(cb.and(sameName, sameSurname, differentID)); //same as cb.and(sameName, sameSurname, differentID) as argument, not the same if I had to use an or
		//apply predicate to query

		criteriaQuery.select(c1);
		criteriaQuery.where(cb.exists(subQuery));
		*/
		
		
		transaction.begin();
		Query query = entityManager.createQuery(criteriaQuery);
		List<Contatto> contatti = query.getResultList();
		transaction.commit();
		entityManager.close();
		return contatti;
	}
	/*
	 * Root<YourTable> queryRootTable = query.from(YourTable.class);
		Join<YourTable, YourTable> selfJoin = queryRootTable.join(queryRootTable);
		
		CriteriaQuery<Contatto> cq = cb.createQuery(Contatto.class);
		Root<Contatto> c1 = cq.from(Contatto.class);
		Join<Contatto, Contatto> c2 = c1.join("id");
		cq.select(c1);
		cq.where(cb.and(
		    cb.equal(c2.get("name"), c1.get("name")),
		    cb.equal(c2.get("surname"), c1.get("surname")),
		    cb.notEqual(c2.get("id"), c1.get("id"))
		));
	 */
	
	public List<Contatto> getContatto(Contatto contact){
		EntityManager entityManager = EMfactory.openEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery criteriaQuery = criteriaBuilder.createQuery(Contatto.class); 
		Root<Contatto> c1 = criteriaQuery.from(Contatto.class);
		criteriaQuery.select(c1).where(criteriaBuilder.equal(c1.get("name"), contact.getName()), criteriaBuilder.equal(c1.get("surname"), contact.getSurname()));
		transaction.begin();
		Query query = entityManager.createQuery(criteriaQuery);
		List<Contatto> contatti = query.getResultList();
		transaction.commit();
		entityManager.close();
		return contatti;
	}
}
