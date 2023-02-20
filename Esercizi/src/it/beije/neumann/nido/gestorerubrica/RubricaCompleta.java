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

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import org.xml.sax.SAXException;

/* TODO
 * - Import/Export manager come singleton? static class?
 * - Valutare gestione connessione al dbManager
 * - Richiamare su menu funzioni import/export
 */


public class RubricaCompleta {

	public static final String CSV = "./src/it/beije/neumann/nido/gestorerubrica/addressBook.csv";
	public static final String XML = "./src/it/beije/neumann/nido/gestorerubrica/addressBook.xml";

	public static RubricaImportManager importManager = new RubricaImportManager(); 
	public static RubricaExportManager exportManager = new RubricaExportManager();
	public static RubricaDBManager dbManager = RubricaDBManager.getDBManager();
//	public static RubricaHBManager hbManager = RubricaHBManager.getHBManager();

	public static void printMenu() {
		System.out.println("\t**Gestore rubrica**");
		System.out.println("\t**Operazioni possibili**");
		System.out.println("-1.Mostra di nuovo il menu"); // OK
		System.out.println("1.Mostra l'elenco dei contatti"); // OK
		System.out.println("2.Cerca un contatto"); // OK
		System.out.println("3.Aggiungi un nuovo contatto"); // OK
		System.out.println("4.Modifica un contatto esistente"); // OK
		System.out.println("5.Cancella un contatto");
		System.out.println("6.Trova duplicati");
		System.out.println("7.Unisci duplicati");
		System.out.println("8.Importa rubrica da CSV"); 
		System.out.println("9.Importa rubrica da XML");
		System.out.println("10.Esporta rubrica su CSV");
		System.out.println("11.Esporta rubrica su XML");
		System.out.println("0.ESCI\n"); // OK
	}

	public static void op1() {
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

		dbManager.showRubrica(orderBy, onWhat); // meglio static?
//		hbManager.showRubrica(orderBy, onWhat);
	}

	public static void op2() {
		List<Contact> contactsFound = new ArrayList<>();

		Scanner in = new Scanner(System.in);

		System.out.print("Inserisci i dati del contatto da cercare:\n");
		System.out.print("\t-Cognome: ");
		String surname = in.nextLine().trim();

		System.out.print("\t-Nome: ");
		String name = in.nextLine().trim();

		contactsFound = dbManager.searchContact(name, surname);
//		contactsFound = hbManager.searchContact(name, surname);

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

		System.out.print("\t-Eta': ");
		contact.setAge(Integer.parseInt(in.nextLine()));

		System.out.print("\t-Telefono: ");
		contact.setTelephone(in.nextLine());

		System.out.print("\t-E-Mail: ");
		contact.setEmail(in.nextLine());

		System.out.print("\t-Note sul contatto: ");
		contact.setNote(in.nextLine());

		System.out.println();

		dbManager.addContact(contact);
//		hbManager.addContact(contact);

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

		found = dbManager.searchContact(name, surname);
//		found = hbManager.searchContact(name, surname);

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

			System.out.print("\t-Eta': ");
			newC.setAge(Integer.parseInt(in.nextLine()));

			System.out.print("\t-Telefono: ");
			newC.setTelephone(in.nextLine());

			System.out.print("\t-E-Mail: ");
			newC.setEmail(in.nextLine());

			System.out.print("\t-Note sul contatto: ");
			newC.setNote(in.nextLine());

			dbManager.editContact(newC);
//			hbManager.editContact(newC);
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

		found = dbManager.searchContact(name, surname);
//		found = hbManager.searchContact(name, surname);

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

			dbManager.deleteContact(newC);
		}
	}

	public static void op6() {
		System.out.println("*Operazione 6*\n");
	}

	public static void op7() {
		System.out.println("*Operazione 7*\n");
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
//		hbManager.openSession();

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
//				hbManager.closeSession();
				break;

			case 1:
				op1();
				break;

			case 2:
				op2();
				break;

			case 3:
				op3();
				break;

			case 4:
				op4();
				break;

			case 5:
				op5();
				break;

			case 6:
				op6();
				break;

			case 7:
				op7();
				break;

			case 8:
				break;

			case 9:
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
