package it.beije.neumann.rubrica.iaria_gestore_rubrica_jpa;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.mysql.cj.x.protobuf.MysqlxCrud.Delete;

public class GestoreRubricaCriteriaJPA {
	
	//Metodo che legge db
	public void vediListaContatti(){

		EntityManagerFactory entityManagerFactory = JPAEntityManager.openEntityManager();
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
				
		Contatti contatto = new Contatti();

		//Creo un oggetto CriteriaBuilder usando l'istanza EntityManager
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		
		//Creo un oggetto query creando un'istanza dell'interfaccia criteriaQuery
		CriteriaQuery<Contatti> criteriaQuery = criteriaBuilder.createQuery(Contatti.class);
		
		//Imposto la radice della query
		Root<Contatti> contattiRoot = criteriaQuery.from(Contatti.class);
		
		//Specifico il tipo di risultato della query
		CriteriaQuery<Contatti> select = criteriaQuery.select(contattiRoot);
		//criteriaQuery.select(contattiRoot.get("nome"));  --> SELECT, es: CriteriaQuery<Contatti> select criteriaQuery.select(contattiRoot.get("nome"));
		
		//Preparo la query per l'esecuzione, specificando il tipo di risultato
		TypedQuery<Contatti> query = entityManager.createQuery(select);
		
		//Eseguo la query con getResultList() e inserisco i risultati nella List
		List<Contatti> contatti = query.getResultList();
		
		for(Contatti c : contatti){
			System.out.println(c);
		}

		transaction.commit();
		//transaction.rollback();

		entityManager.close();

	}
	
	//Metodo che cerca contatto corrispondente
	public void cercaContatto() {
		
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
		
		//Creo oggetti e radice query
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Contatti> criteriaQuery = criteriaBuilder.createQuery(Contatti.class);
		Root<Contatti> contattiRoot = criteriaQuery.from(Contatti.class);

		List contattiDaCercare = Arrays.asList(new String[]{nomeScanner,cognomeScanner}); //Lista dei valori da confrontare
		Expression<String> exp1 = contattiRoot.get("nome");
		Expression<String> exp2 = contattiRoot.get("cognome");
		Predicate contenutoNome = exp1.in(contattiDaCercare);
		Predicate contenutoCognome = exp2.in(contattiDaCercare);
		criteriaQuery.where(contenutoNome,contenutoCognome); //WHERE nome = nomeScanner AND cognome = cognomeScanner

		CriteriaQuery<Contatti> select = criteriaQuery.select(contattiRoot);
		TypedQuery<Contatti> query = entityManager.createQuery(select);
		List<Contatti> contatti = query.getResultList();
		
		if(!contatti.isEmpty()) {
			for(Contatti c : contatti){
				System.out.println(c);
			}
		} else {
			System.out.println("Nessuna corrispondenza trovata");
		}
		
		transaction.commit();
		//transaction.rollback();

		entityManager.close();
		
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
		
		System.out.println();
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
		
		//contatto = entityManager.find(Contatti.class, numeroIdScanner);
		
		//Creo oggetti e radice query
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Contatti> criteriaQuery = criteriaBuilder.createQuery(Contatti.class);
		Root<Contatti> contattiRoot = criteriaQuery.from(Contatti.class);

		List idDaCercare = Arrays.asList(new String[]{Integer.toString(numeroIdScanner)}); //Lista dei valori da confrontare
		Expression<String> exp1 = contattiRoot.get("id");
		Predicate contenutoId = exp1.in(idDaCercare);
		criteriaQuery.where(contenutoId); //WHERE id = numeroIdScanner
		
		CriteriaQuery<Contatti> select = criteriaQuery.select(contattiRoot);
		TypedQuery<Contatti> query = entityManager.createQuery(select);
		List<Contatti> contattoCorrispondente = query.getResultList();
		
		if(contattoCorrispondente != null) {

			//Faccio inserire all'utente i dati da sostituire
			System.out.println("Adesso inserisci i nuovi dati: ");
			Scanner s2 = new Scanner(System.in);
			
			System.out.print("Nome: ");
			contattoInput.setNome(s2.nextLine());
			if(contattoInput.getNome().isEmpty()) {
				contattoInput.setNome(null);
			}
			
			System.out.print("Cognome: ");
			contattoInput.setCognome(s2.nextLine());
			if(contattoInput.getCognome().isEmpty()) {
				contattoInput.setCognome(null);
			}
			
			System.out.print("Telefono: ");
			contattoInput.setTelefono(s2.nextLine());
			if(contattoInput.getTelefono().isEmpty()) {
				contattoInput.setTelefono(null);
			}
			
			System.out.print("Email: ");
			contattoInput.setEmail(s2.nextLine());
			if(contattoInput.getEmail().isEmpty()) {
				contattoInput.setEmail(null);
			}
			
			System.out.print("Note: ");
			contattoInput.setNote(s2.nextLine());
			if(contattoInput.getNote().isEmpty()) {
				contattoInput.setNote(null);
			}
			
			for(Contatti c : contattoCorrispondente) {
				c.setNome(contattoInput.getNome());
				c.setCognome(contattoInput.getCognome());
				c.setTelefono(contattoInput.getTelefono());
				c.setEmail(contattoInput.getEmail());
				c.setNote(contattoInput.getNote());
			}

			System.out.println("Contatto modificato correttamente!");
			System.out.println();
			
		} else {
			System.out.println("Nessuna corrispondenza");
		}

		transaction.commit();
		//transaction.rollback();

		entityManager.close();
		
		System.out.println();
	}
	
