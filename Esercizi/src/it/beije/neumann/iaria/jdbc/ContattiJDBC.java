package it.beije.neumann.iaria.jdbc;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
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

import it.beije.neumann.iaria.rubrica.Contatto;

public class ContattiJDBC {
	
	//Metodo che legge db
	public static void leggiContatti() throws ClassNotFoundException {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection connection = null;
		Statement statement = null; 
		ResultSet rs = null;
				
		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/neumann?serverTimezone=CET&useSSL=false", "root", "beije2023");
			statement = connection.createStatement();
		
			rs = statement.executeQuery("SELECT id, email, telefono, cognome, nome, note FROM contatti");
			while (rs.next()) {
				System.out.println("id : " + rs.getInt("id"));
				System.out.println("cognome : " + rs.getString("cognome"));
				System.out.println("nome : " + rs.getString("nome"));
				System.out.println("email : " + rs.getString("email"));
				System.out.println("telefono : " + rs.getString("telefono"));
				System.out.println("note : " + rs.getString("note"));
				System.out.println("--------");
			}
			
		} catch (SQLException sqlEx) {
			sqlEx.printStackTrace();
		} finally {
			try {
				rs.close();
				statement.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	//Metodo che importa il file csv su db
	public static void importaContattiCSV(String pathFile, String separator) throws FileNotFoundException, IOException, ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connection = null;
		Statement statement = null; 
		int righeInserite = 0;
		
		FileReader fileReader = new FileReader(pathFile);
		BufferedReader bufferedReader = new BufferedReader(fileReader);
		
		try {
			String r = null;
			String[] fields = null;
			Contatto contatto = null;
			
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/neumann?serverTimezone=CET&useSSL=false", "root", "beije2023");			
			statement = connection.createStatement();
			
			while (bufferedReader.ready()) {
				r = bufferedReader.readLine();
				fields = r.split(separator);
				
				righeInserite++;
				contatto = new Contatto();
				contatto.setSurname(fields[0]);
				contatto.setName(fields[1]);
				contatto.setTelephone(fields[2]);
				contatto.setEmail(fields[3]);
				contatto.setNote(fields[4]);	
				
				//Se si trova alla seconda riga (quindi salto NOME;COGNOME;TELEFONO;EMAIL;NOTE)
				if(righeInserite > 1) {
					//INSERT
					statement.executeUpdate("INSERT INTO contatti(nome, cognome, telefono, email, note) VALUES ('" + contatto.getName() + "', '" + contatto.getSurname() + "', '" + contatto.getTelephone() + "', '" + contatto.getEmail() + "', '" + contatto.getNote() + "')");
				}
				
				//UPDATE
				/*statement.executeUpdate("UPDATE contatti SET nome = NULL WHERE nome = ''");
				statement.executeUpdate("UPDATE contatti SET cognome = NULL WHERE cognome = ''");
				statement.executeUpdate("UPDATE contatti SET telefono = NULL WHERE telefono = ''");
				statement.executeUpdate("UPDATE contatti SET email = NULL WHERE email = ''");
				statement.executeUpdate("UPDATE contatti SET note = NULL WHERE note = ''");*/
				statement.executeUpdate("UPDATE contatti set nome = case when nome in('null','') then null else nome end, cognome = case when cognome in('null','') then null else cognome end, telefono = case when telefono in('null','') then null else telefono end, email = case when email in('null','') then null else email end, note = case when note in('null','') then null else note end");
				
			}
			
			//Salto NOME;COGNOME;TELEFONO;EMAIL;NOTE togliendo 1 da righeInserite che contiene il numero di cicli effettuati
			System.out.println("Sono state inserite "+ (righeInserite-1) +" righe");
			
		} catch (SQLException sqlEx) {
			sqlEx.printStackTrace();
		} catch (IOException ioEx) {
			ioEx.printStackTrace();
			throw ioEx;
		} finally {
			bufferedReader.close();
			try {
				statement.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}	
		}
	}

	//Per poi leggere dati .XML
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
	public static void importaContattiXML(String pathFile, String separator) throws ParserConfigurationException, IOException, SAXException, ClassNotFoundException{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connection = null;
		Statement statement = null; 
		int righeInserite = 0;
		
		DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
		Document document = documentBuilder.parse(pathFile);		
		Element rootElement = document.getDocumentElement();
		List<Element> elements = getChildElements(rootElement);
		
		
		try {
			
			Contatto contatto = null;
			
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/neumann?serverTimezone=CET&useSSL=false", "root", "beije2023");			
			statement = connection.createStatement();
			
			for (Element el : elements) {
				righeInserite++;
				contatto = new Contatto();
				
				List<Element> values = getChildElements(el);
	
				//Leggo in verticale
				for (Element v : values) {
					String valore = v.getNodeName().toLowerCase(); //Prendo il nome del nodo in minuscolo per confrontarlo
	
					switch (valore) {
					case "nome":
						contatto.setName(v.getTextContent());
						break;
					case "cognome":
						contatto.setSurname(v.getTextContent());
						break;
					case "note":
						contatto.setNote(v.getTextContent());
						break;
					case "telefono":
						contatto.setTelephone(v.getTextContent());
						break;
					}
				}
				//INSERT
				statement.executeUpdate("INSERT INTO contatti(nome, cognome, telefono, email, note) VALUES ('" + contatto.getName() + "', '" + contatto.getSurname() + "', '" + contatto.getTelephone() + "', '" + contatto.getEmail() + "', '" + contatto.getNote() + "')");
			}
			//UPDATE
			statement.executeUpdate("UPDATE contatti set nome = case when nome in('null','') then null else nome end, cognome = case when cognome in('null','') then null else cognome end, telefono = case when telefono in('null','') then null else telefono end, email = case when email in('null','') then null else email end, note = case when note in('null','') then null else note end");
			System.out.println("Sono state inserite "+righeInserite+" righe");
		} catch (SQLException sqlEx) {
			sqlEx.printStackTrace();
		} finally {
			try {
				statement.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}	
		}		
	}
	
	//Metodo che esporta dati db su csv
	public static void writeRubricaCSV(String pathFile, String separator) throws IOException, ClassNotFoundException, SQLException{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connection = null;
		Statement statement = null; 
		ResultSet rs = null;
		File rubrica = new File(pathFile);
		boolean exists = rubrica.exists(); //File esiste
		FileWriter fileWriter = new FileWriter(pathFile, true);
		int righeInserite = 0;
		
		try {
			
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/neumann?serverTimezone=CET&useSSL=false", "root", "beije2023");			
			statement = connection.createStatement();
			
			if(!exists) {//Creo la prima riga con NOME-COGNOME-NOTE-TELEFONO se il file non esiste
				fileWriter.write("COGNOME" + separator);
				fileWriter.write("NOME" + separator);
				fileWriter.write("TELEFONO" + separator);
				fileWriter.write("EMAIL" + separator);
				fileWriter.write("NOTE" + "\n");
			}
			
			//Prendo i dati dal db
			rs = statement.executeQuery("SELECT id, email, telefono, cognome, nome, note FROM contatti");
			while (rs.next()) {
				righeInserite++;
				fileWriter.write(rs.getString("cognome") + separator);
				fileWriter.write(rs.getString("nome") + separator);
				fileWriter.write(rs.getString("email") + separator);
				fileWriter.write(rs.getString("telefono") + separator);
				fileWriter.write(rs.getString("note") + "\n");
			}
			System.out.println("Sono state inserite "+righeInserite+" righe");

		} catch (SQLException sqlEx) {
			sqlEx.printStackTrace();
		} finally {
			fileWriter.close(); //Chiudo il file e salvo le modifiche
			try {
				statement.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}	
		}	
	}
	
	public static void main(String[] args) throws ClassNotFoundException, FileNotFoundException, IOException, ParserConfigurationException, SAXException, SQLException {
		
		String pathForCSV = "/Users/gianf/Desktop/rubrica.csv";
		String pathForXml = "/Users/gianf/Desktop/rubrica.xml";
		String separator = ";";
		//importaContattiCSV(pathForCSV,separator);
		//importaContattiXML(pathForXml, separator);
		writeRubricaCSV(pathForCSV,separator);
		
		//leggiContatti();
				


	}

}