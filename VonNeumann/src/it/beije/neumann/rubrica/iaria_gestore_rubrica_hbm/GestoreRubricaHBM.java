package it.beije.neumann.rubrica.iaria_gestore_rubrica_hbm;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
public class GestoreRubricaHBM {
	
	//Metodo che legge db
	public void vediListaContatti(){
		
		Session session = HBMsessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
				
		Contatti contatto = new Contatti();

		//SELECT
		Query<Contatti> query = session.createQuery("SELECT c FROM Contatti as c"); //HQL
		List<Contatti> contatti = query.getResultList();
		for (Contatti c : contatti) {
			System.out.println(c);
		}

		transaction.commit();
		session.close();
		//transaction.rollback();
		
		//Torna true se sessione aperta
		System.out.println(session.isOpen()); //--> Close perché è stata chiusa con session.close();
	}
	
	//Metodo che cerca contatto corrispondente
	public void cercaContatto() {
		
		String stringaContatto = "Esito: ";
		int riga = 0;
		int count = 0;
		boolean confronto;
		
		Session session = HBMsessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		
		System.out.println("Inserisci i dati da cercare:");
		Scanner s = new Scanner(System.in);	
		System.out.println("Nome:");
		String nomeScanner = s.nextLine();
		System.out.println("Cognome:");
		String cognomeScanner = s.nextLine();
		System.out.println();
				
		Contatti contatto = new Contatti();
		
		//SELECT
		Query<Contatti> query = session.createQuery("SELECT c FROM Contatti as c"); //HQL
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
			
			/*Se alla fine del ciclo, count è 0, vuol dire che non c'è stata corrispondenza
			quindi stampa "Nessuna corrispondenza trovata"*/
			if(count==0) {
				System.out.println("Nessuna corrispondenza trovata");
			}
			
		}
		
		transaction.commit();
		session.close();
		//transaction.rollback();
		