	//Metodo che elimina un contatto
	public void eliminaContatto(){
		
		EntityManagerFactory entityManagerFactory = JPAEntityManager.openEntityManager();
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		
		Contatti contatto = new Contatti();
		System.out.println("Contatti: ");
		vediListaContatti();
		System.out.println("Inserisci l'id della riga da eliminare: ");
		Scanner s = new Scanner(System.in);
		int numeroIdScanner = s.nextInt();
		System.out.println();
		
		//Creo oggetti e radice query
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaDelete<Contatti> criteriaDelete = criteriaBuilder.createCriteriaDelete(Contatti.class);
		Root<Contatti> contattoDaEliminare = criteriaDelete.from(Contatti.class);

		String idDaCercare = Integer.toString(numeroIdScanner); //Lista dei valori da confrontare
		criteriaDelete.where(contattoDaEliminare.get("id").in(idDaCercare));
		
		int result = entityManager.createQuery(criteriaDelete).executeUpdate();
		
		if(result<1) {
			System.out.println("Nessuna corrispondenza trovata");
		}

		transaction.commit();
		//transaction.rollback();

		entityManager.close();
		
		System.out.println();
	}
	
	//Metodo che trova duplicati
	public void trovaDuplicati(){
		int rigaLetta = 0;
		int rigaLetta2 = 0;
		int duplicatiTrovati = 0;
		
		EntityManagerFactory entityManagerFactory = JPAEntityManager.openEntityManager();
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();

		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Contatti> criteriaQuery = criteriaBuilder.createQuery(Contatti.class);
		Root<Contatti> contattiRoot = criteriaQuery.from(Contatti.class);
		
		CriteriaQuery<Contatti> select = criteriaQuery.select(contattiRoot);		
		TypedQuery<Contatti> query = entityManager.createQuery(select);
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
		//transaction.rollback();

		entityManager.close();
		
		System.out.println();
	}
	
