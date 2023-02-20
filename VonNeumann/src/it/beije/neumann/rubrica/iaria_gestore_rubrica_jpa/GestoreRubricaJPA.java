package it.beije.neumann.rubrica.iaria_gestore_rubrica_jpa;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class GestoreRubricaJPA {
	
	//Metodo che legge db
	public void vediListaContatti(){

		EntityManagerFactory entityManagerFactory = JPAEntityManager.openEntityManager();
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
				
		Contatti contatto = new Contatti();

		//SELECT
		Query query = entityManager.createQuery("SELECT c FROM Contatti as c");
		List<Contatti> contatti = query.getResultList();
		for (Contatti c : contatti) {
			System.out.println(c);
		}

		transaction.commit();
		//transaction.rollback();

		entityManager.close();
		
		//Torna true se aperta
		System.out.println(entityManager.isOpen()); //--> false

	}
	
	//Metodo che cerca contatto corrispondente
	public void cercaContatto() {
		
		String stringaContatto = "Esito: ";
		int riga = 0;
		int count = 0;
		
		System.out.println("Inserisci i dati da cercare:");
		Scanner s = new Scanner(System.in);	
		System.out.println("Nome:");
		String nomeScanner = s.nextLine();
		System.out.println("Cognome:");
		String cognomeScanner = s.nextLine();
		System.out.println();
		
		EntityManagerFactory entityManagerFactory = JPAEntityManager.openEntityManager();
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		
		Contatti contatto = new Contatti();
		
		//SELECT
		Query query = entityManager.createQuery("SELECT c FROM Contatti as c");
		List<Contatti> contatti = query.getResultList();
		for (Contatti c : contatti) {
			riga++; //Conteggio le rige ogni iterazione per poi stampare la corrispondente

			//Confronta i fields
			if(!nomeScanner.isEmpty() && !cognomeScanner.isEmpty()) { //Se il nome ed il cognome non sono nulli
				if(nomeScanner.contains(c.getNome()) && cognomeScanner.contains(c.getCognome())) { //E contiene corrispondente del db
					count++;
					System.out.println("Contatto trovato alla riga "+riga+":\n"
							+ "id : " + c.getId() + "\n"
							+ "cognome : " + c.getCognome() +"\n"
							+ "nome : " + c.getNome() +"\n"
							+ "email : " + c.getEmail() +"\n"
							+ "telefono : " + c.getTelefono() +"\n"
							+ "note : " + c.getNote() +"\n"
							+ "------------------");
				}
				
 			} else if(nomeScanner.isEmpty() || cognomeScanner.isEmpty()){
				if(nomeScanner.contains(c.getNome()) || cognomeScanner.contains(c.getCognome())) { //E contiene corrispondente del db
					count++;
					System.out.println("Contatto trovato alla riga "+riga+":\n"
							+ "id : " + c.getId() + "\n"
							+ "cognome : " + c.getCognome() +"\n"
							+ "nome : " + c.getNome() +"\n"
							+ "email : " + c.getEmail() +"\n"
							+ "telefono : " + c.getTelefono() +"\n"
							+ "note : " + c.getNote() +"\n"
							+ "------------------");
				}
				
			} else if(nomeScanner.isEmpty() && cognomeScanner.isEmpty()) {
				System.out.println("Non puoi lasciare entrambi i campi vuoti!");
				break;
			}
			
		}
		
		/*Se alla fine del ciclo, count è 0, vuol dire che non c'è stata corrispondenza
		quindi stampa "Nessuna corrispondenza trovata"*/
		if(count==0) {
			System.out.println("Nessuna corrispondenza trovata");
		}
		
		transaction.commit();
		//transaction.rollback();

		entityManager.close();
		
		//Torna true se aperta
		System.out.println(entityManager.isOpen()); //--> false
		
	}
	
	//Metodo che chiede all'utente i dati per creare un nuovo contatto e lo inserisce nel db
	public void creaNuovoContatto(){
		
		System.out.println("Inserisci il contatto:");
		Scanner s = new Scanner(System.in);
		
		Contatti contattoInput = new Contatti();
		
		System.out.print("Nome: ");
		contattoInput.setNome(s.nextLine());
		if(contattoInput.getNome().isEmpty()) {
			contattoInput.setNome(null);
		}
		
		System.out.print("Cognome: ");
		contattoInput.setCognome(s.nextLine());
		if(contattoInput.getCognome().isEmpty()) {
			contattoInput.setCognome(null);
		}
		
		System.out.print("Telefono: ");
		contattoInput.setTelefono(s.nextLine());
		if(contattoInput.getTelefono().isEmpty()) {
			contattoInput.setTelefono(null);
		}
		
		System.out.print("Email: ");
		contattoInput.setEmail(s.nextLine());
		if(contattoInput.getEmail().isEmpty()) {
			contattoInput.setEmail(null);
		}
		
		System.out.print("Note: ");
		contattoInput.setNote(s.nextLine());
		if(contattoInput.getNote().isEmpty()) {
			contattoInput.setNote(null);
		}
		
		EntityManagerFactory entityManagerFactory = JPAEntityManager.openEntityManager();
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		
		//INSERT --> contattoInput contiene solo il contatto da inserire in un nuovo record
		entityManager.persist(contattoInput);
		
		System.out.println("Contatto salvato con successo!");
		
		transaction.commit();
		//transaction.rollback();

		entityManager.close();
		
		//Torna true se aperta
		System.out.println(entityManager.isOpen()); //--> false
	}
	
	//Metodo che modifica un contatto
	public void modificaContatto(){
		
		Contatti contatto = new Contatti();
		Contatti contattoInput = new Contatti();
		int corrispondenza = 0;
		System.out.println("Contatti: ");
		vediListaContatti();
		System.out.println("Inserisci l'id della riga da modificare: ");
		Scanner s = new Scanner(System.in);
		int numeroIdScanner = s.nextInt();
		System.out.println();
	
		EntityManagerFactory entityManagerFactory = JPAEntityManager.openEntityManager();
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		
		contatto = entityManager.find(Contatti.class, numeroIdScanner);
		if(contatto != null) {
			
			//Faccio inserire all'utente i dati da sostituire
			System.out.println("Adesso inserisci i nuovi dati: ");
			System.out.println("Nome: ");
			s = new Scanner(System.in);
			contatto.setNome(s.nextLine());
			
			System.out.println("Cognome: ");
			s = new Scanner(System.in);
			contatto.setCognome(s.nextLine());
			
			System.out.println("Email: ");
			s = new Scanner(System.in);
			contatto.setEmail(s.nextLine());
			
			System.out.println("Telefono: ");
			s = new Scanner(System.in);
			contatto.setTelefono(s.nextLine());
			
			System.out.println("Note: ");
			s = new Scanner(System.in);
			contatto.setNote(s.nextLine());
			
			//INSERT --> contattoInput contiene solo il contatto da inserire in un nuovo record
			entityManager.persist(contattoInput);
			
			System.out.println("Contatto modificato correttamente!");
			System.out.println();
			
		} else {
			System.out.println("Nessuna corrispondenza");
		}

		transaction.commit();
		//transaction.rollback();

		entityManager.close();
		
		//Torna true se aperta
		System.out.println(entityManager.isOpen()); //--> false	
		System.out.println();
	}
	

	public static void main(String[] args) {
		String pathForCSV = "/Users/gianf/Desktop/contatti.csv";
		String pathForXml = "/Users/gianf/Desktop/rubrica.xml";
		String separator = "-";
		int scelta = 0;
		GestoreRubricaJPA gestoreRubricaJPA = new GestoreRubricaJPA();
		
		System.out.println("Azioni che è possibile svolgere:");
		System.out.println("- Inserisci 1 per vedere la lista contatti \n"
				+ "- Inserisci 2 per cercare il contatto \n"
				+ "- Inserisci 3 per inserire un nuovo contatto \n"
				+ "- Inserisci 4 per modificare un contatto \n"
				+ "- Inserisci 5 per cancellare un contatto \n"
				+ "- Inserisci 6 per cercare un duplicato \n"
				+ "- Inserisci 7 per unire un duplicato \n"
				+ "- Inserisci 8 per esportare i dati del db su CSV \n"
				+ "- Inserisci 9 per importare i dati del CSV sul db \n"
				+ "- Inserisci 10 per esportare i dati del db su XML \n"
				+ "- Inserisci 11 per importare i dati dell'XML sul db \n"
				+ "- Inserisci 12 per terminare il programma");
		System.out.println("Inserisci il numero corrispondente per avviare l'azione desiderata:");
		Scanner s = new Scanner(System.in);
		scelta = s.nextInt(); //Prendo il valore inserito dall'utente
		System.out.println();
		
		if(scelta <= 0 || scelta > 12) {
			System.out.println("Scelta non presente");
			System.out.println();
			gestoreRubricaJPA.main(args); //Se non è presente rilancia il programma
		} else {
			switch(scelta) {
				case 1:
					gestoreRubricaJPA.vediListaContatti(); //Se 1 chiama metodo che fa visualizzare i contatti
					System.out.println();
					gestoreRubricaJPA.main(args); //Richiama il programma così si può continuare ad usare, dato che l'utente non ha ancora fatto l'exit
					break;
				case 2:
					gestoreRubricaJPA.cercaContatto();
					System.out.println();
					gestoreRubricaJPA.main(args);
					break;
				case 3:
					gestoreRubricaJPA.creaNuovoContatto();
					System.out.println();
					gestoreRubricaJPA.vediListaContatti();
					gestoreRubricaJPA.main(args);
					break;
				case 4:
					gestoreRubricaJPA.modificaContatto();
					System.out.println("Lista aggiornata");
					gestoreRubricaJPA.vediListaContatti();
					gestoreRubricaJPA.main(args); //Richiama il programma così si può continuare ad usare, dato che l'utente non ha ancora fatto l'exit
					break;
				case 5:
//					gestoreRubricaJPA.eliminaContatto();
					System.out.println("Lista aggiornata");
//					gestoreRubricaJPA.vediListaContatti();
					gestoreRubricaJPA.main(args);
					break;
				case 6:
//					gestoreRubricaJPA.trovaDuplicati();
					gestoreRubricaJPA.main(args);
					break;
				case 7:
//					gestoreRubricaJPA.unisciDuplicati();
					System.out.println();
					System.out.println("Lista aggiornata");
//					ggestoreRubricaJPA.vediListaContatti();
					gestoreRubricaJPA.main(args);
					break;
				case 8:
//					gestoreRubricaJPA.writeRubricaCSV(pathForCSV,separator);
					gestoreRubricaJPA.main(args);
					break;
				case 9:
//					gestoreRubricaJPA.importaContattiCSV(pathForCSV,separator);
					gestoreRubricaJPA.main(args);
					break;
				case 10:
//					gestoreRubricaJPA.writeRubricaXML(pathForXml);
					gestoreRubricaJPA.main(args);
					break;
				case 11:
//					gestoreRubricaJPA.importaContattiXML(pathForXml);
					gestoreRubricaJPA.main(args);
					break;
				case 12:
					System.out.println("Programma terminato");
					break; //Ferma il programma per l'exit
			}
		}
	}
}
