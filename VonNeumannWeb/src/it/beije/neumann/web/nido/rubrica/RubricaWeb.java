package it.beije.neumann.web.nido.rubrica;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RubricaWeb {

//	public static final String CSV = "./src/it/beije/neumann/nido/gestorerubrica/addressBook.csv";
//	public static final String XML = "./src/it/beije/neumann/nido/gestorerubrica/addressBook.xml";

//	public static RubricaImportManager importManager = new RubricaImportManager();
//	public static RubricaExportManager exportManager = new RubricaExportManager();
//	public static RubricaDBManager dbManager = RubricaDBManager.getDBManager();
//	public static RubricaHBManager hbManager = RubricaHBManager.getHBManager();
	private static RubricaJPAWeb jpaManager = RubricaJPAWeb.getJPAManager();
//	public static RubricaJPACriteriaManager criteriaManager = RubricaJPACriteriaManager.getJPACriteriaManager();

	public static List<Contact> op1(String orderBy, String onWhat) {
//		Scanner in = new Scanner(System.in);
//
//		String orderBy = null;
//		String onWhat = null;
//
//		System.out.print("In che ordine vuoi che ti venga mostrata la rubrica? (crescente/decrescente): ");
//		orderBy = in.nextLine().toLowerCase();

		switch (orderBy) {
		default:
		case "crescente":
			orderBy = "ASC";
			break;

		case "decrescente":
			orderBy = "DESC";
			break;

		}

//		System.out.print("Su che campo vuoi ordinare? (nome/cognome): ");
//		onWhat = in.nextLine().toLowerCase();

		switch (onWhat) {
		default:
		case "nome":
			onWhat = "name";
			break;

		case "cognome":
			onWhat = "surname";
			break;

		}
		
		StringBuilder out = new StringBuilder("");

		List<Contact> contacts = jpaManager.showRubrica(orderBy, onWhat);
		
//		for (Contact c : contacts) {
//			out.append(c).append("<br/><br/>");
//		}
		
		return contacts;
			
	}

	public static void op2() {
		List<Contact> contactsFound = new ArrayList<>();

		Scanner in = new Scanner(System.in);

		System.out.print("Inserisci i dati del contatto da cercare:\n");
		System.out.print("\t-Cognome: ");
		String surname = in.nextLine().trim();

		System.out.print("\t-Nome: ");
		String name = in.nextLine().trim();

		contactsFound = jpaManager.searchContact(name, surname);

		if (contactsFound.size() == 0) {
			System.out.println("Mi dispiace, non è stato trovato alcun [" + name + " " + surname + "]");
		} else {
			System.out.println(contactsFound);
		}

	}

	public static void op3() {
		Scanner in = new Scanner(System.in);
		Contact contact = new Contact();

		System.out.print("Inserisci un nuovo contatto:\n");

		System.out.print("\t-Cognome: ");
		contact.setSurname(in.nextLine());

		System.out.print("\t-Nome: ");
		contact.setName(in.nextLine());

		System.out.print("\t-Telefono: ");
		contact.setTelephone(in.nextLine());

		System.out.print("\t-E-Mail: ");
		contact.setEmail(in.nextLine());

		System.out.print("\t-Note sul contatto: ");
		contact.setNote(in.nextLine());

		System.out.println();

		jpaManager.addContact(contact);

		System.out.println("Contatto aggiunto!");
	}

	public static void op4() {
		List<Contact> found = new ArrayList<>();

		Scanner in = new Scanner(System.in);

		System.out.print("Inserisci i dati del contatto da modificare:\n");
		System.out.print("\t-Cognome: ");
		String surname = in.nextLine().trim();

		System.out.print("\t-Nome: ");
		String name = in.nextLine().trim();

		Contact newC = new Contact();

		found = jpaManager.searchContact(name, surname);

		if (found.size() == 0) {
			System.out.println("Mi dispiace, non è stato trovato alcun [" + name + " " + surname + "]");
		} else {
			if (found.size() == 1) {
				System.out.println("Trovato: " + found);
				newC = found.get(0);
			} else {
				System.out.println("C'è più di un contatto corrispondente:");
				System.out.println(found);

				System.out.print("Inserisci l'ID del contatto da modificare: ");
				int id = Integer.parseInt(in.nextLine());

				for (Contact con : found) {
					if (con.getId() == id) {
						newC = con;
					}
				}
			}

			System.out.print("\nInserisci i valori: ");

			System.out.print("\n\t-Cognome: ");
			newC.setSurname(in.nextLine());

			System.out.print("\t-Nome: ");
			newC.setName(in.nextLine());

			System.out.print("\t-Telefono: ");
			newC.setTelephone(in.nextLine());

			System.out.print("\t-E-Mail: ");
			newC.setEmail(in.nextLine());

			System.out.print("\t-Note sul contatto: ");
			newC.setNote(in.nextLine());

			jpaManager.editContact(newC);
		}

	}

	public static void op5() {
		List<Contact> found = new ArrayList<>();

		Scanner in = new Scanner(System.in);

		System.out.print("Inserisci i dati del contatto da eliminare:\n");
		System.out.print("\t-Cognome: ");
		String surname = in.nextLine().trim();

		System.out.print("\t-Nome: ");
		String name = in.nextLine().trim();

		Contact newC = new Contact();

		found = jpaManager.searchContact(name, surname);

		if (found.size() == 0) {
			System.out.println("Mi dispiace, non è stato trovato alcun [" + name + " " + surname + "]");
		} else {
			if (found.size() == 1) {
				System.out.println("Trovato: " + found);
				newC = found.get(0);
			} else {
				System.out.println("C'è più di un contatto corrispondente:");
				System.out.println(found);

				System.out.print("Inserisci l'ID del contatto da eliminare: ");
				int id = Integer.parseInt(in.nextLine());

				for (Contact con : found) {
					if (con.getId() == id) {
						newC = con;
					}
				}
			}

			jpaManager.deleteContact(newC);
		}
	}

	public static void op6() {
		List<Contact> duplicates = jpaManager.searchDuplicate();

		if (duplicates.size() > 0) {
			for (Contact d : duplicates) {
				System.out.println(d);
			}
		} else {
			System.out.println("Non sono stati trovati duplicati.");
		}
	}

	public static void op7() {
		List<Contact> duplicates = jpaManager.searchDuplicate();

		Contact base = null;

		if (!duplicates.isEmpty()) {

			for (Contact dup : duplicates) {
				if (dup.equals(base) && dup.getId() != base.getId()) {

					jpaManager.mergeDuplicate(base, dup);

				} else {
					base = dup;
				}

			}

			System.out.println("Contatti duplicati uniti correttamente!");
		} else {
			System.out.println("Nessun contatto da unificare");
		}

	}

	public static void subMenuOp8_9() {
		System.out.println("*.Importa rubrica");
		System.out.println("8.Da CSV");
		System.out.println("9.Da XML");
	}

	public static void subMenuOp10_11() {
		System.out.println("*.Esporta rubrica");
		System.out.println("10.Su CSV");
		System.out.println("11.Su XML");
	}

}