	//Metodo che unisce duplicati
	public void unisciDuplicati(){
		
		boolean haDuplicato = false;
		Contatti contatto = null;
		
		EntityManagerFactory entityManagerFactory = JPAEntityManager.openEntityManager();
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
	
		System.out.println("Contatti: ");
		vediListaContatti();
		System.out.println("Inserisci l'id del duplicato da unire: ");
		Scanner s = new Scanner(System.in);
		int numeroIdScanner = s.nextInt();
		System.out.println();
		
		//Contatto con id uguale
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Contatti> criteriaQuery = criteriaBuilder.createQuery(Contatti.class);
		Root<Contatti> contattoRoot = criteriaQuery.from(Contatti.class);
		
		List idDaCercare = Arrays.asList(new String[]{Integer.toString(numeroIdScanner)}); //Lista dei valori da confrontare
		Expression<String> exp1 = contattoRoot.get("id");
		Predicate contenutoId = exp1.in(idDaCercare);
		criteriaQuery.where(contenutoId); //WHERE id = numeroIdScanner
		
		CriteriaQuery<Contatti> select = criteriaQuery.select(contattoRoot);
		TypedQuery<Contatti> query1 = entityManager.createQuery(select);
		List<Contatti> contattoConIdCorrispondente = query1.getResultList();
		
		//Tutti i contatti
		CriteriaBuilder criteriaBuilder2 = entityManager.getCriteriaBuilder();
		CriteriaQuery<Contatti> criteriaQuery2 = criteriaBuilder2.createQuery(Contatti.class);
		Root<Contatti> contattiRootAll = criteriaQuery2.from(Contatti.class);
		CriteriaQuery<Contatti> select2 = criteriaQuery2.select(contattiRootAll);
		TypedQuery<Contatti> query2 = entityManager.createQuery(select2);
		List<Contatti> contattiAll = query2.getResultList();
		
		for(Contatti c1 : contattoConIdCorrispondente){ //Scorro il contatto con id uguale (devo farlo per avere getNome e getCognome)
			for(Contatti c2 : contattiAll) {  //Scorro tutti i contatti. Quando il nome == nome contatto id uguale, ed anche il cognome ma id diverso (così non cancello quello di partenza)
				if(c1.getNome().contains(c2.getNome()) && c1.getCognome().contains(c2.getCognome()) && c1.getId() != c2.getId()) {
					haDuplicato = true;
					c1.setTelefono(c1.getTelefono() + " / " + c2.getTelefono()); //Aggiungo il numero del duplicato al contatto di partenza

					//Scorro la lista ed elimino tutti gli altri contatti
					CriteriaBuilder criteriaBuilder3 = entityManager.getCriteriaBuilder();
					CriteriaDelete<Contatti> criteriaDelete = criteriaBuilder3.createCriteriaDelete(Contatti.class);
					Root<Contatti> daEliminare = criteriaDelete.from(Contatti.class);
					criteriaDelete.where(daEliminare.get("nome").in(c2.getNome()), daEliminare.get("cognome").in(c2.getCognome()), daEliminare.get("id").in(c2.getId()));

					int result = entityManager.createQuery(criteriaDelete).executeUpdate();
					
				} //Aggiungo i numeri di telefono all'utente originale ed elimino gli altri
			}
		}		
		
		System.out.println("Duplicati uniti correttamente!");
		
		if(haDuplicato == false) {
			System.out.println("L'utente non ha duplicati");
		}
		
		transaction.commit();
		//transaction.rollback();

		entityManager.close();
		
		System.out.println();
	}
	
	//Metodo che esporta dati db su csv
	public void writeRubricaCSV(String pathFile, String separator) throws IOException{
		
		EntityManagerFactory entityManagerFactory = JPAEntityManager.openEntityManager();
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		
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
		Query query = entityManager.createQuery("SELECT c FROM Contatti as c");
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
		//transaction.rollback();

		entityManager.close();

		System.out.println();
			
	}
	
	//Metodo che importa il file csv su db
	public void importaContattiCSV(String pathFile, String separator) throws FileNotFoundException, IOException{
		
		EntityManagerFactory entityManagerFactory = JPAEntityManager.openEntityManager();
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		
		int righeInserite = 0;
		String[] fields = null;
		Contatti contatto = null;
		String r = null;
		
		FileReader fileReader = new FileReader(pathFile);
		BufferedReader bufferedReader = new BufferedReader(fileReader);
		
		//Prendo i dati dal db
		Query query = entityManager.createQuery("SELECT c FROM Contatti as c");
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
					entityManager.persist(contatto);
				}
				
