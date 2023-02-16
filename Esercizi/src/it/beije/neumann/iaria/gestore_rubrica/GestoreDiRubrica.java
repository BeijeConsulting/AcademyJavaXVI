package it.beije.neumann.iaria.gestore_rubrica;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GestoreDiRubrica {
	
	public List<Contatto> vediListaContatti(String pathFile, String separator) throws FileNotFoundException, IOException{
		
		List<Contatto> contatti = new ArrayList<Contatto>();
		FileReader fileReader = new FileReader(pathFile);
		BufferedReader bufferedReader = new BufferedReader(fileReader);
		int rigaLetta = 0;
		
		try {
			
			String r = null;
			String[] fields = null;
			Contatto contatto = null;
			
			//Per ogni riga
			while (bufferedReader.ready()) {
				r = bufferedReader.readLine();
				fields = r.split(separator);
				rigaLetta++;
				
				if(rigaLetta != 1) {
					//Aggiungi i fields
					contatto = new Contatto();
					contatto.setNome(fields[0]);
					contatto.setCognome(fields[1]);
					contatto.setNote(fields[2]);
					contatto.setTelefono(fields[3]);
						
					contatti.add(contatto);
					
					//Ogni iterazione stampo i contatti
					System.out.println(contatto);
				}
			}
			
		} catch (IOException ioEx) {
			ioEx.printStackTrace();
			throw ioEx;
		} finally {
			bufferedReader.close();
		}
		
		return contatti;
	}
	
	//Metodo che chiede all'utente i dati per creare un nuovo contatto e lo inserisce nella Lista
	public List<Contatto> creaNuovoContatto() {
		System.out.println("Inserisci il contatto:");
		Scanner s = new Scanner(System.in);		
		List<Contatto> contattoDaScanner = new ArrayList<Contatto>();
		
		Contatto contattoInput = new Contatto();
		System.out.print("Nome: ");
		contattoInput.setNome(s.nextLine());
		
		System.out.print("Cognome: ");
		contattoInput.setCognome(s.nextLine());
			
		System.out.print("Note: ");
		contattoInput.setNote(s.nextLine());
				
		System.out.print("Telefono: ");
		contattoInput.setTelefono(s.nextLine());
			
		System.out.println("Contatto salvato con successo!");
		contattoDaScanner.add(contattoInput); //Inserisco valore nella lista contatti
		
		return contattoDaScanner;
		
	}
	
	//Metodo per scrivere un nuovo contatto (append)
	public void scriviContatto(List<Contatto> contatti, String pathFile, String separator) throws FileNotFoundException, IOException{
		File rubrica = new File(pathFile);
		FileWriter fileWriter = new FileWriter(pathFile, true);
		
		try {
			
			for (Contatto persona : contatti) {
				fileWriter.write(persona.getNome() + separator);
				fileWriter.write(persona.getCognome() + separator);
				fileWriter.write(persona.getNote() + separator);
				fileWriter.write(persona.getTelefono() + "\n");
			}

		} catch (IOException ioEx) {
			ioEx.printStackTrace();
			throw ioEx;
		} finally {
			fileWriter.close(); //Chiudo il file per salvare modifiche
		}
	}
	
	//Metodo per sovrascrivere il file (nel caso di modifica o rimozione di un contatto)
	public void sovrascriviContatti(List<Contatto> contatti, String pathFile, String separator) throws FileNotFoundException, IOException{
		File rubrica = new File(pathFile);
		FileWriter fileWriter = new FileWriter(pathFile);
		
		try {
			
			for (Contatto persona : contatti) {
				fileWriter.write(persona.getNome() + separator);
				fileWriter.write(persona.getCognome() + separator);
				fileWriter.write(persona.getNote() + separator);
				fileWriter.write(persona.getTelefono() + "\n");
			}

		} catch (IOException ioEx) {
			ioEx.printStackTrace();
			throw ioEx;
		} finally {
			fileWriter.close(); //Chiudo il file per salvare modifiche
		}
	}
	
	//Metodo che cerca contatto corrispondente
	public String cercaContatto(String pathFile, String separator) throws FileNotFoundException, IOException {
		String stringaContatto = "Esito: ";
		String contattoTrovato = "";
		int riga = 0;
		int count = 0;
		List<Contatto> contatti = new ArrayList<Contatto>();
		FileReader fileReader = new FileReader(pathFile);
		BufferedReader bufferedReader = new BufferedReader(fileReader);
		boolean confronto;
		
		System.out.println("Inserisci i dati da cercare, per saltarli, lasciali vuoti");
		Scanner s = new Scanner(System.in);	
		System.out.println("Nome:");
		String nomeScanner = s.nextLine();
		System.out.println("Cognome:");
		String cognomeScanner = s.nextLine();
		System.out.println("Nota:");
		String notaScanner = s.nextLine();
		System.out.println("Telefono:");
		String telefonoScanner = s.nextLine();
		
			
		try {
			
			String r = null;
			String[] fields = null;
			Contatto contatto = null;
		
			//Per ogni riga
			while (bufferedReader.ready()) {
				r = bufferedReader.readLine();
				fields = r.split(separator);
				riga++; //Conteggio le rige ogni iterazione per poi stampare la corrispondente
				
				//Confronta i fields
				if(!nomeScanner.isEmpty()) { //Se il nome inserito non è nullo
					if(nomeScanner.contains(fields[0])) { //E contiene corrispondente del csv
						count++; //Aumento il conteggio (quindi solo se trovo una corrispondenza)
					} else {
						count = 0; //Altrimenti count=0, è inutile verificare gli altri
					}
				} else {
					count++; //Aumento il conteggio anche se la stringa è vuota (la considero come corrispondenza da non cercare)
				}
				
				if(!cognomeScanner.isEmpty()) {
					if(cognomeScanner.contains(fields[1])) {
						count++;
					} else {
						count = 0;
					}
				} else {
					count++;
				}
				
				if(!notaScanner.isEmpty()) {
					if(notaScanner.contains(fields[2])) {
						count++;
					} else {
						count = 0;
					}
				} else {
					count++;
				}
				
				if(!telefonoScanner.isEmpty()) {
					if(telefonoScanner.contains(fields[3])) {
						count++;
					} else {
						count = 0;
					}
				} else {
					count++;
				}
				
				//Ad ogni iterazione vedo se c'è corrispondenza (cioè count = 4) altrimenti reset di count
				if(count==4) {
					int copiaRiga = riga-1; //Dato che la prima riga è NOME-COGNOME-NOTE-TELEFONO, decremento
					contattoTrovato = "Contatto trovato alla riga "+copiaRiga;
				} else {
					count = 0;
				}
			}
			
			/*Se alla fine del ciclo, la Stringa "contattoTrovato" è vuota, vuol dire che non c'è stata corrispondenza
			quindi stampa "Nessuna corrispondenza trovata"*/
			if(contattoTrovato.isEmpty()) {
				contattoTrovato = "Nessuna corrispondenza trovata";
			}
			
		} catch (IOException ioEx) {
			ioEx.printStackTrace();
			throw ioEx;
		} finally {
			bufferedReader.close();
		}
		return stringaContatto + contattoTrovato;
	}
	
	//Metodo che modifica un contatto
	public List<Contatto> modificaContatto(String pathFile, String separator) throws FileNotFoundException, IOException{
		List<Contatto> contatti = new ArrayList<Contatto>();
		FileReader fileReader = new FileReader(pathFile);
		BufferedReader bufferedReader = new BufferedReader(fileReader);
		
		int numeroRigaWhile = 0;
		vediListaContatti(pathFile,separator);
		System.out.println("Inserisci il numero corrispondente alla riga da modificare: ");
		Scanner s = new Scanner(System.in);
		int numeroRigaScanner = s.nextInt();
		System.out.println();
		
		try {
			
			String r = null;
			String[] fields = null;
			Contatto contatto = null;
			
			//Lista con solo il nuovo contatto da inserire
			List<Contatto> contattiCSV = creaNuovoContatto();
			System.out.println();
			
			//Per ogni riga leggi e inserisci i dati nella lista
			while (bufferedReader.ready()) {
				r = bufferedReader.readLine();
				fields = r.split(separator);
				contatto = new Contatto();
				
				if(numeroRigaWhile == numeroRigaScanner) {
					for (Contatto persona : contattiCSV) {
						contatto.setNome(persona.getNome());
						contatto.setCognome(persona.getCognome());
						contatto.setNote(persona.getNote());
						contatto.setTelefono(persona.getTelefono());
					}
				} else {
					//Aggiungi i fields
					contatto.setNome(fields[0]);
					contatto.setCognome(fields[1]);
					contatto.setNote(fields[2]);
					contatto.setTelefono(fields[3]);
				}
	            contatti.add(contatto);
	            numeroRigaWhile++;
			} 
			//Fine lettura
			//Una volta aggiornati i dati li riscriviamo sul file
			sovrascriviContatti(contatti,pathFile,separator);
			System.out.println("Contatti dopo l'aggiornamento: ");
			vediListaContatti(pathFile,separator);
			System.out.println();
			
		} catch (IOException ioEx) {
			ioEx.printStackTrace();
			throw ioEx;
		} finally {
			bufferedReader.close();
		}
		
		return contatti;
	}

	
	//Metodo che elimina un contatto
	public List<Contatto> eliminaContatto(String pathFile, String separator) throws FileNotFoundException, IOException{
		List<Contatto> contatti = new ArrayList<Contatto>();
		FileReader fileReader = new FileReader(pathFile);
		BufferedReader bufferedReader = new BufferedReader(fileReader);
		
		int numeroRigaWhile = 0;
		vediListaContatti(pathFile,separator);
		System.out.println("Inserisci il numero corrispondente alla riga da eliminare: ");
		Scanner s = new Scanner(System.in);
		int numeroRigaScanner = s.nextInt();
		System.out.println();
		
		try {
			
			String r = null;
			String[] fields = null;
			Contatto contatto = null;
			
			//Per ogni riga leggi e inserisci i dati nella lista
			while (bufferedReader.ready()) {
				r = bufferedReader.readLine();
				fields = r.split(separator);
				contatto = new Contatto();
				
				if(numeroRigaWhile == numeroRigaScanner) {
					numeroRigaWhile++; //Se ci troviamo nella riga da eliminare, saltiamo all'iterazione successiva
				} else {
					//Aggiungi i fields
					contatto.setNome(fields[0]);
					contatto.setCognome(fields[1]);
					contatto.setNote(fields[2]);
					contatto.setTelefono(fields[3]);
					contatti.add(contatto);
					numeroRigaWhile++;
				}
			} 
			//Fine lettura
			//Una volta aggiornati i dati li riscriviamo sul file
			sovrascriviContatti(contatti,pathFile,separator);
			System.out.println();
			System.out.println("Contatti dopo l'aggiornamento: ");
			vediListaContatti(pathFile,separator);
			System.out.println();
			
		} catch (IOException ioEx) {
			ioEx.printStackTrace();
			throw ioEx;
		} finally {
			bufferedReader.close();
		}
		
		return contatti;
	}
	
	public static void main(String[] args) throws FileNotFoundException, IOException{
		String path = "/Users/gianf/Desktop/contatti.csv";
		String separator = "-";
		int scelta = 0;
		GestoreDiRubrica gestoreRubrica = new GestoreDiRubrica();
		
		System.out.println("Azioni che è possibile svolgere:");
		System.out.println("- Inserisci 1 per vedere la lista contatti \n- Inserisci 2 per cercare il contatto \n- Inserisci 3 per inserire un nuovo contatto \n- Inserisci 4 per modificare un contatto \n- Inserisci 5 per cancellare un contatto \n- Inserisci 6 per uscire");
		System.out.println("Inserisci il numero corrispondente per avviare l'azione desiderata:");
		Scanner s = new Scanner(System.in);
		scelta = s.nextInt(); //Prendo il valore inserito dall'utente
		System.out.println();
		
		if(scelta <= 0 || scelta > 6) {
			System.out.println("Scelta non presente");
			gestoreRubrica.main(args); //Se non è presente rilancia il programma
		} else {
			switch(scelta) {
				case 1:
					gestoreRubrica.vediListaContatti(path,separator); //Se 1 chiama metodo che fa visualizzare i contatti
					System.out.println();
					gestoreRubrica.main(args); //Richiama il programma così si può continuare ad usare, dato che l'utente non ha ancora fatto l'exit
					break;
				case 2:
					String risultato = gestoreRubrica.cercaContatto(path,separator);
					System.out.println(risultato);
					System.out.println();
					gestoreRubrica.main(args);
					break;
				case 3:
					List<Contatto> contattiCSV = gestoreRubrica.creaNuovoContatto();
					gestoreRubrica.scriviContatto(contattiCSV,path,separator);
					System.out.println();
					gestoreRubrica.vediListaContatti(path,separator);
					System.out.println();
					gestoreRubrica.main(args);
					break;
				case 4:
					gestoreRubrica.modificaContatto(path,separator);
					gestoreRubrica.main(args); //Richiama il programma così si può continuare ad usare, dato che l'utente non ha ancora fatto l'exit
					break;
				case 5:
					gestoreRubrica.eliminaContatto(path,separator);
					gestoreRubrica.main(args);
					break;
				case 6:
					System.out.println("Programma terminato");
					break; //Ferma il programma per l'exit
					
			}
		}
		
	
	
	}

}
