package it.beije.neumann.nido.gestorerubrica;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class RubricaHBManager {

	private static RubricaHBManager hbManager;
	private static Session session;

	private RubricaHBManager() {
	}

	public static RubricaHBManager getHBManager() {

		if (hbManager == null)
			hbManager = new RubricaHBManager();

		return hbManager;
	}

	public static void openSession() {
		session = HBMsessionFactory.openSession();
	}

	public static void closeSession() {
		session.close();
	}

	public static void showRubrica(String orderBy, String onWhat) {
		String selectHQL = "SELECT c FROM Contact AS c ORDER BY " + onWhat + " " + orderBy;

		Query<Contact> query = session.createQuery(selectHQL);
		List<Contact> contacts = query.getResultList();

		for (Contact c : contacts)
			System.out.println(c + "\n");
	}

	public static List<Contact> searchContact(String name, String surname) {
		List<Contact> found = new ArrayList<>();

		String selectHQL = "SELECT c FROM Contact AS c ";

		if (!surname.isEmpty() && !name.isEmpty()) {
			selectHQL += "WHERE name='" + name + "' AND surname='" + surname + "'";
		} else if (!surname.isEmpty()) {
			selectHQL += "WHERE surname='" + surname + "'";
		} else if (!name.isEmpty()) {
			selectHQL += "WHERE name='" + name + "'";
		}

		Query<Contact> query = session.createQuery(selectHQL);
		found = query.getResultList();

		return found;
	}

	public static void addContact(Contact contact) {
		session.save(contact);
	}

	/*
	 * System.out.println("4.Modifica un contatto esistente");
	 * System.out.println("5.Cancella un contatto");
	 * System.out.println("6.Trova duplicati");
	 * System.out.println("7.Unisci duplicati");
	 */
	public static void editContact(String name, String surname) {
		// Se ci sono più corrispondenze, vai su id
		System.out.println("editContact() on its way for implementation");
	}

	public static void deleteContact() {
		System.out.println("deleteContact() on its way for implementation");
	}

	public static void searchDuplicate() {
		System.out.println("searchDuplicate() on its way for implementation");
	}

	public static void mergeDuplicate() {
		System.out.println("mergeDuplicate() on its way for implementation");
	}
}
