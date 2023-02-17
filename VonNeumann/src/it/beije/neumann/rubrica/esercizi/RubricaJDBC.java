package it.beije.neumann.rubrica.esercizi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RubricaJDBC {

	public static void main(String[] args) throws ClassNotFoundException {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection connection = null;
		Statement statement = null; 
		ResultSet rs = null;
				
		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/neumann?serverTimezone=CET&useSSL=false", "root", "password");
			//System.out.println(connection.isClosed());
			
			statement = connection.createStatement();
	
			//UPDATE
//			int rows = statement.executeUpdate("UPDATE contatti SET note = 'Siamo Bianchi' WHERE id = '1'");
//			System.out.println("rows updated : " + rows);
			
			//DELETE
//			rows = statement.executeUpdate("DELETE FROM contatti WHERE cognome = 'Roberta'");
//			System.out.println("rows updated : " + rows);
			
			//SELECT
//			statement.execute("SELECT id, email, telefono, cognome, nome, note FROM contatti");
//			ResultSet rs = statement.getResultSet();
		
			
			Scanner s = new Scanner(System.in);
			System.out.println("1)Vedi lista contatti");
			System.out.println("2)Cerca contatto");
			System.out.println("3)Inserisci nuovo contatto");
			System.out.println("4)Modifica contatto");
			System.out.println("5)Cancella contatto");
			System.out.println("6)Trova contatti duplicati");
			System.out.println("7)Unisci contatti duplicati");
			
			String st = s.next();
			while (!st.equalsIgnoreCase("exit")) {
				switch(st) {
				 case "1":
					 getContacts(connection);
					break;
				 case "2":
					 searchContact(connection);
					 break;
				 case "3":
					 addContact(statement);
					 break;
				 case "4":	
					 updateContact(statement);
					 break;
				 case "5":
					 deleteContact(statement);
					 break;
				 case "6":
					 printDuplicate();
					 break;
				 case "7":
					 mergeDuplicate();
					 break;
				default:
					System.out.println("Numero non valido");
				}
				st = s.next();
				
			}
			s.close();
			

			
			
		} catch (SQLException sqlEx) {
			sqlEx.printStackTrace();
		} finally {
			try {
				rs.close();
				statement.close();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static List<Contatto> getContacts(Connection connection) {
		List<Contatto> contacts = new ArrayList<Contatto>();
		ResultSet rs;
		try {
			PreparedStatement preparedStatement = connection.prepareStatement("SELECT id, email, telefono, cognome, nome, note FROM contatti");
			rs = preparedStatement.executeQuery();
			while (rs.next()) {
				
				Contatto c = new Contatto();
				c.setId(rs.getInt("id"));
				c.setName(rs.getString("nome"));
				c.setSurname(rs.getString("cognome"));
				c.setEmail(rs.getString("email"));
				c.setTelephone(rs.getString("telefono"));
				c.setNote("note");
				
				contacts.add(c);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		for (Contatto c : contacts) {
			System.out.println(c.toString());
		}
		return contacts;
		
	}
	
	public static void searchContact(Connection connection) {
	    String name = "Bianchi";
	    
		ArrayList<Contatto> contacts = new ArrayList<Contatto>();
		ResultSet rs;
		try {
			PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM contatti WHERE nome = ?");
			preparedStatement.setString(1, name);
			rs = preparedStatement.executeQuery();
			while (rs.next()) {
				
				Contatto c = new Contatto();
				c.setId(rs.getInt("id"));
				c.setName(rs.getString("nome"));
				c.setSurname(rs.getString("cognome"));
				c.setEmail(rs.getString("email"));
				c.setTelephone(rs.getString("telefono"));
				c.setNote("note");
				
				contacts.add(c);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		for (Contatto c : contacts) {
			System.out.println(c.toString());
		}
	}
	public static void addContact(Statement statement) {
		try {
			statement.executeUpdate("INSERT INTO contatti(nome, cognome, telefono, email) VALUES ('Mario', 'Rossi', '325235252', 'mariorossi@beije.it')");
		} catch (SQLException e) {
			e.printStackTrace();
		}
//		String nome = "Marianna";
//		String cognome = "Viola";
//		statement.executeUpdate("INSERT INTO contatti(nome, cognome, telefono, email) VALUES ('" + nome + "', '" + cognome + "', '325235252', 'r.bianchi@beije.it')");
	
	}
	public static void updateContact(Statement statement) {
		int rows;
		try {
			rows = statement.executeUpdate("UPDATE contatti SET note = 'Siamo Bianchi' WHERE id = '1'");
			System.out.println("rows updated : " + rows);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public static void deleteContact(Statement statement) {
		System.out.println("deleteContact");
	}
	public static void printDuplicate() {
		System.out.println("printDuplicate");
	}
	public static void mergeDuplicate() {
		System.out.println("mergeDuplicate");
	}
	
	public static void countPossibleConnections(){
		for(int i = 0; ; i++) {
			try {
				DriverManager.getConnection("jdbc:mysql://localhost:3306/neumann?serverTimezone=CET&useSSL=false", "root", "password");
				System.out.println(i);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void exportOnCsv(List<Contatto> contacts){
		List<String> rows = new ArrayList<String>();
		for(Contatto c : contacts) {
			StringBuilder str = new StringBuilder();
			str.append(c.getId()).append(",");
			str.append(c.getName()).append(",");
			str.append(c.getSurname()).append(",");
			str.append(c.getEmail()).append(",");
			str.append(c.getTelephone()).append(",");
			str.append(c.getNote()).append(",");
			
			rows.add(str.toString());
		}
		CSVmanager.writeCsv(rows, "./src/it/beije/neumann/rubrica/esercizi/nuovaRubrica.csv");
	}

}
