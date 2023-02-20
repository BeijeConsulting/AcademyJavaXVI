package it.beije.neumann.vanoli.rubrica;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class RubricaJDBC {
	
	public static Connection getConnection() {
		//Lettura file con passwd
		Connection conn = null;
		try {
			FileReader fileReader = new FileReader("/temp/passwordSQL.txt");
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			String password = bufferedReader.readLine().trim();
			bufferedReader.close();
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rubrica?serverTimezone=CET&useSSL=false", "root", password);
		}
		catch (IOException | ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	public static List<Contatto> LoadRubricaFromDB() throws ClassNotFoundException, IOException {
		
		Connection connection = null;
		Statement statement = null; 
		ResultSet rs = null;
		
		List<Contatto> contatti = new ArrayList<Contatto>();
		
		try {
			connection = getConnection();			
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
				
		Connection connection = null;
		
		try {
			connection = getConnection();
			
			PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO contatti(nome, cognome, telefono, email, note) VALUES (? , ? , ? , ? , ?)");
			
			for (Contatto c: listaContatti) {				
				preparedStatement.setString(1, c.getName());
				preparedStatement.setString(2, c.getSurname());
				preparedStatement.setString(3, c.getTelephone());
				preparedStatement.setString(4, c.getEmail());
				preparedStatement.setString(5, c.getNote());
				preparedStatement.executeUpdate();				
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
	
	//funzioni riga di comando
	
	public static List<Contatto> elencoRubrica(String orderBy) {
		Connection connection = null;
		Statement statement = null;
		ResultSet rs = null;
		
		List<Contatto> contatti = new ArrayList<Contatto>();
		
		try {
			connection = getConnection();
			statement = connection.createStatement();
			
			rs = statement.executeQuery("SELECT * FROM contatti ORDER BY " + orderBy);					
			while (rs.next()) {
				Contatto c = new Contatto();
				c.setId(rs.getInt("id"));
				c.setName(rs.getString("nome"));
				c.setSurname(rs.getString("cognome"));
				c.setTelephone(rs.getString("telefono"));
				c.setEmail(rs.getString("email"));
				c.setNote(rs.getString("note"));
				contatti.add(c);
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return contatti;		
	}
	
	public static List<Contatto> cercaContatto(String nome, String cognome) {
		Connection connection = getConnection();
		ResultSet rs = null;
		
		List<Contatto> contatti = new ArrayList<Contatto>();
		
		try {
			PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM contatti WHERE cognome = ? AND nome = ?");
			preparedStatement.setString(1, cognome);
			preparedStatement.setString(2, nome);
			rs = preparedStatement.executeQuery();		
			while (rs.next()) {
				Contatto c = new Contatto();
				c.setId(rs.getInt("id"));
				c.setName(rs.getString("nome"));
				c.setSurname(rs.getString("cognome"));
				c.setTelephone(rs.getString("telefono"));
				c.setEmail(rs.getString("email"));
				c.setNote(rs.getString("note"));
				contatti.add(c);
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return contatti;		
	}
	
	public static void inserisciContatto(Contatto c) {
		Connection connection = getConnection();
		
		try {
			PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO contatti(nome, cognome, telefono, email, note) VALUES (? , ? , ? , ? , ?)");
			preparedStatement.setString(1, c.getName());
			preparedStatement.setString(2, c.getSurname());
			preparedStatement.setString(3, c.getTelephone());
			preparedStatement.setString(4, c.getEmail());
			preparedStatement.setString(5, c.getNote());
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
	
	public static void editContatto(Contatto c) {
		Connection connection = getConnection();
		
		try {
			PreparedStatement preparedStatement = connection.prepareStatement("UPDATE contatti SET nome = ?, cognome = ?, telefono = ?, email = ?, note = ? WHERE id = ?");
			preparedStatement.setString(1, c.getName());
			preparedStatement.setString(2, c.getSurname());
			preparedStatement.setString(3, c.getTelephone());
			preparedStatement.setString(4, c.getEmail());
			preparedStatement.setString(5, c.getNote());
			preparedStatement.setString(6, String.valueOf(c.getId()));
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
	
	public static void deleteContatto(Contatto c) {
		Connection connection = getConnection();
		
		try {
			PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM contatti WHERE id = ?");
			preparedStatement.setString(1, String.valueOf(c.getId()));
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
	
	public static List<Contatto> trovaContattiDuplicati() {
		Connection connection = null;
		Statement statement = null;
		ResultSet rs = null;
		
		List<Contatto> contatti = new ArrayList<Contatto>();
		
		try {
			connection = getConnection();
			statement = connection.createStatement();
			
			rs = statement.executeQuery("SELECT * FROM rubrica.contatti INNER JOIN (SELECT nome, cognome FROM rubrica.contatti GROUP BY nome, cognome HAVING COUNT(*) > 1) dupes ON rubrica.contatti.nome = dupes.nome AND rubrica.contatti.cognome = dupes.cognome");					
			while (rs.next()) {
				Contatto c = new Contatto();
				c.setId(rs.getInt("id"));
				c.setName(rs.getString("nome"));
				c.setSurname(rs.getString("cognome"));
				c.setTelephone(rs.getString("telefono"));
				c.setEmail(rs.getString("email"));
				c.setNote(rs.getString("note"));
				contatti.add(c);
			}			
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return contatti;		
	}
	/*
	public static List<Contatto> unisciContattiDuplicati() {
		
	}
	*/
	
}