				//session.save("UPDATE contatti set nome = case when nome in('null','') then null else nome end, cognome = case when cognome in('null','') then null else cognome end, telefono = case when telefono in('null','') then null else telefono end, email = case when email in('null','') then null else email end, note = case when note in('null','') then null else note end");

			}
			
			//Salto NOME;COGNOME;TELEFONO;EMAIL;NOTE togliendo 1 da righeInserite che contiene il numero di cicli effettuati
			System.out.println("Sono state inserite "+ (righeInserite-1) +" righe");
			System.out.println();
			
			bufferedReader.close();
			
			transaction.commit();
			//transaction.rollback();

			entityManager.close();
			
			//Torna true se aperta
			System.out.println(entityManager.isOpen()); //--> false	
			System.out.println();

	}
	
	//Metodo che esporta dati db su xml
	public void writeRubricaXML(String pathFile) throws ParserConfigurationException, IOException, SAXException, ClassNotFoundException, DOMException, SQLException, TransformerException{
		
		EntityManagerFactory entityManagerFactory = JPAEntityManager.openEntityManager();
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		
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
		Query query = entityManager.createQuery("SELECT c FROM Contatti as c");
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
		//transaction.rollback();

		entityManager.close();
		
		//Torna true se aperta
		System.out.println(entityManager.isOpen()); //--> false	
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
		
		EntityManagerFactory entityManagerFactory = JPAEntityManager.openEntityManager();
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();

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
			entityManager.persist(contatto);
	
		}
			
			//UPDATE
			//("UPDATE contatti set nome = case when nome in('null','') then null else nome end, cognome = case when cognome in('null','') then null else cognome end, telefono = case when telefono in('null','') then null else telefono end, email = case when email in('null','') then null else email end, note = case when note in('null','') then null else note end");
			
			System.out.println("Sono state inserite "+righeInserite+" righe");
			System.out.println();
			
			transaction.commit();
			//transaction.rollback();

			entityManager.close();
			
			//Torna true se aperta
			System.out.println(entityManager.isOpen()); //--> false	
			System.out.println();

	}

	public static void main(String[] args) throws IOException, ClassNotFoundException, DOMException, ParserConfigurationException, SAXException, SQLException, TransformerException {
		String pathForCSV = "/Users/gianf/Desktop/contatti.csv";
		String pathForXml = "/Users/gianf/Desktop/rubrica.xml";
		String separator = "-";
		int scelta = 0;
		GestoreRubricaCriteriaJPA gestoreRubricaCriteriaJPA = new GestoreRubricaCriteriaJPA();
		
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
			gestoreRubricaCriteriaJPA.main(args); //Se non è presente rilancia il programma
		} else {
			switch(scelta) {
				case 1:
					gestoreRubricaCriteriaJPA.vediListaContatti(); //Se 1 chiama metodo che fa visualizzare i contatti
					System.out.println();
					gestoreRubricaCriteriaJPA.main(args); //Richiama il programma così si può continuare ad usare, dato che l'utente non ha ancora fatto l'exit
					break;
				case 2:
					gestoreRubricaCriteriaJPA.cercaContatto();
					System.out.println();
					gestoreRubricaCriteriaJPA.main(args);
					break;
				case 3:
					gestoreRubricaCriteriaJPA.creaNuovoContatto();
					System.out.println();
					gestoreRubricaCriteriaJPA.vediListaContatti();
					gestoreRubricaCriteriaJPA.main(args);
					break;
				case 4:
					gestoreRubricaCriteriaJPA.modificaContatto();
					System.out.println("Lista aggiornata");
					gestoreRubricaCriteriaJPA.vediListaContatti();
					gestoreRubricaCriteriaJPA.main(args); //Richiama il programma così si può continuare ad usare, dato che l'utente non ha ancora fatto l'exit
					break;
				case 5:
					gestoreRubricaCriteriaJPA.eliminaContatto();
					System.out.println("Lista aggiornata");
					gestoreRubricaCriteriaJPA.vediListaContatti();
					gestoreRubricaCriteriaJPA.main(args);
					break;
				case 6:
					gestoreRubricaCriteriaJPA.trovaDuplicati();
					gestoreRubricaCriteriaJPA.main(args);
					break;
				case 7:
					gestoreRubricaCriteriaJPA.unisciDuplicati();
					System.out.println();
					System.out.println("Lista aggiornata");
					gestoreRubricaCriteriaJPA.vediListaContatti();
					gestoreRubricaCriteriaJPA.main(args);
					break;
				case 8:
					gestoreRubricaCriteriaJPA.writeRubricaCSV(pathForCSV,separator);
					gestoreRubricaCriteriaJPA.main(args);
					break;
				case 9:
					gestoreRubricaCriteriaJPA.importaContattiCSV(pathForCSV,separator);
					gestoreRubricaCriteriaJPA.main(args);
					break;
				case 10:
					gestoreRubricaCriteriaJPA.writeRubricaXML(pathForXml);
					gestoreRubricaCriteriaJPA.main(args);
					break;
				case 11:
					gestoreRubricaCriteriaJPA.importaContattiXML(pathForXml);
					gestoreRubricaCriteriaJPA.main(args);
					break;
				case 12:
					System.out.println("Programma terminato");
					break; //Ferma il programma per l'exit
			}
		}
	}

}

