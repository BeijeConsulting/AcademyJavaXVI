package it.beije.neumann.web.nido.rubrica.model;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

public class RubricaJPAWeb{ // Sistemare

	private static RubricaJPAWeb jpaManager;
	private EntityManager entityManager = null;
	private EntityTransaction transaction = null;

	private RubricaJPAWeb() {
	}

	public static RubricaJPAWeb getJPAManager() {

		if (jpaManager == null)
			jpaManager = new RubricaJPAWeb();

		return jpaManager;
	}

	private void launchEntityManager() {
		entityManager = JPAentityFactory.getEntityManager("VonNeumannWeb");
		transaction = entityManager.getTransaction();
	}

	private void closeEntityManager() {
		entityManager.close();
	}

	public List<Contact> showRubrica(String orderBy, String onWhat) {
		launchEntityManager();
		transaction.begin();

		String selectHQL = "SELECT c FROM Contact AS c ORDER BY " + onWhat + " " + orderBy;

		Query query = entityManager.createQuery(selectHQL);
		List<Contact> contacts = query.getResultList();
		
//		for (Contact c : contacts)
//			System.out.println(c + "\n");

		transaction.commit();
		closeEntityManager();
		
		return contacts;
	}

	public List<Contact> searchContact(String name, String surname) {
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

	public void addContact(Contact contact) {
		launchEntityManager();
		transaction.begin();

		entityManager.persist(contact);

		transaction.commit();
		closeEntityManager();

	}

	public void editContact(Contact contact) {
		launchEntityManager();
		transaction.begin();

		Contact toEdit = entityManager.find(Contact.class, contact.getId());

		toEdit.setName(contact.getName());
		toEdit.setSurname(contact.getSurname());
		toEdit.setEmail(contact.getEmail());
		toEdit.setTelephone(contact.getTelephone());
		toEdit.setNote(contact.getNote());

		entityManager.persist(toEdit);

		transaction.commit();
		closeEntityManager();

	}

	public void deleteContact(Contact contact) {
		launchEntityManager();
		transaction.begin();

		Contact toDelete = entityManager.find(Contact.class, contact.getId());

		toDelete.setName(contact.getName());
		toDelete.setSurname(contact.getSurname());
		toDelete.setEmail(contact.getEmail());
		toDelete.setTelephone(contact.getTelephone());
		toDelete.setNote(contact.getNote());

		entityManager.remove(toDelete);

		transaction.commit();
		closeEntityManager();

	}

	public List<Contact> searchDuplicate() {
		launchEntityManager();
		transaction.begin();

		String innerQuery = "SELECT d FROM Contact AS d WHERE d.name = c.name AND d.surname = c.surname AND d.id <> c.id";
		String selectHQL = "SELECT c FROM Contact AS c WHERE EXISTS (" + innerQuery
				+ ") ORDER BY c.surname ASC, c.id ASC";

		Query query = entityManager.createQuery(selectHQL);
		List<Contact> duplicates = query.getResultList();

		transaction.commit();
		closeEntityManager();

		return duplicates;
	}

	public void mergeDuplicate(Contact base, Contact dup) {
		String newVal = null;

		// Telephone
		if (!base.getTelephone().contains(dup.getTelephone())) {
			newVal = FilesUtils.formatNewField(base.getTelephone(), dup.getTelephone());
			base.setTelephone(newVal);
		}

		// Email
		if (!base.getEmail().contains(dup.getEmail())) {
			newVal = FilesUtils.formatNewField(base.getEmail(), dup.getEmail());
			base.setEmail(newVal);
		}

		// Note
		if (!base.getNote().contains(dup.getNote())) {
			newVal = FilesUtils.formatNewField(base.getNote(), dup.getNote());
			base.setNote(newVal);
		}

		this.deleteContact(dup);
		this.editContact(base);

	}

}