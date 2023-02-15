package it.beije.neumann.vanoli.rubrica;

import java.util.List;
import java.util.Scanner;

public class LineaDiComando {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Digita 1 per cercare un contatto.");
		System.out.println("Digita 2 per inserire un nuovo contatto.");
		System.out.println("Digita 3 per modificare un contatto.");
		System.out.println("Digita 4 per cancellare un contatto.");
		System.out.println("Digita 5 per trovare contatti duplicati.");
		System.out.println("Digita 6 per unire contatti duplicati.");
		
		String input = sc.nextLine().trim();
		
		if (input.equals("1")) {
			System.out.println("Nome del contatto da cercare: ");
			String nome = sc.nextLine().trim();
			System.out.println("Cognome del contatto da cercare: ");
			String cognome = sc.nextLine().trim();
			List<Contatto> c = RubricaJDBC.CercaContatto(nome, cognome);
			System.out.println("Sono stati trovati " + c.size() + " contatti:");
			System.out.println(c);			
		}
		else if (input.equals("2")) {
			Contatto newContatto = new Contatto();
			System.out.println("Nome:");
			newContatto.setName(sc.nextLine().trim());
			System.out.println("Cognome:");
			newContatto.setSurname(sc.nextLine().trim());
			System.out.println("Telefono:");
			newContatto.setTelephone(sc.nextLine().trim());
			System.out.println("Email:");
			newContatto.setEmail(sc.nextLine().trim());
			System.out.println("Note:");
			newContatto.setNote(sc.nextLine().trim());
			RubricaJDBC.inserisciContatto(newContatto);
		}
		else if (input.equals("3")) {
			
		}
		
		sc.close();
		
	}
}
