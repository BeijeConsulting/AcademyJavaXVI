package it.beije.neumann.nido.gestorerubrica;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

public class RubricaHBManager implements RubricaQLManager {

	private static RubricaHBManager hbManager;
	private Session session;
	private Transaction transaction;

	private RubricaHBManager() {
	}

	public static RubricaHBManager getHBManager() {

		if (hbManager == null)
			hbManager = new RubricaHBManager();

		return hbManager;
	}

	private void openSession() {
		session = HBMsessionFactory.openSession();
	}

	private void closeSession() {
		session.close();
	}

	public void showRubrica(String orderBy, String onWhat) {
		openSession();
		// transaction = session.beginTransaction();

		String selectHQL = "SELECT c FROM Contact AS c ORDER BY " + onWhat + " " + orderBy;

		Query<Contact> query = session.createQuery(selectHQL);
		List<Contact> contacts = query.getResultList();

		for (Contact c : contacts)
			System.out.println(c + "\n");

		// transaction.commit();
		closeSession();
	}

	public List<Contact> searchContact(String name, String surname) {
		openSession();
//		transaction = session.beginTransaction();

		String selectHQL = "SELECT c FROM Contact AS c ";

		if (!surname.isEmpty() && !name.isEmpty()) {
			selectHQL += "WHERE name='" + name + "' AND surname='" + surname + "'";
		} else if (!surname.isEmpty()) {
			selectHQL += "WHERE surname='" + surname + "'";
		} else if (!name.isEmpty()) {
			selectHQL += "WHERE name='" + name + "'";
		}

		Query<Contact> query = session.createQuery(selectHQL);
		List<Contact> found = query.getResultList();

//		transaction.commit();
		closeSession();

		return found;
	}

	public void addContact(Contact contact) {
		openSession();
//		transaction = session.beginTransaction();
		session.save(contact);
		System.out.println("Contatto aggiunto!");
//		transaction.commit();
		closeSession();
	}

	public void editContact(Contact contact) {
		openSession();
		transaction = session.beginTransaction();

		String selectHQL = "SELECT c FROM Contact AS c WHERE id='" + contact.getId() + "'";

		Query<Contact> query = session.createQuery(selectHQL);
		Contact toEdit = query.getResultList().get(0); // La lista avrà un solo record, controllo fatto a monte

		toEdit.setName(contact.getName());
		toEdit.setSurname(contact.getSurname());
		toEdit.setEmail(contact.getEmail());
		toEdit.setTelephone(contact.getTelephone());
		toEdit.setNote(contact.getNote());

		System.out.println("contatto PRE : " + toEdit);
		session.save(toEdit);
		System.out.println("contatto POST : " + toEdit);

		transaction.commit();
		closeSession();

		System.out.println("Modifiche effettuate!");
	}

	public void deleteContact(Contact contact) {
		openSession();
		transaction = session.beginTransaction();

		String selectHQL = "SELECT c FROM Contact AS c WHERE id='" + contact.getId() + "'";

		Query<Contact> query = session.createQuery(selectHQL);
		Contact toDelete = query.getResultList().get(0); // La lista avrà un solo record, controllo fatto a monte

		toDelete.setName(contact.getName());
		toDelete.setSurname(contact.getSurname());
		toDelete.setEmail(contact.getEmail());
		toDelete.setTelephone(contact.getTelephone());
		toDelete.setNote(contact.getNote());

		System.out.println("contatto PRE : " + toDelete);
		session.delete(toDelete);
		System.out.println("contatto POST : " + toDelete);

		transaction.commit();
		closeSession();

		System.out.println("Contatto eliminato!");
		System.out.println("deleteContact() on its way for implementation");
	}

	/*
	 * System.out.println("6.Trova duplicati");
	 * System.out.println("7.Unisci duplicati");
	 */

	public List<Contact> searchDuplicate() {
		openSession();
		transaction = session.beginTransaction();

		String innerQuery = "SELECT d FROM Contact AS d WHERE d.name = c.name AND d.surname = c.surname AND d.id <> c.id";
		String selectHQL = "SELECT c FROM Contact AS c WHERE EXISTS (" + innerQuery
				+ ") ORDER BY c.surname ASC, c.id ASC";

		Query<Contact> query = session.createQuery(selectHQL);
		List<Contact> found = query.getResultList();

		transaction.commit();
		closeSession();

		return found;
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
