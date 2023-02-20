package it.beije.neumann.nido.gestorerubrica;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

public class RubricaJPAManager { //Sistemare
	
	private static RubricaJPAManager jpaManager;
	private static EntityManager entityManager = null;
	private static EntityTransaction transaction = null;
	
	private RubricaJPAManager() {
	}

	public static RubricaJPAManager getJPAManager() {

		if (jpaManager == null)
			jpaManager = new RubricaJPAManager();

		return jpaManager;
	}
	
	private static void launchEntityManager() {
		entityManager = JPAentityFactory.getEntityManager("Esercizi");
		transaction = entityManager.getTransaction();
	}
	
	private static void closeEntityManager() {
		entityManager.close();
	}
	
	
	public static void showRubrica(String orderBy, String onWhat) {
		launchEntityManager();
		transaction.begin();
		
		String selectHQL = "SELECT c FROM Contact AS c ORDER BY " + onWhat + " " + orderBy;

		Query query = entityManager.createQuery(selectHQL);
		List<Contact> contacts = query.getResultList();

		for (Contact c : contacts)
			System.out.println(c + "\n");
		
		transaction.commit();
		closeEntityManager();
	}
	
	public static List<Contact> searchContact(String name, String surname) {
		launchEntityManager();
		transaction.begin();

		String selectHQL = "SELECT c FROM Contact AS c ";

		if (!surname.isEmpty() && !name.isEmpty()) {
			selectHQL += "WHERE name='" + name + "' AND surname='" + surname + "'";
		} else if (!surname.isEmpty()) {
			selectHQL += "WHERE surname='" + surname + "'";
		} else if (!name.isEmpty()) {
			selectHQL += "WHERE name='" + name + "'";
		}

		Query query = entityManager.createQuery(selectHQL);
		List<Contact> found = query.getResultList();
		
		transaction.commit();
		closeEntityManager();
		
		return found;
	}
	
	public static void addContact(Contact contact) {
		launchEntityManager();
		transaction.begin();
		
		entityManager.persist(contact);
		
		transaction.commit();
		closeEntityManager();
		
	}
	
	public static void editContact(Contact contact) {
		launchEntityManager();
		transaction.begin();
		
		Contact toEdit = entityManager.find(Contact.class, contact.getId());
		
		toEdit.setName(contact.getName());
		toEdit.setSurname(contact.getSurname());
		toEdit.setAge(contact.getAge());
		toEdit.setEmail(contact.getEmail());
		toEdit.setTelephone(contact.getTelephone());
		toEdit.setNote(contact.getNote());
		
		entityManager.persist(toEdit);
		
		transaction.commit();
		closeEntityManager();
		
	}
	
	public static void deleteContact(Contact contact) {
		launchEntityManager();
		transaction.begin();
		
		Contact toDelete = entityManager.find(Contact.class, contact.getId());
		
		toDelete.setName(contact.getName());
		toDelete.setSurname(contact.getSurname());
		toDelete.setAge(contact.getAge());
		toDelete.setEmail(contact.getEmail());
		toDelete.setTelephone(contact.getTelephone());
		toDelete.setNote(contact.getNote());
		
		entityManager.remove(toDelete);
		
		transaction.commit();
		closeEntityManager();
		
	}
	
	public static List<Contact> searchDuplicate() {
		launchEntityManager();
		transaction.begin();
		
		System.out.println("searchDuplicate() on its way for implementation");
		
		transaction.commit();
		closeEntityManager();
		
		return null;
	}
	
	public static void mergeDuplicate() {
		launchEntityManager();
		transaction.begin();
		
		System.out.println("mergeDuplicate() on its way for implementation");
		
		transaction.commit();
		closeEntityManager();

	}

}
