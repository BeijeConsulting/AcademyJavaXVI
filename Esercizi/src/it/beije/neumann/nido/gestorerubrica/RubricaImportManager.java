package it.beije.neumann.nido.gestorerubrica;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

public class RubricaImportManager {

	public List<Contact> importFromCSV(String filePath, String separator) throws IOException {
		List<Contact> contacts = new ArrayList<>();

		FileReader fileReader = new FileReader(filePath);
		BufferedReader bufferedReader = new BufferedReader(fileReader);

		try {
			String r = null;
			String[] fields = null;
			Contact contact = null;
			while (bufferedReader.ready()) {
				r = bufferedReader.readLine();
				fields = r.split(separator);

				contact = new Contact();

				contact.setSurname(fields[0]);
				contact.setName(fields[1]);
				contact.setAge(Integer.parseInt(fields[2]));
				contact.setTelephone(fields[3]);
				contact.setEmail(fields[4]);
				contact.setNote(fields[5]);

				contacts.add(contact);
			}
		} catch (IOException ioEx) {
			ioEx.printStackTrace();
			throw ioEx;
		} finally {
			try {
				bufferedReader.close();
			} catch (IOException ioEx2) {
				ioEx2.printStackTrace();
				throw ioEx2;
			}
		}

		return contacts;
	}

	public List<Contact> importFromXML(String pathFile) throws ParserConfigurationException, SAXException, IOException {
		List<Contact> contacts = new ArrayList<>();

		DocumentBuilderFactory docBuilderFact = DocumentBuilderFactory.newInstance();
		DocumentBuilder docBuilder = docBuilderFact.newDocumentBuilder();
		Document document = docBuilder.parse(pathFile);

		Element rootElement = document.getDocumentElement();

		List<Element> childElements = FilesUtils.getChildElementsXML(rootElement);

		Contact contact = null;

		for (Element e : childElements) {
			contact = new Contact();

			List<Element> internalTags = FilesUtils.getChildElementsXML(e);
			for (Element tag : internalTags) {
				switch (tag.getNodeName()) {
				case "surname":
					contact.setSurname(tag.getTextContent());
					break;
				case "name":
					contact.setName(tag.getTextContent());
					break;
				case "age":
					contact.setAge(Integer.parseInt(tag.getTextContent()));
					break;
				case "telephone":
					contact.setTelephone(tag.getTextContent());
					break;
				case "email":
					contact.setEmail(tag.getTextContent());
					break;
				case "note":
					contact.setNote(tag.getTextContent());
					break;
				}
			}

			contacts.add(contact);
		}
		return contacts;

	}

//	public List<Contact> importFromDB() {
//		List<Contact> contacts = new ArrayList<>();
//
//		Connection connection = null;
//		Statement statement = null;
//		ResultSet rs = null;
//
//		try {
//			connection = DriverManager.getConnection(CONN_STR, USER, PSW);
//			statement = connection.createStatement();
//
//			rs = statement.executeQuery("SELECT * FROM rubricacompleta");
//
//			while (rs.next()) {
//				Contact contact = new Contact();
//
//				contact.setId(rs.getInt("id"));
//				contact.setSurname(rs.getString("surname"));
//				contact.setName(rs.getString("name"));
//				contact.setAge(rs.getInt("age"));
//				contact.setTelephone(rs.getString("telephone"));
//				contact.setEmail(rs.getString("email"));
//				contact.setNote(rs.getString("note"));
//
//				contacts.add(contact);
//			}
//
//		} catch (SQLException sqlEx) {
//			sqlEx.printStackTrace();
//		} finally {
//			try {
//				rs.close();
//				statement.close();
//				connection.close();
//			} catch (SQLException sqlEx2) {
//				sqlEx2.printStackTrace();
//			}
//
//		}
//
//		return contacts;
//
//	}
}
