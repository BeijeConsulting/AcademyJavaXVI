package it.beije.neumann.elassl.contatti;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.Transaction;

import it.beije.neumann.rubrica.Contatto;

public class DBjpa implements ContactManager {
	
	DBjpa(){
		EntityManager entityManager = EMfactory.openEntityManager();
		entityManager.close();
	}

	@Override
	public List<Contatto> getContatti() throws ClassNotFoundException {
		EntityManager entityManager = EMfactory.openEntityManager();
		Query query = entityManager.createQuery("SELECT c FROM Contatto as c");
		List<Contatto> contatti = query.getResultList();
		entityManager.close();
		return contatti;
	}

	@Override
	public int writeContatto(Contatto contatto) throws ClassNotFoundException {
		EntityManager entityManager = EMfactory.openEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		entityManager.persist(contatto);
		transaction.commit();
		entityManager.close();
		return 0;
	}

	@Override
	public int updateContatto(Contatto contact) throws ClassNotFoundException {
		EntityManager entityManager = EMfactory.openEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		Contatto c = entityManager.find(Contatto.class, contact.getId());
		c.setName(contact.getName());
		c.setSurname(contact.getSurname());
		c.setEmail(contact.getEmail());
		c.setTelephone(contact.getTelephone());
		c.setNote(contact.getNote());
		entityManager.persist(c);
		transaction.commit();
		entityManager.close();
		return 0;
	}

	@Override
	public List<Contatto> getDuplicates() throws ClassNotFoundException {
		String textQuery = "SELECT c1 FROM Contatto as c1 WHERE EXISTS (SELECT 1 FROM Contatto as c2 WHERE c2.name = c1.name AND c2.surname = c1.surname AND c2.id <> c1.id)";
		EntityManager entityManager = EMfactory.openEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		Query query = entityManager.createQuery(textQuery);
		List<Contatto> contatti = query.getResultList();
		transaction.commit();
		entityManager.close();
		return contatti;
	}

	@Override
	public void mergeDuplicates() throws ClassNotFoundException {
		
		List<Contatto> duplicateContacts = getDuplicates();
		List<Contatto> deleted = new ArrayList<>();
		
		for(Contatto contact1: duplicateContacts) {
			for(Contatto contact2: duplicateContacts) {
				if(!deleted.contains(contact1) && !deleted.contains(contact2) && contact1.equals(contact2) && contact1.getId() != contact2.getId()) {
					String telephone = (contact1.getTelephone() == null || contact1.getTelephone().length() == 0) ? contact2.getTelephone() : contact1.getTelephone();
					String email = (contact1.getEmail() == null || contact1.getEmail().length() == 0) ? contact2.getEmail() : contact1.getEmail();
					String note = (contact1.getNote() == null || contact1.getNote().length() == 0) ? contact2.getNote() : contact1.getNote();
					contact1.setTelephone(telephone);
					contact1.setEmail(email);
					contact1.setNote(note);
					deleteContatto(contact2);
					deleted.add(contact2);
					updateContatto(contact1);
				}	
			}
		}
	}

	@Override
	public int deleteContatto(Contatto contact) throws ClassNotFoundException {
		EntityManager entityManager = EMfactory.openEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		Contatto c = entityManager.find(Contatto.class, contact.getId());
		entityManager.remove(c);
		transaction.commit();
		entityManager.close();
		return 0;
	}

	@Override
	public List<Contatto> getContatto(Contatto contact) {
		EntityManager entityManager = EMfactory.openEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		List<Contatto> contatti = entityManager.createQuery("SELECT c FROM Contatto as c where c.name = :name and c.surname = :surname")
				.setParameter("name", contact.getName()).setParameter("surname", contact.getSurname()).getResultList();
		return contatti;
	}

}
