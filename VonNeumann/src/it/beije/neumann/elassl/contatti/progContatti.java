package it.beije.neumann.elassl.contatti;

import java.util.List;
import java.util.Scanner;

public class progContatti {

	public static void main(String[] args) throws ClassNotFoundException {
		// TODO rubrica manager da tastiera
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
			System.out.println(" 6 > Remove Duplicate Contacts");
			input = s.nextLine();
			if(input.equalsIgnoreCase("exit")) break;
			
			switch(input) {
			case "1":
				contacts = DBmanager.getContatti();
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
				DBmanager.writeContatto(contact);
				break;
			case "3":
				break;
			case "4":
				contacts = DBmanager.getContatti();
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
					DBmanager.deleteContatto(toRemove);
					System.out.println("\n\nContact deleted Succesfully!\n");
				}
				System.out.println("\nPress any key to continue...\n");
				break;
			case "5":
				contacts = DBmanager.getDuplicates();
				System.out.println("\n\nContact List:\n");
				for(Contatto c: contacts)
					System.out.println(c);
				System.out.println("\nPress any key to continue...\n");
				s.nextLine();
				
				break;
			case "6":
				DBmanager.mergeDuplicates();
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
