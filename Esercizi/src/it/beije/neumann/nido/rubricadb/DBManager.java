package it.beije.neumann.nido.rubricadb;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import it.beije.neumann.nido.rubrica.CSVManager;
import it.beije.neumann.nido.rubrica.Contatto;

public class DBManager {

	public static final String CONN_STR = "jdbc:mysql://localhost:3306/neumann?serverTimezone=CET&useSSL=false"; //allowPublicKeyRetrieval=true
	public static final String USER = "root";
	public static final String PSW = "Mary23BeijeSQL";

	public static final String CSV_READ = "./src/it/beije/neumann/nido/rubrica/rubrica.csv";
	
	public static String checkPeak(String str) {
		
		str = str.replace("'", "''");
		
		return str;
	}

	public static int importRubricaToDB(List<Contatto> contacts) {
		Connection connection = null;
		//Statement statement = null;
		PreparedStatement preparedStatement = null;
		int rowsAdd = 0;

		try {
			connection = DriverManager.getConnection(CONN_STR, USER, PSW);
			//statement = connection.createStatement();
			preparedStatement = connection.prepareStatement("INSERT INTO contatti(cognome, nome, telefono, email, note) VALUES (?,?,?,?,?)");
			
			for(Contatto c : contacts) {
				//String queryInsert = "INSERT INTO contatti(cognome, nome, telefono, email, note) VALUES ('"+checkPeak(c.getSurname())+"', '"+checkPeak(c.getName())+"', '"+c.getTelephone()+"', '"+c.getEmail()+"', '"+checkPeak(c.getNote())+"')";
				//rowsAdd += statement.executeUpdate(queryInsert);
				preparedStatement.setString(1, checkPeak(c.getSurname()));
				preparedStatement.setString(2, checkPeak(c.getName()));
				preparedStatement.setString(3, c.getTelephone());
				preparedStatement.setString(4, c.getEmail());
				preparedStatement.setString(5, checkPeak(c.getNote()));
				rowsAdd += preparedStatement.executeUpdate();
			}
			
		} catch (SQLException sqlEx) {
			sqlEx.printStackTrace();
		} finally {
			try {
				//statement.close();
				preparedStatement.close();
				connection.close();
			} catch (SQLException sqlEx2) {
				sqlEx2.printStackTrace();
			}
		}

		return rowsAdd;
	}

	public static List<Contatto> exportRubricaFromDB() {
		List<Contatto> contacts = new ArrayList<>();

		Connection connection = null;
		Statement statement = null;
		ResultSet rs = null;

		try {
			connection = DriverManager.getConnection(CONN_STR, USER, PSW);
			statement = connection.createStatement();

			rs = statement.executeQuery("SELECT * FROM contatti");

			while (rs.next()) {
				// Add contacts to list
				Contatto contact = new Contatto();

				contact.setId(rs.getInt("id"));
				contact.setSurname(rs.getString("cognome"));
				contact.setName(rs.getString("nome"));
				contact.setEmail(rs.getString("email"));
				contact.setTelephone(rs.getString("telefono"));
				contact.setNote(rs.getString("note"));

				contacts.add(contact);
			}

		} catch (SQLException sqlEx) {
			sqlEx.printStackTrace();
		} finally {
			try {
				rs.close();
				statement.close();
				connection.close();
			} catch (SQLException sqlEx2) {
				sqlEx2.printStackTrace();
			}

		}

		return contacts;

	}

	public static void main(String[] args) throws ClassNotFoundException, FileNotFoundException, IOException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		System.out.println("Contacts read from DB:");

		List<Contatto> rubricaDB = exportRubricaFromDB();

		for (Contatto c : rubricaDB) {
			System.out.println(c);
		}
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~\n");

		List<Contatto> rubricaCSV = CSVManager.readRubrica(CSV_READ, ";", false);
		rubricaCSV.remove(0);
		
		System.out.println("Contacts read from CSV:");

		for (Contatto c : rubricaCSV) {
			System.out.println(c);
		}
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~\n");

		System.out.println("Rows added to DB: "+importRubricaToDB(rubricaCSV));

	}

}
