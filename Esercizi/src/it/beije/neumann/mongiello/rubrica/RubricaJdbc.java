package it.beije.neumann.mongiello.rubrica;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

public class RubricaJdbc  {

	public static void stampaDb() throws ClassNotFoundException {
		Connection connection = null;
		Statement statement = null; 
		ResultSet rs = null;

		int id ;
		String name = null;
		String surname = null;
		String telephone = null;
		String email = null;
		String note = null;

		try {

			connection = connectionDb();
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

	//legge i dati nel db e li memorizza in un arrayList
	public static List<Contatto> readDb()throws ClassNotFoundException {


		List<Contatto> contatti = new ArrayList<>();
		//		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connection = null;
		Statement statement = null; 
		ResultSet rs = null;

		int id ;
		String name = null;
		String surname = null;
		String telephone = null;
		String email = null;
		String note = null;

		try {

			connection = connectionDb();
			statement = connection.createStatement();
			rs = statement.executeQuery("SELECT id, email, telefono, cognome, nome, note FROM contatti");
			while (rs.next()) {			
				id = rs.getInt("id");
				name = rs.getString("nome");
				surname = rs.getString("cognome");
				email = rs.getString("email");
				telephone = rs.getString("telefono");
				note = rs.getString("note");
				contatti.add( new Contatto( id, name,surname,telephone,email,note ) );
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
		return contatti;
	}

	//memorizza i dati di un arraylist in un databse
//	public static void writeDb( List<Contatto> list ) throws ClassNotFoundException {
//		Connection connection = null;
//		Statement statement = null; 		
//		try {
//			connection = connectionDb();
//			statement = connection.createStatement();
//			for( Contatto c: list ) {
//				statement.executeUpdate("INSERT INTO contatti(nome, cognome, telefono, email) VALUES ('" + c.getName() + "', '" + c.getSurname() + "', '"+c.getTelephone()+"', '"+c.getEmail()+"', '"+c.getNote()+"' )");				
//			}
//		} catch (SQLException sqlEx) {
//			sqlEx.printStackTrace();
//		} finally {
//			try {
//				statement.close();
//				connection.close();	
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//		}
//
//	}

	public static void writeContatto( Contatto c ) throws ClassNotFoundException {

		Connection connection = null;
		Statement statement = null; 		
		try {
			connection = connectionDb();
			//	statement = connection.createStatement();
			//	statement.executeUpdate("INSERT INTO contatti(nome, cognome, telefono, email, note) VALUES ('" + c.getName() + "', '" + c.getSurname() + "', '"+c.getTelephone()+"', '"+c.getEmail()+"', '"+c.getNote()+"' )");			
			PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO contatti(nome, cognome, telefono, email, note) VALUES (?,?,?,?,?)");
			preparedStatement.setString(1,c.getName());
			preparedStatement.setString(2,c.getSurname());
			preparedStatement.setString(3,c.getTelephone());
			preparedStatement.setString(4,c.getEmail());
			preparedStatement.setString(5,c.getNote());
			preparedStatement.executeUpdate();
		} catch (SQLException sqlEx) {
			sqlEx.printStackTrace();
		} finally {
			try {
				connection.close();	
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	public static Connection connectionDb() throws ClassNotFoundException {

		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connection = null;


		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/neumann?serverTimezone=CET&useSSL=false", "root", "root");

		} catch (SQLException sqlEx) {
			sqlEx.printStackTrace();	
		}

		return connection;
	}



	public static void search(String surname) throws ClassNotFoundException {


		List<Contatto> contatti = new ArrayList<>();
		Connection connection = null;
		Statement statement = null; 
		ResultSet rs = null;

		int id ;
		String name = null;

		String telephone = null;
		String email = null;
		String note = null;

		try {
			connection = connectionDb();
			//statement = connection.createStatement();
			//rs = statement.executeQuery("SELECT id, email, telefono, cognome, nome, note FROM contatti WHERE cognome = '"+surname+"'  ");
			PreparedStatement preparedStatement = connection.prepareStatement("SELECT id, email, telefono, cognome, nome, note FROM contatti WHERE cognome = ?");
			preparedStatement.setString(1, surname);
			rs = preparedStatement.executeQuery();
			
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
				connection.close();

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}


	}

	public static void editDb(int id, String fieldToEdit, String newField) throws ClassNotFoundException {

		Connection connection = null;
		Statement statement = null; 	
		ResultSet rs = null;
		try {
			connection = connectionDb();
			//statement = connection.createStatement();
			//statement.executeUpdate("UPDATE contatti SET "+fieldToEdit+" = '"+newField+"' WHERE id = '"+id+"'");
			StringBuilder qr = new StringBuilder();
			qr.append("Update contatti SET ");
			qr.append(fieldToEdit);
			PreparedStatement preparedStatement = connection.prepareStatement(qr.toString()+"=? WHERE id = ?");
			preparedStatement.setString(1, newField);
			preparedStatement.setInt(2, id);
			preparedStatement.executeUpdate();
		} catch (SQLException sqlEx) {
			sqlEx.printStackTrace();
		} finally {
			try {
			
				connection.close();	
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	public static void deleteContact(int id) throws ClassNotFoundException {
		Connection connection = null;
		Statement statement = null; 		
		try {
			connection = connectionDb();
			//statement = connection.createStatement();
			//statement.executeUpdate("DELETE FROM contatti WHERE id = '"+id+"'");

			PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM contatti WHERE id =?");
			preparedStatement.setInt(1, id);
			preparedStatement.executeUpdate();
			

		} catch (SQLException sqlEx) {
			sqlEx.printStackTrace();
		} finally {
			try {
			
				connection.close();	
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	public static void order(String valore) throws ClassNotFoundException {
		Connection connection = null;
		
		ResultSet rs = null;
		try {
			connection = connectionDb();
			StringBuilder qr = new StringBuilder("Select * FROM contatti ORDER BY ");
			PreparedStatement preparedStatement = connection.prepareStatement(qr+valore);
			rs = preparedStatement.executeQuery();
			
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

				connection.close();	
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void exportCsv() throws  ClassNotFoundException, IOException {

			Connection connection = null;
			ResultSet rs = null;
			
			File file = new File("/temp/export.csv");
			FileWriter fileWriter = new FileWriter(file);
			
			fileWriter.write("id;cognome;nome;telefono;email;note");
			fileWriter.write("\n");
			
			try {
				connection = connectionDb();
				PreparedStatement preparedStatement = connection.prepareStatement("Select * FROM contatti");
				rs = preparedStatement.executeQuery();
				
				while (rs.next()) {	
					
//					System.out.println("id : " + rs.getInt("id"));
//					System.out.println("cognome : " + rs.getString("cognome"));
//					System.out.println("nome : " + rs.getString("nome"));
//					System.out.println("email : " + rs.getString("email"));
//					System.out.println("telefono : " + rs.getString("telefono"));
//					System.out.println("note : " + rs.getString("note"));
//					System.out.println("--------");				
									
					fileWriter.write(rs.getString("id"));
					fileWriter.write(";");
					fileWriter.write(  Check.isNull(rs.getString("cognome")));
					fileWriter.write(";");
					fileWriter.write( Check.isNull(rs.getString("nome")));
					fileWriter.write(";");
					fileWriter.write( Check.isNull(rs.getString("telefono")));
					fileWriter.write(";");
					fileWriter.write( Check.isNull(rs.getString("email")));
					fileWriter.write(";");
					fileWriter.write( Check.isNull(rs.getString("note")));
					fileWriter.write("\n");
				}
			}catch(NullPointerException npEx) {
						
			} catch (SQLException sqlEx) {
				sqlEx.printStackTrace();
			} finally {
				try {
					connection.close();	
				} catch (SQLException e) {
					e.printStackTrace();
				}
				fileWriter.flush();
			}

		

	}

	
	public static void exportXml() throws ClassNotFoundException, ParserConfigurationException, TransformerException  {

		Connection connection = null;
		ResultSet rs = null;
		
		DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
		Document document = documentBuilder.newDocument();
		
		Element documentElement = document.createElement("rubrica");
		document.appendChild(documentElement);
		
		try {
			connection = connectionDb();
			PreparedStatement preparedStatement = connection.prepareStatement("Select * FROM contatti");
			rs = preparedStatement.executeQuery();
			
			while(rs.next()) {
				Element contatto = document.createElement("contatto");
				documentElement.appendChild(contatto);
				
				Element id = document.createElement("id");
				id.setTextContent(rs.getString("id") );
				contatto.appendChild(id);
				
				Element surname = document.createElement("cognome");
				surname.setTextContent(Check.isNull(rs.getString("cognome")) );
				contatto.appendChild(surname);
				
				Element name = document.createElement("nome");
				name.setTextContent(Check.isNull(rs.getString("nome")) );
				contatto.appendChild(name);
				
				Element telephone = document.createElement("telefono");
				telephone.setTextContent(Check.isNull(rs.getString("telefono")) );
				contatto.appendChild(telephone);
				
				Element email = document.createElement("email");
				email.setTextContent(Check.isNull(rs.getString("email")) );
				contatto.appendChild(email);
				
				Element note = document.createElement("note");
				note.setTextContent(Check.isNull(rs.getString("cognome")));
				contatto.appendChild(note);
			}
			
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(document);
			
			StreamResult result = new StreamResult(new File("/temp/export.xml"));

			// Output to console for testing
			StreamResult syso = new StreamResult(System.out);

			transformer.transform(source, result);
		//	transformer.transform(source, syso);
		

		} catch (SQLException sqlEx) {
			sqlEx.printStackTrace();
		} finally {
			try {
				connection.close();	
			} catch (SQLException e) {
				e.printStackTrace();
			}


		}
	}

	public static void importCsv() throws IOException, ClassNotFoundException, SQLException {

		Connection connection = null;
		ResultSet rs = null;
		String separator = ";";
		File file = new File("/temp/export.csv");
		FileReader fileReader = new FileReader(file);
		BufferedReader bufferedReader = new BufferedReader(fileReader);
			try {
			connection = connectionDb();
			String r = null;
			String rigaIntestazione = null;
			String[] fields = null;
			
			String[] dynamicFields = null;
			String surname = null;
			String name = null;
			String telephone = null;
			String email = null;
			String note = null;
			while( bufferedReader.ready() ) {
				r = bufferedReader.readLine();
				if(r.equalsIgnoreCase("id"+separator +"cognome"+separator +"nome"+separator+"telefono"+separator +"email"+separator+"note")) continue;
				
				fields = r.split(separator, -1);
				PreparedStatement preparedStatement = null;
				if(fields[0] == "") {
					preparedStatement = connection.prepareStatement("INSERT INTO contatti( cognome, nome, telefono, email, note) VALUES (?,?,?,?,?)");
					
					preparedStatement.setString(1,fields[1]);
					preparedStatement.setString(2,fields[2]);
					preparedStatement.setString(3,fields[3]);
					preparedStatement.setString(4,fields[4]);
					preparedStatement.setString(5,fields[5]);
				}else {
						 preparedStatement = connection.prepareStatement("INSERT INTO contatti(id, cognome, nome, telefono, email, note) VALUES (?,?,?,?,?,?)");
						preparedStatement.setString(1,fields[0]);
						preparedStatement.setString(2,fields[1]);
						preparedStatement.setString(3,fields[2]);
						preparedStatement.setString(4,fields[3]);
						preparedStatement.setString(5,fields[4]);
						preparedStatement.setString(6,fields[5]);
					}
					preparedStatement.executeUpdate();
				
			}

		} finally {
			try {
				connection.close();	
			} catch (SQLException e) {
				e.printStackTrace();
			}
			

		}
	}


	public static void importXml() throws SQLException, SAXException, IOException, ParserConfigurationException, ClassNotFoundException {
		
		Connection connection = null;
		ResultSet rs = null;
		
		File file = new File("/temp/export.xml");
		
		DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
		Document document = documentBuilder.parse(file);
		
		Element rootElement = document.getDocumentElement();		
		List<Element> elements = RubricaXml.getChildElements(rootElement);
		
		String id = null;
		String name = null;
		String surname = null;
		String telephone = null;
		String email = null;
		String note = null;
		
		
		try {
			connection = connectionDb();
			PreparedStatement preparedStatement = null;
		for (Element el : elements) {
			List<Element> values = RubricaXml.getChildElements(el);
			for (Element v : values) {
				switch (v.getNodeName()) {
				case "id":
					id = v.getTextContent();
					break;
				case "cognome":
					surname = v.getTextContent();
					break;
				case "nome":
					name = v.getTextContent();
					break;
				case "telefono":
					telephone = v.getTextContent();
					break;
				case "email":
					email = v.getTextContent();
					break;
				case "note":
					note = v.getTextContent();
					break;
				}
//				if(id == "") {
//					preparedStatement = connection.prepareStatement("INSERT INTO contatti( cognome, nome, telefono, email, note) VALUES (?,?,?,?,?)");
//					
//					preparedStatement.setString(1,surname);
//					preparedStatement.setString(2,name);
//					preparedStatement.setString(3,telephone);
//					preparedStatement.setString(4,email);
//					preparedStatement.setString(5,note);
//				}else {
//						 preparedStatement = connection.prepareStatement("INSERT INTO contatti(id, cognome, nome, telefono, email, note) VALUES (?,?,?,?,?,?)");
//						preparedStatement.setString(1,id);
//						preparedStatement.setString(2,surname);
//						preparedStatement.setString(3,name);
//						preparedStatement.setString(4,telephone);
//						preparedStatement.setString(5,email);
//						preparedStatement.setString(6,note);
//					}
//					preparedStatement.executeUpdate();
			
			}
			preparedStatement = connection.prepareStatement("INSERT INTO contatti( cognome, nome, telefono, email, note) VALUES (?,?,?,?,?)");
			preparedStatement.setString(1,surname);
			preparedStatement.setString(2,name);
			preparedStatement.setString(3,telephone);
			preparedStatement.setString(4,email);
			preparedStatement.setString(5,note);
			preparedStatement.executeUpdate();
		}
		
	} finally {
		try {
			connection.close();	
		} catch (SQLException e) {
			e.printStackTrace();
		}


	}
}
}






