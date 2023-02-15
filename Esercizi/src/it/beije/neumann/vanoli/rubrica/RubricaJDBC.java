package it.beije.neumann.vanoli.rubrica;

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

public class RubricaJDBC {
	
	public static List<Contatto> LoadRubricaFromDB() throws ClassNotFoundException, IOException {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection connection = null;
		Statement statement = null; 
		ResultSet rs = null;
		
		List<Contatto> contatti = new ArrayList<Contatto>();
		
		FileReader fileReader = new FileReader("/temp/passwordSQL.txt");
		BufferedReader bufferedReader = new BufferedReader(fileReader);
		String password = bufferedReader.readLine().trim();
		bufferedReader.close();
				
		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/rubrica?serverTimezone=CET&useSSL=false", "root", password);			
			statement = connection.createStatement();
			
			rs = statement.executeQuery("SELECT id, email, telefono, cognome, nome, note FROM contatti");
			while (rs.next()) {
				Contatto c = new Contatto();
				c.setId(rs.getInt("id"));
				c.setSurname(rs.getString("cognome"));
				c.setName(rs.getString("nome"));
				c.setEmail(rs.getString("email"));
				c.setTelephone(rs.getString("telefono"));
				c.setNote(rs.getString("note"));
				contatti.add(c);
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

	public static void WriteRubricaToDB(List<Contatto> listaContatti) throws ClassNotFoundException, IOException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection connection = null;
		Statement statement = null; 
		
		FileReader fileReader = new FileReader("/temp/passwordSQL.txt");
		BufferedReader bufferedReader = new BufferedReader(fileReader);
		String password = bufferedReader.readLine().trim();
		bufferedReader.close();
				
		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/rubrica?serverTimezone=CET&useSSL=false", "root", password);
			
			statement = connection.createStatement();
			
			for (Contatto c: listaContatti) {
				StringBuilder sb = new StringBuilder();
				sb.append("INSERT INTO contatti(nome, cognome, telefono, email, note) VALUES ('");
				sb.append(c.getName());
				sb.append("', '");
				sb.append(c.getSurname());
				sb.append("', '");
				sb.append(c.getTelephone());
				sb.append("', '");
				sb.append(c.getEmail());
				sb.append("', '");
				sb.append(c.getNote());
				sb.append("')");
				statement.executeUpdate(sb.toString());
			}
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
	
	//funzioni riga di comando
	
	public static List<Contatto> CercaContatto(String nome, String cognome) {
		List<Contatto> contatti = null;
		try {
			contatti = RubricaJDBC.LoadRubricaFromDB();
		} catch (ClassNotFoundException | IOException e) {
			e.printStackTrace();
		}
		
		List<Contatto> matchingContatti = new ArrayList<Contatto>();
		
		for (Contatto c: contatti) {
			if (c.getName().equals(nome) && c.getSurname().equals(cognome)) {
				matchingContatti.add(c);
			}
		}		
		return matchingContatti;		
	}
	
	public static void inserisciContatto(Contatto c) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		
		Connection connection = null;
		Statement statement = null;
		String password = "";
		
		FileReader fileReader;
		try {
			fileReader = new FileReader("/temp/passwordSQL.txt");	
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			password = bufferedReader.readLine().trim();
			bufferedReader.close();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
				
		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/rubrica?serverTimezone=CET&useSSL=false", "root", password);
			
			statement = connection.createStatement();
			
			StringBuilder sb = new StringBuilder();
			sb.append("INSERT INTO contatti(nome, cognome, telefono, email, note) VALUES ('");
			sb.append(c.getName());
			sb.append("', '");
			sb.append(c.getSurname());
			sb.append("', '");
			sb.append(c.getTelephone());
			sb.append("', '");
			sb.append(c.getEmail());
			sb.append("', '");
			sb.append(c.getNote());
			sb.append("')");
			statement.executeUpdate(sb.toString());			
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
	
}
