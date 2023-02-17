package it.beije.neumann.rubrica;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class RubricaJDBC {
	
	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/neumann?serverTimezone=CET", "root", "beije");
	}

	public static void main(String[] args) {
		
		Connection connection = null;
		Statement statement = null; 
		ResultSet rs = null;
				
		try {
			connection = getConnection();
			
			statement = connection.createStatement();
			
			//INSERT
			//statement.executeUpdate("INSERT INTO contatti(nome, cognome, telefono, email) VALUES ('Bianchi', 'Roberta', '325235252', 'r.bianchi@beije.it')");
			String nome = "Marianna";
			String cognome = "Viola";
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
//			rs = statement.executeQuery("SELECT id, email, telefono, cognome, nome, note FROM contatti");
			
			PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM contatti WHERE cognome = ? AND nome = ?");
			preparedStatement.setString(1, cognome);
			preparedStatement.setString(2, nome);
			rs = preparedStatement.executeQuery();
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

	// SELECT * FORM USERS WHERE USERNAME = username AND PASSWORD = password 
	// SELECT * FORM USERS WHERE USERNAME = '' OR USERNAME LIKE '%%' # AND PASSWORD = password
	
}
