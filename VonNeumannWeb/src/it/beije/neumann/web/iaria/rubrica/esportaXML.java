package it.beije.neumann.web.iaria.rubrica;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 * Servlet implementation class leggiContatti
 */
@WebServlet("/iaria/esportaXML")
public class esportaXML extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public esportaXML() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		EntityManagerFactory entityManagerFactory = JPAEntityManager.openEntityManager();
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		String pathFile = "/Users/gianf/Desktop/rubrica.xml";
		int righeInserite = 0;
		
		//Creo file
		File rubricaXml = new File(pathFile);
		DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
		
		//Costruiamo una factory per processare il nostro flusso di dati
		//DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
		Document doc = null;
		
		//Creo il root che una volta creato il file diventerà rubrica
		Element root = null;
		
		//Se il file esiste, analizza e verifica il root per poi effettuare l'append
		if(rubricaXml.exists()) {
			//doc = docBuilder.parse(pathFile);
			root = doc.getDocumentElement();			
		} else { //Se non esiste crea un nuovo document con il root "Rubrica"
			//doc = docBuilder.newDocument();
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
		//Transformer transformer = transformerFactory.newTransformer();
		DOMSource source = new DOMSource(doc);
		StreamResult result = new StreamResult(new File(pathFile));
		//transformer.transform(source, result);

		entityManager.close();
		
		//Torna true se aperta
		System.out.println(entityManager.isOpen()); //--> false	
		System.out.println();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
