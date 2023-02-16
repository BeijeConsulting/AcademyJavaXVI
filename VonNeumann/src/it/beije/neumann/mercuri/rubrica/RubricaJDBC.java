package it.beije.neumann.mercuri.rubrica;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class RubricaJDBC {

	public static List<Contatto> exportContattiDB (){
		
		List<Contatto> contatti = new ArrayList<>();
		
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

					rowCount++;
					
					Contatto c = new Contatto();
					c.setId(rs.getInt("id"));
					c.setSurname(rs.getString("cognome") == "null"? null: rs.getString("cognome"));
					c.setName(rs.getString("nome") == "null"? null: rs.getString("nome"));
					c.setTelephone(rs.getString("telefono") == "null"? null: rs.getString("telefono"));
					c.setEmail(rs.getString("email") == "null"? null: rs.getString("email"));
					c.setNote(rs.getString("note") == "null"? null: rs.getString("note"));

					contatti.add(c);
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
					PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO contatti(nome, cognome, telefono, email, note) VALUES (?,?,?,?,?)");
					preparedStatement.setString(1, c.getName());
					preparedStatement.setString(2, c.getSurname());
					preparedStatement.setString(3, c.getTelephone());
					preparedStatement.setString(4, c.getEmail());
					preparedStatement.setString(5, c.getNote());
					
					rowCount += preparedStatement.executeUpdate();
					
//					rowCount += statement.executeUpdate("INSERT INTO contatti(nome, cognome, telefono, email, note)"
//							+ " VALUES ('"+c.getName()+"', '"+c.getSurname()+"', '"+c.getTelephone()+"', '"+c.getEmail()+"', '"+c.getNote()+"')");
//										
					
				}
				
				statement.executeUpdate("UPDATE contatti set nome = case when nome in ('null','') then null else nome end, "
						+ "cognome = case when cognome in ('null','') then null else cognome end, "
						+ "telefono = case when telefono in ('null','') then null else telefono end, "
						+ "email = case when email in ('null','') then null else email end, "
						+ "note = case when note in ('null','') then null else note end");

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
		
		contatti = exportContattiDB();
		
		XMLmanager.writeRubricaXML(contatti, "/temp/rubricaFromDB.xml");
	}

}
