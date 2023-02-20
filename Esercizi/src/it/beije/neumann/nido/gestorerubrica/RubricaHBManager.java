package it.beije.neumann.nido.gestorerubrica;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class RubricaHBManager {

	private static RubricaHBManager hbManager;
	private static Session session;
	private static Transaction transaction;

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
		transaction = session.beginTransaction();

		String selectHQL = "SELECT c FROM Contact AS c ORDER BY " + onWhat + " " + orderBy;

		Query<Contact> query = session.createQuery(selectHQL);
		List<Contact> contacts = query.getResultList();

		for (Contact c : contacts)
			System.out.println(c + "\n");

		transaction.commit();
	}

	public static List<Contact> searchContact(String name, String surname) {
		transaction = session.beginTransaction();

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

		transaction.commit();

		return found;
	}

	public static void addContact(Contact contact) {
		transaction = session.beginTransaction();
		session.save(contact);
		System.out.println("Contatto aggiunto!");
		transaction.commit();
	}
	
	public static void editContact(Contact contact) {
		transaction = session.beginTransaction();

		System.out.println("contatto PRE : " + contact);
		session.save(contact);
		System.out.println("contatto POST : " + contact);

		transaction.commit();

		System.out.println("Modifiche effettuate!");
	}
	
	/*
	 * System.out.println("5.Cancella un contatto");
	 * System.out.println("6.Trova duplicati");
	 * System.out.println("7.Unisci duplicati");
	 */

	public static void deleteContact() {
		transaction = session.beginTransaction();
		transaction.commit();
		System.out.println("deleteContact() on its way for implementation");
	}

	public static void searchDuplicate() {
		transaction = session.beginTransaction();
		transaction.commit();
		System.out.println("searchDuplicate() on its way for implementation");
	}

	public static void mergeDuplicate() {
		transaction = session.beginTransaction();
		transaction.commit();
		System.out.println("mergeDuplicate() on its way for implementation");
	}
}
