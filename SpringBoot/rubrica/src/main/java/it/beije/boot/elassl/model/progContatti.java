package it.beije.boot.elassl.model;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import org.xml.sax.SAXException;


public class progContatti {

	public static void main(String[] args) throws ClassNotFoundException {
		// TODO rubrica manager da tastiera
		//ContactManager db = new DBmanager();// JDBC implementation
		//ContactManager db = new DBhybernate();// HBM implementation
		//ContactManager db = new DBjpa();// JPA implementation
		//ContactManager db = new DBjpacriteria();// JPA with criteria queries implementation
		ContactManager db = new XMLmanager();// JPA with criteria queries implementation
		
		int menu=-1;
		Scanner s = new Scanner(System.in);
		String input = "";
		System.out.println("\nWelcome to my CLI Contact Manager!\n");
		while(!input.equalsIgnoreCase("exit")) {
			String pathFile;
			List<Contatto> contacts;
			System.out.println(" Esc > Exit");
			System.out.println(" 0 > Search Contact");
			System.out.println(" 1 > Visualize Contacts");
			System.out.println(" 2 > Insert Contact");
			System.out.println(" 3 > Edit Contact");
			System.out.println(" 4 > Delete Contact");
			System.out.println(" 5 > Find Duplicate Contacts");
			System.out.println(" 6 > Merge Duplicate Contacts");
			System.out.println(" 7 > Export to CSV");
			System.out.println(" 8 > Import from CSV");
			System.out.println(" 9 > Export to XML");
			System.out.println(" 10 > Import from XML");
			input = s.nextLine();
			if(input.equalsIgnoreCase("exit")) break;
			
			switch(input) {
			case "0":
				System.out.println("\n\nInsert name:\n");
				String name=s.nextLine();
				System.out.println("\n\nInsert surname:\n");
				String surname=s.nextLine();
				Contatto contact = new Contatto(name, surname, null, null, null);
				contacts = db.getContatto(contact);
				System.out.println("\nContacts found:\n");
				for(Contatto c: contacts)
					System.out.println(c);
				System.out.println("\nPress any key to continue...\n");
				s.nextLine();
				
				break;
			case "1":
				contacts = db.getContatti();
				System.out.println("\n\nContact List:\n");
				for(Contatto c: contacts)
					System.out.println(c);
				System.out.println("\nPress any key to continue...\n");
				s.nextLine();
				break;
			case "2":
				System.out.println("\n\nInsert name:\n");
				String name1=s.nextLine();
				System.out.println("\n\nInsert surname:\n");
				String surname1=s.nextLine();
				System.out.println("\n\nInsert email:\n");
				String email=s.nextLine();
				System.out.println("\n\nInsert telephone:\n");
				String telephone=s.nextLine();
				System.out.println("\n\nInsert notes:\n");
				String notes=s.nextLine();
				
				Contatto contact1 = new Contatto(name1, surname1, telephone, email, notes);
				db.writeContatto(contact1);
				break;
			case "3":
				contacts = db.getContatti();
				System.out.println("\n\nContact List:\n");
				for(Contatto c: contacts)
					System.out.println(c);
				System.out.println("\n\nInsert id of the contact you want to edit:\n");
				int editId=Integer.parseInt(s.nextLine());
				System.out.println("\n\nInsert name:\n");
				String editName=s.nextLine();
				System.out.println("\n\nInsert surname:\n");
				String editSurname=s.nextLine();
				System.out.println("\n\nInsert email:\n");
				String editEmail=s.nextLine();
				System.out.println("\n\nInsert telephone:\n");
				String editTelephone=s.nextLine();
				System.out.println("\n\nInsert notes:\n");
				String editNotes=s.nextLine();
				
				Contatto editContact = new Contatto(editId, editName, editSurname, editTelephone, editEmail, editNotes);
				db.updateContatto(editContact);
				break;
			case "4":
				contacts = db.getContatti();
				Contatto toRemove = null;
				System.out.println("\n\nContact List:\n");
				for(Contatto c: contacts)
					System.out.println(c);
				System.out.println("\n\nInsert the id of the contact you want to remove:\n");
				int id=Integer.parseInt(s.nextLine()); 
				for(Contatto c: contacts)
					if(c.getId()==id) toRemove = c;
				if(toRemove==null) {
					System.out.println("\n\nError, Id not Found\n");
				}
				else {
					db.deleteContatto(toRemove);
					System.out.println("\n\nContact deleted Succesfully!\n");
				}
				System.out.println("\nPress any key to continue...\n");
				s.nextLine();
				break;
			case "5":
				contacts = db.getDuplicates();
				System.out.println("\n\nContact List:\n");
				for(Contatto c: contacts)
					System.out.println(c);
				System.out.println("\nPress any key to continue...\n");
				s.nextLine();
				
				break;
			case "6":
				db.mergeDuplicates();
				System.out.println("\nDuplicate contacts merged succesfully!\n");
				System.out.println("\nPress any key to continue...\n");
				break;
			case "7":
				System.out.println("\n\nInsert the desired filepath:\n");
				pathFile=s.nextLine(); 
				try {
					CSVmanager.writeRubricaCSV(db.getContatti(), pathFile, ";");
					System.out.println("\nExported to CSV succesfully!\n");
					System.out.println("\nPress any key to continue...\n");
					s.nextLine();
				} catch (IOException e) {
					System.out.println("\nError, invalid filepath!\n");
					try {System.out.println("\nCurrent relative path:\n"+new File(".").getCanonicalPath());
					} catch (IOException e1) {}
					e.printStackTrace();
				}
				break;
			case "8":
				System.out.println("\n\nInsert the filepath:\n");
				pathFile=s.nextLine(); 
				try {
					contacts = CSVmanager.loadRubricaFromCSV(pathFile, ";");
					for (Contatto c: contacts) 
						db.writeContatto(c);
					System.out.println("\nImported from CSV succesfully!\n");
					System.out.println("\nPress any key to continue...\n");
					s.nextLine();
				} catch (IOException e) {
					System.out.println("\nError, invalid filepath!\n");
					try {System.out.println("\nCurrent relative path:\n"+new File(".").getCanonicalPath());
					} catch (IOException e1) {}
					e.printStackTrace();
				}
				break;
			case "9":
				System.out.println("\n\nInsert the desired filepath:\n");
				pathFile=s.nextLine(); 
				try {
					XMLmanager.writeRubricaXML(db.getContatti(), pathFile);
					System.out.println("\nExported to XML succesfully!\n");
					System.out.println("\nPress any key to continue...\n");
					s.nextLine();
				} catch (IOException e) {
					System.out.println("\nError, invalid filepath!\n");
					try {System.out.println("\nCurrent relative path:\n"+new File(".").getCanonicalPath());
					} catch (IOException e1) {}
					e.printStackTrace();
				} catch (ParserConfigurationException e) {
					e.printStackTrace();
				} catch (SAXException e) {
					e.printStackTrace();
				} catch (TransformerException e) {
					e.printStackTrace();
				}
				break;
			case "10":
				System.out.println("\n\nInsert the filepath:\n");
				pathFile=s.nextLine(); 
				try {
					contacts = XMLmanager.loadRubricaFromXML(pathFile);
					for (Contatto c: contacts) 
						db.writeContatto(c);
					System.out.println("\nImported from XML succesfully!\n");
					System.out.println("\nPress any key to continue...\n");
					s.nextLine();
				} catch (IOException e) {
					System.out.println("\nError, invalid filepath!\n");
					try {System.out.println("\nCurrent relative path:\n"+new File(".").getCanonicalPath());
					} catch (IOException e1) {}
					e.printStackTrace();
				} catch (ParserConfigurationException e) {
					e.printStackTrace();
				} catch (SAXException e) {
					e.printStackTrace();
				}
				break;
			default:
				System.out.println("\nError, choose a valid option:");
			
			}
		}
		
		s.close();
	}

}
