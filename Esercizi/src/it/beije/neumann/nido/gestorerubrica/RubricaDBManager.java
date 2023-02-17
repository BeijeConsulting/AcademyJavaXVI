package it.beije.neumann.nido.gestorerubrica;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RubricaDBManager {

	private static RubricaDBManager rubricaDBManager;

	private static Connection connection = null;

	private static final String URL = "jdbc:mysql://localhost:3306/neumann?serverTimezone=CET&useSSL=false";
	private static final String USER = "root";
	private static final String PSW = "Mary23BeijeSQL";

	private RubricaDBManager() {}

	public static RubricaDBManager getDBManager() {

		if (rubricaDBManager == null)
			rubricaDBManager = new RubricaDBManager();

		return rubricaDBManager;
	}

	/*
	 * System.out.println("2.Cerca un contatto");
	 * System.out.println("3.Aggiungi un nuovo contatto");
	 * System.out.println("4.Modifica un contatto esistente");
	 * System.out.println("5.Cancella un contatto");
	 * System.out.println("6.Trova duplicati");
	 * System.out.println("7.Unisci duplicati");
	 */

	private static Connection openConnection() throws SQLException {
		return DriverManager.getConnection(URL, USER, PSW);
	}

	private static void closeConnection() throws SQLException {
		connection.close();
	}

	public static void showRubrica(String orderBy, String onWhat) {
		PreparedStatement prepStatement = null;
		ResultSet rs = null;
		
		String querySelect = "SELECT * FROM rubricacompleta ORDER BY "+onWhat+ " "+orderBy;

		try {
			connection = openConnection();

			// Preparazione query
			prepStatement = connection.prepareStatement(querySelect);

			rs = prepStatement.executeQuery();

			while (rs.next()) {
				Contact contact = new Contact();

				contact.setId(rs.getInt("id"));
				contact.setSurname(rs.getString("surname"));
				contact.setName(rs.getString("name"));
				contact.setAge(rs.getInt("age"));
				contact.setTelephone(rs.getString("telephone"));
				contact.setEmail(rs.getString("email"));
				contact.setNote(rs.getString("note"));

				System.out.println(contact);

			}

		} catch (SQLException sqlEx) {
			sqlEx.printStackTrace();
		} finally {
			try {
				rs.close();
				prepStatement.close();
				closeConnection();
			} catch (SQLException sqlEx2) {
				sqlEx2.printStackTrace();
			}

		}
	}

	public static void searchContact() {
		System.out.println("searchContact() on its way for implementation");
	}

	public static void addContact() {
		System.out.println("addContact() on its way for implementation");
	}

	public static void editContact(String name, String surname) {
		// Se ci sono più corrispondenze, vai su id
		System.out.println("editContact() on its way for implementation");
	}

	public static void deleteContact() {
		System.out.println("deleteContact() on its way for implementation");
	}

	public static void searchDuplicate() {
		System.out.println("searchDuplicate() on its way for implementation");
	}

	public static void mergeDuplicate() {
		System.out.println("mergeDuplicate() on its way for implementation");
	}

}
