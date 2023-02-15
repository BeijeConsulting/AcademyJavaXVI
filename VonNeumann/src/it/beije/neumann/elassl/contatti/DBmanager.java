package it.beije.neumann.elassl.contatti;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DBmanager {
	
	static public List<Contatto> getContatti() throws ClassNotFoundException {
		List<Contatto> contacts= new ArrayList<>();
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		try(Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/neumann?serverTimezone=CET&useSSL=false", "root", "password123");
			Statement statement = connection.createStatement();
			){
			ResultSet rs = statement.executeQuery("SELECT id, email, telefono, cognome, nome, note FROM contatti");
			while (rs.next()) {
//				System.out.println("id : " + rs.getInt(1));
//				System.out.println("cognome : " + rs.getString(3));
//				System.out.println("nome : " + rs.getString(4));
//				System.out.println("email : " + rs.getString(2));
//				System.out.println("telefono : " + rs.getString(4));
//				System.out.println("note : " + rs.getString(6));
				int id=rs.getInt("id");
				String name=rs.getString("nome");
				String surname=rs.getString("cognome");
				String email=rs.getString("email");
				String telephone=rs.getString("telefono");
				String note=rs.getString("note");
				Contatto contatto= new Contatto(id, name, surname, telephone, email, note);
				contacts.add(contatto);
			}
		}
		catch (SQLException sqlEx) {
			sqlEx.printStackTrace();
		}
		
		return contacts;
	}
	
	static public int writeContatto(Contatto contatto) throws ClassNotFoundException {
		int res=-1;
		Class.forName("com.mysql.cj.jdbc.Driver");
		try(Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/neumann?serverTimezone=CET&useSSL=false", "root", "password123");
				Statement statement = connection.createStatement();
				){
				PreparedStatement stmt=connection.prepareStatement("INSERT INTO contatti (nome, cognome, telefono, email, note) values(?,?,?,?,?)"); 
				stmt.setString(1,contatto.getName());
				stmt.setString(2,contatto.getSurname());
				stmt.setString(3,contatto.getTelephone());
				stmt.setString(4,contatto.getEmail());
				stmt.setString(5,contatto.getNote());
				res=stmt.executeUpdate();    
			}
			catch (SQLException sqlEx) {
				sqlEx.printStackTrace();
			}
		return res;
	}
	
	static public int updateContatto(Contatto contact) throws ClassNotFoundException {
		int res=-1;
		Class.forName("com.mysql.cj.jdbc.Driver");
		try(Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/neumann?serverTimezone=CET&useSSL=false", "root", "password123");
				Statement statement = connection.createStatement();
				){
				PreparedStatement stmt=connection.prepareStatement("UPDATE contatti SET nome = ?, cognome = ?, telefono = ?, email = ?, note = ? WHERE id = ? "); 
				stmt.setString(1,contact.getName());
				stmt.setString(2,contact.getSurname());
				stmt.setString(3,contact.getTelephone());
				stmt.setString(4,contact.getEmail());
				stmt.setString(5,contact.getNote());
				res=stmt.executeUpdate();    
			}
			catch (SQLException sqlEx) {
				sqlEx.printStackTrace();
			}
		return res;
	}
	static public List<Contatto> getDuplicates() throws ClassNotFoundException {

		String Query = "SELECT id, email, telefono, cognome, nome, note FROM contatti";
		int res=-1;
		List<Contatto> contacts= new ArrayList<>();
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		try(Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/neumann?serverTimezone=CET&useSSL=false", "root", "password123");
			Statement statement = connection.createStatement();
			){
			ResultSet rs = statement.executeQuery(Query);
			while (rs.next()) {
				int id=rs.getInt("id");
				String name=rs.getString("nome");
				String surname=rs.getString("cognome");
				String email=rs.getString("email");
				String telephone=rs.getString("telefono");
				String note=rs.getString("note");
				Contatto contatto= new Contatto(id, name, surname, telephone, email, note);
				contacts.add(contatto);
			}
		}
		catch (SQLException sqlEx) {
			sqlEx.printStackTrace();
		}
		
		return contacts;
	}
	static public int deleteContatto(Contatto contact) throws ClassNotFoundException {
		String Query = "DELETE FROM contatti WHERE id=?;";
		int res=-1;
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		try(Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/neumann?serverTimezone=CET&useSSL=false", "root", "password123");
				Statement statement = connection.createStatement();
				){
				PreparedStatement stmt=connection.prepareStatement(Query); 
				stmt.setInt(1,contact.getId());
				res=stmt.executeUpdate();    
			}
			catch (SQLException sqlEx) {
				sqlEx.printStackTrace();
			}
		return res;
	}
		

	}
}
