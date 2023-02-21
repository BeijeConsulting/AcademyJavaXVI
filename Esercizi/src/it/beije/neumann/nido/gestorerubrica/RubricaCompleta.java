/*
 * Implementare un gestore di rubrica a linea di comando, con le seguenti funzionalità:
 * -vedi lista contatti (con possibilità di ordinare per nome e cognome a scelta)
 * -cerca contatto
 * -inserisci nuovo contatto
 * -modifica contatto
 * -cancella contatto
 * -trova contatti duplicati (stesso nome e cognome)
 * -unisci contatti duplicati
 * 
 * La rubrica deve essere memorizzata su DB e deve esserci la possibilità
 * di importare ed esportare contatti da/in file XML e CSV
 */
package it.beije.neumann.nido.gestorerubrica;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/* TODO
 * - Import/Export manager come singleton? static class?
 * - Richiamare su menu funzioni import/export
 */

public class RubricaCompleta {

	public static final String CSV = "./src/it/beije/neumann/nido/gestorerubrica/addressBook.csv";
	public static final String XML = "./src/it/beije/neumann/nido/gestorerubrica/addressBook.xml";

	public static RubricaImportManager importManager = new RubricaImportManager();
	public static RubricaExportManager exportManager = new RubricaExportManager();
	public static RubricaDBManager dbManager = RubricaDBManager.getDBManager();
	public static RubricaHBManager hbManager = RubricaHBManager.getHBManager();
	public static RubricaJPAManager jpaManager = RubricaJPAManager.getJPAManager();
	public static RubricaJPACriteriaManager criteriaManager = RubricaJPACriteriaManager.getJPACriteriaManager();

	public static void printMenu() {
		System.out.println("\t**Gestore rubrica**");
		System.out.println("\t**Operazioni possibili**");
		System.out.println("-1.Mostra di nuovo il menu");
		System.out.println("1.Mostra l'elenco dei contatti");
		System.out.println("2.Cerca un contatto");
		System.out.println("3.Aggiungi un nuovo contatto");
		System.out.println("4.Modifica un contatto esistente");
		System.out.println("5.Cancella un contatto");
		System.out.println("6.Trova duplicati");
		System.out.println("7.Unisci duplicati");
		System.out.println("8.Importa rubrica da CSV");
		System.out.println("9.Importa rubrica da XML");
		System.out.println("10.Esporta rubrica su CSV");
		System.out.println("11.Esporta rubrica su XML");
		System.out.println("0.ESCI\n");
	}

	public static void op1(RubricaQLManager dataManager) {
		Scanner in = new Scanner(System.in);

		String orderBy = null;
		String onWhat = null;

		System.out.print("In che ordine vuoi che ti venga mostrata la rubrica? (crescente/decrescente): ");
		orderBy = in.nextLine().toLowerCase();

		switch (orderBy) {
		default:
		case "crescente":
			orderBy = "ASC";
			break;

		case "decrescente":
			orderBy = "DESC";
			break;

		}

		System.out.print("Su che campo vuoi ordinare? (nome/cognome): ");
		onWhat = in.nextLine().toLowerCase();

		switch (onWhat) {
		default:
		case "nome":
			onWhat = "name";
			break;

		case "cognome":
			onWhat = "surname";
			break;

		}

		dataManager.showRubrica(orderBy, onWhat);
	}

	public static void op2(RubricaQLManager dataManager) {
		List<Contact> contactsFound = new ArrayList<>();

		Scanner in = new Scanner(System.in);

		System.out.print("Inserisci i dati del contatto da cercare:\n");
		System.out.print("\t-Cognome: ");
		String surname = in.nextLine().trim();

		System.out.print("\t-Nome: ");
		String name = in.nextLine().trim();

		contactsFound = dataManager.searchContact(name, surname);

		if (contactsFound.size() == 0) {
			System.out.println("Mi dispiace, non è stato trovato alcun [" + name + " " + surname + "]");
		} else {
			System.out.println(contactsFound);
		}

	}

	public static void op3(RubricaQLManager dataManager) {
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

		dataManager.addContact(contact);

		System.out.println("Contatto aggiunto!");
	}

	public static void op4(RubricaQLManager dataManager) {
		List<Contact> found = new ArrayList<>();

		Scanner in = new Scanner(System.in);

		System.out.print("Inserisci i dati del contatto da modificare:\n");
		System.out.print("\t-Cognome: ");
		String surname = in.nextLine().trim();

		System.out.print("\t-Nome: ");
		String name = in.nextLine().trim();

		Contact newC = new Contact();

		found = dataManager.searchContact(name, surname);

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

			dataManager.editContact(newC);
		}

	}

	public static void op5(RubricaQLManager dataManager) {
		List<Contact> found = new ArrayList<>();

		Scanner in = new Scanner(System.in);

		System.out.print("Inserisci i dati del contatto da eliminare:\n");
		System.out.print("\t-Cognome: ");
		String surname = in.nextLine().trim();

		System.out.print("\t-Nome: ");
		String name = in.nextLine().trim();

		Contact newC = new Contact();

		found = dataManager.searchContact(name, surname);

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

			dataManager.deleteContact(newC);
		}
	}

	public static void op6(RubricaQLManager dataManager) {
		List<Contact> duplicates = dataManager.searchDuplicate();

		if (duplicates.size() > 0) {
			for (Contact d : duplicates) {
				System.out.println(d);
			}
		} else {
			System.out.println("Non sono stati trovati duplicati.");
		}
	}

	public static void op7(RubricaQLManager dataManager) {
		List<Contact> duplicates = dataManager.searchDuplicate();

		Contact base = null;

		if (!duplicates.isEmpty()) {

			for (Contact dup : duplicates) {
				if (dup.equals(base) && dup.getId() != base.getId()) {

					dataManager.mergeDuplicate(base, dup);

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

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String choose = null;
		boolean inMenu = true;

		RubricaQLManager manager = dbManager;

		printMenu();

		while (inMenu) {

			System.out.print("Operazione: ");
			choose = in.nextLine();

			switch (Integer.parseInt(choose)) {
			case -1:
				printMenu();
				break;
			case 0:
				inMenu = false;
				break;

			case 1:
				op1(manager);
				break;

			case 2:
				op2(manager);
				break;

			case 3:
				op3(manager);
				break;

			case 4:
				op4(manager);
				break;

			case 5:
				op5(manager);
				break;

			case 6:
				op6(manager);
				break;

			case 7:
				op7(manager);
				break;

			case 8:
				System.out.print("Da dove vuoi importare la rubrica? ");
				String file = in.nextLine();
				switch (file) {
				case "CSV":
					break;
				case "XML":
					break;
				default:
					System.out.println("Non riconosco questo tipo di sorgente!");
				}
				break;

			case 9:
				System.out.println("Operation 9 not available now");
				break;

			case 10:
				System.out.println("Export to CSV not available now");
				break;

			case 11:
				System.out.println("Export to XML not available now");
				break;

			default:
				System.out.println("*Operazione non riconosciuta!*");
				break;
			}
		}

		System.out.println("\n*Ciao ciao!*");

	}

}
