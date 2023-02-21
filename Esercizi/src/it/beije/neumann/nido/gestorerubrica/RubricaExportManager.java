package it.beije.neumann.nido.gestorerubrica;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

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
import org.xml.sax.SAXException;

public class RubricaExportManager {

	private final String CSV = "./src/it/beije/neumann/nido/gestorerubrica/addressBook.csv";
	private final String XML = "./src/it/beije/neumann/nido/gestorerubrica/addressBook.xml";

	public void exportToCSV(String pathFile, String header, String separator, List<Contact> contacts)
			throws IOException {
		File file = new File(pathFile);
		FileWriter fW = null;

		if (file.exists()) {
			fW = new FileWriter(file, true); // Append
		} else {
			fW = new FileWriter(file); // Riscrive
		}

		try {

			fW.write(header.toUpperCase() + "\n");

			for (Contact contact : contacts) {
				fW.write(contact.getSurname() + separator);
				fW.write(contact.getName() + separator);
				fW.write(contact.getAge() + separator);
				fW.write(contact.getTelephone() + separator);
				fW.write(contact.getEmail() + separator);
				fW.write(contact.getNote() + "\n");
			}
		} catch (IOException ioEx) {
			ioEx.printStackTrace();
		} finally {
			fW.flush();
			fW.close();
		}
	}

	public void exportToXML(String pathFile, List<Contact> contacts)
			throws ParserConfigurationException, SAXException, IOException, TransformerException {
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

		for (Contact c : contacts) {
			Element contact = xmlDoc.createElement("contact");

			Element surname = xmlDoc.createElement("surname");
			surname.setTextContent(c.getSurname());

			Element name = xmlDoc.createElement("name");
			name.setTextContent(c.getName());

			Element age = xmlDoc.createElement("age");
			age.setTextContent(String.valueOf(c.getAge()));

			Element telephone = xmlDoc.createElement("telephone");
			telephone.setTextContent(c.getTelephone());

			Element email = xmlDoc.createElement("email");
			email.setTextContent(c.getEmail());

			Element note = xmlDoc.createElement("note");
			note.setTextContent(c.getNote());

			root.appendChild(contact);
			contact.appendChild(surname);
			contact.appendChild(name);
			contact.appendChild(telephone);
			contact.appendChild(email);
			contact.appendChild(note);
		}

		TransformerFactory transFactory = TransformerFactory.newInstance();
		Transformer transformer = transFactory.newTransformer();
		DOMSource source = new DOMSource(xmlDoc);

		StreamResult result = new StreamResult(new File(pathFile));
		transformer.transform(source, result);
	}
}
