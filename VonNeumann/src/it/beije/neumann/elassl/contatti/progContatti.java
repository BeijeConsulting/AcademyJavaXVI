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

			System.out.println(" Esc > Exit");
			System.out.println(" 1 > Visualize Contacts");
			System.out.println(" 2 > Insert Contact");
			System.out.println(" 3 > Edit Contact");
			System.out.println(" 4 > Delete Contact");
			System.out.println(" 5 > Find Duplicate Contacts");
			System.out.println(" 6 > Remove Duplicate Contacts");
			input = s.next();
			if(input.equalsIgnoreCase("exit")) break;
			
			switch(input) {
			case "1":
				List<Contatto> contacts = DBmanager.getContatti();
				System.out.println("\n\nContact List:\n");
				for(Contatto contact: contacts)
					System.out.println(contact);
				System.out.println("\nPress any key to continue...\n");
				s.next();
				break;
			case "2":
				System.out.println("\n\nInsert name:\n");
				String name=s.next();
				System.out.println("\n\nInsert surname:\n");
				String surname=s.next();
				System.out.println("\n\nInsert email:\n");
				String email=s.next();
				System.out.println("\n\nInsert telephone:\n");
				String telephone=s.next();
				System.out.println("\n\nInsert notes:\n");
				String notes=s.next();
				
				Contatto contact = new Contatto(name, surname, telephone, email, notes);
				DBmanager.writeContatto(contact);
				break;
			case "3":
				break;
			case "4":
				break;
			case "5":
				break;
			default:
				System.out.println("\nError, choose a valid option:");
			
			}
		}
		
		s.close();
	}

}
