package it.beije.neumann.rubrica.iaria_gestore_rubrica_jdbc;

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
import java.util.Scanner;

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


public class GestoreDiRubricaJDBC {
	
	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/neumann?serverTimezone=CET&useSSL=false", "root", "beije2023");
	}
	
	//Metodo che legge db
	public void vediListaContatti() throws ClassNotFoundException, SQLException {

		Connection connection = null;
		Statement statement = null; 
		ResultSet rs = null;
				
		try {
			connection = getConnection();
			statement = connection.createStatement();
		
			PreparedStatement preparedStatement = connection.prepareStatement("SELECT id, email, telefono, cognome, nome, note FROM contatti");
			rs = preparedStatement.executeQuery();
			while (rs.next()) {
				System.out.println("id : " + rs.getInt("id"));
				System.out.println("cognome : " + rs.getString("cognome"));
				System.out.println("nome : " + rs.getString("nome"));
				System.out.println("email : " + rs.getString("email"));
				System.out.println("telefono : " + rs.getString("telefono"));
				System.out.println("note : " + rs.getString("note"));
				System.out.println("------------------");
			}
			
		} catch (ClassNotFoundException cnfEx) {
			cnfEx.printStackTrace(); 
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
	
	//Metodo che cerca contatto corrispondente
	public void cercaContatto() throws ClassNotFoundException, SQLException {
		
		String stringaContatto = "Esito: ";
		int riga = 0;
		int count = 0;
		boolean confronto;
		
		Connection connection = null;
		Statement statement = null; 
		ResultSet rs = null;
		
		System.out.println("Inserisci i dati da cercare:");
		Scanner s = new Scanner(System.in);	
		System.out.println("Nome:");
		String nomeScanner = s.nextLine();
		System.out.println("Cognome:");
		String cognomeScanner = s.nextLine();
		System.out.println();
		
		try {
			connection = getConnection();
			statement = connection.createStatement();
			
			PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM contatti");
			rs = preparedStatement.executeQuery();
			while (rs.next()) {
				riga++;//Conteggio le rige ogni iterazione per poi stampare la corrispondente
				
				//Confronta i fields
				if(!nomeScanner.isEmpty() && !cognomeScanner.isEmpty()) { //Se il nome ed il cognome non sono nulli
					if(nomeScanner.contains(rs.getString("nome")) && cognomeScanner.contains(rs.getString("cognome"))) { //E contiene corrispondente del db
						count++;
						System.out.println("Contatto trovato alla riga "+riga+":\n"
								+ "id : " + rs.getInt("id")+"\n"
								+ "cognome : " + rs.getString("cognome")+"\n"
								+ "nome : " + rs.getString("nome")+"\n"
								+ "email : " + rs.getString("email")+"\n"
								+ "telefono : " + rs.getString("telefono")+"\n"
								+ "note : " + rs.getString("note")+"\n"
								+ "------------------");
					}
				} else if(nomeScanner.isEmpty() || cognomeScanner.isEmpty()){
					if(nomeScanner.contains(rs.getString("nome")) || cognomeScanner.contains(rs.getString("cognome"))) { //E contiene corrispondente del db
						count++;
						System.out.println("Contatto trovato alla riga "+riga+":\n"
								+ "id : " + rs.getInt("id")+"\n"
								+ "cognome : " + rs.getString("cognome")+"\n"
								+ "nome : " + rs.getString("nome")+"\n"
								+ "email : " + rs.getString("email")+"\n"
								+ "telefono : " + rs.getString("telefono")+"\n"
								+ "note : " + rs.getString("note")+"\n"
								+ "------------------");
					}
				} else if(nomeScanner.isEmpty() && cognomeScanner.isEmpty()) {
					System.out.println("Non puoi lasciare entrambi i campi vuoti!");
					break;
				}
			}
			
			/*Se alla fine del ciclo, count è 0, vuol dire che non c'è stata corrispondenza
			quindi stampa "Nessuna corrispondenza trovata"*/
			if(count==0) {
				System.out.println("Nessuna corrispondenza trovata");
			}
			
		} catch (ClassNotFoundException cnfEx) {
			cnfEx.printStackTrace(); 
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
	
	//Metodo che chiede all'utente i dati per creare un nuovo contatto e lo inserisce nel db
	public void creaNuovoContatto() throws ClassNotFoundException, SQLException{
		
		Connection connection = null;
		Statement statement = null; 
		
		try {
			connection = getConnection();
			statement = connection.createStatement();
		
			System.out.println("Inserisci il contatto:");
			Scanner s = new Scanner(System.in);
			
			Contatto contattoInput = new Contatto();
			
			System.out.print("Nome: ");
			contattoInput.setName(s.nextLine());
			
			System.out.print("Cognome: ");
			contattoInput.setSurname(s.nextLine());
			
			System.out.print("Telefono: ");
			contattoInput.setTelephone(s.nextLine());
			
			System.out.print("Email: ");
			contattoInput.setEmail(s.nextLine());
				
			System.out.print("Note: ");
			contattoInput.setNote(s.nextLine());
				
			System.out.println("Contatto salvato con successo!");
			
			//INSERT
			PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO contatti(nome, cognome, telefono, email, note) VALUES (?, ?, ?, ?, ?)");//('" + contattoInput.getName() + "', '" + contattoInput.getSurname() + "', '" + contattoInput.getTelephone() + "', '" + contattoInput.getEmail() + "', '" + contattoInput.getNote() + "')");
			preparedStatement.setString(1, contattoInput.getName());
			preparedStatement.setString(2, contattoInput.getSurname());
			preparedStatement.setString(3, contattoInput.getTelephone());
			preparedStatement.setString(4, contattoInput.getEmail());
			preparedStatement.setString(5, contattoInput.getNote());
			int row = preparedStatement.executeUpdate();
			
			//UPDATE IN CASO DI VALORI VUOTI
			preparedStatement = connection.prepareStatement("UPDATE contatti set nome = case when nome in('null','') then null else nome end, cognome = case when cognome in('null','') then null else cognome end, telefono = case when telefono in('null','') then null else telefono end, email = case when email in('null','') then null else email end, note = case when note in('null','') then null else note end");
			row = preparedStatement.executeUpdate();
			
		} catch (ClassNotFoundException cnfEx) {
			cnfEx.printStackTrace(); 
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
	
	//Metodo che modifica un contatto
	public void modificaContatto() throws ClassNotFoundException, SQLException {
		
		Connection connection = null;
		Statement statement = null; 
		ResultSet rs = null;
		int row;
		
		System.out.println("Contatti: ");
		vediListaContatti();
		System.out.println("Inserisci l'id della riga da modificare: ");
		Scanner s = new Scanner(System.in);
		int numeroIdScanner = s.nextInt();
		System.out.println();
		
		//Faccio inserire all'utente i dati da sostituire
		System.out.println("id: ");
		s = new Scanner(System.in);
		String id = s.nextLine();
		System.out.println("Nome: ");
		s = new Scanner(System.in);
		String nome = s.nextLine();
		System.out.println("Cognome: ");
		s = new Scanner(System.in);
		String cognome = s.nextLine();
		System.out.println("Email: ");
		s = new Scanner(System.in);
		String email = s.nextLine();
		System.out.println("Telefono: ");
		s = new Scanner(System.in);
		String telefono = s.nextLine();
		System.out.println("Note: ");
		s = new Scanner(System.in);
		String note = s.nextLine();
		System.out.println();
	
		try {
			
			connection = getConnection();
			statement = connection.createStatement();
			
			PreparedStatement preparedStatement = connection.prepareStatement("SELECT id, email, telefono, cognome, nome, note FROM contatti");
			rs = preparedStatement.executeQuery();
			while (rs.next()) {
				PreparedStatement preparedStatement2 = connection.prepareStatement("UPDATE contatti SET id = ?, email = ?, telefono = ?, cognome = ?, nome = ?, note = ? WHERE id = ?");
				
				//Inserisco i dati dell'utente alla query
				preparedStatement2.setString(1, id);
				preparedStatement2.setString(2, email);
				preparedStatement2.setString(3, telefono);
				preparedStatement2.setString(4, cognome);
				preparedStatement2.setString(5, nome);
				preparedStatement2.setString(6, note);
				preparedStatement2.setInt(7, numeroIdScanner);
				
				row = preparedStatement2.executeUpdate();
			}
			
			//UPDATE IN CASO DI VALORI VUOTI
			PreparedStatement preparedStatement3 = connection.prepareStatement("UPDATE contatti set nome = case when nome in('null','') then null else nome end, cognome = case when cognome in('null','') then null else cognome end, telefono = case when telefono in('null','') then null else telefono end, email = case when email in('null','') then null else email end, note = case when note in('null','') then null else note end");
			row = preparedStatement3.executeUpdate();
		
		} catch (ClassNotFoundException cnfEx) {
			cnfEx.printStackTrace(); 
		} catch (SQLException sqlEx) {
			sqlEx.printStackTrace();
		} finally {
			try {
				statement.close();
				rs.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	//Metodo che elimina un contatto
	public void eliminaContatto() throws ClassNotFoundException, SQLException{
		
		Connection connection = null;
		Statement statement = null; 
		ResultSet rs = null;
		int row;
	
		System.out.println("Contatti: ");
		vediListaContatti();
		System.out.println("Inserisci l'id della riga da eliminare: ");
		Scanner s = new Scanner(System.in);
		int numeroIdScanner = s.nextInt();
		System.out.println();
		
		try {
			
			connection = getConnection();
			statement = connection.createStatement();
			
			PreparedStatement preparedStatement = connection.prepareStatement("SELECT id, email, telefono, cognome, nome, note FROM contatti");
			rs = preparedStatement.executeQuery();
			while (rs.next()) {
				
				PreparedStatement preparedStatement2 = connection.prepareStatement("DELETE FROM contatti WHERE id = ?");
				preparedStatement2.setInt(1, numeroIdScanner);				
				row = preparedStatement2.executeUpdate();
				
			}
			
		} catch (ClassNotFoundException cnfEx) {
			cnfEx.printStackTrace(); 
		} catch (SQLException sqlEx) {
			sqlEx.printStackTrace();
		} finally {
			try {
				statement.close();
				rs.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	//Metodo che trova duplicati
	public void trovaDuplicati() throws ClassNotFoundException, SQLException{
		List<Contatto> contatti = new ArrayList<>();
		Connection connection = null;
		Statement statement = null; 
		ResultSet rs = null;
		ResultSet rs2 = null;
		int rigaLetta = 0;
		int rigaLetta2 = 0;
		int duplicatiTrovati = 0;
		
		try {
			
			connection = getConnection();
			statement = connection.createStatement();
			
			Contatto contatto = null;
			String distingui = "";
			int count = 0;
			
			PreparedStatement preparedStatement = connection.prepareStatement("SELECT id, email, telefono, cognome, nome, note FROM contatti");
			rs = preparedStatement.executeQuery();
			while (rs.next()) {
				contatto = new Contatto();
				contatto.setId(rs.getInt("id"));
				contatto.setEmail(rs.getString("email"));
				contatto.setTelephone(rs.getString("telefono"));
				contatto.setSurname(rs.getString("cognome"));
				contatto.setName(rs.getString("nome"));
				contatto.setNote(rs.getString("note"));
				contatti.add(contatto);
			}
			
			PreparedStatement preparedStatement2 = connection.prepareStatement("SELECT cognome, nome FROM contatti");
			rs2 = preparedStatement2.executeQuery();
			while(rs2.next()) {
				rigaLetta++;
				for(Contatto contattiLetti : contatti) {
					rigaLetta2++;
					if(rigaLetta != rigaLetta2) {
						if(contattiLetti.getSurname().contains(rs2.getString("cognome")) && contattiLetti.getName().contains(rs2.getString("nome"))) {
							duplicatiTrovati++;
							System.out.println(contattiLetti.getName()+" "+contattiLetti.getSurname()+" ha un duplicato alla riga: "+rigaLetta2);
						}
					}
				}
				System.out.println();
				rigaLetta2 = 0; 
				if(duplicatiTrovati != 0) {
					duplicatiTrovati = 0;
				}
			}

		} catch (ClassNotFoundException cnfEx) {
			cnfEx.printStackTrace(); 
		} catch (SQLException sqlEx) {
			sqlEx.printStackTrace();
		} finally {
			try {
				statement.close();
				rs.close();
				rs2.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	//Metodo che unisce duplicati
	public void unisciDuplicati() throws ClassNotFoundException, SQLException{
		
		List<Contatto> contatti = new ArrayList<>();
		Connection connection = null;
		Statement statement = null; 
		ResultSet rs = null;
		int row;
		boolean haDuplicato = false;
	
		System.out.println("Contatti: ");
		vediListaContatti();
		System.out.println("Inserisci l'id del duplicato da unire: ");
		Scanner s = new Scanner(System.in);
		int numeroIdScanner = s.nextInt();
		System.out.println();
		
		try {
			
			connection = getConnection();
			statement = connection.createStatement();
			Contatto contatto = null;
			
			PreparedStatement preparedStatement = connection.prepareStatement("SELECT id, email, telefono, cognome, nome, note FROM contatti");
			rs = preparedStatement.executeQuery();
			while (rs.next()) {
				
				contatto = new Contatto();
				contatto.setId(rs.getInt("id"));
				contatto.setEmail(rs.getString("email"));
				contatto.setTelephone(rs.getString("telefono"));
				contatto.setSurname(rs.getString("cognome"));
				contatto.setName(rs.getString("nome"));
				contatto.setNote(rs.getString("note"));
				contatti.add(contatto);
			}
			
			for(Contatto c : contatti) {
				if(contatto.getId() == numeroIdScanner) {
					for(Contatto c2 : contatti) {
						if(contatto.getName().contains(c2.getName())) {
							haDuplicato = true;
							PreparedStatement preparedStatement2 = connection.prepareStatement("DELETE FROM contatti WHERE id = ?");
							preparedStatement2.setInt(1, numeroIdScanner);				
							row = preparedStatement2.executeUpdate();
							System.out.println("Duplicati uniti correttamente!");
							break;
						}	
					} 
				}
			}
			
			if(haDuplicato == false) {
				System.out.println("L'utente non ha duplicati");
			}
			
		} catch (ClassNotFoundException cnfEx) {
			cnfEx.printStackTrace(); 
		} catch (SQLException sqlEx) {
			sqlEx.printStackTrace();
		} finally {
			try {
				statement.close();
				rs.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	//Metodo che esporta dati db su csv
	public void writeRubricaCSV(String pathFile, String separator) throws IOException, ClassNotFoundException, SQLException{
		
		Connection connection = null;
		Statement statement = null; 
		ResultSet rs = null;
		
		File rubrica = new File(pathFile);
		boolean exists = rubrica.exists(); //File esiste
		FileWriter fileWriter = new FileWriter(pathFile, true);
		int righeInserite = 0;
		
		try {
			
			connection = getConnection();
			statement = connection.createStatement();
			
			if(!exists) {//Creo la prima riga con NOME-COGNOME-NOTE-TELEFONO se il file non esiste
				fileWriter.write("ID" + separator);
				fileWriter.write("COGNOME" + separator);
				fileWriter.write("NOME" + separator);
				fileWriter.write("TELEFONO" + separator);
				fileWriter.write("EMAIL" + separator);
				fileWriter.write("NOTE" + "\n");
			}
			
			//Prendo i dati dal db
			PreparedStatement preparedStatement = connection.prepareStatement("SELECT id, cognome, nome, telefono, email, note FROM contatti");
			rs = preparedStatement.executeQuery();
			while (rs.next()) {
				righeInserite++;
				fileWriter.write(rs.getInt("id") + separator);
				fileWriter.write(rs.getString("cognome") + separator);
				fileWriter.write(rs.getString("nome") + separator);	
				fileWriter.write(rs.getString("telefono") + separator);
				fileWriter.write(rs.getString("email") + separator);
				fileWriter.write(rs.getString("note") + "\n");
			}
			System.out.println("Sono state inserite "+righeInserite+" righe");

		} catch (ClassNotFoundException cnfEx) {
			cnfEx.printStackTrace(); 
		} catch (SQLException sqlEx) {
			sqlEx.printStackTrace();
		} finally {
			fileWriter.close(); //Chiudo il file e salvo le modifiche
			try {
				statement.close();
				rs.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	//Metodo che importa il file csv su db
	public void importaContattiCSV(String pathFile, String separator) throws FileNotFoundException, IOException, ClassNotFoundException {
		
		Connection connection = null;
		Statement statement = null; 
		ResultSet rs = null;
		int righeInserite = 0;
		
		FileReader fileReader = new FileReader(pathFile);
		BufferedReader bufferedReader = new BufferedReader(fileReader);
		
		try {
			String r = null;
			String[] fields = null;
			Contatto contatto = null;
			
			connection = getConnection();
			statement = connection.createStatement();
			
			while (bufferedReader.ready()) {
				r = bufferedReader.readLine();
				fields = r.split(separator);
				
				righeInserite++;
				contatto = new Contatto();
				
				contatto.setSurname(fields[1]);
				contatto.setName(fields[2]);
				contatto.setTelephone(fields[3]);
				contatto.setEmail(fields[4]);
				contatto.setNote(fields[5]);
				
				//Se si trova alla seconda riga (quindi salto NOME;COGNOME;TELEFONO;EMAIL;NOTE)
				if(righeInserite > 1) {
					
					//INSERT
					PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO contatti(cognome, nome, telefono, email, note) VALUES (?, ?, ?, ?, ?)");
					preparedStatement.setString(1, contatto.getSurname());
					preparedStatement.setString(2, contatto.getName());
					preparedStatement.setString(3, contatto.getTelephone());
					preparedStatement.setString(4, contatto.getEmail());
					preparedStatement.setString(5, contatto.getNote());
					int row = preparedStatement.executeUpdate();

				}
				
				PreparedStatement preparedStatement2 = connection.prepareStatement("UPDATE contatti set nome = case when nome in('null','') then null else nome end, cognome = case when cognome in('null','') then null else cognome end, telefono = case when telefono in('null','') then null else telefono end, email = case when email in('null','') then null else email end, note = case when note in('null','') then null else note end");
				int row2 = preparedStatement2.executeUpdate();

			}
			
			//Salto NOME;COGNOME;TELEFONO;EMAIL;NOTE togliendo 1 da righeInserite che contiene il numero di cicli effettuati
			System.out.println("Sono state inserite "+ (righeInserite-1) +" righe");
			System.out.println();
		
		} catch (ClassNotFoundException cnfEx) {
			cnfEx.printStackTrace(); 
		} catch (IOException ioEx) {
			ioEx.printStackTrace();
			throw ioEx;
		} catch (SQLException sqlEx) {
			sqlEx.printStackTrace();
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
	
	//Metodo che esporta dati db su xml
	public void writeRubricaXML(String pathFile) throws ParserConfigurationException, IOException, SAXException, ClassNotFoundException, DOMException, SQLException{
		
		Connection connection = null;
		Statement statement = null; 
		ResultSet rs = null;
		int righeInserite = 0;
		
		try {
				
			connection = getConnection();
			statement = connection.createStatement();
			
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
			PreparedStatement preparedStatement = connection.prepareStatement("SELECT id, email, telefono, cognome, nome, note FROM contatti");
			rs = preparedStatement.executeQuery();
			while (rs.next()) {
				righeInserite++;
				
				//Per ogni contatto inserisci: Contatto ed i figli nome,cognome ecc. con valori
				Element contatto = doc.createElement("Contatto");
				Element id = doc.createElement("ID");
				id.setTextContent(rs.getString("id"));
				Element cognome = doc.createElement("Cognome");
				cognome.setTextContent(rs.getString("cognome"));
				Element nome = doc.createElement("Nome");
				nome.setTextContent(rs.getString("nome"));
				Element telefono = doc.createElement("Telefono");
				telefono.setTextContent(rs.getString("telefono"));
				Element email = doc.createElement("Email");
				telefono.setTextContent(rs.getString("email"));
				Element note = doc.createElement("Note");
				note.setTextContent(rs.getString("note"));	
				
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
			
		}catch(TransformerException te) {
			System.out.println("TransformerException");
		}catch(ParserConfigurationException pcex) {
			System.out.println("ParserConfigurationException");
		} catch (ClassNotFoundException cnfEx) {
			cnfEx.printStackTrace(); 
		} catch (IOException ioEx) {
			ioEx.printStackTrace();
			throw ioEx;
		} catch (SQLException sqlEx) {
			sqlEx.printStackTrace();
		} finally {
			try {
				statement.close();
				connection.close();
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
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
		
		Connection connection = null;
		Statement statement = null; 
		ResultSet rs = null;
		int righeInserite = 0;
		
		DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
		Document document = documentBuilder.parse(pathFile);		
		Element rootElement = document.getDocumentElement();
		List<Element> elements = getChildElements(rootElement);
		
		
		try {
			
			Contatto contatto = null;
			
			connection = getConnection();
			statement = connection.createStatement();
			
			for (Element el : elements) {
				righeInserite++;
				contatto = new Contatto();
				
				List<Element> values = getChildElements(el);
	
				//Leggo in verticale
				for (Element v : values) {
					String valore = v.getNodeName().toLowerCase(); //Prendo il nome del nodo in minuscolo per confrontarlo
	
					switch (valore) {
					case "cognome":
						contatto.setSurname(v.getTextContent());
						break;
					case "nome":
						contatto.setName(v.getTextContent());
						break;
					case "telefono":
						contatto.setTelephone(v.getTextContent());
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
				PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO contatti(cognome, nome, telefono, email, note) VALUES (?, ?, ?, ?, ?)");
				preparedStatement.setString(1, contatto.getSurname());
				preparedStatement.setString(2, contatto.getName());
				preparedStatement.setString(3, contatto.getTelephone());
				preparedStatement.setString(4, contatto.getEmail());
				preparedStatement.setString(5, contatto.getNote());
				int row = preparedStatement.executeUpdate();
		
			}
			
			//UPDATE
			statement.executeUpdate("UPDATE contatti set nome = case when nome in('null','') then null else nome end, cognome = case when cognome in('null','') then null else cognome end, telefono = case when telefono in('null','') then null else telefono end, email = case when email in('null','') then null else email end, note = case when note in('null','') then null else note end");
			System.out.println("Sono state inserite "+righeInserite+" righe");
			System.out.println();
		
		} catch (ClassNotFoundException cnfEx) {
			cnfEx.printStackTrace(); 
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
	
	public static void main(String[] args) throws ClassNotFoundException, FileNotFoundException, IOException, ParserConfigurationException, SAXException, SQLException {
		String pathForCSV = "/Users/gianf/Desktop/contatti.csv";
		String pathForXml = "/Users/gianf/Desktop/rubrica.xml";
		String separator = "-";
		int scelta = 0;
		GestoreDiRubricaJDBC gestoreRubrica = new GestoreDiRubricaJDBC();
		
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
			gestoreRubrica.main(args); //Se non è presente rilancia il programma
		} else {
			switch(scelta) {
				case 1:
					gestoreRubrica.vediListaContatti(); //Se 1 chiama metodo che fa visualizzare i contatti
					System.out.println();
					gestoreRubrica.main(args); //Richiama il programma così si può continuare ad usare, dato che l'utente non ha ancora fatto l'exit
					break;
				case 2:
					gestoreRubrica.cercaContatto();
					System.out.println();
					gestoreRubrica.main(args);
					break;
				case 3:
					gestoreRubrica.creaNuovoContatto();
					System.out.println();
					gestoreRubrica.vediListaContatti();
					gestoreRubrica.main(args);
					break;
				case 4:
					gestoreRubrica.modificaContatto();
					System.out.println("Lista aggiornata");
					gestoreRubrica.vediListaContatti();
					gestoreRubrica.main(args); //Richiama il programma così si può continuare ad usare, dato che l'utente non ha ancora fatto l'exit
					break;
				case 5:
					gestoreRubrica.eliminaContatto();
					System.out.println("Lista aggiornata");
					gestoreRubrica.vediListaContatti();
					gestoreRubrica.main(args);
					break;
				case 6:
					gestoreRubrica.trovaDuplicati();
					gestoreRubrica.main(args);
					break;
				case 7:
					gestoreRubrica.unisciDuplicati();
					System.out.println();
					gestoreRubrica.main(args);
					break;
				case 8:
					gestoreRubrica.writeRubricaCSV(pathForCSV,separator);
					gestoreRubrica.main(args);
					break;
				case 9:
					gestoreRubrica.importaContattiCSV(pathForCSV,separator);
					gestoreRubrica.main(args);
					break;
				case 10:
					gestoreRubrica.writeRubricaXML(pathForXml);
					gestoreRubrica.main(args);
					break;
				case 11:
					gestoreRubrica.importaContattiXML(pathForXml);
					gestoreRubrica.main(args);
					break;
				case 12:
					System.out.println("Programma terminato");
					break; //Ferma il programma per l'exit
					
			}
		}
		
	
	
	}

}
