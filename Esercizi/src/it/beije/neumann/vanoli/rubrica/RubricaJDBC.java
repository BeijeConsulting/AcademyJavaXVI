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

public class RubricaJDBC implements RubricaInterface{
	
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
	
	public List<Contatto> LoadRubricaFromDB() {
		
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
				c.setCognome(rs.getString("cognome"));
				c.setNome(rs.getString("nome"));
				c.setEmail(rs.getString("email"));
				c.setTelefono(rs.getString("telefono"));
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

	public void WriteRubricaToDB(List<Contatto> listaContatti) {
				
		Connection connection = null;
		
		try {
			connection = getConnection();
			
			PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO contatti(nome, cognome, telefono, email, note) VALUES (? , ? , ? , ? , ?)");
			
			for (Contatto c: listaContatti) {				
				preparedStatement.setString(1, c.getNome());
				preparedStatement.setString(2, c.getCognome());
				preparedStatement.setString(3, c.getTelefono());
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
	
	public List<Contatto> elencoRubrica(String orderBy) {
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
				c.setNome(rs.getString("nome"));
				c.setCognome(rs.getString("cognome"));
				c.setTelefono(rs.getString("telefono"));
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
	
	public List<Contatto> cercaContatto(String nome, String cognome) {
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
				c.setNome(rs.getString("nome"));
				c.setCognome(rs.getString("cognome"));
				c.setTelefono(rs.getString("telefono"));
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
	
	public void inserisciContatto(Contatto c) {
		Connection connection = getConnection();
		
		try {
			PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO contatti(nome, cognome, telefono, email, note) VALUES (? , ? , ? , ? , ?)");
			preparedStatement.setString(1, c.getNome());
			preparedStatement.setString(2, c.getCognome());
			preparedStatement.setString(3, c.getTelefono());
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
	
	public void editContatto(Contatto c) {
		Connection connection = getConnection();
		
		try {
			PreparedStatement preparedStatement = connection.prepareStatement("UPDATE contatti SET nome = ?, cognome = ?, telefono = ?, email = ?, note = ? WHERE id = ?");
			preparedStatement.setString(1, c.getNome());
			preparedStatement.setString(2, c.getCognome());
			preparedStatement.setString(3, c.getTelefono());
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
	
	public void deleteContatto(Contatto c) {
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
	
	public List<Contatto> trovaContattiDuplicati() {
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
				c.setNome(rs.getString("nome"));
				c.setCognome(rs.getString("cognome"));
				c.setTelefono(rs.getString("telefono"));
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
	
	public void unisciContattiDuplicati() {
		List<Contatto> dupes = trovaContattiDuplicati();
		List<Contatto> toEdit = new ArrayList<Contatto>();
		for (Contatto dup: dupes) {
			//Controlliamo se abbbiamo già inserito il contatto nella lista toEdit, se si' ci salviamo il contatto altrimenti resta null
			Contatto trovatoEdit = null;
			for (Contatto c: toEdit) {
				if (c.getNome().equals(dup.getNome()) && c.getNome().equals(dup.getNome())) {
					trovatoEdit = c;
					break;
				}
			}
			if (trovatoEdit == null) {
				//se non l'abbiamo trovato, lo aggiungiamo semplicemente nella lista
				toEdit.add(dup);
			}
			else {
				//altrimenti, lo uniamo con quello che abbiamo trovatoEdit e facciamo una delete
				trovatoEdit.setEmail(unisciStringhe(trovatoEdit.getEmail(), dup.getEmail()));
				trovatoEdit.setTelefono(unisciStringhe(trovatoEdit.getTelefono(), dup.getTelefono()));
				trovatoEdit.setNote(unisciStringhe(trovatoEdit.getNote(), dup.getNote()));
				deleteContatto(dup);
			}
		}
		//adesso andiamo semplicemente a modificare i contatti che abbiamo in toEdit
		for (Contatto c: toEdit) {
			editContatto(c);
		}
	}
	
	private String unisciStringhe(String s1, String s2) {
		if (s1.equals(""))
			return s2;
		else if (s2.equals(""))
			return s1;
		else if (s1.equals(s2))
			return s1;
		else
			return s1 + "; " + s2;
	}
	
}