		//Torna true se sessione aperta
		System.out.println(session.isOpen()); //--> Close perché è stata chiusa con session.close();
		
	}
	
	//Metodo che chiede all'utente i dati per creare un nuovo contatto e lo inserisce nel db
	public void creaNuovoContatto(){
		
		Session session = HBMsessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		
		System.out.println("Inserisci il contatto:");
		Scanner s = new Scanner(System.in);
		
		Contatti contattoInput = new Contatti();
		
		System.out.print("Nome: ");
		contattoInput.setNome(s.nextLine());
		
		System.out.print("Cognome: ");
		contattoInput.setCognome(s.nextLine());
		
		System.out.print("Telefono: ");
		contattoInput.setTelefono(s.nextLine());
		
		System.out.print("Email: ");
		contattoInput.setEmail(s.nextLine());
			
		System.out.print("Note: ");
		contattoInput.setNote(s.nextLine());
			
		System.out.println("Contatto salvato con successo!");
		
		//INSERT		
		session.save(contattoInput);
		
		//UPDATE IN CASO DI VALORI VUOTI
		//session.update("UPDATE contatti set nome = case when nome in('null','') then null else nome end, cognome = case when cognome in('null','') then null else cognome end, telefono = case when telefono in('null','') then null else telefono end, email = case when email in('null','') then null else email end, note = case when note in('null','') then null else note end");
		
		transaction.commit();
		session.close();
		//transaction.rollback();
		
		//Torna true se sessione aperta
		System.out.println(session.isOpen()); //--> Close perché è stata chiusa con session.close();	
	}
	
	//Metodo che modifica un contatto
	public void modificaContatto(){
		
		Session session = HBMsessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		
		Contatti contatto = new Contatti();
		Contatti contattoInput = new Contatti();
		int corrispondenza = 0;
		System.out.println("Contatti: ");
		vediListaContatti();
		System.out.println("Inserisci l'id della riga da modificare: ");
		Scanner s = new Scanner(System.in);
		int numeroIdScanner = s.nextInt();
		System.out.println();
	
		Query<Contatti> query = session.createQuery("SELECT c FROM Contatti as c"); //HQL
		List<Contatti> contatti = query.getResultList();
		for (Contatti c : contatti) {
			if(c.getId() == numeroIdScanner) {  //Se l'id inserito dall'utente corrisponde ad una riga
				
				//Faccio inserire all'utente i dati da sostituire
				System.out.println("Adesso inserisci i nuovi dati: ");
				System.out.println("Nome: ");
				s = new Scanner(System.in);
				c.setNome(s.nextLine());
				
				System.out.println("Cognome: ");
				s = new Scanner(System.in);
				c.setCognome(s.nextLine());
				
				System.out.println("Email: ");
				s = new Scanner(System.in);
				c.setEmail(s.nextLine());
				
				System.out.println("Telefono: ");
				s = new Scanner(System.in);
				c.setTelefono(s.nextLine());
				
				System.out.println("Note: ");
				s = new Scanner(System.in);
				c.setNote(s.nextLine());
				
				System.out.println();
				corrispondenza = 1;
				session.save(contatto); //UPDATE --> Salvo il contatto aggiornato
				
			} else {
				corrispondenza = 0;
			}
		}
		
		if(corrispondenza == 0) {
			System.out.println("Nessuna corrispondenza");
		}
			
		transaction.commit();
		session.close();
		//transaction.rollback();
		
		//Torna true se sessione aperta
		System.out.println(session.isOpen()); //--> Close perché è stata chiusa con session.close();	
		System.out.println();
	}
	
	//Metodo che elimina un contatto
	public void eliminaContatto(){
		
		Session session = HBMsessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		
		System.out.println("Contatti: ");
		vediListaContatti();
		System.out.println("Inserisci l'id della riga da eliminare: ");
		Scanner s = new Scanner(System.in);
		int numeroIdScanner = s.nextInt();
		System.out.println();
		
		Query<Contatti> query = session.createQuery("SELECT c FROM Contatti as c"); //HQL
		List<Contatti> contatti = query.getResultList();
		for (Contatti c : contatti) {
			if(c.getId() == numeroIdScanner) {
				session.delete(c);
			}
		}

		transaction.commit();
		session.close();
		//transaction.rollback();
		
		//Torna true se sessione aperta
		System.out.println(session.isOpen()); //--> Close perché è stata chiusa con session.close();	
		System.out.println();
	}
	
	//Metodo che trova duplicati
	public void trovaDuplicati(){
		int rigaLetta = 0;
		int rigaLetta2 = 0;
		int duplicatiTrovati = 0;
		int count = 0;
		Contatti contatto = null;
		String distingui = "";
		
		Session session = HBMsessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
	
		Query<Contatti> query = session.createQuery("SELECT c FROM Contatti as c"); //HQL
		List<Contatti> contatti = query.getResultList();
		
		for (Contatti c : contatti) {
			rigaLetta++;
			for(Contatti contattiLetti : contatti) {
				rigaLetta2++;
				if(rigaLetta != rigaLetta2) {
					if(contattiLetti.getCognome().contains(c.getCognome()) && contattiLetti.getNome().contains(c.getNome())) {
						duplicatiTrovati++;
						System.out.println(contattiLetti.getNome()+" "+contattiLetti.getCognome()+" ha un duplicato alla riga: "+rigaLetta2);
					}
				}
			}
			System.out.println();
			rigaLetta2 = 0; 
			if(duplicatiTrovati != 0) {
				duplicatiTrovati = 0;
			}
		}

			transaction.commit();
			session.close();
			//transaction.rollback();
			
			//Torna true se sessione aperta
			System.out.println(session.isOpen()); //--> Close perché è stata chiusa con session.close();	
			System.out.println();
	}
	
	//Metodo che unisce duplicati
	public void unisciDuplicati(){
		
		boolean haDuplicato = false;
		Contatti contatto = null;
		List<Contatti> copiaContatto = new ArrayList<>();
		int riga = 0;
		
		Session session = HBMsessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
	
		System.out.println("Contatti: ");
		vediListaContatti();
		System.out.println("Inserisci l'id del duplicato da unire: ");
		Scanner s = new Scanner(System.in);
		int numeroIdScanner = s.nextInt();
		System.out.println();
		
		Query<Contatti> query = session.createQuery("SELECT c FROM Contatti as c"); //HQL
		List<Contatti> contatti = query.getResultList();
		
		for (Contatti c : contatti) {
			if(c.getId() == numeroIdScanner) {
				copiaContatto.add(c);
			}
		}
		
		for(Contatti c : contatti) {
			riga++;
			for(Contatti c2 : copiaContatto) {
				if(c.getNome() != null && c2.getNome() != null && c.getNome().contains(c2.getNome()) && riga > 1) { //Salto la riga corrispondente all'id
					haDuplicato = true;
					session.delete(c);
				}
			}
		}
		
		System.out.println("Duplicati uniti correttamente!");
		
		if(haDuplicato == false) {
			System.out.println("L'utente non ha duplicati");
		}
		
		transaction.commit();
		session.close();
		//transaction.rollback();
		
		//Torna true se sessione aperta
		System.out.println(session.isOpen()); //--> Close perché è stata chiusa con session.close();	
		System.out.println();
	}

	//Metodo che esporta dati db su csv
	public void writeRubricaCSV(String pathFile, String separator) throws IOException{
		
		Session session = HBMsessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		
		File rubrica = new File(pathFile);
		boolean exists = rubrica.exists(); //File esiste
		FileWriter fileWriter = new FileWriter(pathFile, true);
		int righeInserite = 0;
			
		if(!exists) {//Creo la prima riga con NOME-COGNOME-NOTE-TELEFONO se il file non esiste
			fileWriter.write("ID" + separator);
			fileWriter.write("COGNOME" + separator);
			fileWriter.write("NOME" + separator);
			fileWriter.write("TELEFONO" + separator);
			fileWriter.write("EMAIL" + separator);
			fileWriter.write("NOTE" + "\n");
		}
		
		//Prendo i dati dal db
		Query<Contatti> query = session.createQuery("SELECT c FROM Contatti as c"); //HQL
		List<Contatti> contatti = query.getResultList();
		for (Contatti c : contatti) {
			righeInserite++;
			fileWriter.write(c.getId() + separator);
			fileWriter.write(c.getCognome() + separator);
			fileWriter.write(c.getNome() + separator);	
			fileWriter.write(c.getTelefono() + separator);
			fileWriter.write(c.getEmail() + separator);
			fileWriter.write(c.getNote() + "\n");
		}
		System.out.println("Sono state inserite "+righeInserite+" righe");

		fileWriter.close(); //Chiudo il file e salvo le modifiche
		
		transaction.commit();
		session.close();
		//transaction.rollback();
		
		//Torna true se sessione aperta
		System.out.println(session.isOpen()); //--> Close perché è stata chiusa con session.close();	
		System.out.println();
			
	}
	
	//Metodo che importa il file csv su db
	public void importaContattiCSV(String pathFile, String separator) throws FileNotFoundException, IOException{
		
		Session session = HBMsessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		
		int righeInserite = 0;
		String[] fields = null;
		Contatti contatto = null;
		String r = null;
		
		FileReader fileReader = new FileReader(pathFile);
		BufferedReader bufferedReader = new BufferedReader(fileReader);
		
		//Prendo i dati dal db
		Query<Contatti> query = session.createQuery("SELECT c FROM Contatti as c"); //HQL
		List<Contatti> contatti = query.getResultList();
			
			while (bufferedReader.ready()) {
				r = bufferedReader.readLine();
				fields = r.split(separator);
				
				righeInserite++;
				contatto = new Contatti();
				
				contatto.setCognome(fields[1]);
				contatto.setNome(fields[2]);
				contatto.setTelefono(fields[3]);
				contatto.setEmail(fields[4]);
				contatto.setNote(fields[5]);
				
				//Se si trova alla seconda riga (quindi salto NOME;COGNOME;TELEFONO;EMAIL;NOTE)
				if(righeInserite > 1) {
					session.save(contatto);
				}
				
				//session.save("UPDATE contatti set nome = case when nome in('null','') then null else nome end, cognome = case when cognome in('null','') then null else cognome end, telefono = case when telefono in('null','') then null else telefono end, email = case when email in('null','') then null else email end, note = case when note in('null','') then null else note end");

			}
			
			//Salto NOME;COGNOME;TELEFONO;EMAIL;NOTE togliendo 1 da righeInserite che contiene il numero di cicli effettuati
			System.out.println("Sono state inserite "+ (righeInserite-1) +" righe");
			System.out.println();
			
			bufferedReader.close();
			
			transaction.commit();
			session.close();
			//transaction.rollback();
			
			//Torna true se sessione aperta
			System.out.println(session.isOpen()); //--> Close perché è stata chiusa con session.close();	
			System.out.println();

	}
	
	//Metodo che esporta dati db su xml
	public void writeRubricaXML(String pathFile) throws ParserConfigurationException, IOException, SAXException, ClassNotFoundException, DOMException, SQLException, TransformerException{
		
		Session session = HBMsessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		
		int righeInserite = 0;
			
		//Creo file
		File rubricaXml = new File(pathFile);
		DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
		
		//Costruiamo una factory per processare il nostro flusso di dati
		DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
		Document doc = null;
		
		//Creo il root che una volta creato il file diventerà rubrica
		Element root = null;
		
		//Se il file esiste, analizza e verifica il root per poi effettuare l'append
		if(rubricaXml.exists()) {
			doc = docBuilder.parse(pathFile);
			root = doc.getDocumentElement();			
		} else { //Se non esiste crea un nuovo document con il root "Rubrica"
			doc = docBuilder.newDocument();
			root = doc.createElement("Rubrica");
			doc.appendChild(root);
		}
		
		//Prendo i dati dal db
		Query<Contatti> query = session.createQuery("SELECT c FROM Contatti as c"); //HQL
		List<Contatti> contatti = query.getResultList();
		for (Contatti c : contatti) {
			righeInserite++;
			
			//Per ogni contatto inserisci: Contatto ed i figli nome,cognome ecc. con valori
			Element contatto = doc.createElement("Contatto");
			Element id = doc.createElement("ID");
			id.setTextContent(Integer.toString(c.getId()));
			Element cognome = doc.createElement("Cognome");
			cognome.setTextContent(c.getCognome());
			Element nome = doc.createElement("Nome");
			nome.setTextContent(c.getNome());
			Element telefono = doc.createElement("Telefono");
			telefono.setTextContent(c.getTelefono());
			Element email = doc.createElement("Email");
			email.setTextContent(c.getEmail());
			Element note = doc.createElement("Note");
			note.setTextContent(c.getNote());	
			
			//Inserisco contatto come figlio di root (Rubrica) e poi aggiungo ai contatti i valori
			root.appendChild(contatto);
			contatto.appendChild(id);
			contatto.appendChild(cognome);
			contatto.appendChild(nome);
			contatto.appendChild(telefono);
			contatto.appendChild(email);
			contatto.appendChild(note);
		}
		System.out.println("Sono state inserite "+righeInserite+" righe");
		System.out.println();
		
		//Scrivo il contenuto nel file xml
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer = transformerFactory.newTransformer();
		DOMSource source = new DOMSource(doc);
		StreamResult result = new StreamResult(new File(pathFile));
		transformer.transform(source, result);
		
		transaction.commit();
		session.close();
		//transaction.rollback();
		
		//Torna true se sessione aperta
		System.out.println(session.isOpen()); //--> Close perché è stata chiusa con session.close();	
		System.out.println();
		
	}
	
	//Per leggere dati .XML
	public static List<Element> getChildElements(Element e) {
		List<Element> elements = new ArrayList<Element>();
		NodeList childNodes = e.getChildNodes();
		for (int i = 0; i < childNodes.getLength(); i ++) {
			Node node = childNodes.item(i);
			if (node instanceof Element) {
				elements.add((Element) node);
			}
		}
		
		return elements;
	}
	
	//Metodo che importa il file xml su db
	public void importaContattiXML(String pathFile) throws ParserConfigurationException, IOException, SAXException, ClassNotFoundException{
		
		Session session = HBMsessionFactory.openSession();
		Transaction transaction = session.beginTransaction();

		int righeInserite = 0;
		
		DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
		Document document = documentBuilder.parse(pathFile);		
		Element rootElement = document.getDocumentElement();
		List<Element> elements = getChildElements(rootElement);
			
		Contatti contatto = null;
		
		for (Element el : elements) {
			righeInserite++;
			contatto = new Contatti();
			
			List<Element> values = getChildElements(el);

			//Leggo in verticale
			for (Element v : values) {
				String valore = v.getNodeName().toLowerCase(); //Prendo il nome del nodo in minuscolo per confrontarlo

				switch (valore) {
				case "cognome":
					contatto.setCognome(v.getTextContent());
					break;
				case "nome":
					contatto.setNome(v.getTextContent());
					break;
				case "telefono":
					contatto.setTelefono(v.getTextContent());
					break;
				case "email":
					contatto.setEmail(v.getTextContent());
					break;
				case "note":
					contatto.setNote(v.getTextContent());
					break;
				}
			}
			
			//INSERT
			session.save(contatto);
	
		}
			
			//UPDATE
			//("UPDATE contatti set nome = case when nome in('null','') then null else nome end, cognome = case when cognome in('null','') then null else cognome end, telefono = case when telefono in('null','') then null else telefono end, email = case when email in('null','') then null else email end, note = case when note in('null','') then null else note end");
			
			System.out.println("Sono state inserite "+righeInserite+" righe");
			System.out.println();
			
			transaction.commit();
			session.close();
			//transaction.rollback();
			
			//Torna true se sessione aperta
			System.out.println(session.isOpen()); //--> Close perché è stata chiusa con session.close();	
			System.out.println();

	}
	
	public static void main(String[] args) throws IOException, ClassNotFoundException, DOMException, ParserConfigurationException, SAXException, SQLException, TransformerException {
		String pathForCSV = "/Users/gianf/Desktop/contatti.csv";
		String pathForXml = "/Users/gianf/Desktop/rubrica.xml";
		String separator = "-";
		int scelta = 0;
		GestoreRubricaHBM gestoreRubricaHBM = new GestoreRubricaHBM();
		
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
			gestoreRubricaHBM.main(args); //Se non è presente rilancia il programma
		} else {
			switch(scelta) {
				case 1:
					gestoreRubricaHBM.vediListaContatti(); //Se 1 chiama metodo che fa visualizzare i contatti
					System.out.println();
					gestoreRubricaHBM.main(args); //Richiama il programma così si può continuare ad usare, dato che l'utente non ha ancora fatto l'exit
					break;
				case 2:
					gestoreRubricaHBM.cercaContatto();
					System.out.println();
					gestoreRubricaHBM.main(args);
					break;
				case 3:
					gestoreRubricaHBM.creaNuovoContatto();
					System.out.println();
					gestoreRubricaHBM.vediListaContatti();
					gestoreRubricaHBM.main(args);
					break;
				case 4:
					gestoreRubricaHBM.modificaContatto();
					System.out.println("Lista aggiornata");
					gestoreRubricaHBM.vediListaContatti();
					gestoreRubricaHBM.main(args); //Richiama il programma così si può continuare ad usare, dato che l'utente non ha ancora fatto l'exit
					break;
				case 5:
					gestoreRubricaHBM.eliminaContatto();
					System.out.println("Lista aggiornata");
					gestoreRubricaHBM.vediListaContatti();
					gestoreRubricaHBM.main(args);
					break;
				case 6:
					gestoreRubricaHBM.trovaDuplicati();
					gestoreRubricaHBM.main(args);
					break;
				case 7:
					gestoreRubricaHBM.unisciDuplicati();
					System.out.println();
					System.out.println("Lista aggiornata");
					gestoreRubricaHBM.vediListaContatti();
					gestoreRubricaHBM.main(args);
					break;
				case 8:
					gestoreRubricaHBM.writeRubricaCSV(pathForCSV,separator);
					gestoreRubricaHBM.main(args);
					break;
				case 9:
					gestoreRubricaHBM.importaContattiCSV(pathForCSV,separator);
					gestoreRubricaHBM.main(args);
					break;
				case 10:
					gestoreRubricaHBM.writeRubricaXML(pathForXml);
					gestoreRubricaHBM.main(args);
					break;
				case 11:
					gestoreRubricaHBM.importaContattiXML(pathForXml);
					gestoreRubricaHBM.main(args);
					break;
				case 12:
					System.out.println("Programma terminato");
					break; //Ferma il programma per l'exit
			}
		}
	}
}
