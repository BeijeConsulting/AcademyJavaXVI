package it.beije.neumann.elassl.contatti;

import java.util.List;
import java.util.Scanner;

import it.beije.neumann.rubrica.Contatto;

public class progContatti {

	public static void main(String[] args) throws ClassNotFoundException {
		// TODO rubrica manager da tastiera
		//ContactManager db = new DBmanager();// JDBC
		//ContactManager db = new DBhybernate();//HBM
		EMfactory.openEntityManager();
		ContactManager db = new DBjpa();
		
		int menu=-1;
		Scanner s = new Scanner(System.in);
		String input = "";
		System.out.println("\nWelcome to my CLI Contact Manager!\n");
		while(!input.equalsIgnoreCase("exit")) {
			List<Contatto> contacts;
			System.out.println(" Esc > Exit");
			System.out.println(" 1 > Visualize Contacts");
			System.out.println(" 2 > Insert Contact");
			System.out.println(" 3 > Edit Contact");
			System.out.println(" 4 > Delete Contact");
			System.out.println(" 5 > Find Duplicate Contacts");
			System.out.println(" 6 > Merge Duplicate Contacts");
			input = s.nextLine();
			if(input.equalsIgnoreCase("exit")) break;
			
			switch(input) {
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
				String name=s.nextLine();
				System.out.println("\n\nInsert surname:\n");
				String surname=s.nextLine();
				System.out.println("\n\nInsert email:\n");
				String email=s.nextLine();
				System.out.println("\n\nInsert telephone:\n");
				String telephone=s.nextLine();
				System.out.println("\n\nInsert notes:\n");
				String notes=s.nextLine();
				
				Contatto contact = new Contatto(name, surname, telephone, email, notes);
				db.writeContatto(contact);
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
			default:
				System.out.println("\nError, choose a valid option:");
			
			}
		}
		
		s.close();
	}

}
