/*
 * Implementate metodi analoghi a questi:
 * 
 * public List<Contatto> loadRubricaFromCSV(String pathFile, String separator) {...}
 * public List<Contatto> loadRubricaFromXML(String pathFile) {...}
 * public void writeRubricaCSV(List<Contatto> contatti, String pathFile, String separator) {...}
 * public void writeRubricaXML(List<Contatto> contatti, String pathFile) {...}
 * 
 * Naturalmente lascio a voi la gestione di eventuali eccezioni.
 * Dopo i metodi base per la scrittura, fate in modo che se indicate
 * un file xml o csv già esistente, i nuovi contatti non vadano a
 * sovrascrivere quelli già presenti, bensì vengano aggiunti in coda.
 * 
 * Estendere la potenzialità dei metodi aggiungendo l'interpretazione
 * automatica delle colonne tramite la lettura della prima riga,
 * ovvero distinguere e gestire in modo automatico
 * SURNAME;NAME;TELEPHONE;EMAIL come anche EMAIL;NAME;SURNAME
 * (senza colonna TELEPHONE) 

 */
package it.beije.neumann.nido.rubrica;

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

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class RubricaManager {

	public static final String CSV_LOAD_PATH = "./src/it/beije/neumann/nido/rubrica/rubrica.csv";
	public static final String CSV_SAVE_PATH = "./src/it/beije/neumann/nido/rubrica/rubricaToCSV.csv";
	public static final String XML_LOAD_PATH = "./src/it/beije/neumann/nido/rubrica/rubrica.xml";
	public static final String XML_SAVE_PATH = "./src/it/beije/neumann/nido/rubrica/rubricaToXML.xml";

	public List<Contatto> loadRubricaFromCSV(String pathFile, String separator)
			throws FileNotFoundException, IOException {
		List<Contatto> contatti = new ArrayList<>();

		FileReader fileReader = new FileReader(pathFile);
		BufferedReader bufferedReader = new BufferedReader(fileReader);

		try {
			String row = null;
			String[] fields = null;
			Contatto contatto = null;

			while (bufferedReader.ready()) {
				row = bufferedReader.readLine();
				fields = row.split(separator);

				contatto = new Contatto();

				contatto.setSurname(fields[0]);
				contatto.setName(fields[1]);
				contatto.setTelephone(fields[2]);
				contatto.setEmail(fields[3]);
				contatto.setNote(fields[4]);

				contatti.add(contatto);
			}
		} catch (IOException ioEx) {
			ioEx.printStackTrace();
			throw ioEx;
		} finally {
			bufferedReader.close();
		}

		return contatti;
	}

	public List<Contatto> loadRubricaFromXML(String pathFile)
			throws ParserConfigurationException, IOException, SAXException {
		List<Contatto> contatti = new ArrayList<>();

		DocumentBuilderFactory docBuilderFact = DocumentBuilderFactory.newInstance();
		DocumentBuilder docBuilder = docBuilderFact.newDocumentBuilder();
		Document document = docBuilder.parse(pathFile);

		Element rootElement = document.getDocumentElement();

		List<Element> childElements = getChildElements(rootElement);
		Contatto contatto = null;

		for (Element e : childElements) {
			contatto = new Contatto();

			List<Element> internalTags = getChildElements(e);
			for (Element tag : internalTags) {
				// System.out.println("node name: " + tag.getNodeName());
				switch (tag.getNodeName()) {
				case "nome":
					contatto.setName(tag.getTextContent());
					break;
				case "cognome":
					contatto.setSurname(tag.getTextContent());
					break;
				case "telefono":
					contatto.setTelephone(tag.getTextContent());
					break;
				case "email":
					contatto.setEmail(tag.getTextContent());
					break;
				case "note":
					contatto.setNote(tag.getTextContent());
					break;
				}
			}

			contatti.add(contatto);
		}

		return contatti;
	}

	public void writeRubricaCSV(List<Contatto> contatti, String pathFile, String separator) throws IOException {

		File file = new File(pathFile);
		FileWriter fW = null;

		if (file.exists()) {
			fW = new FileWriter(file, true); // Append
		} else {
			fW = new FileWriter(file); // Riscrive
		}

		try {
			for (Contatto contatto : contatti) {
				fW.write(contatto.getName() + separator);
				fW.write(contatto.getSurname() + separator);
				fW.write(contatto.getTelephone() + separator);
				fW.write(contatto.getEmail() + separator);
				fW.write(contatto.getNote() + "\n");
			}
		} catch (IOException ioEx) {
			ioEx.printStackTrace();
		} finally {
			fW.flush();
			fW.close();
		}

	}

	public void writeRubricaXML(List<Contatto> contatti, String pathFile)
			throws TransformerException, ParserConfigurationException, SAXException, IOException {

		File file = new File(pathFile);
		DocumentBuilderFactory docBuilderFact = DocumentBuilderFactory.newInstance();
		DocumentBuilder docBuilder = docBuilderFact.newDocumentBuilder();
		Document xmlDoc = null;
		Element root = null;

		if (file.exists()) {
			xmlDoc = docBuilder.parse(pathFile); // Append
			root = xmlDoc.getDocumentElement();

		} else {
			xmlDoc = docBuilder.newDocument(); // Riscrive
			root = xmlDoc.createElement("rubrica");
			xmlDoc.appendChild(root);
		}

		for (Contatto c : contatti) {
			Element contatto = xmlDoc.createElement("contatto");
			Element nome = xmlDoc.createElement("nome");
			nome.setTextContent(c.getName());
			Element cognome = xmlDoc.createElement("cognome");
			cognome.setTextContent(c.getSurname());
			Element telefono = xmlDoc.createElement("telefono");
			telefono.setTextContent(c.getTelephone());
			Element email = xmlDoc.createElement("email");
			email.setTextContent(c.getEmail());
			Element note = xmlDoc.createElement("note");
			note.setTextContent(c.getNote());

			root.appendChild(contatto);
			contatto.appendChild(nome);
			contatto.appendChild(cognome);
			contatto.appendChild(telefono);
			contatto.appendChild(email);
			contatto.appendChild(note);
		}

		TransformerFactory transFactory = TransformerFactory.newInstance();
		Transformer transformer = transFactory.newTransformer();
		DOMSource source = new DOMSource(xmlDoc);

		StreamResult result = new StreamResult(new File(pathFile));

		// Output to console for testing
		StreamResult syso = new StreamResult(System.out);

		transformer.transform(source, result);
		transformer.transform(source, syso);
	}

	public static List<Element> getChildElements(Element e) {
		List<Element> elements = new ArrayList<Element>();
		NodeList childNodes = e.getChildNodes();
		for (int i = 0; i < childNodes.getLength(); i++) {
			Node node = childNodes.item(i);
			if (node instanceof Element) {
				elements.add((Element) node);
			}
		}

		return elements;
	}

	public List<Contatto> addContacts() {
		Scanner in = new Scanner(System.in);
		List<Contatto> contacts = new ArrayList<>();
		String continueAdd = null;
		boolean add = true;

		while (add) {

			System.out.print("\nVuoi inserire un contatto? (s/n) -> ");
			continueAdd = in.nextLine();

			if (continueAdd.equals("s")) {
				Contatto contact = new Contatto();

				System.out.print("Inserisci un nuovo contatto:\n" + "\t-Nome: ");
				contact.setName(in.nextLine());
				System.out.print("\t-Cognome: ");
				contact.setSurname(in.nextLine());
				System.out.print("\t-Telefono: ");
				contact.setTelephone(in.nextLine());
				System.out.print("\t-E-Mail: ");
				contact.setEmail(in.nextLine());
				System.out.print("\t-Note sul contatto: ");
				contact.setNote(in.nextLine());
				System.out.println();

				contacts.add(contact);

				System.out.println("**Inserimento riuscito!**");
			} else {
				add = false;
				System.out.println("**Chiusura inserimento...**");
			}
		}

		return contacts;
	}

	public static void fromCSVtoXML(RubricaManager manager) {
		// Loading
		List<Contatto> contattiCSV = null;

		try {
			contattiCSV = manager.loadRubricaFromCSV(CSV_LOAD_PATH, ";");

			System.out.println("**Contatti letti da CSV**\n");
			for (Contatto c : contattiCSV) {
				System.out.println(c);
			}

			System.out.println();

		} catch (IOException ioEx) {
			ioEx.printStackTrace();
		}

		// Writing
		try {
			manager.writeRubricaXML(contattiCSV, XML_SAVE_PATH);

		} catch (TransformerException | ParserConfigurationException | SAXException | IOException e) {
			e.printStackTrace();
		}
	}

	public static void fromXMLtoCSV(RubricaManager manager) {
		// Loading
		List<Contatto> contattiXML = null;

		try {
			contattiXML = manager.loadRubricaFromXML(XML_LOAD_PATH);

			System.out.println("**Contatti letti da XML**\n");
			for (Contatto c : contattiXML) {
				System.out.println(c);
			}

			System.out.println();

		} catch (ParserConfigurationException | IOException | SAXException e) {
			e.printStackTrace();
		}

		// Writing
		try {
			manager.writeRubricaCSV(contattiXML, CSV_SAVE_PATH, "#");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public boolean isHeader(String line) {
		boolean header = false;

		// TODO Completare metodo per l'intestazione
		System.out.println("Da sistemare");

		return header;
	}

	// TODO Sistemare le eccezioni
	public static void main(String[] args) {
		RubricaManager manager = new RubricaManager();

		fromCSVtoXML(manager); // Okay Append

		// Add contact(s) to CSV
		try {
			manager.writeRubricaCSV(manager.addContacts(), CSV_SAVE_PATH, "#");
		} catch (IOException e) {
			e.printStackTrace();
		}

		fromXMLtoCSV(manager); // Okay Append

		// Add contact(s) to XML
		
		try {
			manager.writeRubricaXML(manager.addContacts(), XML_SAVE_PATH);

		} catch (TransformerException | ParserConfigurationException | SAXException | IOException e) {
			e.printStackTrace();
		}
	}

}
