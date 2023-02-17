package it.beije.neumann.rubrica;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class RubricaJDBC {

	public static void main(String[] args) throws ClassNotFoundException, IOException, SAXException, ParserConfigurationException, TransformerException {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection connection = null;
		Statement statement = null; 
		ResultSet rs = null;
				
		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/neumann?serverTimezone=CET&useSSL=false", "root", "root");
			//System.out.println(connection.isClosed());
			
			statement = connection.createStatement();
			
			//INSERT
			//statement.executeUpdate("INSERT INTO contatti(nome, cognome, telefono, email) VALUES ('Bianchi', 'Roberta', '325235252', 'r.bianchi@beije.it')");
//			String nome = "Marianna";
//			String cognome = "Viola";
//			statement.executeUpdate("INSERT INTO contatti(nome, cognome, telefono, email) VALUES ('" + nome + "', '" + cognome + "', '325235252', 'r.bianchi@beije.it')");
			
			//UPDATE
//			int rows = statement.executeUpdate("UPDATE contatti SET note = 'siamo Bianchi' WHERE cognome = 'Bianchi'");
//			System.out.println("rows updated : " + rows);
			
			//DELETE
//			rows = statement.executeUpdate("DELETE FROM contatti WHERE cognome = 'Roberta'");
//			System.out.println("rows updated : " + rows);
			
			//SELECT
//			statement.execute("SELECT id, email, telefono, cognome, nome, note FROM contatti");
//			ResultSet rs = statement.getResultSet();
			rs = statement.executeQuery("SELECT id, email, telefono, cognome, nome, note FROM contatti");
			while (rs.next()) {
//				System.out.println("id : " + rs.getInt(1));
//				System.out.println("cognome : " + rs.getString(3));
//				System.out.println("nome : " + rs.getString(4));
//				System.out.println("email : " + rs.getString(2));
//				System.out.println("telefono : " + rs.getString(4));
//				System.out.println("note : " + rs.getString(6));
				System.out.println("id : " + rs.getInt("id"));
				System.out.println("cognome : " + rs.getString("cognome"));
				System.out.println("nome : " + rs.getString("nome"));
				System.out.println("email : " + rs.getString("email"));
				System.out.println("telefono : " + rs.getString("telefono"));
				System.out.println("note : " + rs.getString("note"));
				System.out.println("--------");
				

				importContactsCSV("VonNeumann/src/it/beije/neumann/rubrica/rubrica.csv", connection);
				exportContactsCSV("exportRubricaCSV", connection);
				importContactsXML("VonNeumann/src/it/beije/neumann/rubrica/rubrica.csv", connection);
				exportContactsXML("exportRubricaXML", connection);
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
	
	public static void importContactsCSV(String filePath, Connection conn) throws SQLException, IOException {

	    Statement statement = conn.createStatement();
	    
	    BufferedReader reader = new BufferedReader(new FileReader(filePath));
	    String line;
	    while ((line = reader.readLine()) != null) {
	    	
	        String[] values = line.split(",");
	        String nome = values[0];
	        String cognome = values[1];
	        String telefono = values[2];
	        String email = values[3];
	        String note = values[4];
	        
	        
	        statement.executeUpdate("INSERT INTO contacts (nome, cognome, telefono, email, note) VALUES ('" + nome + "', '" + cognome + "'  ,'" + telefono + "', '" + email + "', '"+ note +"')");
	    }
	    
	    statement.close();
	    reader.close();
	}
	
	public static void exportContactsCSV(String filePath, Connection conn) {
		
		try {
            String sql = "SELECT * FROM contatti";
             
            Statement statement = conn.createStatement();
             
            ResultSet result = statement.executeQuery(sql);
             
            BufferedWriter fileWriter = new BufferedWriter(new FileWriter(filePath));
                
            fileWriter.write("nome,cognome,telefono,email,note");
             
            while (result.next()) {
                String contactName = result.getString("nome");
                String contactLastName = result.getString("cognome");
                String contactPhone = result.getString("telefono");
                String contactEmail = result.getString("email");
                String contactNote = result.getString("note");
                
                 
                
                String line = String.format("%s,%s,%s,%s,%s",
                        contactName, contactLastName, contactPhone, contactEmail, contactNote);
                 
                fileWriter.newLine();
                fileWriter.write(line);            
            }
             
            statement.close();
            fileWriter.close();
             
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
		
	}

	public static void importContactsXML(String filePath, Connection conn) throws SQLException, IOException, SAXException, ParserConfigurationException {

	    Statement statement = conn.createStatement();

	    DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
	    DocumentBuilder builder = factory.newDocumentBuilder();
	    Document document = builder.parse(new File(filePath));

	    NodeList contacts = document.getElementsByTagName("contatti");

	    for (int i = 0; i < contacts.getLength(); i++) {

	        Element contact = (Element) contacts.item(i);

	        String nome = contact.getElementsByTagName("nome").item(0).getTextContent();
	        String cognome = contact.getElementsByTagName("cognome").item(0).getTextContent();
	        String telefono = contact.getElementsByTagName("telefono").item(0).getTextContent();
	        String email = contact.getElementsByTagName("email").item(0).getTextContent();
	        String note = contact.getElementsByTagName("note").item(0).getTextContent();

	        statement.executeUpdate("INSERT INTO contacts (nome, cognome, telefono, email, note) VALUES ('" + nome + "', '" + cognome + "'  ,'" + telefono + "', '" + email + "', '"+ note +"')");
	    }

	    statement.close();
	}
	
	public static void exportContactsXML(String filePath, Connection conn) throws SQLException, IOException, ParserConfigurationException, TransformerException {

	    Statement statement = conn.createStatement();
	    ResultSet result = statement.executeQuery("SELECT * FROM contatti");

	    DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
	    DocumentBuilder builder = factory.newDocumentBuilder();
	    Document document = builder.newDocument();

	    Element rootElement = document.createElement("contatti");
	    document.appendChild(rootElement);

	    while (result.next()) {

	        Element contact = document.createElement("contact");
	        rootElement.appendChild(contact);

	        Element nome = document.createElement("nome");
	        nome.appendChild(document.createTextNode(result.getString("nome")));
	        contact.appendChild(nome);

	        Element cognome = document.createElement("cognome");
	        cognome.appendChild(document.createTextNode(result.getString("cognome")));
	        contact.appendChild(cognome);

	        Element telefono = document.createElement("telefono");
	        telefono.appendChild(document.createTextNode(result.getString("telefono")));
	        contact.appendChild(telefono);

	        Element email = document.createElement("email");
	        email.appendChild(document.createTextNode(result.getString("email")));
	        contact.appendChild(email);

	        Element note = document.createElement("note");
	        note.appendChild(document.createTextNode(result.getString("note")));
	        contact.appendChild(note);
	    }

	    statement.close();
	    result.close();

	    TransformerFactory transformerFactory = TransformerFactory.newInstance();
	    Transformer transformer = transformerFactory.newTransformer();
	    DOMSource source = new DOMSource(document);
	    StreamResult file = new StreamResult(new File(filePath));
	    transformer.transform(source, file);
	}
}


