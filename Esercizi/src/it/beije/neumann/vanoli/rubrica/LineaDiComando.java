package it.beije.neumann.vanoli.rubrica;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class LineaDiComando {
	
	public static void stampaListaContatti(List<Contatto> listaContatti) {
		for (int i = 1; i <= listaContatti.size(); i++) {
			System.out.println("Contatto " + i + ":");
			System.out.println(listaContatti.get(i-1));
		}
	}
	
	public static void main(String[] args) throws ClassNotFoundException, IOException {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Digita 0 per visualizzare tutti i contatti.");
		System.out.println("Digita 1 per cercare un contatto.");
		System.out.println("Digita 2 per inserire un nuovo contatto.");
		System.out.println("Digita 3 per modificare un contatto.");
		System.out.println("Digita 4 per cancellare un contatto.");
		System.out.println("Digita 5 per trovare contatti duplicati.");
		System.out.println("Digita 6 per unire contatti duplicati.");
		
		String input = sc.nextLine().trim();
		
		if (input.equals("0")) {
			System.out.println("Come vuoi ordinare i contatti? Nome/Cognome/No");
			input = sc.nextLine().trim();
			if (input.equalsIgnoreCase("Nome") || input.equalsIgnoreCase("Cognome")) {
				stampaListaContatti(RubricaJDBC.elencoRubrica(input.toLowerCase()));
			}
			else {
				stampaListaContatti(RubricaJDBC.LoadRubricaFromDB());
			}
		}
		else if (input.equals("1")) {
			System.out.println("Nome del contatto da cercare: ");
			String nome = sc.nextLine().trim();
			System.out.println("Cognome del contatto da cercare: ");
			String cognome = sc.nextLine().trim();
			List<Contatto> c = RubricaJDBC.cercaContatto(nome, cognome);
			System.out.println("Sono stati trovati " + c.size() + " contatti:");
			stampaListaContatti(c);			
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
			System.out.println("Nome del contatto da modificare: ");
			String nome = sc.nextLine().trim();
			System.out.println("Cognome del contatto da modificare: ");
			String cognome = sc.nextLine().trim();
			List<Contatto> risultati = RubricaJDBC.cercaContatto(nome, cognome);
			if (risultati.size() == 0) {
				System.out.println("Non sono stati trovati contatti");
			}
			else {
				Contatto toEdit = new Contatto();
				if (risultati.size() == 1) {
					toEdit = risultati.get(0);
				}
				else {
					System.out.println("Sono stati trovati piu' contatti:");
					stampaListaContatti(risultati);
					System.out.println("Quale contatto vuoi modificare? (Digita 1 per il primo, 2 per il secondo etc.)");
					int sceltaInd = Integer.parseInt(sc.nextLine().trim());
					if (sceltaInd > risultati.size()) {
						System.out.println("Indice non valido");
					    System.exit(0);
					}
					toEdit = risultati.get(sceltaInd - 1);
				}
				System.out.println("Vuoi modificare il nome? Y/N");
				input = sc.nextLine().trim();
				if (input.equalsIgnoreCase("Y")) {
					System.out.println("Digita il nuovo nome");
					toEdit.setName(sc.nextLine().trim());
				}
				System.out.println("Vuoi modificare il cognome? Y/N");
				input = sc.nextLine().trim();
				if (input.equalsIgnoreCase("Y")) {
					System.out.println("Digita il nuovo cognome");
					toEdit.setSurname(sc.nextLine().trim());
				}
				System.out.println("Vuoi modificare il telefono? Y/N");
				input = sc.nextLine().trim();
				if (input.equalsIgnoreCase("Y")) {
					System.out.println("Digita il nuovo telefono");
					toEdit.setTelephone(sc.nextLine().trim());
				}
				System.out.println("Vuoi modificare la mail? Y/N");
				input = sc.nextLine().trim();
				if (input.equalsIgnoreCase("Y")) {
					System.out.println("Digita la nuova mail");
					toEdit.setEmail(sc.nextLine().trim());
				}
				System.out.println("Vuoi modificare le note? Y/N");
				input = sc.nextLine().trim();
				if (input.equalsIgnoreCase("Y")) {
					System.out.println("Digita le nouve note");
					toEdit.setNote(sc.nextLine().trim());
				}
				RubricaJDBC.editContatto(toEdit);
			}
		}
		else if (input.equals("4")) {
			System.out.println("Nome del contatto da eliminare: ");
			String nome = sc.nextLine().trim();
			System.out.println("Cognome del contatto da eliminare: ");
			String cognome = sc.nextLine().trim();
			List<Contatto> risultati = RubricaJDBC.cercaContatto(nome, cognome);
			if (risultati.size() == 0) {
				System.out.println("Non sono stati trovati contatti");
			}
			else {
				Contatto toDelete = new Contatto();
				if (risultati.size() == 1) {
					toDelete = risultati.get(0);
				}
				else {
					System.out.println("Sono stati trovati piu' contatti:");
					stampaListaContatti(risultati);
					System.out.println("Quale contatto vuoi modificare? (Digita 1 per il primo, 2 per il secondo etc.)");
					int sceltaInd = Integer.parseInt(sc.nextLine().trim());
					if (sceltaInd > risultati.size()) {
						System.out.println("Indice non valido");
					    System.exit(0);
					}
					toDelete = risultati.get(sceltaInd - 1);
				}
				RubricaJDBC.deleteContatto(toDelete);
			}
		}
		
		sc.close();
		
	}
}


