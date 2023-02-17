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

public class RubricaCompleta {

	public static final String CSV = "./src/assignments/rubrica/addressBook.csv";
	public static final String XML = "./src/assignments/rubrica/addressBook.xml";

	public static RubricaImportManager importManager = new RubricaImportManager(); // static class? singleton anche?
	public static RubricaExportManager exportManager = new RubricaExportManager(); // static class? singleton anche?
	public static RubricaDBManager dbManager = RubricaDBManager.getDBManager(); // stile singleton

	public static void firstMenu() {
		System.out.println("\t**Gestore rubrica**");
		System.out.println("*Per iniziare, verrà caricata la rubrica.*");
		System.out.println("-------------------------------------------------------------\n");
	}

	public static void printMenu() {
		System.out.println("\t**Operazioni possibili**");
		System.out.println("-1.Mostra di nuovo il menu"); // OK
		System.out.println("1.Mostra l'elenco dei contatti"); // OK
		System.out.println("2.Cerca un contatto"); // da sistemare su DB
		System.out.println("3.Aggiungi un nuovo contatto"); // da sistemare su DB
		System.out.println("4.Modifica un contatto esistente");
		System.out.println("5.Cancella un contatto");
		System.out.println("6.Trova duplicati");
		System.out.println("7.Unisci duplicati");
		System.out.println("8.Importa rubrica da CSV"); // funzione OK, da chiamare su menu
		System.out.println("9.Importa rubrica da XML"); // funzione OK, da chiamare su menu
		System.out.println("10.Esporta rubrica su CSV"); // funzione OK, da chiamare su menu
		System.out.println("11.Esporta rubrica su XML"); // funzione OK, da chiamare su menu
		System.out.println("0.ESCI\n"); // OK
	}

	public static void subMenuOp1() {
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

		case "decrescente":
			onWhat = "surname";
			break;

		}

		System.out.println("Ordine " + orderBy + " per " + onWhat);
		dbManager.showRubrica(orderBy, onWhat); // meglio static?
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

	public static List<Contact> searchContact(List<Contact> rubrica) {
		List<Contact> contactsFound = new ArrayList<>();

		Scanner in = new Scanner(System.in);

		System.out.print("Inserisci i dati del contatto da cercare:\n");
		System.out.print("\t-Cognome: ");
		String surname = in.nextLine().trim();

		System.out.print("\t-Nome: ");
		String name = in.nextLine().trim();

		for (Contact c : rubrica) {
			if (!surname.isEmpty() && !name.isEmpty()) {
				if (c.getName().equalsIgnoreCase(name) && c.getSurname().equalsIgnoreCase(surname)) {
					contactsFound.add(c);
				}
			} else if (!surname.isEmpty()) {
				if (c.getSurname().equalsIgnoreCase(surname)) {
					contactsFound.add(c);
				}
			} else if (!name.isEmpty()) {
				if (c.getName().equalsIgnoreCase(name)) {
					contactsFound.add(c);
				}
			}
		}

		if (contactsFound.size() == 0) {
			System.out.println("Mi dispiace, non è stato trovato alcun [" + name + " " + surname + "]");
		}

		return contactsFound;
	}

	public static List<Contact> addContact() {
		Scanner in = new Scanner(System.in);
		List<Contact> contacts = new ArrayList<>();
		String continueAdd = null;
		boolean add = true;

		while (add) {

			System.out.print("Vuoi inserire un contatto? (s/n) -> ");
			continueAdd = in.nextLine();

			if (continueAdd.equals("s")) {
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

				contacts.add(contact);

				System.out.println(contact);

				System.out.println("**Inserimento riuscito!**");
			} else {
				add = false;
				System.out.println("**I contatti sono pronti per il salvataggio in rubrica!**");
			}
		}

		return contacts;
	}

	public static void op4() {
		System.out.println("*Operazione 4*\n");
	}

	public static void op5() {
		System.out.println("*Operazione 5*\n");
	}

	public static void op6() {
		System.out.println("*Operazione 6*\n");
	}

	public static void op7() {
		System.out.println("*Operazione 7*\n");
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String choose = null;
		boolean inMenu = true;

		firstMenu();
		List<Contact> toAdd = null;

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
				subMenuOp1();
				break;

			case 2:
				break;

			case 3:
				toAdd = addContact();
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
