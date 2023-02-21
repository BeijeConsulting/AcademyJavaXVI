package it.beije.neumann.vanoli.rubrica;

import java.io.IOException;
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
		
		RubricaInterface rubricaAPI = new RubricaJPA(); //istanziando una classe diversa qui si cambia facilmente da JPA a HBM o JDBC
		
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
				stampaListaContatti(rubricaAPI.elencoRubrica(input.toLowerCase()));
			}
			else {
				stampaListaContatti(rubricaAPI.LoadRubricaFromDB());
			}
		}
		else if (input.equals("1")) {
			System.out.println("Nome del contatto da cercare: ");
			String nome = sc.nextLine().trim();
			System.out.println("Cognome del contatto da cercare: ");
			String cognome = sc.nextLine().trim();
			List<Contatto> c = rubricaAPI.cercaContatto(nome, cognome);
			System.out.println("Sono stati trovati " + c.size() + " contatti:");
			stampaListaContatti(c);			
		}
		else if (input.equals("2")) {
			Contatto newContatto = new Contatto();
			System.out.println("Nome:");
			newContatto.setNome(sc.nextLine().trim());
			System.out.println("Cognome:");
			newContatto.setCognome(sc.nextLine().trim());
			System.out.println("Telefono:");
			newContatto.setTelefono(sc.nextLine().trim());
			System.out.println("Email:");
			newContatto.setEmail(sc.nextLine().trim());
			System.out.println("Note:");
			newContatto.setNote(sc.nextLine().trim());
			rubricaAPI.inserisciContatto(newContatto);
		}
		else if (input.equals("3")) {
			System.out.println("Nome del contatto da modificare: ");
			String nome = sc.nextLine().trim();
			System.out.println("Cognome del contatto da modificare: ");
			String cognome = sc.nextLine().trim();
			List<Contatto> risultati = rubricaAPI.cercaContatto(nome, cognome);
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
					toEdit.setNome(sc.nextLine().trim());
				}
				System.out.println("Vuoi modificare il cognome? Y/N");
				input = sc.nextLine().trim();
				if (input.equalsIgnoreCase("Y")) {
					System.out.println("Digita il nuovo cognome");
					toEdit.setCognome(sc.nextLine().trim());
				}
				System.out.println("Vuoi modificare il telefono? Y/N");
				input = sc.nextLine().trim();
				if (input.equalsIgnoreCase("Y")) {
					System.out.println("Digita il nuovo telefono");
					toEdit.setTelefono(sc.nextLine().trim());
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
					System.out.println("Digita le nuove note");
					toEdit.setNote(sc.nextLine().trim());
				}
				rubricaAPI.editContatto(toEdit);
			}
		}
		else if (input.equals("4")) {
			System.out.println("Nome del contatto da eliminare: ");
			String nome = sc.nextLine().trim();
			System.out.println("Cognome del contatto da eliminare: ");
			String cognome = sc.nextLine().trim();
			List<Contatto> risultati = rubricaAPI.cercaContatto(nome, cognome);
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
				rubricaAPI.deleteContatto(toDelete);
			}
		}
		else if (input.equals("5")) {			
			List<Contatto> risultati = rubricaAPI.trovaContattiDuplicati();
			if (risultati.size() == 0) {
				System.out.println("Non sono stati trovati contatti duplicati");
			}
			else {
				System.out.println("Sono stati trovati i seguenti contatti duplicati:");
				stampaListaContatti(risultati);
			}
		}
		/*
		else if (input.equals("6")) {			
			List<Contatto> risultati = rubricaAPI.unisciContattiDuplicati();
			if (risultati.size() == 0) {
				System.out.println("Non è stato possibile unire nessun contatto");
			}
			else {
				System.out.println("Sono stati uniti i seguenti contatti:");
				stampaListaContatti(risultati);
			}
		}
		*/
		sc.close();
		
	}
}


