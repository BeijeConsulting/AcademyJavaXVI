package it.beije.neumann.iaria.rubrica;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.xml.sax.SAXException;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;

public class LoadWriteCsvXml {
	
	//Metodo che chiede all'utente di inserire 3 contatti e li inserisce nella List<Contatto>
	public static List<Contatto> userContacts() {
		System.out.println("Inserisci 3 contatti:");
		Scanner s = new Scanner(System.in);		
		List<Contatto> contattiDaScanner = new ArrayList<Contatto>();
		
		for(int i=1; i<=3; i++) {
			Contatto contattoInput = new Contatto();
			System.out.print("Nome: ");
			contattoInput.setName(s.nextLine());
		
			System.out.print("Cognome: ");
			contattoInput.setSurname(s.nextLine());
			
			System.out.print("Note: ");
			contattoInput.setNote(s.nextLine());
				
			System.out.print("Telefono: ");
			contattoInput.setTelephone(s.nextLine());

			int mancanti = 3-i;
			
			if(mancanti==0) {
				System.out.println("Contatti salvati con successo!");
				contattiDaScanner.add(contattoInput); //Inserisco valori nella lista contatti
				break;
			}
			System.out.println("Salvato il "+i+"° contatto, ne mancano ancora "+mancanti);
			
			contattiDaScanner.add(contattoInput); //Inserisco valori nella lista contatti

		}
		
		return contattiDaScanner;		
	}
	
	public void writeRubricaCSV(List<Contatto> contatti, String pathFile, String separator) throws IOException{
		File rubrica = new File(pathFile);
		//FileWriter fileWriter = new FileWriter(rubrica);
		FileWriter fileWriter = new FileWriter(pathFile, true);
		
		try {
			
			//Creo la prima riga con NOME-COGNOME-NOTE-TELEFONO
			fileWriter.write("NOME" + separator);
			fileWriter.write("COGNOME" + separator);
			fileWriter.write("NOTE" + separator);
			fileWriter.write("TELEFONO" + "\n");
			
			for (Contatto persona : contatti) {
				fileWriter.write(persona.getName() + separator);
				fileWriter.write(persona.getSurname() + separator);
				fileWriter.write(persona.getNote() + separator);
				fileWriter.write(persona.getTelephone() + "\n");
			}

		} catch (IOException ioEx) {
			ioEx.printStackTrace();
			throw ioEx;
		} finally {
			fileWriter.close(); //Chiudo il file per salvare modifiche
		}
	}
	
	public void writeRubricaXML(List<Contatto> contatti, String pathFile) throws ParserConfigurationException, IOException, SAXException{
		
		try {
			
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
			
			//Leggo i contatti e li inserisco nel documento
			for (Contatto persona : contatti) {

				//Per ogni contatto inserisci: Contatto ed i figli nome,cognome ecc. con valori
				Element contatto = doc.createElement("Contatto");
				Element nome = doc.createElement("Nome");
				nome.setTextContent(persona.getName());
				Element cognome = doc.createElement("Cognome");
				cognome.setTextContent(persona.getSurname());
				Element note = doc.createElement("Note");
				note.setTextContent(persona.getNote());
				Element telefono = doc.createElement("Telefono");
				telefono.setTextContent(persona.getTelephone());
				
				//Inserisco contatto come figlio di root (Rubrica) e poi aggiungo ai contatti i valori
				root.appendChild(contatto); 
				contatto.appendChild(nome);
				contatto.appendChild(cognome);
				contatto.appendChild(note);
				contatto.appendChild(telefono);

			}
			
			//Chiudo rubrica dopo aver inserito i valori
			//doc.appendChild(root);
			
			//Scrivo il contenuto nel file xml
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(doc);
			StreamResult result = new StreamResult(new File(pathFile));
			transformer.transform(source, result);
			
		}catch(TransformerException te) {
			System.out.println("TransformerException");
		}catch(ParserConfigurationException pcex) {
			System.out.println("ParserConfigurationException");
		}
		
	}
	
	/*public List<Contatto> loadRubricaFromCSV(String pathFile, String separator) throws {
	List<Contatto> contatti = new ArrayList<Contatto>();
	return contatti;
	}*/
	
	public static void main(String[] args) throws FileNotFoundException, IOException, ParserConfigurationException, SAXException {
		LoadWriteCsvXml lwcsvxml = new LoadWriteCsvXml();
		
		//CSV
		String pathForCsvFile = "/Users/gianf/Desktop/rubrica.csv";
		String separator = "-";
		//List<Contatto> contattiCSV = userContacts();
		
		//XML
		List<Contatto> contattiXML = userContacts();
		String pathForXmlFile = "/Users/gianf/Desktop/rubrica.xml";
		
		
		//lwcsvxml.writeRubricaCSV(contattiCSV, pathForCsvFile, separator);
		lwcsvxml.writeRubricaXML(contattiXML, pathForXmlFile);
		
		//System.out.println(contattiCSV);
		
	}

}
