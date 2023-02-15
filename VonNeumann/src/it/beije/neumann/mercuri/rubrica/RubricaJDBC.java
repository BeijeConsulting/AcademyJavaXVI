package it.beije.neumann.mercuri.rubrica;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class RubricaJDBC {

	public static List<Contatto> exportContattiDB (String pathFile){
		
		List<Contatto> contatti = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
						
			Connection connection = null;
			Statement statement = null; 
			ResultSet rs =null;
			
			try {
				connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/neumann?serverTimezone=CET&useSSL=false", "root", "*****");
				
				statement = connection.createStatement();
				
				int rowCount = 0;

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

				System.out.println("Selected rows: " + rowCount);

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
		catch (ClassNotFoundException classEx){
				
			classEx.printStackTrace();
			
		}
		
		return contatti;
		
	}
	public static void importContattiToDB (List<Contatto> contatti) {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection connection = null;
			Statement statement = null; 
					
			try {
				connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/neumann?serverTimezone=CET&useSSL=false", "root", "*****");
				
				statement = connection.createStatement();
				
				int rowCount = 0;
				for (Contatto c: contatti) {
					rowCount += statement.executeUpdate("INSERT INTO contatti(nome, cognome, telefono, email, note)"
							+ " VALUES ('"+c.getName()+"', '"+c.getSurname()+"', '"+c.getTelephone()+"', '"+c.getEmail()+"', '"+c.getNote()+"')");
										
					
				}
				
				statement.executeUpdate("update contatti set nome = null where nome = 'null'");
				statement.executeUpdate("update contatti set cognome = null where cognome = 'null'");
				statement.executeUpdate("update contatti set telefono = null where telefono = 'null'");
				statement.executeUpdate("update contatti set email = null where email = 'null'");
				statement.executeUpdate("update contatti set note = null where note = 'null'");
				
				System.out.println("Affected rows: " + rowCount);

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
		catch (ClassNotFoundException classEx){
				
			classEx.printStackTrace();
			
		}
		
	}
	public static void main(String[] args)  {
		
		List<Contatto> contatti = XMLmanager.loadRubricaFromXML("/temp/rubrica.xml");
		
		importContattiToDB(contatti);
	}

}
